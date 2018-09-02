package gaia.items;

import gaia.helpers.ModelLoaderHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShardMisc extends ItemBase {

	public ItemShardMisc() {
		super("shard_misc");
		setHasSubtypes(true);
	}

	/* SUBITEMS */
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (!isInCreativeTab(tab)) {
			return;
		}

		for (int i = 0; i < 1; i++) {
			items.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerClient() {
		ModelLoaderHelper.registerItem(this, 
				"variant=undying"
				);
	}
	/* SUBITEMS */
}
