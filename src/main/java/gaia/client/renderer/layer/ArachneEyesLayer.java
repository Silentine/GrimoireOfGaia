package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.ArachneModel;
import gaia.client.state.ArachneRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class ArachneEyesLayer extends EyesLayer<ArachneRenderState, ArachneModel> {
	private static final RenderType ARACHNE_EYES = RenderTypes.eyes(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/arachne/arachne_eyes.png"));

	public ArachneEyesLayer(RenderLayerParent<ArachneRenderState, ArachneModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return ARACHNE_EYES;
	}
}
