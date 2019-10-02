package gaia.item.food;

import gaia.init.GaiaFoods;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFoodNetherWart extends ItemFoodBase {

	public ItemFoodNetherWart(Item.Properties builder) {
		super(builder.food(GaiaFoods.NETHER_WART));
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("(40%) ").appendSibling(new TranslationTextComponent("effect.minecraft.speed")).appendSibling(new StringTextComponent(" (0:20)")));
		tooltip.add(new StringTextComponent("(40%) ").appendSibling(new TranslationTextComponent("effect.minecraft.haste")).appendSibling(new StringTextComponent(" (0:30)")));
	}
}
