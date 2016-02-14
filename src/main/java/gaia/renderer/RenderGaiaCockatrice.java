package gaia.renderer;

import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.model.ModelGaiaCockatrice;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCockatrice extends RenderLiving<EntityGaiaCockatrice> {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Cockatrice.png");

	public RenderGaiaCockatrice(RenderManager renderManager, ModelGaiaCockatrice model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }
	
	protected ResourceLocation getEntityTexture(EntityGaiaCockatrice entity) {
		return texture;
	}
}
