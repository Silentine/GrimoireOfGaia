package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaEnderEye;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.entity.assist.GaiaEnderEyeEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class GaiaEnderEyeRenderer extends MobRenderer<GaiaEnderEyeEntity, ModelGaiaEnderEye<GaiaEnderEyeEntity>> {
    private static final ResourceLocation EYE_TEXTURES = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_eye.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_eye.png");
    private Random rnd = new Random();
    private static final RenderType RENDER_TYPE = RenderType.getEyes(EYE_TEXTURES);

    public GaiaEnderEyeRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaEnderEye(), shadowSize);
        addLayer(new GaiaGlowingLayer<>(this, RENDER_TYPE));
    }

    @Override
    public Vec3d getRenderOffset(GaiaEnderEyeEntity entityIn, float partialTicks) {
        if (entityIn.isScreaming()) {
            double d0 = 0.02D;
            return new Vec3d(this.rnd.nextGaussian() * 0.02D, 0.0D, this.rnd.nextGaussian() * 0.02D);
        } else {
            return super.getRenderOffset(entityIn, partialTicks);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(GaiaEnderEyeEntity entity) {
        return TEXTURE;
    }
}
