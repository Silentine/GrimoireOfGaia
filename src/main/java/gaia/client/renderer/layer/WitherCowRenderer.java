package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WitherCowModel;
import gaia.entity.WitherCow;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WitherCowRenderer extends MobRenderer<WitherCow, WitherCowModel> {
	public static final ResourceLocation[] WITHER_COW_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/wither_cow/wither_cow.png")};

	public WitherCowRenderer(Context context) {
		super(context, new WitherCowModel(context.bakeLayer(ClientHandler.WITHER_COW)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(WitherCow witherCow) {
		return WITHER_COW_LOCATIONS[witherCow.getVariant()];
	}
}
