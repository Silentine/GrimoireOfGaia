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

public class ItemFoodRottenHeart extends ItemFoodBase {

	public ItemFoodRottenHeart(Item.Properties builder) {
		super(builder.maxStackSize(1).food(GaiaFoods.ROTTEN_HEART));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("effect.minecraft.regeneration").appendSibling(new StringTextComponent(" (0:10)")));
		tooltip.add(new TranslationTextComponent("effect.minecraft.hunger").appendSibling(new StringTextComponent(" (0:30)")));
	}
}
