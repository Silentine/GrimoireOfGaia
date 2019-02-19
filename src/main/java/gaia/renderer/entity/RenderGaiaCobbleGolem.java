package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCobbleGolem;
import gaia.model.ModelGaiaCobbleGolem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaCobbleGolem extends RenderLiving<EntityGaiaCobbleGolem> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/cobble_golem.png");

	public RenderGaiaCobbleGolem(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaCobbleGolem(), shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGaiaCobbleGolem entity) {
		return texture;
	}

	@Override
	protected void applyRotations(EntityGaiaCobbleGolem entityLiving, float rotationPitch, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, rotationPitch, rotationYaw, partialTicks);

		if ((double) entityLiving.limbSwingAmount >= 0.01D) {
			float f = 13.0F;
			float f1 = entityLiving.limbSwing - entityLiving.limbSwingAmount * (1.0F - partialTicks) + 6.0F;
			float f2 = (Math.abs(f1 % f - f * 0.5F) - f * 0.25F) / (f * 0.25F);
			GlStateManager.rotatef(6.5F * f2, 0.0F, 0.0F, 1.0F);
		}
	}
}
