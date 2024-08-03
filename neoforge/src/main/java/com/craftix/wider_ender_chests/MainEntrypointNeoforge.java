package com.craftix.wider_ender_chests;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MainEntrypointNeoforge.MODID)
public class MainEntrypointNeoforge {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "wider_ender_chests";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "wider_ender_chests" namespace

    public MainEntrypointNeoforge(IEventBus modEventBus, ModContainer modContainer) {
       // NeoForge.EVENT_BUS.register(this);
    }
}
