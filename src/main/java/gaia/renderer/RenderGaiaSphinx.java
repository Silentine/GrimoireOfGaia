package gaia.renderer;

import gaia.entity.monster.EntityGaiaSphinx;
import gaia.model.ModelGaiaSphinx;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSphinx extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Sphinx.png");

	public RenderGaiaSphinx() {
		super(new ModelGaiaSphinx(), 0.5F);
		this.setRenderPassModel(new ModelGaiaSphinx());
	}

	protected void scaleSphinx(EntityGaiaSphinx par1EntityGaiaSphinx, float par2) {
		float f1 = par1EntityGaiaSphinx.SphinxScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleSphinx((EntityGaiaSphinx)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
