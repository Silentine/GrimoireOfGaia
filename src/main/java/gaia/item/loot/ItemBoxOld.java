package gaia.item.loot;

import gaia.init.GaiaLootTables;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBoxOld extends ItemBoxBase {
	public ItemBoxOld(Item.Properties builder) {
		super(builder);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return GaiaLootTables.BOXES_OLD;
	}
}
