package gaia.datagen.server;

import gaia.Reference;
import gaia.registry.GaiaRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class GaiaRecipes extends RecipeProvider {
	public GaiaRecipes(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
		super(provider, recipeOutput);
	}

	@Override
	protected void buildRecipes() {
		shapeless(RecipeCategory.DECORATIONS, GaiaRegistry.HEADGEAR_DOLL.get())
				.requires(GaiaRegistry.DOLL_MAID.get()).unlockedBy("has_maid_doll", has(GaiaRegistry.DOLL_MAID.get()))
				.save(output);
		shapeless(RecipeCategory.MISC, GaiaRegistry.QUILL.get())
				.requires(Tags.Items.GEMS_DIAMOND).requires(Tags.Items.FEATHERS).unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND))
				.save(output);
		shapeless(RecipeCategory.FOOD, GaiaRegistry.GOLDEN_APPLE_PIE.get())
				.requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get()).requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get())
				.requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get()).requires(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get())
				.unlockedBy("has_golden_apple_pie_slice", has(GaiaRegistry.GOLDEN_APPLE_PIE_SLICE.get()))
				.save(output);
		shapeless(RecipeCategory.DECORATIONS, GaiaRegistry.PEARL_BLOCK.get())
				.requires(GaiaRegistry.SHINY_PEARL.get()).requires(GaiaRegistry.SHINY_PEARL.get())
				.requires(GaiaRegistry.SHINY_PEARL.get()).requires(GaiaRegistry.SHINY_PEARL.get())
				.unlockedBy("has_shiny_pearl", has(GaiaRegistry.SHINY_PEARL.get()))
				.save(output);
		shaped(RecipeCategory.MISC, Items.COAL_BLOCK)
				.pattern("CCC").pattern("CCC").pattern("CCC")
				.define('C', GaiaRegistry.STONE_COAL.get())
				.unlockedBy("has_stone_coal", has(GaiaRegistry.STONE_COAL.get())).save(output, "grimoireofgaia:stone_coal_to_coal_block");
		shaped(RecipeCategory.MISC, Items.DIAMOND)
				.pattern("SSS").pattern("SSS").pattern("SSS")
				.define('S', GaiaRegistry.DIAMOND_SHARD.get())
				.unlockedBy("has_diamond_shard", has(GaiaRegistry.DIAMOND_SHARD.get())).save(output, "grimoireofgaia:diamond_shard_to_diamond");
		shaped(RecipeCategory.MISC, Items.EMERALD)
				.pattern("SSS").pattern("SSS").pattern("SSS")
				.define('S', GaiaRegistry.EMERALD_SHARD.get())
				.unlockedBy("has_emerald_shard", has(GaiaRegistry.EMERALD_SHARD.get())).save(output, "grimoireofgaia:emerald_shard_to_emerald");

		shapeless(RecipeCategory.FOOD, GaiaRegistry.MONSTER_FEED.get())
				.requires(Tags.Items.SEEDS_WHEAT).requires(Tags.Items.SEEDS_WHEAT).requires(GaiaRegistry.EXPERIENCE_IRON.get())
				.unlockedBy("has_experience_iron", has(GaiaRegistry.EXPERIENCE_IRON.get()))
				.save(output);
		shapeless(RecipeCategory.FOOD, GaiaRegistry.MONSTER_FEED.get(), 2)
				.requires(Tags.Items.SEEDS_WHEAT).requires(Tags.Items.SEEDS_WHEAT).requires(GaiaRegistry.EXPERIENCE_GOLD.get())
				.unlockedBy("has_experience_gold", has(GaiaRegistry.EXPERIENCE_GOLD.get()))
				.save(output, "grimoireofgaia:monster_feed_1");
		shapeless(RecipeCategory.FOOD, GaiaRegistry.MONSTER_FEED.get(), 4)
				.requires(Tags.Items.SEEDS_WHEAT).requires(Tags.Items.SEEDS_WHEAT).requires(GaiaRegistry.EXPERIENCE_DIAMOND.get())
				.unlockedBy("has_experience_diamond", has(GaiaRegistry.EXPERIENCE_DIAMOND.get()))
				.save(output, "grimoireofgaia:monster_feed_2");
		shapeless(RecipeCategory.TRANSPORTATION, Items.ELYTRA)
				.requires(GaiaRegistry.ELYTRA_FRAGMENT.get()).requires(GaiaRegistry.ELYTRA_FRAGMENT.get())
				.requires(Items.POPPED_CHORUS_FRUIT)
				.unlockedBy("has_elytra_fragment", has(GaiaRegistry.ELYTRA_FRAGMENT.get()))
				.save(output, "grimoireofgaia:fragment_to_elytra");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.BOX_IRON.get()), RecipeCategory.MISC, CookingBookCategory.MISC,
						GaiaRegistry.EXPERIENCE_IRON.get(), 0.1F, 200).unlockedBy("has_iron_box", has(GaiaRegistry.BOX_IRON.get()))
				.save(output);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.BOX_GOLD.get()), RecipeCategory.MISC, CookingBookCategory.MISC,
						GaiaRegistry.EXPERIENCE_GOLD.get(), 0.1F, 200).unlockedBy("has_gold_box", has(GaiaRegistry.BOX_GOLD.get()))
				.save(output);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.BOX_DIAMOND.get()), RecipeCategory.MISC, CookingBookCategory.MISC,
						GaiaRegistry.EXPERIENCE_DIAMOND.get(), 0.1F, 200).unlockedBy("has_diamond_box", has(GaiaRegistry.BOX_DIAMOND.get()))
				.save(output);
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(GaiaRegistry.FUR.get()), RecipeCategory.MISC, CookingBookCategory.MISC,
						Items.LEATHER, 0.1F, 200).unlockedBy("has_fur", has(GaiaRegistry.FUR.get()))
				.save(output, "grimoireofgaia:fur_to_leather");

		ItemStackTemplate bookTemplate = getGuideBook();
		if (bookTemplate != null) {
			shapeless(RecipeCategory.MISC, bookTemplate)
					.requires(Items.BOOK)
					.requires(Items.IRON_NUGGET)
					.unlockedBy("has_book", has(Items.BOOK))
					.unlockedBy("has_nugget", has(Items.IRON_NUGGET))
					.save(output, Reference.modLoc("gaiapedia").toString());
		}
	}

	public static ItemStackTemplate getGuideBook() {
		Item guideBook = BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("patchouli", "guide_book"));
//		if (guideBook != null) {
//			return new ItemStackTemplate(guideBook, DataComponentPatch.builder()
//					.set(PatchouliDataComponents.BOOK, Reference.modLoc("gaiapedia")).build());
//		}
		return null;
	}

	public static class Runner extends RecipeProvider.Runner {
		public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
			super(output, completableFuture);
		}

		@Override
		protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
			return new GaiaRecipes(provider, recipeOutput);
		}

		@Override
		public String getName() {
			return "Grimoire of Gaia Recipes";
		}
	}
}
