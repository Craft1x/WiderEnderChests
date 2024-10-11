package com.craftix.wider_ender_chests.shared.mixin;

import net.minecraft.world.inventory.PlayerEnderChestContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PlayerEnderChestContainer.class)
public abstract class PlayerEnderChestContainerMix {

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 27))
    private static int modifyConst(int value) {
        return 72;
    }
}