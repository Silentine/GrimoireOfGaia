package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.WerecatModel;
import gaia.client.renderer.layer.WerecatEyesLayer;
import gaia.entity.Werecat;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WerecatRenderer extends MobRenderer<Werecat, WerecatModel> {
	public static final ResourceLocation[] WERECAT_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/werecat/werecat01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/werecat/werecat02.png")};

	public WerecatRenderer(EntityRendererProvider.Context context) {
		super(context, new WerecatModel(context.bakeLayer(ClientHandler.WERECAT)), ClientHandler.smallShadow);
		this.addLayer(new WerecatEyesLayer(this));
	}

	@Override
	public ResourceLocation getTextureLocation(Werecat werecat) {
		return WERECAT_LOCATIONS[werecat.getVariant()];
	}
}
