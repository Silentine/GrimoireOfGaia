package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodSmallAppleGold extends ItemFood {
	String texture;

	public ItemFoodSmallAppleGold(int par2, float par3, boolean par4, String texture) {
		super(par2, par3, par4);
		this.texture = texture;
		this.maxStackSize = 64;
		this.setUnlocalizedName("GrimoireOfGaia.FoodSmallAppleGold");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.UNCOMMON;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("potion.absorption") + " (2:00)");
		par3List.add(StatCollector.translateToLocal("potion.regeneration") + " (IV)" + " (0:04)");
		par3List.add(StatCollector.translateToLocal("potion.resistance") + " (0:50)");
		par3List.add(StatCollector.translateToLocal("potion.fireResistance") + " (0:50)");
	}

	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.absorption.id, 2400, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 80, 4));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 1000, 0));
		par3EntityPlayer.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1000, 0));
	}
}
