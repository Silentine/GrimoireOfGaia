package gaia.items;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAccessoryCursed extends ItemAccessoryBauble {
	public ItemAccessoryCursed() {
		super("accessory_cursed");
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("effect.moveSlowdown"));
		tooltip.add(I18n.format("effect.digSlowDown"));
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		PotionEffect effect = player.getActivePotionEffect(MobEffects.SLOWNESS);
		if (effect != null && player instanceof EntityPlayer && effect.getAmplifier() == 1) {
			player.removePotionEffect(MobEffects.SLOWNESS);
		}

		effect = player.getActivePotionEffect(MobEffects.MINING_FATIGUE);
		if (effect != null && player instanceof EntityPlayer && effect.getAmplifier() == 1) {
			player.removePotionEffect(MobEffects.MINING_FATIGUE);
		}
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (player.getActivePotionEffect(MobEffects.SLOWNESS) != null) {
			player.removePotionEffect(MobEffects.SLOWNESS);
		}

		if (player.getActivePotionEffect(MobEffects.MINING_FATIGUE) != null) {
			player.removePotionEffect(MobEffects.MINING_FATIGUE);
		}

		player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, Integer.MAX_VALUE, 1, true, true));
		player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, Integer.MAX_VALUE, 1, true, true));
	}
}
