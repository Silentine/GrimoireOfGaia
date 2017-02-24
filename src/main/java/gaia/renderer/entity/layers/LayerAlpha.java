package gaia.renderer.entity.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class LayerAlpha implements LayerRenderer<EntityLiving> {
	ResourceLocation alpha_texture;
	RenderLiving livingEntityRenderer;

	public LayerAlpha(RenderLiving livingEntityRendererIn, ResourceLocation textureIn) {
		this.livingEntityRenderer = livingEntityRendererIn;
		this.alpha_texture = textureIn;
	}

	public void doRenderLayer(EntityLiving entity, float f1, float f2, float partialTicks, float f4, float f5, float f6, float scale) {
		this.livingEntityRenderer.bindTexture(alpha_texture);

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableNormalize();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 771);
		this.livingEntityRenderer.getMainModel().render(entity, f1, f2, f4, f5, f6, scale);
		this.livingEntityRenderer.setLightmap(entity, partialTicks);
		GlStateManager.disableBlend();
		GlStateManager.disableNormalize();
	}

	public boolean shouldCombineTextures() {
		return true;
	}
}