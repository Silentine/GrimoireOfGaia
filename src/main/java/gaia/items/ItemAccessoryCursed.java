package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAccessoryCursed extends Item {
	
	public ItemAccessoryCursed(String name) {
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack stack, EntityPlayer player, List par3List, boolean par4) {
		par3List.add(TextFormatting.ITALIC + (I18n.translateToLocal("item.GrimoireOfGaia.AccessoryCursed.desc")));
		par3List.add(I18n.translateToLocal("effect.moveSlowdown"));
		par3List.add(I18n.translateToLocal("effect.digSlowDown"));
	}

	public void onUpdate(ItemStack stack, World world, Entity par3Entity, int par4, boolean par5) {
		super.onUpdate(stack, world, par3Entity, par4, par5);
		EntityPlayer player = (EntityPlayer)par3Entity;

		for(int i = 0; i < 35; ++i) {
			if (player.inventory.getStackInSlot(i) == stack) {
				this.doEffect(player, stack);
				break;
			}
		}
	}

	public void doEffect(EntityPlayer player, ItemStack item) {
		player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 200, 1));
		player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 200, 1));
	}
}
