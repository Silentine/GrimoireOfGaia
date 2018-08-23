package gaia.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemShardMisc extends ItemBase {

	public ItemShardMisc(String name) {
		super(name);
		setHasSubtypes(true);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 2; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}
}
