package gaia.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemMiscGigaGear extends Item {

	private int fuelTimeTicks = 1240000;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscGigaGear(Item.Properties builder) {
		super(builder); //"misc_giga_gear");
		//setMaxStackSize(1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(new TranslationTextComponent("item.grimoireofgaia.misc_giga_gear.desc").applyTextStyle(TextFormatting.ITALIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.EPIC;
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
