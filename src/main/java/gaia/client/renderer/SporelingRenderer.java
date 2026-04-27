package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SporelingModel;
import gaia.client.state.SporelingRenderState;
import gaia.entity.Sporeling;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class SporelingRenderer extends MobRenderer<Sporeling, SporelingRenderState, SporelingModel> {
	public static final Identifier[] SPORELING_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/sporeling/sporeling01.png"),
			GrimoireOfGaia.modLoc("textures/entity/sporeling/sporeling02.png")};

	public SporelingRenderer(Context context) {
		super(context, new SporelingModel(context.bakeLayer(ClientHandler.SPORELING)), ClientHandler.tinyShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
	}

	@Override
	public SporelingRenderState createRenderState() {
		return new SporelingRenderState();
	}

	@Override
	public void extractRenderState(Sporeling entity, SporelingRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	protected void scale(SporelingRenderState state, PoseStack poseStack) {
		poseStack.scale(0.5F, 0.5F, 0.5F);
	}

	@Override
	public Identifier getTextureLocation(SporelingRenderState state) {
		return SPORELING_LOCATIONS[state.variant];
	}
}
