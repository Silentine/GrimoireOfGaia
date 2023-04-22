package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.model.MinotaurModel;
import gaia.entity.Minotaur;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class MinotaurEyesLayer extends EyesLayer<Minotaur, MinotaurModel> {
	private static final RenderType MINOTAUR_EYE_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/minotaur/eyes_minotaur.png"));

	public MinotaurEyesLayer(RenderLayerParent<Minotaur, MinotaurModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, Minotaur minotaur,
					   float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		super.render(poseStack, bufferSource, packedLightIn, minotaur, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);

	}

	public RenderType renderType() {
		return MINOTAUR_EYE_EYES;
	}
}