package gaia.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;

public class ItemGaiaLootable extends ItemBase {

	ItemGaiaLootable(String name) {
		super(name);
	}

	public ActionResult<ItemStack> loot(ItemStack stack) {
		return new ActionResult<>(EnumActionResult.SUCCESS, stack);
	}

	public ActionResult<ItemStack> loot(Block item) {
		return loot(new ItemStack(item));
	}

	public ActionResult<ItemStack> loot(Item item) {
		return loot(new ItemStack(item));
	}
}
