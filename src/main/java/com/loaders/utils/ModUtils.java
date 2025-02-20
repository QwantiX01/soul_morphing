package com.loaders.utils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModUtils {
    public static @NotNull List<Entity> getMobsInArea(PlayerEntity user, World world, float area) {
        return world.getOtherEntities(user, new Box(
                user.getX() - area,
                user.getY() - area,
                user.getZ() - area,
                user.getX() + area,
                user.getY() + area,
                user.getZ() + area
        ));
    }
}
