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

public class ItemAccessoryRingNight extends ItemAccessoryBauble {
	public ItemAccessoryRingNight() {
		super("accessory_ring_night");
		setMaxStackSize(1);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + I18n.format("text.grimoireofgaia.Ring.tag"));

		if (shiftPressed) {
			if (!isBaublesLoaded) {
				tooltip.add(TextFormatting.YELLOW + (I18n.format("text.grimoireofgaia.InventoryAccessory")));
			}
			tooltip.add(I18n.format("effect.nightVision"));
		} else {
			tooltip.add(TextFormatting.ITALIC + I18n.format("text.grimoireofgaia.HoldShift"));
		}
	}
	
	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(0, 1);
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (player.getActivePotionEffect(MobEffects.NIGHT_VISION) != null) {
			player.removePotionEffect(MobEffects.NIGHT_VISION);
		}

		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 15 * 20, 1, true, false));
	}
	
	@Override
	public void applyModifier(EntityLivingBase player, ItemStack item) {
	}

	@Override
	public void removeModifier(EntityLivingBase player, ItemStack item) {
	}
}
