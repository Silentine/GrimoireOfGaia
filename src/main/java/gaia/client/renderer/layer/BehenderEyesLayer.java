package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.BehenderModel;
import gaia.entity.Behender;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class BehenderEyesLayer extends EyesLayer<Behender, BehenderModel> {
	private static final RenderType BEHENDER_EYE_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/behender/eyes_beholder.png"));

	public BehenderEyesLayer(RenderLayerParent<Behender, BehenderModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return BEHENDER_EYE_EYES;
	}
}