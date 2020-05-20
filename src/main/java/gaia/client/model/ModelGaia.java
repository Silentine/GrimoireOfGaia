package gaia.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public abstract class ModelGaia<T extends MobEntity> extends EntityModel<T> {
	protected T entityIn;

	protected void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		parParent.addChild(parChild);
	}

	private double distanceMovedTotal = 0.0D;

	/**
	 * Helper functions
	 */
	void updateDistanceMovedTotal(T parEntity) {
		distanceMovedTotal += parEntity.getDistance(parEntity);
	}

	double getDistanceMovedTotal() {
		return distanceMovedTotal;
	}

	protected float degToRad(float degrees) {
		return degrees * (float) Math.PI / 180;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.entityIn = entityIn;
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}
}
