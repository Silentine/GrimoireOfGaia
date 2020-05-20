package gaia.client.renderer.monster;

import com.mojang.blaze3d.matrix.MatrixStack;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaEnderDragonGirl;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.entity.assist.GaiaEnderDragonGirlEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class GaiaEnderDragonGirlRenderer extends MobRenderer<GaiaEnderDragonGirlEntity, ModelGaiaEnderDragonGirl<GaiaEnderDragonGirlEntity>> {
    private static final ResourceLocation EYE_TEXTURES = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_dragon_girl.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_dragon_girl.png");
    private Random rnd = new Random();
    private static final RenderType RENDER_TYPE = RenderType.getEyes(EYE_TEXTURES);

    public GaiaEnderDragonGirlRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaEnderDragonGirl(), shadowSize);
        this.addLayer(new GaiaGlowingLayer<>(this, RENDER_TYPE));
    }

    @Override
    public void render(GaiaEnderDragonGirlEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public Vec3d getRenderOffset(GaiaEnderDragonGirlEntity entityIn, float partialTicks) {
        if (entityIn.isScreaming()) {
            double d0 = 0.02D;
            return new Vec3d(this.rnd.nextGaussian() * 0.02D, 0.0D, this.rnd.nextGaussian() * 0.02D);
        } else {
            return super.getRenderOffset(entityIn, partialTicks);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(GaiaEnderDragonGirlEntity entity) {
        return TEXTURE;
    }
}
