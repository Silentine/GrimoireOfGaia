package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSludgeGirl;
import gaia.model.ModelGaiaSludgeGirl;
import gaia.renderer.entity.layers.LayerTextureSludgeGirl;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSludgeGirl extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/sludge_girl01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/sludge_girl02.png");
	private static final ResourceLocation texture03 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/sludge_girl03.png");

	public RenderGaiaSludgeGirl(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaSludgeGirl(), shadowSize);
		addLayer(new LayerTextureSludgeGirl(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaSludgeGirl) entity);
	}

	private ResourceLocation getTexture(EntityGaiaSludgeGirl entity) {
		switch (entity.getTextureType()) {
		case 0:
			return texture01;
		case 1:
			return texture02;
		case 2:
			return texture03;
		default:
			return texture01;
		}
	}
}
