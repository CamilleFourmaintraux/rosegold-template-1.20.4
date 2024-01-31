package net.grotacam.rosegold.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.grotacam.rosegold.Rosegold;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {


    public static final Item ROSEGOLD_INGOT = registerItem("rosegold_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSEGOLD_NUGGET = registerItem("rosegold_nugget", new Item(new FabricItemSettings()));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        if(Rosegold.addToVanillaTab){
            entries.add(ROSEGOLD_INGOT);
            entries.add(ROSEGOLD_NUGGET);
        }
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Rosegold.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Rosegold.LOGGER.info("Registering Mod Items for + "+Rosegold.MOD_ID+".");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
