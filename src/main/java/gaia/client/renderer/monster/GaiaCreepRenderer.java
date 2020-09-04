package gaia.client.renderer.monster;

import com.mojang.blaze3d.matrix.MatrixStack;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaCreep;
import gaia.client.renderer.layers.GaiaCreepChargeLayer;
import gaia.entity.hostile.GaiaCreepEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nullable;

public class GaiaCreepRenderer extends MobRenderer<GaiaCreepEntity, ModelGaiaCreep<GaiaCreepEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/creep.png");

    public GaiaCreepRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaCreep(), shadowSize);
        addLayer(new GaiaCreepChargeLayer(this));
    }

    @Override
    protected void preRenderCallback(GaiaCreepEntity livingEntity, MatrixStack matrixStackIn, float partialTickTime) {
        float f = livingEntity.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        matrixStackIn.scale(f2, f3, f2);
    }

    protected float getOverlayProgress(CreeperEntity livingEntityIn, float partialTicks) {
        float f = livingEntityIn.getCreeperFlashIntensity(partialTicks);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaCreepEntity entity) {
        return texture;
    }
}
