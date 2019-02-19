package gaia.items;

import gaia.ItemGroupGaia;
import net.minecraft.item.Item;

public class ItemBase extends Item {
	public ItemBase(Item.Properties builder) {
		super(builder.group(ItemGroupGaia.INSTANCE));
	}	
}
