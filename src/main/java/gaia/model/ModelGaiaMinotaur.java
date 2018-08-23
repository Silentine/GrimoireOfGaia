package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMinotaur extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer neckmuscle;
	private ModelRenderer body;
	private ModelRenderer body2;
	private ModelRenderer body3;
	private ModelRenderer waist;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;

	public ModelGaiaMinotaur() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.5F, -7F, -4F, 7, 7, 8);
		head.setRotationPoint(0F, -9F, -4F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer righthorn1 = new ModelRenderer(this, 50, 0);
		righthorn1.addBox(-5.5F, -8F, -3F, 4, 3, 3);
		righthorn1.setRotationPoint(0F, -9F, -4F);
		righthorn1.setTextureSize(128, 64);
		setRotation(righthorn1, 0F, 0F, 0F);
		ModelRenderer righthorn2 = new ModelRenderer(this, 50, 6);
		righthorn2.addBox(-6.5F, -9F, -4F, 3, 3, 3);
		righthorn2.setRotationPoint(0F, -9F, -4F);
		righthorn2.setTextureSize(128, 64);
		setRotation(righthorn2, 0F, 0F, 0F);
		ModelRenderer righthorn3 = new ModelRenderer(this, 50, 12);
		righthorn3.addBox(-7.5F, -10F, -5F, 2, 3, 2);
		righthorn3.setRotationPoint(0F, -9F, -4F);
		righthorn3.setTextureSize(128, 64);
		setRotation(righthorn3, 0F, 0F, 0F);
		ModelRenderer righthorn4 = new ModelRenderer(this, 50, 17);
		righthorn4.addBox(-6.5F, -11F, -4F, 2, 2, 2);
		righthorn4.setRotationPoint(0F, -9F, -4F);
		righthorn4.setTextureSize(128, 64);
		setRotation(righthorn4, 0F, 0F, 0F);
		ModelRenderer righthorn5 = new ModelRenderer(this, 50, 21);
		righthorn5.addBox(-5F, -11.5F, -2.5F, 1, 1, 1);
		righthorn5.setRotationPoint(0F, -9F, -4F);
		righthorn5.setTextureSize(128, 64);
		setRotation(righthorn5, 0F, 0F, 0F);
		ModelRenderer lefthorn1 = new ModelRenderer(this, 50, 0);
		lefthorn1.mirror = true;
		lefthorn1.addBox(1.5F, -8F, -3F, 4, 3, 3);
		lefthorn1.setRotationPoint(0F, -9F, -4F);
		lefthorn1.setTextureSize(128, 64);
		setRotation(lefthorn1, 0F, 0F, 0F);
		ModelRenderer lefthorn2 = new ModelRenderer(this, 50, 6);
		lefthorn2.mirror = true;
		lefthorn2.addBox(3.5F, -9F, -4F, 3, 3, 3);
		lefthorn2.setRotationPoint(0F, -9F, -4F);
		lefthorn2.setTextureSize(128, 64);
		setRotation(lefthorn2, 0F, 0F, 0F);
		ModelRenderer lefthorn3 = new ModelRenderer(this, 50, 12);
		lefthorn3.mirror = true;
		lefthorn3.addBox(5.5F, -10F, -5F, 2, 3, 2);
		lefthorn3.setRotationPoint(0F, -9F, -4F);
		lefthorn3.setTextureSize(128, 64);
		setRotation(lefthorn3, 0F, 0F, 0F);
		ModelRenderer lefthorn4 = new ModelRenderer(this, 50, 17);
		lefthorn4.mirror = true;
		lefthorn4.addBox(4.5F, -11F, -5F, 2, 2, 2);
		lefthorn4.setRotationPoint(0F, -9F, -4F);
		lefthorn4.setTextureSize(128, 64);
		setRotation(lefthorn4, 0F, 0F, 0F);
		ModelRenderer letfhorn5 = new ModelRenderer(this, 50, 21);
		letfhorn5.mirror = true;
		letfhorn5.addBox(4F, -11.5F, -3.5F, 1, 1, 1);
		letfhorn5.setRotationPoint(0F, -9F, -4F);
		letfhorn5.setTextureSize(128, 64);
		setRotation(letfhorn5, 0F, 0F, 0F);
		ModelRenderer brow = new ModelRenderer(this, 30, 0);
		brow.addBox(-3F, -6F, -6F, 6, 2, 2);
		brow.setRotationPoint(0F, -9F, -4F);
		brow.setTextureSize(128, 64);
		setRotation(brow, 0F, 0F, 0F);
		ModelRenderer nose = new ModelRenderer(this, 30, 4);
		nose.addBox(-2.5F, -4F, -9F, 5, 4, 5);
		nose.setRotationPoint(0F, -9F, -4F);
		nose.setTextureSize(128, 64);
		setRotation(nose, 0F, 0F, 0F);
		ModelRenderer nosering = new ModelRenderer(this, 30, 13);
		nosering.addBox(-2F, -1.5F, -10F, 4, 4, 1);
		nosering.setRotationPoint(0F, -9F, -4F);
		nosering.setTextureSize(128, 64);
		setRotation(nosering, 0F, 0F, 0F);
		neckmuscle = new ModelRenderer(this, 0, 15);
		neckmuscle.addBox(-5F, -2F, 1.5F, 10, 6, 5);
		neckmuscle.setRotationPoint(0F, -9F, -4F);
		neckmuscle.setTextureSize(128, 64);
		setRotation(neckmuscle, 0.6108652F, 0F, 0F);
		body = new ModelRenderer(this, 0, 26);
		body.addBox(-6F, 0F, -4F, 12, 9, 8);
		body.setRotationPoint(0F, -10F, 0F);
		body.setTextureSize(128, 64);
		setRotation(body, 0.1745329F, 0F, 0F);
		body2 = new ModelRenderer(this, 0, 43);
		body2.addBox(-5F, 11F, -2F, 10, 5, 6);
		body2.setRotationPoint(0F, -12F, 0F);
		body2.setTextureSize(128, 64);
		setRotation(body2, 0.0872665F, 0F, 0F);
		body3 = new ModelRenderer(this, 0, 54);
		body3.addBox(-4F, 16F, -1F, 8, 5, 5);
		body3.setRotationPoint(0F, -12F, 0F);
		body3.setTextureSize(128, 64);
		setRotation(body3, 0F, 0F, 0F);
		waist = new ModelRenderer(this, 66, 0);
		waist.addBox(-4.5F, 16F, -1.5F, 9, 8, 6);
		waist.setRotationPoint(0F, -12F, 0F);
		waist.setTextureSize(128, 64);
		setRotation(waist, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 50, 23);
		rightarm.addBox(-3F, -2F, -2F, 4, 10, 4);
		rightarm.setRotationPoint(-7F, -7F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 50, 23);
		leftarm.mirror = true;
		leftarm.addBox(-1F, -2F, -2F, 4, 10, 4);
		leftarm.setRotationPoint(7F, -7F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 50, 37);
		rightarmlower.addBox(-4.5F, 8F, -2F, 4, 8, 4);
		rightarmlower.setRotationPoint(-7F, -7F, 0F);
		rightarmlower.setTextureSize(128, 64);
		setRotation(rightarmlower, 0F, 0F, 0F);
		ModelRenderer righthandle = new ModelRenderer(this, 120, 16);
		righthandle.addBox(-3.5F, -9F, -15F, 2, 18, 2);
		righthandle.setRotationPoint(-7F, -7F, 0F);
		righthandle.setTextureSize(128, 64);
		setRotation(righthandle, 1.570796F, 0F, 0F);
		ModelRenderer righthammerhead = new ModelRenderer(this, 96, 0);
		righthammerhead.addBox(-5.5F, -15F, -19F, 6, 6, 10);
		righthammerhead.setRotationPoint(-7F, -7F, 0F);
		righthammerhead.setTextureSize(128, 64);
		setRotation(righthammerhead, 1.570796F, 0F, 0F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 50, 37);
		leftarmlower.mirror = true;
		leftarmlower.addBox(0.5F, 8F, -2F, 4, 8, 4);
		leftarmlower.setRotationPoint(7F, -7F, 0F);
		leftarmlower.setTextureSize(128, 64);
		setRotation(leftarmlower, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 66, 14);
		rightleg.addBox(-2F, -1F, -2F, 4, 9, 4);
		rightleg.setRotationPoint(-4F, 7F, 2F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, -0.4363323F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 66, 27);
		rightleglower.addBox(-1.5F, 5F, 2F, 3, 10, 3);
		rightleglower.setRotationPoint(-4F, 7F, 2F);
		rightleglower.setTextureSize(128, 64);
		setRotation(rightleglower, -0.4363323F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 66, 40);
		rightfoot.addBox(-2F, 14F, -5F, 4, 3, 4);
		rightfoot.setRotationPoint(-4F, 7F, 2F);
		rightfoot.setTextureSize(128, 64);
		setRotation(rightfoot, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 66, 14);
		leftleg.mirror = true;
		leftleg.addBox(-2F, -1F, -2F, 4, 9, 4);
		leftleg.setRotationPoint(4F, 7F, 2F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, -0.3490659F, 0F, 0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 66, 27);
		leftleglower.addBox(-1.5F, 5F, 2F, 3, 10, 3);
		leftleglower.setRotationPoint(4F, 7F, 2F);
		leftleglower.setTextureSize(128, 64);
		setRotation(leftleglower, -0.4363323F, 0F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 66, 40);
		leftfoot.addBox(-2F, 14F, -5F, 4, 3, 4);
		leftfoot.setRotationPoint(4F, 7F, 2F);
		leftfoot.setTextureSize(128, 64);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, righthorn4);
		convertToChild(head, righthorn5);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, lefthorn4);
		convertToChild(head, letfhorn5);
		convertToChild(head, brow);
		convertToChild(head, nose);
		convertToChild(head, nosering);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfoot);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
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
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
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

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
