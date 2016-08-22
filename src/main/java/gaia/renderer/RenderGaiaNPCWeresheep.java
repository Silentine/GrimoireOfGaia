package gaia.renderer;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCWeresheep;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCWeresheep extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Weresheep.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaNPCWeresheep( float shadowSize) {
        super(rend, new ModelGaiaNPCWeresheep(), shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
