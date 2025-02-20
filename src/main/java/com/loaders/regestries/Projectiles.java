package com.loaders.regestries;

import com.loaders.entities.HeavySinnersWaveEntity;
import com.loaders.entities.LightSinnersWaveEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class Projectiles {
    public static final EntityType<LightSinnersWaveEntity> LIGHT_SINNERS_WAVE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "light_sinners_wave"),
            FabricEntityTypeBuilder.<LightSinnersWaveEntity>create(SpawnGroup.MISC, LightSinnersWaveEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4)
                    .trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<HeavySinnersWaveEntity> HEAVY_SINNERS_WAVE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "heavy_sinners_wave"),
            FabricEntityTypeBuilder.<HeavySinnersWaveEntity>create(SpawnGroup.MISC, HeavySinnersWaveEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 2f))
                    .trackRangeBlocks(4)
                    .trackedUpdateRate(10)
                    .build()
    );

    public static void register() {
    }
}
