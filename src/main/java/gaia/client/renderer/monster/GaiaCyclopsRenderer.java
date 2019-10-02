package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaDeathword;
import gaia.client.model.ModelGaiaMonoeye;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaCyclopsEntity;
import gaia.entity.hostile.GaiaDeathwordEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

public class GaiaCyclopsRenderer extends MobRenderer<GaiaCyclopsEntity, ModelGaiaMonoeye<GaiaCyclopsEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/monoeye.png");

    public GaiaCyclopsRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaMonoeye<>(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Override
    protected ResourceLocation getEntityTexture(GaiaCyclopsEntity entity) {
        return texture;
    }
}
