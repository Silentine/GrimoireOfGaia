package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.BansheeModel;
import gaia.entity.Banshee;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class BansheeGlowLayer extends EyesLayer<Banshee, BansheeModel> {
	private static final RenderType BANSHEE = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/banshee/banshee.png"));

	public BansheeGlowLayer(RenderLayerParent<Banshee, BansheeModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return BANSHEE;
	}
}
