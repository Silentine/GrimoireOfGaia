package gaia.item;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.Range;

import java.util.List;

public class ItemAccessoryTrinketLevitation extends ItemAccessoryBauble {
	public ItemAccessoryTrinketLevitation(Item.Properties builder) {
		super(builder);
	}

//	@Override
//	public BaubleType getBaubleType(ItemStack itemstack) {
//		return BaubleType.CHARM;
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = Screen.hasShiftDown();
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.Trinket.tag").applyTextStyle(TextFormatting.YELLOW));

		if (shiftPressed) {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.InventoryTrinket").applyTextStyle(TextFormatting.YELLOW));
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.InventoryImmunity").appendSibling(new StringTextComponent(" ")).appendSibling(new TranslationTextComponent("effect.minecraft.levitation")) );
			tooltip.add(new TranslationTextComponent("effect.minecraft.slowness"));
		} else {
			tooltip.add(new TranslationTextComponent("text.grimoireofgaia.HoldShift").applyTextStyle(TextFormatting.ITALIC));
		}
	}

	@Override
	protected Range<Integer> getActiveSlotRange() {
		return Range.between(8, 8);
	}

	@Override
	public void doEffect(LivingEntity player, ItemStack item) {
		if (player.getActivePotionEffect(Effects.LEVITATION) != null) {
			player.removePotionEffect(Effects.LEVITATION);
		}

		if (player.getActivePotionEffect(Effects.SLOWNESS) != null) {
			player.removePotionEffect(Effects.SLOWNESS);
		}

		player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20 * 10, 1, true, false));
	}
}
