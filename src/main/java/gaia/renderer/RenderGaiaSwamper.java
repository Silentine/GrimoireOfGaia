package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaSwamper;
import gaia.model.ModelGaiaSwamper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSwamper extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Swamper.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSwamper( float shadowSize) {
        super(rend, new ModelGaiaSwamper(), shadowSize);
		//this.setRenderPassModel(new ModelGaiaSwamper());
	}

	protected void scaleSwamper(EntityGaiaSwamper par1EntityGaiaSwamper, float par2) {
		float f1 = par1EntityGaiaSwamper.SwamperScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleSwamper((EntityGaiaSwamper)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
