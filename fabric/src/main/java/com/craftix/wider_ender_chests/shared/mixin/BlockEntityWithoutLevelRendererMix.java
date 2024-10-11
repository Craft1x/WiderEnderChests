package com.craftix.wider_ender_chests.shared.mixin;

import com.craftix.wider_ender_chests.shared.CustomEnderChestBlock;
import com.craftix.wider_ender_chests.shared.ModBlocks;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.EnderChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = BlockEntityWithoutLevelRenderer.class)
public abstract class BlockEntityWithoutLevelRendererMix {

    @WrapOperation(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderDispatcher;renderItem(Lnet/minecraft/world/level/block/entity/BlockEntity;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)Z"))
    private boolean wrapOperation(BlockEntityRenderDispatcher instance, BlockEntity blockEntity, PoseStack poseStack, MultiBufferSource mu, int i, int i2, Operation<Boolean> original, ItemStack stack, ItemDisplayContext p_270899_, PoseStack p_108832_, MultiBufferSource p_108833_, int p_108834_, int p_108835_) {
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            if(block==ModBlocks.COPPER_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.COPPER_CHEST.defaultBlockState());
            else if(block==ModBlocks.DIAMOND_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.DIAMOND_CHEST.defaultBlockState());
            else if(block==ModBlocks.EMERALD_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.EMERALD_CHEST.defaultBlockState());
            else if(block==ModBlocks.GOLD_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.GOLD_CHEST.defaultBlockState());
            else if(block==ModBlocks.IRON_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.IRON_CHEST.defaultBlockState());
            else if(block==ModBlocks.LAPIS_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.LAPIS_CHEST.defaultBlockState());
            else if(block==ModBlocks.NETHERITE_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.NETHERITE_CHEST.defaultBlockState());
            else if(block==ModBlocks.REDSTONE_CHEST)
                blockEntity = new EnderChestBlockEntity(BlockPos.ZERO, ModBlocks.REDSTONE_CHEST.defaultBlockState());
        }
        return original.call(instance, blockEntity, poseStack, mu, i, i2);
    }

    @ModifyExpressionValue(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", ordinal = 2))
    private boolean modifyExpression(boolean original, ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j) {
        Item item = itemStack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
            BlockState blockstate = block.defaultBlockState();
            if (blockstate.getBlock() instanceof CustomEnderChestBlock) {
                return true;
            }
        }

        return original;
    }
}