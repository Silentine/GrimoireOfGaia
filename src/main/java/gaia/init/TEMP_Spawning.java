package gaia.init;

import gaia.ConfigGaia;
import gaia.entity.monster.EntityGaiaDryad;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

/** Temporary class to try and streamline spawning.**/
public class TEMP_Spawning {
	
	
	static BiomeGenBase[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);
	static BiomeGenBase[] sandy = BiomeDictionary.getBiomesForType(Type.SANDY);
	static BiomeGenBase[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
	static BiomeGenBase[] swamp = BiomeDictionary.getBiomesForType(Type.SWAMP);
	static BiomeGenBase[] spooky = BiomeDictionary.getBiomesForType(Type.SPOOKY);
	static BiomeGenBase[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
	static BiomeGenBase[] snowy = BiomeDictionary.getBiomesForType(Type.SNOWY);
	static BiomeGenBase[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);

	static BiomeGenBase[] water = BiomeDictionary.getBiomesForType(Type.WATER);
	static BiomeGenBase[] beach = BiomeDictionary.getBiomesForType(Type.BEACH);

	static BiomeGenBase[] hell = BiomeDictionary.getBiomesForType(Type.NETHER);
	static BiomeGenBase[] sky = BiomeDictionary.getBiomesForType(Type.END);

	static int i;
	static SpawnListEntry SpawnEntry;
	
	/** Init area **/
	public static void register_spawn(){
		
		addspawn(ConfigGaia.SpawnDryad, EntityGaiaDryad.class, 4, 6, forest);
		
	}
	
	
	/** Incomplete but will iterate through the chosen biome to spawn and add mod to that spawning list **/
	public static void addspawn(int configuration, Class <? extends EntityLiving > entityclassIn, int groupmin, int groupmax, BiomeGenBase[] biome){	
		
		if(biome == forest){
			for(i = 0; i < forest.length; ++i) 
			{
				// forest, forestHills, birchForest, birchForestHills
				if(!BiomeDictionary.isBiomeOfType(forest[i], Type.CONIFEROUS) 
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SNOWY)  
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MOUNTAIN) 
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.SPOOKY) 
						&& !BiomeDictionary.isBiomeOfType(forest[i], Type.MAGICAL))  	 
				{
					SpawnEntry = new SpawnListEntry(entityclassIn, configuration, groupmin, groupmax);
					forest[i].getSpawnableList(EnumCreatureType.MONSTER).add(SpawnEntry);
				}
			}}
		
	}
	
	
}
