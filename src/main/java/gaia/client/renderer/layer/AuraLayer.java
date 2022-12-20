package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EnergySwirlLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PowerableMob;

import java.util.function.Supplier;

public class AuraLayer<T extends LivingEntity & PowerableMob, M extends EntityModel<T>> extends EnergySwirlLayer<T, M> {
	private static final ResourceLocation WITHER_ARMOR_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/layer/aura_immune_ranged.png");
	private final EntityModel<T> model;

	public AuraLayer(RenderLayerParent<T, M> layerParent, Supplier<M> mSupplier) {
		super(layerParent);
		this.model = mSupplier.get();
	}

	protected float xOffset(float offset) {
		return Mth.cos(offset * 0.02F) * 3.0F;
	}

	protected ResourceLocation getTextureLocation() {
		return WITHER_ARMOR_LOCATION;
	}

	protected EntityModel<T> model() {
		return this.model;
	}
}