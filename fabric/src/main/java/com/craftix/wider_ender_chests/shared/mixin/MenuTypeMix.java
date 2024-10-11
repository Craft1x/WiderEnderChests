package com.craftix.wider_ender_chests.shared.mixin;

import com.craftix.wider_ender_chests.shared.ChestMenus;
import com.craftix.wider_ender_chests.shared.ChestType;
import com.craftix.wider_ender_chests.shared.CustomChestMenu;
import net.minecraft.world.flag.FeatureElement;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.craftix.wider_ender_chests.shared.Vars.MOD_ID;

@Mixin(value = MenuType.class)
public abstract class MenuTypeMix<T extends AbstractContainerMenu> implements FeatureElement {

    @Shadow
    private static <T extends AbstractContainerMenu> MenuType<T> register(String p_39989_, MenuType.MenuSupplier<T> p_39990_) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void injectedTail(CallbackInfo ci) {
        ChestMenus.IRON = register(MOD_ID + ":iron_chest", (id, inventory) -> new CustomChestMenu(ChestType.IRON, id, inventory, () -> ChestMenus.IRON));
        ChestMenus.COPPER = register(MOD_ID + ":copper_chest", (id, inventory) -> new CustomChestMenu(ChestType.COPPER, id, inventory, () -> ChestMenus.COPPER));
        ChestMenus.GOLD = register(MOD_ID + ":gold_chest", (id, inventory) -> new CustomChestMenu(ChestType.GOLD, id, inventory, () -> ChestMenus.GOLD));
        ChestMenus.LAPIS = register(MOD_ID + ":lapis_chest", (id, inventory) -> new CustomChestMenu(ChestType.LAPIS, id, inventory, () -> ChestMenus.LAPIS));
        ChestMenus.REDSTONE = register(MOD_ID + ":redstone_chest", (id, inventory) -> new CustomChestMenu(ChestType.REDSTONE, id, inventory, () -> ChestMenus.REDSTONE));
        ChestMenus.DIAMOND = register(MOD_ID + ":diamond_chest", (id, inventory) -> new CustomChestMenu(ChestType.DIAMOND, id, inventory, () -> ChestMenus.DIAMOND));
        ChestMenus.EMERALD = register(MOD_ID + ":emerald_chest", (id, inventory) -> new CustomChestMenu(ChestType.EMERALD, id, inventory, () -> ChestMenus.EMERALD));
        ChestMenus.NETHERITE = register(MOD_ID + ":netherite_chest", (id, inventory) -> new CustomChestMenu(ChestType.NETHERITE, id, inventory, () -> ChestMenus.NETHERITE));
    }
}