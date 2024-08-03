package com.craftix.wider_ender_chests.shared.mixin;

import com.craftix.wider_ender_chests.shared.ModBlocks;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(targets = "net/minecraft/world/level/block/entity/EnderChestBlockEntity$1")
public abstract class EnderChestBlockEntityMix {

    @WrapOperation(method = "openerCountChanged", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;blockEvent(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;II)V"))
    private void wrapOperation(Level level, BlockPos blockPos, Block block, int i, int j, Operation<Void> original) {

        original.call(level, blockPos, block, i, j);
        original.call(level, blockPos, ModBlocks.IRON_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.COPPER_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.GOLD_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.DIAMOND_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.EMERALD_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.NETHERITE_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.LAPIS_CHEST, i, j);
        original.call(level, blockPos, ModBlocks.REDSTONE_CHEST, i, j);
    }
}