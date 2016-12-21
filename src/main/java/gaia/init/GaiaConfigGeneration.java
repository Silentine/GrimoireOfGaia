package gaia.init;

import gaia.ConfigGaia;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class GaiaConfigGeneration extends ConfigGaia{

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
		SpawnAnubis = config.get("general", "SpawnRateAnubis", SpawnAnubis).getInt();
		SpawnBanshee = config.get("general", "SpawnRateBanshee", SpawnBanshee).getInt();
		SpawnGryphon = config.get("general", "SpawnRateGryphon", SpawnGryphon).getInt();
		SpawnBaphomet = config.get("general", "SpawnRateBaphomet", SpawnBaphomet).getInt();
		SpawnBoneKnight = config.get("general", "SpawnRateBoneKnight", SpawnBoneKnight).getInt();
		SpawnCentaur = config.get("general", "SpawnRateCentaur", SpawnCentaur).getInt();
		SpawnNineTails = config.get("general", "SpawnRateNineTails", SpawnNineTails).getInt();
		SpawnCobbleGolem = config.get("general", "SpawnRateCobbleGolem", SpawnCobbleGolem).getInt();
		SpawnCobblestoneGolem = config.get("general", "SpawnRateCobblestoneGolem", SpawnCobblestoneGolem).getInt();
		SpawnCockatrice = config.get("general", "SpawnRateCockatrice", SpawnCockatrice).getInt();
		SpawnCreep = config.get("general", "SpawnRateCreep", SpawnCreep).getInt();
		SpawnCyclops = config.get("general", "SpawnRateCyclops", SpawnCyclops).getInt();
		SpawnDhampir = config.get("general", "SpawnRateDhampir", SpawnDhampir).getInt();
		SpawnDryad = config.get("general", "SpawnRateDryad", SpawnDryad).getInt();
		SpawnDullahan = config.get("general", "SpawnRateDullahan", SpawnDullahan).getInt();
		SpawnEnderDragonGirl = config.get("general", "SpawnRateEnderDragonGirl", SpawnEnderDragonGirl).getInt();
		SpawnEnderEye = config.get("general", "SpawnRateEnderEye", SpawnEnderEye).getInt();
		SpawnFleshLich = config.get("general", "SpawnRateFleshLich", SpawnFleshLich).getInt();
		SpawnFutakuchiOnna = config.get("general", "SpawnRateFutakuchiOnna", SpawnFutakuchiOnna).getInt();
		SpawnHarpy = config.get("general", "SpawnRateHarpy", SpawnHarpy).getInt();
		SpawnHunter = config.get("general", "SpawnRateHunter", SpawnHunter).getInt();
		SpawnJorogumo = config.get("general", "SpawnRateJorogumo", SpawnJorogumo).getInt();
		SpawnMatango = config.get("general", "SpawnRateSpawnMatango", SpawnMatango).getInt();
		SpawnMandragora = config.get("general", "SpawnRateSpawnMandragora", SpawnMandragora).getInt();
		SpawnMermaid = config.get("general", "SpawnRateMermaid", SpawnMermaid).getInt();
		SpawnMimic = config.get("general", "SpawnRateMimic", SpawnMimic).getInt();
		SpawnMinotaur = config.get("general", "SpawnRateMinotaur", SpawnMinotaur).getInt();
		SpawnMinotaurus = config.get("general", "SpawnRateMinotaurus", SpawnMinotaurus).getInt();
		SpawnNaga = config.get("general", "SpawnRateNaga", SpawnNaga).getInt();
		SpawnSahuagin = config.get("general", "SpawnRateSahuagin", SpawnSahuagin).getInt();
		SpawnSatyr = config.get("general", "SpawnRateSatyr", SpawnSatyr).getInt();
		SpawnSelkie = config.get("general", "SpawnRateSelkie", SpawnSelkie).getInt();
		SpawnShaman = config.get("general", "SpawnRateShaman", SpawnShaman).getInt();
		SpawnSharko = config.get("general", "SpawnRateSharko", SpawnSharko).getInt();
		SpawnSiren = config.get("general", "SpawnRateSiren", SpawnSiren).getInt();
		SpawnSludgeGirl = config.get("general", "SpawnSludgeGirl", SpawnSludgeGirl).getInt();
		SpawnSphinx = config.get("general", "SpawnRateSphinx", SpawnSphinx).getInt();
		SpawnSpriggan = config.get("general", "SpawnRateSpriggan", SpawnSpriggan).getInt();
		SpawnSuccubus = config.get("general", "SpawnRateSuccubus", SpawnSuccubus).getInt();
		SpawnSwamper = config.get("general", "SpawnRateSwamper", SpawnSwamper).getInt();
		SpawnValkyrie = config.get("general", "SpawnRateValkyrie", SpawnValkyrie).getInt();
		SpawnVampire = config.get("general", "SpawnRateVampire", SpawnVampire).getInt();
		SpawnWerecat = config.get("general", "SpawnRateWerecat", SpawnWerecat).getInt();
		SpawnWitch = config.get("general", "SpawnRateWitch", SpawnWitch).getInt();
		SpawnWitherCow = config.get("general", "SpawnRateWitherCow", SpawnWitherCow).getInt();
		SpawnYeti = config.get("general", "SpawnRateYeti", SpawnYeti).getInt();
		SpawnYukiOnna = config.get("general", "SpawnRateYukiOnna", SpawnYukiOnna).getInt();

		//Base Damage
		BaseDamage = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.BaseDamage", true).getBoolean(true);
		ShieldsBlockPiercing = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.ShieldsBlockPiercing", true).getBoolean(true);
		HardmodeArchers = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.HardmodeArchers", true).getBoolean(true);
		StrafingArchers = config.get("base damage", "configgui.GrimoireOfGaia.category.damage.StrafingArchers", true).getBoolean(true);
		//Attributes
		Tier1maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier1maxHealth", Tier1maxHealth).getInt();
		Tier1attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier1attackDamage", Tier1attackDamage).getInt();
		Tier2maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier2maxHealth", Tier2maxHealth).getInt();
		Tier2attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier2attackDamage", Tier2attackDamage).getInt();
		Tier3maxHealth = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier3maxHealth", Tier3maxHealth).getInt();
		Tier3attackDamage = config.get("attributes", "configgui.GrimoireOfGaia.category.attributes.Tier3attackDamage", Tier3attackDamage).getInt();

		//Debugging
		Spawn_Debug_Mode = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Spawn_Debug_Mode", false).getBoolean(false);
		Debug_Commands = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Debug_Commands", false).getBoolean(false);
		Biome_Tweaks = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Biome_Tweaks", true).getBoolean(true);
		OreUnity = config.get("debug", "configgui.GrimoireOfGaia.category.debug.Ore_Unity", true).getBoolean(true);
		
		
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