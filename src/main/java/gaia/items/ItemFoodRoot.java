package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodRoot extends ItemFood {
	
	public void clearNegativePotions(EntityPlayer entityplayer) {
		entityplayer.removePotionEffect(MobEffects.SLOWNESS);
		entityplayer.removePotionEffect(MobEffects.MINING_FATIGUE);
		entityplayer.removePotionEffect(MobEffects.NAUSEA);
		entityplayer.removePotionEffect(MobEffects.BLINDNESS);
		entityplayer.removePotionEffect(MobEffects.HUNGER);
		entityplayer.removePotionEffect(MobEffects.WEAKNESS);
		entityplayer.removePotionEffect(MobEffects.POISON);
		entityplayer.removePotionEffect(MobEffects.WITHER);
	}

	public ItemFoodRoot(int amount, float saturation, boolean isWolfFood, String name) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(16);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("text.GrimoireOfGaia.NegativeStatus.desc"));
	}

	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		this.clearNegativePotions(player);
	}
}
