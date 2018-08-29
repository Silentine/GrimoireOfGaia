package gaia.renderer.entity;

import gaia.GaiaReference;
import gaia.model.ModelGaiaEnderEye;
import gaia.renderer.entity.layers.LayerGlowing;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//TODO apply RenderEnderman shaking when provoked
@SideOnly(Side.CLIENT)
public class RenderGaiaEnderEye extends RenderLiving<EntityLiving> {
	private static final ResourceLocation endereyeEyesTexture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/layer/eyes_ender_eye.png");
	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/ender_eye.png");

	public RenderGaiaEnderEye(RenderManager renderManager, float shadowSize) {
		super(renderManager, new ModelGaiaEnderEye(), shadowSize);
		addLayer(new LayerGlowing(this, endereyeEyesTexture));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLiving entity) {
		return texture;
	}
}
