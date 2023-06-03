package gaia.client.renderer.prop;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.prop.CyanFlowerModel;
import gaia.entity.prop.CyanFlower;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CyanFlowerRenderer extends MobRenderer<CyanFlower, CyanFlowerModel> {
	public static final ResourceLocation CYAN_FLOWER_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mandragora/mandragora_flower.png");

	public CyanFlowerRenderer(EntityRendererProvider.Context context) {
		super(context, new CyanFlowerModel(context.bakeLayer(ClientHandler.CYAN_FLOWER)), 0.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(CyanFlower cyanFlower) {
		return CYAN_FLOWER_LOCATION;
	}
}
