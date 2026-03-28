package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.EnderGirlModel;
import gaia.client.state.EnderGirlRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class EnderGirlEyeLayer extends EyesLayer<EnderGirlRenderState, EnderGirlModel> {
	private static final RenderType ENDER_GIRL_EYES = RenderTypes.eyes(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/ender_girl/eyes_ender_girl.png"));

	public EnderGirlEyeLayer(RenderLayerParent<EnderGirlRenderState, EnderGirlModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return ENDER_GIRL_EYES;
	}
}
