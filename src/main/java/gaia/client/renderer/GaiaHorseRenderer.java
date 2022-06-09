package gaia.client.renderer;

import gaia.client.ClientHandler;
import gaia.entity.GaiaHorse;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class GaiaHorseRenderer extends AbstractHorseRenderer<GaiaHorse, HorseModel<GaiaHorse>> {
	private static final ResourceLocation LOCATION = new ResourceLocation("textures/entity/horse/horse_zombie.png");

	public GaiaHorseRenderer(EntityRendererProvider.Context context) {
		super(context, new HorseModel<>(context.bakeLayer(ClientHandler.HORSE)), 1.0F);
	}

	public ResourceLocation getTextureLocation(GaiaHorse horse) {
		return LOCATION;
	}
}
