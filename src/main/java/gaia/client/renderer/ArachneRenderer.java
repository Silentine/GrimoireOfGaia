package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.ArachneModel;
import gaia.client.renderer.layer.ArachneEyesLayer;
import gaia.entity.Arachne;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class ArachneRenderer extends MobRenderer<Arachne, ArachneModel> {
	public static final ResourceLocation[] ARACHNE_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/arachne/arachne.png")};

	public ArachneRenderer(Context context) {
		super(context, new ArachneModel(context.bakeLayer(ClientHandler.ARACHNE)), ClientHandler.largeShadow);
		this.addLayer(new ItemInHandLayer<>(this));
		this.addLayer(new ArachneEyesLayer(this));
	}

	protected float getFlipDegrees(Arachne arachne) {
		return 180.0F;
	}

	@Override
	public ResourceLocation getTextureLocation(Arachne arachne) {
		return ARACHNE_LOCATIONS[arachne.getVariant()];
	}
}
