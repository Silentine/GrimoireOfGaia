package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaYeti;
import gaia.model.ModelGaiaYeti;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaYeti extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Yeti.png");

	public RenderGaiaYeti(RenderManager renderManager, ModelGaiaYeti model, float shadowSize) {
        super(renderManager, model, shadowSize);
		//this.setRenderPassModel(new ModelGaiaYeti());
	}

	protected void scaleYeti(EntityGaiaYeti par1EntityGaiaYeti, float par2) {
		float f1 = par1EntityGaiaYeti.YetiScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleYeti((EntityGaiaYeti)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
