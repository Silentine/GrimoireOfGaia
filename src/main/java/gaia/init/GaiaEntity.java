package gaia.init;

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
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.entity.monster.EntityGaiaHunter;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMimic;
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
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaNPCCreeperGirl;
import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.entity.passive.EntityGaiaNPCHolstaurus;
import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.entity.passive.EntityGaiaNPCTrader;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.items.ItemGaiaSpawnEgg;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Registers SpawnEggs
 */
public class GaiaEntity {

	public static byte trackingRange = 64;
	public static byte updateFrequency = 3;
	
	public static void register() {		
		//Monsters
		//Register(EntityGaia.class, 				"Name", 			0, 0xbody, 0xspots);
		Register(EntityGaiaAnt.class, 				"Ant", 				1, 0x303030, 0x8a7264);
		Register(EntityGaiaAnubis.class, 			"Anubis", 			2, 0x353535, 0xb19534);
		Register(EntityGaiaArachne.class, 			"Arachne", 			3, 3815994, 11013646);
		Register(EntityGaiaBanshee.class, 			"Banshee", 			4, 0xeed2e8, 0xc6b0ed);
		Register(EntityGaiaBaphomet.class, 			"Baphomet", 		5, 3559756, 14197864);
		Register(EntityGaiaBoneKnight.class, 		"BoneKnight", 		6, 4602533, 13619151);
		Register(EntityGaiaCentaur.class, 			"Centaur", 			7, 0x8d4f41, 0x353535);	
		Register(EntityGaiaPropChestMimic.class, 	"Chest", 			8, 11237677, 4274991);
		Register(EntityGaiaCobbleGolem.class, 		"CobbleGolem", 		9, 11513775, 11513775);
		Register(EntityGaiaCobblestoneGolem.class, 	"CobblestoneGolem", 10, 11513775, 11513775);
		Register(EntityGaiaCreep.class, 			"Creep", 			11, 7917159, 2053400);
		Register(EntityGaiaCyclops.class, 			"Cyclops", 			12, 4936602, 3487029);				
		Register(EntityGaiaPropFlowerCyan.class, 	"CyanFlower", 		13, 1073920, 4045287);
		Register(EntityGaiaDhampir.class, 			"Dhampir", 			14, 0x9c1c2b, 0xc9b161);
		Register(EntityGaiaDryad.class, 			"Dryad", 			15, 10255437, 5681460);
		Register(EntityGaiaDullahan.class, 			"Dullahan", 		16, 0x824fab, 0xa4452d);
		Register(EntityGaiaDwarf.class, 			"Dwarf", 			17, 0x969696, 0xf09942);
		Register(EntityGaiaEnderDragonGirl.class, 	"EnderDragonGirl", 	18, 3158064, 14711290);
		Register(EntityGaiaEnderEye.class, 			"EnderEye", 		19, 2039583, 3158064);
		Register(EntityGaiaFleshLich.class, 		"FleshLich", 		20, 0x00cccc, 0x799c65);		
		Register(EntityGaiaFutakuchiOnna.class, 	"FutakuchiOnna", 	21, 0x4e3738, 0xb43434);
		Register(EntityGaiaHarpy.class, 			"Harpy", 			22, 0xc9b161, 0xa5884e);
		Register(EntityGaiaHunter.class, 			"Hunter", 			23, 0xae6b3c, 0x353535);
		Register(EntityGaiaKobold.class, 			"Kobold", 			24, 0x938dab, 0xafa7c1);
		Register(EntityGaiaMatango.class, 			"Matango", 			25, 0xab1311, 0xd8d8d8);
		Register(EntityGaiaMermaid.class, 			"Mermaid", 			26, 0x5c70b1, 0xa4452d);
		Register(EntityGaiaMinotaur.class, 			"Minotaur", 		27, 0x8d4f41, 0xd54242);
		Register(EntityGaiaMinotaurus.class,		"Minotaurus", 		28, 0x8d4f41, 0xa9a9a9);
		Register(EntityGaiaMummy.class, 			"Mummy", 			29, 0xdcd7c1, 0xc9b161);
		Register(EntityGaiaNaga.class, 				"Naga", 			30, 0x29bc55, 0xccb63f);		
		Register(EntityGaiaNineTails.class, 		"NineTails", 		31, 11809844, 13218145);
		Register(EntityGaiaSahuagin.class, 			"Sahuagin", 		32, 0x5c70b1, 0x84a498);		
		Register(EntityGaiaSatyress.class, 			"Satyress", 		33, 0x707b4f, 0xa4452d);
		Register(EntityGaiaSelkie.class, 			"Selkie", 			34, 9082818, 13488612);
		Register(EntityGaiaShaman.class, 			"Shaman", 			35, 0xae6b3c, 0x56b134);
		Register(EntityGaiaSharko.class, 			"Sharko", 			36, 0x84a498, 0x5c70b1);		
		Register(EntityGaiaSiren.class, 			"Siren", 			37, 0x29bc55, 0x48a0de);
		Register(EntityGaiaSludgeGirl.class, 		"SludgeGirl", 		38, 6595667, 7715172);
		Register(EntityGaiaSphinx.class, 			"Sphinx", 			39, 0xf09942, 0x353535);
		Register(EntityGaiaSpriggan.class, 			"Spriggan", 		40, 4010013, 8151614);
		Register(EntityGaiaSuccubus.class, 			"Succubus", 		41, 4079166, 13218145);
		Register(EntityGaiaToad.class, 				"Toad", 			42, 0x355d2b, 0x779f5a);
		Register(EntityGaiaValkyrie.class, 			"Valkyrie", 		43, 0xc9b161, 0xd54242);
		Register(EntityGaiaVampire.class, 			"Vampire", 			44, 0xc23021, 0xc9b161);		
		Register(EntityGaiaWerecat.class, 			"Werecat", 			45, 0x7a7e8a, 0xdddadb);		
		Register(EntityGaiaWitch.class, 			"Witch", 			46, 0x303030, 0x943dbb);
		Register(EntityGaiaWitherCow.class, 		"WitherCow", 		47, 5791069, 16777215);
		Register(EntityGaiaYeti.class, 				"Yeti", 			48, 16448250, 7895160);
		Register(EntityGaiaYukiOnna.class, 			"Yuki-Onna",		49, 6781114, 13817330);
		
		//Register(EntityDebugMob.class, 			"DebugMob", 		200, 0x6fa289, 0x915741);

		//NPC
		Register(EntityGaiaNPCCreeperGirl.class, 	"CreeperGirl", 		61 );
		Register(EntityGaiaNPCSlimeGirl.class, 		"SlimeGirl", 		62 );
		Register(EntityGaiaNPCEnderGirl.class, 		"EnderGirl", 		63 );
		Register(EntityGaiaNPCTrader.class, 		"Trader", 			64 );
		Register(EntityGaiaNPCHolstaurus.class, 	"Holstaurus", 		65 );
		Register(EntityGaiaNPCWeresheep.class, 		"Weresheep", 		66 );

		//Spawn
		Register(EntityGaiaMandragora.class, 		"Mandragora", 		81 );
		Register(EntityGaiaMimic.class, 			"Mimic", 			82 );
		Register(EntityGaiaSummonButler.class,	 	"Butler", 			83 ); 
		Register(EntityGaiaSummonSporeling.class, 	"Sporeling", 		84 ); 
		
		//Projectiles
		Register(EntityGaiaProjectileSmallFireball.class,"SmallFireball", 101 );
		Register(EntityGaiaProjectileMagic.class, 	"Magic"				, 102 );
	}
	
	public static int MaxEgg;
	
	/**
	 * Shortcut for registering entities with forge
	 */
	public static void Register(Class entityClass, String entityName, int id) {
		EntityRegistry.registerModEntity(entityClass, entityName, id, Gaia.instance, trackingRange, updateFrequency, true);	
		
	}
	
	/**
	 * Shortcut for registering entities with custom spawning eggs
	 */
	public static void Register(Class entityClass, String entityName, int id, int primaryColor, int secondaryColor) {
		Register(entityClass, entityName, id);
		ItemGaiaSpawnEgg.registerEntityEgg(entityClass, id, primaryColor, secondaryColor);
		MaxEgg = id;
	}
}
