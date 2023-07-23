package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class GaiaItemInHandLayer<T extends LivingEntity, M extends EntityModel<T> & ArmedModel> extends RenderLayer<T, M> {
	private final HumanoidArm humanoidArm;
	private final ItemInHandRenderer renderer;

	public GaiaItemInHandLayer(RenderLayerParent<T, M> renderLayerParent, HumanoidArm hand, ItemInHandRenderer renderer) {
		super(renderLayerParent);
		this.humanoidArm = hand;
		this.renderer = renderer;
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T livingEntity, float limbSwing,
					   float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean rightHanded = this.humanoidArm == HumanoidArm.RIGHT;
		ItemStack heldStack = rightHanded ? livingEntity.getMainHandItem() : livingEntity.getOffhandItem();
		if (!heldStack.isEmpty()) {
			poseStack.pushPose();
			if (this.getParentModel().young) {
				float f = 0.5F;
				poseStack.translate(0.0D, 0.75D, 0.0D);
				poseStack.scale(0.5F, 0.5F, 0.5F);
			}

			this.renderArmWithItem(livingEntity, heldStack,
					rightHanded ? ItemDisplayContext.THIRD_PERSON_RIGHT_HAND : ItemDisplayContext.THIRD_PERSON_LEFT_HAND,
					poseStack, bufferSource, packedLight);
			poseStack.popPose();
		}
	}

	protected void renderArmWithItem(LivingEntity livingEntity, ItemStack stack, ItemDisplayContext transformType,
									 PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
		if (!stack.isEmpty()) {
			poseStack.pushPose();
			this.getParentModel().translateToHand(humanoidArm, poseStack);
			poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
			poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
			boolean flag = humanoidArm == HumanoidArm.LEFT;
			poseStack.translate((double) ((float) (flag ? -1 : 1) / 16.0F), 0.125D, -0.625D);
			renderer.renderItem(livingEntity, stack, transformType, flag, poseStack, bufferSource, packedLight);
			poseStack.popPose();
		}
	}
}