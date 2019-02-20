package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.entity.monster.EntityGaiaSuccubus;
import gaia.model.ModelGaiaSuccubus;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGaiaSuccubus extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/succubus.png");
	private static final ResourceLocation textureMale = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/alternate/succubus_male.png");

	public RenderGaiaSuccubus(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaSuccubus(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, getModel().getRightArm()));
		addLayer(LayerGaiaHeldItem.left(this, getModel().getLeftArm()));
	}

	private ModelGaiaSuccubus getModel() {
		return (ModelGaiaSuccubus) getMainModel();
	}

	private ResourceLocation getTexture(EntityGaiaSuccubus entity) {
		if (!entity.isMale()) {
			return texture;
		} else {
			return textureMale;
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return getTexture((EntityGaiaSuccubus) entity);
	}
}
