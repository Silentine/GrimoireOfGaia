package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMinotaurus;
import gaia.model.ModelGaiaMinotaurus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaMinotaurus extends RenderLiving {

	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Minotaurus01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Minotaurus02.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaMinotaurus( float shadowSize) {
        super(rend, new ModelGaiaMinotaurus(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaMinotaurus.rightarm));
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getTexture((EntityGaiaMinotaurus) entity);
	}
	
	protected ResourceLocation getTexture(EntityGaiaMinotaurus par1EntityGaiaMinotaurus) {
		switch(par1EntityGaiaMinotaurus.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
