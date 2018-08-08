package gaia;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

	@Config.Name("general")
	public static General general = new General();

	public static class General {
		@Config.Name("configgui.grimoireofgaia.category.general.SpawnLevel3")
		public boolean spawnLevel3 = true;
		@Config.Name("configgui.grimoireofgaia.category.general.SpawnLevel3Chance")
		public int spawnLevel3Chance = 20;
		// closed; taiga, taigaHills, megaTaiga, megaTaigaHills
		@Config.Name("entity.grimoireofgaia.Cyclops.name")
		public int spawnCyclops = 60;
		@Config.Name("entity.grimoireofgaia.Yuki-Onna.name")
		public int spawnYukiOnna = 60;
		@Config.Name("entity.grimoireofgaia.FutakuchiOnna.name")
		public int spawnFutakuchiOnna = 80;
		@Config.Name("entity.grimoireofgaia.NineTails.name")
		public int spawnNineTails = 40;
		// closed; forest, forestHills, birchForest, birchForestHills
		@Config.Name("entity.grimoireofgaia.Mandragora.name")
		public int spawnMandragora = 60;
		@Config.Name("entity.grimoireofgaia.Dryad.name")
		public int spawnDryad = 60;
		@Config.Name("entity.grimoireofgaia.Werecat.name")
		public int spawnWerecat = 80;
		@Config.Name("entity.grimoireofgaia.Spriggan.name")
		public int spawnSpriggan = 40;
		// open; desert, desertHills, mesa, mesaPlateau, mesaPlateau_F
		@Config.Name("entity.grimoireofgaia.Ant.name")
		public int spawnAnt = 30;
		@Config.Name("entity.grimoireofgaia.Mummy.name")
		public int spawnMummy = 100;
		@Config.Name("entity.grimoireofgaia.Anubis.name")
		public int spawnAnubis = 80;
		@Config.Name("entity.grimoireofgaia.Sphinx.name")
		public int spawnSphinx = 40;
		// open; plains, savanna, savannaPlateau
		@Config.Name("entity.grimoireofgaia.Satyress.name")
		public int spawnSatyress = 30;
		@Config.Name("entity.grimoireofgaia.Centaur.name")
		public int spawnCentaur = 30;
		@Config.Name("entity.grimoireofgaia.Harpy.name")
		public int spawnHarpy = 100;
		@Config.Name("entity.grimoireofgaia.Minotaurus.name")
		public int spawnMinotaurus = 80;
		@Config.Name("entity.grimoireofgaia.Minotaur.name")
		public int spawnMinotaur = 40;
		// closed; swamp
		@Config.Name("entity.grimoireofgaia.Siren.name")
		public int spawnSiren = 60;
		@Config.Name("entity.grimoireofgaia.SludgeGirl.name")
		public int spawnSludgeGirl = 100;
		@Config.Name("entity.grimoireofgaia.Naga.name")
		public int spawnNaga = 80;
		// closed; roofedForest
		@Config.Name("entity.grimoireofgaia.Matango.name")
		public int spawnMatango = 60;
		@Config.Name("entity.grimoireofgaia.Toad.name")
		public int spawnToad = 80;
		@Config.Name("entity.grimoireofgaia.Witch.name")
		public int spawnWitch = 60;
		// closed; jungle
		@Config.Name("entity.grimoireofgaia.Hunter.name")
		public int spawnHunter = 60;
		@Config.Name("entity.grimoireofgaia.CobbleGolem.name")
		public int spawnCobbleGolem = 60;
		@Config.Name("entity.grimoireofgaia.Shaman.name")
		public int spawnShaman = 60;
		@Config.Name("entity.grimoireofgaia.CobblestoneGolem.name")
		public int spawnCobblestoneGolem = 60;
		// open; icePlains, iceMountains
		@Config.Name("entity.grimoireofgaia.Selkie.name")
		public int spawnSelkie = 60;
		@Config.Name("entity.grimoireofgaia.Kobold.name")
		public int spawnKobold = 100;
		@Config.Name("entity.grimoireofgaia.Yeti.name")
		public int spawnYeti = 80;
		// closed; coldTaiga, coldTaigaHills
		@Config.Name("entity.grimoireofgaia.Dhampir.name")
		public int spawnDhampir = 80;
		@Config.Name("entity.grimoireofgaia.Vampire.name")
		public int spawnVampire = 40;
		// open; extremeHills, extremeHillsPlus
		@Config.Name("entity.grimoireofgaia.Dwarf.name")
		public int spawnDwarf = 30;
		@Config.Name("entity.grimoireofgaia.SpawnGryphon.name")
		public int spawnGryphon = 60;
		@Config.Name("entity.grimoireofgaia.Valkyrie.name")
		public int spawnValkyrie = 40;
		@Config.Name("entity.grimoireofgaia.Dullahan.name")
		public int spawnDullahan = 100;
		@Config.Name("entity.grimoireofgaia.Banshee.name")
		public int spawnBanshee = 80;
		// closed; frozenRiver, coldBeach, stoneBeach, river, beach, ocean,
		// deepOcean
		@Config.Name("entity.grimoireofgaia.Sahuagin.name")
		public int spawnSahuagin = 80;
		@Config.Name("entity.grimoireofgaia.Mermaid.name")
		public int spawnMermaid = 40;
		@Config.Name("entity.grimoireofgaia.Sharko.name")
		public int spawnSharko = 40;
		// closed; underground
		@Config.Name("entity.grimoireofgaia.Creep.name")
		public int spawnCreep = 80;
		@Config.Name("entity.grimoireofgaia.EnderEye.name")
		public int spawnEnderEye = 40;
		@Config.Name("entity.grimoireofgaia.Arachne.name")
		public int spawnArachne = 80;
		@Config.Name("entity.grimoireofgaia.Mimic.name")
		public int spawnMimic = 80;
		@Config.Name("entity.grimoireofgaia.BoneKnight.name")
		public int spawnBoneKnight = 40;
		@Config.Name("entity.grimoireofgaia.FleshLich.name")
		public int spawnFleshLich = 40;
		// closed; hell
		@Config.Name("entity.grimoireofgaia.Succubus.name")
		public int spawnSuccubus = 16;
		@Config.Name("entity.grimoireofgaia.WitherCow.name")
		public int spawnWitherCow = 8;
		@Config.Name("entity.grimoireofgaia.Baphomet.name")
		public int spawnBaphomet = 8;
		// open; sky
		@Config.Name("entity.grimoireofgaia.EnderDragonGirl.name")
		public int spawnEnderDragonGirl = 4;
	}

	@Config.Name("base damage")
	public static BaseDamage baseDamage = new BaseDamage();

	public static class BaseDamage {
		@Config.Name("configgui.grimoireofgaia.category.damage.Menu0.BaseDamage")
		public boolean baseDamage = true;
		@Config.Name("configgui.grimoireofgaia.category.damage.Menu2.ShieldsBlockPiercing")
		public boolean shieldsBlockPiercing = true;
		@Config.Name("configgui.grimoireofgaia.category.damage.Menu1.BaseDamageArchers")
		public boolean baseDamageArchers = true;
	}

	@Config.Name("defense")
	public static Defense defense = new Defense();

	public static class Defense {
		@Config.Name("configgui.grimoireofgaia.category.defense.Tier1baseDefense")
		public int tier1baseDefense = 2;
		@Config.Name("configgui.grimoireofgaia.category.defense.Tier2baseDefense")
		public int tier2baseDefense = 4;
		@Config.Name("configgui.grimoireofgaia.category.defense.Tier3baseDefense")
		public int tier3baseDefense = 8;
	}

	@Config.Name("attributes")
	public static Attributes attributes = new Attributes();

	public static class Attributes {
		@Config.Name("configgui.grimoireofgaia.category.attributes.Tier1maxHealth")
		public int tier1maxHealth = 100;
		@Config.Name("configgui.grimoireofgaia.category.attributes.Tier1attackDamage")
		public int tier1attackDamage = 100;
		@Config.Name("configgui.grimoireofgaia.category.attributes.Tier2maxHealth")
		public int tier2maxHealth = 100;
		@Config.Name("configgui.grimoireofgaia.category.attributes.Tier2attackDamage")
		public int tier2attackDamage = 100;
		@Config.Name("configgui.grimoireofgaia.category.attributes.Tier3maxHealth")
		public int tier3maxHealth = 100;
		@Config.Name("configgui.grimoireofgaia.category.attributes.Tier3attackDamage")
		public int tier3attackDamage = 100;
	}

	@Config.Name("options")
	public static Options options = new Options();

	public static class Options {
		@Config.Name("configgui.grimoireofgaia.category.options.Menu0.Enable_Spawn")
		public boolean enableSpawn = true;
		@Config.Name("configgui.grimoireofgaia.category.options.Menu1.AdditionalOre")
		public boolean additionalOre = false;
		@Config.Name("configgui.grimoireofgaia.category.options.Menu2.StrafingArchers")
		public boolean strafingArchers = true;
	}

	@Config.Name("debug")
	public static Debug debug = new Debug();

	public static class Debug {
		@Config.Name("configgui.grimoireofgaia.category.debug.Menu1.Biome_Tweaks")
		public boolean biomeTweaks = true;
		@Config.Name("configgui.grimoireofgaia.category.debug.Menu2.Ore_Unity")
		public boolean oreUnity = false;
		@Config.Name("configgui.grimoireofgaia.category.debug.Menu4.Debug_Commands")
		public boolean debugCommands = true;
		@Config.Name("configgui.grimoireofgaia.category.debug.Menu3.Debug_Spawn")
		public boolean debugSpawn = false;
	}
}
