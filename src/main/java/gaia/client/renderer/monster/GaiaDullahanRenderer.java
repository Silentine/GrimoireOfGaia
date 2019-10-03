package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaBoneKnight;
import gaia.client.model.ModelGaiaDullahan;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.hostile.GaiaBoneKnightEntity;
import gaia.entity.hostile.GaiaDullahanEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaDullahanRenderer extends MobRenderer<GaiaDullahanEntity, ModelGaiaDullahan<GaiaDullahanEntity>> {
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/dullahan.png");

    public GaiaDullahanRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaDullahan(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaDullahanEntity entity) {
        return texture;
    }
}
