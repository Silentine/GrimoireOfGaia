package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CobbleGolemModel;
import gaia.entity.CobbleGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CobbleGolemRenderer extends MobRenderer<CobbleGolem, CobbleGolemModel> {
	public static final ResourceLocation[] COBBLE_GOLEM_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/cobble_golem/cobble_golem.png")};

	public CobbleGolemRenderer(Context context) {
		super(context, new CobbleGolemModel(context.bakeLayer(ClientHandler.COBBLE_GOLEM)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(CobbleGolem cobbleGolem) {
		return COBBLE_GOLEM_LOCATIONS[cobbleGolem.getVariant()];
	}
}
