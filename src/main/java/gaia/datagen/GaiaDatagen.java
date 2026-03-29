package gaia.datagen;

import gaia.GrimoireOfGaia;
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
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber
public class GaiaDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = CompletableFuture.supplyAsync(() -> GaiaDatagen.getProvider().full());

		generator.addProvider(true, new GaiaAdvancementProvider(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaRecipes.Runner(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaLoot(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaBlockTags(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaItemTags(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaEntityTags(packOutput, lookupProvider));
		generator.addProvider(true, new GaiaDatamapProvider(packOutput, lookupProvider));

		generator.addProvider(true, new DatapackBuiltinEntriesProvider(
				packOutput, CompletableFuture.supplyAsync(GaiaDatagen::getProvider), Set.of(GrimoireOfGaia.MOD_ID)));

		generator.addProvider(true, new GaiaLanguage(packOutput));
		generator.addProvider(true, new GaiaSoundProvider(packOutput));
		generator.addProvider(true, new GaiaModels(packOutput));
		if (ModList.get().isLoaded("patchouli"))
			generator.addProvider(true, new gaia.datagen.client.compat.GaiaPatchouliProvider(packOutput, lookupProvider));
		
	}

	private static RegistrySetBuilder.PatchedRegistries getProvider() {
		final RegistrySetBuilder registryBuilder = new RegistrySetBuilder();
		registryBuilder.add(Registries.CONFIGURED_FEATURE, context -> {
		});
		registryBuilder.add(Registries.PLACED_FEATURE, context -> {
		});
		registryBuilder.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GaiaBiomeModifiers::bootstrap);
		// We need the BIOME registry to be present ,so we can use a biome tag, doesn't matter that it's empty
		RegistryAccess.Frozen regAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
		Cloner.Factory cloner$factory = new Cloner.Factory();
		net.neoforged.neoforge.registries.DataPackRegistriesHooks.getDataPackRegistriesWithDimensions().forEach(data -> data.runWithArguments(cloner$factory::addCodec));
		return registryBuilder.buildPatch(regAccess, VanillaRegistries.createLookup(), cloner$factory);
	}
}
