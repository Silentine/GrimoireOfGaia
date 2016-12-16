package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemFoodPieMandrake extends Gaia_FoodItem {
	
	public ItemFoodPieMandrake(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		par3List.add(I18n.translateToLocal("effect.nightVision") + " (3:00)");
		par3List.add(I18n.translateToLocal("effect.waterBreathing") + " (3:00)");
	}
	@Override
	public void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		
		rewardEXP(player,itemRand.nextInt(14) + 6);        
		player.heal(4.0F);
		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 3600, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 3600, 0));
	}
	
}
