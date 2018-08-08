package gaia.init;

import com.google.common.collect.ImmutableSet;
import gaia.Gaia;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaMummy;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyress;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static gaia.GaiaConfig.general;

/**
 * Streamlined Spawning Registry, Tried to keep structure as similar, but
 * cleaned up methods and repetitive code to save time and fingers.
 */
public class GaiaSpawning {
	private GaiaSpawning() {}

	/**
	 * Bridge Method for simpler spawning registry
	 */
	public static void add(int weight, Class<? extends EntityLiving> entityclassIn, int groupCountMin, int groupCountMax, Biome biome) {
		if (weight > 0) {
			biome.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(entityclassIn, weight, groupCountMin, groupCountMax));
		}
	}

	/**
	 * Underground Creature Roster
	 */
	private static void underground(Biome biome) {
		add(general.spawnCreep, EntityGaiaCreep.class, 2, 4, biome);
		add(general.spawnEnderEye, EntityGaiaEnderEye.class, 2, 4, biome);
		add(general.spawnArachne, EntityGaiaArachne.class, 1, 2, biome);
		add(general.spawnMimic, EntityGaiaPropChestMimic.class, 1, 2, biome);
		add(general.spawnBoneKnight, EntityGaiaBoneKnight.class, 1, 2, biome);
		add(general.spawnFleshLich, EntityGaiaFleshLich.class, 1, 2, biome);
	}

	// Water based mobs
	private static void aquatic(Biome biome) {
		add(general.spawnSahuagin, EntityGaiaSahuagin.class, 4, 6, biome);
		add(general.spawnMermaid, EntityGaiaMermaid.class, 2, 4, biome);
		add(general.spawnSharko, EntityGaiaSharko.class, 2, 4, biome);
	}

	/**
	 * Register Mobs based on Biome sub Types
	 */
	public static void register() {
		Map<Type, Set<Biome>> biomeMap = buildBiomeListByType();

		addForestSpawns(biomeMap);
		addSandySpawns(biomeMap);
		addPlainsSpawns(biomeMap);
		addSwampSpawns(biomeMap);
		addJungleSpawns(biomeMap);
		addSnowySpawns(biomeMap);
		addMountainSpawns(biomeMap);
		addWaterSpawns(biomeMap);
		addBeachSpawns(biomeMap);
		addNetherSpawns(biomeMap);
		addEndSpawns(biomeMap);
	}

	private static void addEndSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.END)) {
			if (BiomeDictionary.hasType(biome, Type.COLD) && (BiomeDictionary.hasType(biome, Type.DRY))) {
				add(general.spawnEnderDragonGirl, EntityGaiaEnderDragonGirl.class, 1, 2, biome);
			}
		}
	}

	private static void addNetherSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.NETHER)) {
			add(general.spawnSuccubus, EntityGaiaSuccubus.class, 2, 4, biome);
			add(general.spawnWitherCow, EntityGaiaWitherCow.class, 1, 2, biome);
			add(general.spawnBaphomet, EntityGaiaBaphomet.class, 1, 2, biome);
		}
	}

	private static void addBeachSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.BEACH)) {
			aquatic(biome);
		}
	}

	private static void addWaterSpawns(Map<Type, Set<Biome>> biomeMap) {
		Set<Biome> water = new ImmutableSet.Builder<Biome>().addAll(biomeMap.get(Type.OCEAN)).addAll(biomeMap.get(Type.RIVER)).build();
		for (Biome biome : water) {
			aquatic(biome);
		}
	}

	private static void addMountainSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.MOUNTAIN)) {
			if (!BiomeDictionary.hasType(biome, Type.SNOWY)) {
				add(general.spawnGryphon, EntityGaiaGryphon.class, 1, 2, biome);
				add(general.spawnDwarf, EntityGaiaDwarf.class, 4, 6, biome);

				if (!general.spawnLevel3) {
					add(general.spawnValkyrie, EntityGaiaValkyrie.class, 1, 2, biome);
				}

				add(general.spawnDullahan, EntityGaiaDullahan.class, 4, 6, biome);
				add(general.spawnBanshee, EntityGaiaBanshee.class, 2, 4, biome);

				underground(biome);
			}
		}
	}

	private static void addSnowySpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.SNOWY)) {
			if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) && !BiomeDictionary.hasType(biome, Type.FOREST) &&
					!BiomeDictionary.hasType(biome, Type.OCEAN) && !BiomeDictionary.hasType(biome, Type.RIVER) &&
					!BiomeDictionary.hasType(biome, Type.BEACH)) {
				add(general.spawnSelkie, EntityGaiaSelkie.class, 2, 4, biome);
				add(general.spawnKobold, EntityGaiaKobold.class, 4, 6, biome);
				add(general.spawnYeti, EntityGaiaYeti.class, 2, 4, biome);

				underground(biome);
			}
		}
	}

	private static void addJungleSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.JUNGLE)) {
			add(general.spawnCobbleGolem, EntityGaiaCobbleGolem.class, 2, 4, biome);
			add(general.spawnHunter, EntityGaiaHunter.class, 2, 4, biome);
			add(general.spawnShaman, EntityGaiaShaman.class, 2, 4, biome);
			add(general.spawnCobblestoneGolem, EntityGaiaCobblestoneGolem.class, 2, 4, biome);

			underground(biome);
		}
	}

	private static void addSwampSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.SWAMP)) {
			add(general.spawnSiren, EntityGaiaSiren.class, 4, 6, biome);
			add(general.spawnSludgeGirl, EntityGaiaSludgeGirl.class, 2, 4, biome);
			add(general.spawnNaga, EntityGaiaNaga.class, 1, 2, biome);

			underground(biome);
		}
	}

	private static void addPlainsSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.PLAINS)) {
			add(general.spawnSatyress, EntityGaiaSatyress.class, 2, 4, biome);
			add(general.spawnCentaur, EntityGaiaCentaur.class, 4, 6, biome);
			add(general.spawnHarpy, EntityGaiaHarpy.class, 2, 4, biome);
			add(general.spawnMinotaurus, EntityGaiaMinotaurus.class, 2, 4, biome);

			if (!general.spawnLevel3) {
				add(general.spawnMinotaur, EntityGaiaMinotaur.class, 1, 2, biome);
			}

			underground(biome);
		}
	}

	private static void addSandySpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.SANDY)) {
			add(general.spawnAnt, EntityGaiaAnt.class, 2, 4, biome);
			add(general.spawnMummy, EntityGaiaMummy.class, 2, 4, biome);
			add(general.spawnAnubis, EntityGaiaAnubis.class, 2, 4, biome);

			if (!general.spawnLevel3) {
				add(general.spawnSphinx, EntityGaiaSphinx.class, 1, 2, biome);
			}

			underground(biome);
		}
	}

	private static void addForestSpawns(Map<Type, Set<Biome>> biomeMap) {
		for (Biome biome : biomeMap.get(Type.FOREST)) {
			// forest, forestHills, birchForest, birchForestHills
			if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) && !BiomeDictionary.hasType(biome, Type.SNOWY) &&
					!BiomeDictionary.hasType(biome, Type.MOUNTAIN) && !BiomeDictionary.hasType(biome, Type.SPOOKY) &&
					!BiomeDictionary.hasType(biome, Type.MAGICAL)) {
				add(general.spawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, biome);
				add(general.spawnDryad, EntityGaiaDryad.class, 4, 6, biome);
				add(general.spawnWerecat, EntityGaiaWerecat.class, 4, 6, biome);
				add(general.spawnSpriggan, EntityGaiaSpriggan.class, 2, 4, biome);

				underground(biome);
			}

			// taiga, taigaHills, megaTaiga, megaTaigaHills
			if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (!BiomeDictionary.hasType(biome, Type.SNOWY))) {
				add(general.spawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, biome);
				add(general.spawnCyclops, EntityGaiaCyclops.class, 4, 6, biome);
				add(general.spawnYukiOnna, EntityGaiaYukiOnna.class, 2, 4, biome);
				add(general.spawnFutakuchiOnna, EntityGaiaFutakuchiOnna.class, 4, 6, biome);
				add(general.spawnNineTails, EntityGaiaNineTails.class, 2, 4, biome);

				underground(biome);
			}

			// coldTaiga, coldTaigaHills
			if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (BiomeDictionary.hasType(biome, Type.SNOWY))) {
				add(general.spawnDhampir, EntityGaiaDhampir.class, 2, 4, biome);

				if (!general.spawnLevel3) {
					add(general.spawnVampire, EntityGaiaVampire.class, 1, 2, biome);
				}

				underground(biome);
			}

			// roofedForest
			if (BiomeDictionary.hasType(biome, Type.SPOOKY)) {
				add(general.spawnMatango, EntityGaiaMatango.class, 2, 4, biome);
				add(general.spawnToad, EntityGaiaToad.class, 2, 4, biome);
				add(general.spawnWitch, EntityGaiaWitch.class, 2, 4, biome);

				underground(biome);
			}
		}
	}

	/**
	 * "Mutated" biomes don't have type dictionaries by default. This addition
	 * compensates for specific sub biomes having gaps in creature spawning.
	 */
	public static void biomeTweaks() {
		Gaia.LOGGER.info("Sub Biome Tweaks Enabled");

		BiomeDictionary.addTypes(Biomes.MUTATED_ROOFED_FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE,
				BiomeDictionary.Type.FOREST);
		BiomeDictionary.addTypes(Biomes.MUTATED_EXTREME_HILLS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
		BiomeDictionary.addTypes(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
	}

	private static Map<Type, Set<Biome>> buildBiomeListByType() {
		Map<Type, Set<Biome>> biomesAndTypes = new HashMap<>();

		for (Biome biome : Biome.REGISTRY) {
			Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(biome);
			for (BiomeDictionary.Type type : types) {
				if (!biomesAndTypes.containsKey(type)) {
					biomesAndTypes.put(type, new HashSet<>());
				}

				biomesAndTypes.get(type).add(biome);
			}
		}

		return biomesAndTypes;
	}
}
