package gaia.client.renderer.monster;

import gaia.GaiaReference;
import gaia.client.model.ModelGaiaMimic;
import gaia.entity.assist.GaiaEnderDragonGirlEntity;
import gaia.entity.hostile.GaiaMimicEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

import javax.annotation.Nullable;
import java.util.Random;

public class GaiaMimicRenderer extends MobRenderer<GaiaMimicEntity, ModelGaiaMimic<GaiaMimicEntity>> {
    private Random rand = new Random();
    private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/mimic.png");

    public GaiaMimicRenderer(EntityRendererManager rendererManager, float shadowSize) {
        super(rendererManager, new ModelGaiaMimic(), shadowSize);
    }

    @Override
    public Vec3d getRenderOffset(GaiaMimicEntity entityIn, float partialTicks) {
        double d0 = 0.02D;
        return new Vec3d(this.rand.nextGaussian() * 0.06D, 0.0D, this.rand.nextGaussian() * 0.06D);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(GaiaMimicEntity entity) {
        return texture;
    }
}
