package com.loaders;

import com.loaders.regestries.ItemGroups;
import com.loaders.regestries.Items;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoulMorphing implements ModInitializer {
    public static final String MOD_ID = "soul_morphing";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Started loading 'Soul Morphing'");
        Items.initialize();
        ItemGroups.initialize();
    }

}