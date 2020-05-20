package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaBee;
import gaia.entity.assist.GaiaBeeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GaiaBeeRenderer extends MobRenderer<GaiaBeeEntity, ModelGaiaBee<GaiaBeeEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/bee.png");

    public GaiaBeeRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaBee(), shadowSize);
    }

    @Override
    public ResourceLocation getEntityTexture(GaiaBeeEntity entity) {
        return texture;
    }
}
