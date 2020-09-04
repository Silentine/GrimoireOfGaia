package gaia.client.renderer.monster;

import com.mojang.blaze3d.matrix.MatrixStack;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaSphinx;
import gaia.entity.hostile.GaiaSphinxEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaSphinxRenderer extends MobRenderer<GaiaSphinxEntity, ModelGaiaSphinx<GaiaSphinxEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/sphinx.png");

    public GaiaSphinxRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaSphinx(), shadowSize);
    }

    @Override
    protected void preRenderCallback(GaiaSphinxEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
        matrixStackIn.scale(1.25F, 1.25F, 1.25F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaSphinxEntity entity) {
        return texture;
    }
}
