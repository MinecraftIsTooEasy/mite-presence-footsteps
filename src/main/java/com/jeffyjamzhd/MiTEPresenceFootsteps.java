package com.jeffyjamzhd;

import net.fabricmc.api.ModInitializer;

import net.minecraft.PFHaddon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MiTEPresenceFootsteps implements ModInitializer {
    public static final String MOD_ID = "presence-footsteps";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final PFHaddon ADDON = new PFHaddon();

    @Override
    public void onInitialize() {
    }
}
