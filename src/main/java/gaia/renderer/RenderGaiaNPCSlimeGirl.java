package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.passive.EntityGaiaNPCSlimeGirl;
import gaia.model.ModelGaiaNPCSlimeGirl;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCSlimeGirl extends RenderLiving {

	private static final ResourceLocation hairSlimeGirl = new ResourceLocation("gaia", "textures/models/Slime_Girl_Hair.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Slime_Girl.png");

	public RenderGaiaNPCSlimeGirl(RenderManager renderManager, ModelGaiaNPCSlimeGirl model, float shadowSize) {
        super(renderManager, model, shadowSize);
		//this.setRenderPassModel(new ModelGaiaNPCSlimeGirl());
	}
	
	protected int shouldRenderPass(EntityGaiaNPCSlimeGirl par1EntityGaiaSlimeGirl, int par2, float par3) {
		if (par1EntityGaiaSlimeGirl.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(hairSlimeGirl);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
		}
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaNPCSlimeGirl)par1EntityLiving, par2, par3);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
