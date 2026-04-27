package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SludgeGirlModel;
import gaia.client.state.SludgeGirlRenderState;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class SludgeHairLayer extends RenderLayer<SludgeGirlRenderState, SludgeGirlModel> {
	public static final Identifier[] SLUDGE_GIRL_HAIR_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/sludge_girl/hair_sludge_girl01.png"),
			GrimoireOfGaia.modLoc("textures/entity/sludge_girl/hair_sludge_girl02.png"),
			GrimoireOfGaia.modLoc("textures/entity/sludge_girl/hair_sludge_girl03.png")};

	private final SludgeGirlModel model;

	public SludgeHairLayer(RenderLayerParent<SludgeGirlRenderState, SludgeGirlModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new SludgeGirlModel(modelSet.bakeLayer(ClientHandler.SLUDGE_GIRL));
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, SludgeGirlRenderState state, float yRot, float xRot) {
		boolean appearsGlowingWithInvisibility = state.appearsGlowing() && state.isInvisible;
		if (!state.isInvisible || appearsGlowingWithInvisibility) {
			int overlayCoords = LivingEntityRenderer.getOverlayCoords(state, 0.0F);
			if (appearsGlowingWithInvisibility) {
				submitNodeCollector.order(1)
						.submitModel(
								this.model, state, poseStack, RenderTypes.outline(this.getTextureLocation(state)), lightCoords, overlayCoords, state.outlineColor, null
						);
			} else {
				submitNodeCollector.order(1)
						.submitModel(
								this.model,
								state,
								poseStack,
								RenderTypes.entityTranslucent(this.getTextureLocation(state)),
								lightCoords,
								overlayCoords,
								state.outlineColor,
								null
						);
			}
		}
	}

	protected Identifier getTextureLocation(SludgeGirlRenderState state) {
		return SLUDGE_GIRL_HAIR_LOCATIONS[state.variant];
	}
}