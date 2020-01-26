package gaia.renderer.entity.layers;

import gaia.GaiaReference;
import gaia.entity.passive.EntityGaiaNPCWeresheep;
import gaia.renderer.entity.RenderGaiaNPCWeresheep;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see LayerWolfCollar
 */
@SideOnly(Side.CLIENT)
public class LayerColorWeresheep implements LayerRenderer<EntityGaiaNPCWeresheep> {
	private static final ResourceLocation COLOR = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/skin_weresheep.png");
	private final RenderGaiaNPCWeresheep entityRenderer;

	public LayerColorWeresheep(RenderGaiaNPCWeresheep entityRendererIn) {
		this.entityRenderer = entityRendererIn;
	}

	public void doRenderLayer(EntityGaiaNPCWeresheep entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (!entitylivingbaseIn.isInvisible()) {
			this.entityRenderer.bindTexture(COLOR);
			float[] afloat = entitylivingbaseIn.getDyeColor().getColorComponentValues();
			GlStateManager.color(afloat[0], afloat[1], afloat[2]);
			this.entityRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		}
	}

	public boolean shouldCombineTextures() {
		return true;
	}
}