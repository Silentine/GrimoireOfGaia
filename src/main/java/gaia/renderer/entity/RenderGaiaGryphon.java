package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaGryphon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaGryphon extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/gryphon.png");
	private static final float SCALE_AMOUNT = 1.25F;

	public RenderGaiaGryphon(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaGryphon(), shadowSize);
	}

	@Override
	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
		GlStateManager.scalef(SCALE_AMOUNT, SCALE_AMOUNT, SCALE_AMOUNT);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
