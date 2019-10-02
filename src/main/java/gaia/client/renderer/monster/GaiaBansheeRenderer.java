package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaBanshee;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.entity.hostile.GaiaBansheeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GaiaBansheeRenderer extends MobRenderer<GaiaBansheeEntity, ModelGaiaBanshee<GaiaBansheeEntity>> {
    private static final ResourceLocation bansheeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/banshee.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/banshee.png");

    public GaiaBansheeRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaBanshee(), shadowSize);
        this.addLayer(new GaiaGlowingLayer<>(this, bansheeEyesTexture));
    }

    @Override
    protected ResourceLocation getEntityTexture(GaiaBansheeEntity entity) {
        return texture;
    }
}
