package com.loaders.utils;

import com.loaders.regestries.Items;
import net.fabricmc.fabric.api.entity.event.v1.ServerEntityCombatEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.random.Random;

import java.util.HashMap;
import java.util.Map;

public class RunesCustomDrop {

    private static Map<String, String> mobRunesMap = new HashMap<>() {{
// SHADOW_RUNE
        put("entity.minecraft.spider", "SHADOW_RUNE");
        put("entity.minecraft.cave_spider", "SHADOW_RUNE");
        put("entity.minecraft.zombie", "SHADOW_RUNE");
        put("entity.minecraft.zombie_villager", "SHADOW_RUNE");
        put("entity.minecraft.husk", "SHADOW_RUNE");
        put("entity.minecraft.skeleton", "SHADOW_RUNE");
        put("entity.minecraft.stray", "SHADOW_RUNE");
        put("entity.minecraft.wither_skeleton", "SHADOW_RUNE");
        put("entity.minecraft.creeper", "SHADOW_RUNE");
        put("entity.minecraft.witch", "SHADOW_RUNE");
        put("entity.minecraft.enderman", "SHADOW_RUNE");
        put("entity.minecraft.phantom", "SHADOW_RUNE");
        put("entity.minecraft.silverfish", "SHADOW_RUNE");
        put("entity.minecraft.endermite", "SHADOW_RUNE");
        put("entity.minecraft.drowned", "SHADOW_RUNE");
// ELEMENTAL_RUNE
        put("entity.minecraft.blaze", "ELEMENTAL_RUNE");
        put("entity.minecraft.magma_cube", "ELEMENTAL_RUNE");
        put("entity.minecraft.ghast", "ELEMENTAL_RUNE");
        put("entity.minecraft.slime", "ELEMENTAL_RUNE");
        put("entity.minecraft.strider", "ELEMENTAL_RUNE");
        put("entity.minecraft.iron_golem", "ELEMENTAL_RUNE");
        put("entity.minecraft.snow_golem", "ELEMENTAL_RUNE");
// CELESTIAL_RUNE
        put("entity.minecraft.ender_dragon", "CELESTIAL_RUNE");
        put("entity.minecraft.allay", "CELESTIAL_RUNE");
        put("entity.minecraft.shulker", "CELESTIAL_RUNE");
        put("entity.minecraft.vex", "CELESTIAL_RUNE");

// ANCIENT_RUNE
        put("entity.minecraft.pillager", "ANCIENT_RUNE");
        put("entity.minecraft.evoker", "ANCIENT_RUNE");
        put("entity.minecraft.vindicator", "ANCIENT_RUNE");
        put("entity.minecraft.illusioner", "ANCIENT_RUNE");
        put("entity.minecraft.guardian", "ANCIENT_RUNE");
        put("entity.minecraft.elder_guardian", "ANCIENT_RUNE");
        put("entity.minecraft.ravager", "ANCIENT_RUNE");
        put("entity.minecraft.wither", "ANCIENT_RUNE");
        put("entity.minecraft.warden", "ANCIENT_RUNE");
// BEAST_RUNE
        put("entity.minecraft.wolf", "BEAST_RUNE");
        put("entity.minecraft.fox", "BEAST_RUNE");
        put("entity.minecraft.piglin", "BEAST_RUNE");
        put("entity.minecraft.piglin_brute", "BEAST_RUNE");
        put("entity.minecraft.hoglin", "BEAST_RUNE");
        put("entity.minecraft.zoglin", "BEAST_RUNE");
    }};

    public static void initiliaze() {
        ServerEntityCombatEvents.AFTER_KILLED_OTHER_ENTITY.register((serverWorld, killerEntity, killedEntity) -> {
            Random rand = serverWorld.getRandom();
            if (killerEntity instanceof PlayerEntity player) {
                ItemStack killingTool = player.getMainHandStack();
                if (killingTool.itemMatches(Registries.ITEM.getEntry(Items.SOUL_MORPHIST))) {
                    Item runeToDrop = getRune(killedEntity.getType().toString());
                    int lootingLevel = EnchantmentHelper.getLevel(Enchantments.LOOTING, killingTool);
                    switch (lootingLevel) {
                        case 0: {
                            if (rand.nextBetween(0, 101) > 15) {
                                break;
                            } else {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 1));
                            }
                        }
                        case 1: {
                            int chance = rand.nextBetween(0, 101);
                            if (chance < 20) {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 2));
                            } else if (chance < 30) {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 1));
                            } else {
                                break;
                            }
                        }
                        case 2: {
                            int chance = rand.nextBetween(0, 101);
                            if (chance < 60) {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 1));
                            } else if (chance < 80) {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 2));
                            } else {
                                break;
                            }
                        }
                        case 3: {
                            int chance = rand.nextBetween(0, 101);
                            if (chance < 30) {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 3));
                            } else if (chance < 80) {
                                killedEntity.dropStack(new ItemStack(runeToDrop, 2));
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        });
    }

    public static Item getRune(String entityName) {
        return switch (mobRunesMap.get(entityName.toLowerCase())) {
            case "SHADOW_RUNE" -> Items.SHADOW_RUNE;
            case "ANCIENT_RUNE" -> Items.ANCIENT_RUNE;
            case "CELESTIAL_RUNE" -> Items.CELESTIAL_RUNE;
            case "ELEMENTAL_RUNE" -> Items.ELEMENTAL_RUNE;
            case "BEAST_RUNE" -> Items.BEAST_RUNE;
            default -> net.minecraft.item.Items.AIR;
        };
    }

}
