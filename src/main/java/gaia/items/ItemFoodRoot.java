package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

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

	public ItemFoodRoot(int par2, float par3, boolean par4, String name) {
		super(par2, par3, par4);
		this.setMaxStackSize(16);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.NegativeStatus.desc"));
	}

	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		this.clearNegativePotions(player);
	}
}
