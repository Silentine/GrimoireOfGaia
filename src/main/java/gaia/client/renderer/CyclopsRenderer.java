package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CyclopsModel;
import gaia.entity.Cyclops;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class CyclopsRenderer extends MobRenderer<Cyclops, CyclopsModel> {
	public static final ResourceLocation[] CYCLOPS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/cyclops/cyclops.png")};

	public CyclopsRenderer(Context context) {
		super(context, new CyclopsModel(context.bakeLayer(ClientHandler.CYCLOPS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Cyclops cyclops) {
		return CYCLOPS_LOCATIONS[cyclops.getVariant()];
	}
}
