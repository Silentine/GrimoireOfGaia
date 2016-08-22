package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCentaur;
import gaia.model.ModelGaiaCentaur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaCentaur extends RenderLiving<EntityGaiaCentaur> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Centaur.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaCentaur(float shadowSize) {
        super(rend, new ModelGaiaCentaur(), shadowSize);
        this.addLayer(new held_rightarm(this, ModelGaiaCentaur.rightarm));
    }
	
	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaCentaur entity) {
		return texture;
	}
}
