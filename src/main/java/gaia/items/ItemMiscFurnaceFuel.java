package gaia.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMiscFurnaceFuel extends ItemBase {

	private int fuelTimeTicks = 3600;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscFurnaceFuel() {
		super("misc_furnace_fuel");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.format("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
	}

	@Override
	public int getItemBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
