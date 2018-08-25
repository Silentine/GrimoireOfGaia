package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaEnderDragonGirl extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer waist;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer rightleg1;
	private ModelRenderer leftleg1;
	private ModelRenderer rightwing;
	private ModelRenderer leftwing;

	private boolean isCarrying;

	public ModelGaiaEnderDragonGirl() {
		textureWidth = 128;
		textureHeight = 64;

		setCarrying(false);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -4F, -2F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, -4F, -2F);
		headeyes.setTextureSize(128, 64);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -4F, -2F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, -4F, -2F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0.1745329F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1F, 5, 6, 3);
		bodytop.setRotationPoint(0F, -4F, -2F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, -4F, -2F);
		bodymiddle.setTextureSize(128, 64);
		setRotation(bodymiddle, 0.0872665F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, -4F, -2F);
		bodymiddlebutton.setTextureSize(128, 64);
		setRotation(bodymiddlebutton, 0.0872665F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, -4F, -2F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0.1745329F, 0F, 0F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-2.5F, -2.5F, -1.5F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, -0.2617994F, 0F, 0.4363323F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, -2.5F, -1.5F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, -0.2617994F, 0F, -0.4363323F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -2F, -3F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -2F, -3F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		ModelRenderer righthorn = new ModelRenderer(this, 36, 14);
		righthorn.addBox(-4F, -7.5F, 0.5F, 2, 2, 7);
		righthorn.setRotationPoint(0F, -4F, -2F);
		righthorn.setTextureSize(128, 64);
		setRotation(righthorn, 0.3490659F, 0F, 0F);
		ModelRenderer lefthorn = new ModelRenderer(this, 36, 14);
		lefthorn.addBox(2F, -7.5F, 0.5F, 2, 2, 7);
		lefthorn.setRotationPoint(0F, -4F, -2F);
		lefthorn.setTextureSize(128, 64);
		setRotation(lefthorn, 0.3490659F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 19);
		rightear.addBox(-4F, -4F, -1F, 0, 2, 4);
		rightear.setRotationPoint(0F, -4F, -2F);
		rightear.setTextureSize(128, 64);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 19);
		leftear.mirror = true;
		leftear.addBox(4F, -4F, -1F, 0, 2, 4);
		leftear.setRotationPoint(0F, -4F, -2F);
		leftear.setTextureSize(128, 64);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 16, 20);
		rightarmlower.addBox(-2F, 5F, 0F, 2, 6, 2);
		rightarmlower.setRotationPoint(-2.5F, -2.5F, -1.5F);
		rightarmlower.setTextureSize(128, 64);
		setRotation(rightarmlower, -0.4537856F, 0F, 0.4363323F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 16, 20);
		leftarmlower.addBox(0F, 5F, 0F, 2, 6, 2);
		leftarmlower.setRotationPoint(2.5F, -2.5F, -1.5F);
		leftarmlower.setTextureSize(128, 64);
		setRotation(leftarmlower, -0.4537856F, 0F, -0.4363323F);
		ModelRenderer rightclaw = new ModelRenderer(this, 64, 0);
		rightclaw.addBox(-2F, 11F, -0.5F, 2, 3, 3);
		rightclaw.setRotationPoint(-2.5F, -2.5F, -1.5F);
		rightclaw.setTextureSize(128, 64);
		setRotation(rightclaw, -0.4537856F, 0F, 0.4363323F);
		ModelRenderer leftclaw = new ModelRenderer(this, 74, 0);
		leftclaw.addBox(0F, 11F, -0.5F, 2, 3, 3);
		leftclaw.setRotationPoint(2.5F, -2.5F, -1.5F);
		leftclaw.setTextureSize(128, 64);
		setRotation(leftclaw, -0.4537856F, 0F, -0.4363323F);
		waist = new ModelRenderer(this, 64, 6);
		waist.addBox(-3.5F, 9F, -3F, 7, 3, 4);
		waist.setRotationPoint(0F, -4F, -2F);
		waist.setTextureSize(128, 64);
		setRotation(waist, 0.1745329F, 0F, 0F);
		tail1 = new ModelRenderer(this, 64, 13);
		tail1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		tail1.setRotationPoint(0F, 6F, 0F);
		tail1.setTextureSize(128, 64);
		setRotation(tail1, 0.5235988F, 0F, 0F);
		tail2 = new ModelRenderer(this, 64, 24);
		tail2.addBox(-1F, 8F, -2.5F, 2, 6, 2);
		tail2.setRotationPoint(0F, 6F, 0F);
		tail2.setTextureSize(128, 64);
		setRotation(tail2, 0.6981317F, 0F, 0F);
		tail3 = new ModelRenderer(this, 64, 32);
		tail3.addBox(-0.5F, 13.5F, -4.5F, 1, 6, 1);
		tail3.setRotationPoint(0F, 6F, 0F);
		tail3.setTextureSize(128, 64);
		setRotation(tail3, 0.8726646F, 0F, 0F);
		rightleg1 = new ModelRenderer(this, 86, 0);
		rightleg1.addBox(-1.5F, 0.5F, -1.5F, 3, 11, 3);
		rightleg1.setRotationPoint(-2F, 6F, 0F);
		rightleg1.setTextureSize(128, 64);
		setRotation(rightleg1, -0.3490659F, 0.1745329F, 0F);
		leftleg1 = new ModelRenderer(this, 86, 0);
		leftleg1.addBox(-1.5F, 0.5F, -1.5F, 3, 11, 3);
		leftleg1.setRotationPoint(2F, 6F, 0F);
		leftleg1.setTextureSize(128, 64);
		setRotation(leftleg1, -0.3490659F, -0.1745329F, 0F);
		ModelRenderer rightleg2 = new ModelRenderer(this, 86, 14);
		rightleg2.addBox(-2F, 1.5F, -2F, 4, 8, 4);
		rightleg2.setRotationPoint(-2F, 6F, 0F);
		rightleg2.setTextureSize(128, 64);
		setRotation(rightleg2, -0.3490659F, 0.1745329F, 0F);
		ModelRenderer leftleg2 = new ModelRenderer(this, 86, 14);
		leftleg2.addBox(-2F, 1.5F, -2F, 4, 8, 4);
		leftleg2.setRotationPoint(2F, 6F, 0F);
		leftleg2.setTextureSize(128, 64);
		setRotation(leftleg2, -0.3490659F, -0.1745329F, 0F);
		ModelRenderer rightleg3 = new ModelRenderer(this, 86, 26);
		rightleg3.addBox(-1F, 10.5F, -1F, 2, 2, 5);
		rightleg3.setRotationPoint(-2F, 6F, 0F);
		rightleg3.setTextureSize(128, 64);
		setRotation(rightleg3, -0.3490659F, 0.1745329F, 0F);
		ModelRenderer leftleg3 = new ModelRenderer(this, 86, 26);
		leftleg3.addBox(-1F, 10.5F, -1F, 2, 2, 5);
		leftleg3.setRotationPoint(2F, 6F, 0F);
		leftleg3.setTextureSize(128, 64);
		setRotation(leftleg3, -0.3490659F, -0.1745329F, 0F);
		ModelRenderer rightleg4 = new ModelRenderer(this, 86, 33);
		rightleg4.addBox(-1.5F, 3.5F, -16.5F, 3, 2, 6);
		rightleg4.setRotationPoint(-2F, 6F, 0F);
		rightleg4.setTextureSize(128, 64);
		setRotation(rightleg4, 1.22173F, 0.1745329F, 0F);
		ModelRenderer leftleg4 = new ModelRenderer(this, 86, 33);
		leftleg4.addBox(-1.5F, 3.5F, -16.5F, 3, 2, 6);
		leftleg4.setRotationPoint(2F, 6F, 0F);
		leftleg4.setTextureSize(128, 64);
		setRotation(leftleg4, 1.22173F, -0.1745329F, 0F);
		ModelRenderer rightleg5 = new ModelRenderer(this, 86, 41);
		rightleg5.addBox(-1.5F, -4.5F, -18F, 3, 4, 1);
		rightleg5.setRotationPoint(-2F, 6F, 0F);
		rightleg5.setTextureSize(128, 64);
		setRotation(rightleg5, 1.570796F, 0.1745329F, 0F);
		ModelRenderer leftleg5 = new ModelRenderer(this, 86, 41);
		leftleg5.addBox(-1.5F, -4.5F, -18F, 3, 4, 1);
		leftleg5.setRotationPoint(2F, 6F, 0F);
		leftleg5.setTextureSize(128, 64);
		setRotation(leftleg5, 1.570796F, -0.1745329F, 0F);
		rightwing = new ModelRenderer(this, 104, 34);
		rightwing.addBox(0F, -4F, 0F, 0, 18, 12);
		rightwing.setRotationPoint(-2F, -2F, 0F);
		rightwing.setTextureSize(128, 64);
		setRotation(rightwing, 0.5235988F, -0.5235988F, 0F);
		leftwing = new ModelRenderer(this, 104, 34);
		leftwing.mirror = true;
		leftwing.addBox(0F, -4F, 0F, 0, 18, 12);
		leftwing.setRotationPoint(2F, -2F, 0F);
		leftwing.setTextureSize(128, 64);
		setRotation(leftwing, 0.5235988F, 0.5235988F, 0F);

		convertToChild(head, righthorn);
		convertToChild(head, lefthorn);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightarm, rightclaw);
		convertToChild(leftarm, leftclaw);
		convertToChild(rightleg1, rightleg2);
		convertToChild(rightleg1, rightleg3);
		convertToChild(rightleg1, rightleg4);
		convertToChild(rightleg1, rightleg5);
		convertToChild(leftleg1, leftleg2);
		convertToChild(leftleg1, leftleg3);
		convertToChild(leftleg1, leftleg4);
		convertToChild(leftleg1, leftleg5);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddle.render(scale);
		bodymiddlebutton.render(scale);
		bodybottom.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		waist.render(scale);
		tail1.render(scale);
		tail2.render(scale);
		tail3.render(scale);
		rightleg1.render(scale);
		leftleg1.render(scale);
		rightwing.render(scale);
		leftwing.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = (headPitch / 57.295776F) + 0.1745329F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (isCarrying) {
			rightarm.rotateAngleX -= 0.5F;
			leftarm.rotateAngleX -= 0.5F;
			rightarm.rotateAngleZ += 0.05F;
			leftarm.rotateAngleZ -= 0.05F;
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.rotateAngleY -= 0.5235988F;
		leftwing.rotateAngleY += 0.5235988F;

		tail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(3);
		tail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(6);
		tail3.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(9);

		// legs
		rightleg1.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 1.5F;
		rightleg1.rotateAngleX -= 0.3490659F;
		leftleg1.rotateAngleX = (MathHelper.cos(limbSwing * 0.6665F + (float) Math.PI) * 0.5F * limbSwingAmount) * 1.5F;
		leftleg1.rotateAngleX -= 0.3490659F;
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
		rightarm.rotateAngleX += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public void setCarrying(boolean carrying) {
		isCarrying = carrying;
	}
}
