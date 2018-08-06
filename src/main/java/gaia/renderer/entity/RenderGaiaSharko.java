package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaSharko;
import gaia.renderer.entity.layers.LayerGaiaHeldItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSharko extends RenderLiving<EntityLiving> {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/sharko.png");
	static RenderManager rend = Minecraft.getMinecraft()
			.getRenderManager();

	public RenderGaiaSharko(float shadowSize) {
		super(rend, new ModelGaiaSharko(), shadowSize);
		this.addLayer(LayerGaiaHeldItem.Right(this, ModelGaiaSharko.rightarm));
		this.addLayer(LayerGaiaHeldItem.Left(this, ModelGaiaSharko.leftarm));
	}

	@Override
	public void transformHeldFull3DItemLayer() {
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}

	@Override
	protected void preRenderCallback(EntityLiving living, float par2) {
		GlStateManager.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
