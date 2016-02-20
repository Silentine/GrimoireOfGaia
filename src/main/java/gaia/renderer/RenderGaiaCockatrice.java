package gaia.renderer;

import gaia.entity.monster.EntityGaiaCockatrice;
import gaia.model.ModelGaiaCockatrice;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaCockatrice extends RenderLiving<EntityGaiaCockatrice> {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Cockatrice.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaCockatrice( float shadowSize) {
        super(rend, new ModelGaiaCockatrice(), shadowSize);
    }
	
	protected ResourceLocation getEntityTexture(EntityGaiaCockatrice entity) {
		return texture;
	}
}
