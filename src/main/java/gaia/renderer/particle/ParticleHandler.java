package gaia.renderer.particle;

import gaia.GaiaReference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleHandler {

	/**
	 * Resources used.
	 * Path leads to textures/particles/image.png
	 */
	static final ResourceLocation PARTICLE_BUFF = new ResourceLocation(GaiaReference.MOD_ID, "particles/particlebuff");
	static final ResourceLocation PARTICLE_DROP = new ResourceLocation(GaiaReference.MOD_ID, "particles/particledrop");
	static final ResourceLocation PARTICLE_EXAMPLE = new ResourceLocation(GaiaReference.MOD_ID, "particles/particleexample");
	static final ResourceLocation PARTICLE_HEAL = new ResourceLocation(GaiaReference.MOD_ID, "particles/particleheal");
	static final ResourceLocation PARTICLE_WARNING = new ResourceLocation(GaiaReference.MOD_ID, "particles/particlewarning");

	/**
	 * "Register" or add textures to the particle mappings
	 */
	@SubscribeEvent
	public void stitcherEventPre(TextureStitchEvent.Pre event) {
		event.getMap().registerSprite(PARTICLE_BUFF);
		event.getMap().registerSprite(PARTICLE_DROP);
		event.getMap().registerSprite(PARTICLE_EXAMPLE);
		event.getMap().registerSprite(PARTICLE_HEAL);
		event.getMap().registerSprite(PARTICLE_WARNING);
	}
}
