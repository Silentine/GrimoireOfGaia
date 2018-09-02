package gaia;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@SuppressWarnings("WeakerAccess") //forge needs public access to fields here to write values from config
@Config(modid = GaiaReference.MOD_ID, category = "")
public class GaiaConfig {
	private GaiaConfig() {}

	@SuppressWarnings({"unused", "squid:S3985"})
	@Mod.EventBusSubscriber(modid = GaiaReference.MOD_ID)
	private static class EventHandler {

		private EventHandler() {}

		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(GaiaReference.MOD_ID)) {
				ConfigManager.sync(GaiaReference.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu0.general")
	public static final General GENERAL = new General();

	public static class General {
		// closed; taiga, taigaHills, megaTaiga, megaTaigaHills
		@Config.LangKey("entity.grimoireofgaia.cyclops.name")
		public int spawnCyclops = 60;
		@Config.LangKey("entity.grimoireofgaia.yuki-onna.name")
		public int spawnYukiOnna = 60;
		@Config.LangKey("entity.grimoireofgaia.futakuchi_onna.name")
		public int spawnFutakuchiOnna = 80;
		@Config.LangKey("entity.grimoireofgaia.nine_tails.name")
		public int spawnNineTails = 40;
		// closed; forest, forestHills, birchForest, birchForestHills
		@Config.LangKey("entity.grimoireofgaia.mandragora.name")
		public int spawnMandragora = 60;
		@Config.LangKey("entity.grimoireofgaia.dryad.name")
		public int spawnDryad = 60;
		@Config.LangKey("entity.grimoireofgaia.werecat.name")
		public int spawnWerecat = 80;
		@Config.LangKey("entity.grimoireofgaia.spriggan.name")
		public int spawnSpriggan = 40;
		// open; desert, desertHills, mesa, mesaPlateau, mesaPlateau_F
		@Config.LangKey("entity.grimoireofgaia.ant.name")
		public int spawnAnt = 30;
		@Config.LangKey("entity.grimoireofgaia.mummy.name")
		public int spawnMummy = 100;
		@Config.LangKey("entity.grimoireofgaia.anubis.name")
		public int spawnAnubis = 80;
		@Config.LangKey("entity.grimoireofgaia.sphinx.name")
		public int spawnSphinx = 40;
		// open; plains, savanna, savannaPlateau
		@Config.LangKey("entity.grimoireofgaia.satyress.name")
		public int spawnSatyress = 30;
		@Config.LangKey("entity.grimoireofgaia.centaur.name")
		public int spawnCentaur = 30;
		@Config.LangKey("entity.grimoireofgaia.harpy.name")
		public int spawnHarpy = 100;
		@Config.LangKey("entity.grimoireofgaia.minotaurus.name")
		public int spawnMinotaurus = 80;
		@Config.LangKey("entity.grimoireofgaia.minotaur.name")
		public int spawnMinotaur = 40;
		// closed; swamp
		@Config.LangKey("entity.grimoireofgaia.siren.name")
		public int spawnSiren = 60;
		@Config.LangKey("entity.grimoireofgaia.sludge_girl.name")
		public int spawnSludgeGirl = 100;
		@Config.LangKey("entity.grimoireofgaia.naga.name")
		public int spawnNaga = 80;
		// closed; roofedForest
		@Config.LangKey("entity.grimoireofgaia.matango.name")
		public int spawnMatango = 60;
		@Config.LangKey("entity.grimoireofgaia.toad.name")
		public int spawnToad = 80;
		@Config.LangKey("entity.grimoireofgaia.witch.name")
		public int spawnWitch = 60;
		// closed; jungle
		@Config.LangKey("entity.grimoireofgaia.hunter.name")
		public int spawnHunter = 60;
		@Config.LangKey("entity.grimoireofgaia.cobble_golem.name")
		public int spawnCobbleGolem = 60;
		@Config.LangKey("entity.grimoireofgaia.shaman.name")
		public int spawnShaman = 60;
		@Config.LangKey("entity.grimoireofgaia.cobblestone_golem.name")
		public int spawnCobblestoneGolem = 60;
		// open; icePlains, iceMountains
		@Config.LangKey("entity.grimoireofgaia.selkie.name")
		public int spawnSelkie = 60;
		@Config.LangKey("entity.grimoireofgaia.kobold.name")
		public int spawnKobold = 100;
		@Config.LangKey("entity.grimoireofgaia.yeti.name")
		public int spawnYeti = 80;
		// closed; coldTaiga, coldTaigaHills
		@Config.LangKey("entity.grimoireofgaia.dhampir.name")
		public int spawnDhampir = 80;
		@Config.LangKey("entity.grimoireofgaia.vampire.name")
		public int spawnVampire = 40;
		// open; extremeHills, extremeHillsPlus
		@Config.LangKey("entity.grimoireofgaia.dwarf.name")
		public int spawnDwarf = 30;
		@Config.LangKey("entity.grimoireofgaia.gryphon.name")
		public int spawnGryphon = 60;
		@Config.LangKey("entity.grimoireofgaia.valkyrie.name")
		public int spawnValkyrie = 40;
		@Config.LangKey("entity.grimoireofgaia.dullahan.name")
		public int spawnDullahan = 100;
		@Config.LangKey("entity.grimoireofgaia.banshee.name")
		public int spawnBanshee = 80;
		// closed; frozenRiver, coldBeach, stoneBeach, river, beach, ocean,
		// deepOcean
		@Config.LangKey("entity.grimoireofgaia.sahuagin.name")
		public int spawnSahuagin = 80;
		@Config.LangKey("entity.grimoireofgaia.mermaid.name")
		public int spawnMermaid = 40;
		@Config.LangKey("entity.grimoireofgaia.sharko.name")
		public int spawnSharko = 40;
		// closed; underground
		@Config.LangKey("entity.grimoireofgaia.creep.name")
		public int spawnCreep = 80;
		@Config.LangKey("entity.grimoireofgaia.ender_eye.name")
		public int spawnEnderEye = 40;
		@Config.LangKey("entity.grimoireofgaia.arachne.name")
		public int spawnArachne = 80;
		@Config.LangKey("entity.grimoireofgaia.mimic.name")
		public int spawnMimic = 80;
		@Config.LangKey("entity.grimoireofgaia.bone_knight.name")
		public int spawnBoneKnight = 40;
		@Config.LangKey("entity.grimoireofgaia.flesh_lich.name")
		public int spawnFleshLich = 40;
		// closed; hell
		@Config.LangKey("entity.grimoireofgaia.succubus.name")
		public int spawnSuccubus = 16;
		@Config.LangKey("entity.grimoireofgaia.wither_cow.name")
		public int spawnWitherCow = 8;
		@Config.LangKey("entity.grimoireofgaia.baphomet.name")
		public int spawnBaphomet = 8;
		// open; sky
		@Config.LangKey("entity.grimoireofgaia.ender_dragon_girl.name")
		public int spawnEnderDragonGirl = 4;
	}
	
	@Config.LangKey("configgui.grimoireofgaia.category.Menu1.spawns")
	public static final Spawn SPAWN = new Spawn();

	public static class Spawn {
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu0.SpawnDaysPassed")
		public boolean spawnDaysPassed = false;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu1.SpawnDaysSet")
		public int spawnDaysSet = 3;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu2.SpawnLevel3Rain")
		public boolean spawnLevel3Rain = false;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu3.SpawnLevel3")
		public boolean spawnLevel3 = true;
		@Config.LangKey("configgui.grimoireofgaia.category.spawn.Menu4.SpawnLevel3Chance")
		public int spawnLevel3Chance = 20;
	}
	
	@Config.LangKey("configgui.grimoireofgaia.category.Menu2.attributes")
	public static final Attributes ATTRIBUTES = new Attributes();

	public static class Attributes {
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier1maxHealth")
		public int tier1maxHealth = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier1attackDamage")
		public int tier1attackDamage = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier2maxHealth")
		public int tier2maxHealth = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier2attackDamage")
		public int tier2attackDamage = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier3maxHealth")
		public int tier3maxHealth = 100;
		@Config.LangKey("configgui.grimoireofgaia.category.attributes.Tier3attackDamage")
		public int tier3attackDamage = 100;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu3.damage")
	public static final Damage DAMAGE = new Damage();

	public static class Damage {
		@Config.LangKey("configgui.grimoireofgaia.category.damage.Menu0.BaseDamage")
		public boolean baseDamage = true;
		@Config.LangKey("configgui.grimoireofgaia.category.damage.Menu2.ShieldsBlockPiercing")
		public boolean shieldsBlockPiercing = true;
		@Config.LangKey("configgui.grimoireofgaia.category.damage.Menu1.BaseDamageArchers")
		public boolean baseDamageArchers = true;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu4.defense")
	public static final Defense DEFENSE = new Defense();

	public static class Defense {
		@Config.LangKey("configgui.grimoireofgaia.category.defense.Tier1baseDefense")
		public int tier1baseDefense = 2;
		@Config.LangKey("configgui.grimoireofgaia.category.defense.Tier2baseDefense")
		public int tier2baseDefense = 4;
		@Config.LangKey("configgui.grimoireofgaia.category.defense.Tier3baseDefense")
		public int tier3baseDefense = 8;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu5.options")
	public static final Options OPTIONS = new Options();

	public static class Options {
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu0.Enable_Spawn")
		@Config.RequiresMcRestart
		public boolean enableSpawn = true;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu1.AdditionalOre")
		public boolean additionalOre = false;
		@Config.LangKey("configgui.grimoireofgaia.category.options.Menu2.StrafingArchers")
		public boolean strafingArchers = true;
	}

	@Config.LangKey("configgui.grimoireofgaia.category.Menu6.debug")
	public static final Debug DEBUG = new Debug();

	public static class Debug {
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu1.Biome_Tweaks")
		@Config.RequiresMcRestart
		public boolean biomeTweaks = true;
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu2.Ore_Unity")
		public boolean oreUnity = false;
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu4.Debug_Commands")
		@Config.RequiresMcRestart
		public boolean debugCommands = false;
		@Config.LangKey("configgui.grimoireofgaia.category.debug.Menu3.Debug_Spawn")
		@Config.RequiresMcRestart
		public boolean debugSpawn = false;
	}
}
