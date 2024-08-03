package com.craftix.wider_ender_chests.shared;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.monster.piglin.PiglinAi;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.PlayerEnderChestContainer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EnderChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class CustomEnderChestBlock extends EnderChestBlock {

    public ChestType type;
    public Supplier<MenuType<CustomChestMenu>> menu;

    public CustomEnderChestBlock(Properties properties, ChestType type, Supplier<MenuType<CustomChestMenu>> menu) {
        super(properties);
        this.type = type;
        this.menu = menu;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {

        PlayerEnderChestContainer playerEnderChestContainer = player.getEnderChestInventory();
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (playerEnderChestContainer != null && blockEntity instanceof EnderChestBlockEntity) {
            BlockPos blockPos2 = blockPos.above();
            if (level.getBlockState(blockPos2).isRedstoneConductor(level, blockPos2)) {
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else if (level.isClientSide) {
                return InteractionResult.SUCCESS;
            } else {
                EnderChestBlockEntity enderChestBlockEntity = (EnderChestBlockEntity) blockEntity;
                playerEnderChestContainer.setActiveChest(enderChestBlockEntity);

                player.openMenu(new SimpleMenuProvider((i, inventory, playerx) -> new CustomChestMenu(type, i, inventory, playerEnderChestContainer, (3 + type.getExtraSlots()), () -> menu.get()), Component.translatable("container.enderchest." + type.name().toLowerCase())));
                player.awardStat(Stats.OPEN_ENDERCHEST);
                PiglinAi.angerNearbyPiglins(player, true);
                return InteractionResult.CONSUME;
            }
        } else {
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? createTickerHelper(blockEntityType, BlockEntityType.ENDER_CHEST, EnderChestBlockEntity::lidAnimateTick) : null;
    }
}
