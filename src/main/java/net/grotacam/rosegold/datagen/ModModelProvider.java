package net.grotacam.rosegold.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.grotacam.rosegold.block.ModBlocks;
import net.grotacam.rosegold.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROSEGOLD_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ROSEGOLD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSEGOLD_NUGGET, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROSEGOLD_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROSEGOLD_CARROT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ROSEGOLD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSEGOLD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSEGOLD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSEGOLD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ROSEGOLD_HOE, Models.HANDHELD);


        itemModelGenerator.registerArmor((ArmorItem) ModItems.ROSEGOLD_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ROSEGOLD_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ROSEGOLD_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ROSEGOLD_BOOTS);
    }
}
