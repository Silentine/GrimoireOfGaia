package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WitchModel;
import gaia.entity.Witch;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WitchRenderer extends MobRenderer<Witch, WitchModel> {
	public static final ResourceLocation[] WITCH_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/witch/witch01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/witch/witch02.png")};

	public WitchRenderer(Context context) {
		super(context, new WitchModel(context.bakeLayer(ClientHandler.WITCH)), ClientHandler.tinyShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(Witch witch) {
		return WITCH_LOCATIONS[witch.getVariant()];
	}
}
