package gaia.config;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class GaiaSpawningConfig {

	public static class Common {
		public final SpawningInfo anubisSpawning;
		public final SpawningInfo centaurSpawning;
		public final SpawningInfo creepSpawning;
		public final SpawningInfo cyclopsSpawning;
		public final SpawningInfo dryadSpawning;
		public final SpawningInfo dullahanSpawning;
		public final SpawningInfo harpySpawning;
		public final SpawningInfo hunterSpawning;
		public final SpawningInfo koboldSpawning;
		public final SpawningInfo matangoSpawning;
		public final SpawningInfo nineTailsSpawning;
		public final SpawningInfo shamanSpawning;
		public final SpawningInfo sirenSpawning;
		public final SpawningInfo sludgeGirlSpawning;
		public final SpawningInfo succubusSpawning;
		public final SpawningInfo werecatSpawning;
		public final SpawningInfo yukiOnnaSpawning;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("Spawning settings")
					.push("Spawning");

			List<? extends String> anubisBiomes = generateList(Biomes.DESERT);
			List<? extends String> anubisBiomeDictionary = List.of("OVERWORLD,PLAINS,!SAVANNA", "OVERWORLD,MESA");
			anubisSpawning = new SpawningInfo(builder, "Anubis", 80, 2, 4, anubisBiomes, anubisBiomeDictionary);

			List<? extends String> centaurBiomes = generateList(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.BADLANDS, Biomes.ERODED_BADLANDS);
			List<? extends String> centaurBiomeDictionary = List.of(
					"OVERWORLD,SANDY,!MESA",
					"OVERWORLD,MESA");
			centaurSpawning = new SpawningInfo(builder, "Centaur", 80, 2, 4, centaurBiomes, centaurBiomeDictionary);

			List<? extends String> creepBiomeDictionary = List.of("OVERWORLD");
			creepSpawning = new SpawningInfo(builder, "Creep", 20, 4, 6, List.of(), creepBiomeDictionary, true);

			List<? extends String> cyclopsBiomes = generateList(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> cyclopsBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			cyclopsSpawning = new SpawningInfo(builder, "Cyclops", 40, 4, 6, cyclopsBiomes, cyclopsBiomeDictionary);

			List<? extends String> dryadBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			List<? extends String> dryadBiomeDictionary = List.of(
					"OVERWORLD,FOREST,!CONIFEROUS,!COLD,!HOT,!SPARSE,SPOOKY,!DENSE",
					"OVERWORLD,FOREST,DENSE,RARE,!CONIFEROUS,!COLD,!HOT,!SPARSE,SPOOKY");
			dryadSpawning = new SpawningInfo(builder, "Dryad", 60, 4, 6, dryadBiomes, dryadBiomeDictionary);

			List<? extends String> dullahanBiomes = generateList(Biomes.MEADOW);
			List<? extends String> dullahanBiomeDictionary = List.of("OVERWORLD,PLATEAU,!COLD,!HOT");
			dullahanSpawning = new SpawningInfo(builder, "Dullahan", 100, 4, 6, dullahanBiomes, dullahanBiomeDictionary);

			List<? extends String> harpyBiomes = generateList(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
			List<? extends String> harpyBiomeDictionary = List.of(
					"OVERWORLD,PLAINS,!SAVANNA",
					"OVERWORLD,MESA",
					"OVERWORLD,FOREST,SPOOKY");
			harpySpawning = new SpawningInfo(builder, "Harpy", 100, 2, 4, harpyBiomes, harpyBiomeDictionary);

			List<? extends String> hunterBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			List<? extends String> hunterBiomeDictionary = List.of("OVERWORLD,JUNGLE");
			hunterSpawning = new SpawningInfo(builder, "Hunter", 60, 2, 4, hunterBiomes, hunterBiomeDictionary);

			List<? extends String> koboldBiomes = generateList(Biomes.SNOWY_PLAINS, Biomes.SNOWY_SLOPES);
			List<? extends String> koboldBiomeDictionary = List.of("OVERWORLD,SNOWY,!OCEAN,!RIVER,!BEACH,!FOREST");
			koboldSpawning = new SpawningInfo(builder, "Kobold", 60, 4, 6, koboldBiomes, koboldBiomeDictionary);

			List<? extends String> matangoBiomes = generateList(Biomes.DARK_FOREST);
			List<? extends String> matangoBiomeDictionary = List.of("OVERWORLD,FOREST,SPOOKY");
			matangoSpawning = new SpawningInfo(builder, "Matango", 60, 2, 4, matangoBiomes, matangoBiomeDictionary);

			List<? extends String> nineTailsBiomes = generateList(Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> nineTailsBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			nineTailsSpawning = new SpawningInfo(builder, "NineTails", 40, 2, 4, nineTailsBiomes, nineTailsBiomeDictionary);

			List<? extends String> shamanBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			List<? extends String> shamanBiomeDictionary = List.of("OVERWORLD,JUNGLE");
			shamanSpawning = new SpawningInfo(builder, "Shaman", 60, 2, 4, shamanBiomes, shamanBiomeDictionary);

			List<? extends String> sirenBiomes = generateList(Biomes.SWAMP);
			List<? extends String> sirenBiomeDictionary = List.of("OVERWORLD,SWAMP");
			sirenSpawning = new SpawningInfo(builder, "Siren", 60, 4, 6, sirenBiomes, sirenBiomeDictionary);

			List<? extends String> sludgeGirlBiomes = generateList(Biomes.SWAMP);
			List<? extends String> sludgeBiomeDictionary = List.of("OVERWORLD,SWAMP");
			sludgeGirlSpawning = new SpawningInfo(builder, "SludgeGirl", 100, 2, 4, sludgeGirlBiomes, sludgeBiomeDictionary);

			List<? extends String> succubusBiomes = generateList(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY,
					Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);
			List<? extends String> succubusBiomeDictionary = List.of("NETHER");
			succubusSpawning = new SpawningInfo(builder, "Succubus", 16, 2, 4, succubusBiomes, succubusBiomeDictionary);

			List<? extends String> werecatBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			List<? extends String> werecatBiomeDictionary = List.of("OVERWORLD,BEACH,!MUSHROOM");
			werecatSpawning = new SpawningInfo(builder, "Werecat", 80, 4, 6, werecatBiomes, werecatBiomeDictionary);

			List<? extends String> yukiOnnaBiomes = generateList(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> yukiOnnaBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			yukiOnnaSpawning = new SpawningInfo(builder, "YukiOnna", 60, 2, 4, yukiOnnaBiomes, yukiOnnaBiomeDictionary);

			builder.pop();
		}
	}

	public static List<String> generateList(ResourceKey<Biome>... biomes) {
		List<String> list = new ArrayList();
		for (ResourceKey<Biome> biome : biomes) {
			list.add(biome.location().toString());
		}
		return list;
	}

	public static final ForgeConfigSpec commonSpec;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		commonSpec = specPair.getRight();
		COMMON = specPair.getLeft();
	}
}
