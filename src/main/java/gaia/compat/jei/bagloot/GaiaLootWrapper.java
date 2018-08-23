package gaia.compat.jei.bagloot;

import java.util.ArrayList;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class GaiaLootWrapper implements IRecipeWrapper {
	private final ItemStack bag;
    private final ArrayList<ItemStack> lootList;

    public GaiaLootWrapper(ItemStack bag, ArrayList<ItemStack> loot) {
    	this.bag = bag;
        this.lootList = loot;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
    	ingredients.setInput(ItemStack.class, bag);	
    	ingredients.setOutputs(ItemStack.class, lootList);
    }
}