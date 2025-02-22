package com.loaders.items;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WitheringSword extends SwordItem {
    public WitheringSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld server) {
            for (int i = 0; i <= 3; i++) {
                AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(server, user.getX(), user.getY(), user.getZ());
                areaEffectCloudEntity.setParticleType(ParticleTypes.CRIT);
                areaEffectCloudEntity.setRadius(2.0F);
                areaEffectCloudEntity.setWaitTime(0);
                areaEffectCloudEntity.setDuration(60);
                areaEffectCloudEntity.setRadiusGrowth(0.03f);
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1));

                double theta = Math.toRadians(-user.getYaw());
                double offsetX = Math.sin(theta) * (i * 3 + 4);
                double offsetZ = Math.cos(theta) * (i * 3 + 4);

                double X = user.getX() + offsetX;
                double Z = user.getZ() + offsetZ;
                areaEffectCloudEntity.setPos(X, user.getY() + 0.5f, Z);

                server.spawnEntity(areaEffectCloudEntity);
            }
        }
        return super.use(world, user, hand);
    }
}
