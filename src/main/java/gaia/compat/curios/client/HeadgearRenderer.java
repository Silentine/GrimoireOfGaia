package gaia.compat.curios.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

//TODO: Re-implement headgear rendering
public class HeadgearRenderer implements ICurioRenderer {
	public ItemModelResolver itemModelResolver;
	public final ItemStackRenderState headItem = new ItemStackRenderState();

	@Override
	public <S extends LivingEntityRenderState, M extends EntityModel<? super S>> void render(ItemStack stack, SlotContext slotContext,
	                                                                                         PoseStack poseStack, SubmitNodeCollector submitNodeCollector,
	                                                                                         int lightCoords, S renderState,
	                                                                                         RenderLayerParent<S, M> renderLayerParent,
	                                                                                         EntityRendererProvider.Context context,
	                                                                                         float yRotation, float xRotation) {
		if (slotContext.identifier().equals("head")) {
			if (!(renderLayerParent.getModel() instanceof HeadedModel headedModel)) {
				return;
			}
			if (itemModelResolver == null) {
				this.itemModelResolver = context.getItemModelResolver();
			}
			this.itemModelResolver.updateForLiving(headItem, stack, ItemDisplayContext.HEAD, slotContext.entity());

			poseStack.pushPose();

			headedModel.getHead().translateAndRotate(poseStack);

			poseStack.translate(0.0D, -0.25D, 0.0D);
			poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
			poseStack.scale(0.625F, -0.625F, -0.625F);

			headItem.submit(poseStack, submitNodeCollector, lightCoords, OverlayTexture.NO_OVERLAY, -1);
			poseStack.popPose();
		}
	}
}