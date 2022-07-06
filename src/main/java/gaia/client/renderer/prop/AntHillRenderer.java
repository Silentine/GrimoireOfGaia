package gaia.client.renderer.prop;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.AntHillModel;
import gaia.entity.prop.AntHill;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AntHillRenderer extends MobRenderer<AntHill, AntHillModel> {
	public static final ResourceLocation ANT_HILL_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/prop/ant_hill/ant_hill.png");

	public AntHillRenderer(Context context) {
		super(context, new AntHillModel(context.bakeLayer(ClientHandler.ANT_HILL)), 0.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(AntHill antHill) {
		return ANT_HILL_LOCATION;
	}
}
