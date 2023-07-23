package gaia.datagen;

import gaia.GrimoireOfGaia;
import gaia.datagen.client.GaiaBlockModels;
import gaia.datagen.client.GaiaBlockstates;
import gaia.datagen.client.GaiaItemModels;
import gaia.datagen.client.GaiaLanguage;
import gaia.datagen.client.GaiaSoundProvider;
import gaia.datagen.client.compat.GaiaPatchouliProvider;
import gaia.datagen.server.GaiaAdvancementProvider;
import gaia.datagen.server.GaiaBiomeModifiers;
import gaia.datagen.server.GaiaBlockTags;
import gaia.datagen.server.GaiaEntityTags;
import gaia.datagen.server.GaiaItemTags;
import gaia.datagen.server.GaiaLoot;
import gaia.datagen.server.GaiaRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GaiaDatagen {
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput packOutput = generator.getPackOutput();
		CompletableFuture<HolderLookup.Provider> lookupProvider = CompletableFuture.supplyAsync(GaiaDatagen::getProvider);
		ExistingFileHelper helper = event.getExistingFileHelper();

		if (event.includeServer()) {
			generator.addProvider(true, new GaiaAdvancementProvider(packOutput, lookupProvider, helper));
			generator.addProvider(true, new GaiaRecipes(packOutput));
			generator.addProvider(true, new GaiaLoot(packOutput));
			BlockTagsProvider blockTagsProvider;
			generator.addProvider(true, blockTagsProvider = new GaiaBlockTags(packOutput, lookupProvider, helper));
			generator.addProvider(true, new GaiaItemTags(packOutput, lookupProvider, blockTagsProvider, helper));
			generator.addProvider(true, new GaiaEntityTags(packOutput, lookupProvider, helper));

			generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(
					packOutput, lookupProvider, Set.of(GrimoireOfGaia.MOD_ID)));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new GaiaLanguage(packOutput));
			generator.addProvider(true, new GaiaSoundProvider(packOutput, helper));
			generator.addProvider(true, new GaiaBlockModels(packOutput, helper));
			generator.addProvider(true, new GaiaItemModels(packOutput, helper));
			generator.addProvider(true, new GaiaBlockstates(packOutput, helper));
			if (ModList.get().isLoaded("patchouli"))
				generator.addProvider(true, new GaiaPatchouliProvider(packOutput));
		}
	}

	private static HolderLookup.Provider getProvider() {
		final RegistrySetBuilder registryBuilder = new RegistrySetBuilder();
		registryBuilder.add(Registries.CONFIGURED_FEATURE, context -> {
		});
		registryBuilder.add(Registries.PLACED_FEATURE, context -> {
		});
		registryBuilder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, GaiaBiomeModifiers::bootstrap);
		// We need the BIOME registry to be present so we can use a biome tag, doesn't matter that it's empty
		registryBuilder.add(Registries.BIOME, context -> {
		});
		RegistryAccess.Frozen regAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
		return registryBuilder.buildPatch(regAccess, VanillaRegistries.createLookup());
	}
}
