package gaia.client.renderer.layer;

import gaia.client.ClientHandler;
import gaia.client.model.CreepModel;
import gaia.client.state.CreepRenderState;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.Identifier;

public class CreepPowerLayer extends EnergySwirlLayer<CreepRenderState, CreepModel> {
	private static final Identifier POWER_LOCATION = Identifier.parse("textures/entity/creeper/creeper_armor.png");
	private final CreepModel model;

	public CreepPowerLayer(RenderLayerParent<CreepRenderState, CreepModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new CreepModel(modelSet.bakeLayer(ClientHandler.CREEP_ARMOR));
	}

	@Override
	protected boolean isPowered(CreepRenderState state) {
		return state.isPowered();
	}

	protected float xOffset(float offset) {
		return offset * 0.01F;
	}

	protected Identifier getTextureLocation() {
		return POWER_LOCATION;
	}

	protected CreepModel model() {
		return this.model;
	}
}