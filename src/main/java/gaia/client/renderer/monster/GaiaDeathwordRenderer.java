package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaDeathword;
import gaia.entity.hostile.GaiaDeathwordEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GaiaDeathwordRenderer extends MobRenderer<GaiaDeathwordEntity, ModelGaiaDeathword<GaiaDeathwordEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/deathword.png");

    public GaiaDeathwordRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaDeathword<>(), shadowSize);
    }

    @Override
    public ResourceLocation getEntityTexture(GaiaDeathwordEntity entity) {
        return texture;
    }
}
