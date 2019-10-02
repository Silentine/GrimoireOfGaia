package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaMimic;
import gaia.entity.hostile.GaiaAntEntity;
import gaia.entity.hostile.GaiaMimicEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.Random;

public class GaiaMimicRenderer extends MobRenderer<GaiaMimicEntity, ModelGaiaMimic<GaiaMimicEntity>> {
    private Random rand = new Random();
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/mimic.png");

    public GaiaMimicRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaMimic(), shadowSize);
    }

    @Override
    public void doRender(GaiaMimicEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        double d0 = 0.02D;
        x += this.rand.nextGaussian() * 0.06D;
        z += this.rand.nextGaussian() * 0.06D;

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(GaiaMimicEntity entity) {
        return texture;
    }
}
