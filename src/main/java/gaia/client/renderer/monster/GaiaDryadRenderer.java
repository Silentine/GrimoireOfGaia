package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaBoneKnight;
import gaia.client.model.ModelGaiaDryad;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaDryadEntity;
import gaia.entity.hostile.GaiaBoneKnightEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaDryadRenderer extends MobRenderer<GaiaDryadEntity, ModelGaiaDryad<GaiaDryadEntity>> {
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/dryad01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/dryad02.png");

    public GaiaDryadRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaDryad(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaDryadEntity entity) {
        switch (entity.getTextureType()) {
            default:
                return texture01;
            case 1:
                return texture02;
        }
    }
}
