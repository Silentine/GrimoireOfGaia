package gaia.init;

import gaia.ConfigGaia;
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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class GaiaEntity {

	public static void register(){
		byte trackingRange = 64;
		byte updateFrequency = 3;

		//EntityRegistry.registerModEntity(EntityGaiaAnubis.class, "Anubis", 1, Gaia.instance, trackingRange, updateFrequency, true);
		/*EntityRegistry.registerModEntity(EntityGaiaBanshee.class, "Banshee", 2, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBaphomet.class, "Baphomet", 3, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaBoneKnight.class, "Bone Knight", 4, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCentaur.class, "Centaur", 5, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobbleGolem.class, "Cobble Golem", 6, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCobblestoneGolem.class, "Cobblestone Golem", 7, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCockatrice.class, "Cockatrice", 8, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCreep.class, "Creep", 9, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaCyclops.class, "Cyclops", 10, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaPropFlowerCyan.class, "Cyan Flower", 11, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDhampir.class, "Dhampir", 12, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDryad.class, "Dryad", 13, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaDullahan.class, "Dullahan", 14, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderDragonGirl.class, "Ender Dragon Girl", 15, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaEnderEye.class, "Ender Eye", 16, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFleshLich.class, "Flesh Lich", 17, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaFutakuchiOnna.class, "FutakuchiOnna", 18, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaGryphon.class, "Gryphon", 19, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHarpy.class, "Harpy", 20, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaHunter.class, "Hunter", 21, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaJorogumo.class, "Jorogumo", 22, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaKobold.class, "Kobold", 47, Gaia.instance, trackingRange, updateFrequency, true); //ID
		EntityRegistry.registerModEntity(EntityGaiaMermaid.class, "Mermaid", 23, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMimic.class, "Mimic", 24, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaur.class, "Minotaur", 25, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaMinotaurus.class, "Minotaurus", 26, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNaga.class, "Naga", 27, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNineTails.class, "NineTails", 28, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSahuagin.class, "Sahuagin", 29, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSatyr.class, "Satyr", 30, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSelkie.class, "Selkie", 31, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaShaman.class, "Shaman", 32, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSharko.class, "Sharko", 33, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSiren.class, "Siren", 34, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSludgeGirl.class, "Sludge Girl", 35, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSphinx.class, "Sphinx", 36, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSpriggan.class, "Spriggan", 37, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSuccubus.class, "Succubus", 38, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSwamper.class, "Swamper", 39, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaValkyrie.class, "Valkyrie", 40, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaVampire.class, "Vampire", 41, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWerecat.class, "Werecat", 42, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitch.class, "Witch", 43, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaWitherCow.class, "Wither Cow", 44, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYeti.class, "Yeti", 45, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaYukiOnna.class, "Yuki-Onna", 46, Gaia.instance, trackingRange, updateFrequency, true);

		EntityRegistry.registerModEntity(EntityGaiaNPCCreeperGirl.class, "Creeper Girl", 60, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCEnderGirl.class, "Ender Girl", 63, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCHolstaurus.class, "Holstaurus", 64, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCSlimeGirl.class, "Slime Girl", 62, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaNPCTrader.class, "Trader", 61, Gaia.instance, trackingRange, updateFrequency, true);
	
		EntityRegistry.registerModEntity(EntityGaiaProjectileSmallFireball.class, "Small Fireball", 100, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaProjectileMagic.class, "Magic", 101, Gaia.instance, trackingRange, updateFrequency, true);

		EntityRegistry.registerModEntity(EntityGaiaMandragora.class, "Mandragora", 80, Gaia.instance, trackingRange, updateFrequency, true);
		EntityRegistry.registerModEntity(EntityGaiaSummonButler.class, "Butler", 81, Gaia.instance, trackingRange, updateFrequency, true); */
		
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
}
