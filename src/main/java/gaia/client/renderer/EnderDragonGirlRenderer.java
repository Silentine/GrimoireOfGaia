package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderDragonGirlModel;
import gaia.client.renderer.layer.EnderDragonGirlEyesLayer;
import gaia.client.state.EnderDragonGirlRenderState;
import gaia.entity.EnderDragonGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class EnderDragonGirlRenderer extends MobRenderer<EnderDragonGirl, EnderDragonGirlRenderState, EnderDragonGirlModel> {
	private final Random random = new Random();
	public static final Identifier[] ENDER_DRAGON_GIRL_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/ender_dragon_girl/ender_dragon_girl.png")
	};

	public EnderDragonGirlRenderer(Context context) {
		super(context, new EnderDragonGirlModel(context.bakeLayer(ClientHandler.ENDER_DRAGON_GIRL)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new EnderDragonGirlEyesLayer(this));
	}

	@Override
	public Vec3 getRenderOffset(EnderDragonGirlRenderState state) {
		if (state.isScreaming) {
			double d0 = 0.02D;
			return new Vec3(this.random.nextGaussian() * d0, 0.0D, this.random.nextGaussian() * d0);
		} else {
			return super.getRenderOffset(state);
		}
	}

	@Override
	public EnderDragonGirlRenderState createRenderState() {
		return new EnderDragonGirlRenderState();
	}

	@Override
	public void extractRenderState(EnderDragonGirl entity, EnderDragonGirlRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isScreaming = entity.isScreaming();
	}

	@Override
	public Identifier getTextureLocation(EnderDragonGirlRenderState state) {
		return ENDER_DRAGON_GIRL_LOCATIONS[state.variant];
	}
}
