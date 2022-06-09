package gaia.client.renderer.layer;

import gaia.client.ClientHandler;
import gaia.client.model.CreepModel;
import gaia.entity.Creep;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.ResourceLocation;

public class CreepPowerLayer extends EnergySwirlLayer<Creep, CreepModel> {
	private static final ResourceLocation POWER_LOCATION = new ResourceLocation("textures/entity/creep/creeper_armor.png");
	private final CreepModel model;

	public CreepPowerLayer(RenderLayerParent<Creep, CreepModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new CreepModel(modelSet.bakeLayer(ClientHandler.CREEP_ARMOR));
	}

	protected float xOffset(float offset) {
		return offset * 0.01F;
	}

	protected ResourceLocation getTextureLocation() {
		return POWER_LOCATION;
	}

	protected EntityModel<Creep> model() {
		return this.model;
	}
}