package gaia.registry;

import gaia.GrimoireOfGaia;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GaiaTags {
	public static final TagKey<Item> DIMENSIONAL_BOXES = ItemTags.create(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "dimensional_boxes"));
	public static final TagKey<Item> GOLDEN_TOOLS = ItemTags.create(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "golden_tools"));
	public static final TagKey<Block> INCORRECT_FOR_BOOK_TOOL = BlockTags.create(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "incorrect_for_book_tool"));
	public static final TagKey<Block> INCORRECT_FOR_CURSED_METAL_TOOL = BlockTags.create(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "incorrect_for_cursed_metal_tool"));
	public static final TagKey<Block> GAIA_SPAWABLE_ON = BlockTags.create(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "gaia_spawnable_on"));
	public static final TagKey<Block> FLOWER_SPAWNABLE_ON = BlockTags.create(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "flower_spawnable_on"));

	public static final TagKey<Item> RECORDS = ItemTags.create(Identifier.fromNamespaceAndPath("c", "records"));
	public static final TagKey<Item> NUGGETS_DIAMOND = ItemTags.create(Identifier.fromNamespaceAndPath("c", "nuggets/diamond"));
	public static final TagKey<Item> NUGGETS_EMERALD = ItemTags.create(Identifier.fromNamespaceAndPath("c", "nuggets/emerald"));
}
