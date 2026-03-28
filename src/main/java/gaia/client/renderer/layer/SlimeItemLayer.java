package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import gaia.client.model.GelatinousSlimeModel;
import gaia.client.state.GelatinousSlimeRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

public class SlimeItemLayer extends RenderLayer<GelatinousSlimeRenderState, GelatinousSlimeModel> {

	public SlimeItemLayer(RenderLayerParent<GelatinousSlimeRenderState, GelatinousSlimeModel> layerParent) {
		super(layerParent);
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, GelatinousSlimeRenderState state, float yRot, float xRot) {
		if (!state.isInvisible) {
			ItemStackRenderState stackRenderState = state.mainItemRenderState;
			if (stackRenderState != null) {
				poseStack.pushPose();

				this.getParentModel().translateToHand(state, HumanoidArm.LEFT, poseStack);

				poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
				poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
				poseStack.translate((double) ((float) (-1) / 16.0F), 0.125D, -0.625D);

				stackRenderState.submit(poseStack, submitNodeCollector, state.lightCoords,
						OverlayTexture.NO_OVERLAY, state.outlineColor);

				poseStack.popPose();
			}
		}
	}
}
