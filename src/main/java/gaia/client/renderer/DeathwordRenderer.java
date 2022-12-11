package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.DeathwordModel;
import gaia.entity.Deathword;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DeathwordRenderer extends MobRenderer<Deathword, DeathwordModel> {
	public static final ResourceLocation[] DEATHWORD_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/deathword/deathword.png")};

	public DeathwordRenderer(Context context) {
		super(context, new DeathwordModel(context.bakeLayer(ClientHandler.DEATHWORD)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(Deathword deathword) {
		return DEATHWORD_LOCATIONS[deathword.getVariant()];
	}
}
