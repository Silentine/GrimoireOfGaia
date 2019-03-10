package gaia.init;

import gaia.Gaia;
import gaia.GaiaReference;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

import static gaia.GaiaConfig.COMMON;

/**
 * Streamlined Spawning Registry, Tried to keep structure as similar, but cleaned up methods and repetitive code to save time and fingers.
 */
@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GaiaReference.MOD_ID)
public class GaiaSpawning {
	/**
	 * Bridge Method for simpler spawning registry
	 *
	 * @param weight        Spawn rate
	 * @param entityType Entity
	 * @param groupCountMin Minimum amount (always 1)
	 * @param groupCountMax Maximum amount (depreciated due to chunk limits)
	 * @param biome         Biome
	 */
	public static void add(int weight, EntityType<? extends EntityLiving> entityType, int groupCountMin, int groupCountMax, Biome biome) {
		if (weight > 0) {
			biome.getSpawns(EnumCreatureType.MONSTER).add(new SpawnListEntry(entityType, weight, groupCountMin, groupCountMax));
		}
	}

	/**
	 * Underground Creature Roster
	 */
	private static void underground(Biome biome) {
		add(COMMON.spawnCreep.get(), GaiaEntities.CREEP, 2, 4, biome);
		add(COMMON.spawnEnderEye.get(), GaiaEntities.ENDER_EYE, 2, 4, biome);
		add(COMMON.spawnVase.get(), GaiaEntities.VASE, 1, 1, biome);
		add(COMMON.spawnMimic.get(), GaiaEntities.MIMIC, 1, 1, biome);
		add(COMMON.spawnArachne.get(), GaiaEntities.ARACHNE, 1, 2, biome);
		add(COMMON.spawnDeathword.get(), GaiaEntities.DEATHWORD, 1, 2, biome);
		add(COMMON.spawnBoneKnight.get(), GaiaEntities.BONE_KNIGHT, 1, 2, biome);
		add(COMMON.spawnFleshLich.get(), GaiaEntities.FLESH_LICH, 1, 2, biome);
	}

	/**
	 * Ocean Creature Roster
	 */
	private static void aquatic(Biome biome) {
		add(COMMON.spawnCecaelia.get(), GaiaEntities.CECEALIA, 4, 6, biome);
		add(COMMON.spawnMermaid.get(), GaiaEntities.MERMAID, 2, 4, biome);
		add(COMMON.spawnSharko.get(), GaiaEntities.SHARKO, 2, 4, biome);
	}

	/**
	 * Register Mobs based on Biome sub Types
	 */
	public static void register() {
		registerSpawnPlacement();

		for(Biome biome : ForgeRegistries.BIOMES)
		{
			addForestSPAWN(biome);
			addSandySPAWN(biome);
			addPlainsSPAWN(biome);
			addSwampSPAWN(biome);
			addJungleSPAWN(biome);
			addSnowySPAWN(biome);
			addMountainSPAWN(biome);
			addSavannaSPAWN(biome);
			addMesaSPAWN(biome);
			addWaterSPAWN(biome);
			addBeachSPAWN(biome);
			addNetherSPAWN(biome);
			addEndSPAWN(biome);
		}
	}

	/*
	 * List of missing Biomes;
	 *
	 * MUTATED_REDWOOD_TAIGA
	 * MUTATED_REDWOOD_TAIGA_HILLS
	 * MUTATED_MESA_ROCK
	 */

	private static void addEndSPAWN(Biome biome) {
		/*
		 * SKY
		 */
		if (BiomeDictionary.hasType(biome, Type.END)) {
			if (BiomeDictionary.hasType(biome, Type.COLD) && (BiomeDictionary.hasType(biome, Type.DRY))) {
				add(COMMON.spawnEnderDragonGirl.get(), GaiaEntities.ENDER_DRAGON_GIRL, 1, 2, biome);
			}
		}
	}

	private static void addNetherSPAWN(Biome biome) {
		/*
		 * NETHER
		 */
		if (BiomeDictionary.hasType(biome, Type.NETHER)) {
			add(COMMON.spawnSuccubus.get(), GaiaEntities.SUCCUBUS, 2, 4, biome);
			add(COMMON.spawnWitherCow.get(), GaiaEntities.WITHER_COW, 2, 4, biome);
			add(COMMON.spawnBaphomet.get(), GaiaEntities.BAPHOMET, 2, 4, biome);
		}
	}

	private static void addBeachSPAWN(Biome biome) {
		/*
		 * BEACH,
		 * STONE_BEACH,
		 * COLD_BEACH
		 */
		if (BiomeDictionary.hasType(biome, Type.BEACH)) {
			if (!BiomeDictionary.hasType(biome, Type.MUSHROOM)) {
				aquatic(biome);
			}
		}
	}

