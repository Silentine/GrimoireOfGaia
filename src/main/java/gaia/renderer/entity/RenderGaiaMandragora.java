package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.model.ModelGaiaMandragora;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaMandragora extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/mandragora.png");
	private Random rnd = new Random();

	public RenderGaiaMandragora(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaMandragora(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
		doRender((EntityGaiaMandragora) entity, x, y, z, entityYaw, partialTicks);
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public void doRender(EntityGaiaMandragora entity, double x, double y, double z, float entityYaw, float partialTicks) {

		if (entity.isScreaming()) {
			double d0 = 0.02D;
			x += this.rnd.nextGaussian() * 0.06D;
			z += this.rnd.nextGaussian() * 0.06D;
		}

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	private ModelGaiaMandragora getModel() {
		return (ModelGaiaMandragora) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GlStateManager.translatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
