package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CreepModel;
import gaia.client.renderer.layer.CreepPowerLayer;
import gaia.client.state.CreepRenderState;
import gaia.entity.Creep;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

public class CreepRenderer extends MobRenderer<Creep, CreepRenderState, CreepModel> {
	public static final Identifier[] CREEP_LOCATIONS = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/creep/creep.png")};

	public CreepRenderer(Context context) {
		super(context, new CreepModel(context.bakeLayer(ClientHandler.CREEP)), ClientHandler.smallShadow);
		this.addLayer(new CreepPowerLayer(this, context.getModelSet()));
	}

	@Override
	protected void scale(CreepRenderState state, PoseStack poseStack) {
		float g = state.swelling;
		float wobble = 1.0F + Mth.sin(g * 100.0F) * g * 0.01F;
		g = Mth.clamp(g, 0.0F, 1.0F);
		g *= g;
		g *= g;
		float s = (1.0F + g * 0.4F) * wobble;
		float hs = (1.0F + g * 0.1F) / wobble;
		poseStack.scale(s, hs, s);
	}

	@Override
	protected float getWhiteOverlayProgress(CreepRenderState state) {
		float step = state.swelling;
		return (int) (step * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(step, 0.5F, 1.0F);
	}

	public CreepRenderState createRenderState() {
		return new CreepRenderState();
	}

	public void extractRenderState(Creep entity, CreepRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.swelling = entity.getSwelling(partialTicks);
		state.powered = entity.isPowered();
	}

	@Override
	public Identifier getTextureLocation(CreepRenderState state) {
		return CREEP_LOCATIONS[state.variant];
	}
}
