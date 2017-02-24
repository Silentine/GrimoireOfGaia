package gaia.init;

import gaia.GaiaConfig;
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
import gaia.entity.monster.EntityGaiaMatango;
import gaia.entity.monster.EntityGaiaMermaid;
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
import gaia.entity.monster.EntityGaiaToad;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaVampire;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.entity.monster.EntityGaiaWitherCow;
import gaia.entity.monster.EntityGaiaYeti;
import gaia.entity.monster.EntityGaiaYukiOnna;
import gaia.entity.passive.EntityGaiaPropChestMimic;
import gaia.entity.passive.EntityGaiaPropFlowerCyan;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import org.apache.commons.lang3.ArrayUtils;

/** 
 * Streamlined Spawning Registry, 
 * Tried to keep structure as similar,
 * but cleaned up methods and repetitive code to save time and fingers.
 */
public class GaiaSpawning extends GaiaConfig{

	static int i;
	static SpawnListEntry SpawnEntry;

	/**
	 * Bridge Method for simpler spawning registry
	 */
	public static void add(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, Biome[] biome, int subbiome) {	
		if (configuration > 0 ) {
			SpawnEntry = new SpawnListEntry(entityclassIn, configuration, groupmin, groupmax);
			biome[subbiome].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
		}
	}

	/** 
	 * Underground Creature Roster 
	 */
	public static void underground(Biome[] biome, int subbiome) {		
		add(SpawnCreep, EntityGaiaCreep.class, 2, 4, biome, subbiome);
		add(SpawnEnderEye, EntityGaiaEnderEye.class, 2, 4, biome, subbiome);	
		add(SpawnArachne, EntityGaiaArachne.class, 1, 2, biome, subbiome);	
		add(SpawnMimic, EntityGaiaPropChestMimic.class, 1, 2, biome, subbiome);		
		add(SpawnBoneKnight, EntityGaiaBoneKnight.class, 1, 2, biome, subbiome);	
		add(SpawnFleshLich, EntityGaiaFleshLich.class, 1, 2, biome, subbiome);
	}
	
	//Water based mobs
	public static void aquatic(Biome[] biome, int subbiome) {
		add(SpawnSahuagin, EntityGaiaSahuagin.class, 4, 6, biome, subbiome);		
		add(SpawnMermaid, EntityGaiaMermaid.class, 2, 4, biome, subbiome);		
		add(SpawnSharko, EntityGaiaSharko.class, 2, 4, biome, subbiome);	
	}

	/** 
	 * Register Mobs based on Biome sub Types 
	 */
	public static void register() {

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
			//forest, forestHills, birchForest, birchForestHills
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
				add(SpawnMandragora, EntityGaiaPropFlowerCyan.class, 1, 2, forest, i);	
				
				add(SpawnCyclops, EntityGaiaCyclops.class, 4, 6, forest, i);

				add(SpawnYukiOnna, EntityGaiaYukiOnna.class, 2, 4, forest, i);

				add(SpawnFutakuchiOnna, EntityGaiaFutakuchiOnna.class, 4, 6, forest, i);

				add(SpawnNineTails, EntityGaiaNineTails.class, 2, 4, forest, i);

				underground(forest, i);
			} 

