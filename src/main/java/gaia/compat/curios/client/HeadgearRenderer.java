package gaia.compat.curios.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

//TODO: Re-implement headgear rendering
public class HeadgearRenderer implements ICurioRenderer {
	@Override
	public <S extends LivingEntityRenderState, M extends EntityModel<? super S>> void render(ItemStack stack, SlotContext slotContext,
	                                                                                         PoseStack poseStack, SubmitNodeCollector submitNodeCollector,
	                                                                                         int packedLight, S renderState,
	                                                                                         RenderLayerParent<S, M> renderLayerParent,
	                                                                                         EntityRendererProvider.Context context,
	                                                                                         float yRotation, float xRotation) {
		if (slotContext.identifier().equals("head")) {
			if (!(renderLayerParent.getModel() instanceof HeadedModel headedModel)) {
				return;
			}
			poseStack.pushPose();

//			ICurioRenderer.followHeadRotations(slotContext.entity(), headedModel.getHead());
			headedModel.getHead().translateAndRotate(poseStack);

			poseStack.translate(0.0D, -0.25D, 0.0D);
			poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
			poseStack.scale(0.625F, -0.625F, -0.625F);

//			Minecraft.getInstance().getItemRenderer().renderStatic(stack, ItemDisplayContext.HEAD, light,
//					OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, Minecraft.getInstance().level, 0);
			poseStack.popPose();
		}
	}
}