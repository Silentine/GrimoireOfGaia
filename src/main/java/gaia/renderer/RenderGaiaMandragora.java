package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.model.ModelGaiaMandragora;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderGaiaMandragora extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Mandragora.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaMandragora( float shadowSize) {
        super(rend, new ModelGaiaMandragora(), shadowSize);
	}

	protected void scaleMandragora(EntityGaiaMandragora par1EntityGaiaMandragora, float par2) {
		float f1 = par1EntityGaiaMandragora.MandragoraScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLiving, float par2) {
		this.scaleMandragora((EntityGaiaMandragora)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
