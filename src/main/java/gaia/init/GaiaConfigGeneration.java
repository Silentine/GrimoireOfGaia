package gaia.init;

import gaia.ConfigGaia;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GaiaConfigGeneration {

	public static Configuration config;

	public static void configOptions(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig();
	}

	public static String DAMAGE = "base damage";
	public static String ATTRIBUTES = "attributes";
	public static String DEBUG = "debug";

	public static void syncConfig(){
		//Spawn Rate
		ConfigGaia.SpawnAnubis = config.get("general", "SpawnRateAnubis", ConfigGaia.SpawnAnubis).getInt();
		ConfigGaia.SpawnBanshee = config.get("general", "SpawnRateBanshee", ConfigGaia.SpawnBanshee).getInt();
		ConfigGaia.SpawnGryphon = config.get("general", "SpawnRateGryphon", ConfigGaia.SpawnGryphon).getInt();
		ConfigGaia.SpawnBaphomet = config.get("general", "SpawnRateBaphomet", ConfigGaia.SpawnBaphomet).getInt();
		ConfigGaia.SpawnBoneKnight = config.get("general", "SpawnRateBoneKnight", ConfigGaia.SpawnBoneKnight).getInt();
		ConfigGaia.SpawnCentaur = config.get("general", "SpawnRateCentaur", ConfigGaia.SpawnCentaur).getInt();
		ConfigGaia.SpawnNineTails = config.get("general", "SpawnRateNineTails", ConfigGaia.SpawnNineTails).getInt();
		ConfigGaia.SpawnCobbleGolem = config.get("general", "SpawnRateCobbleGolem", ConfigGaia.SpawnCobbleGolem).getInt();
		ConfigGaia.SpawnCobblestoneGolem = config.get("general", "SpawnRateCobblestoneGolem", ConfigGaia.SpawnCobblestoneGolem).getInt();
		ConfigGaia.SpawnCockatrice = config.get("general", "SpawnRateCockatrice", ConfigGaia.SpawnCockatrice).getInt();
		ConfigGaia.SpawnCreep = config.get("general", "SpawnRateCreep", ConfigGaia.SpawnCreep).getInt();
		ConfigGaia.SpawnCyclops = config.get("general", "SpawnRateCyclops", ConfigGaia.SpawnCyclops).getInt();
		ConfigGaia.SpawnDhampir = config.get("general", "SpawnRateDhampir", ConfigGaia.SpawnDhampir).getInt();
		ConfigGaia.SpawnDryad = config.get("general", "SpawnRateDryad", ConfigGaia.SpawnDryad).getInt();
		ConfigGaia.SpawnDullahan = config.get("general", "SpawnRateDullahan", ConfigGaia.SpawnDullahan).getInt();
		ConfigGaia.SpawnEnderDragonGirl = config.get("general", "SpawnRateEnderDragonGirl", ConfigGaia.SpawnEnderDragonGirl).getInt();
		ConfigGaia.SpawnEnderEye = config.get("general", "SpawnRateEnderEye", ConfigGaia.SpawnEnderEye).getInt();
		ConfigGaia.SpawnFleshLich = config.get("general", "SpawnRateFleshLich", ConfigGaia.SpawnFleshLich).getInt();
		ConfigGaia.SpawnFutakuchiOnna = config.get("general", "SpawnRateFutakuchiOnna", ConfigGaia.SpawnFutakuchiOnna).getInt();
		ConfigGaia.SpawnHarpy = config.get("general", "SpawnRateHarpy", ConfigGaia.SpawnHarpy).getInt();
		ConfigGaia.SpawnHunter = config.get("general", "SpawnRateHunter", ConfigGaia.SpawnHunter).getInt();
		ConfigGaia.SpawnJorogumo = config.get("general", "SpawnRateJorogumo", ConfigGaia.SpawnJorogumo).getInt();
		ConfigGaia.SpawnMatango = config.get("general", "SpawnRateSpawnMatango", ConfigGaia.SpawnMatango).getInt();
		ConfigGaia.SpawnMandragora = config.get("general", "SpawnRateSpawnMandragora", ConfigGaia.SpawnMandragora).getInt();
		ConfigGaia.SpawnMermaid = config.get("general", "SpawnRateMermaid", ConfigGaia.SpawnMermaid).getInt();
		ConfigGaia.SpawnMimic = config.get("general", "SpawnRateMimic", ConfigGaia.SpawnMimic).getInt();
		ConfigGaia.SpawnMinotaur = config.get("general", "SpawnRateMinotaur", ConfigGaia.SpawnMinotaur).getInt();
		ConfigGaia.SpawnMinotaurus = config.get("general", "SpawnRateMinotaurus", ConfigGaia.SpawnMinotaurus).getInt();
		ConfigGaia.SpawnNaga = config.get("general", "SpawnRateNaga", ConfigGaia.SpawnNaga).getInt();
		ConfigGaia.SpawnSahuagin = config.get("general", "SpawnRateSahuagin", ConfigGaia.SpawnSahuagin).getInt();
		ConfigGaia.SpawnSatyr = config.get("general", "SpawnRateSatyr", ConfigGaia.SpawnSatyr).getInt();
		ConfigGaia.SpawnSelkie = config.get("general", "SpawnRateSelkie", ConfigGaia.SpawnSelkie).getInt();
		ConfigGaia.SpawnShaman = config.get("general", "SpawnRateShaman", ConfigGaia.SpawnShaman).getInt();
		ConfigGaia.SpawnSharko = config.get("general", "SpawnRateSharko", ConfigGaia.SpawnSharko).getInt();
		ConfigGaia.SpawnSiren = config.get("general", "SpawnRateSiren", ConfigGaia.SpawnSiren).getInt();
		ConfigGaia.SpawnSludgeGirl = config.get("general", "SpawnSludgeGirl", ConfigGaia.SpawnSludgeGirl).getInt();
		ConfigGaia.SpawnSphinx = config.get("general", "SpawnRateSphinx", ConfigGaia.SpawnSphinx).getInt();
		ConfigGaia.SpawnSpriggan = config.get("general", "SpawnRateSpriggan", ConfigGaia.SpawnSpriggan).getInt();
		ConfigGaia.SpawnSuccubus = config.get("general", "SpawnRateSuccubus", ConfigGaia.SpawnSuccubus).getInt();
		ConfigGaia.SpawnSwamper = config.get("general", "SpawnRateSwamper", ConfigGaia.SpawnSwamper).getInt();
		ConfigGaia.SpawnValkyrie = config.get("general", "SpawnRateValkyrie", ConfigGaia.SpawnValkyrie).getInt();
		ConfigGaia.SpawnVampire = config.get("general", "SpawnRateVampire", ConfigGaia.SpawnVampire).getInt();
		ConfigGaia.SpawnWerecat = config.get("general", "SpawnRateWerecat", ConfigGaia.SpawnWerecat).getInt();
		ConfigGaia.SpawnWitch = config.get("general", "SpawnRateWitch", ConfigGaia.SpawnWitch).getInt();
		ConfigGaia.SpawnWitherCow = config.get("general", "SpawnRateWitherCow", ConfigGaia.SpawnWitherCow).getInt();
		ConfigGaia.SpawnYeti = config.get("general", "SpawnRateYeti", ConfigGaia.SpawnYeti).getInt();
		ConfigGaia.SpawnYukiOnna = config.get("general", "SpawnRateYukiOnna", ConfigGaia.SpawnYukiOnna).getInt();

		//Base Damage
		ConfigGaia.BaseDamage = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.BaseDamage", true).getBoolean(true);
		ConfigGaia.ShieldsBlockPiercing = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.ShieldsBlockPiercing", true).getBoolean(true);
		ConfigGaia.HardmodeArchers = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.HardmodeArchers", true).getBoolean(true);
		
		//Attributes
		ConfigGaia.Tier1maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier1maxHealth", ConfigGaia.Tier1maxHealth).getInt();
		ConfigGaia.Tier1attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier1attackDamage", ConfigGaia.Tier1attackDamage).getInt();
		ConfigGaia.Tier2maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier2maxHealth", ConfigGaia.Tier2maxHealth).getInt();
		ConfigGaia.Tier2attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier2attackDamage", ConfigGaia.Tier2attackDamage).getInt();
		ConfigGaia.Tier3maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier3maxHealth", ConfigGaia.Tier3maxHealth).getInt();
		ConfigGaia.Tier3attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier3attackDamage", ConfigGaia.Tier3attackDamage).getInt();

		//Debugging
		ConfigGaia.Spawn_Debug_Mode = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Spawn_Debug_Mode", false).getBoolean(false);
		ConfigGaia.Debug_Commands = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Debug_Commands", false).getBoolean(false);
		
		
		//Descriptions
		// Disabled due to it messing up the ConfigGui by including an extra input box
		/*
		Property generalproperty = config.get("general", "", "");
		generalproperty.comment = "Set to 0 to disable mob from spawning. Recommended: 10> Day, <100 Night";
		Property basedamageproperty = config.get("base damage", "", "");
		basedamageproperty.comment = "If set to true, all mobs will deal an additional 1.0 magical damage (bypasses armor)";
		Property attributesproperty = config.get("attributes", "", "");
		attributesproperty.comment = "Attributes based on percentage. WARNING: Do not set below 50";
		*/
		if(config.hasChanged())
			config.save();
	}
}