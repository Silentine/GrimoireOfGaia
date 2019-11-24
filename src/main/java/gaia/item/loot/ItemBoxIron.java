package gaia.item.loot;

import gaia.init.GaiaLootTables;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemBoxIron extends ItemBoxBase {
	public ItemBoxIron(Item.Properties builder) {
		super(builder);
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return GaiaLootTables.BOXES_IRON;
	}
}
