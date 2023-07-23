package gaia.compat.curios.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class HeadgearRenderer implements ICurioRenderer {

	@Override
	public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext,
																		  PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent,
																		  MultiBufferSource multiBufferSource, int light, float limbSwing,
																		  float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		if (slotContext.identifier().equals("head")) {
			if (!(renderLayerParent.getModel() instanceof HeadedModel headedModel)) {
				return;
			}
			poseStack.pushPose();

			ICurioRenderer.followHeadRotations(slotContext.entity(), headedModel.getHead());
			headedModel.getHead().translateAndRotate(poseStack);

			poseStack.translate(0.0D, -0.25D, 0.0D);
			poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
			poseStack.scale(0.625F, -0.625F, -0.625F);

			Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.HEAD, light,
					OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, Minecraft.getInstance().level, 0);
			poseStack.popPose();
		}
	}
}