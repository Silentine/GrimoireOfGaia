package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderEyeModel;
import gaia.client.renderer.layer.EnderEyeEyesLayer;
import gaia.client.state.EnderEyeRenderState;
import gaia.entity.EnderEye;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class EnderEyeRenderer extends MobRenderer<EnderEye, EnderEyeRenderState, EnderEyeModel> {
	private final Random random = new Random();
	public static final Identifier[] ENDER_EYE_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/ender_eye/ender_eye.png")
	};

	public EnderEyeRenderer(Context context) {
		super(context, new EnderEyeModel(context.bakeLayer(ClientHandler.ENDER_EYE)), ClientHandler.smallShadow);
		this.addLayer(new EnderEyeEyesLayer(this));
	}

	public Vec3 getRenderOffset(EnderEyeRenderState state) {
		if (state.isScreaming) {
			double d0 = 0.02D;
			return new Vec3(this.random.nextGaussian() * d0, 0.0D, this.random.nextGaussian() * d0);
		} else {
			return super.getRenderOffset(state);
		}
	}

	@Override
	public EnderEyeRenderState createRenderState() {
		return new EnderEyeRenderState();
	}

	@Override
	public void extractRenderState(EnderEye entity, EnderEyeRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isScreaming = entity.isScreaming();
	}

	@Override
	public Identifier getTextureLocation(EnderEyeRenderState state) {
		return ENDER_EYE_LOCATIONS[state.variant];
	}
}
