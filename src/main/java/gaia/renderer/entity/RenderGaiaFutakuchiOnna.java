package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaFutakuchiOnna;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGaiaFutakuchiOnna extends RenderLiving<EntityLiving> {
	private static final ResourceLocation FutakuchiOnnaEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_futakuchi_onna.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/futakuchi_onna.png");

	public RenderGaiaFutakuchiOnna(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaFutakuchiOnna(), shadowSize);
		addLayer(new LayerGlowing(this, FutakuchiOnnaEyesTexture));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
