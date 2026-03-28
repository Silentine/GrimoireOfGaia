package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SirenModel;
import gaia.client.state.SirenRenderState;
import gaia.entity.Siren;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class SirenRenderer extends MobRenderer<Siren, SirenRenderState, SirenModel> {
	public static final Identifier[] SIREN_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/siren/siren.png"),
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/siren/siren_halloween.png")};

	public SirenRenderer(Context context) {
		super(context, new SirenModel(context.bakeLayer(ClientHandler.SIREN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public SirenRenderState createRenderState() {
		return new SirenRenderState();
	}

	@Override
	public void extractRenderState(Siren entity, SirenRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.isAggressive = entity.isAggressive();
	}

	@Override
	public Identifier getTextureLocation(SirenRenderState state) {
		return SIREN_LOCATIONS[state.variant];
	}
}
