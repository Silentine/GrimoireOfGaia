package gaia.renderer.entity.layers;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import gaia.init.GaiaItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Used to render items inserted into the HEAD slot of Baubles
 */
@SideOnly(Side.CLIENT)
public class LayerHeadgear implements LayerRenderer<EntityPlayer> {
	private ModelRenderer bipedHead;

	public LayerHeadgear(ModelRenderer bipedHead) {
		this.bipedHead = bipedHead;
	}

	@Override
	public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack headgear = getHeadgear(player);

		if (!headgear.isEmpty()) {
			GlStateManager.pushMatrix();

			if (player.isSneaking()) {
				GlStateManager.translate(0.0F, 0.2F, 0.0F);
			}

			bipedHead.postRender(0.0625F);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

			GlStateManager.translate(0.0F, -0.25F, 0.0F);
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.scale(0.625F, -0.625F, -0.625F);

			Minecraft.getMinecraft().getItemRenderer().renderItem(player, headgear, ItemCameraTransforms.TransformType.HEAD);
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

	/** Baubles **/
	private ItemStack getHeadgear(EntityPlayer entity) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(entity);

		for (int i = 0; i < baubles.getSlots(); i++) {
			ItemStack bauble = baubles.getStackInSlot(i);
			if (bauble.isEmpty() || bauble.getItem() != GaiaItems.ACCESSORY_HEADGEAR)
				continue;

			return bauble;
		}
		return ItemStack.EMPTY;
	}
}
