package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.prop.EntityGaiaPropVase;
import gaia.model.ModelGaiaPropVase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaPropVase extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_vase.png");

	public RenderGaiaPropVase(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaPropVase(), 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaPropVase) entity);
	}

	private ResourceLocation getTexture(EntityGaiaPropVase entity) {
		return texture;
	}
}
