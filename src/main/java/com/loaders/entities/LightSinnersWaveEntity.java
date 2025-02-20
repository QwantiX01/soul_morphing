package com.loaders.entities;

import com.loaders.regestries.Projectiles;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightSinnersWaveEntity extends ThrownItemEntity {
    public LightSinnersWaveEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.AIR;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }


    public LightSinnersWaveEntity(World world, LivingEntity owner) {
        super(Projectiles.LIGHT_SINNERS_WAVE, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age > 100) this.discard();
        World level = this.getWorld();
        if (level instanceof ServerWorld serverLevel) {
            serverLevel.spawnParticles(
                    ParticleTypes.DRAGON_BREATH,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    10,
                    0.1,
                    0.1,
                    0.1,
                    0.02);
        }
        if (this.isOnGround()) this.discard();
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.getWorld().isClient) {
            World level = this.getWorld();
            if (level instanceof ServerWorld serverLevel) {
                entityHitResult.getEntity().damage(serverLevel.getDamageSources().mobProjectile(this, entityHitResult.getEntity().getControllingPassenger()), 2);
                serverLevel.spawnParticles(
                        ParticleTypes.DRAGON_BREATH,
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        50,
                        0.1,
                        0.1,
                        0.1,
                        1);
            }
            this.discard();
        }
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        this.setVelocity(new Vec3d(packet.getVelocityX(), packet.getVelocityY(), packet.getVelocityZ()));
    }
}
