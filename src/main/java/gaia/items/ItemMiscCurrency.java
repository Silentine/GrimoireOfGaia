package gaia.items;

import java.util.List;

import gaia.init.GaiaItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemMiscCurrency extends ItemBase {
	public ItemMiscCurrency(Item.Properties builder) {
		super(builder); //"misc_currency");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (stack.getItem() == GaiaItems.MISC_CURRENCY_SELL) {
			tooltip.add(new TextComponentTranslation("item.grimoireofgaia.misc_currency.desc"));
		}
	}
}
