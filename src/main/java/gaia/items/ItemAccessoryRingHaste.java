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

public class ItemAccessoryRingHaste extends ItemAccessoryRing {
	
	public ItemAccessoryRingHaste(String name) {
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
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.Accessory.tag")));
		
		if (shiftPressed) {
			tooltip.add(TextFormatting.YELLOW + (I18n.translateToLocal("text.GrimoireOfGaia.InventoryAccessory")));
			tooltip.add(I18n.translateToLocal("effect.digSpeed"));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.translateToLocal("text.GrimoireOfGaia.HoldShift")));
		}
	}

	@Override
	public void doEffect(EntityPlayer player, ItemStack item) {	
		if (!player.isPotionActive(MobEffects.HASTE)) {
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 10 * 20, 0, true, false));		
		}
	}
}
