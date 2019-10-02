package gaia.client.renderer.layers;

import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import gaia.client.model.ModelGaia;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;

public class GaiaGlowingLayer<T extends MobEntity, M extends ModelGaia<T>> extends LayerRenderer<T, M> {
	private final ResourceLocation GLOWING_TEXTURE;

	public GaiaGlowingLayer(IEntityRenderer<T, M> entityRenderer, ResourceLocation texture) {
		super(entityRenderer);
		this.GLOWING_TEXTURE = texture;
	}

	@Override
	public void render(T livingEntity, float limbswing, float limbswingamount, float partialticks, float ageinticks, float netheadyaw, float headpitch, float scale) {
		this.bindTexture(GLOWING_TEXTURE);

		GlStateManager.enableBlend();
		GlStateManager.blendFunc(1, 1);
		GlStateManager.disableLighting();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);

		if (livingEntity.isInvisible()) {
			GlStateManager.depthMask(false);
		} else {
			GlStateManager.depthMask(true);
		}

		int i = 61680;
		int j = i % 65536;
		int k = i / 65536;
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, (float)j, (float)k);

		GlStateManager.enableLighting();
		GlStateManager.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		getEntityModel().render(livingEntity, limbswing, limbswingamount, ageinticks, netheadyaw, headpitch, scale);

		func_215334_a(livingEntity);

		GlStateManager.depthMask(true);
		GlStateManager.disableBlend();
		GlStateManager.enableAlphaTest();
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
