package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.state.PoweredState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;

import java.util.function.Supplier;

public class AuraLayer<S extends LivingEntityRenderState & PoweredState, M extends EntityModel<S>> extends EnergySwirlLayer<S, M> {
	private static final Identifier WITHER_ARMOR_LOCATION = Identifier.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/layer/aura_immune_ranged.png");
	private final M model;

	public AuraLayer(RenderLayerParent<S, M> layerParent, Supplier<M> mSupplier) {
		super(layerParent);
		this.model = mSupplier.get();
	}

	@Override
	protected boolean isPowered(S state) {
		return state.isPowered();
	}

	protected float xOffset(float offset) {
		return Mth.cos(offset * 0.02F) * 3.0F;
	}

	protected Identifier getTextureLocation() {
		return WITHER_ARMOR_LOCATION;
	}

	protected M model() {
		return this.model;
	}
}