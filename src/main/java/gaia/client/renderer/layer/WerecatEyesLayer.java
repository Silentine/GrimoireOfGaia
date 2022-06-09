package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.WerecatModel;
import gaia.entity.Werecat;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class WerecatEyesLayer extends EyesLayer<Werecat, WerecatModel> {
	private static final RenderType WERECAT_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/werecat/eyes_werecat.png"));

	public WerecatEyesLayer(RenderLayerParent<Werecat, WerecatModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return WERECAT_EYES;
	}
}