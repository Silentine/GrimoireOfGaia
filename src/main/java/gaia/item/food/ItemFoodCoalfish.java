package gaia.item.food;

import gaia.init.GaiaFoods;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFoodCoalfish extends ItemFoodBase {

	private int fuelTimeTicks = 3600;
	private int fuelTimeSeconds = fuelTimeTicks / 20;

	public ItemFoodCoalfish(Item.Properties builder) {
		super(builder.food(GaiaFoods.COAL_FISH));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.FuelForSeconds", fuelTimeSeconds));
		tooltip.add(new TranslationTextComponent("effect.minecraft.water_breathing").appendSibling(new StringTextComponent(" (2:00)")));
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return fuelTimeTicks;
	}
}
