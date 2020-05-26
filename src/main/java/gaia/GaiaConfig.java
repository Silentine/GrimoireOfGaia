package gaia;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = GaiaReference.MOD_ID, category = "")
public class GaiaConfig {
	private GaiaConfig() {
	}

	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	private static class EventHandler {

		private EventHandler() {
		}

		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(GaiaReference.MOD_ID)) {
				ConfigManager.sync(GaiaReference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu0.general")
	@Config.Comment("Spawn Rates")
	public static final General GENERAL = new General();

	public static class General {
		/*
		 * SKY
		 */
		@Config.LangKey("entity.grimoireofgaia.beholderl.name")
		@Config.Comment("Beholder")
		@Config.RequiresMcRestart
		public int spawnBeholder = 1;
		@Config.LangKey("entity.grimoireofgaia.ender_dragon_girl.name")
		@Config.Comment("Ender Dragon Girl")
		@Config.RequiresMcRestart
		public int spawnEnderDragonGirl = 1;
		/*
		 * NETHER
		 */
		@Config.LangKey("entity.grimoireofgaia.vase_nether.name")
		@Config.Comment("Ancient Vase (Nether)")
		@Config.RequiresMcRestart
		public int spawnVaseNether = 12;
		@Config.LangKey("entity.grimoireofgaia.succubus.name")
		@Config.Comment("Succubus")
		@Config.RequiresMcRestart
		public int spawnSuccubus = 16;
		@Config.LangKey("entity.grimoireofgaia.wither_cow.name")
		@Config.Comment("Wither Cow")
		@Config.RequiresMcRestart
		public int spawnWitherCow = 12;
		@Config.LangKey("entity.grimoireofgaia.baphomet.name")
		@Config.Comment("Baphomet")
		@Config.RequiresMcRestart
		public int spawnBaphomet = 12;
		/*
		 * OCEAN,
		 * RIVER,
		 * FROZEN_OCEAN,
		 * FROZEN_RIVER,
		 * DEEP_OCEAN
		 */
		@Config.LangKey("entity.grimoireofgaia.cecaelia.name")
		@Config.Comment("Cecaelia")
		@Config.RequiresMcRestart
		public int spawnCecaelia = 80;
		@Config.LangKey("entity.grimoireofgaia.mermaid.name")
		@Config.Comment("Mermaid")
		@Config.RequiresMcRestart
		public int spawnMermaid = 40;
		@Config.LangKey("entity.grimoireofgaia.sharko.name")
		@Config.Comment("Sharko")
		@Config.RequiresMcRestart
		public int spawnSharko = 40;
		/*
		 * EXTREME_HILLS,
		 * EXTREME_HILLS_EDGE,
		 * EXTREME_HILLS_WITH_TREES,
		 * MUTATED_EXTREME_HILLS
		 */
		@Config.LangKey("entity.grimoireofgaia.dwarf.name")
		@Config.Comment("Dwarf")
		@Config.RequiresMcRestart
		public int spawnDwarf = 30;
		@Config.LangKey("entity.grimoireofgaia.gryphon.name")
		@Config.Comment("Gryphon")
		@Config.RequiresMcRestart
		public int spawnGryphon = 60;
		@Config.LangKey("entity.grimoireofgaia.valkyrie.name")
		@Config.Comment("Valkyrie")
		@Config.RequiresMcRestart
		public int spawnValkyrie = 10;
		@Config.LangKey("entity.grimoireofgaia.dullahan.name")
		@Config.Comment("Dullahan")
		@Config.RequiresMcRestart
		public int spawnDullahan = 100;
		@Config.LangKey("entity.grimoireofgaia.banshee.name")
		@Config.Comment("Banshee")
		@Config.RequiresMcRestart
		public int spawnBanshee = 80;
		/*
		 * ICE_PLAINS,
		 * ICE_MOUNTAINS
		 */
		@Config.LangKey("entity.grimoireofgaia.selkie.name")
		@Config.Comment("Selkie")
		@Config.RequiresMcRestart
		public int spawnSelkie = 30;
		@Config.LangKey("entity.grimoireofgaia.kobold.name")
		@Config.Comment("Kobold")
		@Config.RequiresMcRestart
		public int spawnKobold = 60;
		@Config.LangKey("entity.grimoireofgaia.yeti.name")
		@Config.Comment("Yeti")
		@Config.RequiresMcRestart
		public int spawnYeti = 80;
		/*
		 * JUNGLE,
		 * JUNGLE_HILLS,
		 * JUNGLE_EDGE,
		 * MUTATED_JUNGLE,
		 * MUTATED_JUNGLE_EDGE
		 */
		@Config.LangKey("entity.grimoireofgaia.hunter.name")
		@Config.Comment("Hunter")
		@Config.RequiresMcRestart
		public int spawnHunter = 60;
		@Config.LangKey("entity.grimoireofgaia.cobble_golem.name")
		@Config.Comment("Cobble Golem")
		@Config.RequiresMcRestart
		public int spawnCobbleGolem = 60;
		@Config.LangKey("entity.grimoireofgaia.shaman.name")
		@Config.Comment("Shaman")
		@Config.RequiresMcRestart
		public int spawnShaman = 60;
		@Config.LangKey("entity.grimoireofgaia.cobblestone_golem.name")
		@Config.Comment("Cobblestone Golem")
		@Config.RequiresMcRestart
		public int spawnCobblestoneGolem = 60;
		/*
		 * SWAMPLAND
		 * MUTATED_SWAMPLAND
		 */
		@Config.LangKey("entity.grimoireofgaia.siren.name")
		@Config.Comment("Siren")
		@Config.RequiresMcRestart
		public int spawnSiren = 60;
		@Config.LangKey("entity.grimoireofgaia.naga.name")
		@Config.Comment("Naga")
		@Config.RequiresMcRestart
		public int spawnNaga = 30;
//		@Config.LangKey("entity.grimoireofgaia.gorgon.name")
//		@Config.Comment("Gorgon")
//		@Config.RequiresMcRestart
//		public int spawnGorgon = 10;
		@Config.LangKey("entity.grimoireofgaia.sludge_girl.name")
		@Config.Comment("Sludge Girl")
		@Config.RequiresMcRestart
		public int spawnSludgeGirl = 100;
		@Config.LangKey("entity.grimoireofgaia.gelatinous_slime.name")
		@Config.Comment("Gelatinous Slime")
		@Config.RequiresMcRestart
		public int spawnGelatinousSlime = 80;
		/*
		 * PLAINS
		 * MUTATED_PLAINS
		 */
		@Config.LangKey("entity.grimoireofgaia.satyress.name")
		@Config.Comment("Satyress")
		@Config.RequiresMcRestart
		public int spawnSatyress = 20;
		@Config.LangKey("entity.grimoireofgaia.centaur.name")
		@Config.Comment("Centaur")
		@Config.RequiresMcRestart
		public int spawnCentaur = 20;
		@Config.LangKey("entity.grimoireofgaia.harpy.name")
		@Config.Comment("Harpy")
		@Config.RequiresMcRestart
		public int spawnHarpy = 100;
		@Config.LangKey("entity.grimoireofgaia.minotaurus.name")
		@Config.Comment("Minotaurus")
		@Config.RequiresMcRestart
		public int spawnMinotaurus = 80;
		@Config.LangKey("entity.grimoireofgaia.minotaur.name")
		@Config.Comment("Minotaur")
		@Config.RequiresMcRestart
		public int spawnMinotaur = 10;
		/*
		 * SAVANNA,
		 * SAVANNA_PLATEAU,
		 * MUTATED_SAVANNA,
		 * MUTATED_SAVANNA_ROCK,
		 * MUTATED_MESA,
		 * MUTATED_MESA_CLEAR_ROCK
		 */
		@Config.LangKey("entity.grimoireofgaia.goblin.name")
		@Config.Comment("Goblin")
		public int spawnGoblin = 30;
		@Config.LangKey("entity.grimoireofgaia.orc.name")
		@Config.Comment("Orc")
		public int spawnOrc = 80;
		/*
		 * DESERT,
		 * DESERT_HILLS,
		 * MUTATED_DESERT
		 */
		@Config.LangKey("entity.grimoireofgaia.ant_hill.name")
		@Config.Comment("Ant Hill")
		@Config.RequiresMcRestart
		public int spawnAntHill = 20;
		@Config.LangKey("entity.grimoireofgaia.ant_ranger.name")
		@Config.Comment("Ant Salvager")
		@Config.RequiresMcRestart
		public int spawnAntRanger = 20;
		@Config.LangKey("entity.grimoireofgaia.mummy.name")
		@Config.Comment("Mummy")
		@Config.RequiresMcRestart
		public int spawnMummy = 100;
		@Config.LangKey("entity.grimoireofgaia.anubis.name")
		@Config.Comment("Anubis")
		@Config.RequiresMcRestart
		public int spawnAnubis = 80;
		@Config.LangKey("entity.grimoireofgaia.sphinx.name")
		@Config.Comment("Sphinx")
		@Config.RequiresMcRestart
		public int spawnSphinx = 10;
		/*
		 * FOREST,
		 * FOREST_HILLS,
		 * BIRCH_FOREST,
		 * BIRCH_FOREST_HILLS
		 * MUTATED_BIRCH_FOREST
		 * MUTATED_BIRCH_FOREST_HILLS
		 */
		@Config.LangKey("entity.grimoireofgaia.dryad.name")
		@Config.Comment("Dryad")
		@Config.RequiresMcRestart
		public int spawnDryad = 60;
		@Config.LangKey("entity.grimoireofgaia.bee.name")
		@Config.Comment("Bee")
		@Config.RequiresMcRestart
		public int spawnBee = 40;
		@Config.LangKey("entity.grimoireofgaia.mandragora.name")
		@Config.Comment("Mandragora")
		@Config.RequiresMcRestart
		public int spawnMandragora = 60;
		@Config.LangKey("entity.grimoireofgaia.werecat.name")
		@Config.Comment("Werecat")
		@Config.RequiresMcRestart
		public int spawnWerecat = 80;
		@Config.LangKey("entity.grimoireofgaia.spriggan.name")
		@Config.Comment("Spriggan")
		@Config.RequiresMcRestart
		public int spawnSpriggan = 40;
		/*
		 * TAIGA
		 * REDWOOD_TAIGA,
		 * REDWOOD_TAIGA_HILLS
		 */
		@Config.LangKey("entity.grimoireofgaia.cyclops.name")
		@Config.Comment("Cyclops")
		@Config.RequiresMcRestart
		public int spawnCyclops = 40;
		@Config.LangKey("entity.grimoireofgaia.yuki-onna.name")
		@Config.Comment("Yuki-Onna")
		@Config.RequiresMcRestart
		public int spawnYukiOnna = 60;
		@Config.LangKey("entity.grimoireofgaia.oni.name")
		@Config.Comment("Oni")
		@Config.RequiresMcRestart
		public int spawnOni = 80;
		@Config.LangKey("entity.grimoireofgaia.nine_tails.name")
		@Config.Comment("Nine Tails")
		@Config.RequiresMcRestart
		public int spawnNineTails = 40;
		/*
		 * COLD_TAIGA,
		 * COLD_TAIGA_HILLS,
		 * REDWOOD_TAIGA,
		 * REDWOOD_TAIGA_HILLS
		 */
		@Config.LangKey("entity.grimoireofgaia.kikimora.name")
		@Config.Comment("Kikimora")
		@Config.RequiresMcRestart
		public int spawnKikimora = 40;
		@Config.LangKey("entity.grimoireofgaia.dhampir.name")
		@Config.Comment("Dhampir")
		@Config.RequiresMcRestart
		public int spawnDhampir = 80;
		@Config.LangKey("entity.grimoireofgaia.vampire.name")
		@Config.Comment("Vampire")
		@Config.RequiresMcRestart
		public int spawnVampire = 10;
		/*
		 * ROOFED_FOREST
		 * MUTATED_ROOFED_FOREST
		 */
		@Config.LangKey("entity.grimoireofgaia.matango.name")
		@Config.Comment("Matango")
		@Config.RequiresMcRestart
		public int spawnMatango = 60;
		@Config.LangKey("entity.grimoireofgaia.toad.name")
		@Config.Comment("Toad")
		@Config.RequiresMcRestart
		public int spawnToad = 80;
		@Config.LangKey("entity.grimoireofgaia.harpy_wizard.name")
		@Config.Comment("Wizard Harpy")
		@Config.RequiresMcRestart
		public int spawnHarpyWizard = 60;
		@Config.LangKey("entity.grimoireofgaia.witch.name")
		@Config.Comment("Witch")
		@Config.RequiresMcRestart
		public int spawnWitch = 60;
		/*
		 * UNDERGROUND
		 */
		@Config.LangKey("entity.grimoireofgaia.vase.name")
		@Config.Comment("Ancient Vase")
		@Config.RequiresMcRestart
		public int spawnVase = 40;
		@Config.LangKey("entity.grimoireofgaia.creep.name")
		@Config.Comment("Creep")
		@Config.RequiresMcRestart
		public int spawnCreep = 80;
		@Config.LangKey("entity.grimoireofgaia.ender_eye.name")
		@Config.Comment("Ender Eye")
		@Config.RequiresMcRestart
		public int spawnEnderEye = 40;
		@Config.LangKey("entity.grimoireofgaia.arachne.name")
		@Config.Comment("Arachne")
		@Config.RequiresMcRestart
		public int spawnArachne = 80;
		@Config.LangKey("entity.grimoireofgaia.mimic.name")
		@Config.Comment("Mimic")
		@Config.RequiresMcRestart
		public int spawnMimic = 40;
		@Config.LangKey("entity.grimoireofgaia.deathword.name")
		@Config.Comment("Deathword")
		@Config.RequiresMcRestart
		public int spawnDeathword = 40;
		@Config.LangKey("entity.grimoireofgaia.bone_knight.name")
		@Config.Comment("Bone Knight")
		@Config.RequiresMcRestart
		public int spawnBoneKnight = 40;
		@Config.LangKey("entity.grimoireofgaia.flesh_lich.name")
		@Config.Comment("Flesh Lich")
		@Config.RequiresMcRestart
		public int spawnFleshLich = 40;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu1.spawns")
	@Config.Comment("Spawn Options")
	public static final Spawn SPAWN = new Spawn();

	public static class Spawn {
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu0.SpawnDaysPassed")
		@Config.Comment("Mobs only spawn after a certain amount of days have passed")
		public boolean spawnDaysPassed = false;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu1.SpawnDaysSet")
		@Config.Comment("Amount of days required to have passed before they can start spawning")
		public int spawnDaysSet = 3;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu2.SpawnLevel3Rain")
		@Config.Comment("Level 3 mobs only spawn when it is raining/snowing.")
		public boolean spawnLevel3Rain = false;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu5.AdditionalSpawnBlocks")
		@Config.Comment("Additional Blocks Gaia mobs can spawn on")
		public String[] additionalSpawnBlocks = {Blocks.SANDSTONE.getRegistryName().toString()};
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu6.AdditionalFlowerSpawnBlocks")
		@Config.Comment("Additional Blocks Gaia flower can spawn on")
		public String[] additionalFlowerSpawnBlocks = {Blocks.SANDSTONE.getRegistryName().toString()};
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu7.Weather")
		@Config.Comment("Remove spawn conditions related to weather.")
		public boolean spawnWeather = false;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu8.Height")
		@Config.Comment("Remove spawn conditions related to height (Y-axis).")
		public boolean disableYRestriction = false;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu2.biome")
	@Config.Comment("Spawn Biomes")
	public static Biomes BIOMES = new Biomes();

	public static class Biomes {

		@Config.LangKey("")
		@Config.Comment("If TRUE, you can customize the Gaia mobs will spawn in what biome.")
		@Config.RequiresMcRestart
		public boolean enableSpawnSettingsEachBiomes = false;

		/*
		 * SKY
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.beholder.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesBeholder = false;
		@Config.LangKey("entity.grimoireofgaia.beholderl.name")
		@Config.Comment("Beholder")
		@Config.RequiresMcRestart
		public int[] biomesBeholder = {9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.ender_dragon_girl.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesEnderDragonGirl = false;
		@Config.LangKey("entity.grimoireofgaia.ender_dragon_girl.name")
		@Config.Comment("Ender Dragon Girl")
		@Config.RequiresMcRestart
		public int[] biomesEnderDragonGirl = {9};

		/*
		 * NETHER
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.vase_nether.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesVaseNether = false;
		@Config.LangKey("entity.grimoireofgaia.vase_nether.name")
		@Config.Comment("Ancient Vase (Nether)")
		@Config.RequiresMcRestart
		public int[] biomesVaseNether = {8};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.succubus.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSuccubus = false;
		@Config.LangKey("entity.grimoireofgaia.succubus.name")
		@Config.Comment("Succubus")
		@Config.RequiresMcRestart
		public int[] biomesSuccubus = {8};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.wither_cow.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesWitherCow = false;
		@Config.LangKey("entity.grimoireofgaia.wither_cow.name")
		@Config.Comment("Wither Cow")
		@Config.RequiresMcRestart
		public int[] biomesWitherCow = {8};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.baphomet.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesBaphomet = false;
		@Config.LangKey("entity.grimoireofgaia.baphomet.name")
		@Config.Comment("Baphomet")
		@Config.RequiresMcRestart
		public int[] biomesBaphomet = {8};

		/*
		 * OCEAN,
		 * RIVER,
		 * FROZEN_OCEAN,
		 * FROZEN_RIVER,
		 * DEEP_OCEAN
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.cecaelia.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesCecaelia = false;
		@Config.LangKey("entity.grimoireofgaia.cecaelia.name")
		@Config.Comment("Cecaelia")
		@Config.RequiresMcRestart
		public int[] biomesCecaelia = {
				0, 7, 10, 11, 24
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.mermaid.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMermaid = false;
		@Config.LangKey("entity.grimoireofgaia.mermaid.name")
		@Config.Comment("Mermaid")
		@Config.RequiresMcRestart
		public int[] biomesMermaid = {
				0, 7, 10, 11, 24
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.sharko.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSharko = false;
		@Config.LangKey("entity.grimoireofgaia.sharko.name")
		@Config.Comment("Sharko")
		@Config.RequiresMcRestart
		public int[] biomesSharko = {
				0, 7, 10, 11, 24
		};

		/*
		 * EXTREME_HILLS,
		 * EXTREME_HILLS_EDGE,
		 * EXTREME_HILLS_WITH_TREES,
		 * MUTATED_EXTREME_HILLS
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.dwarf.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesDwarf = false;
		@Config.LangKey("entity.grimoireofgaia.dwarf.name")
		@Config.Comment("Dwarf")
		@Config.RequiresMcRestart
		public int[] biomesDwarf = {
				3, 20, 34, 131
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.gryphon.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesGryphon = false;
		@Config.LangKey("entity.grimoireofgaia.gryphon.name")
		@Config.Comment("Gryphon")
		@Config.RequiresMcRestart
		public int[] biomesGryphon = {
				3, 20, 34, 131
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.valkyrie.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesValkyrie = false;
		@Config.LangKey("entity.grimoireofgaia.valkyrie.name")
		@Config.Comment("Valkyrie")
		@Config.RequiresMcRestart
		public int[] biomesValkyrie = {
				3, 20, 34, 131
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.dullahan.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesDullahan = false;
		@Config.LangKey("entity.grimoireofgaia.dullahan.name")
		@Config.Comment("Dullahan")
		@Config.RequiresMcRestart
		public int[] biomesDullahan = {
				3, 20, 34, 131
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.banshee.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesBanshee = false;
		@Config.LangKey("entity.grimoireofgaia.banshee.name")
		@Config.Comment("Banshee")
		@Config.RequiresMcRestart
		public int[] biomesBanshee = {
				3, 20, 34, 131
		};

		/*
		 * ICE_PLAINS,
		 * ICE_MOUNTAINS
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.selkie.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSelkie = false;
		@Config.LangKey("entity.grimoireofgaia.selkie.name")
		@Config.Comment("Selkie")
		@Config.RequiresMcRestart
		public int[] biomesSelkie = {
				12, 13
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.kobold.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesKobold = false;
		@Config.LangKey("entity.grimoireofgaia.kobold.name")
		@Config.Comment("Kobold")
		@Config.RequiresMcRestart
		public int[] biomesKobold = {
				12, 13
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.yeti.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesYeti = false;
		@Config.LangKey("entity.grimoireofgaia.yeti.name")
		@Config.Comment("Yeti")
		@Config.RequiresMcRestart
		public int[] biomesYeti = {
				12, 13
		};

		/*
		 * JUNGLE,
		 * JUNGLE_HILLS,
		 * JUNGLE_EDGE,
		 * MUTATED_JUNGLE,
		 * MUTATED_JUNGLE_EDGE
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.hunter.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesHunter = false;
		@Config.LangKey("entity.grimoireofgaia.hunter.name")
		@Config.Comment("Hunter")
		@Config.RequiresMcRestart
		public int[] biomesHunter = {
				21, 22, 23, 149, 151
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.cobble_golem.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesCobbleGolem = false;
		@Config.LangKey("entity.grimoireofgaia.cobble_golem.name")
		@Config.Comment("Cobble Golem")
		@Config.RequiresMcRestart
		public int[] biomesCobbleGolem = {
				21, 22, 23, 149, 151
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.shaman.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesShaman = false;
		@Config.LangKey("entity.grimoireofgaia.shaman.name")
		@Config.Comment("Shaman")
		@Config.RequiresMcRestart
		public int[] biomesShaman = {
				21, 22, 23, 149, 151
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.cobblestone_golem.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesCobblestoneGolem = false;
		@Config.LangKey("entity.grimoireofgaia.cobblestone_golem.name")
		@Config.Comment("Cobblestone Golem")
		@Config.RequiresMcRestart
		public int[] biomesCobblestoneGolem = {
				21, 22, 23, 149, 151
		};

		/*
		 * SWAMPLAND
		 * MUTATED_SWAMPLAND
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.siren.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSiren = false;
		@Config.LangKey("entity.grimoireofgaia.siren.name")
		@Config.Comment("Siren")
		@Config.RequiresMcRestart
		public int[] biomesSiren = {
				6, 134
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.naga.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesNaga = false;
		@Config.LangKey("entity.grimoireofgaia.naga.name")
		@Config.Comment("Naga")
		@Config.RequiresMcRestart
		public int[] biomesNaga = {
				6, 134
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.sludge_girl.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSludgeGirl = false;
		@Config.LangKey("entity.grimoireofgaia.sludge_girl.name")
		@Config.Comment("Sludge Girl")
		@Config.RequiresMcRestart
		public int[] biomesSludgeGirl = {
				6, 134
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.gelatinous_slime.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesGelatinousSlime = false;
		@Config.LangKey("entity.grimoireofgaia.gelatinous_slime.name")
		@Config.Comment("Gelatinous Slime")
		@Config.RequiresMcRestart
		public int[] biomesGelatinousSlime = {
				6, 134
		};

		/*
		 * PLAINS
		 * MUTATED_PLAINS
		 * MESA
		 * MESA_ROCK
		 * MESA_CLEAR_ROCK
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.satyress.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSatyress = false;
		@Config.LangKey("entity.grimoireofgaia.satyress.name")
		@Config.Comment("Satyress")
		@Config.RequiresMcRestart
		public int[] biomesSatyress = {
				1, 129, 37, 38, 39
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.centaur.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesCentaur = false;
		@Config.LangKey("entity.grimoireofgaia.centaur.name")
		@Config.Comment("Centaur")
		@Config.RequiresMcRestart
		public int[] biomesCentaur = {
				1, 129, 37, 38, 39
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.harpy.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesHarpy = false;
		@Config.LangKey("entity.grimoireofgaia.harpy.name")
		@Config.Comment("Harpy")
		@Config.RequiresMcRestart
		public int[] biomesHarpy = {
				1, 129, 37, 38, 39
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.minotaurus.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMinotaurus = false;
		@Config.LangKey("entity.grimoireofgaia.minotaurus.name")
		@Config.Comment("Minotaurus")
		@Config.RequiresMcRestart
		public int[] biomesMinotaurus = {
				1, 129, 37, 38, 39
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.minotaur.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMinotaur = false;
		@Config.LangKey("entity.grimoireofgaia.minotaur.name")
		@Config.Comment("Minotaur")
		@Config.RequiresMcRestart
		public int[] biomesMinotaur = {
				1, 129, 37, 38, 39
		};

		/*
		 * SAVANNA,
		 * SAVANNA_PLATEAU,
		 * MUTATED_SAVANNA,
		 * MUTATED_SAVANNA_ROCK,
		 * MUTATED_MESA,
		 * MUTATED_MESA_CLEAR_ROCK
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.goblin.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesGoblin = false;
		@Config.LangKey("entity.grimoireofgaia.goblin.name")
		@Config.Comment("Goblin")
		public int[] biomesGoblin = {
				35, 36, 163, 164, 165, 167
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.orc.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesOrc = false;
		@Config.LangKey("entity.grimoireofgaia.orc.name")
		@Config.Comment("Orc")
		public int[] biomesOrc = {
				35, 36, 163, 164, 165, 167
		};

		/*
		 * DESERT,
		 * DESERT_HILLS,
		 * MUTATED_DESERT
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.ant_hill.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesAntHill = false;
		@Config.LangKey("entity.grimoireofgaia.ant_hill.name")
		@Config.Comment("Ant Hill")
		@Config.RequiresMcRestart
		public int[] biomesAntHill = {
				2, 17, 130
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.ant_ranger.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesAntRanger = false;
		@Config.LangKey("entity.grimoireofgaia.ant_ranger.name")
		@Config.Comment("Ant Salvager")
		@Config.RequiresMcRestart
		public int[] biomesAntRanger = {
				2, 17, 130
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.mummy.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMummy = false;
		@Config.LangKey("entity.grimoireofgaia.mummy.name")
		@Config.Comment("Mummy")
		@Config.RequiresMcRestart
		public int[] biomesMummy = {
				2, 17, 130
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.anubis.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesAnubis = false;
		@Config.LangKey("entity.grimoireofgaia.anubis.name")
		@Config.Comment("Anubis")
		@Config.RequiresMcRestart
		public int[] biomesAnubis = {
				2, 17, 130
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.sphinx.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSphinx = false;
		@Config.LangKey("entity.grimoireofgaia.sphinx.name")
		@Config.Comment("Sphinx")
		@Config.RequiresMcRestart
		public int[] biomesSphinx = {
				2, 17, 130
		};

		/*
		 * FOREST,
		 * FOREST_HILLS,
		 * BIRCH_FOREST,
		 * BIRCH_FOREST_HILLS
		 * MUTATED_FOREST
		 * MUTATED_BIRCH_FOREST
		 * MUTATED_BIRCH_FOREST_HILLS
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.dryad.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesDryad = false;
		@Config.LangKey("entity.grimoireofgaia.dryad.name")
		@Config.Comment("Dryad")
		@Config.RequiresMcRestart
		public int[] biomesDryad = {
				4, 18, 27, 28, 132, 155, 156
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.bee.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesBee = false;
		@Config.LangKey("entity.grimoireofgaia.bee.name")
		@Config.Comment("Bee")
		@Config.RequiresMcRestart
		public int[] biomesBee = {
				4, 18, 27, 28, 132, 155, 156
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.mandragora.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMandragora = false;
		@Config.LangKey("entity.grimoireofgaia.mandragora.name")
		@Config.Comment("Mandragora")
		@Config.RequiresMcRestart
		public int[] biomesMandragora = {
				4, 18, 27, 28, 132, 155, 156
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.werecat.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesWerecat = false;
		@Config.LangKey("entity.grimoireofgaia.werecat.name")
		@Config.Comment("Werecat")
		@Config.RequiresMcRestart
		public int[] biomesWerecat = {
				4, 18, 27, 28, 132, 155, 156
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.spriggan.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesSpriggan = false;
		@Config.LangKey("entity.grimoireofgaia.spriggan.name")
		@Config.Comment("Spriggan")
		@Config.RequiresMcRestart
		public int[] biomesSpriggan = {
				4, 18, 27, 28, 132, 155, 156
		};

		/*
		 * TAIGA
		 * TAIGA_HILLS
		 * REDWOOD_TAIGA,
		 * REDWOOD_TAIGA_HILLS
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.cyclops.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesCyclops = false;
		@Config.LangKey("entity.grimoireofgaia.cyclops.name")
		@Config.Comment("Cyclops")
		@Config.RequiresMcRestart
		public int[] biomesCyclops = {
				5, 19, 160, 161
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.yuki-onna.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesYukiOnna = false;
		@Config.LangKey("entity.grimoireofgaia.yuki-onna.name")
		@Config.Comment("Yuki-Onna")
		@Config.RequiresMcRestart
		public int[] biomesYukiOnna = {
				5, 19, 160, 161
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.oni.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesOni = false;
		@Config.LangKey("entity.grimoireofgaia.oni.name")
		@Config.Comment("Oni")
		@Config.RequiresMcRestart
		public int[] biomesOni = {
				5, 19, 160, 161
		};


		@Config.LangKey("configgui.grimoireofgaia.category.biome.nine_tails.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesNineTails = false;
		@Config.LangKey("entity.grimoireofgaia.nine_tails.name")
		@Config.Comment("Nine Tails")
		@Config.RequiresMcRestart
		public int[] biomesNineTails = {
				5, 19, 160, 161
		};

		/*
		 * ROOFED_FOREST
		 * MUTATED_ROOFED_FOREST
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.matango.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMatango = false;
		@Config.LangKey("entity.grimoireofgaia.matango.name")
		@Config.Comment("Matango")
		@Config.RequiresMcRestart
		public int[] biomesMatango = {
				29, 157
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.toad.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesToad = false;
		@Config.LangKey("entity.grimoireofgaia.toad.name")
		@Config.Comment("Toad")
		@Config.RequiresMcRestart
		public int[] biomesToad = {
				29, 157
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.harpy_wizard.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesHarpyWizard = false;
		@Config.LangKey("entity.grimoireofgaia.harpy_wizard.name")
		@Config.Comment("Wizard Harpy")
		@Config.RequiresMcRestart
		public int[] biomesHarpyWizard = {
				29, 157
		};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.witch.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesWitch = false;
		@Config.LangKey("entity.grimoireofgaia.witch.name")
		@Config.Comment("Witch")
		@Config.RequiresMcRestart
		public int[] biomesWitch = {
				29, 157
		};

		/*
		 * UNDERGROUND
		 */
		@Config.LangKey("configgui.grimoireofgaia.category.biome.vase.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesVase = true;
		@Config.LangKey("entity.grimoireofgaia.vase.name")
		@Config.Comment("Ancient Vase")
		@Config.RequiresMcRestart
		public int[] biomesVase = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.creep.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesCreep = true;
		@Config.LangKey("entity.grimoireofgaia.creep.name")
		@Config.Comment("Creep")
		@Config.RequiresMcRestart
		public int[] biomesCreep = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.ender_eye.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesEnderEye = true;
		@Config.LangKey("entity.grimoireofgaia.ender_eye.name")
		@Config.Comment("Ender Eye")
		@Config.RequiresMcRestart
		public int[] biomesEnderEye = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.arachne.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesArachne = true;
		@Config.LangKey("entity.grimoireofgaia.arachne.name")
		@Config.Comment("Arachne")
		@Config.RequiresMcRestart
		public int[] biomesArachne = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.mimic.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesMimic = true;
		@Config.LangKey("entity.grimoireofgaia.mimic.name")
		@Config.Comment("Mimic")
		@Config.RequiresMcRestart
		public int[] biomesMimic = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.deathword.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesDeathword = true;
		@Config.LangKey("entity.grimoireofgaia.deathword.name")
		@Config.Comment("Deathword")
		@Config.RequiresMcRestart
		public int[] biomesDeathword = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.bone_knight.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesBoneKnight = true;
		@Config.LangKey("entity.grimoireofgaia.bone_knight.name")
		@Config.Comment("Bone Knight")
		@Config.RequiresMcRestart
		public int[] biomesBoneKnight = {8, 9};

		@Config.LangKey("configgui.grimoireofgaia.category.biome.flesh_lich.blacklist")
		@Config.RequiresMcRestart
		public boolean isBlackListBiomesFleshLich = true;
		@Config.LangKey("entity.grimoireofgaia.flesh_lich.name")
		@Config.Comment("Flesh Lich")
		@Config.RequiresMcRestart
		public int[] biomesFleshLich = {8, 9};

	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu3.attributes")
	@Config.Comment("Attributes")
	public static final Attributes ATTRIBUTES = new Attributes();

	public static class Attributes {
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier1maxHealth")
		@Config.Comment("Health: 40 (20 Hearts). (50 = half, 200 = double)")
		public int tier1maxHealth = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier1attackDamage")
		@Config.Comment("Damage: 4 (2 Hearts). (50 = half, 200 = double)")
		public int tier1attackDamage = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier2maxHealth")
		@Config.Comment("Health: 80 (40 Hearts). (50 = half, 200 = double)")
		public int tier2maxHealth = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier2attackDamage")
		@Config.Comment("Damage: 6 (3 Hearts). (50 = half, 200 = double)")
		public int tier2attackDamage = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier3maxHealth")
		@Config.Comment("Health: 160 (80 Hearts). (50 = half, 200 = double)")
		public int tier3maxHealth = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier3attackDamage")
		@Config.Comment("Damage: 8 (4 Hearts). (50 = half, 200 = double)")
		public int tier3attackDamage = 100;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu4.damage")
	@Config.Comment("Base Damage")
	public static final Damage DAMAGE = new Damage();

	public static class Damage {
		@Config.LangKey("configgui.grimoireofgaia.category.damage.Menu0.BaseDamage")
		@Config.Comment("Melee attacks deal an additional 2.0 (1 heart) of damage")
		public boolean baseDamage = true;
		@Config.LangKey("configgui.grimoireofgaia.category.damage.Menu2.ShieldsBlockPiercing")
		@Config.Comment("Archers arrows deal an additional 1 (0.5 heart) of damage")
		public boolean shieldsBlockPiercing = true;
		@Config.LangKey("configgui.grimoireofgaia.category.damage.Menu1.BaseDamageArchers")
		@Config.Comment("Shields Block Piercing Damage")
		public boolean baseDamageArchers = true;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu5.defense")
	@Config.Comment("Base Damage Cap")
	public static final Defense DEFENSE = new Defense();

	public static class Defense {
		@Config.LangKey("configgui.grimoireofgaia.category.defense.Tier1baseDefense")
		@Config.Comment("Maximum amount of hits required. (0 = disable)")
		public int tier1baseDefense = 2;
		@Config.LangKey("configgui.grimoireofgaia.category.defense.Tier2baseDefense")
		@Config.Comment("Maximum amount of hits required. (0 = disable)")
		public int tier2baseDefense = 4;
		@Config.LangKey("configgui.grimoireofgaia.category.defense.Tier3baseDefense")
		@Config.Comment("Maximum amount of hits required. (0 = disable)")
		public int tier3baseDefense = 8;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu6.options")
	public static final Options OPTIONS = new Options();

	public static class Options {
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu0.Enable_Spawn")
		@Config.Comment("Enable Gaia mobs to spawn")
		@Config.RequiresMcRestart
		public boolean enableSpawn = true;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu1.Passive_Hostile_Mobs")
		@Config.Comment("Hostile day mobs will no longer attack players on sight")
		public boolean passiveHostileMobs = false;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu2.Passive_Hostile_All_Mobs")
		@Config.Comment("All mobs are now hostile")
		public boolean passiveHostileAllMobs = false;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu3.AdditionalOre")
		@Config.Comment("Gaia mobs can now drop Copper and Silver Nuggets")
		public boolean additionalOre = false;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu4.StrafingArchers")
		@Config.Comment("Archers will strafe and avoid attacks (like Skeletons)")
		public boolean strafingArchers = true;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu5.DisableDrops")
		@Config.Comment("Disable drops not using loot tables.")
		public boolean disableDrops = false;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu6.DisableInvisibility")
		@Config.Comment("Disable mobs that use the Invisibility status effect when far from a player.")
		public boolean disableInvisibility = false;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu7.debug")
	@Config.Comment("Debug")
	public static final Debug DEBUG = new Debug();

	public static class Debug {
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu0.Ore_Unity")
		@Config.Comment("Mobs can drop nuggets/shards from other mods. (Disable if you encounter issues)")
		public boolean oreUnity = false;
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu1.Debug_Spawn")
		@Config.Comment("Disables all non-Gaia mobs from spawning")
		@Config.RequiresMcRestart
		public boolean debugCommands = false;
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu2.Debug_Commands")
		@Config.Comment("Enables developer commands")
		@Config.RequiresMcRestart
		public boolean debugSpawn = false;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu8.dimensions")
	@Config.Comment("Dimensional Settings")
	public static final Dimensions DIMENSIONS = new Dimensions();

	public static class Dimensions {
		@Config.LangKey("configgui.grimoireofgaia.category.dimensions.Menu0.Dimension_Blacklist")
		@Config.Comment("Disables Gaia mobs from spawning in the specified dimension ids")
		public int[] dimensionBlacklist = {};
	}
}
