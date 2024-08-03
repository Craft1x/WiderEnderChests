package com.craftix.wider_ender_chests.shared.mixin;

import com.craftix.wider_ender_chests.shared.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = BlockEntityType.Builder.class)
public abstract class BlockEntityTypeMix<T extends BlockEntity> {

    @ModifyVariable(method = "of", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static Block[] modifyParam(Block[] blocks) {
        if (blocks.length > 0 && blocks[0] == Blocks.ENDER_CHEST) {
            return ArrayUtils.addAll(blocks,
                    ModBlocks.IRON_CHEST,
                    ModBlocks.GOLD_CHEST,
                    ModBlocks.COPPER_CHEST,
                    ModBlocks.DIAMOND_CHEST,
                    ModBlocks.EMERALD_CHEST,
                    ModBlocks.NETHERITE_CHEST,
                    ModBlocks.LAPIS_CHEST,
                    ModBlocks.REDSTONE_CHEST
            );
        }
        return blocks;
    }
}