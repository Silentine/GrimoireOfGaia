package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MummyModel;
import gaia.client.state.MummyRenderState;
import gaia.entity.Mummy;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class MummyRenderer extends MobRenderer<Mummy, MummyRenderState, MummyModel> {
	public static final Identifier[] MUMMY_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/mummy/mummy.png")
	};

	public MummyRenderer(Context context) {
		super(context, new MummyModel(context.bakeLayer(ClientHandler.MUMMY)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public MummyRenderState createRenderState() {
		return new MummyRenderState();
	}

	@Override
	public void extractRenderState(Mummy entity, MummyRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isAggressive = entity.isAggressive();
	}

	@Override
	public Identifier getTextureLocation(MummyRenderState renderState) {
		return MUMMY_LOCATIONS[renderState.variant];
	}
}
