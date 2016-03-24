package gaia.renderer;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaHarpy;
import gaia.model.ModelGaiaHarpy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaHarpy extends RenderLiving {

	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Harpy01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/Harpy02.png");
	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	
	public RenderGaiaHarpy( float shadowSize) {
        super(rend, new ModelGaiaHarpy(), shadowSize);
    }
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getTexture((EntityGaiaHarpy) entity);
	}

	protected ResourceLocation getTexture(EntityGaiaHarpy par1EntityGaiaHarpy) {
		switch(par1EntityGaiaHarpy.getTextureType()) {
		case 0: return texture01;
		case 1: return texture02;
		default: return texture01;
		}
	}
}
