package com.loaders.items.advanced;

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
                AreaEffectCloudEntity flame = new AreaEffectCloudEntity(server, user.getX(), user.getY(), user.getZ());
                flame.setOwner(user);
                flame.setRadius(2.0F);
                flame.setDuration(30);
//                flame.addEffect(new StatusEffectInstance(StatusEffects.GLOWING, 2000));
                flame.addEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 200,3));
                flame.setWaitTime(0);
                flame.setParticleType(ParticleTypes.CRIT);
                
                double theta = Math.toRadians(-user.getYaw());
                double offsetX = Math.sin(theta) * (i * 3 + 4);
                double offsetZ = Math.cos(theta) * (i * 3 + 4);

                double X = user.getX() + offsetX;
                double Z = user.getZ() + offsetZ;
                flame.setPos(X, user.getY(), Z);

                server.spawnEntity(flame);
            }
        }
        return super.use(world, user, hand);
    }
}
