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
		public final SpawningInfo antHillSpawning;
		public final SpawningInfo antSalvagerSpawning;
		public final SpawningInfo anubisSpawning;
		public final SpawningInfo arachneSpawning;
		public final SpawningInfo bansheeSpawning;
		public final SpawningInfo beeSpawning;
		public final SpawningInfo behenderSpawning;
		public final SpawningInfo boneKnightSpawning;
		public final SpawningInfo cecaeliaSpawning;
		public final SpawningInfo centaurSpawning;
		public final SpawningInfo cobbleGolemSpawning;
		public final SpawningInfo cobblestoneGolemSpawning;
		public final SpawningInfo creepSpawning;
		public final SpawningInfo cyclopsSpawning;
		public final SpawningInfo deathwordSpawning;
		public final SpawningInfo dryadSpawning;
		public final SpawningInfo dullahanSpawning;
		public final SpawningInfo dwarfSpawning;
		public final SpawningInfo enderDragonGirlSpawning;
		public final SpawningInfo enderEyeSpawning;
		public final SpawningInfo fleshLichSpawning;
		public final SpawningInfo gelatinousSlimeSpawning;
		public final SpawningInfo goblinSpawning;
		public final SpawningInfo gryphonSpawning;
		public final SpawningInfo harpySpawning;
		public final SpawningInfo hunterSpawning;
		public final SpawningInfo koboldSpawning;
		public final SpawningInfo matangoSpawning;
		public final SpawningInfo mermaidSpawning;
		public final SpawningInfo mimicSpawning;
		public final SpawningInfo minotaurusSpawning;
		public final SpawningInfo nagaSpawning;
		public final SpawningInfo nineTailsSpawning;
		public final SpawningInfo oniSpawning;
		public final SpawningInfo orcSpawning;
		public final SpawningInfo satyressSpawning;
		public final SpawningInfo shamanSpawning;
		public final SpawningInfo sharkoSpawning;
		public final SpawningInfo sirenSpawning;
		public final SpawningInfo sludgeGirlSpawning;
		public final SpawningInfo sphinxSpawning;
		public final SpawningInfo sprigganSpawning;
		public final SpawningInfo succubusSpawning;
		public final SpawningInfo toadSpawning;
		public final SpawningInfo valkyrieSpawning;
		public final SpawningInfo werecatSpawning;
		public final SpawningInfo witchSpawning;
		public final SpawningInfo witherCowSpawning;
		public final SpawningInfo wizardHarpySpawning;
		public final SpawningInfo yukiOnnaSpawning;

		Common(ForgeConfigSpec.Builder builder) {
			builder.comment("Spawning settings")
					.push("Spawning");

			List<? extends String> antHillBiomes = generateList(Biomes.DESERT);
			List<? extends String> antHillBiomeDictionary = List.of("OVERWORLD,SANDY,!MESA");
			antHillSpawning = new SpawningInfo(builder, "AntHill", 20, 1, 1, antHillBiomes, antHillBiomeDictionary);

			List<? extends String> antSalvagerBiomes = generateList(Biomes.DESERT);
			List<? extends String> antSalvagerBiomeDictionary = List.of("OVERWORLD,SANDY,!MESA");
			antSalvagerSpawning = new SpawningInfo(builder, "AntSalvager", 20, 2, 5, antSalvagerBiomes, antSalvagerBiomeDictionary);

			List<? extends String> anubisBiomes = generateList(Biomes.DESERT);
			List<? extends String> anubisBiomeDictionary = List.of("OVERWORLD,SANDY,!MESA");
			anubisSpawning = new SpawningInfo(builder, "Anubis", 20, 2, 4, anubisBiomes, anubisBiomeDictionary);

			List<? extends String> arachneBiomeDictionary = List.of("OVERWORLD");
			arachneSpawning = new SpawningInfo(builder, "Arachne", 80, 1, 2, List.of(), arachneBiomeDictionary);

			List<? extends String> bansheeBiomes = generateList(Biomes.MEADOW, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS);
			List<? extends String> bansheeBiomeDictionary = List.of("OVERWORLD,PLATEAU,!COLD,!HOT,!DENSE",
					"OVERWORLD,MOUNTAIN,!HOT,!DENSE");
			bansheeSpawning = new SpawningInfo(builder, "Banshee", 40, 2, 4, bansheeBiomes, bansheeBiomeDictionary);

			List<? extends String> beeBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			List<? extends String> beeBiomeDictionary = List.of("OVERWORLD,FOREST,!CONIFEROUS,!COLD,!HOT,!SPARSE,!SPOOKY,!DENSE",
					"OVERWORLD,FOREST,DENSE,RARE,!CONIFEROUS,!COLD,!HOT,!SPARSE,!SPOOKY");
			beeSpawning = new SpawningInfo(builder, "Bee", 80, 2, 4, beeBiomes, beeBiomeDictionary);

			List<? extends String> behenderBiomeDictionary = List.of("END,COLD,DRY");
			behenderSpawning = new SpawningInfo(builder, "Behender", 1, 1, 1, List.of(), behenderBiomeDictionary, true);

			List<? extends String> boneKnightBiomeDictionary = List.of("OVERWORLD");
			boneKnightSpawning = new SpawningInfo(builder, "BoneKnight", 80, 2, 4, List.of(), boneKnightBiomeDictionary, true);

			List<? extends String> cecaeliaBiomes = generateList(Biomes.BEACH, Biomes.OCEAN, Biomes.WARM_OCEAN, Biomes.RIVER);
			List<? extends String> cecaeliaBiomeDictionary = List.of("OVERWORLD,BEACH", "OVERWORLD,WATER");
			cecaeliaSpawning = new SpawningInfo(builder, "Cecaelia", 80, 4, 6, cecaeliaBiomes, cecaeliaBiomeDictionary);

			List<? extends String> centaurBiomes = generateList(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.BADLANDS, Biomes.ERODED_BADLANDS);
			List<? extends String> centaurBiomeDictionary = List.of(
					"OVERWORLD,PLAINS,!SAVANNA",
					"OVERWORLD,MESA");
			centaurSpawning = new SpawningInfo(builder, "Centaur", 80, 2, 4, centaurBiomes, centaurBiomeDictionary);

			List<? extends String> cobbleGolemBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			List<? extends String> cobbleGolemBiomeDictionary = List.of("OVERWORLD,JUNGLE");
			cobbleGolemSpawning = new SpawningInfo(builder, "CobbleGolem", 60, 2, 4, cobbleGolemBiomes, cobbleGolemBiomeDictionary);

			List<? extends String> cobblestoneGolemBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			List<? extends String> cobblestoneGolemBiomeDictionary = List.of("OVERWORLD,JUNGLE");
			cobblestoneGolemSpawning = new SpawningInfo(builder, "CobblestoneGolem", 60, 2, 4, cobblestoneGolemBiomes, cobblestoneGolemBiomeDictionary);

			List<? extends String> creepBiomeDictionary = List.of("OVERWORLD");
			creepSpawning = new SpawningInfo(builder, "Creep", 20, 4, 6, List.of(), creepBiomeDictionary, true);

			List<? extends String> cyclopsBiomes = generateList(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> cyclopsBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			cyclopsSpawning = new SpawningInfo(builder, "Cyclops", 40, 4, 6, cyclopsBiomes, cyclopsBiomeDictionary);

			List<? extends String> deathwordBiomeDictionary = List.of("OVERWORLD");
			deathwordSpawning = new SpawningInfo(builder, "Deathword", 40, 1, 2, List.of(), deathwordBiomeDictionary, true);

			List<? extends String> dryadBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			List<? extends String> dryadBiomeDictionary = List.of(
					"OVERWORLD,FOREST,!CONIFEROUS,!COLD,!HOT,!SPARSE,SPOOKY,!DENSE",
					"OVERWORLD,FOREST,DENSE,RARE,!CONIFEROUS,!COLD,!HOT,!SPARSE,SPOOKY");
			dryadSpawning = new SpawningInfo(builder, "Dryad", 60, 4, 6, dryadBiomes, dryadBiomeDictionary);

			List<? extends String> dullahanBiomes = generateList(Biomes.MEADOW, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS);
			List<? extends String> dullahanBiomeDictionary = List.of("OVERWORLD,PLATEAU,!COLD,!HOT,!DENSE",
					"OVERWORLD,MOUNTAIN,!HOT,!DENSE");
			dullahanSpawning = new SpawningInfo(builder, "Dullahan", 100, 4, 6, dullahanBiomes, dullahanBiomeDictionary);

			List<? extends String> dwarfBiomes = generateList(Biomes.MEADOW, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS);
			List<? extends String> dwarfBiomeDictionary = List.of("OVERWORLD,PLATEAU,!COLD,!HOT,!DENSE",
					"OVERWORLD,MOUNTAIN,!HOT,!DENSE");
			dwarfSpawning = new SpawningInfo(builder, "Dwarf", 30, 4, 6, dwarfBiomes, dwarfBiomeDictionary);

			List<? extends String> enderEyeBiomeDictionary = List.of("OVERWORLD");
			enderEyeSpawning = new SpawningInfo(builder, "EnderEye", 40, 2, 4, List.of(), enderEyeBiomeDictionary, true);

			List<? extends String> enderDragonGirlBiomeDictionary = List.of("END,COLD,DRY");
			enderDragonGirlSpawning = new SpawningInfo(builder, "EnderDragonGirl", 1, 1, 1, List.of(), enderDragonGirlBiomeDictionary, true);

			List<? extends String> fleshLichBiomeDictionary = List.of("OVERWORLD");
			fleshLichSpawning = new SpawningInfo(builder, "FleshLich", 100, 4, 6, List.of(), fleshLichBiomeDictionary);

			List<? extends String> gelatinousSlimeBiomes = generateList(Biomes.SWAMP);
			List<? extends String> gelatinousSlimeBiomeDictionary = List.of("OVERWORLD,SWAMP");
			gelatinousSlimeSpawning = new SpawningInfo(builder, "GelatinousSlime", 80, 1, 2, gelatinousSlimeBiomes, gelatinousSlimeBiomeDictionary);

			List<? extends String> goblinBiomes = generateList(Biomes.SAVANNA);
			List<? extends String> goblinBiomeDictionary = List.of("OVERWORLD,SAVANNA");
			goblinSpawning = new SpawningInfo(builder, "Goblin", 30, 2, 6, goblinBiomes, goblinBiomeDictionary);

			List<? extends String> gryphonBiomes = generateList(Biomes.MEADOW, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS);
			List<? extends String> gryphonBiomeDictionary = List.of("OVERWORLD,PLATEAU,!COLD,!HOT,!DENSE",
					"OVERWORLD,MOUNTAIN,!HOT,!DENSE");
			gryphonSpawning = new SpawningInfo(builder, "Gryphon", 100, 1, 2, gryphonBiomes, gryphonBiomeDictionary);

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

			List<? extends String> mermaidBiomes = generateList(Biomes.BEACH, Biomes.OCEAN, Biomes.WARM_OCEAN, Biomes.RIVER);
			List<? extends String> mermaidBiomeDictionary = List.of("OVERWORLD,BEACH", "OVERWORLD,WATER");
			mermaidSpawning = new SpawningInfo(builder, "Mermaid", 40, 2, 4, mermaidBiomes, mermaidBiomeDictionary);

			List<? extends String> minotaurusBiomes = generateList(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
			List<? extends String> minotaurusBiomeDictionary = List.of(
					"OVERWORLD,PLAINS,!SAVANNA",
					"OVERWORLD,MESA",
					"OVERWORLD,FOREST,SPOOKY");
			minotaurusSpawning = new SpawningInfo(builder, "Minotaurus", 80, 2, 4, minotaurusBiomes, minotaurusBiomeDictionary);

			List<? extends String> mimicBiomeDictionary = List.of("OVERWORLD");
			mimicSpawning = new SpawningInfo(builder, "Mimic", 40, 1, 1, List.of(), mimicBiomeDictionary, true);

			List<? extends String> nagaBiomes = generateList(Biomes.SWAMP);
			List<? extends String> nagaBiomeDictionary = List.of("OVERWORLD,SWAMP");
			nagaSpawning = new SpawningInfo(builder, "Naga", 60, 4, 6, nagaBiomes, nagaBiomeDictionary);

			List<? extends String> nineTailsBiomes = generateList(Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> nineTailsBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			nineTailsSpawning = new SpawningInfo(builder, "NineTails", 40, 2, 4, nineTailsBiomes, nineTailsBiomeDictionary);

			List<? extends String> oniBiomes = generateList(Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> oniBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			oniSpawning = new SpawningInfo(builder, "Oni", 80, 4, 6, oniBiomes, oniBiomeDictionary);

			List<? extends String> orcBiomes = generateList(Biomes.SAVANNA);
			List<? extends String> orcBiomeDictionary = List.of("OVERWORLD,SAVANNA");
			orcSpawning = new SpawningInfo(builder, "Orc", 80, 2, 6, orcBiomes, orcBiomeDictionary);

			List<? extends String> satyressBiomes = generateList(Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.BADLANDS, Biomes.ERODED_BADLANDS);
			List<? extends String> satyressBiomeDictionary = List.of(
					"OVERWORLD,PLAINS,!SAVANNA",
					"OVERWORLD,MESA");
			satyressSpawning = new SpawningInfo(builder, "Satyress", 20, 2, 4, satyressBiomes, satyressBiomeDictionary);

			List<? extends String> shamanBiomes = generateList(Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE);
			List<? extends String> shamanBiomeDictionary = List.of("OVERWORLD,JUNGLE");
			shamanSpawning = new SpawningInfo(builder, "Shaman", 60, 2, 4, shamanBiomes, shamanBiomeDictionary);

			List<? extends String> sharkoBiomes = generateList(Biomes.BEACH, Biomes.OCEAN, Biomes.WARM_OCEAN, Biomes.RIVER);
			List<? extends String> sharkoBiomeDictionary = List.of("OVERWORLD,BEACH", "OVERWORLD,WATER");
			sharkoSpawning = new SpawningInfo(builder, "Sharko", 40, 2, 4, sharkoBiomes, sharkoBiomeDictionary);

			List<? extends String> sirenBiomes = generateList(Biomes.SWAMP);
			List<? extends String> sirenBiomeDictionary = List.of("OVERWORLD,SWAMP");
			sirenSpawning = new SpawningInfo(builder, "Siren", 60, 4, 6, sirenBiomes, sirenBiomeDictionary);

			List<? extends String> sludgeGirlBiomes = generateList(Biomes.SWAMP);
			List<? extends String> sludgeBiomeDictionary = List.of("OVERWORLD,SWAMP");
			sludgeGirlSpawning = new SpawningInfo(builder, "SludgeGirl", 100, 2, 4, sludgeGirlBiomes, sludgeBiomeDictionary);

			List<? extends String> sphinxBiomes = generateList(Biomes.DESERT);
			List<? extends String> sphinxBiomeDictionary = List.of("OVERWORLD,SANDY,!MESA");
			sphinxSpawning = new SpawningInfo(builder, "Sphinx", 10, 1, 1, sphinxBiomes, sphinxBiomeDictionary);

			List<? extends String> sprigganBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			List<? extends String> sprigganBiomeDictionary = List.of("OVERWORLD,FOREST,!CONIFEROUS,!COLD,!HOT,!SPARSE,!SPOOKY,!DENSE",
					"OVERWORLD,FOREST,DENSE,RARE,!CONIFEROUS,!COLD,!HOT,!SPARSE,!SPOOKY");
			sprigganSpawning = new SpawningInfo(builder, "Spriggan", 40, 2, 4, sprigganBiomes, sprigganBiomeDictionary);

			List<? extends String> succubusBiomes = generateList(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY,
					Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);
			List<? extends String> succubusBiomeDictionary = List.of("NETHER");
			succubusSpawning = new SpawningInfo(builder, "Succubus", 16, 2, 4, succubusBiomes, succubusBiomeDictionary);

			List<? extends String> toadBiomes = generateList(Biomes.DARK_FOREST);
			List<? extends String> toadBiomeDictionary = List.of("OVERWORLD,FOREST,SPOOKY");
			toadSpawning = new SpawningInfo(builder, "Toad", 80, 2, 4, toadBiomes, toadBiomeDictionary);

			List<? extends String> valkyrieBiomes = generateList(Biomes.MEADOW, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS);
			List<? extends String> valkyrieBiomeDictionary = List.of("OVERWORLD,PLATEAU,!COLD,!HOT,!DENSE",
					"OVERWORLD,MOUNTAIN,!HOT,!DENSE");
			valkyrieSpawning = new SpawningInfo(builder, "Valkyrie", 10, 1, 2, valkyrieBiomes, valkyrieBiomeDictionary);

			List<? extends String> werecatBiomes = generateList(Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST);
			List<? extends String> werecatBiomeDictionary = List.of("OVERWORLD,FOREST,!CONIFEROUS,!COLD,!HOT,!SPARSE,!SPOOKY,!DENSE",
					"OVERWORLD,FOREST,DENSE,RARE,!CONIFEROUS,!COLD,!HOT,!SPARSE,!SPOOKY");
			werecatSpawning = new SpawningInfo(builder, "Werecat", 80, 4, 6, werecatBiomes, werecatBiomeDictionary);

			List<? extends String> witchBiomes = generateList(Biomes.DARK_FOREST);
			List<? extends String> witchBiomeDictionary = List.of("OVERWORLD,FOREST,SPOOKY");
			witchSpawning = new SpawningInfo(builder, "Witch", 60, 2, 4, witchBiomes, witchBiomeDictionary);

			List<? extends String> witherCowBiomes = generateList(Biomes.NETHER_WASTES, Biomes.SOUL_SAND_VALLEY,
					Biomes.CRIMSON_FOREST, Biomes.WARPED_FOREST, Biomes.BASALT_DELTAS);
			List<? extends String> witherCowBiomeDictionary = List.of("NETHER");
			witherCowSpawning = new SpawningInfo(builder, "WitherCow", 12, 2, 4, witherCowBiomes, witherCowBiomeDictionary);

			List<? extends String> wizardHarpyBiomes = generateList(Biomes.DARK_FOREST);
			List<? extends String> wizardHarpyBiomeDictionary = List.of("OVERWORLD,FOREST,SPOOKY");
			wizardHarpySpawning = new SpawningInfo(builder, "WizardHarpy", 60, 1, 2, wizardHarpyBiomes, wizardHarpyBiomeDictionary);

			List<? extends String> yukiOnnaBiomes = generateList(Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA);
			List<? extends String> yukiOnnaBiomeDictionary = List.of("OVERWORLD,FOREST,CONIFEROUS,!SNOWY");
			yukiOnnaSpawning = new SpawningInfo(builder, "YukiOnna", 60, 2, 4, yukiOnnaBiomes, yukiOnnaBiomeDictionary);

			builder.pop();
		}
	}

	@SafeVarargs
	public static List<String> generateList(ResourceKey<Biome>... biomes) {
		List<String> list = new ArrayList<>();
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
