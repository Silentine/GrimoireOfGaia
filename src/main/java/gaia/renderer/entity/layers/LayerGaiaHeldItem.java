package gaia.renderer.entity.layers;

import gaia.entity.monster.EntityGaiaAnt;
import gaia.entity.monster.EntityGaiaAnubis;
import gaia.entity.monster.EntityGaiaArachne;
import gaia.entity.monster.EntityGaiaDullahan;
import gaia.entity.monster.EntityGaiaDwarf;
import gaia.entity.monster.EntityGaiaGoblin;
import gaia.entity.monster.EntityGaiaGoblinFeral;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.entity.monster.EntityGaiaMermaid;
import gaia.entity.monster.EntityGaiaMinotaur;
import gaia.entity.monster.EntityGaiaNaga;
import gaia.entity.monster.EntityGaiaOrc;
import gaia.entity.monster.EntityGaiaValkyrie;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.entity.monster.EntityGaiaWitch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerGaiaHeldItem implements LayerRenderer<EntityLivingBase> {
	private ModelRenderer limb;
	private EntityEquipmentSlot slot;

	private final RenderLiving<EntityLiving> livingEntityRenderer;

	/**
	 * Render an Item model in an entities hand
	 *
	 * @param livingEntityRendererIn The entity holding the item
	 * @param limb                   The limb to render the item at
	 * @param slot                   The item to render, based on the equipment slot
	 */
	public LayerGaiaHeldItem(RenderLiving<EntityLiving> livingEntityRendererIn, ModelRenderer limb, EntityEquipmentSlot slot) {
		livingEntityRenderer = livingEntityRendererIn;
		this.limb = limb;
		this.slot = slot == EntityEquipmentSlot.MAINHAND || slot == EntityEquipmentSlot.OFFHAND ? slot : EntityEquipmentSlot.MAINHAND;
	}

	/**
	 * Shortcut for rendering items in a left arm, See parent for more options
	 */
	public static LayerGaiaHeldItem left(RenderLiving<EntityLiving> livingEntityRendererIn, ModelRenderer limb) {
		return new LayerGaiaHeldItem(livingEntityRendererIn, limb, EntityEquipmentSlot.OFFHAND);
	}

	/**
	 * Shortcut for rendering items in a Right arm, See parent for more options
	 */
	public static LayerGaiaHeldItem right(RenderLiving<EntityLiving> livingEntityRendererIn, ModelRenderer limb) {
		return new LayerGaiaHeldItem(livingEntityRendererIn, limb, EntityEquipmentSlot.MAINHAND);
	}

	@Override
	public void doRenderLayer(EntityLivingBase living, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ItemStack stack = living.getItemStackFromSlot(slot);

		GlStateManager.pushMatrix();

		if (livingEntityRenderer.getMainModel().isChild) {
			GlStateManager.translate(0.0F, 0.625F, 0.0F);
			GlStateManager.rotate(-20.0F, -1.0F, 0.0F, 0.0F);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
		}

		/**
		 * Used to manually adjust x, y, z coordinates.
		 * x = distance from hand (<0 = away from body, >0 = closer to body)
		 * y = distance from shoulder (>0 = further from shoulder, <0 = closer to shoulder)
		 * z = angle
		 */

		if (living instanceof EntityGaiaAnt) {
			GlStateManager.translate(0.0F, 0.08F, 0.0F);
		}

		if (living instanceof EntityGaiaAnubis) {
			GlStateManager.translate(0.0F, 0.08F, 0.0F);
		}

		if (living instanceof EntityGaiaArachne) {
			GlStateManager.translate(0.0F, -0.02F, 0.0F);
		}

		if (living instanceof EntityGaiaDullahan) {
			GlStateManager.translate(0.0F, -0.02F, 0.0F);
		}

		if (living instanceof EntityGaiaDwarf) {
			GlStateManager.translate(0.0F, -0.04F, 0.0F);
		}

		if (living instanceof EntityGaiaGoblin) {
			GlStateManager.translate(0.0F, -0.12F, 0.0F);
		}

		if (living instanceof EntityGaiaGoblinFeral) {
			GlStateManager.translate(0.0F, -0.12F, 0.0F);
		}

		if (living instanceof EntityGaiaKobold) {
			GlStateManager.translate(0.0F, 0.08F, 0.0F);
		}

		if (living instanceof EntityGaiaMermaid) {
			GlStateManager.translate(0.0F, 0.08F, 0.0F);
		}

		if (living instanceof EntityGaiaMinotaur) {
			GlStateManager.translate(0.0F, 0.2F, -0.01F);
			GlStateManager.rotate(12.0F, -1.0F, 0.0F, 0.0F);
		}

		if (living instanceof EntityGaiaOrc) {
			GlStateManager.translate(0.0F, 0.20F, 0.0F);
		}

		if (living instanceof EntityGaiaNaga) {
			GlStateManager.translate(0.04F, 0.25F, -0.02F);
			GlStateManager.rotate(12.0F, -1.0F, 0.0F, 0.0F);
		}

		if (living instanceof EntityGaiaValkyrie) {
			GlStateManager.translate(0.0F, 0.08F, 0.0F);
		}

		if (living instanceof EntityGaiaWerecat) {
			GlStateManager.translate(0.0F, 0.08F, 0.0F);
		}

		if (slot == EntityEquipmentSlot.MAINHAND) {
			renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
		} else {
			renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
		}

		GlStateManager.popMatrix();
	}

	private void renderHeldItem(EntityLivingBase living, ItemStack stack, ItemCameraTransforms.TransformType camera, EnumHandSide handSide) {
		if (!stack.isEmpty()) {
			GlStateManager.pushMatrix();

			if (living.isSneaking()) {
				GlStateManager.translate(0.0F, 0.2F, 0.0F);
			}

			limb.postRender(0.0625F);

			GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);

			boolean flag = handSide == EnumHandSide.LEFT;
			GlStateManager.translate((float) (flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);
			Minecraft.getMinecraft().getItemRenderer().renderItemSide(living, stack, camera, flag);
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}
