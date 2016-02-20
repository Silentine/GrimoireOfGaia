package gaia.renderer;

import gaia.model.ModelGaiaWitherCow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaWitherCow extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Wither_Cow.png");
	
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaWitherCow( float shadowSize) {
        super(rend, new ModelGaiaWitherCow(), shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
