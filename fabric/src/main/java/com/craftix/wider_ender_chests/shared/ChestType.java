package com.craftix.wider_ender_chests.shared;

public enum ChestType {
    IRON(1),
    COPPER(1),
    GOLD(2),
    LAPIS(2),
    REDSTONE(2),
    DIAMOND(3),
    EMERALD(4),
    NETHERITE(5);

    private final int extraSlots;

    ChestType(int extraSlots) {
        this.extraSlots = extraSlots;
    }

    public int getExtraSlots() {
        return extraSlots;
    }
}
