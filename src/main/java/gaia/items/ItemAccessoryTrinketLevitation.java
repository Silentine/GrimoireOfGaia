package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang3.Range;
import org.lwjgl.input.Keyboard;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAccessoryTrinketLevitation extends ItemAccessoryBauble {
	public ItemAccessoryTrinketLevitation() {
		super("accessory_trinket_levitation");
		setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BODY;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.Trinket.tag")));

		if (shiftPressed) {
			if (!isBaublesLoaded) {
				tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryTrinket")));
			}

			tooltip.add(I18n.format("text.grimoireofgaia.InventoryImmunity") + " " + I18n.format("effect.levitation"));
			tooltip.add(I18n.format("effect.moveSlowdown"));
		} else {
			tooltip.add(TextFormatting.ITALIC + (I18n.format("text.grimoireofgaia.HoldShift")));
		}
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(8, 8);
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (player.getActivePotionEffect(MobEffects.LEVITATION) != null) {
			player.removePotionEffect(MobEffects.LEVITATION);
		}

		if (player.getActivePotionEffect(MobEffects.SLOWNESS) != null) {
			player.removePotionEffect(MobEffects.SLOWNESS);
		}

		player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20 * 10, 1, true, false));
	}
	
	@Override
	public void applyModifier(EntityLivingBase player, ItemStack item) {
	}

	@Override
	public void removeModifier(EntityLivingBase player, ItemStack item) {
	}
}
