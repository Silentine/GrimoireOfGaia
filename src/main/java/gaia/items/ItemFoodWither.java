package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodWither extends ItemFood {
	String texture;

	public ItemFoodWither(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.WITHER, 10, 0), 0.6F);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("(60%) " + I18n.translateToLocal("effect.wither") + " (0:10)");
	}
}
