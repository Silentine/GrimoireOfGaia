package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DullahanModel;
import gaia.client.state.DullahanRenderState;
import gaia.entity.Dullahan;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class DullahanRenderer extends MobRenderer<Dullahan, DullahanRenderState, DullahanModel> {
	public static final Identifier[] DULLAHAN_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/dullahan/dullahan.png")};

	public DullahanRenderer(Context context) {
		super(context, new DullahanModel(context.bakeLayer(ClientHandler.DULLAHAN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public DullahanRenderState createRenderState() {
		return new DullahanRenderState();
	}

	@Override
	public void extractRenderState(Dullahan entity, DullahanRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(DullahanRenderState renderState) {
		return DULLAHAN_LOCATIONS[renderState.variant];
	}
}
