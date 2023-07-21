package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.BansheeModel;
import gaia.client.model.EnderGirlModel;
import gaia.entity.Banshee;
import gaia.entity.trader.EnderGirl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class EnderGirlEyeLayer extends EyesLayer<EnderGirl, EnderGirlModel> {
	private static final RenderType ENDER_GIRL_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_girl/eyes_ender_girl.png"));

	public EnderGirlEyeLayer(RenderLayerParent<EnderGirl, EnderGirlModel> layerParent) {
		super(layerParent);
	}

	public RenderType renderType() {
		return ENDER_GIRL_EYES;
	}
}
