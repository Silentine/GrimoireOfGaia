package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GaiaTags {
	public static final TagKey<Item> DIMENSIONAL_BOXES = ItemTags.create(GrimoireOfGaia.modLoc("dimensional_boxes"));
	public static final TagKey<Item> GOLDEN_TOOLS = ItemTags.create(GrimoireOfGaia.modLoc("golden_tools"));
	public static final TagKey<Block> INCORRECT_FOR_BOOK_TOOL = BlockTags.create(GrimoireOfGaia.modLoc("incorrect_for_book_tool"));
	public static final TagKey<Block> INCORRECT_FOR_CURSED_METAL_TOOL = BlockTags.create(GrimoireOfGaia.modLoc("incorrect_for_cursed_metal_tool"));
	public static final TagKey<Block> GAIA_SPAWABLE_ON = BlockTags.create(GrimoireOfGaia.modLoc("gaia_spawnable_on"));
	public static final TagKey<Block> FLOWER_SPAWNABLE_ON = BlockTags.create(GrimoireOfGaia.modLoc("flower_spawnable_on"));

	public static final TagKey<Item> RECORDS = ItemTags.create(Identifier.fromNamespaceAndPath("c", "records"));
	public static final TagKey<Item> NUGGETS_DIAMOND = ItemTags.create(Identifier.fromNamespaceAndPath("c", "nuggets/diamond"));
	public static final TagKey<Item> NUGGETS_EMERALD = ItemTags.create(Identifier.fromNamespaceAndPath("c", "nuggets/emerald"));
	public static final TagKey<Item> BOOK_REPAIR_ITEMS = ItemTags.create(GrimoireOfGaia.modLoc("book_repair_items"));
	public static final TagKey<Item> CURSED_METAL_REPAIR_ITEMS = ItemTags.create(GrimoireOfGaia.modLoc("cursed_metal_repair_items"));
}
