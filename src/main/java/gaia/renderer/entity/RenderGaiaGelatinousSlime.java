package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaGelatinousSlime;
import gaia.model.ModelGaiaGelatinousSlime;
import gaia.renderer.entity.layers.LayerAlpha;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaGelatinousSlime extends RenderLiving<EntityLiving> {
	private static final ResourceLocation layerSlime = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/layer_gelatinous_slime.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/gelatinous_slime.png");

	public RenderGaiaGelatinousSlime(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaGelatinousSlime(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
		addLayer(new LayerAlpha(this, layerSlime));
	}

	private ModelGaiaGelatinousSlime getModel() {
		return (ModelGaiaGelatinousSlime) getMainModel();
	}

//	@Override
//	public void transformHeldFull3DItemLayer() {
//		GlStateManager.translatef(0.0F, 0.1875F, 0.0F);
//	}

	@Override
    protected void preRenderCallback(EntityLiving entitylivingbaseIn, float partialTickTime)
    {
		preRenderCallback((EntityGaiaGelatinousSlime) entitylivingbaseIn, partialTickTime);
    }
	
    protected void preRenderCallback(EntityGaiaGelatinousSlime entitylivingbaseIn, float partialTickTime)
    {
        float f = 0.999F;
        GlStateManager.scalef(1.0F, 1.0F, 1.0F);
        float f1 = 1.0F;
        float f2 = (entitylivingbaseIn.prevSquishFactor + (entitylivingbaseIn.squishFactor - entitylivingbaseIn.prevSquishFactor) * partialTickTime) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        GlStateManager.scalef(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
