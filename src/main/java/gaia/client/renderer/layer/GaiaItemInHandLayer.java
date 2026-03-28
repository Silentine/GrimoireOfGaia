package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

public class GaiaItemInHandLayer<T extends ArmedEntityRenderState, M extends EntityModel<T> & ArmedModel> extends RenderLayer<T, M> {
	private final HumanoidArm humanoidArm;

	public GaiaItemInHandLayer(RenderLayerParent<T, M> renderLayerParent, HumanoidArm hand) {
		super(renderLayerParent);
		this.humanoidArm = hand;
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int lightCoords, T state, float yRot, float xRot) {
		boolean rightHanded = this.humanoidArm == HumanoidArm.RIGHT;
		ItemStackRenderState heldStack = rightHanded ? state.rightHandItemState : state.leftHandItemState;
		if (!heldStack.isEmpty()) {
			poseStack.pushPose();
			if (state.isBaby) {
				poseStack.translate(0.0D, 0.75D, 0.0D);
				poseStack.scale(0.5F, 0.5F, 0.5F);
			}

			this.renderArmWithItem(state, heldStack, poseStack, submitNodeCollector);
			poseStack.popPose();
		}
	}

	protected void renderArmWithItem(T state, ItemStackRenderState stackRenderState, PoseStack poseStack, SubmitNodeCollector nodeCollector) {
		if (stackRenderState != null) {
			poseStack.pushPose();
			this.getParentModel().translateToHand(state, humanoidArm, poseStack);
			poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
			poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
			boolean flag = humanoidArm == HumanoidArm.LEFT;
			poseStack.translate((double) ((float) (flag ? -1 : 1) / 16.0F), 0.125D, -0.625D);
			stackRenderState.submit(poseStack, nodeCollector, state.lightCoords, OverlayTexture.NO_OVERLAY, state.outlineColor);
			poseStack.popPose();
		}
	}
}