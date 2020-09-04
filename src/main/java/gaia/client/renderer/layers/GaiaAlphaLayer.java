package gaia.client.renderer.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import gaia.client.model.ModelGaia;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.MobEntity;

public class GaiaAlphaLayer<T extends MobEntity, M extends ModelGaia<T>> extends LayerRenderer<T, M> {
    private static RenderType RENDER_TYPE;
    private static ModelGaia alphaModel;

    public GaiaAlphaLayer(IEntityRenderer<T, M> entityRenderer, RenderType renderType, ModelGaia model) {
        super(entityRenderer);
        this.RENDER_TYPE = renderType;
        this.alphaModel = model;
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!livingEntity.isInvisible()) {
            this.getEntityModel().copyModelAttributesTo(this.alphaModel);
            this.alphaModel.setLivingAnimations(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.alphaModel.setRotationAngles(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RENDER_TYPE);
            this.alphaModel.render(matrixStackIn, ivertexbuilder, packedLightIn, LivingRenderer.getPackedOverlay(livingEntity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
