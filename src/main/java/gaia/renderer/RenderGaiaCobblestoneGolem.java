package gaia.renderer;

import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import gaia.model.ModelGaiaCobblestoneGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCobblestoneGolem extends RenderLiving<EntityGaiaCobblestoneGolem> {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Cobblestone_Golem.png");

	public RenderGaiaCobblestoneGolem(RenderManager renderManager, ModelGaiaCobblestoneGolem model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }
	
	protected ResourceLocation getEntityTexture(EntityGaiaCobblestoneGolem entity) {
		return texture;
	}
}
