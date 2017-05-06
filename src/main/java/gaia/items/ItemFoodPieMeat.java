package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodPieMeat extends GaiaItemFood {
	
	public ItemFoodPieMeat(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.maxStackSize = 1;
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
		
		this.setPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 30, 0), 1.0F);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocalFormatted("text.GrimoireOfGaia.GainExperience"));
		tooltip.add(I18n.translateToLocal("effect.moveSlowdown") + " (0:30)");
	}

	@Override
	public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		rewardEXP(player, itemRand.nextInt(8) + 4);
    }
}
