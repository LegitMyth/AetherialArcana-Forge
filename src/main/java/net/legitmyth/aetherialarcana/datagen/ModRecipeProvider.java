package net.legitmyth.aetherialarcana.datagen;

import net.legitmyth.aetherialarcana.AetherialArcana;
import net.legitmyth.aetherialarcana.block.ModBlocks;
import net.legitmyth.aetherialarcana.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> AQUA_SMELTABLES = List.of(ModItems.RAW_AQUA.get(),
            ModBlocks.AQUA_ORE.get(),
            ModBlocks.DEEPSLATE_AQUA_ORE.get(),
            ModBlocks.NETHER_AQUA_ORE.get(),
            ModBlocks.END_STONE_AQUA_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput, AQUA_SMELTABLES, RecipeCategory.MISC, ModItems.AQUA.get(), 0.25f, 200, "aqua");
        oreBlasting(recipeOutput, AQUA_SMELTABLES, RecipeCategory.MISC, ModItems.AQUA.get(), 0.25f, 100, "aqua");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AQUA_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.AQUA.get())
                .unlockedBy(getHasName(ModItems.AQUA.get()), has(ModItems.AQUA.get()))
                .save(recipeOutput);
ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_AQUA_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_AQUA.get())
                .unlockedBy(getHasName(ModItems.RAW_AQUA.get()), has(ModItems.RAW_AQUA.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AQUA.get(), 9)
                .requires(ModBlocks.AQUA_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.AQUA_BLOCK.get()), has(ModBlocks.AQUA_BLOCK.get()))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_AQUA.get(), 9)
                .requires(ModBlocks.RAW_AQUA_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_AQUA_BLOCK.get()), has(ModBlocks.RAW_AQUA_BLOCK.get()))
                .save(recipeOutput);

    }
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, AetherialArcana.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
