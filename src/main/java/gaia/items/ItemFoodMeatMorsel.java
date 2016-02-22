package gaia.items;

import gaia.Gaia;
import net.minecraft.item.ItemFood;

public class ItemFoodMeatMorsel extends ItemFood {
	String texture;

	public ItemFoodMeatMorsel(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.FoodMeatMorsel");
		this.setCreativeTab(Gaia.tabGaia);
	}
}
