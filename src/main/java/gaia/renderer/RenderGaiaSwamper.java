package gaia.renderer;

import gaia.entity.monster.EntityGaiaSwamper;
import gaia.model.ModelGaiaSwamper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSwamper extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation("gaia", "textures/models/Swamper.png");

	public RenderGaiaSwamper() {
		super(new ModelGaiaSwamper(), 0.5F);
		this.setRenderPassModel(new ModelGaiaSwamper());
	}

	protected void scaleSwamper(EntityGaiaSwamper par1EntityGaiaSwamper, float par2) {
		float f1 = par1EntityGaiaSwamper.SwamperScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleSwamper((EntityGaiaSwamper)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
