package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.entity.AbstractGaiaEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;

/**
 * A variation of the MobRenderer class that scales the model to half if the entity is a baby.
 * To reduce the amount of duplicate code, this class extends the MobRenderer class and overrides the methods that are necessary.
 *
 * @see net.minecraft.client.renderer.entity.MobRenderer
 */
public abstract class GaiaBabyMobRenderer<T extends AbstractGaiaEntity, M extends EntityModel<T>> extends MobRenderer<T, M> {

	public GaiaBabyMobRenderer(Context context, M model, float shadowSize) {
		super(context, model, shadowSize);
	}

	@Override
	protected void scale(T gaia, PoseStack poseStack, float partialTicks) {
		if (gaia.isBaby()) {
			poseStack.scale(0.5F, 0.5F, 0.5F);
		}
	}
}
