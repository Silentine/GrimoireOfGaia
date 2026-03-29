package gaia.datagen.server;

import gaia.registry.GaiaRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class GaiaDatamapProvider extends DataMapProvider {

	public GaiaDatamapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(packOutput, lookupProvider);
	}

	@Override
	protected void gather(HolderLookup.Provider provider) {
		final var fuels = builder(NeoForgeDataMaps.FURNACE_FUELS);

		fuels.add(GaiaRegistry.FIRESHARD, new FurnaceFuel(20000), false);
		fuels.add(GaiaRegistry.GIGA_GEAR, new FurnaceFuel(1240000), false);
		fuels.add(GaiaRegistry.STONE_COAL, new FurnaceFuel(3600), false);
		fuels.add(GaiaRegistry.SOULFIRE, new FurnaceFuel(11600), false);
	}
}
