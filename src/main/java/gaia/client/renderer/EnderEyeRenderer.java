package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderEyeModel;
import gaia.client.renderer.layer.EnderEyeEyesLayer;
import gaia.entity.EnderEye;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class EnderEyeRenderer extends MobRenderer<EnderEye, EnderEyeModel> {
	private final Random random = new Random();
	public static final ResourceLocation[] ENDER_EYE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_eye/ender_eye.png")
	};

	public EnderEyeRenderer(Context context) {
		super(context, new EnderEyeModel(context.bakeLayer(ClientHandler.ENDER_EYE)), ClientHandler.smallShadow);
		this.addLayer(new EnderEyeEyesLayer(this));
	}

	public Vec3 getRenderOffset(EnderEye enderEye, float partialTick) {
		if (enderEye.isScreaming()) {
			double d0 = 0.02D;
			return new Vec3(this.random.nextGaussian() * d0, 0.0D, this.random.nextGaussian() * d0);
		} else {
			return super.getRenderOffset(enderEye, partialTick);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(EnderEye enderEye) {
		return ENDER_EYE_LOCATIONS[enderEye.getVariant()];
	}
}
