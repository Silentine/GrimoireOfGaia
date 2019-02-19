package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemMiscGigaGear extends ItemBase {

	private int fuelTimeTicks = 1240000;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscGigaGear(Item.Properties builder) {
		super(builder); //"misc_giga_gear");
		//setMaxStackSize(1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(new TextComponentTranslation("item.grimoireofgaia.misc_giga_gear.desc").applyTextStyle(TextFormatting.ITALIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
