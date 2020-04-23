package gaia.item;

import gaia.init.GaiaItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ItemMiscCurrency extends Item {
	public ItemMiscCurrency(Item.Properties builder) {
		super(builder); //"misc_currency");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.UNCOMMON;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (stack.getItem() == GaiaItems.MISC_CURRENCY_SELL.get()) {
			tooltip.add(new TranslationTextComponent("item.grimoireofgaia.misc_currency.desc"));
		}
	}
}
