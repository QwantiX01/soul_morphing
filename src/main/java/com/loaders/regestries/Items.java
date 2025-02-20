package com.loaders.regestries;

import com.loaders.items.advanced.MistAmulet;
import com.loaders.items.advanced.ScorchingWave;
import com.loaders.items.advanced.SinnerStaff;
import com.loaders.items.advanced.WitheringSword;
import com.loaders.items.materials.SpiritiumArmorMaterial;
import com.loaders.items.materials.SpiritiumToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class Items {
    private static final ToolMaterial SpiritiumMaterial = new SpiritiumToolMaterial();
    private static ArmorMaterial SpiritiumArmorMaterial = new SpiritiumArmorMaterial();

    public static final Item SPIRITIUM_INGOT = register("spiritium_ingot");
    public static final Item RAW_SPIRITIUM = register("raw_spiritium");
    public static final Item SPIRITIUM_NUGGET = register("spiritium_nugget");
    public static final Item ASH_INGOT = register("ash_ingot");
    public static final Item RAW_ASH = register("raw_ash");
    public static final Item ASH_NUGGET = register("ash_nugget");
    public static final Item DUSK_SOUL = register("dusk_soul");
    public static final Item SINISTER_CORE = register("sinister_core");
    public static final Item ENDER_SHELL = register("ender_shell");
    public static final Item IGNITED_SOUL = register("ignited_soul");
    public static final Item TERROR_STAR = register("terror_star");
    public static final Item EBOBA = register("eboba");
    public static final Item CAGED_SOUL = register("caged_soul");
    public static final Item CURVED_BONE = register("cursed_bone");
    public static final Item DUNGEON_SOUL_LANTERN = register("dungeon_soul_lantern");
    public static final Item SOUL_MORPHIST = register("soul_morphist");
    public static final Item WITHERING_SWORD = register("withering_sword", new WitheringSword(SpiritiumMaterial, 5, -2.4f, new FabricItemSettings()));
    public static final Item INFERNAL_KNIFE = register("infernal_knife", new SwordItem(ToolMaterials.DIAMOND, 3, -1.2f, new FabricItemSettings()));
    public static final Item VICIOUS_SKULL = register("vicious_skull");

    public static final Item SPIRITIUM_AXE = register("spiritium_axe", new AxeItem(SpiritiumMaterial, 7, -3.1f, new FabricItemSettings()));
    public static final Item SPIRITIUM_PICKAXE = register("spiritium_pickaxe", new PickaxeItem(SpiritiumMaterial, 4, -2.8f, new FabricItemSettings()));
    public static final Item SPIRITIUM_SHOVEL = register("spiritium_shovel", new ShovelItem(SpiritiumMaterial, 3.5f, -3.0f, new FabricItemSettings()));
    public static final Item SPIRITIUM_HOE = register("spiritium_hoe", new HoeItem(SpiritiumMaterial, -3, 0.0f, new FabricItemSettings()));
    public static final Item SPIRITIUM_MULTITOOL = register("spiritium_multitool", new SwordItem(SpiritiumMaterial, 6, -2.4f, new FabricItemSettings()));

    public static final ArmorItem SPIRITIUM_HELMET = register("spiritium_helmet", new ArmorItem(SpiritiumArmorMaterial, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final ArmorItem SPIRITIUM_CHESTPLATE = register("spiritium_chestplate", new ArmorItem(SpiritiumArmorMaterial, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final ArmorItem SPIRITIUM_LEGGINGS = register("spiritium_leggings", new ArmorItem(SpiritiumArmorMaterial, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final ArmorItem SPIRITIUM_BOOTS = register("spiritium_boots", new ArmorItem(SpiritiumArmorMaterial, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item MIST_AMULET = register("mist_amulet", new MistAmulet(new FabricItemSettings()));
    public static final Item SCORCHING_WAVE = register("scorching_wave", new ScorchingWave(new FabricItemSettings()));
    public static final Item SINNERS_STAFF = register("sinners_staff", new SinnerStaff(new FabricItemSettings()));

    private static <T extends Item> T register(String path, T item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, path), item);
    }

    private static Item register(String path) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID, path), new Item(new FabricItemSettings()));
    }

    public static void initialize() {
    }
}