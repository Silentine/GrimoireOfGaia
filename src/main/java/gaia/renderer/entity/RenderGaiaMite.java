package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaMite;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaMite extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/mite.png");
	private static final float SCALE_AMOUNT = 1.0F;

	public RenderGaiaMite(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaMite(), shadowSize);
	}

	@Override
	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
		GlStateManager.scale(SCALE_AMOUNT, SCALE_AMOUNT, SCALE_AMOUNT);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
