package gaia.renderer.entity;

import java.util.Random;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderEye;
import gaia.model.ModelGaiaEnderEye;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaEnderEye extends RenderLiving<EntityLiving> {
	private static final ResourceLocation endereyeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_eye.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_eye.png");
	private Random rnd = new Random();

	public RenderGaiaEnderEye(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaEnderEye(), shadowSize);
		addLayer(new LayerGlowing(this, endereyeEyesTexture));
	}

	private ModelGaiaEnderEye getModel() {
		return (ModelGaiaEnderEye) getMainModel();
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
		doRender((EntityGaiaEnderEye) entity, x, y, z, entityYaw, partialTicks);
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public void doRender(EntityGaiaEnderEye entity, double x, double y, double z, float entityYaw, float partialTicks) {
		ModelGaiaEnderEye modelenderman = getModel();

		if (entity.isScreaming()) {
			double d0 = 0.02D;
			x += this.rnd.nextGaussian() * 0.02D;
			z += this.rnd.nextGaussian() * 0.02D;
		}

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
