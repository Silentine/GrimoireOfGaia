package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderEyeModel;
import gaia.client.renderer.layer.EnderEyeEyesLayer;
import gaia.entity.EnderEye;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EnderEyeRenderer extends MobRenderer<EnderEye, EnderEyeModel> {
	public static final ResourceLocation[] ENDER_EYE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_eye/ender_eye.png")
	};

	public EnderEyeRenderer(Context context) {
		super(context, new EnderEyeModel(context.bakeLayer(ClientHandler.ENDER_EYE)), ClientHandler.smallShadow);
		this.addLayer(new EnderEyeEyesLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(EnderEye enderEye) {
		return ENDER_EYE_LOCATIONS[enderEye.getVariant()];
	}
}
