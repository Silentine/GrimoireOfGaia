package gaia.init;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public class GaiaRecipes {
	
	private static ItemStack getType(PotionType type) {
		return PotionUtils.addPotionToItemStack(new ItemStack(Items.POTION, 1), type);
	}

	public static void addBrews() {
		BrewingRecipeRegistry.addRecipe(getType(PotionTypes.WATER), Ingredient.fromItems(GaiaItems.FOOD_NETHER_WART), getType(PotionTypes.AWKWARD));
	}
}
