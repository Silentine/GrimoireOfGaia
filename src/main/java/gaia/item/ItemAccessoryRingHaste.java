package gaia.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.Range;

import java.util.List;

public class ItemAccessoryRingHaste extends ItemAccessoryBauble {
	public ItemAccessoryRingHaste(Item.Properties builder) {
		super(builder);
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(0, 1);
	}

//	@Override
//	public BaubleType getBaubleType(ItemStack itemstack) {
//		return BaubleType.RING;
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Screen.hasShiftDown();
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.Accessory.tag").applyTextStyle(TextFormatting.YELLOW));

		if (shiftPressed) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.InventoryAccessory").applyTextStyle(TextFormatting.YELLOW));
			tooltip.add(new TranslationTextComponent("effect.minecraft.haste"));
		} else {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.HoldShift").applyTextStyle(TextFormatting.ITALIC));
		}
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack item) {
		if (player.getActivePotionEffect(Effects.HASTE) != null) {
			player.removePotionEffect(Effects.HASTE);
		}

		player.addPotionEffect(new EffectInstance(Effects.HASTE, 5 * 20, 1, true, false));
	}
}
