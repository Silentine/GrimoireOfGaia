package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaKobold;
import gaia.model.ModelGaiaKobold;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaKobold extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/kobold01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/kobold02.png");

	public RenderGaiaKobold(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaKobold(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaKobold getModel() {
		return (ModelGaiaKobold) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GlStateManager.translatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaKobold) entity);
	}

	private ResourceLocation getTexture(EntityGaiaKobold entity) {
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
