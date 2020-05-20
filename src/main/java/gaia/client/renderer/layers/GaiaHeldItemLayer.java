package gaia.client.renderer.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import gaia.entity.assist.GaiaDwarfEntity;
import gaia.entity.assist.GaiaGoblinEntity;
import gaia.entity.assist.GaiaGoblinFeralEntity;
import gaia.entity.hostile.GaiaAntEntity;
import gaia.entity.hostile.GaiaAnubisEntity;
import gaia.entity.hostile.GaiaArachneEntity;
import gaia.entity.hostile.GaiaDullahanEntity;
import gaia.entity.hostile.GaiaKoboldEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;

@SuppressWarnings("deprecation")
public class GaiaHeldItemLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private ModelRenderer limb;
    private EquipmentSlotType slot;

    public GaiaHeldItemLayer(IEntityRenderer<T, M> entityRenderer, ModelRenderer limb, EquipmentSlotType slot) {
        super(entityRenderer);
        this.limb = limb;
        this.slot = slot == EquipmentSlotType.MAINHAND || slot == EquipmentSlotType.OFFHAND ? slot : EquipmentSlotType.MAINHAND;
    }

    /**
     * Shortcut for rendering items in a left arm, See parent for more options
     */
    public GaiaHeldItemLayer left(IEntityRenderer<T, M> entityRenderer, ModelRenderer limb) {
        return new GaiaHeldItemLayer(entityRenderer, limb, EquipmentSlotType.OFFHAND);
    }

    /**
     * Shortcut for rendering items in a Right arm, See parent for more options
     */
    public GaiaHeldItemLayer right(IEntityRenderer<T, M> entityRenderer, ModelRenderer limb) {
        return new GaiaHeldItemLayer(entityRenderer, limb, EquipmentSlotType.MAINHAND);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T livingEntityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        boolean flag = livingEntityIn.getPrimaryHand() == HandSide.RIGHT;
        ItemStack itemstack = flag ? livingEntityIn.getHeldItemOffhand() : livingEntityIn.getHeldItemMainhand();
        ItemStack itemstack1 = flag ? livingEntityIn.getHeldItemMainhand() : livingEntityIn.getHeldItemOffhand();
        if (!itemstack.isEmpty() || !itemstack1.isEmpty()) {
            matrixStackIn.push();

            if (this.getEntityModel().isChild) {
                float f = 0.5F;
                matrixStackIn.translate(0.0D, 0.75D, 0.0D);
                matrixStackIn.scale(0.5F, 0.5F, 0.5F);
            }

            /**
             * Used to manually adjust x, y, z coordinates.
             * x = distance from hand (<0 = away from body, >0 = closer to body)
             * y = distance from shoulder (>0 = further from shoulder, <0 = closer to shoulder)
             * z = angle
             */

            if (livingEntityIn instanceof GaiaAntEntity) {
                matrixStackIn.translate(0.0F, 0.08F, 0.0F);
            }

            if (livingEntityIn instanceof GaiaAnubisEntity) {
                matrixStackIn.translate(0.0F, 0.08F, 0.0F);
            }

            if (livingEntityIn instanceof GaiaArachneEntity) {
                matrixStackIn.translate(0.0F, -0.02F, 0.0F);
            }

            if (livingEntityIn instanceof GaiaDullahanEntity) {
                matrixStackIn.translate(0.0F, -0.02F, 0.0F);
            }

            if (livingEntityIn instanceof GaiaDwarfEntity) {
                matrixStackIn.translate(0.0F, -0.04F, 0.0F);
            }

            if (livingEntityIn instanceof GaiaGoblinEntity) {
                matrixStackIn.translate(0.0F, -0.12F, 0.0F);
            }

            if (livingEntityIn instanceof GaiaGoblinFeralEntity) {
                matrixStackIn.translate(0.0F, -0.12F, 0.0F);
            }
//
            if (livingEntityIn instanceof GaiaKoboldEntity) {
                matrixStackIn.translate(0.0F, 0.08F, 0.0F);
            }
//
//        if (livingEntityIn instanceof EntityGaiaMermaid) {
//            matrixStackIn.translate(0.0F, 0.08F, 0.0F);
//        }
//
//        if (livingEntityIn instanceof EntityGaiaMinotaur) {
//            matrixStackIn.translate(0.0F, 0.2F, -0.01F);
//            matrixStackIn.rotatef(12.0F, -1.0F, 0.0F, 0.0F);
//        }
//
//        if (livingEntityIn instanceof EntityGaiaOrc) {
//            matrixStackIn.translate(0.0F, 0.20F, 0.0F);
//        }
//
//        if (livingEntityIn instanceof EntityGaiaNaga) {
//            matrixStackIn.translate(0.04F, 0.25F, -0.02F);
//            matrixStackIn.rotatef(12.0F, -1.0F, 0.0F, 0.0F);
//        }
//
//        if (livingEntityIn instanceof EntityGaiaValkyrie) {
//            matrixStackIn.translate(0.0F, 0.08F, 0.0F);
//        }
//
//        if (livingEntityIn instanceof EntityGaiaWerecat) {
//            matrixStackIn.translate(0.0F, 0.08F, 0.0F);
//        } TODO: Reimplement other mob translations

            if (livingEntityIn.isSneaking()) {
                matrixStackIn.translate(0.0F, 0.2F, 0.0F);
            }
            if (slot == EquipmentSlotType.MAINHAND) {
                renderHeldItem(livingEntityIn, itemstack1, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, HandSide.RIGHT, matrixStackIn, bufferIn, packedLightIn);
            } else {
                renderHeldItem(livingEntityIn, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, HandSide.LEFT, matrixStackIn, bufferIn, packedLightIn);
            }
            matrixStackIn.pop();
        }
    }

    private void renderHeldItem(LivingEntity living, ItemStack stack, ItemCameraTransforms.TransformType camera, HandSide handSide, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();

//        matrixStackIn.translate(0.0D, 0.0625D, 0.0D);

        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(-90.0F));
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));

        boolean flag = handSide == HandSide.LEFT;
        matrixStackIn.translate((double)((float)(flag ? -1 : 1) / 16.0F), 0.125D, -0.625D);
        Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(living, stack, camera, flag, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.pop();
    }
}
