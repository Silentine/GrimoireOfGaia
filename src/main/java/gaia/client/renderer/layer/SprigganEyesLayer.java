package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.SprigganModel;
import gaia.entity.Spriggan;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class SprigganEyesLayer extends EyesLayer<Spriggan, SprigganModel> {
	private static final RenderType SPRIGGAN_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/spriggan/eyes_spriggan.png"));

	public SprigganEyesLayer(RenderLayerParent<Spriggan, SprigganModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return SPRIGGAN_EYES;
	}
}