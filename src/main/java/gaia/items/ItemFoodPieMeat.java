package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemFoodPieMeat extends Gaia_FoodItem {
	
	public ItemFoodPieMeat(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30, 0), 1.0F);
		this.setSecondPotionEffect(new PotionEffect (MobEffects.HUNGER, 30, 0), 0.4F);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) 
	{
		par3List.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		par3List.add(I18n.translateToLocal("effect.moveSlowdown") + " (0:30)");
		par3List.add("(80%) " + I18n.translateToLocal("effect.hunger") + " (0:30)");
	}

	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
		super.onFoodEaten(stack, worldIn, player);
		rewardEXP(player, itemRand.nextInt(14) + 6);
    }
	
}
