package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MimicModel;
import gaia.entity.Mimic;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MimicRenderer extends MobRenderer<Mimic, MimicModel> {
	public static final ResourceLocation[] MIMIC_LOCATION = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mimic/mimic.png")
	};

	public MimicRenderer(Context context) {
		super(context, new MimicModel(context.bakeLayer(ClientHandler.MIMIC)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(Mimic mimic) {
		return MIMIC_LOCATION[mimic.getVariant()];
	}
}
