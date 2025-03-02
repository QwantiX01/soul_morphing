package com.loaders;

import com.loaders.regestries.BlockEntities;
import com.loaders.regestries.Blocks;
import com.loaders.regestries.ItemGroups;
import com.loaders.regestries.Items;
import com.loaders.utils.RunesCustomDrop;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
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
        RunesCustomDrop.initiliaze();
        Blocks.initialize();
        BlockEntities.initialize();
    }

}