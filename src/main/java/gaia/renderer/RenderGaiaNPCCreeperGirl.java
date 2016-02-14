package gaia.renderer;

import gaia.model.ModelGaiaNPCCreeperGirl;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCCreeperGirl extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Creeper_Girl.png");

	public RenderGaiaNPCCreeperGirl(RenderManager renderManager, ModelGaiaNPCCreeperGirl model, float shadowSize) {
        super(renderManager, model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
