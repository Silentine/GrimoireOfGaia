package gaia.client.renderer.monster;

import com.mojang.blaze3d.platform.GlStateManager;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaGoblinFeral;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaGoblinFeralEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nullable;

public class GaiaGoblinFeralRenderer extends MobRenderer<GaiaGoblinFeralEntity, ModelGaiaGoblinFeral<GaiaGoblinFeralEntity>> {
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/goblin_feral01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/goblin_feral02.png");
    private static final ResourceLocation texture03 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/goblin_feral03.png");

    public GaiaGoblinFeralRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaGoblinFeral(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Override
    protected void preRenderCallback(GaiaGoblinFeralEntity entitylivingbaseIn, float partialTickTime) {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scalef(f2, f3, f2);
    }

    @Override
    protected int getColorMultiplier(GaiaGoblinFeralEntity entitylivingbaseIn, float lightBrightness, float partialTickTime) {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);

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
    protected ResourceLocation getEntityTexture(GaiaGoblinFeralEntity entity) {
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
