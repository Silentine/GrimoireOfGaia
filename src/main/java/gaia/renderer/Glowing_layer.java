package gaia.renderer;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class Glowing_layer implements LayerRenderer<EntityLiving> {
	private final ResourceLocation glowing_texture;
	private final RenderLiving livingEntityRenderer;

	public Glowing_layer(RenderLiving livingEntityRendererIn, ResourceLocation textureIn) {
		this.livingEntityRenderer = livingEntityRendererIn;
		this.glowing_texture = textureIn;
	}

	public void doRenderLayer(EntityLiving entity, float f1, float f2, float partialTicks, float f4, float f5, float f6, float scale) {
		this.livingEntityRenderer.bindTexture(glowing_texture);
		GlStateManager.enableBlend();
		//GlStateManager.disableAlpha();
		GlStateManager.blendFunc(1, 1);
		GlStateManager.disableLighting();
		GlStateManager.depthMask(!entity.isInvisible());
		int i = 61680;
		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		GlStateManager.enableLighting();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.livingEntityRenderer.getMainModel().render(entity, f1, f2, f4, f5, f6, scale);
		this.livingEntityRenderer.setLightmap(entity, partialTicks);
		GlStateManager.depthMask(true);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
	}

	public boolean shouldCombineTextures() {
		return true;
	}
}