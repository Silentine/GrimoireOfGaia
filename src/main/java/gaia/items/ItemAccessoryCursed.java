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
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//TODO Remove/Phase out
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

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(I18n.translateToLocal("effect.moveSlowdown"));
		tooltip.add(I18n.translateToLocal("effect.digSlowDown"));
	}

	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		EntityPlayer player = (EntityPlayer)entityIn;
		
		if (!(entityIn instanceof EntityPlayer))
			return;

		for (int i = 0; i < 35; ++i) {
			if (player.inventory.getStackInSlot(i) == stack) {
				this.doEffect(player, stack);
				break;
			}
		}
	}

	public void doEffect(EntityPlayer player, ItemStack item) {
		if (!player.isPotionActive(MobEffects.SLOWNESS)) {
			player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20 * 10, 1));
		}

		if (!player.isPotionActive(MobEffects.MINING_FATIGUE)) {
			player.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 20 * 10, 1));
		}
	}
}
