package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SlimeGirlModel;
import gaia.client.state.SlimeGirlRenderState;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class SlimeGirlHairLayer extends RenderLayer<SlimeGirlRenderState, SlimeGirlModel> {
	private static final Identifier HAIR_LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/slime_girl/hair_slime_girl.png");

	private final SlimeGirlModel model;

	public SlimeGirlHairLayer(RenderLayerParent<SlimeGirlRenderState, SlimeGirlModel> layerParent, EntityModelSet modelSet) {
		super(layerParent);
		this.model = new SlimeGirlModel(modelSet.bakeLayer(ClientHandler.SLIME_GIRL));
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, SlimeGirlRenderState state, float yRot, float xRot) {
		boolean appearsGlowingWithInvisibility = state.appearsGlowing() && state.isInvisible;
		if (!state.isInvisible || appearsGlowingWithInvisibility) {
			int overlayCoords = LivingEntityRenderer.getOverlayCoords(state, 0.0F);
			if (appearsGlowingWithInvisibility) {
				submitNodeCollector.order(1)
						.submitModel(
								this.model, state, poseStack, RenderTypes.outline(HAIR_LOCATION), lightCoords, overlayCoords, state.outlineColor, null
						);
			} else {
				submitNodeCollector.order(1)
						.submitModel(
								this.model,
								state,
								poseStack,
								RenderTypes.entityTranslucent(HAIR_LOCATION),
								lightCoords,
								overlayCoords,
								state.outlineColor,
								null
						);
			}
		}
	}
}
