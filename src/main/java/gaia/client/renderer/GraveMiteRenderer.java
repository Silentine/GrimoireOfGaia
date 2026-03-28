package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GraveMiteModel;
import gaia.client.state.GraveMiteRenderState;
import gaia.entity.GraveMite;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class GraveMiteRenderer extends MobRenderer<GraveMite, GraveMiteRenderState, GraveMiteModel> {
	private static final Identifier LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/mummy/mummy_mite.png");

	public GraveMiteRenderer(EntityRendererProvider.Context context) {
		super(context, new GraveMiteModel(context.bakeLayer(ClientHandler.GRAVEMITE)), 0.3F);
	}

	@Override
	public GraveMiteRenderState createRenderState() {
		return new GraveMiteRenderState();
	}

	@Override
	protected void scale(GraveMiteRenderState state, PoseStack poseStack) {
		poseStack.scale(1.0F, 1.0F, 1.0F);
		super.scale(state, poseStack);
	}

	public Identifier getTextureLocation(GraveMiteRenderState renderState) {
		return LOCATION;
	}
}
