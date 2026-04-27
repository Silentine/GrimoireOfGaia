package gaia.datagen;

import gaia.datagen.client.GaiaLanguage;
import gaia.datagen.client.GaiaModels;
import gaia.datagen.client.GaiaSoundProvider;
import gaia.datagen.server.GaiaAdvancementProvider;
import gaia.datagen.server.GaiaBiomeModifiers;
import gaia.datagen.server.GaiaBlockTags;
import gaia.datagen.server.GaiaDatamapProvider;
import gaia.datagen.server.GaiaEntityTags;
import gaia.datagen.server.GaiaItemTags;
import gaia.datagen.server.GaiaLoot;
import gaia.datagen.server.GaiaRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class GaiaDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		event.createDatapackRegistryObjects(BUILDER);
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		generator.addProvider(true, new GaiaAdvancementProvider(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaRecipes.Runner(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaLoot(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaBlockTags(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaItemTags(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaEntityTags(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaDatamapProvider(packOutput, lookupProvider));

		generator.addProvider(true, new GaiaLanguage(packOutput));
		generator.addProvider(true, new GaiaSoundProvider(packOutput));
		generator.addProvider(true, new GaiaModels(packOutput));
		if (ModList.get().isLoaded("patchouli"))
			generator.addProvider(true, new gaia.datagen.client.compat.GaiaPatchouliProvider(packOutput, lookupProvider));
		
	}

	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GaiaBiomeModifiers::bootstrap);
}
