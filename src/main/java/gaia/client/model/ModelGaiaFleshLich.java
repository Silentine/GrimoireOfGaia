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
public class ModelGaiaFleshLich<T extends MobEntity> extends ModelGaia<T> {

    RendererModel head;
    RendererModel headupper;
    RendererModel headlower;
    RendererModel neck;
    RendererModel body;
    RendererModel rightarm;
    RendererModel leftarm;
    RendererModel rightshoulder;
    RendererModel rightshoulderlower;
    RendererModel leftshoulder;
    RendererModel banner;
    RendererModel waist1;
    RendererModel waist2;
    RendererModel waist3;
    RendererModel rightleg;
    RendererModel leftleg;

	public ModelGaiaFleshLich() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 6, 8);
		head.setRotationPoint(0F, 0F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headupper = new RendererModel(this, 56, 0);
		headupper.addBox(-4F, 0F, -8F, 8, 2, 8);
		headupper.setRotationPoint(0F, -2F, 4F);
		setRotation(headupper, 0F, 0F, 0F);
		headlower = new RendererModel(this, 56, 10);
		headlower.addBox(-4F, 0F, -8F, 8, 4, 8);
		headlower.setRotationPoint(0F, -2F, 4F);
		setRotation(headlower, 0F, 0F, 0F);
		neck = new RendererModel(this, 56, 22);
		neck.addBox(-2F, -2F, -2F, 4, 4, 4);
		neck.setRotationPoint(0F, 0F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		body = new RendererModel(this, 0, 14);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		setRotation(body, 0F, 0F, 0F);
		rightarm = new RendererModel(this, 24, 14);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new RendererModel(this, 24, 14);
		leftarm.mirror = true;
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightshoulder = new RendererModel(this, 56, 30);
		rightshoulder.addBox(-4F, -3F, -3F, 6, 6, 6);
		rightshoulder.setRotationPoint(-5F, 2F, 0F);
		setRotation(rightshoulder, 0F, 0F, 0.0872665F);
		rightshoulderlower = new RendererModel(this, 56, 42);
		rightshoulderlower.addBox(-3.5F, -0.5F, -2.5F, 5, 7, 5);
		rightshoulderlower.setRotationPoint(-5F, 2F, 0F);
		setRotation(rightshoulderlower, 0F, 0F, 0F);
		leftshoulder = new RendererModel(this, 56, 54);
		leftshoulder.addBox(-1.5F, -3F, -2.5F, 5, 5, 5);
		leftshoulder.setRotationPoint(5F, 2F, 0F);
		setRotation(leftshoulder, 0F, 0F, -0.0872665F);
		banner = new RendererModel(this, 88, 27);
		banner.addBox(-3F, 11F, -3F, 6, 12, 4);
		banner.setRotationPoint(0F, 0F, 0F);
		setRotation(banner, 0F, 0F, 0F);
		waist1 = new RendererModel(this, 88, 0);
		waist1.addBox(-4.5F, 10F, -2.5F, 9, 4, 5);
		waist1.setRotationPoint(0F, 0F, 0F);
		setRotation(waist1, 0F, 0F, 0F);
		waist2 = new RendererModel(this, 88, 9);
		waist2.addBox(-5F, 0F, -4.5F, 10, 4, 5);
		waist2.setRotationPoint(0F, 14F, 2.5F);
		setRotation(waist2, 0F, 0F, 0F);
		waist3 = new RendererModel(this, 88, 18);
		waist3.addBox(-5.5F, 0F, -4.5F, 11, 4, 5);
		waist3.setRotationPoint(0F, 18F, 3F);
		setRotation(waist3, 0F, 0F, 0F);
		rightleg = new RendererModel(this, 40, 14);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new RendererModel(this, 40, 14);
		leftleg.mirror = true;
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		setRotation(leftleg, 0F, 0F, 0F);

		convertToChild(head, headupper);
		convertToChild(head, headlower);
		convertToChild(rightarm, rightshoulder);
		convertToChild(rightarm, rightshoulderlower);
		convertToChild(waist2, waist3);
		convertToChild(waist1, waist2);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		neck.render(scale);
		body.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		banner.render(scale);
		waist1.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstack = ((MobEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		
		headlower.rotateAngleX = +degToRad(5);

		// arms
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		
		waist1.rotateAngleX = degToRad(5);
		waist2.rotateAngleX = degToRad(5);
		waist3.rotateAngleX = degToRad(5);
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

	private void animationThrow() {
		rightarm.rotateAngleX = -1.0472F;
	}

	public RendererModel getRightArm() {
		return rightarm;
	}
}
