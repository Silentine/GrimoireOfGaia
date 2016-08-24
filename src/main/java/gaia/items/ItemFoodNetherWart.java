package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.StatCollector;
import net.minecraft.util.text.translation.I18n;

public class ItemFoodNetherWart extends ItemFood {
	String texture;
	
	private int SecondPotionID;
	private int SecondPotionDuration;
	private int SecondPotionAmplifier;
	private float SecondPotionEffectPropability;

	public ItemFoodNetherWart(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setUnlocalizedName("GrimoireOfGaia.FoodNetherWart");
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(MobEffects.SPEED, 30, 0, 0.4F);
		this.setSecondPotionEffect(MobEffects.HASTE, 30, 0, 0.4F);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("(40%) " + I18n.translateToLocal("potion.moveSpeed") + " (0:30)");
		par3List.add("(40%) " + I18n.translateToLocal("potion.digSpeed") + " (0:30)");
	}

	public ItemFood setSecondPotionEffect(int par1, int par2, int par3,float par4) {
		this.SecondPotionID = par1;
		this.SecondPotionDuration = par2;
		this.SecondPotionAmplifier = par3;
		this.SecondPotionEffectPropability = par4;
		return this;
	}
}
