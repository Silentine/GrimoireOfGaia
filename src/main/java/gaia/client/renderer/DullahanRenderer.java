package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DullahanModel;
import gaia.entity.Dullahan;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class DullahanRenderer extends MobRenderer<Dullahan, DullahanModel> {
	public static final ResourceLocation[] DULLAHAN_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/dullahan/dullahan.png")};

	public DullahanRenderer(Context context) {
		super(context, new DullahanModel(context.bakeLayer(ClientHandler.DULLAHAN)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Dullahan dullahan) {
		return DULLAHAN_LOCATIONS[dullahan.getVariant()];
	}
}
