package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.AntSalvagerModel;
import gaia.client.state.AntSalvagerRenderState;
import gaia.entity.AntSalvager;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class AntSalvagerRenderer extends MobRenderer<AntSalvager, AntSalvagerRenderState, AntSalvagerModel> {
	public static final Identifier[] ANT_SALVAGER_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/ant/ant_salvager.png")};

	public AntSalvagerRenderer(Context context) {
		super(context, new AntSalvagerModel(context.bakeLayer(ClientHandler.ANT_SALVAGER)), ClientHandler.smallShadow);
	}

	@Override
	public AntSalvagerRenderState createRenderState() {
		return new AntSalvagerRenderState();
	}

	@Override
	public void extractRenderState(AntSalvager entity, AntSalvagerRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	public Identifier getTextureLocation(AntSalvagerRenderState renderState) {
		return ANT_SALVAGER_LOCATIONS[renderState.variant];
	}
}
