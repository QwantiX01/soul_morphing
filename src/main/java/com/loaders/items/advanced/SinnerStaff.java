package com.loaders.items.advanced;

import com.loaders.entities.HeavySinnersWaveEntity;
import com.loaders.entities.LightSinnersWaveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SinnerStaff extends Item {
    public SinnerStaff(Settings settings) {
        super(settings);
    }

    private static int mode = 0;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient() && world instanceof ServerWorld server) {
            if (user.isSneaking()) {
                changeMode();
//                user.ddisplayClientMessage(Component.literal("Mode: " + mode), true);
                return super.use(world, user, hand);
            }

            switch (mode) {
                case 0 -> {
                    LightSinnersWaveEntity projectile = new LightSinnersWaveEntity(server, user);
                    projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 5.0F, 0.5F);
                    server.spawnEntity(projectile);
                    return super.use(world, user, hand);

                }
                case 1 -> {
                    HeavySinnersWaveEntity projectile = new HeavySinnersWaveEntity(server, user);
                    projectile.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.0F, 0.5F);
                    server.spawnEntity(projectile);
                    user.getItemCooldownManager().set(this, 30);
                    return super.use(world, user, hand);
                }
            }
        }
        return super.use(world, user, hand);
    }

    private void changeMode() {
        if (mode == 0) {
            mode = 1;
        } else {
            mode = 0;
        }
    }
}
