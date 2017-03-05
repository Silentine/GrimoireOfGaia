package gaia.renderer;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCHolstaurus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCHolstaurus extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Holstaurus.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaNPCHolstaurus( float shadowSize) {
        super(rend, new ModelGaiaNPCHolstaurus(), shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
