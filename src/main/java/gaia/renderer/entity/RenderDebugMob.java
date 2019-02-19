package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelDebugMob;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDebugMob extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/debugmob/debug_mob.png");

	public RenderDebugMob(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelDebugMob(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelDebugMob getModel() {
		return (ModelDebugMob) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
