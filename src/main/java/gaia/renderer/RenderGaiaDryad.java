package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaDryad;
import gaia.model.ModelGaiaDryad;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class RenderGaiaDryad extends RenderLiving<EntityGaiaDryad> {

	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Dryad01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Dryad02.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaDryad( float shadowSize) {
        super(rend, new ModelGaiaDryad(), shadowSize);
        this.addLayer(GaiaHeldItem.Right(this, ModelGaiaDryad.rightarm));
    }

	protected void func_82422_c() {
		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGaiaDryad entity) {
		return this.getTexture((EntityGaiaDryad) entity);
	}

	protected ResourceLocation getTexture(EntityGaiaDryad par1EntityGaiaDryad) {
		switch(par1EntityGaiaDryad.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
