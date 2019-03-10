package gaia.renderer.entity;

import java.util.Random;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaEnderDragonGirl;
import gaia.entity.monster.EntityGaiaGelatinousSlime;
import gaia.model.ModelGaiaEnderDragonGirl;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaEnderDragonGirl extends RenderLiving<EntityLiving> {
	private static final ResourceLocation enderdragongirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_ender_dragon_girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/ender_dragon_girl.png");
	private Random rnd = new Random();

	public RenderGaiaEnderDragonGirl(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaEnderDragonGirl(), shadowSize);
		addLayer(new LayerGlowing(this, enderdragongirlEyesTexture));
	}

	private ModelGaiaEnderDragonGirl getModel() {
		return (ModelGaiaEnderDragonGirl) getMainModel();
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
		doRender((EntityGaiaEnderDragonGirl) entity, x, y, z, entityYaw, partialTicks);
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public void doRender(EntityGaiaEnderDragonGirl entity, double x, double y, double z, float entityYaw, float partialTicks) {
		ModelGaiaEnderDragonGirl modelenderman = getModel();

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
