package gaia.items;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemAccessoryRingNight extends ItemAccessoryBauble {
	public ItemAccessoryRingNight(Item.Properties builder) {
		super(builder); //"accessory_ring_night");
	}

//	@Override
//	public BaubleType getBaubleType(ItemStack itemstack) {
//		return BaubleType.RING;
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = GuiScreen.isShiftKeyDown();
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.Accessory.tag").applyTextStyle(TextFormatting.YELLOW));

		if (shiftPressed) {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.InventoryAccessory").applyTextStyle(TextFormatting.YELLOW));
			tooltip.add(new TextComponentTranslation("effect.minecraft.night_vision"));
		} else {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.HoldShift").applyTextStyle(TextFormatting.ITALIC));
		}
	}

//	@Override
//	protected Range<Integer> getActiveSlotRange() {
//		return Range.between(0, 1);
//	}
//
//	@Override
//	public void doEffect(EntityLivingBase player, ItemStack item) {
//		if (player.getActivePotionEffect(MobEffects.NIGHT_VISION) != null) {
//			player.removePotionEffect(MobEffects.NIGHT_VISION);
//		}
//		
//		player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 15 * 20, 1, true, false));
//	}
}
