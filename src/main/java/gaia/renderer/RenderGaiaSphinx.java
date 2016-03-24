package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSphinx;
import gaia.model.ModelGaiaSphinx;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSphinx extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Sphinx.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSphinx( float shadowSize) {
        super(rend, new ModelGaiaSphinx(), shadowSize);
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
