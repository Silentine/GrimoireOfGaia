package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MinotaurusModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.entity.Minotaurus;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class MinotaurusRenderer extends MobRenderer<Minotaurus, MinotaurusModel> {
	public static final ResourceLocation[] MINOTAURUS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/minotaurus/minotaurus01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/minotaurus/minotaurus02.png")};

	public MinotaurusRenderer(Context context) {
		super(context, new MinotaurusModel(context.bakeLayer(ClientHandler.MINOTAURUS)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new AuraLayer<>(this, () -> new MinotaurusModel(context.bakeLayer(ClientHandler.MINOTAURUS))));
	}

	@Override
	public ResourceLocation getTextureLocation(Minotaurus minotaurus) {
		return MINOTAURUS_LOCATIONS[minotaurus.getVariant()];
	}
}
