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
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GaiaEntity {

	public static void register(){
		byte trackingRange = 64;
		byte updateFrequency = 3;

		/** Entities to register **/
		EntityRegistry.registerModEntity(EntityGaiaAnubis.class, "Anubis", 1, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBanshee.class, "Banshee", 2, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *Temp EntityRegistry.registerModEntity(EntityGaiaBaphomet.class, "Baphomet", 3, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBaphomet.class, "Baphomet", 3, Gaia.instance, trackingRange, updateFrequency, true,3559756, 14197864);
		EntityRegistry.registerModEntity(EntityGaiaBoneKnight.class, "Bone Knight", 4, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *Temp EntityRegistry.registerModEntity(EntityGaiaCentaur.class, "Centaur", 5, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCentaur.class, "Centaur", 5, Gaia.instance, trackingRange, updateFrequency, true, 0x8d4f41, 0x353535);
		EntityRegistry.registerModEntity(EntityGaiaCobbleGolem.class, "Cobble Golem", 6, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobblestoneGolem.class, "Cobblestone Golem", 7, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCockatrice.class, "Cockatrice", 8, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCreep.class, "Creep", 9, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *Temp EntityRegistry.registerModEntity(EntityGaiaCyclops.class, "Cyclops", 10, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCyclops.class, "Cyclops", 10, Gaia.instance, trackingRange, updateFrequency, true,4936602, 3487029);
		EntityRegistry.registerModEntity(EntityGaiaPropFlowerCyan.class, "Cyan Flower", 11, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDhampir.class, "Dhampir", 12, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDryad.class, "Dryad", 13, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDullahan.class, "Dullahan", 14, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderDragonGirl.class, "Ender Dragon Girl", 15, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderEye.class, "Ender Eye", 16, Gaia.instance, trackingRange, updateFrequency, true);
		//EntityRegistry.registerModEntity(EntityGaiaFleshLich.class, "Flesh Lich", 17, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFleshLich.class, "Flesh Lich", 17, Gaia.instance, trackingRange, updateFrequency, true,0x00cccc, 0x799c65);
		EntityRegistry.registerModEntity(EntityGaiaFutakuchiOnna.class, "FutakuchiOnna", 18, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaGryphon.class, "Gryphon", 19, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHarpy.class, "Harpy", 20, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHunter.class, "Hunter", 21, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaJorogumo.class, "Jorogumo", 22, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMatango.class, "Matango", 23, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMermaid.class, "Mermaid", 24, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMimic.class, "Mimic", 25, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaur.class, "Minotaur", 26, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaurus.class, "Minotaurus", 27, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *temp EntityRegistry.registerModEntity(EntityGaiaNaga.class, "Naga", 28, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNaga.class, "Naga", 28, Gaia.instance, trackingRange, updateFrequency, true, 0x29bc55, 0xccb63f);
		EntityRegistry.registerModEntity(EntityGaiaNineTails.class, "NineTails", 29, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *temp EntityRegistry.registerModEntity(EntityGaiaSahuagin.class, "Sahuagin", 30, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSahuagin.class, "Sahuagin", 30, Gaia.instance, trackingRange, updateFrequency, true,0x5c70b1, 0x84a498);
		EntityRegistry.registerModEntity(EntityGaiaSatyr.class, "Satyr", 31, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSelkie.class, "Selkie", 32, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaShaman.class, "Shaman", 33, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *TEMP EntityRegistry.registerModEntity(EntityGaiaSharko.class, "Sharko", 34, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSharko.class, "Sharko", 34, Gaia.instance, trackingRange, updateFrequency, true, 0x84a498, 0x5c70b1);
		EntityRegistry.registerModEntity(EntityGaiaSiren.class, "Siren", 35, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSludgeGirl.class, "Sludge Girl", 36, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSphinx.class, "Sphinx", 37, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSpriggan.class, "Spriggan", 38, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSuccubus.class, "Succubus", 39, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSwamper.class, "Swamper", 40, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaValkyrie.class, "Valkyrie", 41, Gaia.instance, trackingRange, updateFrequency, true);
		//TODO *temp EntityRegistry.registerModEntity(EntityGaiaVampire.class, "Vampire", 42, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaVampire.class, "Vampire", 42, Gaia.instance, trackingRange, updateFrequency, true, 0xc23021, 0xc9b161);
		//TODO *temp EntityRegistry.registerModEntity(EntityGaiaWerecat.class, "Werecat", 43, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWerecat.class, "Werecat", 43, Gaia.instance, trackingRange, updateFrequency, true, 0x7a7e8a, 0xdddadb);
		EntityRegistry.registerModEntity(EntityGaiaWitch.class, "Witch", 44, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitherCow.class, "Wither Cow", 45, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYeti.class, "Yeti", 46, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYukiOnna.class, "Yuki-Onna", 47, Gaia.instance, trackingRange, updateFrequency, true);

		//NPC
		EntityRegistry.registerModEntity(EntityGaiaNPCCreeperGirl.class, "Creeper Girl", 61, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCSlimeGirl.class, "Slime Girl", 62, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCEnderGirl.class, "Ender Girl", 63, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCTrader.class, "Trader", 64, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCHolstaurus.class, "Holstaurus", 65, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCWeresheep.class, "Weresheep", 66, Gaia.instance, trackingRange, updateFrequency, true);
	
		//Projectiles
		EntityRegistry.registerModEntity(EntityGaiaProjectileSmallFireball.class, "Small Fireball", 101, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaProjectileMagic.class, "Magic", 102, Gaia.instance, trackingRange, updateFrequency, true);

		//Spawn
		EntityRegistry.registerModEntity(EntityGaiaMandragora.class, "Mandragora", 81, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSummonButler.class, "Butler", 82, Gaia.instance, trackingRange, updateFrequency, true); 
		EntityRegistry.registerModEntity(EntityGaiaSummonSporeling.class, "Sporeling", 83, Gaia.instance, trackingRange, updateFrequency, true); 
		
		/** Eggs to register **/
		
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
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaMatango.class, 22, 0xab1311, 0xd8d8d8);
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
		ItemGaiaSpawnEgg.registerEntityEgg(EntityGaiaYukiOnna.class, 51, 6781114, 13817330);	
		
	}
}
