package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.FleshLichModel;
import gaia.entity.FleshLich;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class FleshLichRenderer extends MobRenderer<FleshLich, FleshLichModel> {
	public static final ResourceLocation[] FLESH_LICH_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/flesh_lich/flesh_lich.png")};

	public FleshLichRenderer(Context context) {
		super(context, new FleshLichModel(context.bakeLayer(ClientHandler.FLESH_LICH)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(FleshLich fleshLich) {
		return FLESH_LICH_LOCATIONS[fleshLich.getVariant()];
	}
}
