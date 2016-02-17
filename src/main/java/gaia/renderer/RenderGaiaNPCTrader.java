package gaia.renderer;

import gaia.model.ModelGaiaNPCTrader;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCTrader extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Trader.png");

	public RenderGaiaNPCTrader(RenderManager renderManager, ModelGaiaNPCTrader model, float shadowSize) {
        super(renderManager, model, shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
