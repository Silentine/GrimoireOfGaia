package gaia.renderer;

import org.lwjgl.opengl.GL11;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSelkie;
import gaia.model.ModelGaiaSelkie;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaSelkie extends RenderLiving {
	
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Selkie01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Selkie02.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaSelkie( float shadowSize) {
        super(rend, new ModelGaiaSelkie(), shadowSize);
        this.addLayer(new held_rightarm(this, ModelGaiaSelkie.rightarm));
	}

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getTexture((EntityGaiaSelkie) entity);
	}
	
	protected ResourceLocation getTexture(EntityGaiaSelkie par1EntityGaiaSelkie) {
		switch(par1EntityGaiaSelkie.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
