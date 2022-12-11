package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GoblinModel;
import gaia.entity.Goblin;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class GoblinRenderer extends MobRenderer<Goblin, GoblinModel<Goblin>> {
	public static final ResourceLocation[] GOBLIN_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/goblin/goblin01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/goblin/goblin02.png")};

	public GoblinRenderer(Context context) {
		super(context, new GoblinModel(context.bakeLayer(ClientHandler.GOBLIN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Goblin goblin) {
		return GOBLIN_LOCATIONS[goblin.getVariant()];
	}
}
