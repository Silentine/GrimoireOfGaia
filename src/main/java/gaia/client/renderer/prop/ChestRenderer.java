package gaia.client.renderer.prop;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.prop.ChestModel;
import gaia.client.state.ChestRenderState;
import gaia.entity.prop.Chest;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;
import net.neoforged.fml.ModList;

public class ChestRenderer extends MobRenderer<Chest, ChestRenderState, ChestModel> {
	public static final Identifier CHEST_LOCATION = GrimoireOfGaia.modLoc("textures/entity/mimic/mimic_chest.png");
	public static final Identifier LOOTR_LOCATION = Identifier.fromNamespaceAndPath("lootr", "textures/chest.png");

	public ChestRenderer(Context context) {
		super(context, new ChestModel(context.bakeLayer(ClientHandler.CHEST)), 0.0F);
	}

	@Override
	public ChestRenderState createRenderState() {
		return new ChestRenderState();
	}

	@Override
	public void extractRenderState(Chest entity, ChestRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.rotation = entity.getRotation();
	}

	@Override
	public Identifier getTextureLocation(ChestRenderState state) {
		if (ModList.get().isLoaded("lootr")) {
			return LOOTR_LOCATION;
		}
		return CHEST_LOCATION;
	}
}
