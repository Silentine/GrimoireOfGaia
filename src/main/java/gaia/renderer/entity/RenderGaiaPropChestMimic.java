package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaPropChestMimic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaPropChestMimic extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/prop_chest_mimic.png");

	public RenderGaiaPropChestMimic(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaPropChestMimic(), 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
