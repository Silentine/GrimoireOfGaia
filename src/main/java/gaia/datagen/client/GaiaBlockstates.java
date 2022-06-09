package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GaiaBlockstates extends BlockStateProvider {
	public GaiaBlockstates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, GrimoireOfGaia.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.generateHorizontal(GaiaRegistry.BUST_GORGON.get());
		this.generateHorizontal(GaiaRegistry.BUST_MINOTAUR.get());
		this.generateHorizontal(GaiaRegistry.BUST_SPHINX.get());
		this.generateHorizontal(GaiaRegistry.BUST_VALKYRIE.get());
		this.generateHorizontal(GaiaRegistry.BUST_VAMPIRE.get());
		this.generateHorizontal(GaiaRegistry.DECO_GARDEN_GNOME.get());
		this.generateHorizontal(GaiaRegistry.DECO_MANDRAGORA_POT.get());
		this.generateHorizontal(GaiaRegistry.DECO_NEST_HARPY.get());
		this.generateHorizontal(GaiaRegistry.DOLL_CREEPER_GIRL.get());
		this.generateHorizontal(GaiaRegistry.DOLL_DRYAD.get());
		this.generateHorizontal(GaiaRegistry.DOLL_DULLAHAN.get());
		this.generateHorizontal(GaiaRegistry.DOLL_ENDER_GIRL.get());
		this.generateHorizontal(GaiaRegistry.DOLL_MAID.get());
		this.generateHorizontal(GaiaRegistry.DOLL_MERMAID.get());
		this.generateHorizontal(GaiaRegistry.DOLL_NINE_TAILS.get());
		this.generateHorizontal(GaiaRegistry.DOLL_SLIME_GIRL.get());
	}

	protected void generateHorizontal(Block block) {
		ModelFile clusterBlock = models().getExistingFile(modLoc("block/" + block.getRegistryName().getPath()));
		getVariantBuilder(block)
				.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
				.modelForState().modelFile(clusterBlock).rotationY(180).addModel()
				.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
				.modelForState().modelFile(clusterBlock).addModel()
				.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
				.modelForState().modelFile(clusterBlock).rotationY(90).addModel()
				.partialState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
				.modelForState().modelFile(clusterBlock).rotationY(270).addModel();
	}
}
