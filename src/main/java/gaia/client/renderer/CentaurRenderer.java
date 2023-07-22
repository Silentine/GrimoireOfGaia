package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CentaurModel;
import gaia.entity.Centaur;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class CentaurRenderer extends MobRenderer<Centaur, CentaurModel> {
	public static final ResourceLocation[] CENTAUR_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur02.png")
	};
	public static final ResourceLocation[] CENTAUR_MALE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur01_male.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/centaur/centaur02_male.png")
	};

	public CentaurRenderer(Context context) {
		super(context, new CentaurModel(context.bakeLayer(ClientHandler.CENTAUR)), ClientHandler.medShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Centaur centaur) {
		return centaur.isMale() ? CENTAUR_MALE_LOCATIONS[centaur.getVariant()] : CENTAUR_LOCATIONS[centaur.getVariant()];
	}
}
