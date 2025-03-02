package com.loaders.regestries;

import com.loaders.blocks.CatalystInfusionBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class Blocks {
    public static final Block CATALYST_INFUSION_BLOCK = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "catalyst_infusion_block"), new CatalystInfusionBlock(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.AMETHYST_BLOCK).nonOpaque()));

    public static void initialize() {

    }
}

