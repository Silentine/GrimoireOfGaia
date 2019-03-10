package gaia.model;

import gaia.entity.debug.EntityDebugMob;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelDebugMob extends ModelGaia {

	ModelRenderer head;
	ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer headleaf;
	ModelRenderer hair;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer rightearback;
	ModelRenderer leftearback;
	ModelRenderer backpack;
	ModelRenderer bodycover;
	ModelRenderer rightarmclothupper;
	ModelRenderer leftarmclothupper;
	ModelRenderer rightarmcloth;
	ModelRenderer leftarmcloth;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer rightlegcloth;
	ModelRenderer rightlegclothlower;
	ModelRenderer leftlegcloth;
	ModelRenderer leftlegclothlower;
	ModelRenderer rightsandal;
	ModelRenderer leftsandal;

	public ModelDebugMob() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleg, 0F, 0F, 0F);
		headleaf = new ModelRenderer(this, 36, 32);
		headleaf.addBox(-2.5F, -7.5F, -0.5F, 5, 0, 6);
		headleaf.setRotationPoint(0F, 1F, 0F);
		setRotation(headleaf, 0.7853982F, 0F, 0F);
		hair = new ModelRenderer(this, 36, 21);
		hair.addBox(-4.5F, -5F, -2.5F, 9, 6, 5);
		hair.setRotationPoint(0F, 1F, 0F);
		setRotation(hair, 0F, 0F, 0F);
		rightear = new ModelRenderer(this, 36, 14);
		rightear.addBox(0F, 0F, -4F, 3, 3, 4);
		rightear.setRotationPoint(-2F, -5F, 2F);
		setRotation(rightear, -0.7853982F, 0.7853982F, 0F);
		leftear = new ModelRenderer(this, 36, 14);
		leftear.mirror = true;
		leftear.addBox(-3F, 0F, -4F, 3, 3, 4);
		leftear.setRotationPoint(2F, -5F, 2F);
		setRotation(leftear, -0.7853982F, -0.7853982F, 0F);
		rightearback = new ModelRenderer(this, 50, 14);
		rightearback.addBox(-0.01F, -0.01F, -3F, 2, 2, 2);
		rightearback.setRotationPoint(-2F, -5F, 2F);
		setRotation(rightearback, -0.7853982F, 0.7853982F, 0F);
		leftearback = new ModelRenderer(this, 50, 14);
		leftearback.mirror = true;
		leftearback.addBox(-1.99F, -0.01F, -3F, 2, 2, 2);
		leftearback.setRotationPoint(2F, -5F, 2F);
		setRotation(leftearback, -0.7853982F, -0.7853982F, 0F);
		backpack = new ModelRenderer(this, 64, 10);
		backpack.addBox(-3F, 0F, 2F, 6, 6, 6);
		backpack.setRotationPoint(0F, 1F, 0F);
		setRotation(backpack, -0.122173F, 0F, 0F);
		bodycover = new ModelRenderer(this, 64, 0);
		bodycover.addBox(-2.5F, 3F, -1.6F, 5, 10, 0);
		bodycover.setRotationPoint(0F, 1F, 0F);
		setRotation(bodycover, -0.0872665F, 0F, 0F);
		rightarmclothupper = new ModelRenderer(this, 88, 0);
		rightarmclothupper.addBox(-3F, 0F, -2F, 4, 2, 4);
		rightarmclothupper.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmclothupper, 0F, 0F, 0.1745329F);
		leftarmclothupper = new ModelRenderer(this, 88, 0);
		leftarmclothupper.mirror = true;
		leftarmclothupper.addBox(-1F, 0F, -2F, 4, 2, 4);
		leftarmclothupper.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmclothupper, 0F, 0F, -0.1745329F);
		rightarmcloth = new ModelRenderer(this, 88, 6);
		rightarmcloth.addBox(-2.5F, 2F, -1.5F, 3, 8, 3);
		rightarmcloth.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmcloth, 0F, 0F, 0.1745329F);
		leftarmcloth = new ModelRenderer(this, 88, 6);
		leftarmcloth.mirror = true;
		leftarmcloth.addBox(-0.5F, 2F, -1.5F, 3, 8, 3);
		leftarmcloth.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmcloth, 0F, 0F, -0.1745329F);
		tail1 = new ModelRenderer(this, 88, 17);
		tail1.addBox(-2F, -2F, 0F, 4, 4, 4);
		tail1.setRotationPoint(0F, 11F, 2F);
		setRotation(tail1, 0F, 0F, 0F);
		tail2 = new ModelRenderer(this, 88, 25);
		tail2.addBox(-1.5F, -1.5F, 0F, 3, 3, 3);
		tail2.setRotationPoint(0F, 11F, 6F);
		setRotation(tail2, 0F, 0F, 0F);
		tail3 = new ModelRenderer(this, 88, 31);
		tail3.addBox(-1F, -1F, 0F, 2, 2, 2);
		tail3.setRotationPoint(0F, 11F, 9F);
		setRotation(tail3, 0F, 0F, 0F);
		rightlegcloth = new ModelRenderer(this, 104, 0);
		rightlegcloth.addBox(-2F, 0F, -2F, 4, 10, 4);
		rightlegcloth.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightlegcloth, 0F, 0F, 0F);
		rightlegclothlower = new ModelRenderer(this, 104, 14);
		rightlegclothlower.addBox(-2.5F, 3.5F, -2.5F, 5, 6, 5);
		rightlegclothlower.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightlegclothlower, 0F, 0F, 0F);
		leftlegcloth = new ModelRenderer(this, 104, 0);
		leftlegcloth.mirror = true;
		leftlegcloth.addBox(-2F, 0F, -2F, 4, 10, 4);
		leftlegcloth.setRotationPoint(2F, 11F, 0F);
		setRotation(leftlegcloth, 0F, 0F, 0F);
		leftlegclothlower = new ModelRenderer(this, 104, 14);
		leftlegclothlower.mirror = true;
		leftlegclothlower.addBox(-2.5F, 3.5F, -2.5F, 5, 6, 5);
		leftlegclothlower.setRotationPoint(2F, 11F, 0F);
		setRotation(leftlegclothlower, 0F, 0F, 0F);
		rightsandal = new ModelRenderer(this, 104, 25);
		rightsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		rightsandal.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightsandal, 0F, 0F, 0F);
		leftsandal = new ModelRenderer(this, 104, 25);
		leftsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		leftsandal.setRotationPoint(2F, 11F, 0F);
		setRotation(leftsandal, 0F, 0F, 0F);

		// When (convertToChild) is invoked, DO NOT include child in render below
		convertToChild(head, headleaf);
		convertToChild(head, hair);
		convertToChild(rightear, rightearback);
		convertToChild(head, rightear);
		convertToChild(leftear, leftearback);
		convertToChild(head, leftear);

		convertToChild(rightarm, rightarmclothupper);
		convertToChild(rightarm, rightarmcloth);
		convertToChild(leftarm, leftarmclothupper);
		convertToChild(leftarm, leftarmcloth);

		convertToChild(bodytop, backpack);
		convertToChild(bodytop, bodycover);
		convertToChild(tail2, tail3);
		convertToChild(tail1, tail2);

		convertToChild(rightleg, rightlegcloth);
		convertToChild(leftleg, leftlegcloth);
		convertToChild(rightleg, rightlegclothlower);
		convertToChild(leftleg, leftlegclothlower);
		convertToChild(rightleg, rightsandal);
		convertToChild(leftleg, leftsandal);
	}

	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

		// offset
		// Switch triggering from client data changing
		EntityDebugMob mob = (EntityDebugMob) entityIn;
		if (mob.getSitting()) {
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 10.0F * scale, 0.0F);
			GlStateManager.rotate(70F, 70, 0, 0);
		}

		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddle.render(scale);
		bodymiddlebutton.render(scale);
		bodybottom.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		tail1.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}

		if (mob.getSitting()) {
			GlStateManager.popMatrix();
		}
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		float earDefaultAngleX = -0.7853982F;

		rightear.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		rightear.rotateAngleX += earDefaultAngleX;
		leftear.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		leftear.rotateAngleX += earDefaultAngleX;

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headTilt(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		}

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail2.rotateAngleX = -0.785398F;
		tail3.rotateAngleX = +0.3926991F;

		tail1.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(1);
		tail2.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(2);
		tail3.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(4);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.1F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;

		// Important Casting call
		EntityDebugMob mob = (EntityDebugMob) entityIn;

		// Switch triggering from client data changing
		if (mob.getSitting()) {
			rightleg.rotateAngleX = rightleg.rotateAngleX - 190;
			leftleg.rotateAngleX = leftleg.rotateAngleX - 70;
			head.rotateAngleX = head.rotateAngleX - 70;
			headeyes.rotateAngleX = head.rotateAngleX;
			headaccessory.rotateAngleX = head.rotateAngleX;
			rightarm.rotateAngleX = rightarm.rotateAngleX - 190;
			leftarm.rotateAngleX = leftarm.rotateAngleX - 8;
		}
	}

	/*
	 * TODO Create a method to display death animations
	 * 
	 * @see ModelEnderman
	 * 
	 * @see RenderEnderman
	 * 
	 * @see EntityEnderman
	 */
//	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime) {
//		super.setLivingAnimations(entitylivingbaseIn, p_78086_2_, p_78086_3_, partialTickTime);
//		// boolean onDeath = ((EntityGaiaAnubis)entitylivingbaseIn).onDeath(partialTickTime);
//
//		EntityExampleMob entity = (EntityExampleMob) entitylivingbaseIn;
//
//		if (entity.onDeath = true) {
//			headeyes.showModel = true;
//		} else {
//			headeyes.showModel = false;
//		}
//
//		if (entity.onDeath = true) {
//			rightarm.rotateAngleX -= 0.7853981F;
//			leftarm.rotateAngleX -= 0.7853981F;
//			rightleg.rotateAngleX -= 0.7853981F;
//			leftarm.rotateAngleX -= 0.7853981F;
//		}
//	}

	public void holdingMelee(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float f6;
		float f7;

		f6 = swingProgress;
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

	public void headTilt(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float f6;
		float f7;

		f6 = swingProgress;
		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		head.rotateAngleZ = (float) ((double) head.rotateAngleZ - ((double) f7 * 1.2D + (double) f8));
		head.rotateAngleZ += (bodytop.rotateAngleY * 2.0F);
		head.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
