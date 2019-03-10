package gaia.items.delete;

import java.util.List;

import gaia.items.ItemBase;
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

public class ItemSpawnTame extends ItemBase {
	public ItemSpawnTame(Item.Properties builder) {
		super(builder.maxStackSize(1)); //"spawn_tame");
	}

	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentTranslation("text.grimoireofgaia.grimoireofgaia.desc").applyTextStyle(TextFormatting.YELLOW));
		tooltip.add(new TextComponentTranslation("item.grimoireofgaia.spawn_tame.desc"));
		tooltip.add(new TextComponentTranslation("item.grimoireofgaia.spawn_tame2.desc").applyTextStyle(TextFormatting.ITALIC));
	}
}
