package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaArachne;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.hostile.GaiaArachneEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaArachneRenderer extends MobRenderer<GaiaArachneEntity, ModelGaiaArachne<GaiaArachneEntity>> {
    private static final ResourceLocation arachne_eye_texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_arachne.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/arachne.png");
    private static final RenderType RENDER_TYPE = RenderType.getEyes(arachne_eye_texture);

    public GaiaArachneRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaArachne(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
        this.addLayer(new GaiaGlowingLayer<>(this, RENDER_TYPE));
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaArachneEntity entity) {
        return texture;
    }
}
