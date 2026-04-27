package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.WerecatModel;
import gaia.client.state.WerecatRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class WerecatEyesLayer extends EyesLayer<WerecatRenderState, WerecatModel> {
	private static final RenderType WERECAT_EYES = RenderTypes.eyes(GrimoireOfGaia.modLoc("textures/entity/werecat/eyes_werecat.png"));

	public WerecatEyesLayer(RenderLayerParent<WerecatRenderState, WerecatModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return WERECAT_EYES;
	}
}