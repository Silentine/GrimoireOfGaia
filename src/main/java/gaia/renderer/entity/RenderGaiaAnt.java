package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaAnt;
import gaia.model.ModelGaiaAnt;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaAnt extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ant01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/alternate/ant02.png");

	public RenderGaiaAnt(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaAnt(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightarm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftarm()));
	}

	private ModelGaiaAnt getModel() {
		return (ModelGaiaAnt) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaAnt) entity);
	}

	private ResourceLocation getTexture(EntityGaiaAnt entity) {
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
