package gaia.renderer.entity;

import gaia.model.ModelGaiaPropChestMimic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaPropChestMimic extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation("minecraft", "textures/entity/chest/normal.png");

	public RenderGaiaPropChestMimic(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaPropChestMimic(), 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
