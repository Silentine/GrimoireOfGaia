package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.YukiOnnaModel;
import gaia.client.state.YukiOnnaRenderState;
import gaia.entity.YukiOnna;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec3;

public class YukiOnnaRenderer extends GaiaBabyMobRenderer<YukiOnna, YukiOnnaRenderState, YukiOnnaModel> {
	public static final Identifier[] YUKI_ONNA_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/yuki_onna/yuki_onna.png")};

	public YukiOnnaRenderer(Context context) {
		super(context, new YukiOnnaModel(context.bakeLayer(ClientHandler.YUKI_ONNA)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public YukiOnnaRenderState createRenderState() {
		return new YukiOnnaRenderState();
	}

	@Override
	public void extractRenderState(YukiOnna entity, YukiOnnaRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isFleeing = entity.isFleeing();
		Vec3 movement = entity.getDeltaMovement();
		state.moving = movement.x * movement.x + movement.z * movement.z > 2.500000277905201E-7D;
	}

	@Override
	public Identifier getTextureLocation(YukiOnnaRenderState state) {
		return YUKI_ONNA_LOCATIONS[state.variant];
	}
}
