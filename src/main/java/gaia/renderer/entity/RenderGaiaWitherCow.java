package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaWitherCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaWitherCow extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/wither_cow.png");

	public RenderGaiaWitherCow(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaWitherCow(), shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
