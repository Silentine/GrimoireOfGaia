package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaEnderDragonGirl;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.entity.assist.GaiaEnderDragonGirlEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class GaiaEnderDragonGirlRenderer extends MobRenderer<GaiaEnderDragonGirlEntity, ModelGaiaEnderDragonGirl<GaiaEnderDragonGirlEntity>> {
    private static final ResourceLocation EYE_TEXTURES = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_dragon_girl.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_dragon_girl.png");
    private Random rnd = new Random();

    public GaiaEnderDragonGirlRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaEnderDragonGirl(), shadowSize);
        addLayer(new GaiaGlowingLayer<>(this, EYE_TEXTURES));
    }

    @Override
    public void doRender(GaiaEnderDragonGirlEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isScreaming()) {
            double d0 = 0.02D;
            x += this.rnd.nextGaussian() * 0.02D;
            z += this.rnd.nextGaussian() * 0.02D;
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(GaiaEnderDragonGirlEntity entity) {
        return TEXTURE;
    }
}
