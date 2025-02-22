package com.loaders.items;

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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.loaders.utils.ModUtils.getMobsInArea;

public class MistAmulet extends Item {
    public MistAmulet(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world instanceof ServerWorld server) {
            List<Entity> entities = getMobsInArea(user, server, 10);
            server.spawnParticles(ParticleTypes.END_ROD, user.getX(), user.getY(), user.getZ(), 2000, 1, 1, 1, 1);
            for (Entity entity : entities) {
                if (entity instanceof ProjectileEntity || entity instanceof Monster) {
                    Vec3d stepVector = getStepVector(user, entity);
                    entity.addVelocity(stepVector);
                }
            }
        }
        return super.use(world, user, hand);
    }

    private static @NotNull Vec3d getStepVector(PlayerEntity user, Entity entity) {
        Vec3d directionalVector =
                new Vec3d(
                        entity.getX() - user.getX(),
                        entity.getY() - user.getY(),
                        entity.getZ() - user.getZ());
        double distance = directionalVector.length();
        return new Vec3d(
                (directionalVector.x / distance) * 4,
                1.2,
                (directionalVector.z / distance) * 4);
    }
}