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

public class ItemFoodNetherWart extends GaiaItemFood {

	public ItemFoodNetherWart(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.SPEED, 30, 0), 0.4F);
		this.setSecondPotionEffect(new PotionEffect(MobEffects.HASTE, 30, 0), 0.4F);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("(40%) " + I18n.translateToLocal("effect.moveSpeed") + " (0:30)");
		tooltip.add("(40%) " + I18n.translateToLocal("effect.digSpeed") + " (0:30)");
	}
}
