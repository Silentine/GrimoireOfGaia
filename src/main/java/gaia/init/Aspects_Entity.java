package gaia.init;

import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import gaia.Gaia;
import gaia.GaiaReference;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.ThaumcraftApi;

@InterfaceList({
	@Interface(iface="thaumcraft.api.ThaumcraftApi", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.Aspect", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.AspectList", modid="Thaumcraft", striprefs=true)})
public class Aspects_Entity extends GaiaEntity{
	
	/**Mod location to look for entity**/
	static String ref = GaiaReference.MOD_ID + ".";
	
	/**Primary method to register aspects**/
	public static void Entity_Aspects(){
		
		Gaia.logger.info("Registering Entity Aspects");
		
		
		ThaumcraftApi.registerEntityTag(ref+"Anubis",
				(new AspectList()).add(Aspect.BEAST, 4).add(Aspect.MAN, 2).add(Aspect.DARKNESS, 6));
		
		ThaumcraftApi.registerEntityTag(ref+"Banshee",
				(new AspectList()).add(Aspect.SOUL, 5).add(Aspect.UNDEAD, 4)
				.add(Aspect.FLIGHT, 3).add(Aspect.ENTROPY, 4));			
		
		
	}
}
