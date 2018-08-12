package gaia.items;

import baubles.api.BaubleType;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAccessoryRingNight extends ItemAccessoryBauble {
	public ItemAccessoryRingNight() {
		super("accessory_ring_night");
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
		tooltip.add(TextFormatting.YELLOW + I18n.format("text.grimoireofgaia.Accessory.tag"));

		if (shiftPressed) {
			tooltip.add(TextFormatting.YELLOW + I18n.format("text.grimoireofgaia.InventoryAccessory"));
			tooltip.add(I18n.format("effect.nightVision"));
		} else {
			tooltip.add(TextFormatting.ITALIC + I18n.format("text.grimoireofgaia.HoldShift"));
		}
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (player.getActivePotionEffect(MobEffects.NIGHT_VISION) != null) {
			player.removePotionEffect(MobEffects.NIGHT_VISION);
		}

		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, Integer.MAX_VALUE, 1, true, true));
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		PotionEffect effect = player.getActivePotionEffect(MobEffects.NIGHT_VISION);
		if (effect != null && effect.getAmplifier() == 1) {
			player.removePotionEffect(MobEffects.NIGHT_VISION);
		}
	}
}
