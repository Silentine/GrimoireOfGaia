package gaia.client.renderer.monster;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import gaia.GaiaReference;
import gaia.client.model.ModelGaiaGelatinousSlime;
import gaia.client.renderer.layers.GaiaAlphaLayer;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.hostile.GaiaGelatinousSlimeEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaGelatinousSlimeRenderer extends MobRenderer<GaiaGelatinousSlimeEntity, ModelGaiaGelatinousSlime<GaiaGelatinousSlimeEntity>> {
    private static final ResourceLocation SLIME_LAYER_TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/layer_gelatinous_slime.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/gelatinous_slime.png");
    private static final RenderType RENDER_TYPE = RenderType.getEntityTranslucent(SLIME_LAYER_TEXTURE);

    public GaiaGelatinousSlimeRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaGelatinousSlime(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaAlphaLayer<>(this, RENDER_TYPE, new ModelGaiaGelatinousSlime()));
    }

    @Override
    protected void preRenderCallback(GaiaGelatinousSlimeEntity entity, MatrixStack matrixStackIn, float partialTickTime) {
        float f = 0.999F;
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
        float f1 = 1.0F;
        float f2 = (entity.prevSquishFactor + (entity.squishFactor - entity.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        matrixStackIn.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaGelatinousSlimeEntity entity) {
        return TEXTURE;
    }
}
