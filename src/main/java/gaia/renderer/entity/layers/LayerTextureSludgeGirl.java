package gaia.renderer.entity.layers;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.renderer.entity.RenderGaiaSludgeGirl;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerLlamaDecor;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see LayerLlamaDecor
 */
@SideOnly(Side.CLIENT)
public class LayerTextureSludgeGirl implements LayerRenderer<EntityGaiaSludgeGirl> {

	private static final ResourceLocation hairSludgeGirl[] = new ResourceLocation[] { new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/hair_sludge_girl01.png"), new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/hair_sludge_girl02.png"), new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/hair_sludge_girl03.png") };

	private final RenderGaiaSludgeGirl sludgeGirlRenderer;

	public LayerTextureSludgeGirl(RenderGaiaSludgeGirl sludgeGirlRendererIn) {
		sludgeGirlRenderer = sludgeGirlRendererIn;
	}

	public void doRenderLayer(EntityGaiaSludgeGirl entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		sludgeGirlRenderer.bindTexture(hairSludgeGirl[entitylivingbaseIn.getTextureType()]);

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
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