	private static void addWaterSPAWN(Biome biome) {
		/*
		 * OCEAN,
		 * RIVER,
		 * FROZEN_OCEAN,
		 * FROZEN_RIVER,
		 * DEEP_OCEAN
		 */
		if (BiomeDictionary.hasType(biome, Type.WATER)){
			aquatic(biome);
		}
	}

	private static void addMountainSPAWN(Biome biome) {
		/*
		 * EXTREME_HILLS,
		 * EXTREME_HILLS_EDGE,
		 * EXTREME_HILLS_WITH_TREES,
		 * MUTATED_EXTREME_HILLS
		 */
		if (!BiomeDictionary.hasType(biome, Type.COLD) && !BiomeDictionary.hasType(biome, Type.HOT) && !BiomeDictionary.hasType(biome, Type.DENSE)) {
			add(COMMON.spawnGryphon.get(), GaiaEntities.GRYPHON, 1, 2, biome);
			add(COMMON.spawnDwarf.get(), GaiaEntities.DWARF, 4, 6, biome);

			if (!COMMON.spawnLevel3.get()) {
				add(COMMON.spawnValkyrie.get(), GaiaEntities.VALKYRIE, 1, 2, biome);
			}

			add(COMMON.spawnDullahan.get(), GaiaEntities.DULLAHAN, 4, 6, biome);
			add(COMMON.spawnBanshee.get(), GaiaEntities.BANSHEE, 2, 4, biome);

			add(COMMON.spawnCampsite.get(), GaiaEntities.CAMPFIRE, 1, 1, biome);
			underground(biome);
		}
	}

	private static void addSnowySPAWN(Biome biome) {
		/*
		 * ICE_PLAINS,
		 * ICE_MOUNTAINS
		 */
		if (BiomeDictionary.hasType(biome, Type.SNOWY)) {
			if (!BiomeDictionary.hasType(biome, Type.OCEAN) &&
					!BiomeDictionary.hasType(biome, Type.RIVER) &&
					!BiomeDictionary.hasType(biome, Type.BEACH) &&
					!BiomeDictionary.hasType(biome, Type.FOREST)) {
				add(COMMON.spawnSelkie.get(), GaiaEntities.SELKIE, 2, 4, biome);
				add(COMMON.spawnKobold.get(), GaiaEntities.KOBOLD, 4, 6, biome);
				add(COMMON.spawnYeti.get(), GaiaEntities.YETI, 2, 4, biome);

				underground(biome);
			}
		}
	}

	private static void addJungleSPAWN(Biome biome) {
		/*
		 * JUNGLE,
		 * JUNGLE_HILLS,
		 * JUNGLE_EDGE,
		 * MUTATED_JUNGLE,
		 * MUTATED_JUNGLE_EDGE
		 */
		if (BiomeDictionary.hasType(biome, Type.JUNGLE)) {
			add(COMMON.spawnCobbleGolem.get(), GaiaEntities.COBBLE_GOLEM, 2, 4, biome);
			add(COMMON.spawnHunter.get(), GaiaEntities.HUNTER, 2, 4, biome);
			add(COMMON.spawnShaman.get(), GaiaEntities.SHAMAN, 2, 4, biome);
			add(COMMON.spawnCobblestoneGolem.get(), GaiaEntities.COBBLESTONE_GOLEM, 2, 4, biome);

			underground(biome);
		}
	}

	private static void addSwampSPAWN(Biome biome) {
		/*
		 * SWAMPLAND
		 * MUTATED_SWAMPLAND
		 */
		if (BiomeDictionary.hasType(biome, Type.SWAMP)) {
			add(COMMON.spawnSiren.get(), GaiaEntities.SIREN, 4, 6, biome);
			add(COMMON.spawnSludgeGirl.get(), GaiaEntities.SLUDGE_GIRL, 2, 4, biome);
			add(COMMON.spawnNaga.get(), GaiaEntities.NAGA, 1, 2, biome);

			underground(biome);
		}
	}

	private static void addPlainsSPAWN(Biome biome) {
		if (BiomeDictionary.hasType(biome, Type.PLAINS)) {
			/*
			 * PLAINS
			 * MUTATED_PLAINS
			 */
			if (!BiomeDictionary.hasType(biome, Type.SAVANNA)) {
				add(COMMON.spawnSatyress.get(), GaiaEntities.SATYRESS, 2, 4, biome);
				add(COMMON.spawnCentaur.get(), GaiaEntities.CENTAUR, 4, 6, biome);
				add(COMMON.spawnHarpy.get(), GaiaEntities.HARPY, 2, 4, biome);
				add(COMMON.spawnMinotaurus.get(), GaiaEntities.MINOTAURUS, 2, 4, biome);

				if (!COMMON.spawnLevel3.get()) {
					add(COMMON.spawnMinotaur.get(), GaiaEntities.MINOTAUR, 1, 2, biome);
				}

				underground(biome);
			}
		}
	}

