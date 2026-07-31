package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.BehenderModel;
import gaia.client.state.BehenderRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;

public class BehenderEyesLayer extends EyesLayer<BehenderRenderState, BehenderModel> {
	private static final RenderType BEHENDER_EYE_EYES = RenderTypes.eyes(GrimoireOfGaia.modLoc("textures/entity/behender/eyes_beholder.png"));

	public BehenderEyesLayer(RenderLayerParent<BehenderRenderState, BehenderModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return BEHENDER_EYE_EYES;
	}
}