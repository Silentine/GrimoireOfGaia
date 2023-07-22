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
import net.minecraftforge.registries.RegistryObject;

public class GaiaBlockstates extends BlockStateProvider {
	public GaiaBlockstates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, GrimoireOfGaia.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.generateHorizontal(GaiaRegistry.BUST_GORGON);
		this.generateHorizontal(GaiaRegistry.BUST_MINOTAUR);
		this.generateHorizontal(GaiaRegistry.BUST_SPHINX);
		this.generateHorizontal(GaiaRegistry.BUST_VALKYRIE);
		this.generateHorizontal(GaiaRegistry.BUST_VAMPIRE);
		this.generateHorizontal(GaiaRegistry.DECO_GARDEN_GNOME);
		this.generateHorizontal(GaiaRegistry.DECO_MANDRAGORA_POT);
		this.generateHorizontal(GaiaRegistry.DECO_NEST_HARPY);
		this.generateHorizontal(GaiaRegistry.DOLL_CREEPER_GIRL);
		this.generateHorizontal(GaiaRegistry.DOLL_DRYAD);
		this.generateHorizontal(GaiaRegistry.DOLL_DULLAHAN);
		this.generateHorizontal(GaiaRegistry.DOLL_ENDER_GIRL);
		this.generateHorizontal(GaiaRegistry.DOLL_MAID);
		this.generateHorizontal(GaiaRegistry.DOLL_MERMAID);
		this.generateHorizontal(GaiaRegistry.DOLL_NINE_TAILS);
		this.generateHorizontal(GaiaRegistry.DOLL_SLIME_GIRL);
		this.simpleBlock(GaiaRegistry.PEARL_BLOCK.get(),
				models().getExistingFile(modLoc("block/" + GaiaRegistry.PEARL_BLOCK.getId().getPath())));
	}

	protected void generateHorizontal(RegistryObject<Block> registryObject) {
		ModelFile clusterBlock = models().getExistingFile(modLoc("block/" + registryObject.getId().getPath()));
		getVariantBuilder(registryObject.get())
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
