package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WitchModel;
import gaia.client.renderer.layer.GaiaItemInHandLayer;
import gaia.entity.Witch;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;

public class WitchRenderer extends MobRenderer<Witch, WitchModel> {
	public static final ResourceLocation[] WITCH_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/witch/witch01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/witch/witch02.png")};

	public WitchRenderer(Context context) {
		super(context, new WitchModel(context.bakeLayer(ClientHandler.WITCH)), ClientHandler.tinyShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new GaiaItemInHandLayer<>(this, HumanoidArm.RIGHT, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Witch witch) {
		return WITCH_LOCATIONS[witch.getVariant()];
	}
}
