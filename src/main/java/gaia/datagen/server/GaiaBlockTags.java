package gaia.datagen.server;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import gaia.registry.GaiaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class GaiaBlockTags extends BlockTagsProvider {
	public GaiaBlockTags(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider, GrimoireOfGaia.MOD_ID);
	}

	@Override
	protected void addTags(HolderLookup.Provider provider) {
		this.tag(GaiaTags.INCORRECT_FOR_BOOK_TOOL).addTag(BlockTags.INCORRECT_FOR_WOODEN_TOOL);
		this.tag(GaiaTags.INCORRECT_FOR_CURSED_METAL_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL);
		this.tag(GaiaTags.GAIA_SPAWABLE_ON).addTags(BlockTags.DIRT, BlockTags.SAND, Tags.Blocks.SANDSTONE_BLOCKS, Tags.Blocks.GRAVELS).add(Blocks.SNOW_BLOCK.builtInRegistryHolder().key());
		this.tag(GaiaTags.FLOWER_SPAWNABLE_ON).addTags(BlockTags.DIRT);
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(GaiaRegistry.PEARL_BLOCK.getKey());
	}
}
