package gaia.renderer.particle;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ParticleHandler {
	/** 
	 * Resources used.
	 * Path leads to textures/particles/image.png
	 */
	static ResourceLocation particleBuff = new ResourceLocation(GaiaReference.MOD_ID,"particles/ParticleBuff");
	static ResourceLocation particleDrop = new ResourceLocation(GaiaReference.MOD_ID,"particles/ParticleDrop");
	static ResourceLocation particleExample = new ResourceLocation(GaiaReference.MOD_ID,"particles/ParticleExample");
	static ResourceLocation particleHeal = new ResourceLocation(GaiaReference.MOD_ID,"particles/ParticleHeal");
	static ResourceLocation particleWarning = new ResourceLocation(GaiaReference.MOD_ID,"particles/ParticleWarning");

	/** 
	 * "Register" or add textures to the particle mappings 
	 */
	@SubscribeEvent
	public void stitcherEventPre(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(particleBuff);
		event.getMap().registerSprite(particleDrop);
		event.getMap().registerSprite(particleExample);
		event.getMap().registerSprite(particleHeal);
		event.getMap().registerSprite(particleWarning);
	}
}