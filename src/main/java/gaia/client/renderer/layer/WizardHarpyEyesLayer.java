package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.WizardHarpyModel;
import gaia.entity.WizardHarpy;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class WizardHarpyEyesLayer extends EyesLayer<WizardHarpy, WizardHarpyModel> {
	private static final RenderType WIZARD_HARPY_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/wizard_harpy/wizard_harpy_eyes.png"));

	public WizardHarpyEyesLayer(RenderLayerParent<WizardHarpy, WizardHarpyModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return WIZARD_HARPY_EYES;
	}
}
