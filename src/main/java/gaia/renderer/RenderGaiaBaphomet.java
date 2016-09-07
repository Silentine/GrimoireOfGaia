package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaBaphomet;
import gaia.model.ModelGaiaBaphomet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaBaphomet extends RenderLiving<EntityGaiaBaphomet> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Baphomet.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaBaphomet(float shadowSize) {
        super(rend, new ModelGaiaBaphomet(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaBaphomet.rightarm));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaBaphomet entity) {
		return texture;
	}
}
