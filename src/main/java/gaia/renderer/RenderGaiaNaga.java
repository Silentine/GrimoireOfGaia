package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNaga;
import gaia.model.ModelGaiaSharko;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNaga extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Naga.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaNaga(float shadowSize) {
        super(rend, new ModelGaiaNaga(), shadowSize);
        //this.addLayer(new held_rightarm_special(this, ModelGaiaNaga.rightarm));
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaNaga.rightarm));
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
