package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.model.ModelGaiaEnderEye;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaEnderEye extends RenderLiving<EntityGaiaEnderEye> {

	private static final ResourceLocation endereyeEyesTexture = new ResourceLocation("gaia", "textures/models/eyes/Eyes_Ender_Eye.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Ender_Eye.png");
	
	public RenderGaiaEnderEye(RenderManager renderManager, ModelGaiaEnderEye model, float shadowSize) {
        super(renderManager, model, shadowSize);
		//this.setRenderPassModel(new ModelGaiaEnderEye());
	}

	protected int shouldRenderPass(EntityGaiaEnderEye par1EntityGaiaEnderEye, int par2, float par3) {
		if (par1EntityGaiaEnderEye.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(endereyeEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (par1EntityGaiaEnderEye.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
		}
	}

	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaEnderEye)par1EntityLiving, par2, par3);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaEnderEye entity) {
		return texture;
	}
}
