package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.AntSalvagerModel;
import gaia.entity.AntSalvager;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AntSalvagerRenderer extends MobRenderer<AntSalvager, AntSalvagerModel> {
	public static final ResourceLocation[] ANT_SALVAGER_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/ant/ant_salvager.png")};

	public AntSalvagerRenderer(Context context) {
		super(context, new AntSalvagerModel(context.bakeLayer(ClientHandler.ANT_SALVAGER)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(AntSalvager antSalvager) {
		return ANT_SALVAGER_LOCATIONS[antSalvager.getVariant()];
	}
}
