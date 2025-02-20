package com.loaders.items.advanced;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

import static com.loaders.utils.ModUtils.getMobsInArea;

public class ScorchingWave extends Item {
    public ScorchingWave(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld server) {
            List<Entity> entities = getMobsInArea(user, server, 10);
            server.spawnParticles(ParticleTypes.FLAME, user.getX(), user.getY(), user.getZ(), 2000, 1, 1, 1, 1);
            for (Entity entity : entities) {
                if (entity instanceof ProjectileEntity || entity instanceof Monster) {
                    entity.setOnFireFor(10);
                    entity.damage(server.getDamageSources().magic(), 7);
                }
            }
        }
        return super.use(world, user, hand);
    }
}