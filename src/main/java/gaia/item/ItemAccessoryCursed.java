package gaia.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.Range;

import java.util.List;

public class ItemAccessoryCursed extends ItemAccessoryBauble {
	public ItemAccessoryCursed(Item.Properties builder) {
		super(builder);
	}

//	@Override
//	public BaubleType getBaubleType(ItemStack itemstack) {
//		return BaubleType.AMULET;
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("effect.minecraft.slowness"));
		tooltip.add(new TranslationTextComponent("effect.minecraft.mining_fatique"));
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(0, 34);
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack item) {
		if (player.getActivePotionEffect(Effects.SLOWNESS) != null) {
			player.removePotionEffect(Effects.SLOWNESS);
		}

		if (player.getActivePotionEffect(Effects.MINING_FATIGUE) != null) {
			player.removePotionEffect(Effects.MINING_FATIGUE);
		}

		player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20 * 10, 1, true, true));
		player.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 20 * 10, 1, true, true));
	}
}
