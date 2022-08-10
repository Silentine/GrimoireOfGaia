package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CobblestoneGolemModel;
import gaia.entity.CobblestoneGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CobblestoneGolemRenderer extends MobRenderer<CobblestoneGolem, CobblestoneGolemModel> {
	public static final ResourceLocation[] COBBLESTONE_GOLEM_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/cobblestone_golem/cobblestone_golem.png")};

	public CobblestoneGolemRenderer(Context context) {
		super(context, new CobblestoneGolemModel(context.bakeLayer(ClientHandler.COBBLE_GOLEM)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(CobblestoneGolem cobbleGolem) {
		return COBBLESTONE_GOLEM_LOCATIONS[cobbleGolem.getVariant()];
	}
}
