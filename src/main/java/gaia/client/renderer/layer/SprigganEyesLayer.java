package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.SprigganModel;
import gaia.client.state.SprigganRenderState;
import gaia.entity.Spriggan;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class SprigganEyesLayer extends EyesLayer<SprigganRenderState, SprigganModel> {
	private static final RenderType SPRIGGAN_EYES = RenderTypes.eyes(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/spriggan/eyes_spriggan.png"));

	public SprigganEyesLayer(RenderLayerParent<SprigganRenderState, SprigganModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return SPRIGGAN_EYES;
	}
}