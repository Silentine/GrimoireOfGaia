package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SuccubusModel;
import gaia.entity.Succubus;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SuccubusRenderer extends MobRenderer<Succubus, SuccubusModel> {
	public static final ResourceLocation[] SUCCUBUS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/succubus/succubus.png")};
	public static final ResourceLocation[] SUCCUBUS_MALE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/succubus/succubus_male.png")};

	public SuccubusRenderer(Context context) {
		super(context, new SuccubusModel(context.bakeLayer(ClientHandler.SUCCUBUS)), ClientHandler.smallShadow);
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Succubus succubus) {
		return succubus.isMale() ? SUCCUBUS_MALE_LOCATIONS[succubus.getVariant()] : SUCCUBUS_LOCATIONS[succubus.getVariant()];
	}
}
