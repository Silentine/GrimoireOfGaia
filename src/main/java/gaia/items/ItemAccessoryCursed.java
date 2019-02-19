package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemAccessoryCursed extends ItemAccessoryBauble {
	public ItemAccessoryCursed(Item.Properties builder) {
		super(builder); //"accessory_cursed"
	}

//	@Override
//	public BaubleType getBaubleType(ItemStack itemstack) {
//		return BaubleType.AMULET;
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TextComponentTranslation("effect.minecraft.slowness"));
		tooltip.add(new TextComponentTranslation("effect.minecraft.mining_fatique"));
	}

//	@Override
//	protected Range<Integer> getActiveSlotRange() {
//		return Range.between(0, 34);
//	}

//	@Override
//	public void doEffect(EntityLivingBase player, ItemStack item) {
//		if (player.getActivePotionEffect(MobEffects.SLOWNESS) != null) {
//			player.removePotionEffect(MobEffects.SLOWNESS);
//		}
//
//		if (player.getActivePotionEffect(MobEffects.MINING_FATIGUE) != null) {
//			player.removePotionEffect(MobEffects.MINING_FATIGUE);
//		}
//
//		player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20 * 10, 1, true, true));
//		player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 20 * 10, 1, true, true));
//	}
}
