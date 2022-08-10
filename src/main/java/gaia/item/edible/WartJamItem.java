package gaia.item.edible;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class WartJamItem extends EdibleEffectItem {
	public WartJamItem(Properties properties) {
		super(properties);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}
}
