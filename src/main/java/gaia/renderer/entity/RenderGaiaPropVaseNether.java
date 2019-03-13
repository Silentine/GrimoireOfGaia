package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.prop.EntityGaiaPropVase;
import gaia.model.ModelGaiaPropVase;
import gaia.model.ModelGaiaPropVaseNether;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaPropVaseNether extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_vase_nether.png");

	public RenderGaiaPropVaseNether(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaPropVaseNether(), 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaPropVase) entity);
	}

	private ResourceLocation getTexture(EntityGaiaPropVase entity) {
		return texture;
	}
}
