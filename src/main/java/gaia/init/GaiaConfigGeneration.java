package gaia.init;

import gaia.GaiaConfig;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GaiaConfigGeneration extends GaiaConfig{

	public static Configuration config;

	public static void configOptions(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig();
	}

	//When adding new categories, update Config_Gui as well
	public static String DAMAGE = "base damage";
//	public static String DEFENSE = "defense";
	public static String ATTRIBUTES = "attributes";
	public static String OPTIONS = "options";
	public static String DEBUG = "debug";

	public static void syncConfig() {
		//Spawn Rate
		SpawnAnt = config.get("general", "entity.grimoireofgaia.Ant.name", SpawnAnt).getInt();
		SpawnAnubis = config.get("general", "entity.grimoireofgaia.Anubis.name", SpawnAnubis).getInt();
		SpawnArachne = config.get("general", "entity.grimoireofgaia.Arachne.name", SpawnArachne).getInt();
		SpawnBanshee = config.get("general", "entity.grimoireofgaia.Banshee.name", SpawnBanshee).getInt();
		SpawnBaphomet = config.get("general", "entity.grimoireofgaia.Baphomet.name", SpawnBaphomet).getInt();
		SpawnBoneKnight = config.get("general", "entity.grimoireofgaia.BoneKnight.name", SpawnBoneKnight).getInt();
		SpawnCentaur = config.get("general", "entity.grimoireofgaia.Centaur.name", SpawnCentaur).getInt();
		SpawnCobbleGolem = config.get("general", "entity.grimoireofgaia.CobbleGolem.name", SpawnCobbleGolem).getInt();
		SpawnCobblestoneGolem = config.get("general", "entity.grimoireofgaia.CobblestoneGolem.name", SpawnCobblestoneGolem).getInt();
		SpawnCreep = config.get("general", "entity.grimoireofgaia.Creep.name", SpawnCreep).getInt();
		SpawnCyclops = config.get("general", "entity.grimoireofgaia.Cyclops.name", SpawnCyclops).getInt();
		SpawnDhampir = config.get("general", "entity.grimoireofgaia.Dhampir.name", SpawnDhampir).getInt();
		SpawnDryad = config.get("general", "entity.grimoireofgaia.Dryad.name", SpawnDryad).getInt();
		SpawnDullahan = config.get("general", "entity.grimoireofgaia.Dullahan.name", SpawnDullahan).getInt();
		SpawnDwarf = config.get("general", "entity.grimoireofgaia.Dwarf.name", SpawnDwarf).getInt();
		SpawnEnderDragonGirl = config.get("general", "entity.grimoireofgaia.EnderDragonGirl.name", SpawnEnderDragonGirl).getInt();
		SpawnEnderEye = config.get("general", "entity.grimoireofgaia.EnderEye.name", SpawnEnderEye).getInt();
		SpawnFleshLich = config.get("general", "entity.grimoireofgaia.FleshLich.name", SpawnFleshLich).getInt();
		SpawnFutakuchiOnna = config.get("general", "entity.grimoireofgaia.FutakuchiOnna.name", SpawnFutakuchiOnna).getInt();
		SpawnHarpy = config.get("general", "entity.grimoireofgaia.Harpy.name", SpawnHarpy).getInt();
		SpawnHunter = config.get("general", "entity.grimoireofgaia.Hunter.name", SpawnHunter).getInt();
		SpawnKobold = config.get("general", "entity.grimoireofgaia.Kobold.name", SpawnKobold).getInt();
		SpawnMandragora = config.get("general", "entity.grimoireofgaia.Mandragora.name", SpawnMandragora).getInt();
		SpawnMatango = config.get("general", "entity.grimoireofgaia.Matango.name", SpawnMatango).getInt();
		SpawnMermaid = config.get("general", "entity.grimoireofgaia.Mermaid.name", SpawnMermaid).getInt();
		SpawnMimic = config.get("general", "entity.grimoireofgaia.Mimic.name", SpawnMimic).getInt();
		SpawnMinotaur = config.get("general", "entity.grimoireofgaia.Minotaur.name", SpawnMinotaur).getInt();
		SpawnMinotaurus = config.get("general", "entity.grimoireofgaia.Minotaurus.name", SpawnMinotaurus).getInt();
		SpawnMummy = config.get("general", "entity.grimoireofgaia.Mummy.name", SpawnMummy).getInt();
		SpawnNaga = config.get("general", "entity.grimoireofgaia.Naga.name", SpawnNaga).getInt();
		SpawnNineTails = config.get("general", "entity.grimoireofgaia.NineTails.name", SpawnNineTails).getInt();
		SpawnSahuagin = config.get("general", "entity.grimoireofgaia.Sahuagin.name", SpawnSahuagin).getInt();
		SpawnSatyress = config.get("general", "entity.grimoireofgaia.Satyress.name", SpawnSatyress).getInt();
		SpawnSelkie = config.get("general", "entity.grimoireofgaia.Selkie.name", SpawnSelkie).getInt();
		SpawnShaman = config.get("general", "entity.grimoireofgaia.Shaman.name", SpawnShaman).getInt();
		SpawnSharko = config.get("general", "entity.grimoireofgaia.Sharko.name", SpawnSharko).getInt();
		SpawnSiren = config.get("general", "entity.grimoireofgaia.Siren.name", SpawnSiren).getInt();
		SpawnSludgeGirl = config.get("general", "entity.grimoireofgaia.SludgeGirl.name", SpawnSludgeGirl).getInt();
		SpawnSphinx = config.get("general", "entity.grimoireofgaia.Sphinx.name", SpawnSphinx).getInt();
		SpawnSpriggan = config.get("general", "entity.grimoireofgaia.Spriggan.name", SpawnSpriggan).getInt();
		SpawnSuccubus = config.get("general", "entity.grimoireofgaia.Succubus.name", SpawnSuccubus).getInt();
		SpawnToad = config.get("general", "entity.grimoireofgaia.Toad.name", SpawnToad).getInt();
		SpawnValkyrie = config.get("general", "entity.grimoireofgaia.Valkyrie.name", SpawnValkyrie).getInt();
		SpawnVampire = config.get("general", "entity.grimoireofgaia.Vampire.name", SpawnVampire).getInt();
		SpawnWerecat = config.get("general", "entity.grimoireofgaia.Werecat.name", SpawnWerecat).getInt();
		SpawnWitch = config.get("general", "entity.grimoireofgaia.Witch.name", SpawnWitch).getInt();
		SpawnWitherCow = config.get("general", "entity.grimoireofgaia.WitherCow.name", SpawnWitherCow).getInt();
		SpawnYeti = config.get("general", "entity.grimoireofgaia.Yeti.name", SpawnYeti).getInt();
		SpawnYukiOnna = config.get("general", "entity.grimoireofgaia.Yuki-Onna.name", SpawnYukiOnna).getInt();
		//Level 3
		SpawnLevel3 = config.get("general", "configgui.GrimoireOfGaia.category.general.SpawnLevel3", true).getBoolean(true);
		SpawnLevel3Chance = config.get("general", "configgui.GrimoireOfGaia.category.general.SpawnLevel3Chance", SpawnLevel3Chance).getInt();

		//Base Damage
		BaseDamage = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.Menu0.BaseDamage", true).getBoolean(true);
		BaseDamageArchers = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.Menu1.BaseDamageArchers", true).getBoolean(true);
		ShieldsBlockPiercing = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.Menu2.ShieldsBlockPiercing", true).getBoolean(true);

		//Base Defense
//		BaseDefense = config.get("defense", "configgui.GrimoireOfGaia.category.defense.BaseDefense", BaseDefense).getInt();
		
		//Attributes
		Tier1maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier1maxHealth", Tier1maxHealth).getInt();
		Tier1attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier1attackDamage", Tier1attackDamage).getInt();
		Tier2maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier2maxHealth", Tier2maxHealth).getInt();
		Tier2attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier2attackDamage", Tier2attackDamage).getInt();
		Tier3maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier3maxHealth", Tier3maxHealth).getInt();
		Tier3attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier3attackDamage", Tier3attackDamage).getInt();

		//Options
		Enable_Spawn = config.get("options", "configgui.GrimoireOfGaia.category.options.Menu0.Enable_Spawn", true).getBoolean(true);
		AdditionalOre = config.get("options", "configgui.GrimoireOfGaia.category.options.Menu1.AdditionalOre", false).getBoolean(false);
		StrafingArchers = config.get("options", "configgui.GrimoireOfGaia.category.options.Menu2.StrafingArchers", true).getBoolean(true);
		
		//Debug
		Biome_Tweaks = 	config.get("debug", "configgui.GrimoireOfGaia.category.debug.Menu1.Biome_Tweaks", true).getBoolean(true);
		OreUnity = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Menu2.Ore_Unity", false).getBoolean(false);
		Debug_Spawn = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Menu3.Debug_Spawn", false).getBoolean(false);
		Debug_Commands = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Menu4.Debug_Commands", false).getBoolean(false);
		
		if(config.hasChanged())
			config.save();
	}
}