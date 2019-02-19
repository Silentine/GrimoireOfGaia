package gaia.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemFoodMonsterFeed extends ItemFoodBase {

	public ItemFoodMonsterFeed(Item.Properties builder) {
		super(builder.maxStackSize(1), 2, 0.2F, true); //"food_monster_feed"
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.grimoireofgaia.desc").applyTextStyle(TextFormatting.YELLOW));
		tooltip.add(new TextComponentTranslation("item.grimoireofgaia.food_monster_feed.desc"));
		tooltip.add(new TextComponentTranslation("item.grimoireofgaia.spawn_tame2.desc").applyTextStyle(TextFormatting.ITALIC));
	}
}
