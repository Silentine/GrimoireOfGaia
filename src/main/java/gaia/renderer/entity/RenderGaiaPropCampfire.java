package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaPropCampfire;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaPropCampfire extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/prop/prop_campfire.png");

	public RenderGaiaPropCampfire(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaPropCampfire(), 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
