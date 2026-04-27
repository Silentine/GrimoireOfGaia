package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.MinotaurModel;
import gaia.client.state.MinotaurRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class MinotaurEyesLayer extends EyesLayer<MinotaurRenderState, MinotaurModel> {
	private static final RenderType MINOTAUR_EYE_EYES = RenderTypes.eyes(GrimoireOfGaia.modLoc("textures/entity/minotaur/eyes_minotaur.png"));

	public MinotaurEyesLayer(RenderLayerParent<MinotaurRenderState, MinotaurModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return MINOTAUR_EYE_EYES;
	}
}