package gaia.items;

import gaia.CreativeTabGaia;
import gaia.GaiaReference;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	public ItemBase(String name) {
		setRegistryName(GaiaReference.MOD_ID, name);
		setUnlocalizedName(GaiaReference.MOD_ID + "." + name);
		setCreativeTab(CreativeTabGaia.INSTANCE);
	}
}
