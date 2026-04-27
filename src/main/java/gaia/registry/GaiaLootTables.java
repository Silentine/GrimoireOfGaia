package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class GaiaLootTables {
	public static final ResourceKey<LootTable> BAG_ARROW = register("lootbox/bag_arrow");
	public static final ResourceKey<LootTable> BAG_BOOK = register("lootbox/bag_book");
	public static final ResourceKey<LootTable> BAG_RECORD = register("lootbox/bag_record");
	public static final ResourceKey<LootTable> BOXES_IRON = register("lootbox/box_iron");
	public static final ResourceKey<LootTable> BOXES_GOLD = register("lootbox/box_gold");
	public static final ResourceKey<LootTable> BOXES_DIAMOND = register("lootbox/box_diamond");
	public static final ResourceKey<LootTable> BOXES_OVERWORLD = register("lootbox/box_overworld");
	public static final ResourceKey<LootTable> BOXES_NETHER = register("lootbox/box_nether");
	public static final ResourceKey<LootTable> BOXES_END = register("lootbox/box_end");
	public static final ResourceKey<LootTable> BOXES_OLD = register("lootbox/box_old");
	public static final ResourceKey<LootTable> BOXES_HAT = register("lootbox/box_hat");
	public static final ResourceKey<LootTable> BOXES_EGG = register("lootbox/box_egg");

	public static final ResourceKey<LootTable> MINOTAURUS_RANGED = register("entities/minotaurus_ranged");
	public static final ResourceKey<LootTable> DWARF_RANGED = register("entities/dwarf_ranged");
	public static final ResourceKey<LootTable> DWARF_MINER = register("entities/dwarf_miner");
	public static final ResourceKey<LootTable> CHEST_TABLES = register("entities/chest_tables");

	private static ResourceKey<LootTable> register(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, GrimoireOfGaia.modLoc(path));
	}
}
