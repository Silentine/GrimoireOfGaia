package gaia.client.renderer.prop;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.prop.ChestModel;
import gaia.entity.prop.AntHill;
import gaia.entity.prop.Chest;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ChestRenderer extends MobRenderer<Chest, ChestModel> {
	public static final ResourceLocation CHEST_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mimic/mimic_chest.png");
	public static final ResourceLocation LOOTR_LOCATION = new ResourceLocation("lootr", "textures/chest.png");

	public ChestRenderer(Context context) {
		super(context, new ChestModel(context.bakeLayer(ClientHandler.CHEST)), 0.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(Chest chest) {
		return CHEST_LOCATION;
	}
}
