package gaia.client.renderer.monster;

import com.mojang.blaze3d.platform.GlStateManager;
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
    protected void preRenderCallback(GaiaSphinxEntity living, float par2) {
        GlStateManager.scalef(1.25F, 1.25F, 1.25F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaSphinxEntity entity) {
        return texture;
    }
}
