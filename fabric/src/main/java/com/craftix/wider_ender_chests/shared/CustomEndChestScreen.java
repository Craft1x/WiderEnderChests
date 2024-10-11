package com.craftix.wider_ender_chests.shared;

import net.minecraft.SharedConstants;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import static com.craftix.wider_ender_chests.shared.Vars.MOD_ID;

public class CustomEndChestScreen extends AbstractContainerScreen<CustomChestMenu> implements MenuAccess<CustomChestMenu> {
    private static ResourceLocation CONTAINER_BACKGROUND;
    private final int containerRows;
    private final ChestType chestType;

    public CustomEndChestScreen(CustomChestMenu menu, Inventory p_98410_, Component p_98411_) {
        super(menu, p_98410_, p_98411_);
        int i = 222;
        int j = 114;
        this.containerRows = menu.getRowCount();
        this.imageHeight = 256;
        this.inventoryLabelY = this.imageHeight - 94;
        this.chestType = menu.chestType;
        CONTAINER_BACKGROUND = new ResourceLocation(MOD_ID, "textures/gui/container/" + chestType.name().toLowerCase() + ".png");
    }

    public void render(GuiGraphics p_282060_, int p_282533_, int p_281661_, float p_281873_) {
        // this.renderBackground(p_282060_);
        if ((SharedConstants.getCurrentVersion()).getProtocolVersion() < 765)
            p_282060_.fillGradient(0, 0, this.width, this.height, -1072689136, -804253680);

        super.render(p_282060_, p_282533_, p_281661_, p_281873_);
        this.renderTooltip(p_282060_, p_282533_, p_281661_);
    }

    protected void renderBg(GuiGraphics p_283694_, float p_282334_, int p_282603_, int p_282158_) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_283694_.blit(CONTAINER_BACKGROUND, i, j, 0, 0, this.imageWidth, imageHeight);
    }
}