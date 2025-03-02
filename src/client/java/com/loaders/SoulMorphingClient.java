package com.loaders;

import com.loaders.regestries.Projectiles;
import com.loaders.screens.Screens;
import com.loaders.screens.CatalystInfusionScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class SoulMorphingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Projectiles.LIGHT_SINNERS_WAVE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Projectiles.HEAVY_SINNERS_WAVE, FlyingItemEntityRenderer::new);

        HandledScreens.register(Screens.CATALYST_INFUSION_SCREEN_HANDLER, CatalystInfusionScreen::new);
    }
}