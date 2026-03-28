package gaia.client.renderer.prop;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.prop.CyanFlowerModel;
import gaia.client.state.CyanFlowerRenderState;
import gaia.entity.prop.CyanFlower;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.Identifier;

public class CyanFlowerRenderer extends MobRenderer<CyanFlower, CyanFlowerRenderState, CyanFlowerModel> {
	public static final Identifier CYAN_FLOWER_LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/mandragora/mandragora_flower.png");

	public CyanFlowerRenderer(EntityRendererProvider.Context context) {
		super(context, new CyanFlowerModel(context.bakeLayer(ClientHandler.CYAN_FLOWER)), 0.0F);
	}

	@Override
	public CyanFlowerRenderState createRenderState() {
		return new CyanFlowerRenderState();
	}

	@Override
	public void extractRenderState(CyanFlower entity, CyanFlowerRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
	}

	@Override
	public Identifier getTextureLocation(CyanFlowerRenderState state) {
		return CYAN_FLOWER_LOCATION;
	}
}
