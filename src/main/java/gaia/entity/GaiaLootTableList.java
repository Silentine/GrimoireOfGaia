package gaia.entity;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class GaiaLootTableList {
	private GaiaLootTableList() {}

	public static final ResourceLocation BAG_ARROW = register("loot_table_bagarrow");
	public static final ResourceLocation BOXES_IRON = register("loot_table_boxiron");
	public static final ResourceLocation BOXES_GOLD = register("loot_table_boxgold");
	public static final ResourceLocation BOXES_DIAMOND = register("loot_table_boxdiamond");
	public static final ResourceLocation BOXES_OVERWORLD = register("loot_table_box");
	public static final ResourceLocation BOXES_NETHER = register("loot_table_boxnether");
	public static final ResourceLocation BOXES_END = register("loot_table_boxend");
	public static final ResourceLocation BOXES_OLD = register("loot_table_boxold");

	private static ResourceLocation register(String id) {
		return LootTableList.register(new ResourceLocation(GaiaReference.MOD_ID, id));
	}
}
