package net.grotacam.rosegold.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.grotacam.rosegold.Rosegold;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block ROSEGOLD_BLOCK = registerBlock("rosegold_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).mapColor(MapColor.PINK)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Rosegold.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Rosegold.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static void addBlocksToBuildingBlockTabItemGroup(FabricItemGroupEntries entries){
        if(Rosegold.addToVanillaTab) {
            entries.add(ROSEGOLD_BLOCK);
        }
    }

    public static void registerModBlocks(){
        Rosegold.LOGGER.info("Registering ModBlocks for "+Rosegold.MOD_ID+".");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlockTabItemGroup);


    }

}
