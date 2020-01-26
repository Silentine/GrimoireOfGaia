package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaSphinx;
import gaia.renderer.entity.layers.LayerAuraSphinx;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaSphinx extends RenderLiving<EntityLiving> {
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/entity/sphinx.png");

	public RenderGaiaSphinx(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaSphinx(0.0F), shadowSize);
        addLayer(new LayerAuraSphinx(this));
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
