package gaia;

import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaBanshee;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.entity.monster.EntityGaiaBoneKnight;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaCyclops;
import gaia.entity.monster.EntityGaiaDhampir;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.entity.monster.EntityGaiaFleshLich;
import gaia.entity.monster.EntityGaiaFutakuchiOnna;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaJorogumo;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaNineTails;
import gaia.entity.monster.EntityGaiaSahuagin;
import gaia.entity.monster.EntityGaiaSatyr;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.entity.monster.EntityGaiaShaman;
import gaia.entity.monster.EntityGaiaSharko;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.entity.monster.EntityGaiaSpriggan;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.entity.monster.EntityGaiaSwamper;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.init.GaiaItem;
import gaia.items.GaiaItemHandlerFuel;
import gaia.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(
		modid = "gaia",
		name = "Grimoire of Gaia 3",
		version = "1.0.0"
		)
/*
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
		)
*/

public class Gaia 
{
	public static final String modid = "GrimoireOfGaia";
	@Instance("GrimoireOfGaia")
	public static Gaia instance = new Gaia();
	@SidedProxy(
			clientSide = "gaia.proxy.ClientProxy",
			serverSide = "gaia.proxy.CommonProxy"
			)
	public static CommonProxy proxy;
	public static CreativeTabs tabGaia = new CreativeTabs("tabGaia") 
	{
		@Override
		public Item getTabIconItem() {
			return GaiaItem.FoodBerryHealth;
		}

	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		ConfigGaia.SpawnAnubis = cfg.get("general", "SpawnRateAnubis", ConfigGaia.SpawnAnubis).getInt();
		/*ConfigGaia.SpawnBanshee = cfg.get("general", "SpawnRateBanshee", ConfigGaia.SpawnBanshee).getInt();
		ConfigGaia.SpawnGryphon = cfg.get("general", "SpawnRateGryphon", ConfigGaia.SpawnGryphon).getInt();
		ConfigGaia.SpawnBaphomet = cfg.get("general", "SpawnRateBaphomet", ConfigGaia.SpawnBaphomet).getInt();
		ConfigGaia.SpawnBoneKnight = cfg.get("general", "SpawnRateBoneKnight", ConfigGaia.SpawnBoneKnight).getInt();
		ConfigGaia.SpawnCentaur = cfg.get("general", "SpawnRateCentaur", ConfigGaia.SpawnCentaur).getInt();
		ConfigGaia.SpawnNineTails = cfg.get("general", "SpawnRateNineTails", ConfigGaia.SpawnNineTails).getInt();
		ConfigGaia.SpawnCobbleGolem = cfg.get("general", "SpawnRateCobbleGolem", ConfigGaia.SpawnCobbleGolem).getInt();
		ConfigGaia.SpawnCobblestoneGolem = cfg.get("general", "SpawnRateCobblestoneGolem", ConfigGaia.SpawnCobblestoneGolem).getInt();
		ConfigGaia.SpawnCockatrice = cfg.get("general", "SpawnRateCockatrice", ConfigGaia.SpawnCockatrice).getInt();
		ConfigGaia.SpawnCreep = cfg.get("general", "SpawnRateCreep", ConfigGaia.SpawnCreep).getInt();
		ConfigGaia.SpawnCyclops = cfg.get("general", "SpawnRateCyclops", ConfigGaia.SpawnCyclops).getInt();
		ConfigGaia.SpawnDhampir = cfg.get("general", "SpawnRateDhampir", ConfigGaia.SpawnDhampir).getInt();
		ConfigGaia.SpawnDryad = cfg.get("general", "SpawnRateDryad", ConfigGaia.SpawnDryad).getInt();
		ConfigGaia.SpawnDullahan = cfg.get("general", "SpawnRateDullahan", ConfigGaia.SpawnDullahan).getInt();
		ConfigGaia.SpawnEnderDragonGirl = cfg.get("general", "SpawnRateEnderDragonGirl", ConfigGaia.SpawnEnderDragonGirl).getInt();
		ConfigGaia.SpawnEnderEye = cfg.get("general", "SpawnRateEnderEye", ConfigGaia.SpawnEnderEye).getInt();
		ConfigGaia.SpawnFleshLich = cfg.get("general", "SpawnRateFleshLich", ConfigGaia.SpawnFleshLich).getInt();
		ConfigGaia.SpawnFutakuchiOnna = cfg.get("general", "SpawnRateFutakuchiOnna", ConfigGaia.SpawnFutakuchiOnna).getInt();
		ConfigGaia.SpawnHarpy = cfg.get("general", "SpawnRateHarpy", ConfigGaia.SpawnHarpy).getInt();
		ConfigGaia.SpawnHunter = cfg.get("general", "SpawnRateHunter", ConfigGaia.SpawnHunter).getInt();
		ConfigGaia.SpawnJorogumo = cfg.get("general", "SpawnRateJorogumo", ConfigGaia.SpawnJorogumo).getInt();
		ConfigGaia.SpawnKobold = cfg.get("general", "SpawnRateSpawnKobold", ConfigGaia.SpawnKobold).getInt();
		ConfigGaia.SpawnMandragora = cfg.get("general", "SpawnRateSpawnMandragora", ConfigGaia.SpawnMandragora).getInt();
		ConfigGaia.SpawnMermaid = cfg.get("general", "SpawnRateMermaid", ConfigGaia.SpawnMermaid).getInt();
		ConfigGaia.SpawnMimic = cfg.get("general", "SpawnRateMimic", ConfigGaia.SpawnMimic).getInt();
		ConfigGaia.SpawnMinotaur = cfg.get("general", "SpawnRateMinotaur", ConfigGaia.SpawnMinotaur).getInt();
		ConfigGaia.SpawnMinotaurus = cfg.get("general", "SpawnRateMinotaurus", ConfigGaia.SpawnMinotaurus).getInt();
		ConfigGaia.SpawnNaga = cfg.get("general", "SpawnRateNaga", ConfigGaia.SpawnNaga).getInt();
		ConfigGaia.SpawnSahuagin = cfg.get("general", "SpawnRateSahuagin", ConfigGaia.SpawnSahuagin).getInt();
		ConfigGaia.SpawnSatyr = cfg.get("general", "SpawnRateSatyr", ConfigGaia.SpawnSatyr).getInt();
		ConfigGaia.SpawnSelkie = cfg.get("general", "SpawnRateSelkie", ConfigGaia.SpawnSelkie).getInt();
		ConfigGaia.SpawnShaman = cfg.get("general", "SpawnRateShaman", ConfigGaia.SpawnShaman).getInt();
		ConfigGaia.SpawnSharko = cfg.get("general", "SpawnRateSharko", ConfigGaia.SpawnSharko).getInt();
		ConfigGaia.SpawnSiren = cfg.get("general", "SpawnRateSiren", ConfigGaia.SpawnSiren).getInt();
		ConfigGaia.SpawnSludgeGirl = cfg.get("general", "SpawnSludgeGirl", ConfigGaia.SpawnSludgeGirl).getInt();
		ConfigGaia.SpawnSphinx = cfg.get("general", "SpawnRateSphinx", ConfigGaia.SpawnSphinx).getInt();
		ConfigGaia.SpawnSpriggan = cfg.get("general", "SpawnRateSpriggan", ConfigGaia.SpawnSpriggan).getInt();
		ConfigGaia.SpawnSuccubus = cfg.get("general", "SpawnRateSuccubus", ConfigGaia.SpawnSuccubus).getInt();
		ConfigGaia.SpawnSwamper = cfg.get("general", "SpawnRateSwamper", ConfigGaia.SpawnSwamper).getInt();
		ConfigGaia.SpawnValkyrie = cfg.get("general", "SpawnRateValkyrie", ConfigGaia.SpawnValkyrie).getInt();
		ConfigGaia.SpawnVampire = cfg.get("general", "SpawnRateVampire", ConfigGaia.SpawnVampire).getInt();
		ConfigGaia.SpawnWerecat = cfg.get("general", "SpawnRateWerecat", ConfigGaia.SpawnWerecat).getInt();
		ConfigGaia.SpawnWitch = cfg.get("general", "SpawnRateWitch", ConfigGaia.SpawnWitch).getInt();
		ConfigGaia.SpawnWitherCow = cfg.get("general", "SpawnRateWitherCow", ConfigGaia.SpawnWitherCow).getInt();
		ConfigGaia.SpawnYeti = cfg.get("general", "SpawnRateYeti", ConfigGaia.SpawnYeti).getInt();
		ConfigGaia.SpawnYukiOnna = cfg.get("general", "SpawnRateYukiOnna", ConfigGaia.SpawnYukiOnna).getInt();*/
		ConfigGaia.BaseDamage = cfg.get("BASE DAMAGE", "BaseDamage", true).getBoolean(true);
		ConfigGaia.Tier1maxHealth = cfg.get("MODIFIER", "Tier1maxHealth", ConfigGaia.Tier1maxHealth).getInt();
		ConfigGaia.Tier1attackDamage = cfg.get("MODIFIER", "Tier1attackDamage", ConfigGaia.Tier1attackDamage).getInt();
		ConfigGaia.Tier2maxHealth = cfg.get("MODIFIER", "Tier2maxHealth", ConfigGaia.Tier2maxHealth).getInt();
		ConfigGaia.Tier2attackDamage = cfg.get("MODIFIER", "Tier2attackDamage", ConfigGaia.Tier2attackDamage).getInt();
		ConfigGaia.Tier3maxHealth = cfg.get("MODIFIER", "Tier3maxHealth", ConfigGaia.Tier3maxHealth).getInt();
		ConfigGaia.Tier3attackDamage = cfg.get("MODIFIER", "Tier3attackDamage", ConfigGaia.Tier3attackDamage).getInt();

		Property generalproperty = cfg.get("general", " ", " ");
		generalproperty.comment = "Spawn Rate. Set to 0 to disable mob from spawning. Recommended: 10> Day, <100 Night";
		Property basedamageproperty = cfg.get("BASE DAMAGE", " ", " ");
		basedamageproperty.comment = "If BaseDamage is set to true, all mobs will deal 1.0 piercing damage (ignores armor).";
		Property modifierproperty = cfg.get("MODIFIER", " ", " ");
		modifierproperty.comment = "Percentage amount. Default value: 100";
		cfg.save();
		//GaiaBlock.init();
    	GaiaItem.init();
    	GaiaItem.register();
    	GaiaItem.oreRegistration();
		//proxy.registerRenderingFactories();
		
	}

