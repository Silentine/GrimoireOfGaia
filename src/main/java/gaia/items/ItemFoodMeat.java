package gaia.items;

import gaia.Gaia;
import net.minecraft.item.ItemFood;

public class ItemFoodMeat extends ItemFood {

	public ItemFoodMeat(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}
}
