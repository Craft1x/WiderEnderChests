package com.craftix.wider_ender_chests.shared;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class CustomChestMenu extends AbstractContainerMenu {

    private final Container container;
    private final int containerRows;

    final ChestType chestType;

    public CustomChestMenu(ChestType type, int i, Inventory inventory, Supplier<MenuType<CustomChestMenu>> menuType) {
        this(type, i, inventory, new SimpleContainer(9 * (type.getExtraSlots() + 3)), type.getExtraSlots() + 3, menuType);
    }

    public CustomChestMenu(ChestType type, int containerId, Inventory inventory, Container container, int rows, Supplier<MenuType<CustomChestMenu>> menuType) {
        super(menuType.get(), containerId);

        checkContainerSize(container, rows * 9);
        this.container = container;
        this.containerRows = rows;
       int maxSlots =( 8 )*9;
        this.chestType = type;
        container.startOpen(inventory.player);
        int k = (this.containerRows - 4) * 18;

        for (int l = 0; l < this.containerRows; ++l) {
            for (int m = 0; m < 9; ++m) {
                this.addSlot(new Slot(container, m + l * 9, 8 + m * 18, 18 + l * 18-2));
            }
        }

        for (int l = 0; l < 3; ++l) {
            for (int m = 0; m < 9; ++m) {
                this.addSlot(new Slot(inventory, m + l * 9 + 9, 8 + m * 18, 103 + l * 18 + maxSlots-1));
            }
        }

        for (int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inventory, l, 8 + l * 18, 161 + maxSlots-1));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(i);
        if (slot != null && slot.hasItem()) {
            ItemStack itemStack2 = slot.getItem();
            itemStack = itemStack2.copy();
            if (i < this.containerRows * 9) {
                if (!this.moveItemStackTo(itemStack2, this.containerRows * 9, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemStack2, 0, this.containerRows * 9, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }
}
