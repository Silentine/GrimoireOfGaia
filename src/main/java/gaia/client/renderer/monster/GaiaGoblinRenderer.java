package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaGoblin;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaGoblinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaGoblinRenderer extends MobRenderer<GaiaGoblinEntity, ModelGaiaGoblin<GaiaGoblinEntity>> {
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/goblin01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/goblin02.png");

    public GaiaGoblinRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaGoblin(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaGoblinEntity entity) {
        switch (entity.getTextureType()) {
            default:
                return texture01;
            case 1:
                return texture02;
        }
    }
}