	@EventHandler
	public void load(FMLInitializationEvent event) 
	{

		proxy.registerRenders();
		GameRegistry.registerFuelHandler(new GaiaItemHandlerFuel());
		byte trackingRange = 64;
		byte updateFrequency = 3;

		EntityRegistry.registerModEntity(EntityGaiaAnubis.class, "Anubis", 1, this, trackingRange, updateFrequency, true);
		/*EntityRegistry.registerModEntity(EntityGaiaBanshee.class, "Banshee", 2, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBaphomet.class, "Baphomet", 3, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBoneKnight.class, "Bone Knight", 4, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCentaur.class, "Centaur", 5, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobbleGolem.class, "Cobble Golem", 6, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobblestoneGolem.class, "Cobblestone Golem", 7, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCockatrice.class, "Cockatrice", 8, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCreep.class, "Creep", 9, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCyclops.class, "Cyclops", 10, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaPropFlowerCyan.class, "Cyan Flower", 11, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDhampir.class, "Dhampir", 12, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDryad.class, "Dryad", 13, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDullahan.class, "Dullahan", 14, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderDragonGirl.class, "Ender Dragon Girl", 15, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderEye.class, "Ender Eye", 16, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFleshLich.class, "Flesh Lich", 17, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFutakuchiOnna.class, "FutakuchiOnna", 18, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaGryphon.class, "Gryphon", 19, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHarpy.class, "Harpy", 20, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHunter.class, "Hunter", 21, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaJorogumo.class, "Jorogumo", 22, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaKobold.class, "Kobold", 47, this, trackingRange, updateFrequency, true); //ID
		EntityRegistry.registerModEntity(EntityGaiaMermaid.class, "Mermaid", 23, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMimic.class, "Mimic", 24, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaur.class, "Minotaur", 25, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaurus.class, "Minotaurus", 26, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNaga.class, "Naga", 27, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNineTails.class, "NineTails", 28, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSahuagin.class, "Sahuagin", 29, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSatyr.class, "Satyr", 30, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSelkie.class, "Selkie", 31, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaShaman.class, "Shaman", 32, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSharko.class, "Sharko", 33, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSiren.class, "Siren", 34, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSludgeGirl.class, "Sludge Girl", 35, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSphinx.class, "Sphinx", 36, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSpriggan.class, "Spriggan", 37, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSuccubus.class, "Succubus", 38, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSwamper.class, "Swamper", 39, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaValkyrie.class, "Valkyrie", 40, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaVampire.class, "Vampire", 41, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWerecat.class, "Werecat", 42, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitch.class, "Witch", 43, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitherCow.class, "Wither Cow", 44, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYeti.class, "Yeti", 45, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYukiOnna.class, "Yuki-Onna", 46, this, trackingRange, updateFrequency, true);

		EntityRegistry.registerModEntity(EntityGaiaNPCCreeperGirl.class, "Creeper Girl", 60, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCEnderGirl.class, "Ender Girl", 63, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCHolstaurus.class, "Holstaurus", 64, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCSlimeGirl.class, "Slime Girl", 62, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCTrader.class, "Trader", 61, this, trackingRange, updateFrequency, true);
	
		EntityRegistry.registerModEntity(EntityGaiaProjectileSmallFireball.class, "Small Fireball", 100, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaProjectileMagic.class, "Magic", 101, this, trackingRange, updateFrequency, true);

		EntityRegistry.registerModEntity(EntityGaiaMandragora.class, "Mandragora", 80, this, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSummonButler.class, "Butler", 81, this, trackingRange, updateFrequency, true);

		//ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaEntity.class, 0, body, spots);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaAnubis.class, 1, 0x353535, 0xb19534);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaBanshee.class, 2, 0xeed2e8, 0xc6b0ed);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaBaphomet.class, 3, 3559756, 14197864);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaBoneKnight.class, 4, 4602533, 13619151);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCentaur.class, 5, 0x8d4f41, 0x353535);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCobbleGolem.class, 6, 11513775, 11513775);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCobblestoneGolem.class, 7, 11513775, 11513775);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCockatrice.class, 8, 0xc9b161, 0xe2e2e2);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCreep.class, 9, 7917159, 2053400);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaCyclops.class, 10, 4936602, 3487029);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaDhampir.class, 11, 0x9c1c2b, 0xc9b161);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaDryad.class, 12, 10255437, 5681460);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaDullahan.class, 13, 0x824fab, 0xa4452d);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaEnderDragonGirl.class, 14, 3158064, 14711290);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaEnderEye.class, 15, 2039583, 3158064);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaFleshLich.class, 17, 0x00cccc, 0x799c65);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaPropFlowerCyan.class, 16, 1073920, 4045287);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaFutakuchiOnna.class, 19, 0x4e3738, 0xb43434);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaGryphon.class, 18, 0xf09942, 0xe2e2e2);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaHarpy.class, 21, 0xc9b161, 0xa5884e);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaHunter.class, 20, 0xae6b3c, 0x353535);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaJorogumo.class, 23, 3815994, 11013646);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaKobold.class, 22, 0x73718d, 0xdec89e);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMermaid.class, 25, 0x5c70b1, 0xa4452d);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMimic.class, 24, 11237677, 4274991);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMinotaur.class, 27, 0x8d4f41, 0xd54242);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMinotaurus.class, 29, 0x8d4f41, 0xa9a9a9);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaNaga.class, 28, 0x29bc55, 0xccb63f);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaNineTails.class, 31, 11809844, 13218145);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSahuagin.class, 30, 0x5c70b1, 0x84a498);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSatyr.class, 34, 0x707b4f, 0xa4452d);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSelkie.class, 35, 9082818, 13488612);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaShaman.class, 32, 0xae6b3c, 0x56b134);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSharko.class, 33, 0x84a498, 0x5c70b1);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSiren.class, 38, 0x29bc55, 0x48a0de);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSludgeGirl.class, 39, 6595667, 7715172);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSphinx.class, 36, 0xf09942, 0x353535);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSpriggan.class, 37, 4010013, 8151614);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSuccubus.class, 42, 4079166, 13218145);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaSwamper.class, 43, 0x516d30, 0x4f8a48);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaValkyrie.class, 40, 0xc9b161, 0xd54242);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaVampire.class, 41, 0xc23021, 0xc9b161);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaWerecat.class, 46, 0x7a7e8a, 0xdddadb);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaWitch.class, 47, 0x303030, 0x943dbb);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaWitherCow.class, 44, 5791069, 16777215);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaYeti.class, 45, 16448250, 7895160);
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaYukiOnna.class, 51, 6781114, 13817330);*/

		BiomeGenBase[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
		BiomeGenBase[] sandy = BiomeDictionary.getBiomesForType(Type.SANDY);
		BiomeGenBase[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
		BiomeGenBase[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
		BiomeGenBase[] spooky = BiomeDictionary.getBiomesForType(Type.SPOOKY);
		BiomeGenBase[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
		BiomeGenBase[] snowy = BiomeDictionary.getBiomesForType(Type.SNOWY);
		BiomeGenBase[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

		BiomeGenBase[] water = BiomeDictionary.getBiomesForType(Type.WATER);
		BiomeGenBase[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);

		BiomeGenBase[] hell = BiomeDictionary.getBiomesForType(Type.NETHER);
		BiomeGenBase[] sky = BiomeDictionary.getBiomesForType(Type.END);

		int i;
		SpawnListEntry SpawnEntry;

		for(i = 0; i < forest.length; ++i) 
		{
			// forest, forestHills, birchForest, birchForestHills
			if(!BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY)  
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MOUNTAIN) 
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY) 
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MAGICAL))  	 
			{
				if(ConfigGaia.SpawnMandragora > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaPropFlowerCyan.class, ConfigGaia.SpawnMandragora, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnDryad > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaDryad.class, ConfigGaia.SpawnDryad, 4, 6);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnWerecat > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaWerecat.class, ConfigGaia.SpawnWerecat, 4, 6);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnSpriggan > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaSpriggan.class, ConfigGaia.SpawnSpriggan, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				// underground
				if(ConfigGaia.SpawnCreep > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnEnderEye > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnJorogumo > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnMimic > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBoneKnight > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFleshLich > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}
			
			//taiga, taigaHills, megaTaiga, megaTaigaHills
			if(BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
					&& (!BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
			{
				if(ConfigGaia.SpawnCyclops > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCyclops.class, ConfigGaia.SpawnCyclops, 4, 6);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnYukiOnna > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaYukiOnna.class, ConfigGaia.SpawnYukiOnna, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFutakuchiOnna > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFutakuchiOnna.class, ConfigGaia.SpawnFutakuchiOnna, 4, 6);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnNineTails > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaNineTails.class, ConfigGaia.SpawnNineTails, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				// underground
				if(ConfigGaia.SpawnCreep > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnEnderEye > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnJorogumo > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnMimic > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBoneKnight > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFleshLich > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			} 
			
			// coldTaiga, coldTaigaHills
			if(BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS)
					&& (BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
			{		
				if(ConfigGaia.SpawnDhampir > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaDhampir.class, ConfigGaia.SpawnDhampir, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnVampire > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaVampire.class, ConfigGaia.SpawnVampire, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				// underground
				if(ConfigGaia.SpawnCreep > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnEnderEye > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnJorogumo > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnMimic > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBoneKnight > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFleshLich > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}
			
			// roofedForest
			if(BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY)) 
			{		
				if(ConfigGaia.SpawnKobold > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaKobold.class, ConfigGaia.SpawnKobold, 2, 6);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnWitch > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaWitch.class, ConfigGaia.SpawnWitch, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				// underground
				if(ConfigGaia.SpawnCreep > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnEnderEye > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnJorogumo > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnMimic > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBoneKnight > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFleshLich > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}
		}

		// desert, desertHills, mesa, mesaPlateau, mesaPlateau_F 
		for(i = 0; i < sandy.length; ++i) 
		{
			if(ConfigGaia.SpawnCockatrice > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCockatrice.class, ConfigGaia.SpawnCockatrice, 2, 4);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnHarpy > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaHarpy.class, ConfigGaia.SpawnHarpy, 2, 4);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnAnubis > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaAnubis.class, ConfigGaia.SpawnAnubis, 2, 4);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnSphinx > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSphinx.class, ConfigGaia.SpawnSphinx, 1, 2);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			// underground
			if(ConfigGaia.SpawnCreep > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnEnderEye > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnJorogumo > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMimic > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnBoneKnight > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnFleshLich > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
				sandy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		// plains, savanna, savannaPlateau 
		for(i = 0; i < plains.length; ++i) 
		{
			if(ConfigGaia.SpawnSatyr > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSatyr.class, ConfigGaia.SpawnSatyr, 2, 4);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnCentaur > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCentaur.class, ConfigGaia.SpawnCentaur, 4, 6);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMinotaurus > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMinotaurus.class, ConfigGaia.SpawnMinotaurus, 2, 4);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMinotaur > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMinotaur.class, ConfigGaia.SpawnMinotaur, 1, 2);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			// underground
			if(ConfigGaia.SpawnCreep > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnEnderEye > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnJorogumo > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMimic > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnBoneKnight > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnFleshLich > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
				plains[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		// swamp
		for(i = 0; i < swamp.length; ++i) 
		{
			if(ConfigGaia.SpawnSiren > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSiren.class, ConfigGaia.SpawnSiren, 4, 6);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
			
			if(ConfigGaia.SpawnNaga > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaNaga.class, ConfigGaia.SpawnNaga, 1, 2);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnSludgeGirl > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSludgeGirl.class, ConfigGaia.SpawnSludgeGirl, 2, 4);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnSwamper > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSwamper.class, ConfigGaia.SpawnSwamper, 1, 2);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			// underground
			if(ConfigGaia.SpawnCreep > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnEnderEye > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnJorogumo > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMimic > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnBoneKnight > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnFleshLich > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
				swamp[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		// jungle
		for(i = 0; i < jungle.length; ++i) 
		{
			if(ConfigGaia.SpawnCobbleGolem > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCobbleGolem.class, ConfigGaia.SpawnCobbleGolem, 2, 4);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnHunter > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaHunter.class, ConfigGaia.SpawnHunter, 2, 4);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnShaman > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaShaman.class, ConfigGaia.SpawnShaman, 2, 4);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnCobblestoneGolem > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCobblestoneGolem.class, ConfigGaia.SpawnCobblestoneGolem, 2, 4);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			// underground
			if(ConfigGaia.SpawnCreep > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnEnderEye > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnJorogumo > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMimic > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnBoneKnight > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnFleshLich > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
				jungle[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		// icePlains, iceMountains
		for(i = 0; i < snowy.length; ++i) 
		{
			if(!BiomeDictionary.isBiomeOfType(snowy[i], Type.FOREST) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.OCEAN) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.RIVER)) 
			{
				if(ConfigGaia.SpawnYeti > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaYeti.class, ConfigGaia.SpawnYeti, 4, 6);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnSelkie > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaSelkie.class, ConfigGaia.SpawnSelkie, 2, 4);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				// underground
				if(ConfigGaia.SpawnCreep > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnEnderEye > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnJorogumo > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnMimic > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBoneKnight > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFleshLich > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
					snowy[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}
		}
		
		// extremeHills, extremeHillsPlus
		for(i = 0; i < mountain.length; ++i) 
		{
			if(!BiomeDictionary.isBiomeOfType(mountain[i], Type.SNOWY)) 
			{
				if(ConfigGaia.SpawnGryphon > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaGryphon.class, ConfigGaia.SpawnGryphon, 4, 6);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnValkyrie > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaValkyrie.class, ConfigGaia.SpawnValkyrie, 1, 2);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnDullahan > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaDullahan.class, ConfigGaia.SpawnDullahan, 4, 6);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBanshee > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBanshee.class, ConfigGaia.SpawnBanshee, 2, 4);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				// underground
				if(ConfigGaia.SpawnCreep > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaCreep.class, ConfigGaia.SpawnCreep, 2, 4);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnEnderEye > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderEye.class, ConfigGaia.SpawnEnderEye, 2, 4);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnJorogumo > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaJorogumo.class, ConfigGaia.SpawnJorogumo, 1, 2);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnMimic > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaMimic.class, ConfigGaia.SpawnMimic, 1, 2);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnBoneKnight > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaBoneKnight.class, ConfigGaia.SpawnBoneKnight, 1, 2);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}

