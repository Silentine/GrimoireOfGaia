package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.EnderGirlModel;
import gaia.client.renderer.layer.EnderGirlEyeLayer;
import gaia.client.state.EnderGirlRenderState;
import gaia.entity.trader.EnderGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class EnderGirlRenderer extends MobRenderer<EnderGirl, EnderGirlRenderState, EnderGirlModel> {
	public static final Identifier ENDER_GIRL_LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/ender_girl/ender_girl.png");

	public EnderGirlRenderer(Context context) {
		super(context, new EnderGirlModel(context.bakeLayer(ClientHandler.ENDER_GIRL)), ClientHandler.medShadow);
		this.addLayer(new EnderGirlEyeLayer(this));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public EnderGirlRenderState createRenderState() {
		return new EnderGirlRenderState();
	}

	@Override
	public void extractRenderState(EnderGirl entity, EnderGirlRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(EnderGirlRenderState renderState) {
		return ENDER_GIRL_LOCATION;
	}
}
