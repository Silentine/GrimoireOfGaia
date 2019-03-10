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
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_vase01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/alternate/prop_vase02.png");

	public RenderGaiaPropVase(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaPropVase(), 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaPropVase) entity);
	}

	private ResourceLocation getTexture(EntityGaiaPropVase entity) {
		switch (entity.getTextureType()) {
		case 0:
			return texture01;
		case 1:
			return texture02;
		default:
			return texture01;
		}
	}
}