			//coldTaiga, coldTaigaHills
			if (BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS)
					&& (BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
			{		
				add(SpawnDhampir, EntityGaiaDhampir.class, 2, 4, forest, i);

				if (GaiaConfig.SpawnLevel3 != true) {
					add(SpawnVampire, EntityGaiaVampire.class, 1, 2, forest, i);
				}

				underground(forest, i);
			}

			//roofedForest
			if (BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY)) 
			{		
				add(SpawnMatango, EntityGaiaMatango.class, 2, 4, forest, i);
				
				add(SpawnToad, EntityGaiaToad.class, 2, 4, forest, i);

				add(SpawnWitch, EntityGaiaWitch.class, 2, 4, forest, i);
				
				underground(forest, i);
			}
		}

		//desert, desertHills, mesa, mesaPlateau, mesaPlateau_F 
		for (i = 0; i < sandy.length; ++i) 
		{
			add(SpawnAnt, EntityGaiaAnt.class, 2, 4, sandy, i);
			
			add(SpawnMummy, EntityGaiaMummy.class, 2, 4, sandy, i);

			add(SpawnAnubis, EntityGaiaAnubis.class, 2, 4, sandy, i);

			if (GaiaConfig.SpawnLevel3 != true) {
				add(SpawnSphinx, EntityGaiaSphinx.class, 1, 2, sandy, i);
			}

			underground(sandy, i);
		}

		//plains, savanna, savannaPlateau 
		for (i = 0; i < plains.length; ++i) 
		{
			add(SpawnSatyress, EntityGaiaSatyress.class, 2, 4, plains, i);

			add(SpawnCentaur, EntityGaiaCentaur.class, 4, 6, plains, i);
			
			add(SpawnHarpy, EntityGaiaHarpy.class, 2, 4, plains, i);

			add(SpawnMinotaurus, EntityGaiaMinotaurus.class, 2, 4, plains, i);

			if (GaiaConfig.SpawnLevel3 != true) {
				add(SpawnMinotaur, EntityGaiaMinotaur.class, 1, 2, plains, i);
			}

			underground(plains, i);
		}

		//swamp
		for (i = 0; i < swamp.length; ++i) 
		{
			add(SpawnSiren, EntityGaiaSiren.class, 4, 6, swamp, i);

			add(SpawnSludgeGirl, EntityGaiaSludgeGirl.class, 2, 4, swamp, i);
			
			add(SpawnNaga, EntityGaiaNaga.class, 1, 2, swamp, i);

			underground(swamp, i);
		}

		//jungle
		for (i = 0; i < jungle.length; ++i) 
		{
			add(SpawnCobbleGolem, EntityGaiaCobbleGolem.class, 2, 4, jungle, i);

			add(SpawnHunter, EntityGaiaHunter.class, 2, 4, jungle, i);

			add(SpawnShaman, EntityGaiaShaman.class, 2, 4, jungle, i);

			add(SpawnCobblestoneGolem, EntityGaiaCobblestoneGolem.class, 2, 4, jungle, i);

			underground(jungle, i);
		}

		//icePlains, iceMountains
		for (i = 0; i < snowy.length; ++i) 
		{
			if (!BiomeDictionary.isBiomeOfType(snowy[i], Type.FOREST) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.OCEAN) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.RIVER)) 
			{
				add(SpawnSelkie, EntityGaiaSelkie.class, 2, 4, snowy, i);
				
				add(SpawnKobold, EntityGaiaKobold.class, 4, 6, snowy, i);
				
				add(SpawnYeti, EntityGaiaYeti.class, 2, 4, snowy, i);

				underground(snowy, i);
			}
		}

		//extremeHills, extremeHillsPlus
		for (i = 0; i < mountain.length; ++i) 
		{
			if (!BiomeDictionary.isBiomeOfType(mountain[i], Type.SNOWY)) 
			{
				add(SpawnDwarf, EntityGaiaDwarf.class, 4, 6, mountain, i);

				if (GaiaConfig.SpawnLevel3 != true) {
					add(SpawnValkyrie, EntityGaiaValkyrie.class, 1, 2, mountain, i);
				}

				add(SpawnDullahan, EntityGaiaDullahan.class, 4, 6, mountain, i);

				add(SpawnBanshee, EntityGaiaBanshee.class, 2, 4, mountain, i);

				underground(mountain, i);
			}
		}

		//frozenRiver, coldBeach, stoneBeach, river, beach, ocean, deepOcean
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

	/** 
	 * "Mutated" biomes don't have type dictionaries by default. 
	 * This addition compensates for specific sub biomes having gaps in creature spawning.
	 */
	public static void Biome_Tweaks() {
		Gaia.logger.info("Sub Biome Tweaks Enabled");

		BiomeDictionary.registerBiomeType(Biomes.MUTATED_ROOFED_FOREST,
				BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST);

		BiomeDictionary.registerBiomeType(Biomes.MUTATED_EXTREME_HILLS,
				BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);

		BiomeDictionary.registerBiomeType(Biomes.MUTATED_EXTREME_HILLS_WITH_TREES,
				BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
	}
}
