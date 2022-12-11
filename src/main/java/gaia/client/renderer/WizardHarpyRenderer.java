package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WizardHarpyModel;
import gaia.client.renderer.layer.WizardHarpyEyesLayer;
import gaia.entity.WizardHarpy;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class WizardHarpyRenderer extends MobRenderer<WizardHarpy, WizardHarpyModel> {
	public static final ResourceLocation[] WIZARD_HARPY_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/wizard_harpy/wizard_harpy.png")};

	public WizardHarpyRenderer(Context context) {
		super(context, new WizardHarpyModel(context.bakeLayer(ClientHandler.WIZARD_HARPY)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new WizardHarpyEyesLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(WizardHarpy shaman) {
		return WIZARD_HARPY_LOCATIONS[shaman.getVariant()];
	}
}
