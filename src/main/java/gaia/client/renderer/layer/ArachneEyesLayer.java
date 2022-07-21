package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.ArachneModel;
import gaia.entity.Arachne;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class ArachneEyesLayer extends EyesLayer<Arachne, ArachneModel> {
	private static final RenderType ARACHNE_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/arachne/arachne_eyes.png"));

	public ArachneEyesLayer(RenderLayerParent<Arachne, ArachneModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return ARACHNE_EYES;
	}
}
