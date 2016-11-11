package gaia.init;

import org.apache.commons.lang3.ArrayUtils;

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
import gaia.entity.monster.EntityGaiaSwamper;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/** Streamlined Spawning Registry, 
 * Tried to keep structure as similiar,
 * But cleaned up methods and repetitive code to save time and fingers**/
public class GaiaSpawning extends ConfigGaia{
	
	static int i;
	static SpawnListEntry SpawnEntry;
	
	/**Bridge Method for simpler spawning registry**/
	public static void add(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, Biome[] biome, int subbiome){	
		
		if(configuration >0 ){
			SpawnEntry = new SpawnListEntry(entityclassIn, configuration, groupmin, groupmax);
			biome[subbiome].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
			}
	}
	
	/** Underground Creature Roster **/
	public static void underground(Biome[] biome, int subbiome)
	{		
		add(SpawnCreep, EntityGaiaCreep.class, 2, 4, biome, subbiome);
		add(SpawnEnderEye, EntityGaiaEnderEye.class, 2, 4, biome, subbiome);	
		add(SpawnJorogumo, EntityGaiaJorogumo.class, 1, 2, biome, subbiome);	
		add(SpawnMimic, EntityGaiaMimic.class, 1, 2, biome, subbiome);		
		add(SpawnBoneKnight, EntityGaiaBoneKnight.class, 1, 2, biome, subbiome);	
		add(SpawnFleshLich, EntityGaiaFleshLich.class, 1, 2, biome, subbiome);
		
	}
	//Water bassed mobs
	public static void aquatic(Biome[] biome, int subbiome)
	{
		add(SpawnSahuagin, EntityGaiaSahuagin.class, 4, 6, biome, subbiome);		
		add(SpawnMermaid, EntityGaiaMermaid.class, 2, 4, biome, subbiome);		
		add(SpawnSharko, EntityGaiaSharko.class, 2, 4, biome, subbiome);	
	}
	
