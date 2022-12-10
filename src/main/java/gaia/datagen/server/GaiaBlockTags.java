package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GaiaBlockTags extends BlockTagsProvider {
	public GaiaBlockTags(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
		super(dataGenerator, GrimoireOfGaia.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(GaiaTags.REQUIRES_BOOK_TAG);
		this.tag(GaiaTags.REQUIRES_CURSED_METAL_TAG);
		this.tag(GaiaTags.GAIA_SPAWABLE_ON).addTags(BlockTags.DIRT, BlockTags.SAND, Tags.Blocks.SANDSTONE, Tags.Blocks.GRAVEL).add(Blocks.SNOW_BLOCK);
	}
}
