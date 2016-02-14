package gaia.renderer;

import gaia.entity.monster.EntityGaiaVampire;
import gaia.model.ModelGaiaVampire;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaVampire extends RenderLiving {

	private static final ResourceLocation vampireEyesTexture = new ResourceLocation("gaia", "textures/models/eyes/Eyes_Vampire.png");
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Vampire.png");

	public RenderGaiaVampire() {
		super(new ModelGaiaVampire(), 0.5F);
		this.setRenderPassModel(new ModelGaiaVampire());
	}

	protected int shouldRenderPass(EntityGaiaVampire par1EntityGaiaVampire, int par2, float par3) {
		if (par1EntityGaiaVampire.isInvisible()) {
			return 0;
		} else if(par2 != 0) {
			return -1;
		} else {
			this.bindTexture(vampireEyesTexture);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			
            if (par1EntityGaiaVampire.isInvisible())
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
		return this.shouldRenderPass((EntityGaiaVampire)par1EntityLiving, par2, par3);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
