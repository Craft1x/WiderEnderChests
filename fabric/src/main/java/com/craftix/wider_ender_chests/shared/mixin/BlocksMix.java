package com.craftix.wider_ender_chests.shared.mixin;

import com.craftix.wider_ender_chests.shared.ChestMenus;
import com.craftix.wider_ender_chests.shared.ChestType;
import com.craftix.wider_ender_chests.shared.CustomEnderChestBlock;
import com.craftix.wider_ender_chests.shared.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.craftix.wider_ender_chests.shared.Vars.MOD_ID;

@Mixin(value = Blocks.class)
public abstract class BlocksMix {

    @Shadow
    private static Block register(String p_50796_, Block p_50797_) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/HeavyCoreBlock;<init>(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", shift = At.Shift.BY, by = 2))
    private static void injectedAfter(CallbackInfo ci) {
        ModBlocks.IRON_CHEST = register(
                MOD_ID + ":iron_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.TERRACOTTA_WHITE)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.IRON, () -> ChestMenus.IRON)
        );

        ModBlocks.COPPER_CHEST = register(
                MOD_ID + ":copper_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.COLOR_ORANGE)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.COPPER, () -> ChestMenus.COPPER)
        );

        ModBlocks.GOLD_CHEST = register(
                MOD_ID + ":gold_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.GOLD)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.GOLD, () -> ChestMenus.GOLD)
        );

        ModBlocks.LAPIS_CHEST = register(
                MOD_ID + ":lapis_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.LAPIS)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.LAPIS, () -> ChestMenus.LAPIS)
        );
        ModBlocks.REDSTONE_CHEST = register(
                MOD_ID + ":redstone_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.COLOR_RED)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.REDSTONE, () -> ChestMenus.REDSTONE)
        );
        ModBlocks.DIAMOND_CHEST = register(
                MOD_ID + ":diamond_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.DIAMOND)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.DIAMOND, () -> ChestMenus.DIAMOND)
        );
        ModBlocks.EMERALD_CHEST = register(
                MOD_ID + ":emerald_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.EMERALD)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.EMERALD, () -> ChestMenus.EMERALD)
        );
        ModBlocks.NETHERITE_CHEST = register(
                MOD_ID + ":netherite_ender_chest",
                new CustomEnderChestBlock(
                        BlockBehaviour.Properties.of()
                                .mapColor(MapColor.COLOR_BLACK)
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(22.5F, 600.0F)
                                .lightLevel(blockStatex -> 7),
                        ChestType.NETHERITE, () -> ChestMenus.NETHERITE)
        );
    }
}