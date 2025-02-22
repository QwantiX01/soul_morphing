package com.loaders;

import com.loaders.regestries.ItemGroups;
import com.loaders.regestries.Items;
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
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((serverWorld, killerEntity, killedEntity) -> {
            if (killerEntity instanceof PlayerEntity player) {
                if (player.getMainHandStack().itemMatches(Registries.ITEM.getEntry(Items.SOUL_MORPHIST))) {
                    player.sendMessage(Text.of(String.format("%s killed %s with %s", player.getEntityName(), killedEntity.getDisplayName().getString(), player.getMainHandStack().getName().getString())), false);
                    serverWorld.spawnEntity(new ItemEntity(serverWorld, killedEntity.getX(), killedEntity.getY(), killedEntity.getZ(), Items.VICIOUS_SKULL.getDefaultStack()));
                }
            }
        });
    }

}