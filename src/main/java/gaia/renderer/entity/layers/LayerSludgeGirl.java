package gaia.renderer.entity.layers;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.renderer.entity.RenderGaiaSludgeGirl;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerLlamaDecor;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * @see LayerLlamaDecor
 */
@OnlyIn(Dist.CLIENT)
public class LayerSludgeGirl implements LayerRenderer<EntityGaiaSludgeGirl> {

	private static final ResourceLocation hairSludgeGirl[] = new ResourceLocation[] { new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_sludge_girl01.png"), new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/hair_sludge_girl02.png") };

	private final RenderGaiaSludgeGirl sludgeGirlRenderer;

	public LayerSludgeGirl(RenderGaiaSludgeGirl sludgeGirlRendererIn) {
		sludgeGirlRenderer = sludgeGirlRendererIn;
	}

	public void render(EntityGaiaSludgeGirl entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		sludgeGirlRenderer.bindTexture(hairSludgeGirl[entitylivingbaseIn.getTextureType()]);

		GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableNormalize();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(770, 771);

		sludgeGirlRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		sludgeGirlRenderer.setLightmap(entitylivingbaseIn);

		GlStateManager.disableBlend();
		GlStateManager.disableNormalize();
	}

	public boolean shouldCombineTextures() {
		return true;
	}
}