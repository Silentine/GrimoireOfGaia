package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaDhampir;
import gaia.client.renderer.layers.GaiaGlowingLayer;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.hostile.GaiaDhampirEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class GaiaDhampirRenderer extends MobRenderer<GaiaDhampirEntity, ModelGaiaDhampir<GaiaDhampirEntity>> {
    private static final ResourceLocation dhampirEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_dhampir.png");
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/dhampir.png");
    private static final RenderType RENDER_TYPE = RenderType.getEyes(dhampirEyesTexture);

    public GaiaDhampirRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaDhampir(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
        addLayer(new GaiaGlowingLayer<>(this, RENDER_TYPE));
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaDhampirEntity entity) {
        return texture;
    }
}
