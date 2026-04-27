package gaia.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.state.GryphonRenderState;
import gaia.entity.Gryphon;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class GryphonRenderer extends MobRenderer<Gryphon, GryphonRenderState, GryphonModel> {
	public static final Identifier[] GRYPHON_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/gryphon/gryphon.png")};

	public GryphonRenderer(Context context) {
		super(context, new GryphonModel(context.bakeLayer(ClientHandler.GRYPHON)), ClientHandler.largeShadow);
	}

	@Override
	public GryphonRenderState createRenderState() {
		return new GryphonRenderState();
	}

	@Override
	public void extractRenderState(Gryphon entity, GryphonRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	protected void scale(GryphonRenderState state, PoseStack poseStack) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public Identifier getTextureLocation(GryphonRenderState renderState) {
		return GRYPHON_LOCATIONS[renderState.variant];
	}
}
