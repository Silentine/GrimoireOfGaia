package gaia.item.edible;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;

public class WartJamItem extends EdibleEffectItem {
	public WartJamItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack stack) {
		return ItemUseAnimation.DRINK;
	}
}
