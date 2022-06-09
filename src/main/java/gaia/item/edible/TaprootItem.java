package gaia.item.edible;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TaprootItem extends Item {
	public TaprootItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (!level.isClientSide) {
			livingEntity.getActiveEffects().forEach(effect -> {
				if (!effect.getEffect().isBeneficial()) {
					ItemStack rootStack = new ItemStack(this);
					if (!effect.getCurativeItems().contains(rootStack)) {
						effect.addCurativeItem(rootStack);
					}
				}
			});
			livingEntity.curePotionEffects(stack);
		}
		return super.finishUsingItem(stack, level, livingEntity);
	}
}
