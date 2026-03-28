package gaia.registry;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;

public class GaiaTiers {

	public static final ToolMaterial BOOK = new ToolMaterial(GaiaTags.INCORRECT_FOR_BOOK_TOOL,
			780, 6.0F, 2.0F, 22, ItemTags.WOODEN_TOOL_MATERIALS); //TODO: MAKE TAG FOR REPAIR! WITH JUST THE QUILL IN IT

	public static final ToolMaterial CURSED_METAL = new ToolMaterial(GaiaTags.INCORRECT_FOR_BOOK_TOOL,
			300, 5.0F, 1.0F, 16, ItemTags.WOODEN_TOOL_MATERIALS); //TODO: MAKE TAG FOR REPAIR! WITH JUST OBISIDIANS TAG IN IT
}
