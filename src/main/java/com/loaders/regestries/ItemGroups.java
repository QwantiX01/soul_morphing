package com.loaders.regestries;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static com.loaders.SoulMorphing.MOD_ID;

public class ItemGroups {

    public static final RegistryKey<ItemGroup> MATERIALS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "soul_morphing_materials"));
    public static final ItemGroup MATERIALS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.SINISTER_CORE))
            .displayName(Text.translatable("itemGroup.soul_morphing.soul_morphing_materials"))
            .build();

    public static final RegistryKey<ItemGroup> TOOLS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "soul_morphing_tools"));
    public static final ItemGroup TOOLS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Items.SCORCHING_WAVE))
            .displayName(Text.translatable("itemGroup.soul_morphing.soul_morphing_tools"))
            .build();


    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, MATERIALS_ITEM_GROUP_KEY, MATERIALS);
        Registry.register(Registries.ITEM_GROUP, TOOLS_ITEM_GROUP_KEY, TOOLS);

        ItemGroupEvents.modifyEntriesEvent(TOOLS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(Items.MIST_AMULET);
            itemGroup.add(Items.SCORCHING_WAVE);
            itemGroup.add(Items.SINNERS_STAFF);
            itemGroup.add(Items.INFERNAL_KNIFE);
            itemGroup.add(Items.CAGED_SOUL);
            itemGroup.add(Items.SPIRITIUM_AXE);
            itemGroup.add(Items.SPIRITIUM_PICKAXE);
            itemGroup.add(Items.SPIRITIUM_SHOVEL);
            itemGroup.add(Items.SPIRITIUM_HOE);
            itemGroup.add(Items.SPIRITIUM_MULTITOOL);
            itemGroup.add(Items.SPIRITIUM_HELMET);
            itemGroup.add(Items.SPIRITIUM_CHESTPLATE);
            itemGroup.add(Items.SPIRITIUM_LEGGINGS);
            itemGroup.add(Items.SPIRITIUM_BOOTS);
            itemGroup.add(Items.SOUL_MORPHIST);
            itemGroup.add(Items.WITHERING_SWORD);
        });

        ItemGroupEvents.modifyEntriesEvent(MATERIALS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(Items.SPIRITIUM_INGOT);
            itemGroup.add(Items.RAW_SPIRITIUM);
            itemGroup.add(Items.SPIRITIUM_NUGGET);
            itemGroup.add(Items.ASH_INGOT);
            itemGroup.add(Items.RAW_ASH);
            itemGroup.add(Items.ASH_NUGGET);
            itemGroup.add(Items.DUSK_SOUL);
            itemGroup.add(Items.SINISTER_CORE);
            itemGroup.add(Items.ENDER_SHELL);
            itemGroup.add(Items.IGNITED_SOUL);
            itemGroup.add(Items.TERROR_STAR);
            itemGroup.add(Items.CURVED_BONE);
            itemGroup.add(Items.VICIOUS_SKULL);
            itemGroup.add(Items.EBOBA);
        });
    }
}
