package com.darkorg.betterpunching;

import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BetterPunching.MODID, name = BetterPunching.NAME, version = BetterPunching.VERSION)

public final class BetterPunching {

    public static final String MODID = "betterpunching";
    public static final String NAME = "Better Punching";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Logger logger = event.getModLog();
    }
    @EventHandler
    public void init(FMLInitializationEvent event) {}


}