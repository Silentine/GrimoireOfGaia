package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MermaidModel;
import gaia.client.state.MermaidRenderState;
import gaia.entity.Mermaid;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class MermaidRenderer extends MobRenderer<Mermaid, MermaidRenderState, MermaidModel> {
	public static final Identifier[] MERMAID_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/mermaid/mermaid01.png"),
			GrimoireOfGaia.modLoc("textures/entity/mermaid/mermaid02.png")};

	public MermaidRenderer(Context context) {
		super(context, new MermaidModel(context.bakeLayer(ClientHandler.MERMAID)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public MermaidRenderState createRenderState() {
		return new MermaidRenderState();
	}

	@Override
	public void extractRenderState(Mermaid entity, MermaidRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(MermaidRenderState state) {
		return MERMAID_LOCATIONS[state.variant];
	}
}
