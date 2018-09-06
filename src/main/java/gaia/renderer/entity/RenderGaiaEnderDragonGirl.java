package gaia.renderer.entity;

import java.util.Random;

import gaia.GaiaReference;
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
	private static final ResourceLocation enderdragongirlEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_ender_dragon_girl.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ender_dragon_girl.png");
	private Random rnd = new Random();

	public RenderGaiaEnderDragonGirl(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaEnderDragonGirl(), shadowSize);
		addLayer(new LayerGlowing(this, enderdragongirlEyesTexture));
	}

	private ModelGaiaEnderDragonGirl getModel() {
		return (ModelGaiaEnderDragonGirl) getMainModel();
	}

//	private void renderEnderDragonGirl(EntityGaiaEnderDragonGirl entity, double x, double y, double z, float entityYaw, float partialTicks) {
//		ModelGaiaEnderDragonGirl model = getModel();
//
//		if (entity.isScreaming()) {
//			super.doRender(entity, x + rnd.nextGaussian() * 0.02D, y, z + rnd.nextGaussian() * 0.02D, entityYaw, partialTicks);
//		}
//
//		super.doRender(entity, x, y, z, entityYaw, partialTicks);
//	}
//
//	@Override
//	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
//		renderEnderDragonGirl((EntityGaiaEnderDragonGirl) entity, x, y, z, entityYaw, partialTicks);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
