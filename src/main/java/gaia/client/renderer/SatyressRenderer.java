package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SatyressModel;
import gaia.entity.Satyress;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SatyressRenderer extends MobRenderer<Satyress, SatyressModel> {
	public static final ResourceLocation[] DRYAD_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/satyress/satyress01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/satyress/satyress02.png")};

	public SatyressRenderer(Context context) {
		super(context, new SatyressModel(context.bakeLayer(ClientHandler.SATYRESS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Satyress dryad) {
		return DRYAD_LOCATIONS[dryad.getVariant()];
	}
}
