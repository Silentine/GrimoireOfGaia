package gaia.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional.Interface;
import net.minecraftforge.fml.common.Optional.InterfaceList;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import gaia.Gaia;
import gaia.GaiaReference;

@InterfaceList({
	@Interface(iface="thaumcraft.api.ThaumcraftApi", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.Aspect", modid="Thaumcraft", striprefs=true),
	@Interface(iface="thaumcraft.api.aspects.AspectList", modid="Thaumcraft", striprefs=true)})
public class Aspects_Items extends GaiaItem{
	
	
	/**Primary method to register aspects**/
	public static void Item_Aspects(){
			
		Gaia.logger.info("Registering Item Aspects");
		
		//Default item/metadata
		ThaumcraftApi.registerObjectTag(new ItemStack(BookWither), 
				(new AspectList()).add(Aspect.DEATH, 5).add(Aspect.ENTROPY, 2).add(Aspect.DARKNESS, 4));
		
		//Meta sensitive
		ThaumcraftApi.registerObjectTag(new ItemStack(PropWeapon, 1, 1),
				(new AspectList()).add(Aspect.FIRE, 4).add(Aspect.ELDRITCH, 2).add(Aspect.AVERSION, 3));
				
		//Blocks
		ThaumcraftApi.registerObjectTag(new ItemStack(GaiaBlock.BustSphinx),
				(new AspectList()).add(Aspect.EARTH, 4).add(Aspect.DESIRE, 2));
	
	}

}