	private static void addSavannaSPAWN(Biome biome) {
		/*
		 * SAVANNA,
		 * SAVANNA_PLATEAU,
		 * MUTATED_SAVANNA,
		 * MUTATED_SAVANNA_ROCK,
		 * MUTATED_MESA,
		 * MUTATED_MESA_CLEAR_ROCK
		 */
		if (BiomeDictionary.hasType(biome, Type.SAVANNA)) {
			add(COMMON.spawnGoblin.get(), GaiaEntities.GOBLIN, 2, 6, biome);
			add(COMMON.spawnOrc.get(), GaiaEntities.ORC, 2, 6, biome);

			underground(biome);
		}
	}

	private static void addMesaSPAWN(Biome biome) {
		/*
		 * MESA,
		 * MESA_ROCK,
		 * MESA_CLEAR_ROCK
		 */
		if (BiomeDictionary.hasType(biome, Type.MESA)) {
			add(COMMON.spawnSatyress.get(), GaiaEntities.SATYRESS, 2, 4, biome);
			add(COMMON.spawnCentaur.get(), GaiaEntities.CENTAUR, 4, 6, biome);
			add(COMMON.spawnHarpy.get(), GaiaEntities.HARPY, 2, 4, biome);
			add(COMMON.spawnMinotaurus.get(), GaiaEntities.MINOTAURUS, 2, 4, biome);

			if (!COMMON.spawnLevel3.get()) {
				add(COMMON.spawnMinotaur.get(), GaiaEntities.MINOTAUR, 1, 2, biome);
			}

			underground(biome);
		}
	}

	private static void addSandySPAWN(Biome biome) {
		/*
		 * DESERT,
		 * DESERT_HILLS,
		 * MUTATED_DESERT
		 */
		if (BiomeDictionary.hasType(biome, Type.SANDY)) {
			if (!BiomeDictionary.hasType(biome, Type.MESA)) {
				add(COMMON.spawnAnt.get(), GaiaEntities.ANT, 2, 4, biome);
				add(COMMON.spawnAntRanger.get(), GaiaEntities.ANT_RANGER, 2, 4, biome);
				add(COMMON.spawnMummy.get(), GaiaEntities.MUMMY, 2, 4, biome);
				add(COMMON.spawnAnubis.get(), GaiaEntities.ANUBIS, 2, 4, biome);

				if (!COMMON.spawnLevel3.get()) {
					add(COMMON.spawnSphinx.get(), GaiaEntities.SPHINX, 1, 2, biome);
				}

				underground(biome);
			}

			underground(biome);
		}
	}

	private static void addForestSPAWN(Biome biome) {
		if (BiomeDictionary.hasType(biome, Type.FOREST)) {
			/*
			 * FOREST,
			 * FOREST_HILLS,
			 * BIRCH_FOREST,
			 * BIRCH_FOREST_HILLS,
			 * MUTATED_FOREST
			 */
			if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) &&
					!BiomeDictionary.hasType(biome, Type.COLD) &&
					!BiomeDictionary.hasType(biome, Type.HOT) &&
					!BiomeDictionary.hasType(biome, Type.SPARSE) &&
					!BiomeDictionary.hasType(biome, Type.SPOOKY) &&
					!BiomeDictionary.hasType(biome, Type.DENSE)) {
				add(COMMON.spawnDryad.get(), GaiaEntities.DRYAD, 4, 6, biome);
				add(COMMON.spawnBee.get(), GaiaEntities.BEE, 2, 4, biome);
				add(COMMON.spawnMandragora.get(), GaiaEntities.MANDRAGORA, 1, 2, biome);
				add(COMMON.spawnWerecat.get(), GaiaEntities.WERECAT, 4, 6, biome);
				add(COMMON.spawnSpriggan.get(), GaiaEntities.SPRIGGAN, 2, 4, biome);

				underground(biome);
			}

