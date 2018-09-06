package gaia.items;

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
import org.apache.commons.lang3.Range;
import org.lwjgl.input.Keyboard;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAccessoryRingHaste extends ItemAccessoryBauble {
	public ItemAccessoryRingHaste() {
		super("accessory_ring_haste");
		setMaxStackSize(1);
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(0, 1);
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
			tooltip.add(I18n.format("effect.digSpeed"));
		} else {
			tooltip.add(TextFormatting.ITALIC + I18n.format("text.grimoireofgaia.HoldShift"));
		}
	}

	@Override
	public void doEffect(EntityLivingBase player, ItemStack item) {
		if (player.getActivePotionEffect(MobEffects.HASTE) != null) {
			player.removePotionEffect(MobEffects.HASTE);
		}

		player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 5 * 20, 1, true, false));
	}
}
