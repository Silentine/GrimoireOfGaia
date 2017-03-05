package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFoodRoot extends ItemFood {
	String texture;

	public void clearNegativePotions(EntityPlayer entityplayer) {
		entityplayer.removePotionEffect(Potion.moveSlowdown.id);
		entityplayer.removePotionEffect(Potion.digSlowdown.id);
		entityplayer.removePotionEffect(Potion.confusion.id);
		entityplayer.removePotionEffect(Potion.blindness.id);
		entityplayer.removePotionEffect(Potion.hunger.id);
		entityplayer.removePotionEffect(Potion.weakness.id);
		entityplayer.removePotionEffect(Potion.poison.id);
		entityplayer.removePotionEffect(Potion.wither.id);
	}

	public ItemFoodRoot(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.setMaxStackSize(16);
		this.setUnlocalizedName("GrimoireOfGaia.FoodRoot");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("item.GrimoireOfGaia.NegativeStatus.desc"));
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		this.clearNegativePotions(par3EntityPlayer);
	}
}
