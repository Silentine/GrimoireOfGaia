package gaia.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSummonButler extends RenderBiped {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Summon_Butler.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaSummonButler( float shadowSize) {
        super(rend, new ModelBiped(), shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
