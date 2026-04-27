package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GoblinModel;
import gaia.client.state.GoblinRenderState;
import gaia.entity.Goblin;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class GoblinRenderer extends MobRenderer<Goblin, GoblinRenderState, GoblinModel> {
	public static final Identifier[] GOBLIN_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/goblin/goblin01.png"),
			GrimoireOfGaia.modLoc("textures/entity/goblin/goblin02.png")};

	public GoblinRenderer(Context context) {
		super(context, new GoblinModel(context.bakeLayer(ClientHandler.GOBLIN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public GoblinRenderState createRenderState() {
		return new GoblinRenderState();
	}

	@Override
	public void extractRenderState(Goblin entity, GoblinRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
		state.isAggresive = entity.isAggressive();
	}

	@Override
	public Identifier getTextureLocation(GoblinRenderState renderState) {
		return GOBLIN_LOCATIONS[renderState.variant];
	}
}
