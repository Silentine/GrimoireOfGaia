package gaia.items;

import gaia.Gaia;
import net.minecraft.item.Item;

public class ItemFragment extends Item {
	String texture;

	public ItemFragment(String texture) {
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.Fragment");
		this.setCreativeTab(Gaia.tabGaia);
	}
}
