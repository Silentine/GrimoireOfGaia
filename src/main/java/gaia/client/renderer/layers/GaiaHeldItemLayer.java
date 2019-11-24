package gaia.client.renderer.layers;

import com.mojang.blaze3d.platform.GlStateManager;
import gaia.entity.assist.GaiaDwarfEntity;
import gaia.entity.assist.GaiaGoblinEntity;
import gaia.entity.hostile.GaiaAntEntity;
import gaia.entity.hostile.GaiaAnubisEntity;
import gaia.entity.hostile.GaiaArachneEntity;
import gaia.entity.hostile.GaiaDullahanEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;

public class GaiaHeldItemLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private RendererModel limb;
    private EquipmentSlotType slot;

    public GaiaHeldItemLayer(IEntityRenderer<T, M> entityRenderer, RendererModel limb, EquipmentSlotType slot) {
        super(entityRenderer);
        this.limb = limb;
        this.slot = slot == EquipmentSlotType.MAINHAND || slot == EquipmentSlotType.OFFHAND ? slot : EquipmentSlotType.MAINHAND;
    }

    /**
     * Shortcut for rendering items in a left arm, See parent for more options
     */
    public GaiaHeldItemLayer left(IEntityRenderer<T, M> entityRenderer, RendererModel limb) {
        return new GaiaHeldItemLayer(entityRenderer, limb, EquipmentSlotType.OFFHAND);
    }

    /**
     * Shortcut for rendering items in a Right arm, See parent for more options
     */
    public GaiaHeldItemLayer right(IEntityRenderer<T, M> entityRenderer, RendererModel limb) {
        return new GaiaHeldItemLayer(entityRenderer, limb, EquipmentSlotType.MAINHAND);
    }

    @Override
    public void render(T living, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ItemStack stack = living.getItemStackFromSlot(slot);
        GlStateManager.pushMatrix();

        if (this.getEntityModel().isChild) {
            GlStateManager.translatef(0.0F, 0.625F, 0.0F);
            GlStateManager.rotatef(-20.0F, -1.0F, 0.0F, 0.0F);
            GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        }

        /**
         * Used to manually adjust x, y, z coordinates.
         * x = distance from hand (<0 = away from body, >0 = closer to body)
         * y = distance from shoulder (>0 = further from shoulder, <0 = closer to shoulder)
         * z = angle
         */

        if (living instanceof GaiaAntEntity) {
            GlStateManager.translatef(0.0F, 0.08F, 0.0F);
        }

        if (living instanceof GaiaAnubisEntity) {
            GlStateManager.translatef(0.0F, 0.08F, 0.0F);
        }

        if (living instanceof GaiaArachneEntity) {
            GlStateManager.translatef(0.0F, -0.02F, 0.0F);
        }

        if (living instanceof GaiaDullahanEntity) {
            GlStateManager.translatef(0.0F, -0.02F, 0.0F);
        }

        if (living instanceof GaiaDwarfEntity) {
            GlStateManager.translatef(0.0F, -0.04F, 0.0F);
        }

        if (living instanceof GaiaGoblinEntity) {
            GlStateManager.translatef(0.0F, -0.12F, 0.0F);
        }
//
//        if (living instanceof EntityGaiaGoblinFeral) {
//            GlStateManager.translatef(0.0F, -0.12F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaKobold) {
//            GlStateManager.translatef(0.0F, 0.08F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaMermaid) {
//            GlStateManager.translatef(0.0F, 0.08F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaMinotaur) {
//            GlStateManager.translatef(0.0F, 0.2F, -0.01F);
//            GlStateManager.rotatef(12.0F, -1.0F, 0.0F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaOrc) {
//            GlStateManager.translatef(0.0F, 0.20F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaNaga) {
//            GlStateManager.translatef(0.04F, 0.25F, -0.02F);
//            GlStateManager.rotatef(12.0F, -1.0F, 0.0F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaValkyrie) {
//            GlStateManager.translatef(0.0F, 0.08F, 0.0F);
//        }
//
//        if (living instanceof EntityGaiaWerecat) {
//            GlStateManager.translatef(0.0F, 0.08F, 0.0F);
//        } TODO: Reimplement other mob translations

        if (slot == EquipmentSlotType.MAINHAND) {
            renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HandSide.RIGHT);
        } else {
            renderHeldItem(living, stack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HandSide.LEFT);
        }

        GlStateManager.popMatrix();
    }

    private void renderHeldItem(LivingEntity living, ItemStack stack, ItemCameraTransforms.TransformType camera, HandSide handSide) {
        if (!stack.isEmpty()) {
            GlStateManager.pushMatrix();
            if (living.shouldRenderSneaking()) {
                GlStateManager.translatef(0.0F, 0.2F, 0.0F);
            }

            limb.postRender(0.0625F);

            GlStateManager.rotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);

            boolean flag = handSide == HandSide.LEFT;
            GlStateManager.translatef((float)(flag ? -1 : 1) / 16.0F, 0.125F, -0.625F);

            Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(living, stack, camera, flag);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
