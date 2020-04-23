package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaMandragora;
import gaia.client.renderer.layers.GaiaHeldItemLayer;
import gaia.entity.hostile.GaiaMandragoraEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Random;

public class GaiaMandragoraRenderer extends MobRenderer<GaiaMandragoraEntity, ModelGaiaMandragora<GaiaMandragoraEntity>> {
    private Random rand = new Random();
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/mandragora.png");

    public GaiaMandragoraRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaMandragora(), shadowSize);
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getLeftArm(), EquipmentSlotType.OFFHAND));
        this.addLayer(new GaiaHeldItemLayer<>(this, getEntityModel().getRightArm(), EquipmentSlotType.MAINHAND));
    }

    @Override
    public void doRender(GaiaMandragoraEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.isScreaming()) {
            double d0 = 0.02D;
            x += this.rand.nextGaussian() * 0.06D;
            z += this.rand.nextGaussian() * 0.06D;
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaMandragoraEntity entity) {
        return texture;
    }
}
