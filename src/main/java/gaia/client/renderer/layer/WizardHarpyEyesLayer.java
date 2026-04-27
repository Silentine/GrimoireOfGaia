package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.WizardHarpyModel;
import gaia.client.state.WizardHarpyRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;

public class WizardHarpyEyesLayer extends EyesLayer<WizardHarpyRenderState, WizardHarpyModel> {
	private static final RenderType WIZARD_HARPY_EYES = RenderTypes.eyes(GrimoireOfGaia.modLoc("textures/entity/wizard_harpy/wizard_harpy_eyes.png"));

	public WizardHarpyEyesLayer(RenderLayerParent<WizardHarpyRenderState, WizardHarpyModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return WIZARD_HARPY_EYES;
	}
}
