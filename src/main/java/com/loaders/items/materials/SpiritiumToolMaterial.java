package com.loaders.items.materials;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class SpiritiumToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 3072; // Незерит 2031
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.5f; // Незерит - 9.0
    }

    @Override
    public float getAttackDamage() {
        return 5.5f; // Незерит - 4.0
    }

    @Override
    public int getMiningLevel() {
        return 5; // Незерит - 4
    }

    @Override
    public int getEnchantability() {
        return 20; // Незерит - 15
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Registries.ITEM.get(new Identifier(MOD_ID, "sinister_core")));
    }
}
