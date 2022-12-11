package gaia.datagen.server;

import gaia.registry.GaiaRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class GaiaRecipes extends RecipeProvider {
	public GaiaRecipes(DataGenerator gen) {
		super(gen);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		ShapelessRecipeBuilder.shapeless(GaiaRegistry.HEADGEAR_DOLL.get())
				.requires(GaiaRegistry.DOLL_MAID.get()).unlockedBy("has_maid_doll", has(GaiaRegistry.DOLL_MAID.get()))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(GaiaRegistry.QUILL.get())
				.requires(Tags.Items.GEMS_DIAMOND).requires(Tags.Items.FEATHERS).unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(GaiaRegistry.GOLDEN_APPLE_PIE.get())
				.requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get()).requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get())
				.requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get()).requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get())
				.unlockedBy("has_golden_apple_pie_slice", has(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get()))
				.save(consumer);
		ShapedRecipeBuilder.shaped(Items.COAL_BLOCK)
				.pattern("CCC").pattern("CCC").pattern("CCC")
				.define('C', GaiaRegistry.STONE_COAL.get())
				.unlockedBy("has_stone_coal", has(GaiaRegistry.STONE_COAL.get())).save(consumer, "grimoireofgaia:stone_coal_to_coal_block");
		ShapedRecipeBuilder.shaped(Items.DIAMOND)
				.pattern("SSS").pattern("SSS").pattern("SSS")
				.define('S', GaiaRegistry.DIAMOND_SHARD.get())
				.unlockedBy("has_diamond_shard", has(GaiaRegistry.DIAMOND_SHARD.get())).save(consumer, "grimoireofgaia:diamond_shard_to_diamond");
		ShapedRecipeBuilder.shaped(Items.EMERALD)
				.pattern("SSS").pattern("SSS").pattern("SSS")
				.define('S', GaiaRegistry.EMERALD_SHARD.get())
				.unlockedBy("has_emerald_shard", has(GaiaRegistry.EMERALD_SHARD.get())).save(consumer, "grimoireofgaia:emerald_shard_to_emerald");

		ShapelessRecipeBuilder.shapeless(GaiaRegistry.MONSTER_FEED.get())
				.requires(Tags.Items.SEEDS_WHEAT).requires(Tags.Items.SEEDS_WHEAT).requires(GaiaRegistry.EXPERIENCE_IRON.get())
				.unlockedBy("has_experience_iron", has(GaiaRegistry.EXPERIENCE_IRON.get()))
				.save(consumer);
		ShapelessRecipeBuilder.shapeless(GaiaRegistry.MONSTER_FEED.get(), 2)
				.requires(Tags.Items.SEEDS_WHEAT).requires(Tags.Items.SEEDS_WHEAT).requires(GaiaRegistry.EXPERIENCE_GOLD.get())
				.unlockedBy("has_experience_gold", has(GaiaRegistry.EXPERIENCE_GOLD.get()))
				.save(consumer, "grimoireofgaia:monster_feed_1");
		ShapelessRecipeBuilder.shapeless(GaiaRegistry.MONSTER_FEED.get(), 4)
				.requires(Tags.Items.SEEDS_WHEAT).requires(Tags.Items.SEEDS_WHEAT).requires(GaiaRegistry.EXPERIENCE_DIAMOND.get())
				.unlockedBy("has_experience_diamond", has(GaiaRegistry.EXPERIENCE_DIAMOND.get()))
				.save(consumer, "grimoireofgaia:monster_feed_2");
		ShapelessRecipeBuilder.shapeless(Items.ELYTRA)
				.requires(GaiaRegistry.ELYTRA_FRAGMENT.get()).requires(GaiaRegistry.ELYTRA_FRAGMENT.get())
				.requires(Items.POPPED_CHORUS_FRUIT)
				.unlockedBy("has_elytra_fragment", has(GaiaRegistry.ELYTRA_FRAGMENT.get()))
				.save(consumer);

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.BOX_IRON.get()),
						GaiaRegistry.EXPERIENCE_IRON.get(), 0.1F, 200).unlockedBy("has_iron_box", has(GaiaRegistry.BOX_IRON.get()))
				.save(consumer);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.BOX_GOLD.get()),
						GaiaRegistry.EXPERIENCE_GOLD.get(), 0.1F, 200).unlockedBy("has_gold_box", has(GaiaRegistry.BOX_GOLD.get()))
				.save(consumer);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.BOX_DIAMOND.get()),
						GaiaRegistry.EXPERIENCE_DIAMOND.get(), 0.1F, 200).unlockedBy("has_diamond_box", has(GaiaRegistry.BOX_DIAMOND.get()))
				.save(consumer);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.FUR.get()),
						Items.LEATHER, 0.1F, 200).unlockedBy("has_fur", has(GaiaRegistry.FUR.get()))
				.save(consumer, "grimoireofgaia:fur_to_leather");
	}
}
