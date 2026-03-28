package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GelatinousSlimeModel;
import gaia.client.renderer.layer.GelatinousSlimeLayer;
import gaia.client.renderer.layer.SlimeItemLayer;
import gaia.client.state.GelatinousSlimeRenderState;
import gaia.entity.GelatinousSlime;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;

public class GelatinousSlimeRenderer extends MobRenderer<GelatinousSlime, GelatinousSlimeRenderState, GelatinousSlimeModel> {
	public static final Identifier[] GELATINOUS_SLIME_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/gelatinous_slime/gelatinous_slime.png")};

	public GelatinousSlimeRenderer(Context context) {
		super(context, new GelatinousSlimeModel(context.bakeLayer(ClientHandler.GELATINOUS_SLIME)), ClientHandler.smallShadow);
		this.addLayer(new GelatinousSlimeLayer(this, context.getModelSet()));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new SlimeItemLayer(this));
	}

	@Override
	protected void scale(GelatinousSlimeRenderState state, PoseStack poseStack) {
		float s = 0.999F;
		poseStack.scale(s, s, s);
		poseStack.translate(0.0F, 0.001F, 0.0F);
		float ss = state.squish / (1 * 0.5F + 1.0F);
		float w = 1.0F / (ss + 1.0F);
		poseStack.scale(w, 1.0F / w, w);
	}

	@Override
	public GelatinousSlimeRenderState createRenderState() {
		return new GelatinousSlimeRenderState();
	}

	@Override
	public void extractRenderState(GelatinousSlime entity, GelatinousSlimeRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.squish = Mth.lerp(partialTicks, entity.oSquish, entity.squish);
		itemModelResolver.updateForLiving(state.mainItemRenderState, entity.getMainHandItem(), ItemDisplayContext.GROUND, entity);
	}

	@Override
	public Identifier getTextureLocation(GelatinousSlimeRenderState renderState) {
		return GELATINOUS_SLIME_LOCATIONS[renderState.variant];
	}
}
