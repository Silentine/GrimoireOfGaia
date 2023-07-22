package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.AnubisModel;
import gaia.entity.Anubis;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class AnubisRenderer extends MobRenderer<Anubis, AnubisModel> {
	public static final ResourceLocation[] ANUBIS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/anubis/anubis.png")
	};
	public static final ResourceLocation[] ANUBIS_MALE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/anubis/anubis_male.png")
	};

	public AnubisRenderer(Context context) {
		super(context, new AnubisModel(context.bakeLayer(ClientHandler.ANUBIS)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Anubis anubis) {
		return anubis.isMale() ? ANUBIS_MALE_LOCATIONS[anubis.getVariant()] : ANUBIS_LOCATIONS[anubis.getVariant()];
	}
}
