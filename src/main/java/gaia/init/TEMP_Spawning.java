package gaia.init;

import gaia.ConfigGaia;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.entity.monster.EntityGaiaWitch;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/** Temporary class to try and streamline spawning.**/
public class TEMP_Spawning {
	
	
	static Biome[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
	static Biome[] sandy = BiomeDictionary.getBiomesForType(Type.SANDY);
	static Biome[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
	static Biome[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
	static Biome[] spooky = BiomeDictionary.getBiomesForType(Type.SPOOKY);
	static Biome[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
	static Biome[] snowy = BiomeDictionary.getBiomesForType(Type.SNOWY);
	static Biome[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

	static Biome[] water = BiomeDictionary.getBiomesForType(Type.WATER);
	static Biome[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);

	static Biome[] hell = BiomeDictionary.getBiomesForType(Type.NETHER);
	static Biome[] sky = BiomeDictionary.getBiomesForType(Type.END);

	static int i;
	static SpawnListEntry SpawnEntry;
	
	/**specific subbiome to use**/
	public enum subbiome{
		TAIGA, COLDTAIGA, SPOOKY, NONE
	}
	
	/** Init area **/
	public static void register_spawn(){
		
		//General addition
		//usage (configuration weight, entity, min to spawn, max to spawn, biome to spawn in
		addspawn(ConfigGaia.SpawnDryad, EntityGaiaDryad.class, 4, 6, forest);
		
		//specific additions
		//usage (configuration weight, entity, min to spawn, max to spawn, biome to spawn, biome subtype
		addspawn(ConfigGaia.SpawnMatango, EntityGaiaWitch.class, 2, 6, forest, subbiome.SPOOKY);
		
		//add to all caves
		//usage (configuration weight, entity, min to spawn, max to spawn, spawn to caves
		addcave(ConfigGaia.SpawnCreep, EntityGaiaCreep.class, 2, 4);
		
	}
	
	/**Bridge methods**/
	public static void addspawn(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, Biome[] biome){
		addspawn(groupmax, entityclassIn, groupmax, groupmax, biome, false, subbiome.NONE);
	}
	public static void addcave(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax){
		addspawn(groupmax, entityclassIn, groupmax, groupmax, forest, true, subbiome.NONE);
	}
	public static void addspawn(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, Biome[] biome, subbiome subtype){
		addspawn(groupmax, entityclassIn, groupmax, groupmax, forest, false, subtype);
	}
	
	/** Iterates through the chosen biome to spawn and add mob to that spawning list **/
	public static void addspawn(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, Biome[] biome, boolean caves, subbiome subtype){	
		
		if(biome == forest || caves){
			for(i = 0; i < forest.length; ++i) 
			{
				// forest, forestHills, birchForest, birchForestHills
				if(subtype == subbiome.NONE || caves){
				if(!BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY)  
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MOUNTAIN) 
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY) 
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MAGICAL))  	 
				{
					addtoentry(configuration, entityclassIn, groupmin, groupmax, forest, i);
				}}
				
				//taiga, taigaHills, megaTaiga, megaTaigaHills
				if(subtype == subbiome.TAIGA || caves){
				if(BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
						&& (!BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
				{
					addtoentry(configuration, entityclassIn, groupmin, groupmax, forest, i);
				}}
				
				// coldTaiga, coldTaigaHills
				if(subtype == subbiome.COLDTAIGA || caves){
				if(BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS)
						&& (BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY))) 
				{
					addtoentry(configuration, entityclassIn, groupmin, groupmax, forest, i);				
				}}
				
				// roofedForest
				if(subtype == subbiome.SPOOKY || caves){
				if(BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY)) 
				{
					addtoentry(configuration, entityclassIn, groupmin, groupmax, forest, i);				
				}}
			}}
		
		// desert, desertHills, mesa, mesaPlateau, mesaPlateau_F 
		if(biome == sandy || caves){
			for(i = 0; i < sandy.length; ++i) 
			{
			addtoentry(configuration, entityclassIn, groupmin, groupmax, sandy, i);
			}}
		
		// plains, savanna, savannaPlateau 
		if(biome == plains || caves){
			for(i = 0; i < plains.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, plains, i);
			}}
		
		// swamp
		
		if(biome == swamp || caves){
			for(i = 0; i < swamp.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, swamp, i);
			}}
		// jungle
		
		if(biome == jungle || caves){
			for(i = 0; i < jungle.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, jungle, i);
			}
		}
		
		// icePlains, iceMountains
		if(biome == snowy || caves){
			for(i = 0; i < snowy.length; ++i) 
			{
				if(!BiomeDictionary.isBiomeOfType(snowy[i], Type.FOREST) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.OCEAN) 
					|| !BiomeDictionary.isBiomeOfType(snowy[i], Type.RIVER)) 
				{
					addtoentry(configuration, entityclassIn, groupmin, groupmax, snowy, i);
				}}}
		
		// extremeHills, extremeHillsPlus
		if(biome == mountain || caves){
			for(i = 0; i < mountain.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, mountain, i);
			}}
		
		// frozenRiver, coldBeach, stoneBeach, river, beach, ocean, deepOcean
		if(biome == water){
			for(i = 0; i < water.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, water, i);
			}}
		
		//beach
		if(biome == beach){
			for(i = 0; i < beach.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, beach, i);
			}}
		
		//hell
		if(biome == hell){
			for(i = 0; i < hell.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, hell, i);
			}}
		
		//sky
		if(biome == sky){
			for(i = 0; i < sky.length; ++i) 
			{
				addtoentry(configuration, entityclassIn, groupmin, groupmax, sky, i);
			}}
	}
	
	public static void addtoentry(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, Biome[] biome, int subbiome){	
		
		SpawnEntry = new SpawnListEntry(entityclassIn, configuration, groupmin, groupmax);
		biome[subbiome].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
	}
}
