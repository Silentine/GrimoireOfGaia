package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodPieAppleGold extends GaiaItemFood {
	
	public ItemFoodPieAppleGold(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		tooltip.add(I18n.translateToLocal("effect.absorption") + " (2:00)");
		tooltip.add(I18n.translateToLocal("effect.regeneration") + " (IV)" + " (0:20)");
		tooltip.add(I18n.translateToLocal("effect.resistance") + " (5:00)");
		tooltip.add(I18n.translateToLocal("effect.fireResistance") + " (5:00)");
	}

	//PotionEffect is a direct copy of ItemAppleGold
	//Gained experience is 100% more
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		rewardEXP(player, itemRand.nextInt(32) + 16);
		player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 2400, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 4));
		player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 6000, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 0));
	}
}