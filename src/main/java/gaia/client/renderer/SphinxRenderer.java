package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SphinxModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.client.state.SphinxRenderState;
import gaia.entity.Sphinx;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.Identifier;

public class SphinxRenderer extends MobRenderer<Sphinx, SphinxRenderState, SphinxModel> {
	public static final Identifier[] SPHINX_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sphinx/sphinx.png")
	};

	public SphinxRenderer(Context context) {
		super(context, new SphinxModel(context.bakeLayer(ClientHandler.SPHINX)), ClientHandler.largeShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new AuraLayer<>(this, () -> new SphinxModel(context.bakeLayer(ClientHandler.SPHINX))));
	}

	@Override
	public SphinxRenderState createRenderState() {
		return new SphinxRenderState();
	}

	@Override
	public void extractRenderState(Sphinx entity, SphinxRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.powered = entity.isPowered();
	}

	@Override
	protected void scale(SphinxRenderState state, PoseStack poseStack) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public Identifier getTextureLocation(SphinxRenderState state) {
		return SPHINX_LOCATIONS[state.variant];
	}
}
