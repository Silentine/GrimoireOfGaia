package gaia.item.loot;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTables;

public class ItemChestJungle extends ItemBoxBase {
	public ItemChestJungle(Item.Properties builder) {
		super(builder.maxStackSize(64));
	}

	@Override
	public Rarity getRarity(ItemStack stack) {
		return Rarity.RARE;
	}

	@Override
	public ResourceLocation getBoxLoot() {
		return LootTables.CHESTS_JUNGLE_TEMPLE;
	}
}
