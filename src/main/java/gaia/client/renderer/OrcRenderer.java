package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.OrcModel;
import gaia.entity.Orc;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class OrcRenderer extends MobRenderer<Orc, OrcModel> {
	public static final ResourceLocation[] ORC_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/orc/orc01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/orc/orc02.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/orc/orc03.png")};

	public OrcRenderer(Context context) {
		super(context, new OrcModel(context.bakeLayer(ClientHandler.ORC)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Orc orc) {
		return ORC_LOCATIONS[orc.getVariant()];
	}
}
