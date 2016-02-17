package gaia.renderer;

import gaia.model.ModelGaiaSuccubus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSuccubus extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Succubus.png");

	public RenderGaiaSuccubus(RenderManager renderManager, ModelGaiaSuccubus model, float shadowSize) {
        super(renderManager, model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
