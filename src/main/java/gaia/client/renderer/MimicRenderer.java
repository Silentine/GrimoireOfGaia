package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MimicModel;
import gaia.client.state.MimicRenderState;
import gaia.entity.Mimic;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.fml.ModList;

public class MimicRenderer extends MobRenderer<Mimic, MimicRenderState, MimicModel> {
	public static final Identifier[] MIMIC_LOCATION = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/mimic/mimic.png")
	};

	public static final Identifier[] LOOTR_LOCATION = new Identifier[]{
			GrimoireOfGaia.modLoc("textures/entity/mimic/lootr_mimic.png")
	};

	public MimicRenderer(Context context) {
		super(context, new MimicModel(context.bakeLayer(ClientHandler.MIMIC)), ClientHandler.smallShadow);
	}

	@Override
	public MimicRenderState createRenderState() {
		return new MimicRenderState();
	}

	@Override
	public void extractRenderState(Mimic entity, MimicRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.variant = entity.getVariant();
	}

	@Override
	public Identifier getTextureLocation(MimicRenderState state) {
		if (ModList.get().isLoaded("lootr")) {
			return LOOTR_LOCATION[state.variant];
		}
		return MIMIC_LOCATION[state.variant];
	}
}
