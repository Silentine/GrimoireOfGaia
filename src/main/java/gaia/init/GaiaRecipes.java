package gaia.init;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class GaiaRecipes {
	//TODO Test if the potion recipes work
	private static ItemStack getType(Potion type) {
		return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION), type);
	}

	public static void addBrews() {
        BrewingRecipeRegistry.addRecipe(Ingredient.fromStacks(getType(Potions.WATER)), Ingredient.fromItems(GaiaItems.FOOD_NETHER_WART), getType(Potions.AWKWARD));
	}
}
