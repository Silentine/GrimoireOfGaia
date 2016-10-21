package gaia.init;

import gaia.Gaia;
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
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.entity.monster.EntityGaiaMatango;
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
import gaia.entity.monster.EntityGaiaSummonButler;
import gaia.entity.monster.EntityGaiaSummonSporeling;
import gaia.entity.monster.EntityGaiaSwamper;
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
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import gaia.entity.projectile.EntityGaiaProjectileMagic;
import gaia.entity.projectile.EntityGaiaProjectileSmallFireball;
import gaia.items.ItemGaiaSpawnEgg;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GaiaEntity {

	public static byte trackingRange = 64;
	public static byte updateFrequency = 3;
	
	
	public static void register(){		

		//Monsters
		Register(EntityGaiaAnubis.class, "Anubis", 1, 0x353535, 0xb19534);
		Register(EntityGaiaBanshee.class, "Banshee", 2, 0xeed2e8, 0xc6b0ed);
		Register(EntityGaiaBaphomet.class, "Baphomet", 3, 3559756, 14197864);
		Register(EntityGaiaBoneKnight.class, "Bone Knight", 4, 4602533, 13619151);
		Register(EntityGaiaCentaur.class, "Centaur", 5, 0x8d4f41, 0x353535);		
		Register(EntityGaiaCobbleGolem.class, "Cobble Golem", 6, 11513775, 11513775);
		Register(EntityGaiaCobblestoneGolem.class, "Cobblestone Golem", 7, 11513775, 11513775);
		Register(EntityGaiaCockatrice.class, "Cockatrice", 8, 0xc9b161, 0xe2e2e2);
		Register(EntityGaiaCreep.class, "Creep", 9, 7917159, 2053400);
		Register(EntityGaiaCyclops.class, "Cyclops", 10, 4936602, 3487029);				
		Register(EntityGaiaPropFlowerCyan.class, "Cyan Flower", 11, 1073920, 4045287);
		Register(EntityGaiaDhampir.class, "Dhampir", 12, 0x9c1c2b, 0xc9b161);
		Register(EntityGaiaDryad.class, "Dryad", 13,10255437, 5681460);
		Register(EntityGaiaDullahan.class, "Dullahan", 14, 0x824fab, 0xa4452d);
		//TODO TEMP* Register(EntityGaiaEnderDragonGirl.class, "Ender Dragon Girl", 15, 3158064, 14711290);
		//TODO TEMP* Register(EntityGaiaEnderEye.class, "Ender Eye", 16, 2039583, 3158064);
		Register(EntityGaiaFleshLich.class, "Flesh Lich", 17, 0x00cccc, 0x799c65);		
		Register(EntityGaiaFutakuchiOnna.class, "FutakuchiOnna", 18, 0x4e3738, 0xb43434);
		Register(EntityGaiaGryphon.class, "Gryphon", 19, 0xf09942, 0xe2e2e2);
		Register(EntityGaiaHarpy.class, "Harpy", 20, 0xc9b161, 0xa5884e);
		Register(EntityGaiaHunter.class, "Hunter", 21, 0xae6b3c, 0x353535);		
		Register(EntityGaiaJorogumo.class, "Jorogumo", 22, 3815994, 11013646);
		Register(EntityGaiaMatango.class, "Matango", 23, 0xab1311, 0xd8d8d8);
		Register(EntityGaiaMermaid.class, "Mermaid", 24, 0x5c70b1, 0xa4452d);
		Register(EntityGaiaMimic.class, "Mimic", 25, 11237677, 4274991);
		Register(EntityGaiaMinotaur.class, "Minotaur", 26, 0x8d4f41, 0xd54242);
		//TODO TEMP* Register(EntityGaiaMinotaurus.class, "Minotaurus", 27, 0x8d4f41, 0xa9a9a9);
		Register(EntityGaiaNaga.class, "Naga", 28, 0x29bc55, 0xccb63f);		
		Register(EntityGaiaNineTails.class, "NineTails", 29, 11809844, 13218145);
		Register(EntityGaiaSahuagin.class, "Sahuagin", 30, 0x5c70b1, 0x84a498);		
		Register(EntityGaiaSatyr.class, "Satyr", 31, 0x707b4f, 0xa4452d);
		Register(EntityGaiaSelkie.class, "Selkie", 32, 9082818, 13488612);
		Register(EntityGaiaShaman.class, "Shaman", 33, 0xae6b3c, 0x56b134);
		Register(EntityGaiaSharko.class, "Sharko", 34, 0x84a498, 0x5c70b1);		
		Register(EntityGaiaSiren.class, "Siren", 35, 0x29bc55, 0x48a0de);
		Register(EntityGaiaSludgeGirl.class, "Sludge Girl", 36, 6595667, 7715172);
		Register(EntityGaiaSphinx.class, "Sphinx", 37, 0xf09942, 0x353535);
		Register(EntityGaiaSpriggan.class, "Spriggan", 38, 4010013, 8151614);
		Register(EntityGaiaSuccubus.class, "Succubus", 39, 4079166, 13218145);
		Register(EntityGaiaSwamper.class, "Swamper", 40, 0x516d30, 0x4f8a48);
		Register(EntityGaiaValkyrie.class, "Valkyrie", 41, 0xc9b161, 0xd54242);
		Register(EntityGaiaVampire.class, "Vampire", 42, 0xc23021, 0xc9b161);		
		Register(EntityGaiaWerecat.class, "Werecat", 43, 0x7a7e8a, 0xdddadb);		
		//TODO TEMP* Register(EntityGaiaWitch.class, "Witch", 44, 0x303030, 0x943dbb);
		Register(EntityGaiaWitherCow.class, "Wither Cow", 45, 5791069, 16777215);
		Register(EntityGaiaYeti.class, "Yeti", 46, 16448250, 7895160);
		Register(EntityGaiaYukiOnna.class, "Yuki-Onna", 47, 6781114, 13817330);

		//NPC
		Register(EntityGaiaNPCCreeperGirl.class, "Creeper Girl", 61 );
		Register(EntityGaiaNPCSlimeGirl.class, "Slime Girl", 62 );
		Register(EntityGaiaNPCEnderGirl.class, "Ender Girl", 63 );
		Register(EntityGaiaNPCTrader.class, "Trader", 64 );
		Register(EntityGaiaNPCHolstaurus.class, "Holstaurus", 65 );
		Register(EntityGaiaNPCWeresheep.class, "Weresheep", 66 );
	
		//Projectiles
		Register(EntityGaiaProjectileSmallFireball.class, "Small Fireball", 101 );
		Register(EntityGaiaProjectileMagic.class, "Magic", 102 );

		//Spawn
		Register(EntityGaiaMandragora.class, "Mandragora", 81 );
		Register(EntityGaiaSummonButler.class, "Butler", 82 ); 
		Register(EntityGaiaSummonSporeling.class, "Sporeling", 83 ); 
		
		
	}
	public static int MaxEgg;
	/**Shortcut for registering entities with forge**/
	public static void Register(Class entityClass, String entityName, int id)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, id, Gaia.instance, trackingRange, updateFrequency, true);	
		
	}
	/**Shortcut for registering entities with custom spawning eggs**/
	public static void Register(Class entityClass, String entityName,
			int id, int primaryColor, int secondaryColor)
	{
		Register(entityClass, entityName, id);
		ItemGaiaSpawnEgg.registerEntityEgg(entityClass, id, primaryColor, secondaryColor);
		MaxEgg = id;
		
	}
}
