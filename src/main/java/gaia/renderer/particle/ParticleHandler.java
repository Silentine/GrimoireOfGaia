package gaia.renderer.particle;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ParticleHandler
{
	/** Resources to use 
	 * Path leads to textures/particles/image.png**/
	//A static particle texture
//	static ResourceLocation BubbleLocation = new ResourceLocation(GaiaReference.MOD_ID,"particles/BlankBubble");
    //An animated particle texture
	static ResourceLocation BubbleLocation = new ResourceLocation(GaiaReference.MOD_ID,"particles/AnimatedBubble");
    
    
	/** "Register" or add textures to the particle mappings **/
	@SubscribeEvent
	public void stitcherEventPre(TextureStitchEvent.Pre event) {
	  
		event.getMap().registerSprite(BubbleLocation);
    
	}
}