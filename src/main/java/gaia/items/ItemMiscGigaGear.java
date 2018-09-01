package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMiscGigaGear extends ItemBase {

	private int fuelTimeTicks = 1240000;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscGigaGear() {
		super("misc_giga_gear");
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(TextFormatting.ITALIC + I18n.format("item.grimoireofgaia.misc_giga_gear.desc"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
