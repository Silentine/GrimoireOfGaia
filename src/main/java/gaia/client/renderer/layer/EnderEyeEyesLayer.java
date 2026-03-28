package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.EnderEyeModel;
import gaia.client.state.EnderEyeRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class EnderEyeEyesLayer extends EyesLayer<EnderEyeRenderState, EnderEyeModel> {
	private static final RenderType ENDER_EYE_EYES = RenderTypes.eyes(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/ender_eye/eyes_ender_eye.png"));

	public EnderEyeEyesLayer(RenderLayerParent<EnderEyeRenderState, EnderEyeModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return ENDER_EYE_EYES;
	}
}