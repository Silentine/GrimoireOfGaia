package gaia.compat.jei.bagloot;

import gaia.GaiaReference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.util.Translator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GaiaLootCategory implements IRecipeCategory<GaiaLootWrapper> {
	protected static final int FIRSTX = 56;
	protected static final int FIRSTY = 2;
	protected static final int ITEMSPERROW = 7;
	protected static final int ITEMSPERCOL = 7;
	protected static final int SPACINGX=18;
	protected static final int SPACINGY=18;
	protected static final int ITEMSPERPAGE = ITEMSPERROW*ITEMSPERCOL;

	public static final String UID = "gaia.Loot";
    private final IDrawableStatic background;
    private final String title;
    private final IDrawableStatic icon;
	
	public GaiaLootCategory(IGuiHelper guiHelper) {
		title = Translator.translateToLocal("gui.gaia.loot");
		 
		ResourceLocation location = new ResourceLocation(GaiaReference.MOD_ID, "textures/gui/bag_loot.png");
		background = guiHelper.createDrawable(location, 0, 0, 184, 130);

		ResourceLocation iconLocation = new ResourceLocation(GaiaReference.MOD_ID, "textures/gui/loot_icon.png");
		icon = guiHelper.createDrawable(iconLocation, 0, 0, 16, 16);
	}
	
	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getModName() {
		return GaiaReference.MOD_NAME;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, GaiaLootWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		
		int x = FIRSTX;
		int y = FIRSTY;
		guiItemStacks.init(0, true, 2, 56);
				
		for(int i = 1; i < Math.min(ITEMSPERPAGE, ingredients.getOutputs(ItemStack.class).size())+1; i++)
		{
			guiItemStacks.init(i, false, x, y);
			x+= SPACINGX;
			if(x >= FIRSTX+SPACINGX*ITEMSPERROW)
			{
				x = FIRSTX;
				y+= SPACINGY;
			}
		}
		
		guiItemStacks.set(ingredients);
	}
}