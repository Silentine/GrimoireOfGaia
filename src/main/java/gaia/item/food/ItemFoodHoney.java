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

public class ItemFoodHoney extends ItemFoodBase {

	public ItemFoodHoney(Item.Properties builder) {
		super(builder.food(GaiaFoods.HONEY));
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("(20%) ").appendSibling(new TranslationTextComponent("effect.minecraft.speed")).appendSibling(new StringTextComponent(" (0:10)")));
		tooltip.add(new StringTextComponent("(20%) ").appendSibling(new TranslationTextComponent("effect.minecraft.haste")).appendSibling(new StringTextComponent(" (0:10)")));
	}
}
