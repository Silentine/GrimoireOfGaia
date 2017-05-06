package gaia.items;

import gaia.Gaia;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;

public class ItemAccessoryTrinketLevitation extends ItemAccessoryTrinket {
	
	public ItemAccessoryTrinketLevitation(String name) {
		this.setUnlocalizedName(name);
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
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.Trinket.tag")));
		
		if (shiftPressed) {
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.InventoryTrinket")));
			tooltip.add(I18n.translateToLocal("text.GrimoireOfGaia.InventoryImmunity") + " " + I18n.translateToLocal("effect.levitation"));
			tooltip.add(I18n.translateToLocal("effect.moveSlowdown"));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.translateToLocal("text.GrimoireOfGaia.HoldShift")));
		}
	}

	@Override
	public void doEffect(EntityPlayer player, ItemStack item) {
		if (player.isPotionActive(MobEffects.LEVITATION))
			player.removePotionEffect(MobEffects.LEVITATION);

		if (!player.isPotionActive(MobEffects.SLOWNESS)) {
			player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20 * 10, 1));
		}
	}
}
