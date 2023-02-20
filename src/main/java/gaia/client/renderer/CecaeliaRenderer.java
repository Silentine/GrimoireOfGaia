package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CecaeliaModel;
import gaia.entity.Cecaelia;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class CecaeliaRenderer extends MobRenderer<Cecaelia, CecaeliaModel> {
	public static final ResourceLocation[] CECAELIA_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/cecaelia/cecaelia.png")
	};

	public CecaeliaRenderer(Context context) {
		super(context, new CecaeliaModel(context.bakeLayer(ClientHandler.CECAELIA)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Cecaelia cecaelia) {
		return CECAELIA_LOCATIONS[cecaelia.getVariant()];
	}
}
