package com.loaders.screens;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class Screens {
    public static final ScreenHandlerType<CatalystInfusionScreenHandler> CATALYST_INFUSION_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(MOD_ID, "catalyst_infusion_block"),
            new ScreenHandlerType<>(CatalystInfusionScreenHandler::new, FeatureSet.empty()));

    public static void initialize() {

    }
}

