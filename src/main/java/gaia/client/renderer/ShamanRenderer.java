package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ShamanModel;
import gaia.entity.Shaman;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class ShamanRenderer extends MobRenderer<Shaman, ShamanModel> {
	public static final ResourceLocation[] SHAMAN_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/shaman/shaman.png")};

	public ShamanRenderer(Context context) {
		super(context, new ShamanModel(context.bakeLayer(ClientHandler.SHAMAN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Shaman shaman) {
		return SHAMAN_LOCATIONS[shaman.getVariant()];
	}
}
