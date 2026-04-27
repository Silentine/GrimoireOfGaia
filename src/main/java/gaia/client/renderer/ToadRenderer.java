package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ToadModel;
import gaia.client.state.ToadRenderState;
import gaia.entity.Toad;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class ToadRenderer extends MobRenderer<Toad, ToadRenderState, ToadModel> {
	public static final Identifier[] TOAD_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/toad/toad.png")};

	public ToadRenderer(Context context) {
		super(context, new ToadModel(context.bakeLayer(ClientHandler.TOAD)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ToadRenderState createRenderState() {
		return new ToadRenderState();
	}

	@Override
	public void extractRenderState(Toad entity, ToadRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isVehicle();
	}

	@Override
	public Identifier getTextureLocation(ToadRenderState state) {
		return TOAD_LOCATIONS[state.variant];
	}
}
