package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.EnderDragonGirlModel;
import gaia.entity.EnderDragonGirl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class EnderDragonGirlEyesLayer extends EyesLayer<EnderDragonGirl, EnderDragonGirlModel> {
	private static final RenderType ENDER_DRAGON_GIRL_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ender_dragon_girl/eyes_ender_dragon_girl.png"));

	public EnderDragonGirlEyesLayer(RenderLayerParent<EnderDragonGirl, EnderDragonGirlModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return ENDER_DRAGON_GIRL_EYES;
	}
}