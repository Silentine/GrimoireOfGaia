package gaia.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;

import java.util.Collections;
import java.util.List;

public class LootHelper {
	public static List<ItemStack> getStacksFromTable(ServerLevel level, LootContext.Builder lootContext,
													 LootContextParamSet paramSet, ResourceLocation table, int maxStacks) {
		LootTable loottable = level.getServer().getLootTables().get(table);
		LootContext ctx = lootContext.create(paramSet);
		List<ItemStack> stacks = loottable.getRandomItems(ctx);
		Collections.shuffle(stacks);

		int max = maxStacks < stacks.size() ? maxStacks : stacks.size();
		return stacks.subList(0, max);
	}

}
