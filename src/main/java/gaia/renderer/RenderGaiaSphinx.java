package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.entity.monster.EntityGaiaSphinx;
import gaia.model.ModelGaiaSphinx;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSphinx extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Sphinx.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSphinx( float shadowSize) {
        super(rend, new ModelGaiaSphinx(), shadowSize);
		//this.setRenderPassModel(new ModelGaiaSphinx());
	}

	protected void scaleSphinx(EntityGaiaSphinx sphinx, float par2) {
		float f1 = sphinx.SphinxScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleSphinx((EntityGaiaSphinx)par1EntityLiving, par2);
	}
	
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
