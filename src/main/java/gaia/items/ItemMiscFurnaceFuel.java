package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemMiscFurnaceFuel extends ItemBase {

	private int fuelTimeTicks = 3600;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemMiscFurnaceFuel(Item.Properties builder) {
		super(builder); //"misc_furnace_fuel");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
