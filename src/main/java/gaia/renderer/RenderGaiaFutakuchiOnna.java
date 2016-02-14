package gaia.renderer;

import gaia.model.ModelGaiaFutakuchiOnna;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaFutakuchiOnna extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Futakuchi_Onna.png");
	
	public RenderGaiaFutakuchiOnna(RenderManager renderManager, ModelGaiaFutakuchiOnna model, float shadowSize) {
        super(renderManager, model, shadowSize);
    }

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
