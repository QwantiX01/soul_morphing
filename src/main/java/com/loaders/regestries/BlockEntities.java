package com.loaders.regestries;

import com.loaders.blocks.CatalystInfusionBlock;
import com.loaders.blocks.entity.CatalystInfusionBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class BlockEntities {
    public static final BlockEntityType<CatalystInfusionBlockEntity> CATALYST_INFUSION_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE,
                    new Identifier(MOD_ID, "catalyst_infuser_be"),
                    FabricBlockEntityTypeBuilder.create(CatalystInfusionBlockEntity::new,
                            Blocks.CATALYST_INFUSION_BLOCK).build());

    public static void initialize() {

    }
}

