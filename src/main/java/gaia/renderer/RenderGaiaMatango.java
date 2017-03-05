package gaia.renderer;

import gaia.GaiaReference;
import gaia.model.ModelGaiaMatango;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaMatango extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Matango.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaMatango( float shadowSize) {
        super(rend, new ModelGaiaMatango(), shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
