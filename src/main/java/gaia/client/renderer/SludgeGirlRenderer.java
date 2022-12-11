package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SludgeGirlModel;
import gaia.client.renderer.layer.SludgeHairLayer;
import gaia.entity.SludgeGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;

public class SludgeGirlRenderer extends MobRenderer<SludgeGirl, SludgeGirlModel> {
	public static final ResourceLocation[] SLUDGE_GIRL_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/sludge_girl01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/sludge_girl02.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/sludge_girl03.png")};

	public SludgeGirlRenderer(Context context) {
		super(context, new SludgeGirlModel(context.bakeLayer(ClientHandler.SLUDGE_GIRL)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new SludgeHairLayer(this, context.getModelSet()));
	}

	@Override
	public ResourceLocation getTextureLocation(SludgeGirl sludgeGirl) {
		return SLUDGE_GIRL_LOCATIONS[sludgeGirl.getVariant()];
	}
}
