package gaia.client.renderer.monster;

import com.mojang.blaze3d.platform.GlStateManager;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaGryphon;
import gaia.entity.assist.GaiaGryphonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GaiaGryphonRenderer extends MobRenderer<GaiaGryphonEntity, ModelGaiaGryphon<GaiaGryphonEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/gryphon.png");
    private static final float SCALE_AMOUNT = 1.25F;

    public GaiaGryphonRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaGryphon(), shadowSize);
    }

    @Override
    protected void preRenderCallback(GaiaGryphonEntity entitylivingbaseIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
        GlStateManager.scalef(SCALE_AMOUNT, SCALE_AMOUNT, SCALE_AMOUNT);
    }

    @Override
    protected ResourceLocation getEntityTexture(GaiaGryphonEntity entity) {
        return texture;
    }
}
