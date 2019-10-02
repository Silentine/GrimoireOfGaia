package gaia.client.renderer.monster;

import com.mojang.blaze3d.platform.GlStateManager;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaCreep;
import gaia.client.renderer.layers.GaiaCreepChargeLayer;
import gaia.entity.hostile.GaiaCreepEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
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
    protected void preRenderCallback(GaiaCreepEntity livingEntity, float partialTickTime) {
        float f = livingEntity.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scalef(f2, f3, f2);
    }

    @Override
    protected int getColorMultiplier(GaiaCreepEntity entity, float lightBrightness, float partialTickTime) {
        float f = entity.getCreeperFlashIntensity(partialTickTime);

        if ((int) (f * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int i = (int) (f * 0.2F * 255.0F);
            i = MathHelper.clamp(i, 0, 255);
            return i << 24 | 822083583;
        }
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaCreepEntity entity) {
        return texture;
    }
}
