package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodRottenHeart extends GaiaItemFood {

	public ItemFoodRottenHeart(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10, 0), 1.0F);
		this.setSecondPotionEffect(new PotionEffect(MobEffects.HUNGER, 30, 0), 0.8F);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("effect.regeneration") + " (0:10)");
		tooltip.add("(80%) " + I18n.translateToLocal("effect.hunger") + " (0:30)");
	}
}
