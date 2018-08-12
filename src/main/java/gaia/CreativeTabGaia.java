package gaia;

import gaia.init.GaiaItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabGaia extends CreativeTabs {

	public static final CreativeTabGaia INSTANCE = new CreativeTabGaia();

	public CreativeTabGaia() {
		super(GaiaReference.MOD_ID);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(GaiaItems.MISC_BOOK, 1, 0);
	}
}
