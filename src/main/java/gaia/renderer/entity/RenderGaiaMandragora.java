package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaMandragora;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaMandragora extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/mandragora.png");

	public RenderGaiaMandragora(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaMandragora(), shadowSize);
		addLayer(LayerGaiaHeldItem.right(this, ModelGaiaMandragora.rightarm));
		addLayer(LayerGaiaHeldItem.left(this, ModelGaiaMandragora.leftarm));
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
