package com.igentuman.steamtech.datagen;

import com.igentuman.steamtech.setup.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class STRecipes extends RecipeProvider {

    public STRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(Registration.GENERATOR.get())
                .pattern("mxm")
                .pattern("x#x")
                .pattern("#x#")
                .define('x', Tags.Items.GEMS_DIAMOND)
                .define('#', Tags.Items.INGOTS_IRON)
                .define('m', Registration.BRONZE_PLATE.get())
                .group("steamtech")
                .unlockedBy("mysterious", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.BRONZE_PLATE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(Registration.POWERGEN.get())
                .pattern("mmm")
                .pattern("x#x")
                .pattern("#x#")
                .define('x', Tags.Items.DUSTS_REDSTONE)
                .define('#', Tags.Items.INGOTS_IRON)
                .define('m', Registration.STEEL_PLATE.get())
                .group("steamtech")
                .unlockedBy("mysterious", InventoryChangeTrigger.TriggerInstance.hasItems(Registration.STEEL_PLATE.get()))
                .save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.TIN_ORE_ITEM.get()),
                        Registration.TIN_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(Registration.TIN_ORE_ITEM.get()))
                .save(consumer, "tin_ingot1");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_TIN_CHUNK.get()),
                        Registration.TIN_INGOT.get(), 0.0f, 100)
                .unlockedBy("has_chunk", has(Registration.RAW_TIN_CHUNK.get()))
                .save(consumer, "tin_ingot2");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.LEAD_ORE_ITEM.get()),
                        Registration.LEAD_INGOT.get(), 1.0f, 100)
                .unlockedBy("has_ore", has(Registration.LEAD_ORE_ITEM.get()))
                .save(consumer, "lead_ingot1");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_LEAD_CHUNK.get()),
                        Registration.LEAD_INGOT.get(), 0.0f, 100)
                .unlockedBy("has_chunk", has(Registration.RAW_LEAD_CHUNK.get()))
                .save(consumer, "lead_ingot2");
    }
}
