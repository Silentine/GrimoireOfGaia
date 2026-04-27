package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.BansheeModel;
import gaia.client.state.BansheeRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class BansheeGlowLayer extends EyesLayer<BansheeRenderState, BansheeModel> {
	private static final RenderType BANSHEE = RenderTypes.eyes(GrimoireOfGaia.modLoc("textures/entity/banshee/banshee.png"));

	public BansheeGlowLayer(RenderLayerParent<BansheeRenderState, BansheeModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return BANSHEE;
	}
}
