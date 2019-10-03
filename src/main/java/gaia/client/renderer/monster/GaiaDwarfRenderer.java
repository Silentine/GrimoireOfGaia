package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaDwarf;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.assist.GaiaDwarfEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaDwarfRenderer extends MobRenderer<GaiaDwarfEntity, ModelGaiaDwarf<GaiaDwarfEntity>> {
    private static final ResourceLocation dwarfEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_dwarf03.png");
    private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/dwarf01.png");
    private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/dwarf02.png");
    private static final ResourceLocation texture03 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/dwarf03.png");

    public GaiaDwarfRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaDwarf(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
        this.addLayer(new GaiaGlowingLayer<>(this, dwarfEyesTexture));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaDwarfEntity entity) {
        switch (entity.getMobType()) {
            default:
                return texture01;
            case 1:
                return texture02;
            case 2:
                return texture03;
        }
    }
}
