package gaia.items;

import gaia.entity.GaiaLootTableList;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBoxEnd extends ItemBoxBase {
	public ItemBoxEnd(Item.Properties builder) {
		super(builder); //"box");
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return GaiaLootTableList.BOXES_END;
	}
}
