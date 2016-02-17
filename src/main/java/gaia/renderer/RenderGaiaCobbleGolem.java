package gaia.renderer;

import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.model.ModelGaiaCobbleGolem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCobbleGolem extends RenderLiving<EntityGaiaCobbleGolem> {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Cobble_Golem.png");

	public RenderGaiaCobbleGolem(RenderManager renderManager, ModelGaiaCobbleGolem model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }
	
	protected ResourceLocation getEntityTexture(EntityGaiaCobbleGolem entity) {
		return texture;
	}
}
