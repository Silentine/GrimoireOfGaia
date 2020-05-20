package gaia.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootTable;

import javax.annotation.Nullable;
import java.util.List;

public class LootHelper {
	private LootHelper() {}

	public static void dropLootAtPlayersPos(World world, PlayerEntity player, ResourceLocation lootTableName) {
		List<ItemStack> loot = getLoot(world, player, true, lootTableName);
		for (ItemStack itemstack : loot) {
			world.addEntity(new ItemEntity(world, player.getPosX(), player.getPosY(), player.getPosZ(), itemstack));
		}
	}

	private static List<ItemStack> getLoot(World world, @Nullable PlayerEntity player, boolean entityWasRecentlyHit, ResourceLocation lootTableName) {
		LootContext.Builder builder = new LootContext.Builder((ServerWorld) world);
		LootTable lootTable = world.getServer().getLootTableManager().getLootTableFromLocation(lootTableName);
		if (entityWasRecentlyHit && player != null) {
			builder.withLuck(player.getLuck());
		}
		return lootTable.generate(builder.build(LootParameterSets.CHEST));
	}

	public static void dropRandomLootAtPlayersPos(World world, PlayerEntity player, ResourceLocation lootTableName, int rolls) {
		dropRandomLootAtEntityPos(world, player, player, true, lootTableName, rolls);
	}

	public static void dropRandomLootAtEntityPos(World world,
			@Nullable PlayerEntity player, Entity entity, boolean entityWasRecentlyHit, ResourceLocation lootTableName,
			int rolls) {
		List<ItemStack> loot = getLoot(world, player, entityWasRecentlyHit, lootTableName);
		for (int i = 0; i < rolls; i++) {
			entity.entityDropItem(loot.get(world.rand.nextInt(loot.size())), 1);
		}
	}
}
