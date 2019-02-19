package gaia.renderer.entity.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Used to render items inserted into the HEAD slot of Baubles
 */
@SuppressWarnings("deprecation")
@OnlyIn(Dist.CLIENT)
public class LayerHeadgear implements LayerRenderer<EntityPlayer> {
	private ModelRenderer bipedHead;

	public LayerHeadgear(ModelRenderer bipedHead) {
		this.bipedHead = bipedHead;
	}

	@Override
	public void render(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack headgear = getHeadgear(player);

		if (!headgear.isEmpty()) {
			GlStateManager.pushMatrix();

			if (player.isSneaking()) {
				GlStateManager.translatef(0.0F, 0.2F, 0.0F);
			}

			bipedHead.postRender(0.0625F);
			GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);

			GlStateManager.translatef(0.0F, -0.25F, 0.0F);
			GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.scalef(0.625F, -0.625F, -0.625F);

			Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(player, headgear, ItemCameraTransforms.TransformType.HEAD, false);
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	/** Baubles **/
	private ItemStack getHeadgear(EntityPlayer entity) {
//		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(entity);

//		for (int i = 0; i < baubles.getSlots(); i++) {
//			ItemStack bauble = baubles.getStackInSlot(i);
//			if (bauble.isEmpty() || bauble.getItem() != GaiaItems.ACCESSORY_HEADGEAR)
//				continue;
//
//			return bauble;
//		}
		return ItemStack.EMPTY;
	}
}
