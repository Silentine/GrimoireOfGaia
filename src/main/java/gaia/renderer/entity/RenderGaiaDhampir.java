package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaDhampir;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaDhampir extends RenderLiving<EntityLiving> {
	private static final ResourceLocation dhampirEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_dhampir.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/dhampir.png");

	public RenderGaiaDhampir(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaDhampir(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
		addLayer(new LayerGlowing(this, dhampirEyesTexture));
	}

	private ModelGaiaDhampir getModel() {
		return (ModelGaiaDhampir) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GlStateManager.translatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
