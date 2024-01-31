package net.grotacam.rosegold.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.grotacam.rosegold.Rosegold;
import net.grotacam.rosegold.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemsGroups {

    public static final ItemGroup ROSEGOLD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Rosegold.MOD_ID, "rosegold_ingot"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.rosegold_ingot"))
                    .icon(()->new ItemStack(ModItems.ROSEGOLD_INGOT)).entries((displayContext, entries) -> {

                entries.add(ModItems.ROSEGOLD_INGOT);

                entries.add(ModItems.ROSEGOLD_NUGGET);

                entries.add(ModBlocks.ROSEGOLD_BLOCK);


                entries.add(ModItems.ROSEGOLD_APPLE);
                entries.add(ModItems.ROSEGOLD_CARROT);

                entries.add(ModItems.ROSEGOLD_SWORD);
                entries.add(ModItems.ROSEGOLD_PICKAXE);
                entries.add(ModItems.ROSEGOLD_AXE);
                entries.add(ModItems.ROSEGOLD_SHOVEL);
                entries.add(ModItems.ROSEGOLD_HOE);

                entries.add(ModItems.ROSEGOLD_HELMET);
                entries.add(ModItems.ROSEGOLD_CHESTPLATE);
                entries.add(ModItems.ROSEGOLD_LEGGINGS);
                entries.add(ModItems.ROSEGOLD_BOOTS);

            }).build());

    public static void registerItemGroups(){
        Rosegold.LOGGER.info("Registering Item Groups for "+Rosegold.MOD_ID);
    }


}
