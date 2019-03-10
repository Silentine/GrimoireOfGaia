package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaWitch;
import gaia.model.ModelGaiaWitch;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaWitch extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/witch01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/witch02.png");

	public RenderGaiaWitch(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaWitch(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
//		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaWitch getModel() {
		return (ModelGaiaWitch) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GlStateManager.translatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaWitch) entity);
	}

	private ResourceLocation getTexture(EntityGaiaWitch entity) {
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
