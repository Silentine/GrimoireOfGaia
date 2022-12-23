package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import gaia.client.model.GelatinousSlimeModel;
import gaia.entity.GelatinousSlime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;

public class SlimeItemLayer extends RenderLayer<GelatinousSlime, GelatinousSlimeModel> {

	public SlimeItemLayer(RenderLayerParent<GelatinousSlime, GelatinousSlimeModel> layerParent) {
		super(layerParent);
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, GelatinousSlime gelatinousSlime,
					   float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (gelatinousSlime.isAlive() && !gelatinousSlime.isInvisible()) {
			ItemStack stack = gelatinousSlime.getOffhandItem();
			if (!stack.isEmpty()) {
				if (!stack.isEmpty()) {
					poseStack.pushPose();
					this.getParentModel().translateToHand(HumanoidArm.LEFT, poseStack);
					poseStack.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
					poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
					poseStack.translate((double) ((float) (-1) / 16.0F), 0.125D, -0.625D);
					Minecraft.getInstance()
							.getItemRenderer()
							.renderStatic(stack, ItemTransforms.TransformType.GROUND, packedLightIn, OverlayTexture.NO_OVERLAY,
									poseStack, bufferSource, (int) gelatinousSlime.blockPosition()
											.asLong());
					poseStack.popPose();
				}
			}
		}
	}
}
