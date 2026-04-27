package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GoblinModel;
import gaia.client.state.GoblinRenderState;
import gaia.entity.GoblinFeral;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class GoblinFeralRenderer extends MobRenderer<GoblinFeral, GoblinRenderState, GoblinModel> {
	public static final Identifier[] GOBLIN_FERAL_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/goblin/goblin_feral01.png"),
			GrimoireOfGaia.modLoc("textures/entity/goblin/goblin_feral02.png"),
			GrimoireOfGaia.modLoc("textures/entity/goblin/goblin_feral03.png")};

	public GoblinFeralRenderer(Context context) {
		super(context, new GoblinModel(context.bakeLayer(ClientHandler.GOBLIN_FERAL)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public GoblinRenderState createRenderState() {
		return new GoblinRenderState();
	}

	@Override
	protected void scale(GoblinRenderState state, PoseStack poseStack) {
		float g = state.swelling;
		float wobble = 1.0F + Mth.sin(g * 100.0F) * g * 0.01F;
		g = Mth.clamp(g, 0.0F, 1.0F);
		g *= g;
		g *= g;
		float s = (1.0F + g * 0.4F) * wobble;
		float hs = (1.0F + g * 0.1F) / wobble;
		poseStack.scale(s, hs, s);
	}

	@Override
	protected float getWhiteOverlayProgress(GoblinRenderState state) {
		float step = state.swelling;
		return (int) (step * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(step, 0.5F, 1.0F);
	}

	@Override
	public void extractRenderState(GoblinFeral entity, GoblinRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isAggresive = entity.isAggressive();
		state.swelling = entity.getSwelling(partialTicks);
	}

	@Override
	public Identifier getTextureLocation(GoblinRenderState renderState) {
		return GOBLIN_FERAL_LOCATIONS[renderState.variant];
	}
}
