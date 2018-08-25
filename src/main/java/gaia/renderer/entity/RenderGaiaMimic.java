package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaMimic;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//TODO Use RenderEnderman as basis to make ModelGaiaMimic randomly shake
@SideOnly(Side.CLIENT)
public class RenderGaiaMimic extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/mimic.png");

	public RenderGaiaMimic(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaMimic(), shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
