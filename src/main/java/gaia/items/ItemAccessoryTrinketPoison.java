package gaia.items;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemAccessoryTrinketPoison extends ItemAccessoryBauble {
	public ItemAccessoryTrinketPoison(Item.Properties builder) {
		super(builder); //"accessory_trinket_poison");
	}

//	@Override
//	public BaubleType getBaubleType(ItemStack itemstack) {
//		return BaubleType.CHARM;
//	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		boolean shiftPressed = GuiScreen.isShiftKeyDown();
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.Trinket.tag").applyTextStyle(TextFormatting.YELLOW));

		if (shiftPressed) {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.InventoryTrinket").applyTextStyle(TextFormatting.YELLOW));
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.InventoryImmunity").appendSibling(new TextComponentString(" ")).appendSibling(new TextComponentTranslation("effect.minecraft.poison")) );
		} else {
			tooltip.add(new TextComponentTranslation("text.grimoireofgaia.HoldShift").applyTextStyle(TextFormatting.ITALIC));
		}
	}

//	@Override
//	protected Range<Integer> getActiveSlotRange() {
//		return Range.between(8, 8);
//	}
//
//	@Override
//	public void doEffect(EntityLivingBase player, ItemStack item) {
//		if (player.getActivePotionEffect(MobEffects.POISON) != null) {
//			player.removePotionEffect(MobEffects.POISON);
//		}
//	}
}
