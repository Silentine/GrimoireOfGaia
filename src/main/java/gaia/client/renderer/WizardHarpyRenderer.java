package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WizardHarpyModel;
import gaia.client.renderer.layer.WizardHarpyEyesLayer;
import gaia.client.state.WizardHarpyRenderState;
import gaia.entity.WizardHarpy;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.Identifier;

public class WizardHarpyRenderer extends MobRenderer<WizardHarpy, WizardHarpyRenderState, WizardHarpyModel> {
	public static final Identifier[] WIZARD_HARPY_LOCATIONS = new Identifier[]{
			Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/wizard_harpy/wizard_harpy.png")};

	public WizardHarpyRenderer(Context context) {
		super(context, new WizardHarpyModel(context.bakeLayer(ClientHandler.WIZARD_HARPY)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getPlayerSkinRenderCache()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new WizardHarpyEyesLayer(this));
	}

	@Override
	public WizardHarpyRenderState createRenderState() {
		return new WizardHarpyRenderState();
	}

	@Override
	public void extractRenderState(WizardHarpy entity, WizardHarpyRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
		state.isRiding = entity.isPassenger();
		state.animationState = entity.getAnimationState();
	}

	@Override
	public Identifier getTextureLocation(WizardHarpyRenderState state) {
		return WIZARD_HARPY_LOCATIONS[state.variant];
	}
}