				if(ConfigGaia.SpawnFleshLich > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaFleshLich.class, ConfigGaia.SpawnFleshLich, 1, 2);
					mountain[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}
		}

		// frozenRiver, coldBeach, stoneBeach, river, beach, ocean, deepOcean
		for(i = 0; i < water.length; ++i) 
		{
			if(ConfigGaia.SpawnSahuagin > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSahuagin.class, ConfigGaia.SpawnSahuagin, 4, 6);
				water[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMermaid > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMermaid.class, ConfigGaia.SpawnMermaid, 2, 4);
				water[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnSharko > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSharko.class, ConfigGaia.SpawnSharko, 2, 4);
				water[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		for(i = 0; i < beach.length; ++i) 
		{
			if(ConfigGaia.SpawnSahuagin > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSahuagin.class, ConfigGaia.SpawnSahuagin, 4, 6);
				beach[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnMermaid > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaMermaid.class, ConfigGaia.SpawnMermaid, 2, 4);
				beach[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnSharko > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSharko.class, ConfigGaia.SpawnSharko, 2, 4);
				beach[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		//hell
		for(i = 0; i < hell.length; ++i) 
		{
			if(ConfigGaia.SpawnSuccubus > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaSuccubus.class, ConfigGaia.SpawnSuccubus, 2, 4);
				hell[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnWitherCow > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaWitherCow.class, ConfigGaia.SpawnWitherCow, 1, 2);
				hell[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}

			if(ConfigGaia.SpawnBaphomet > 0) 
			{
				SpawnEntry = new SpawnListEntry(EntityGaiaBaphomet.class, ConfigGaia.SpawnBaphomet, 1, 2);
				hell[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
		}

		//sky
		for(i = 0; i < sky.length; ++i) 
		{
			if(BiomeDictionary.isBiomeOfType(sky[i], Type.COLD) 
					&& (BiomeDictionary.isBiomeOfType(sky[i], Type.DRY))) 
			{
				if(ConfigGaia.SpawnEnderDragonGirl > 0) 
				{
					SpawnEntry = new SpawnListEntry(EntityGaiaEnderDragonGirl.class, ConfigGaia.SpawnEnderDragonGirl, 1, 2);
					sky[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}
		}
	}
	
	/*
	//debug, remove before compile/release
	MinecraftForge.EVENT_BUS.register(this);
	@SubscribeEvent
	public void postInit(CommandReceivedEvent event) {
		if ("out".equals(event.command)) {
			event.handled = true;
			System.out.println("test");
		}
		if ("butcher".equals(event.command)) {
			event.handled = true;
			EntityPlayer p = (EntityPlayer)event.sender;
			World w = p.worldObj;
			List<Entity> list = w.loadedEntityList;
			for (Entity e : list) {
				if (e instanceof EntityPlayer) continue;
				e.setDead();
			}
		}
		if ("listitems".equals(event.command)) {
			event.handled = true;
			Iterator<String> it = Item.itemRegistry.getKeys().iterator();
			while (it.hasNext()) {
				String s = it.next();
				if (!s.startsWith("minecraft:")) {
					System.out.println(s);	
				}

			}
		}

		if ("spawnall".equals(event.command)) {
			event.handled = true;
			spawnCreatures((EntityPlayer)event.sender);
		}

	}

	public static void spawnCreatures(EntityPlayer player) {
		World world = player.worldObj;
		double posX = player.posX;
		double posY = player.posY;
		double posZ = player.posZ;
		posY+=1.38D;
		for (ModContainer c : EntityRegistry.instance().entityRegistrations.keySet()) {
			System.out.println("modcontainer "+c);
			List<EntityRegistration> l = EntityRegistry.instance().entityRegistrations.get(c);
			for (EntityRegistration r : l) {
				posX+=1.08D;
				try {
					EntityLiving entity = (EntityLiving)r.getEntityClass().getConstructor(new Class[]{World.class}).newInstance(new Object[]{world});
					entity.setLocationAndAngles(posX, posY, posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
					entity.rotationYawHead = entity.rotationYaw;
					entity.renderYawOffset = entity.rotationYaw;
					entity.onSpawnWithEgg((IEntityLivingData)null);
					if (!world.spawnEntityInWorld(entity)) {
						System.err.println("Failed to spawn "+r.getEntityName()+" - "+r.getEntityClass());
					}
				} catch (Exception var11) {
					System.err.println("Failed to spawn "+r.getEntityName()+" - "+r.getEntityClass());
					var11.printStackTrace();
				}

			}
		}
	}
	*/
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
}
