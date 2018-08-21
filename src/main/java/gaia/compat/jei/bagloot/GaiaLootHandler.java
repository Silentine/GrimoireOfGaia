package gaia.compat.jei.bagloot;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.ingredients.Ingredients;
import net.minecraft.item.ItemStack;

public class GaiaLootHandler implements IRecipeHandler<GaiaLootWrapper>{

	@Override
	public Class<GaiaLootWrapper> getRecipeClass() {
		return GaiaLootWrapper.class;
	}

	@Override
	public String getRecipeCategoryUid(GaiaLootWrapper recipe) {
		return GaiaLootCategory.UID;
	}

	@Override
	public IRecipeWrapper getRecipeWrapper(GaiaLootWrapper recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(GaiaLootWrapper recipe) {
		IIngredients ingredients = new Ingredients();
        recipe.getIngredients(ingredients);
        return ingredients.getInputs(ItemStack.class).size() > 0 && ingredients.getOutputs(ItemStack.class).size() > 0;
	}

}