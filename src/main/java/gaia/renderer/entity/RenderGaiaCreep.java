package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaCreep;
import gaia.model.ModelGaiaCreep;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaCreep extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/creep.png");

	public RenderGaiaCreep(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaCreep(), shadowSize);
		addLayer(new LayerCreepCharge(this));
	}

	@Override
	protected void preRenderCallback(EntityLiving entitylivingbaseIn, float partialTickTime) {
		preRenderCallback((EntityGaiaCreep) entitylivingbaseIn, partialTickTime);
	}

	@Override
	protected int getColorMultiplier(EntityLiving entitylivingbaseIn, float lightBrightness, float partialTickTime) {
		return getColorMultiplier((EntityGaiaCreep) entitylivingbaseIn, lightBrightness, partialTickTime);
	}

	protected void preRenderCallback(EntityGaiaCreep entitylivingbaseIn, float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
		float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		f = f * f;
		f = f * f;
		float f2 = (1.0F + f * 0.4F) * f1;
		float f3 = (1.0F + f * 0.1F) / f1;
		GlStateManager.scalef(f2, f3, f2);
	}

	protected int getColorMultiplier(EntityGaiaCreep entitylivingbaseIn, float lightBrightness, float partialTickTime) {
		float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);

		if ((int) (f * 10.0F) % 2 == 0) {
			return 0;
		} else {
			int i = (int) (f * 0.2F * 255.0F);
			i = MathHelper.clamp(i, 0, 255);
			return i << 24 | 822083583;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}

	@OnlyIn(Dist.CLIENT)
	public static class LayerCreepCharge implements LayerRenderer<EntityGaiaCreep> {

		private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
		private final RenderGaiaCreep creeperRenderer;
		private final ModelGaiaCreep creeperModel = new ModelGaiaCreep();

		LayerCreepCharge(RenderGaiaCreep creeperRendererIn) {
			creeperRenderer = creeperRendererIn;
		}

		public void render(EntityGaiaCreep entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
			if (entitylivingbaseIn.getPowered()) {
				boolean flag = entitylivingbaseIn.isInvisible();
				GlStateManager.depthMask(!flag);
				creeperRenderer.bindTexture(LIGHTNING_TEXTURE);
				GlStateManager.matrixMode(5890);
				GlStateManager.loadIdentity();
				float f = (float) entitylivingbaseIn.ticksExisted + partialTicks;
				GlStateManager.translatef(f * 0.01F, f * 0.01F, 0.0F);
				GlStateManager.matrixMode(5888);
				GlStateManager.enableBlend();
				GlStateManager.color4f(0.5F, 0.5F, 0.5F, 1.0F);
				GlStateManager.disableLighting();
				GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
				creeperModel.setModelAttributes(creeperRenderer.getMainModel());
				creeperModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
				GlStateManager.matrixMode(5890);
				GlStateManager.loadIdentity();
				GlStateManager.matrixMode(5888);
				GlStateManager.enableLighting();
				GlStateManager.disableBlend();
				GlStateManager.depthMask(flag);
			}
		}

		public boolean shouldCombineTextures() {
			return false;
		}
	}
}
