package com.loaders.items.materials;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.Map;

import static com.loaders.SoulMorphing.MOD_ID;

public class SpiritiumArmorMaterial implements ArmorMaterial {
    private static final Map<ArmorItem.Type, Integer> BASE_DURABILITY = new EnumMap<>(Map.of(
            ArmorItem.Type.HELMET, 650,
            ArmorItem.Type.CHESTPLATE, 800,
            ArmorItem.Type.LEGGINGS, 750,
            ArmorItem.Type.BOOTS, 700
    ));

    private static final Map<ArmorItem.Type, Integer> PROTECTION_VALUES = new EnumMap<>(Map.of(
            ArmorItem.Type.HELMET, 4,      // Незерит - 3
            ArmorItem.Type.CHESTPLATE, 9, // Незерит - 8
            ArmorItem.Type.LEGGINGS, 8,    // Незерит - 6
            ArmorItem.Type.BOOTS, 4       // Незерит - 3
    ));

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY.getOrDefault(type, 0);
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return PROTECTION_VALUES.getOrDefault(type, 0);
    }

    @Override
    public int getEnchantability() {
        return 18; // Незерит - 15, трошки краще чарується
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Registries.ITEM.get(new Identifier(MOD_ID, "spiritium_ingot")));
    }

    @Override
    public String getName() {
        return "spiritium";
    }

    @Override
    public float getToughness() {
        return 5.0F; // Незерит - 3.0, краще захищає
    }

    @Override
    public float getKnockbackResistance() {
        return 0.2F; // Незерит - 0.1, менший відкид
    }
}
