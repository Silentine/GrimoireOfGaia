package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.passive.EntityGaiaNPCEnderGirl;
import gaia.model.ModelGaiaNPCEnderGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCEnderGirl extends RenderLiving {

	private static final ResourceLocation endergirlEyesTexture = new ResourceLocation("gaia", "textures/models/eyes/Eyes_Ender_Girl.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Ender_Girl.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaNPCEnderGirl( float shadowSize) {
        super(rend, new ModelGaiaNPCEnderGirl(), shadowSize);
		//this.setRenderPassModel(new ModelGaiaNPCEnderGirl());
        this.addLayer(new Glowing_layer(this, endergirlEyesTexture));
	}

	protected int shouldRenderPass(EntityGaiaNPCEnderGirl par1EntityGaiaNPCEnderGirl, int par2, float par3) {
		if (par1EntityGaiaNPCEnderGirl.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(endergirlEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (par1EntityGaiaNPCEnderGirl.isInvisible())
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
		return this.shouldRenderPass((EntityGaiaNPCEnderGirl)par1EntityLiving, par2, par3);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
