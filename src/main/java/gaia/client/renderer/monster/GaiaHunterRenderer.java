package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaHunter;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaHunterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaHunterRenderer extends MobRenderer<GaiaHunterEntity, ModelGaiaHunter<GaiaHunterEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/hunter.png");

    public GaiaHunterRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaHunter(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaHunterEntity entity) {
        return texture;
    }
}
