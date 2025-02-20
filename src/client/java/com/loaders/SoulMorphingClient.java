package com.loaders;

import com.loaders.regestries.Projectiles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class SoulMorphingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Projectiles.LIGHT_SINNERS_WAVE, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(Projectiles.HEAVY_SINNERS_WAVE, FlyingItemEntityRenderer::new);
    }
}