package gaia.renderer.entity;

import java.util.Random;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaMimic;
import gaia.model.ModelGaiaEnderDragonGirl;
import gaia.model.ModelGaiaMimic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaMimic extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/mimic.png");
	private Random rnd = new Random();

	public RenderGaiaMimic(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaMimic(), shadowSize);
	}

	private ModelGaiaMimic getModel() {
		return (ModelGaiaMimic) getMainModel();
	}

	@Override
	public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
		doRender((EntityGaiaMimic) entity, x, y, z, entityYaw, partialTicks);
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public void doRender(EntityGaiaMimic entity, double x, double y, double z, float entityYaw, float partialTicks) {
		ModelGaiaMimic model = getModel();

		double d0 = 0.02D;
		x += this.rnd.nextGaussian() * 0.06D;
		z += this.rnd.nextGaussian() * 0.06D;

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
