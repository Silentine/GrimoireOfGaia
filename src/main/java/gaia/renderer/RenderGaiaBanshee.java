package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaBanshee;
import gaia.model.ModelGaiaBanshee;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaBanshee extends RenderLiving<EntityGaiaBanshee> {

	private static final ResourceLocation bansheeEyesTexture = new ResourceLocation("gaia", "textures/models/Banshee.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Banshee.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaBanshee( float shadowSize) {
        super(rend, new ModelGaiaBanshee(), shadowSize);
        
        this.addLayer(new Glowing_layer(this, bansheeEyesTexture));
    }
	/*
	protected int shouldRenderPass(EntityGaiaBanshee par1EntityGaiaBanshee, int par2, float par3) {
		if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(bansheeEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (par1EntityGaiaBanshee.isInvisible())
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
	*/
	protected int shouldRenderPass(EntityLivingBase par1EntityLiving, int par2, float par3) {
		return this.shouldRenderPass((EntityGaiaBanshee)par1EntityLiving, par2, par3);
	}

	protected ResourceLocation getEntityTexture(EntityGaiaBanshee entity) {
		return texture;
	}
}
