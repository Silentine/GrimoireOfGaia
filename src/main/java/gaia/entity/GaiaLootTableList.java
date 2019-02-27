package gaia.entity;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class GaiaLootTableList {
	private GaiaLootTableList() {}

	public static final ResourceLocation BAG_ARROW = register("lootbox/bag_arrow");
	public static final ResourceLocation BOXES_IRON = register("lootbox/box_iron");
	public static final ResourceLocation BOXES_GOLD = register("lootbox/box_gold");
	public static final ResourceLocation BOXES_DIAMOND = register("lootbox/box_diamond");
	public static final ResourceLocation BOXES_OVERWORLD = register("lootbox/box");
	public static final ResourceLocation BOXES_NETHER = register("lootbox/box_nether");
	public static final ResourceLocation BOXES_END = register("lootbox/box_end");
	public static final ResourceLocation BOXES_OLD = register("lootbox/box_old");

	private static ResourceLocation register(String id) {
		return LootTableList.register(new ResourceLocation(GaiaReference.MOD_ID, id));
	}
}
