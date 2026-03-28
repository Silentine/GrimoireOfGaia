package gaia.client.renderer;

import gaia.client.ClientHandler;
import gaia.client.state.GaiaHorseRenderState;
import gaia.entity.GaiaHorse;
import net.minecraft.client.model.animal.equine.BabyHorseModel;
import net.minecraft.client.model.animal.equine.HorseModel;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class GaiaHorseRenderer extends AbstractHorseRenderer<GaiaHorse, GaiaHorseRenderState, HorseModel> {
	private static final Identifier LOCATION = Identifier.parse("textures/entity/horse/horse_zombie.png");

	public GaiaHorseRenderer(EntityRendererProvider.Context context) {
		super(context, new HorseModel(context.bakeLayer(ClientHandler.HORSE)), new BabyHorseModel(context.bakeLayer(ClientHandler.HORSE)));
	}

	@Override
	public GaiaHorseRenderState createRenderState() {
		return new GaiaHorseRenderState();
	}

	@Override
	public void extractRenderState(GaiaHorse entity, GaiaHorseRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(GaiaHorseRenderState state) {
		return LOCATION;
	}
}
