package net.grotacam.rosegold.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.grotacam.rosegold.Rosegold;
import net.grotacam.rosegold.item.custom.ModArmorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ROSEGOLD_INGOT = registerItem("rosegold_ingot", new Item(new FabricItemSettings()));
    public static final Item ROSEGOLD_NUGGET = registerItem("rosegold_nugget", new Item(new FabricItemSettings()));


    public static final Item ROSEGOLD_APPLE = registerItem("rosegold_apple", new Item(new FabricItemSettings()
            .food(ModFoodComponent.ROSEGOLD_APPLE)));
    public static final Item ROSEGOLD_CARROT = registerItem("rosegold_carrot", new Item(new FabricItemSettings()
            .food(ModFoodComponent.ROSEGOLD_CARROT)));


    //TOOLS
    public static final Item ROSEGOLD_SWORD = registerItem("rosegold_sword",
            new SwordItem(ModToolMaterial.ROSEGOLD, 3, -2.4f, new FabricItemSettings()));
   public static final Item ROSEGOLD_PICKAXE = registerItem("rosegold_pickaxe",
            new PickaxeItem(ModToolMaterial.ROSEGOLD, 2, -2.8f, new FabricItemSettings()));
    public static final Item ROSEGOLD_AXE = registerItem("rosegold_axe",
            new AxeItem(ModToolMaterial.ROSEGOLD, 6, -3.0f, new FabricItemSettings()));
    public static final Item ROSEGOLD_SHOVEL = registerItem("rosegold_shovel",
            new ShovelItem(ModToolMaterial.ROSEGOLD, 1, -2.4f, new FabricItemSettings()));
    public static final Item ROSEGOLD_HOE = registerItem("rosegold_hoe",
            new HoeItem(ModToolMaterial.ROSEGOLD, 0, -2f, new FabricItemSettings()));


    //ARMOR
    public static final Item ROSEGOLD_HELMET= registerItem("rosegold_helmet",
            new ModArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.HELMET, new FabricItemSettings()));

    public static final Item ROSEGOLD_CHESTPLATE = registerItem("rosegold_chestplate",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));

    public static final Item ROSEGOLD_LEGGINGS = registerItem("rosegold_leggings",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));

    public static final Item ROSEGOLD_BOOTS = registerItem("rosegold_boots",
            new ArmorItem(ModArmorMaterials.ROSEGOLD, ArmorItem.Type.BOOTS, new FabricItemSettings()));



    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        entries.add(ROSEGOLD_INGOT);
        entries.add(ROSEGOLD_NUGGET);
    }

    private static void addItemsToFoodTabItemGroup(FabricItemGroupEntries entries){
         entries.add(ROSEGOLD_APPLE);
         entries.add(ROSEGOLD_CARROT);
    }

    private static void addItemsToToolTabItemGroup(FabricItemGroupEntries entries){
        entries.add(ROSEGOLD_PICKAXE);
        entries.add(ROSEGOLD_SHOVEL);
        entries.add(ROSEGOLD_HOE);
    }

    private static void addItemsToWeaponTabItemGroup(FabricItemGroupEntries entries){
        entries.add(ROSEGOLD_SWORD);
        entries.add(ROSEGOLD_AXE);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Rosegold.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Rosegold.LOGGER.info("Registering Mod Items for + "+Rosegold.MOD_ID+".");
        if(Rosegold.addToVanillaTab){
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodTabItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToWeaponTabItemGroup);
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolTabItemGroup);
        }
    }
}
