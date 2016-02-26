package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.model.ModelGaiaSludgeGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSludgeGirl extends RenderLiving {

	private static final ResourceLocation hairSludgeGirl = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Sludge_Girl_Hair.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Sludge_Girl.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSludgeGirl(float shadowSize) {
        super(rend, new ModelGaiaSludgeGirl(), shadowSize);
		//this.setRenderPassModel(new ModelGaiaSludgeGirl());
        this.addLayer(new Alpha_layer(this, hairSludgeGirl));
	}
	/*
	protected int shouldRenderPass(EntityGaiaSludgeGirl par1EntityGaiaSludgeGirl, int par2, float par3) {
		if (par1EntityGaiaSludgeGirl.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(hairSludgeGirl);
            GL11.glEnable(GL11.GL_NORMALIZE);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            return 1;
		}
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaSludgeGirl)par1EntityLiving, par2, par3);
	}
	*/
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