			/*
			 * MUTATED_BIRCH_FOREST
			 * MUTATED_BIRCH_FOREST_HILLS
			 */
			if (!BiomeDictionary.hasType(biome, Type.CONIFEROUS) &&
					!BiomeDictionary.hasType(biome, Type.COLD) &&
					!BiomeDictionary.hasType(biome, Type.HOT) &&
					!BiomeDictionary.hasType(biome, Type.SPARSE) &&
					!BiomeDictionary.hasType(biome, Type.SPOOKY) &&
					BiomeDictionary.hasType(biome, Type.DENSE) &&
					BiomeDictionary.hasType(biome, Type.RARE)) {
				add(COMMON.spawnDryad.get(), GaiaEntities.DRYAD, 4, 6, biome);
				add(COMMON.spawnBee.get(), GaiaEntities.BEE, 2, 4, biome);
				add(COMMON.spawnMandragora.get(), GaiaEntities.MANDRAGORA, 1, 2, biome);
				add(COMMON.spawnWerecat.get(), GaiaEntities.WERECAT, 4, 6, biome);
				add(COMMON.spawnSpriggan.get(), GaiaEntities.SPRIGGAN, 2, 4, biome);

				underground(biome);
			}

			/*
			 * TAIGA
			 * REDWOOD_TAIGA,
			 * REDWOOD_TAIGA_HILLS
			 */
			if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (!BiomeDictionary.hasType(biome, Type.SNOWY))) {
				add(COMMON.spawnMandragora.get(), GaiaEntities.MANDRAGORA, 1, 2, biome);
				add(COMMON.spawnCyclops.get(), GaiaEntities.CYCLOPS, 4, 6, biome);
				add(COMMON.spawnYukiOnna.get(), GaiaEntities.YUKI_ONNA, 2, 4, biome);
				add(COMMON.spawnOni.get(), GaiaEntities.ONI, 4, 6, biome);
				add(COMMON.spawnNineTails.get(), GaiaEntities.NINE_TAILS, 2, 4, biome);

				underground(biome);
			}

			/*
			 * COLD_TAIGA,
			 * COLD_TAIGA_HILLS,
			 * MUTATED_TAIGA_COLD
			 */
			if (BiomeDictionary.hasType(biome, Type.CONIFEROUS) && (BiomeDictionary.hasType(biome, Type.SNOWY))) {
				add(COMMON.spawnKikimora.get(), GaiaEntities.KIKIMORA, 2, 4, biome);
				add(COMMON.spawnDhampir.get(), GaiaEntities.DHAMPIR, 2, 4, biome);

				if (!COMMON.spawnLevel3.get()) {
					add(COMMON.spawnVampire.get(), GaiaEntities.VAMPIRE, 1, 2, biome);
				}

				underground(biome);
			}

			/*
			 * ROOFED_FOREST
			 * MUTATED_ROOFED_FOREST
			 */
			if (BiomeDictionary.hasType(biome, Type.SPOOKY)) {
				add(COMMON.spawnMatango.get(), GaiaEntities.MATANGO, 2, 4, biome);
				add(COMMON.spawnToad.get(), GaiaEntities.TOAD, 2, 4, biome);
				add(COMMON.spawnWitch.get(), GaiaEntities.WITCH, 2, 4, biome);

				underground(biome);
			}
		}
	}

	public static void registerSpawnPlacement(){
		Gaia.LOGGER.info("Registering gaia spawn placement");
		//Mobs that spawn on the ground
		EntitySpawnPlacementRegistry.register(GaiaEntities.ANT, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ANT_RANGER, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ANUBIS, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ARACHNE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.BANSHEE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.BAPHOMET, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.BEE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.BONE_KNIGHT, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.CENTAUR, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.CHEST, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.COBBLE_GOLEM, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.COBBLESTONE_GOLEM, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.CREEP, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.CYCLOPS, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.CYAN_FLOWER, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.DEATHWORD, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.DHAMPIR, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.DRYAD, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.DULLAHAN, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.DWARF, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ENDER_DRAGON_GIRL, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ENDER_EYE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.FLESH_LICH, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.GELATINOUS_SLIME, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.GOBLIN, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.GOBLIN_FERAL, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.GRYPHON, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.HARPY, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.HUNTER, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.KIKIMORA, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.KOBOLD, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MATANGO, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MINOTAUR, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MINOTAURUS, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MUMMY, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.NAGA, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.NINE_TAILS, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ONI, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.ORC, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SATYRESS, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SELKIE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SHAMAN, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SIREN, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SLUDGE_GIRL, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SPHINX, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SPRIGGAN, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SUCCUBUS, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.TOAD, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.VALKYRIE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.VAMPIRE, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.WERECAT, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.WITCH, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.WITHER_COW, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.YETI, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.YUKI_ONNA, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MANDRAGORA, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MIMIC, EntitySpawnPlacementRegistry.SpawnPlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);

		//Mobs that spawn in water
		EntitySpawnPlacementRegistry.register(GaiaEntities.CECEALIA, EntitySpawnPlacementRegistry.SpawnPlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.MERMAID, EntitySpawnPlacementRegistry.SpawnPlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);
		EntitySpawnPlacementRegistry.register(GaiaEntities.SHARKO, EntitySpawnPlacementRegistry.SpawnPlacementType.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, null);

	}
}
