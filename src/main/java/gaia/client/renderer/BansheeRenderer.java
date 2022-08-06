package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BansheeModel;
import gaia.client.renderer.layer.BansheeGlowLayer;
import gaia.entity.Banshee;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class BansheeRenderer extends MobRenderer<Banshee, BansheeModel> {
	public static final ResourceLocation[] BANSHEE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/banshee/banshee.png")};

	public BansheeRenderer(Context context) {
		super(context, new BansheeModel(context.bakeLayer(ClientHandler.BANSHEE)), ClientHandler.smallShadow);
		this.addLayer(new BansheeGlowLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Banshee banshee) {
		return BANSHEE_LOCATIONS[banshee.getVariant()];
	}
}
