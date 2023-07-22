package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SlimeGirlModel;
import gaia.client.renderer.layer.SlimeGirlHairLayer;
import gaia.entity.trader.SlimeGirl;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SlimeGirlRenderer extends MobRenderer<SlimeGirl, SlimeGirlModel> {
	public static final ResourceLocation CREEPER_GIRL_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/slime_girl/slime_girl.png");

	public SlimeGirlRenderer(Context context) {
		super(context, new SlimeGirlModel(context.bakeLayer(ClientHandler.SLIME_GIRL)), ClientHandler.medShadow);
		this.addLayer(new SlimeGirlHairLayer(this, context.getModelSet()));
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(SlimeGirl slimeGirl) {
		return CREEPER_GIRL_LOCATION;
	}
}
