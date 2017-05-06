package gaia.items;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;

public class GaiaLootable extends Item {
	public ActionResult loot(ItemStack stack) {
		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}

	public ActionResult loot(Block item) {
		return loot(new ItemStack(item));
	}

	public ActionResult loot(Item item) {
		return loot(new ItemStack(item));
	}
}