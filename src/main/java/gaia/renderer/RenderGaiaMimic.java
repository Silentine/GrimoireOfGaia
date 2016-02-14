package gaia.renderer;

import gaia.model.ModelGaiaMimic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaMimic extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Mimic.png");

	public RenderGaiaMimic(RenderManager renderManager, ModelGaiaMimic model, float shadowSize) {
        super(renderManager, model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
