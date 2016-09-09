package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemFoodRottenHeart extends Gaia_FoodItem {

	public ItemFoodRottenHeart(int par2, float par3, boolean par4, String unlocal) {
		super(par2, par3, par4);
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.FoodRottenHeart");
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10, 0), 1.0F);
		this.setSecondPotionEffect(new PotionEffect(MobEffects.HUNGER, 30, 0), 0.8F);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("effect.regeneration") + " (0:10)");
		par3List.add("(80%) " + I18n.translateToLocal("effect.hunger") + " (0:30)");
	}

}
