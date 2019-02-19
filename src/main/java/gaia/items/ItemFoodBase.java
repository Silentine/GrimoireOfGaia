package gaia.items;

import gaia.ItemGroupGaia;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood {

	public ItemFoodBase(Item.Properties builder, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood, builder.group(ItemGroupGaia.INSTANCE));
	}
}
