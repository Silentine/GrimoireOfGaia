package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.EnderDragonGirlModel;
import gaia.client.state.EnderDragonGirlRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class EnderDragonGirlEyesLayer extends EyesLayer<EnderDragonGirlRenderState, EnderDragonGirlModel> {
	private static final RenderType ENDER_DRAGON_GIRL_EYES = RenderTypes.eyes(Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/ender_dragon_girl/eyes_ender_dragon_girl.png"));

	public EnderDragonGirlEyesLayer(RenderLayerParent<EnderDragonGirlRenderState, EnderDragonGirlModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return ENDER_DRAGON_GIRL_EYES;
	}
}