package gaia.items;

import gaia.Gaia;
import net.minecraft.item.ItemFood;

public class ItemFoodMeat extends ItemFood {

	public ItemFoodMeat(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}
}
