package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaGryphon;
import gaia.model.ModelGaiaGryphon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaGryphon extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Gryphon.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaGryphon(float shadowSize) {
        super(rend, new ModelGaiaGryphon(), shadowSize);
		//this.setRenderPassModel(new ModelGaiaGryphon());
	}

	protected void scaleGryphon(EntityGaiaGryphon par1EntityGaiaGryphon, float par2) {
		float f1 = par1EntityGaiaGryphon.GryphonScaleAmount();
		GL11.glScalef(f1, f1, f1);
	}

	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
		this.scaleGryphon((EntityGaiaGryphon)par1EntityLiving, par2);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
