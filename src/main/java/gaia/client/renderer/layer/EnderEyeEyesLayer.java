package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.EnderEyeModel;
import gaia.entity.EnderEye;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class EnderEyeEyesLayer extends EyesLayer<EnderEye, EnderEyeModel> {
	private static final RenderType ENDER_EYE_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_eye/eyes_ender_eye.png"));

	public EnderEyeEyesLayer(RenderLayerParent<EnderEye, EnderEyeModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return ENDER_EYE_EYES;
	}
}