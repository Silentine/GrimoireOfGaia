package gaia.item.loot;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;

public class ItemGaiaLootable extends Item {

	ItemGaiaLootable(Item.Properties builder) {
		super(builder);
	}

	public ActionResult<ItemStack> loot(ItemStack stack) {
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	public ActionResult<ItemStack> loot(Block item) {
		return loot(new ItemStack(item));
	}

	public ActionResult<ItemStack> loot(Item item) {
		return loot(new ItemStack(item));
	}
}
