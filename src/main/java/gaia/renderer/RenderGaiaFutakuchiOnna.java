package gaia.renderer;

import gaia.GaiaReference;
import gaia.model.ModelGaiaFutakuchiOnna;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaFutakuchiOnna extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Futakuchi_Onna.png");
	
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaFutakuchiOnna( float shadowSize) {
        super(rend, new ModelGaiaFutakuchiOnna(), shadowSize);
    }

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
