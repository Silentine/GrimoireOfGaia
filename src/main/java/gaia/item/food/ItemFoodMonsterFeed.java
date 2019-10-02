package gaia.item.food;

import gaia.init.GaiaFoods;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemFoodMonsterFeed extends ItemFoodBase {

	public ItemFoodMonsterFeed(Item.Properties builder) {
		super(builder.maxStackSize(1).food(GaiaFoods.MONSTER_FEED));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("text.grimoireofgaia.grimoireofgaia.desc").applyTextStyle(TextFormatting.YELLOW));
		tooltip.add(new TranslationTextComponent("item.grimoireofgaia.food_monster_feed.desc"));
		tooltip.add(new TranslationTextComponent("item.grimoireofgaia.spawn_tame2.desc").applyTextStyle(TextFormatting.ITALIC));
	}
}
