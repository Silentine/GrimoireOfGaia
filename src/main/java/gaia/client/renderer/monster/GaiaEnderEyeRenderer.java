package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaEnderEye;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.entity.assist.GaiaEnderEyeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class GaiaEnderEyeRenderer extends MobRenderer<GaiaEnderEyeEntity, ModelGaiaEnderEye<GaiaEnderEyeEntity>> {
    private static final ResourceLocation EYE_TEXTURES = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_eye.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_eye.png");
    private Random rnd = new Random();

    public GaiaEnderEyeRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaEnderEye(), shadowSize);
        addLayer(new GaiaGlowingLayer<>(this, EYE_TEXTURES));
    }

    @Override
    public void doRender(GaiaEnderEyeEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isScreaming()) {
            double d0 = 0.02D;
            x += this.rnd.nextGaussian() * 0.02D;
            z += this.rnd.nextGaussian() * 0.02D;
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(GaiaEnderEyeEntity entity) {
        return TEXTURE;
    }
}
