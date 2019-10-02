package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Direct copy of ModelGaiaGoblin with the only difference being that under 'setRotationAngles' entity makes reference to EntityGaiaGoblinFeral.
 * 
 * @see ModelGaiaGoblin
 */
@OnlyIn(Dist.CLIENT)
public class ModelGaiaGoblinFeral<T extends MobEntity> extends ModelGaia<T> {
	RendererModel head;
	RendererModel rightarm;
	RendererModel leftarm;
	RendererModel body;
	RendererModel backpack;
	RendererModel rightleg;
	RendererModel leftleg;

	public ModelGaiaGoblinFeral() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 8F, 0F);
		setRotation(head, 0F, 0F, 0F);
		RendererModel headaccessory = new RendererModel(this, 64, 0);
		headaccessory.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9);
		headaccessory.setRotationPoint(0F, 8F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		RendererModel rightear = new RendererModel(this, 64, 10);
		rightear.addBox(-5.5F, -7F, 0F, 0, 6, 8);
		rightear.setRotationPoint(0F, 8F, 0F);
		setRotation(rightear, 0F, -0.7853982F, 0F);
		RendererModel leftear = new RendererModel(this, 64, 10);
		leftear.mirror = true;
		leftear.addBox(5.5F, -7F, 0F, 0, 6, 8);
		leftear.setRotationPoint(0F, 8F, 0F);
		setRotation(leftear, 0F, 0.7853982F, 0F);
		RendererModel rightearback = new RendererModel(this, 80, 10);
		rightearback.addBox(-5.4F, -7F, 0F, 0, 6, 8);
		rightearback.setRotationPoint(0F, 8F, 0F);
		setRotation(rightearback, 0F, -0.7853982F, 0F);
		RendererModel leftearback = new RendererModel(this, 80, 10);
		leftearback.mirror = true;
		leftearback.addBox(5.4F, -7F, 0F, 0, 6, 8);
		leftearback.setRotationPoint(0F, 8F, 0F);
		setRotation(leftearback, 0F, 0.7853982F, 0F);
		RendererModel headnose = new RendererModel(this, 64, 24);
		headnose.addBox(-1F, -3F, -7F, 2, 3, 3);
		headnose.setRotationPoint(0F, 8F, 0F);
		setRotation(headnose, 0F, 0F, 0F);
		RendererModel rightarmpauldron = new RendererModel(this, 100, 0);
		rightarmpauldron.addBox(-3.5F, -2F, -2F, 4, 4, 4);
		rightarmpauldron.setRotationPoint(-4F, 10F, 0F);
		setRotation(rightarmpauldron, 0F, 0F, 0F);
		RendererModel leftarmpauldron = new RendererModel(this, 100, 0);
		leftarmpauldron.mirror = true;
		leftarmpauldron.addBox(-0.5F, -2F, -2F, 4, 4, 4);
		leftarmpauldron.setRotationPoint(4F, 10F, 0F);
		setRotation(leftarmpauldron, 0F, 0F, 0F);
		rightarm = new RendererModel(this, 24, 16);
		rightarm.addBox(-3F, -1.5F, -1.5F, 3, 8, 3);
		rightarm.setRotationPoint(-4F, 10F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		RendererModel rightarmgauntlet = new RendererModel(this, 100, 8);
		rightarmgauntlet.addBox(-3.5F, 3F, -2F, 4, 4, 4);
		rightarmgauntlet.setRotationPoint(-4F, 10F, 0F);
		setRotation(rightarmgauntlet, 0F, 0F, 0F);
		RendererModel leftarmgauntlet = new RendererModel(this, 100, 8);
		leftarmgauntlet.mirror = true;
		leftarmgauntlet.addBox(-0.5F, 3F, -2F, 4, 4, 4);
		leftarmgauntlet.setRotationPoint(4F, 10F, 0F);
		setRotation(leftarmgauntlet, 0F, 0F, 0F);
		leftarm = new RendererModel(this, 24, 16);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1.5F, -1.5F, 3, 8, 3);
		leftarm.setRotationPoint(4F, 10F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		RendererModel rightlegupper = new RendererModel(this, 100, 16);
		rightlegupper.addBox(-2F, 0F, -2F, 4, 4, 4);
		rightlegupper.setRotationPoint(-2F, 16F, 0F);
		setRotation(rightlegupper, 0F, 0F, 0F);
		body = new RendererModel(this, 0, 16);
		body.addBox(-4F, 0F, -2F, 8, 8, 4);
		body.setRotationPoint(0F, 8F, 0F);
		setRotation(body, 0F, 0F, 0F);
		backpack = new RendererModel(this, 64, 30);
		backpack.addBox(-4F, -4F, 0F, 8, 8, 8);
		backpack.setRotationPoint(0F, 12F, 2F);
		setRotation(backpack, 0F, 0F, 0F);
		RendererModel leftlegupper = new RendererModel(this, 100, 16);
		leftlegupper.mirror = true;
		leftlegupper.addBox(-2F, 0F, -2F, 4, 4, 4);
		leftlegupper.setRotationPoint(2F, 16F, 0F);
		setRotation(leftlegupper, 0F, 0F, 0F);
		rightleg = new RendererModel(this, 36, 16);
		rightleg.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		rightleg.setRotationPoint(-2F, 16F, 0F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new RendererModel(this, 36, 16);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		leftleg.setRotationPoint(2F, 16F, 0F);
		setRotation(leftleg, 0F, 0F, 0F);
		RendererModel rightlegboot = new RendererModel(this, 100, 24);
		rightlegboot.addBox(-2F, 4F, -2F, 4, 4, 4);
		rightlegboot.setRotationPoint(-2F, 16F, 0F);
		setRotation(rightlegboot, 0F, 0F, 0F);
		RendererModel leftlegboot = new RendererModel(this, 100, 24);
		leftlegboot.mirror = true;
		leftlegboot.addBox(-2F, 4F, -2F, 4, 4, 4);
		leftlegboot.setRotationPoint(2F, 16F, 0F);
		setRotation(leftlegboot, 0F, 0F, 0F);

		convertToChild(head, headaccessory);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(head, rightearback);
		convertToChild(head, leftearback);
		convertToChild(head, headnose);
		convertToChild(rightarm, rightarmpauldron);
		convertToChild(leftarm, leftarmpauldron);
		convertToChild(rightarm, rightarmgauntlet);
		convertToChild(leftarm, leftarmgauntlet);
		convertToChild(body, backpack);
		convertToChild(rightleg, rightlegupper);
		convertToChild(leftleg, leftlegupper);
		convertToChild(rightleg, rightlegboot);
		convertToChild(leftleg, leftlegboot);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		body.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (entityIn.isAggressive() && (entityIn.getHeldItemMainhand().getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// legs (walk_normal)
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2F);
		rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (body.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
