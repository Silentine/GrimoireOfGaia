package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ArachneModel;
import gaia.client.renderer.layer.ArachneEyesLayer;
import gaia.client.state.ArachneRenderState;
import gaia.entity.Arachne;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class ArachneRenderer extends MobRenderer<Arachne, ArachneRenderState, ArachneModel> {
	public static final Identifier[] ARACHNE_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/arachne/arachne.png")};

	public ArachneRenderer(Context context) {
		super(context, new ArachneModel(context.bakeLayer(ClientHandler.ARACHNE)), ClientHandler.largeShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new ArachneEyesLayer(this));
	}

	@Override
	public ArachneRenderState createRenderState() {
		return null;
	}

	@Override
	protected float getFlipDegrees() {
		return 180.0F;
	}

	@Override
	public Identifier getTextureLocation(ArachneRenderState renderState) {
		return ARACHNE_LOCATIONS[renderState.variant];
	}
}
