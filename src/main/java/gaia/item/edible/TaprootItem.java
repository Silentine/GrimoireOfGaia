package gaia.item.edible;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

//TODO: Re-implement taproot behavior!
public class TaprootItem extends Item {
//	public static final EffectCure TAPROOT = EffectCure.get("taproot");


	public TaprootItem(Properties properties) {
		super(properties);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
		if (!level.isClientSide()) {
//			livingEntity.removeEffectsCuredBy(TAPROOT);

//			livingEntity.getActiveEffects().forEach(effect -> { //TODO: Check if this is the correct way to cure effects
//				if (!effect.getEffect().isBeneficial()) {
//					ItemStack rootStack = new ItemStack(this);
//					if (!effect.getCurativeItems().contains(rootStack)) {
//						effect.addCurativeItem(rootStack);
//					}
//				}
//			});
//			livingEntity.curePotionEffects(stack);
		}
		return super.finishUsingItem(stack, level, livingEntity);
	}
}
