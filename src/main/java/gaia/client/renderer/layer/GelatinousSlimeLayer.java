package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GelatinousSlimeModel;
import gaia.client.state.GelatinousSlimeRenderState;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class GelatinousSlimeLayer extends RenderLayer<GelatinousSlimeRenderState, GelatinousSlimeModel> {
	private static final Identifier SLIME_LAYER_LOCATION = GrimoireOfGaia.modLoc("textures/entity/gelatinous_slime/layer_gelatinous_slime.png");

	private final GelatinousSlimeModel model;

	public GelatinousSlimeLayer(RenderLayerParent<GelatinousSlimeRenderState, GelatinousSlimeModel> layerParent, EntityModelSet modelSet) {
		super(layerParent);
		this.model = new GelatinousSlimeModel(modelSet.bakeLayer(ClientHandler.GELATINOUS_SLIME));
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, GelatinousSlimeRenderState state, float yRot, float xRot) {
		boolean appearsGlowingWithInvisibility = state.appearsGlowing() && state.isInvisible;
		if (!state.isInvisible || appearsGlowingWithInvisibility) {
			int overlayCoords = LivingEntityRenderer.getOverlayCoords(state, 0.0F);
			if (appearsGlowingWithInvisibility) {
				submitNodeCollector.order(1)
						.submitModel(
								this.model, state, poseStack, RenderTypes.outline(SLIME_LAYER_LOCATION), lightCoords, overlayCoords, state.outlineColor, null
						);
			} else {
				submitNodeCollector.order(1)
						.submitModel(
								this.model,
								state,
								poseStack,
								RenderTypes.entityTranslucent(SLIME_LAYER_LOCATION),
								lightCoords,
								overlayCoords,
								state.outlineColor,
								null
						);
			}
		}
	}
}
