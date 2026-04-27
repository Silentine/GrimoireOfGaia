package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MandragoraModel;
import gaia.client.state.MandragorarenderState;
import gaia.entity.Mandragora;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class MandragoraRenderer extends GaiaBabyMobRenderer<Mandragora, MandragorarenderState, MandragoraModel> {
	public static final Identifier[] MANDRAGORA_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/mandragora/mandragora.png")
	};

	public MandragoraRenderer(Context context) {
		super(context, new MandragoraModel(context.bakeLayer(ClientHandler.MANDRAGORA)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public MandragorarenderState createRenderState() {
		return new MandragorarenderState();
	}

	@Override
	public void extractRenderState(Mandragora entity, MandragorarenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(MandragorarenderState state) {
		return MANDRAGORA_LOCATIONS[state.variant];
	}
}
