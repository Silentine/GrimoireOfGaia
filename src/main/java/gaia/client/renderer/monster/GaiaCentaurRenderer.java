package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaCentaur;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaCentaurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

public class GaiaCentaurRenderer extends MobRenderer<GaiaCentaurEntity, ModelGaiaCentaur<GaiaCentaurEntity>> {
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/centaur01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/centaur02.png");
    private static final ResourceLocation texture01Male = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/centaur01_male.png");
    private static final ResourceLocation texture02Male = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/centaur02_male.png");

    public GaiaCentaurRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaCentaur(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Override
    public ResourceLocation getEntityTexture(GaiaCentaurEntity entity) {
        switch (entity.getTextureType()) {
            default:
                return texture01;
            case 1:
                return texture02;
            case 2:
                return texture01Male;
            case 3:
                return texture02Male;
        }
    }
}
