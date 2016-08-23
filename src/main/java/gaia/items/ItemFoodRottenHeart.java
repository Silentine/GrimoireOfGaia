package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFoodRottenHeart extends ItemFood {
	String texture;
	
	private int SecondPotionID;
	private int SecondPotionDuration;
	private int SecondPotionAmplifier;
	private float SecondPotionEffectPropability;

	public ItemFoodRottenHeart(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.FoodRottenHeart");
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(MobEffects.REGENERATION, 10, 0, 1.0F);
		this.setSecondPotionEffect(MobEffects.HUNGER, 30, 0, 0.8F);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("potion.regeneration") + " (0:10)");
		par3List.add("(80%) " + StatCollector.translateToLocal("potion.hunger") + " (0:30)");
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2world, EntityPlayer par3EntityPlayer) {
		super.onFoodEaten(par1ItemStack, par2world, par3EntityPlayer);

		if (!par2world.isRemote && this.SecondPotionID > 0 && par2world.rand.nextFloat() < this.SecondPotionDuration * 20) {
			par3EntityPlayer.addPotionEffect(new PotionEffect (this.SecondPotionID, this.SecondPotionDuration * 20, this.SecondPotionAmplifier));
		}
	}
	
	public ItemFood setSecondPotionEffect(int par1, int par2, int par3,float par4) {
		this.SecondPotionID = par1;
		this.SecondPotionDuration = par2;
		this.SecondPotionAmplifier = par3;
		this.SecondPotionEffectPropability = par4;
		return this;
	}
}
