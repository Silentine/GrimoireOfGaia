package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaWerecat;
import gaia.model.ModelGaiaWerecat;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaWerecat extends RenderLiving<EntityLiving> {
	private static final ResourceLocation werecatEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/layer/eyes_werecat.png");
	private static final ResourceLocation texture01 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/werecat01.png");
	private static final ResourceLocation texture02 = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/werecat02.png");

	public RenderGaiaWerecat(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaWerecat(), shadowSize);
		addLayer(new LayerGlowing(this, werecatEyesTexture));
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaWerecat) entity);
	}

	private ResourceLocation getTexture(EntityGaiaWerecat entity) {
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
