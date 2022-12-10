package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MimicModel;
import gaia.entity.Mimic;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;

public class MimicRenderer extends MobRenderer<Mimic, MimicModel> {
	public static final ResourceLocation[] MIMIC_LOCATION = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mimic/mimic.png")
	};

	public static final ResourceLocation[] LOOTR_LOCATION = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mimic/lootr_mimic.png")
	};

	public MimicRenderer(Context context) {
		super(context, new MimicModel(context.bakeLayer(ClientHandler.MIMIC)), ClientHandler.smallShadow);
	}

	@Override
	public ResourceLocation getTextureLocation(Mimic mimic) {
		if (ModList.get().isLoaded("lootr")) {
			return LOOTR_LOCATION[mimic.getVariant()];
		}
		return MIMIC_LOCATION[mimic.getVariant()];
	}
}
