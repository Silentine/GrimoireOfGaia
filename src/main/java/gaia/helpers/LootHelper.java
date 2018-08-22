package gaia.helpers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;

import javax.annotation.Nullable;
import java.util.List;

public class LootHelper {
	private LootHelper() {}

	public static void dropLootAtPlayersPos(World world, EntityPlayer player, ResourceLocation lootTableName) {
		List<ItemStack> loot = getLoot(world, player, true, lootTableName);

		for (ItemStack itemstack : loot) {
			world.spawnEntity(new EntityItem(world, player.posX, player.posY, player.posZ, itemstack));
		}
	}

	private static List<ItemStack> getLoot(World world, @Nullable EntityPlayer player, boolean entityWasRecentlyHit, ResourceLocation lootTableName) {
		LootContext.Builder builder = new LootContext.Builder((WorldServer) world);
		LootTable lootTable = world.getLootTableManager().getLootTableFromLocation(lootTableName);
		if (entityWasRecentlyHit && player != null) {
			builder.withLuck(player.getLuck()).withPlayer(player);
		}
		return lootTable.generateLootForPools(world.rand, builder.build());
	}

	public static void dropRandomLootAtPlayersPos(World world, EntityPlayer player, ResourceLocation lootTableName, int rolls) {
		dropRandomLootAtEntityPos(world, player, player, true, lootTableName, rolls);
	}

	public static void dropRandomLootAtEntityPos(World world,
			@Nullable EntityPlayer player, Entity entity, boolean entityWasRecentlyHit, ResourceLocation lootTableName,
			int rolls) {
		List<ItemStack> loot = getLoot(world, player, entityWasRecentlyHit, lootTableName);
		for (int i = 0; i < rolls; i++) {
			entity.entityDropItem(loot.get(world.rand.nextInt(loot.size())), 0F);
		}
	}
}
