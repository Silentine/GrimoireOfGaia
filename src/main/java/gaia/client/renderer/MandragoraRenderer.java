package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MandragoraModel;
import gaia.entity.Mandragora;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class MandragoraRenderer extends GaiaBabyMobRenderer<Mandragora, MandragoraModel> {
	public static final ResourceLocation[] MANDRAGORA_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mandragora/mandragora.png")
	};

	public MandragoraRenderer(Context context) {
		super(context, new MandragoraModel(context.bakeLayer(ClientHandler.MANDRAGORA)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Mandragora mandragora) {
		return MANDRAGORA_LOCATIONS[mandragora.getVariant()];
	}
}
