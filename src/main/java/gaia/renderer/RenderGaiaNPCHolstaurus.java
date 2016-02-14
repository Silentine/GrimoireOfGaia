package gaia.renderer;

import gaia.model.ModelGaiaNPCHolstaurus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCHolstaurus extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Holstaurus.png");

	public RenderGaiaNPCHolstaurus(RenderManager renderManager, ModelGaiaNPCHolstaurus model, float shadowSize) {
        super(renderManager, model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
