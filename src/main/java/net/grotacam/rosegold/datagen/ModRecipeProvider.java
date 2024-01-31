package net.grotacam.rosegold.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.grotacam.rosegold.block.ModBlocks;
import net.grotacam.rosegold.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ROSEGOLD_INGOT, RecipeCategory.BUILDING_BLOCKS,
                ModBlocks.ROSEGOLD_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSEGOLD_INGOT, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.ROSEGOLD_NUGGET)
                .criterion(hasItem(ModItems.ROSEGOLD_NUGGET),conditionsFromItem(ModItems.ROSEGOLD_NUGGET))
                .offerTo(exporter, new Identifier("rosegold_nugget_to_ingot"));

        offerShapelessRecipe(exporter, ModItems.ROSEGOLD_NUGGET, ModItems.ROSEGOLD_INGOT, null, 9);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROSEGOLD_INGOT, 4)
                .input(Items.COPPER_INGOT, 1)
                .input(Items.GOLD_INGOT,3)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier("rosegold_alloy"));
    }
}
