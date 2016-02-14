package gaia.renderer;

import gaia.model.ModelGaiaWitherCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaWitherCow extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Wither_Cow.png");

	public RenderGaiaWitherCow(RenderManager renderManager, ModelGaiaWitherCow model, float shadowSize) {
        super(renderManager, model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
