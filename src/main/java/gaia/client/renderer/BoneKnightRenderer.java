package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BoneKnightModel;
import gaia.client.state.BoneKnightRenderState;
import gaia.entity.BoneKnight;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class BoneKnightRenderer extends MobRenderer<BoneKnight, BoneKnightRenderState, BoneKnightModel> {
	public static final Identifier[] BONE_KNIGHT_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/bone_knight/bone_knight.png")};

	public BoneKnightRenderer(Context context) {
		super(context, new BoneKnightModel(context.bakeLayer(ClientHandler.BONE_KNIGHT)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public BoneKnightRenderState createRenderState() {
		return new BoneKnightRenderState();
	}

	@Override
	public void extractRenderState(BoneKnight entity, BoneKnightRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(BoneKnightRenderState renderState) {
		return BONE_KNIGHT_LOCATIONS[renderState.variant];
	}
}
