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
			anubisSpawning = new SpawningInfo(builder, "Anubis", 80, 2, 4, anubisBiomes);

			List<? extends String> centaurBiomes = generateList(Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.WINDSWEPT_SAVANNA);
			centaurSpawning = new SpawningInfo(builder, "Centaur", 80, 2, 4, centaurBiomes);

			List<? extends String> creepBiomes = generateList(Biomes.NETHER_WASTES, Biomes.THE_END, Biomes.SMALL_END_ISLANDS,
					Biomes.END_BARRENS, Biomes.END_HIGHLANDS, Biomes.END_MIDLANDS, Biomes.MUSHROOM_FIELDS, Biomes.NETHER_WASTES,
					Biomes.SOUL_SAND_VALLEY, Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);
			creepSpawning = new SpawningInfo(builder, "Creep", 20, 4, 6, creepBiomes, true);

			List<? extends String> cyclopsBiomes = generateList(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			cyclopsSpawning = new SpawningInfo(builder, "Cyclops", 40, 4, 6, cyclopsBiomes);

			List<? extends String> dryadBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			dryadSpawning = new SpawningInfo(builder, "Dryad", 60, 4, 6, dryadBiomes);

			List<? extends String> dullahanBiomes = generateList(Biomes.MEADOW);
			dullahanSpawning = new SpawningInfo(builder, "Dullahan", 100, 4, 6, dullahanBiomes);

			List<? extends String> harpyBiomes = generateList(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
			harpySpawning = new SpawningInfo(builder, "Harpy", 100, 2, 4, harpyBiomes);

			List<? extends String> hunterBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			hunterSpawning = new SpawningInfo(builder, "Hunter", 60, 2, 4, hunterBiomes);

			List<? extends String> koboldBiomes = generateList(Biomes.SNOWY_PLAINS, Biomes.SNOWY_SLOPES);
			koboldSpawning = new SpawningInfo(builder, "Kobold", 60, 4, 6, koboldBiomes);

			List<? extends String> matangoBiomes = generateList(Biomes.DARK_FOREST);
			matangoSpawning = new SpawningInfo(builder, "Matango", 60, 2, 4, matangoBiomes);

			List<? extends String> nineTailsBiomes = generateList(Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			nineTailsSpawning = new SpawningInfo(builder, "NineTails", 40, 2, 4, nineTailsBiomes);

			List<? extends String> shamanBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			shamanSpawning = new SpawningInfo(builder, "Shaman", 60, 2, 4, shamanBiomes);

			List<? extends String> sirenBiomes = generateList(Biomes.SWAMP);
			sirenSpawning = new SpawningInfo(builder, "Siren", 60, 4, 6, sirenBiomes);

			List<? extends String> sludgeGirlBiomes = generateList(Biomes.SWAMP);
			sludgeGirlSpawning = new SpawningInfo(builder, "SludgeGirl", 100, 2, 4, sludgeGirlBiomes);

			List<? extends String> succubusBiomes = generateList(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY,
					Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);
			succubusSpawning = new SpawningInfo(builder, "Succubus", 16, 2, 4, succubusBiomes);

			List<? extends String> werecatBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			werecatSpawning = new SpawningInfo(builder, "Werecat", 80, 4, 6, werecatBiomes);

			List<? extends String> yukiOnnaBiomes = generateList(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			yukiOnnaSpawning = new SpawningInfo(builder, "YukiOnna", 60, 2, 4, yukiOnnaBiomes);

			builder.pop();
		}
	}

	public static List<? extends String> generateList(ResourceKey<Biome>... biomes) {
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
