package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SlimeGirlModel;
import gaia.client.renderer.layer.SlimeGirlHairLayer;
import gaia.client.state.SlimeGirlRenderState;
import gaia.entity.trader.SlimeGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class SlimeGirlRenderer extends MobRenderer<SlimeGirl, SlimeGirlRenderState, SlimeGirlModel> {
	public static final Identifier CREEPER_GIRL_LOCATION = GrimoireOfGaia.modLoc("textures/entity/slime_girl/slime_girl.png");

	public SlimeGirlRenderer(Context context) {
		super(context, new SlimeGirlModel(context.bakeLayer(ClientHandler.SLIME_GIRL)), ClientHandler.medShadow);
		this.addLayer(new SlimeGirlHairLayer(this, context.getModelSet()));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public SlimeGirlRenderState createRenderState() {
		return new SlimeGirlRenderState();
	}

	@Override
	public void extractRenderState(SlimeGirl entity, SlimeGirlRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, this.itemModelResolver, partialTicks);
		state.isRiding = entity.isPassenger();
	}

	@Override
	public Identifier getTextureLocation(SlimeGirlRenderState state) {
		return CREEPER_GIRL_LOCATION;
	}
}