	/** Register Mobs based on Biome sub Types **/
	public static void register(){

		Biome[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
		Biome[] sandy = BiomeDictionary.getBiomesForType(Type.SANDY);
		Biome[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
		Biome[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
		Biome[] spooky = BiomeDictionary.getBiomesForType(Type.SPOOKY);
		Biome[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
		Biome[] snowy = BiomeDictionary.getBiomesForType(Type.SNOWY);
		Biome[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);
		Biome[] hills = BiomeDictionary.getBiomesForType(Type.HILLS);
		
		  Biome[] ocean = BiomeDictionary.getBiomesForType(Type.OCEAN);
		  Biome[] river = BiomeDictionary.getBiomesForType(Type.RIVER);
		Biome[] water = (Biome[])ArrayUtils.addAll(ocean, river);
		Biome[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);

		Biome[] hell = BiomeDictionary.getBiomesForType(Type.NETHER);
		Biome[] sky = BiomeDictionary.getBiomesForType(Type.END);
		
		
		for (i = 0; i < forest.length; ++i) 
		{
			
			// forest, forestHills, birchForest, birchForestHills
			if (!BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY)  
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MOUNTAIN) 
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY) 
					&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MAGICAL))  	 
			{
				
				add(SpawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, forest, i);	
				
				add(SpawnDryad, EntityGaiaDryad.class, 4, 6, forest, i);
				
				add(SpawnWerecat, EntityGaiaWerecat.class, 4, 6, forest, i);	
				
				add(SpawnSpriggan, EntityGaiaSpriggan.class, 2, 4, forest, i);	
				
				underground(forest, i);
				
			}

			//taiga, taigaHills, megaTaiga, megaTaigaHills
			if (BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
					&& (!BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
			{
				add(SpawnCyclops, EntityGaiaCyclops.class, 4, 6, forest, i);
				
				add(SpawnYukiOnna, EntityGaiaYukiOnna.class, 2, 4, forest, i);
				
				add(SpawnFutakuchiOnna, EntityGaiaFutakuchiOnna.class, 4, 6, forest, i);
				
				add(SpawnNineTails, EntityGaiaNineTails.class, 2, 4, forest, i);
				
				underground(forest, i);
			} 

			// coldTaiga, coldTaigaHills
			if (BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS)
					&& (BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
			{		
				add(SpawnDhampir, EntityGaiaDhampir.class, 2, 4, forest, i);
				
				add(SpawnVampire, EntityGaiaVampire.class, 1, 2, forest, i);

				underground(forest, i);
			}

			// roofedForest
			if (BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY)) 
			{		
				add(SpawnMatango, EntityGaiaMatango.class, 2, 4, forest, i);
				
				add(SpawnWitch, EntityGaiaWitch.class, 2, 4, forest, i);

				underground(forest, i);
			}
		}

		// desert, desertHills, mesa, mesaPlateau, mesaPlateau_F 
		for (i = 0; i < sandy.length; ++i) 
		{
			add(SpawnCockatrice, EntityGaiaCockatrice.class, 2, 4, sandy, i);
			
			add(SpawnHarpy, EntityGaiaHarpy.class, 2, 4, sandy, i);
			
			add(SpawnAnubis, EntityGaiaAnubis.class, 2, 4, sandy, i);
			
			add(SpawnSphinx, EntityGaiaSphinx.class, 1, 2, sandy, i);

			underground(sandy, i);
		}

		// plains, savanna, savannaPlateau 
		for (i = 0; i < plains.length; ++i) 
		{
			add(SpawnSatyr, EntityGaiaSatyr.class, 2, 4, plains, i);
			
			add(SpawnCentaur, EntityGaiaCentaur.class, 4, 6, plains, i);
			
			add(SpawnMinotaurus, EntityGaiaMinotaurus.class, 2, 4, plains, i);
			
			add(SpawnMinotaur, EntityGaiaMinotaur.class, 1, 2, plains, i);
			
			underground(plains, i);
		}

		// swamp
		for (i = 0; i < swamp.length; ++i) 
		{
			add(SpawnSiren, EntityGaiaSiren.class, 4, 6, swamp, i);
			
			add(SpawnNaga, EntityGaiaNaga.class, 1, 2, swamp, i);
			
			add(SpawnSludgeGirl, EntityGaiaSludgeGirl.class, 2, 4, swamp, i);
			
			add(SpawnSwamper, EntityGaiaSwamper.class, 1, 2, swamp, i);
			
			underground(swamp, i);
		}

		// jungle
		for (i = 0; i < jungle.length; ++i) 
		{
			add(SpawnCobbleGolem, EntityGaiaCobbleGolem.class, 2, 4, jungle, i);
			
			add(SpawnHunter, EntityGaiaHunter.class, 2, 4, jungle, i);
			
			add(SpawnShaman, EntityGaiaShaman.class, 2, 4, jungle, i);
			
			add(SpawnCobblestoneGolem, EntityGaiaCobblestoneGolem.class, 2, 4, jungle, i);
			
			underground(jungle, i);
		}

		// icePlains, iceMountains
		for (i = 0; i < snowy.length; ++i) 
		{
			if (!BiomeDictionary.isBiomeOfType(snowy[i], Type.FOREST) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.OCEAN) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.RIVER)) 
			{
				
				add(SpawnYeti, EntityGaiaYeti.class, 4, 6, snowy, i);
				
				add(SpawnSelkie, EntityGaiaSelkie.class, 2, 4, snowy, i);

				underground(snowy, i);
			}
		}

		// extremeHills, extremeHillsPlus
		for (i = 0; i < mountain.length; ++i) 
		{
			if (!BiomeDictionary.isBiomeOfType(mountain[i], Type.SNOWY)) 
			{
				add(SpawnGryphon, EntityGaiaGryphon.class, 4, 6, mountain, i);
				
				add(SpawnValkyrie, EntityGaiaValkyrie.class, 1, 2, mountain, i);
				
				add(SpawnDullahan, EntityGaiaDullahan.class, 4, 6, mountain, i);
				
				add(SpawnBanshee, EntityGaiaBanshee.class, 2, 4, mountain, i);

				underground(mountain, i);
			}
		}
		
		// frozenRiver, coldBeach, stoneBeach, river, beach, ocean, deepOcean
		for (i = 0; i < water.length; ++i) 
		{
			aquatic( water, i);
		}

		for (i = 0; i < beach.length; ++i) 
		{
			aquatic( beach, i);
		}

		//hell
		for (i = 0; i < hell.length; ++i) 
		{
			add(SpawnSuccubus, EntityGaiaSuccubus.class, 2, 4, hell, i);
			
			add(SpawnWitherCow, EntityGaiaWitherCow.class, 1, 2, hell, i);
			
			add(SpawnBaphomet, EntityGaiaBaphomet.class, 1, 2, hell, i);
		}

		//sky
		for (i = 0; i < sky.length; ++i) 
		{
			if (BiomeDictionary.isBiomeOfType(sky[i], Type.COLD) 
					&& (BiomeDictionary.isBiomeOfType(sky[i], Type.DRY))) 
			{
				add(SpawnEnderDragonGirl, EntityGaiaEnderDragonGirl.class, 1, 2, sky, i);
			}
		}
		
		
	}
	
	/** "Mutated" biomes don't have type dictionaries by default. 
	 * This addition compensates for specific sub biomes having gaps in creature spawning.
	 */
	public static void Biome_Tweaks(){
		Gaia.logger.info("Sub Biome Tweaks Enabled");
		
		BiomeDictionary.registerBiomeType(Biomes.MUTATED_ROOFED_FOREST,
				BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST);
		
		BiomeDictionary.registerBiomeType(Biomes.MUTATED_EXTREME_HILLS,
				BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
		
		BiomeDictionary.registerBiomeType(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES,
				BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
	}
	
	

}
