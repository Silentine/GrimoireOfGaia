package gaia.items;

import gaia.Gaia;
import net.minecraft.item.Item;

public class ItemMiscQuill extends Item {

	public ItemMiscQuill(String name) {
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}
}