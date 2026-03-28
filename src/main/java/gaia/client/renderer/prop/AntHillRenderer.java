package gaia.client.renderer.prop;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.prop.AntHillModel;
import gaia.client.state.AntHillRenderState;
import gaia.entity.prop.AntHill;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class AntHillRenderer extends MobRenderer<AntHill, AntHillRenderState, AntHillModel> {
	public static final Identifier ANT_HILL_LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/prop/ant_hill/ant_hill.png");

	public AntHillRenderer(Context context) {
		super(context, new AntHillModel(context.bakeLayer(ClientHandler.ANT_HILL)), 0.0F);
	}

	@Override
	public AntHillRenderState createRenderState() {
		return new AntHillRenderState();
	}

	@Override
	public void extractRenderState(AntHill entity, AntHillRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.spawnAmount = entity.getSpawnAmount();
	}

	@Override
	public Identifier getTextureLocation(AntHillRenderState state) {
		return ANT_HILL_LOCATION;
	}
}
