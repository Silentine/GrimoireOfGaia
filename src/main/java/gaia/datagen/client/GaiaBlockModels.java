package gaia.datagen.client;

import gaia.GrimoireOfGaia;
import gaia.registry.GaiaRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GaiaBlockModels extends BlockModelProvider {
	public GaiaBlockModels(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, GrimoireOfGaia.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		this.cubeBottomTop(GaiaRegistry.PEARL_BLOCK.getId().getPath(),
				modLoc("block/pearl_block_side"), modLoc("block/pearl_block_bottom"), modLoc("block/pearl_block_top"));
	}
}