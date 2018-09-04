package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaOrc;
import gaia.model.ModelGaiaOrc;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaOrc extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/orc01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/orc02.png");

	public RenderGaiaOrc(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaOrc(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaOrc getModel() {
		return (ModelGaiaOrc) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	private ResourceLocation getTexture(EntityGaiaOrc entityGaiaOrc) {
		switch (entityGaiaOrc.getTextureType()) {
		case 0:
			return texture01;
		case 1:
			return texture02;
		default:
			return texture01;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaOrc) entity);
	}
}
