package gaia.init;

import gaia.ConfigGaia;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class GaiaConfig {
	
	public static void configOptions(Configuration config) {
		config.load();
		
		//Spawning
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
		ConfigGaia.SpawnKobold = config.get("general", "SpawnRateSpawnKobold", ConfigGaia.SpawnKobold).getInt();
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
		//Base damage
		ConfigGaia.BaseDamage = config.get("BASE DAMAGE", "BaseDamage", true).getBoolean(true);
		//Tier info
		ConfigGaia.Tier1maxHealth = config.get("MODIFIER", "Tier1maxHealth", ConfigGaia.Tier1maxHealth).getInt();
		ConfigGaia.Tier1attackDamage = config.get("MODIFIER", "Tier1attackDamage", ConfigGaia.Tier1attackDamage).getInt();
		ConfigGaia.Tier2maxHealth = config.get("MODIFIER", "Tier2maxHealth", ConfigGaia.Tier2maxHealth).getInt();
		ConfigGaia.Tier2attackDamage = config.get("MODIFIER", "Tier2attackDamage", ConfigGaia.Tier2attackDamage).getInt();
		ConfigGaia.Tier3maxHealth = config.get("MODIFIER", "Tier3maxHealth", ConfigGaia.Tier3maxHealth).getInt();
		ConfigGaia.Tier3attackDamage = config.get("MODIFIER", "Tier3attackDamage", ConfigGaia.Tier3attackDamage).getInt();
	
		Property generalproperty = config.get("general", " ", " ");
		generalproperty.comment = "Spawn Rate. Set to 0 to disable mob from spawning. Recommended: 10> Day, <100 Night";
		Property basedamageproperty = config.get("BASE DAMAGE", " ", " ");
		basedamageproperty.comment = "If BaseDamage is set to true, all mobs will deal 1.0 piercing damage (ignores armor).";
		Property modifierproperty = config.get("MODIFIER", " ", " ");
		modifierproperty.comment = "Percentage amount. Default value: 100";
		config.save();
		config.load();
	}
}
