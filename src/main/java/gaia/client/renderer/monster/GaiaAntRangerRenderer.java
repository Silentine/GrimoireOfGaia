package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaAntRanger;
import gaia.entity.hostile.GaiaAntRangerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaAntRangerRenderer extends MobRenderer<GaiaAntRangerEntity, ModelGaiaAntRanger<GaiaAntRangerEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ant_ranger.png");

    public GaiaAntRangerRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaAntRanger(), shadowSize);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaAntRangerEntity entity) {
        return texture;
    }
}
