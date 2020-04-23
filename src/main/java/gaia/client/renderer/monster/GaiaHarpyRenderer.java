package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaHarpy;
import gaia.entity.hostile.GaiaHarpyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaHarpyRenderer extends MobRenderer<GaiaHarpyEntity, ModelGaiaHarpy<GaiaHarpyEntity>> {
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/harpy01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/harpy02.png");
    private static final ResourceLocation texture03 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/harpy03.png");

    public GaiaHarpyRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaHarpy(), shadowSize);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaHarpyEntity entity) {
        switch (entity.getTextureType()) {
            default:
                return texture01;
            case 1:
                return texture02;
            case 2:
                return texture03;
        }
    }

}
