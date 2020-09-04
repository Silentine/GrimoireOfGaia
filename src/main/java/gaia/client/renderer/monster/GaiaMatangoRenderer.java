package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaMatango;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.hostile.GaiaMatangoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

public class GaiaMatangoRenderer extends MobRenderer<GaiaMatangoEntity, ModelGaiaMatango<GaiaMatangoEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/matango.png");

    public GaiaMatangoRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaMatango(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Override
    public ResourceLocation getEntityTexture(GaiaMatangoEntity gaiaMatangoEntity) {
        return texture;
    }
}
