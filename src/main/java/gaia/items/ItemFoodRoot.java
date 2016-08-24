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
	String texture;

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

	public ItemFoodRoot(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setMaxStackSize(16);
		this.setUnlocalizedName("GrimoireOfGaia.FoodRoot");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(I18n.translateToLocal("item.GrimoireOfGaia.NegativeStatus.desc"));
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		this.clearNegativePotions(par3EntityPlayer);
	}
}
