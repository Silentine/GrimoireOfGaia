package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSiren;
import gaia.model.ModelGaiaSiren;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSiren extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/siren.png");
	private static final ResourceLocation textureHalloween = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/halloween/siren.png");

	public RenderGaiaSiren(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaSiren(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaSiren getModel() {
		return (ModelGaiaSiren) getMainModel();
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaSiren) entity);
	}

	private ResourceLocation getTexture(EntityGaiaSiren entity) {
		switch (entity.getTextureType()) {
		case 0:
			return texture;
		case 10:
			return textureHalloween;
		default:
			return texture;
		}
	}
}
