package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BeeModel;
import gaia.entity.Bee;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class BeeRenderer extends MobRenderer<Bee, BeeModel> {
	public static final ResourceLocation[] BEE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/bee/bee.png")};

	public BeeRenderer(Context context) {
		super(context, new BeeModel(context.bakeLayer(ClientHandler.BEE)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Bee bee) {
		return BEE_LOCATIONS[bee.getVariant()];
	}
}
