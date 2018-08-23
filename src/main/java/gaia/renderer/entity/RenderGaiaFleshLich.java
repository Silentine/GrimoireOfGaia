package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaFleshLich;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaFleshLich extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/flesh_lich.png");

	public RenderGaiaFleshLich(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaFleshLich(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
	}

	private ModelGaiaFleshLich getModel() {
		return (ModelGaiaFleshLich) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
