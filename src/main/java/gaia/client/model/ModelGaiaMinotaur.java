package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaMinotaur<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel head;
	private RendererModel neckmuscle;
	private RendererModel body;
	private RendererModel body2;
	private RendererModel body3;
	private RendererModel waist;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel rightarmlower;
	private RendererModel leftarmlower;
	private RendererModel rightleg;
	private RendererModel leftleg;
	private RendererModel righthorn1;
	private RendererModel righthorn2;
	private RendererModel righthorn3;
	private RendererModel righthorn4;
	private RendererModel righthorn5;
	private RendererModel lefthorn1;
	private RendererModel lefthorn2;
	private RendererModel lefthorn3;
	private RendererModel lefthorn4;
	private RendererModel lefthorn5;

	public ModelGaiaMinotaur() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3.5F, -7F, -4F, 7, 7, 8);
		head.setRotationPoint(0F, -9F, -4F);
		setRotation(head, 0F, 0F, 0F);
		RendererModel brow = new RendererModel(this, 30, 0);
		brow.addBox(-3F, -6F, -6F, 6, 2, 2);
		brow.setRotationPoint(0F, -9F, -4F);
		setRotation(brow, 0F, 0F, 0F);
		RendererModel nose = new RendererModel(this, 30, 4);
		nose.addBox(-2.5F, -4F, -9F, 5, 4, 5);
		nose.setRotationPoint(0F, -9F, -4F);
		setRotation(nose, 0F, 0F, 0F);
		RendererModel nosering = new RendererModel(this, 30, 13);
		nosering.addBox(-2F, -1.5F, -10F, 4, 4, 1);
		nosering.setRotationPoint(0F, -9F, -4F);
		setRotation(nosering, 0F, 0F, 0F);
		neckmuscle = new RendererModel(this, 0, 15);
		neckmuscle.addBox(-5F, -2F, 1.5F, 10, 6, 5);
		neckmuscle.setRotationPoint(0F, -9F, -4F);
		setRotation(neckmuscle, 0.6108652F, 0F, 0F);
		body = new RendererModel(this, 0, 26);
		body.addBox(-6F, 0F, -4F, 12, 9, 8);
		body.setRotationPoint(0F, -10F, 0F);
		setRotation(body, 0.1745329F, 0F, 0F);
		body2 = new RendererModel(this, 0, 43);
		body2.addBox(-5F, 11F, -2F, 10, 5, 6);
		body2.setRotationPoint(0F, -12F, 0F);
		setRotation(body2, 0.0872665F, 0F, 0F);
		body3 = new RendererModel(this, 0, 54);
		body3.addBox(-4F, 16F, -1F, 8, 5, 5);
		body3.setRotationPoint(0F, -12F, 0F);
		setRotation(body3, 0F, 0F, 0F);
		waist = new RendererModel(this, 66, 0);
		waist.addBox(-4.5F, 16F, -1.5F, 9, 8, 6);
		waist.setRotationPoint(0F, -12F, 0F);
		setRotation(waist, 0F, 0F, 0F);
		RendererModel rightarmpauldron01 = new RendererModel(this, 96, 0);
		rightarmpauldron01.addBox(-4F, -2.5F, -3F, 6, 6, 6);
		rightarmpauldron01.setRotationPoint(-7F, -7F, 0F);
		setRotation(rightarmpauldron01, 0F, 0F, 0F);
		RendererModel rightarmpauldron02 = new RendererModel(this, 96, 12);
		rightarmpauldron02.addBox(-3.5F, 3F, -2.5F, 5, 5, 5);
		rightarmpauldron02.setRotationPoint(-7F, -7F, 0F);
		setRotation(rightarmpauldron02, 0F, 0F, 0F);
		rightarm = new RendererModel(this, 50, 23);
		rightarm.addBox(-3F, -2F, -2F, 4, 10, 4);
		rightarm.setRotationPoint(-7F, -7F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new RendererModel(this, 50, 23);
		leftarm.mirror = true;
		leftarm.addBox(-1F, -2F, -2F, 4, 10, 4);
		leftarm.setRotationPoint(7F, -7F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightarmlower = new RendererModel(this, 50, 37);
		rightarmlower.addBox(-2F, 0F, -4F, 4, 8, 4);
		rightarmlower.setRotationPoint(-8.01F, 1F, 2F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new RendererModel(this, 50, 37);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-2F, 0F, -4F, 4, 8, 4);
		leftarmlower.setRotationPoint(8.01F, 1F, 2F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		rightleg = new RendererModel(this, 66, 14);
		rightleg.addBox(-2F, -1F, -2F, 4, 9, 4);
		rightleg.setRotationPoint(-4F, 7F, 2F);
		setRotation(rightleg, -0.4363323F, 0F, 0F);
		leftleg = new RendererModel(this, 66, 14);
		leftleg.mirror = true;
		leftleg.addBox(-2F, -1F, -2F, 4, 9, 4);
		leftleg.setRotationPoint(4F, 7F, 2F);
		setRotation(leftleg, -0.4363323F, 0F, 0F);
		RendererModel rightleglower = new RendererModel(this, 66, 27);
		rightleglower.addBox(-1.5F, 8F, -2F, 3, 3, 6);
		rightleglower.setRotationPoint(-4F, 7F, 2F);
		setRotation(rightleglower, -0.4363323F, 0F, 0F);
		RendererModel leftleglower = new RendererModel(this, 66, 27);
		leftleglower.addBox(-1.5F, 8F, -2F, 3, 3, 6);
		leftleglower.setRotationPoint(4F, 7F, 2F);
		setRotation(leftleglower, -0.4363323F, 0F, 0F);
		RendererModel rightleglowerfoot = new RendererModel(this, 66, 36);
		rightleglowerfoot.addBox(-1.5F, 8F, 4F, 3, 8, 3);
		rightleglowerfoot.setRotationPoint(-4F, 7F, 2F);
		setRotation(rightleglowerfoot, -0.4363323F, 0F, 0F);
		RendererModel leftleglowerfoot = new RendererModel(this, 66, 36);
		leftleglowerfoot.addBox(-1.5F, 8F, 4F, 3, 8, 3);
		leftleglowerfoot.setRotationPoint(4F, 7F, 2F);
		setRotation(leftleglowerfoot, -0.4363323F, 0F, 0F);
		RendererModel rightfoothoof = new RendererModel(this, 66, 47);
		rightfoothoof.addBox(-1F, 14F, 0F, 2, 2, 2);
		rightfoothoof.setRotationPoint(-4F, 7F, 2F);
		setRotation(rightfoothoof, 0F, 0F, 0F);
		RendererModel leftfoothoof = new RendererModel(this, 66, 47);
		leftfoothoof.addBox(-1F, 14F, 0F, 2, 2, 2);
		leftfoothoof.setRotationPoint(4F, 7F, 2F);
		setRotation(leftfoothoof, 0F, 0F, 0F);
		RendererModel rightfoot = new RendererModel(this, 66, 51);
		rightfoot.addBox(-2F, 14F, -4F, 4, 3, 4);
		rightfoot.setRotationPoint(-4F, 7F, 2F);
		setRotation(rightfoot, 0F, 0F, 0F);
		RendererModel leftfoot = new RendererModel(this, 66, 51);
		leftfoot.addBox(-2F, 14F, -4F, 4, 3, 4);
		leftfoot.setRotationPoint(4F, 7F, 2F);
		setRotation(leftfoot, 0F, 0F, 0F);
		righthorn1 = new RendererModel(this, 50, 0);
		righthorn1 = new RendererModel(this, 50, 0);
		righthorn1.addBox(-3F, 0.5F, -1.5F, 4, 3, 3);
		righthorn1.setRotationPoint(-3.5F, -17.5F, -6F);
		setRotation(righthorn1, 0F, 0F, 0F);
		righthorn2 = new RendererModel(this, 50, 6);
		righthorn2.addBox(-2F, -1.5F, -1.5F, 2, 3, 3);
		righthorn2.setRotationPoint(-6.5F, -15.5F, -6F);
		setRotation(righthorn2, 0F, 0F, 0F);
		righthorn3 = new RendererModel(this, 50, 12);
		righthorn3.addBox(-2F, -1.5F, -1.5F, 2, 3, 3);
		righthorn3.setRotationPoint(-8.5F, -15.5F, -6F);
		setRotation(righthorn3, 0F, 0F, 0F);
		righthorn4 = new RendererModel(this, 50, 18);
		righthorn4.addBox(-2F, -1F, -1F, 2, 2, 2);
		righthorn4.setRotationPoint(-10.5F, -15.5F, -6F);
		setRotation(righthorn4, 0F, 0F, 0F);
		righthorn5 = new RendererModel(this, 58, 18);
		righthorn5.addBox(-1F, -0.5F, -0.5F, 1, 1, 1);
		righthorn5.setRotationPoint(-12.5F, -15.5F, -6F);
		setRotation(righthorn5, 0F, 0F, 0F);
		lefthorn1 = new RendererModel(this, 50, 0);
		lefthorn1.mirror = true;
		lefthorn1.addBox(-1F, 0.5F, -1.5F, 4, 3, 3);
		lefthorn1.setRotationPoint(3.5F, -17.5F, -6F);
		setRotation(lefthorn1, 0F, 0F, 0F);
		lefthorn2 = new RendererModel(this, 50, 6);
		lefthorn2.mirror = true;
		lefthorn2.addBox(0F, -1.5F, -1.5F, 2, 3, 3);
		lefthorn2.setRotationPoint(6.5F, -15.5F, -6F);
		setRotation(lefthorn2, 0F, 0F, 0F);
		lefthorn3 = new RendererModel(this, 50, 12);
		lefthorn3.mirror = true;
		lefthorn3.addBox(0F, -1.5F, -1.5F, 2, 3, 3);
		lefthorn3.setRotationPoint(8.5F, -15.5F, -6F);
		setRotation(lefthorn3, 0F, 0F, 0F);
		lefthorn4 = new RendererModel(this, 50, 18);
		lefthorn4.addBox(0F, -1F, -1F, 2, 2, 2);
		lefthorn4.mirror = true;
		lefthorn4.setRotationPoint(10.5F, -15.5F, -6F);
		setRotation(lefthorn4, 0F, 0F, 0F);
		lefthorn5 = new RendererModel(this, 58, 18);
		lefthorn5.addBox(0F, -0.5F, -0.5F, 1, 1, 1);
		lefthorn5.setRotationPoint(12.5F, -15.5F, -6F);
		setRotation(lefthorn5, 0F, 0F, 0F);

		convertToChild(head, brow);
		convertToChild(nose, nosering);
		convertToChild(head, nose);
		convertToChild(righthorn4, righthorn5);
		convertToChild(righthorn3, righthorn4);
		convertToChild(righthorn2, righthorn3);
		convertToChild(righthorn1, righthorn2);
		convertToChild(head, righthorn1);
		convertToChild(lefthorn4, lefthorn5);
		convertToChild(lefthorn3, lefthorn4);
		convertToChild(lefthorn2, lefthorn3);
		convertToChild(lefthorn1, lefthorn2);
		convertToChild(head, lefthorn1);
		convertToChild(rightarm, rightarmpauldron01);
		convertToChild(rightarm, rightarmpauldron02);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
		convertToChild(rightleg, rightleglowerfoot);
		convertToChild(leftleg, leftleglowerfoot);
		convertToChild(rightleg, rightfoothoof);
		convertToChild(leftleg, leftfoothoof);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftfoot);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		neckmuscle.render(scale);
		body.render(scale);
		body2.render(scale);
		body3.render(scale);
		waist.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstack = ((MobEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		
		righthorn2.rotateAngleY = degToRad(-30);
		righthorn2.rotateAngleZ = degToRad(30);
		righthorn3.rotateAngleY = degToRad(-30);
		righthorn3.rotateAngleZ = degToRad(30);
		righthorn4.rotateAngleY = degToRad(-30);
		righthorn4.rotateAngleZ = degToRad(15);
		righthorn5.rotateAngleY = degToRad(-30);
		righthorn5.rotateAngleZ = degToRad(15);
		
		lefthorn2.rotateAngleY = degToRad(30);
		lefthorn2.rotateAngleZ = degToRad(-30);
		lefthorn3.rotateAngleY = degToRad(30);
		lefthorn3.rotateAngleZ = degToRad(-30);
		lefthorn4.rotateAngleY = degToRad(30);
		lefthorn4.rotateAngleZ = degToRad(-15);
		lefthorn5.rotateAngleY = degToRad(30);
		lefthorn5.rotateAngleZ = degToRad(-15);

		// arms
		float armDefaultAngleX = 0.261799F;

		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

			rightarm.rotateAngleX = +armDefaultAngleX;
			leftarm.rotateAngleX = +armDefaultAngleX;

			rightarmlower.rotateAngleX = -armDefaultAngleX;
			leftarmlower.rotateAngleX = -armDefaultAngleX;
		}

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.4363323F;
		leftleg.rotateAngleX -= 0.4363323F;
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

	private void animationBuff() {
		float armDefaultAngleX = 0.785398F;

		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;
		rightarm.rotateAngleZ = +armDefaultAngleX;
		leftarm.rotateAngleZ = -armDefaultAngleX;

		rightarm.rotateAngleX = +armDefaultAngleX;
		leftarm.rotateAngleX = +armDefaultAngleX;
		rightarmlower.rotateAngleX = -armDefaultAngleX;
		leftarmlower.rotateAngleX = -armDefaultAngleX;
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
