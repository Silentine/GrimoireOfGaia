package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class GaiaBlockTags extends BlockTagsProvider {
	public GaiaBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(packOutput, lookupProvider, GrimoireOfGaia.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(GaiaTags.REQUIRES_BOOK_TAG);
		this.tag(GaiaTags.REQUIRES_CURSED_METAL_TAG);
		this.tag(GaiaTags.GAIA_SPAWABLE_ON).addTags(BlockTags.DIRT, BlockTags.SAND, Tags.Blocks.SANDSTONE, Tags.Blocks.GRAVEL).add(Blocks.SNOW_BLOCK);
		this.tag(GaiaTags.FLOWER_SPAWNABLE_ON).addTags(BlockTags.DIRT);
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(GaiaRegistry.PEARL_BLOCK.get());
	}
}
