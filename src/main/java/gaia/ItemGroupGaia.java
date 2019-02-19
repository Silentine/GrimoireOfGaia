package gaia;

import gaia.init.GaiaItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupGaia extends ItemGroup {

	public static final ItemGroupGaia INSTANCE = new ItemGroupGaia();

	private ItemGroupGaia() {
		super(GaiaReference.MOD_ID);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(GaiaItems.MISC_BOOK);
	}
}
