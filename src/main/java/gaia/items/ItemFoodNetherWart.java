package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;

public class ItemFoodNetherWart extends Gaia_FoodItem {

	public ItemFoodNetherWart(int par2, float par3, boolean par4, String unlocal) {
		super(par2, par3, par4);
		this.setUnlocalizedName("GrimoireOfGaia.FoodNetherWart");
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.SPEED, 30, 0), 0.4F);
		this.setSecondPotionEffect(new PotionEffect(MobEffects.HASTE, 30, 0), 0.4F);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add("(40%) " + I18n.translateToLocal("effect.moveSpeed") + " (0:30)");
		par3List.add("(40%) " + I18n.translateToLocal("effect.digSpeed") + " (0:30)");
	}

}
