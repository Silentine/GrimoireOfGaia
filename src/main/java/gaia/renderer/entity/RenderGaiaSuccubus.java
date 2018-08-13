package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaSpriggan;
import gaia.model.ModelGaiaSuccubus;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSuccubus extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/succubus.png");

	public RenderGaiaSuccubus(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaSuccubus(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, ModelGaiaSpriggan.rightarm));
		addLayer(LayerGaiaHeldItem.left(this, ModelGaiaSpriggan.leftarm));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
