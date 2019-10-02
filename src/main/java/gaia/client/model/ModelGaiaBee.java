package gaia.client.model;

import gaia.entity.assist.GaiaBeeEntity;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaBee<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel anchor;

	private RendererModel head;
	private RendererModel headeyes;
	private RendererModel headaccessory;
	private RendererModel neck;
	private RendererModel bodytop;
	private RendererModel bodymiddle;
	private RendererModel bodymiddlebutton;
	private RendererModel bodybottom;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel rightleg;
	private RendererModel leftleg;
	private RendererModel hair;
	private RendererModel rightantenna;
	private RendererModel leftantenna;
	private RendererModel collar;
	private RendererModel rightwing1;
	private RendererModel rightwing2;
	private RendererModel leftwing1;
	private RendererModel leftwing2;
	private RendererModel rightarmlower;
	private RendererModel leftarmlower;
	private RendererModel thorax1;
	private RendererModel thorax2;
	private RendererModel thorax3;
	private RendererModel rightleglower;
	private RendererModel leftleglower;
	private RendererModel rightlegfoot;
	private RendererModel leftlegfoot;

	public ModelGaiaBee() {
		textureWidth = 128;
		textureHeight = 64;

		// Used to adjust height
		float rotationPointZ = 0F;

		anchor = new RendererModel(this, 38, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -7F, 0F + rotationPointZ);
		setRotation(anchor, 0F, 0F, 0F);

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3.5F, -6.5F, -3.25F, 7, 7, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, 0F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, -0.5F, -2.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 7F, 1.5F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 0F, -2.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 7F, 1.5F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 0F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 9F, 1F);
		setRotation(bodybottom, 0F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3.5F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3.5F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 7, 3);
		rightleg.setRotationPoint(-2F, 11F, 0.5F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 7, 3);
		leftleg.setRotationPoint(2F, 11F, 0.5F);
		setRotation(leftleg, 0F, 0F, 0F);
		hair = new RendererModel(this, 36, 14);
		hair.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair.setRotationPoint(0F, 1F, 0F);
		setRotation(hair, 0F, 0F, 0F);
		rightantenna = new RendererModel(this, 36, 25);
		rightantenna.addBox(-2F, -8F, -5F, 1, 4, 4);
		rightantenna.setRotationPoint(0F, 1F, 0F);
		setRotation(rightantenna, 0F, 0.1745329F, 0F);
		leftantenna = new RendererModel(this, 36, 25);
		leftantenna.addBox(1F, -8F, -5F, 1, 4, 4);
		leftantenna.setRotationPoint(0F, 1F, 0F);
		setRotation(leftantenna, 0F, -0.1745329F, 0F);
		collar = new RendererModel(this, 36, 33);
		collar.addBox(-3.5F, 0F, -1.5F, 7, 3, 3);
		collar.setRotationPoint(0F, 1F, 0F);
		setRotation(collar, 0F, 0F, 0F);
		rightwing1 = new RendererModel(this, 64, -10);
		rightwing1.addBox(0F, -3F, 0F, 0, 6, 10);
		rightwing1.setRotationPoint(-1.5F, 3F, 1.5F);
		setRotation(rightwing1, 0.5235988F, -0.7853982F, 0F);
		rightwing2 = new RendererModel(this, 64, -10);
		rightwing2.addBox(0.5F, -3F, 0F, 0, 6, 10);
		rightwing2.setRotationPoint(-1.5F, 3F, 1.5F);
		setRotation(rightwing2, 0F, -0.7853982F, 0F);
		leftwing1 = new RendererModel(this, 74, -10);
		leftwing1.addBox(0F, -3F, 0F, 0, 6, 10);
		leftwing1.setRotationPoint(1.5F, 3F, 1.5F);
		setRotation(leftwing1, 0.5235988F, 0.7853982F, 0F);
		leftwing2 = new RendererModel(this, 74, -10);
		leftwing1.mirror = true;
		leftwing2.addBox(-0.5F, -3F, 0F, 0, 6, 10);
		leftwing2.setRotationPoint(1.5F, 3F, 1.5F);
		setRotation(leftwing2, 0F, 0.7853982F, 0F);
		rightarmlower = new RendererModel(this, 36, 39);
		rightarmlower.addBox(-2.5F, 8F, -1.5F, 3, 2, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new RendererModel(this, 36, 39);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-0.5F, 8F, -1.5F, 3, 2, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		thorax1 = new RendererModel(this, 64, 6);
		thorax1.addBox(-1.5F, 0F, -1F, 3, 3, 3);
		thorax1.setRotationPoint(0F, 7.5F, 1F);
		setRotation(thorax1, 0F, 0F, 0F);
		thorax2 = new RendererModel(this, 64, 12);
		thorax2.addBox(-2.5F, -1F, 0F, 5, 5, 5);
		thorax2.setRotationPoint(0F, 7.5F, 3F);
		setRotation(thorax2, 0F, 0F, 0F);
		thorax3 = new RendererModel(this, 64, 22);
		thorax3.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
		thorax3.setRotationPoint(0F, 11.5F, 8F);
		rightleglower = new RendererModel(this, 24, 22);
		rightleglower.addBox(-1.49F, 0F, 0F, 3, 7, 3);
		rightleglower.setRotationPoint(-2F, 17F, -1F);
		setRotation(rightleglower, 0F, 0F, 0F);
		leftleglower = new RendererModel(this, 24, 22);
		leftleglower.mirror = true;
		leftleglower.addBox(-1.51F, 0F, 0F, 3, 7, 3);
		leftleglower.setRotationPoint(2F, 17F, -1F);
		setRotation(leftleglower, 0F, 0F, 0F);
		rightlegfoot = new RendererModel(this, 94, 0);
		rightlegfoot.addBox(-2F, 6F, -0.5F, 4, 1, 4);
		rightlegfoot.setRotationPoint(-2F, 17F, -1F);
		setRotation(rightlegfoot, 0F, 0F, 0F);
		leftlegfoot = new RendererModel(this, 94, 0);
		leftlegfoot.mirror = true;
		leftlegfoot.addBox(-2F, 6F, -0.5F, 4, 1, 4);
		leftlegfoot.setRotationPoint(2F, 17F, -1F);
		setRotation(leftlegfoot, 0F, 0F, 0F);

		// joints
		// head
		convertToChild(head, headeyes);
		convertToChild(head, headaccessory);
		convertToChild(head, hair);
		convertToChild(head, rightantenna);
		convertToChild(head, leftantenna);
		// upperBody
		convertToChild(bodytop, rightchest);
		convertToChild(bodytop, leftchest);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(bodytop, rightarm);
		convertToChild(bodytop, leftarm);
		convertToChild(bodytop, collar);
		convertToChild(rightwing2, rightwing1);
		convertToChild(leftwing2, leftwing1);
		convertToChild(bodytop, rightwing2);
		convertToChild(bodytop, leftwing2);
		// lowerBody
		convertToChild(bodymiddle, bodymiddlebutton);
		convertToChild(rightleglower, rightlegfoot);
		convertToChild(leftleglower, leftlegfoot);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
		convertToChild(bodybottom, rightleg);
		convertToChild(bodybottom, leftleg);
		convertToChild(thorax2, thorax3);
		convertToChild(thorax1, thorax2);
		convertToChild(bodybottom, thorax1);
		// finalConnection
		convertToChild(bodymiddle, bodybottom);
		convertToChild(bodytop, bodymiddle);
		convertToChild(neck, bodytop);
		convertToChild(neck, head);

		// anchor
		anchor.addChild(neck);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstack = ((MobEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.HEAD);
		GaiaBeeEntity entityGaiaBee = (GaiaBeeEntity) entityIn;

		float floatSpeed = 0.2F;
		float floatRange = 2.0F;

		boolean moveExtremities;
		float armsAngleMoving;
		float legsAngleMoving;
		float defaultAngle = 0;

		if (entityGaiaBee.isMoving()) {
			moveExtremities = false;
			armsAngleMoving = -degToRad(30);
			legsAngleMoving = -degToRad(75);

			bodytop.rotateAngleX = degToRad(30);
			rightarm.rotateAngleX = armsAngleMoving;
			leftarm.rotateAngleX = armsAngleMoving;
			bodymiddle.rotateAngleX = degToRad(25);
			thorax1.rotateAngleX = -degToRad(30);
			bodybottom.rotateAngleX = degToRad(15);
			rightleg.rotateAngleX = legsAngleMoving;
			leftleg.rotateAngleX = legsAngleMoving;
			rightleglower.rotateAngleX = degToRad(75);
			leftleglower.rotateAngleX = degToRad(75);
		} else {
			moveExtremities = true;
			armsAngleMoving = defaultAngle;
			legsAngleMoving = defaultAngle;

			bodytop.rotateAngleX = defaultAngle;
			rightarm.rotateAngleX = armsAngleMoving;
			leftarm.rotateAngleX = armsAngleMoving;
			bodymiddle.rotateAngleX = defaultAngle;
			thorax1.rotateAngleX = defaultAngle;
			bodybottom.rotateAngleX = defaultAngle;
			rightleg.rotateAngleX = legsAngleMoving;
			leftleg.rotateAngleX = legsAngleMoving;
			rightleglower.rotateAngleX = defaultAngle;
			leftleglower.rotateAngleX = defaultAngle;
		}

		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		if (itemstack.isEmpty()) {
			if (moveExtremities) {
				rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
				leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
			}

			if (!moveExtremities) {
				rightarm.rotateAngleX = armsAngleMoving;
				leftarm.rotateAngleX = armsAngleMoving;
			}

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		// body
		float swingSpeed = 0.2F;
		float angleRange = 1.0F;
		float wingDefaultAngleY = 0.7853982F;

		rightwing2.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		rightwing2.rotateAngleY -= wingDefaultAngleY;
		leftwing2.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		leftwing2.rotateAngleY += wingDefaultAngleY;

		thorax1.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);

		// legs
		if (itemstack.isEmpty()) {
			if (moveExtremities) {
				rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
				leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
			}

			float swingSpeed2 = 0.2F;
			float angleRange2 = 0.1F;

			if (!moveExtremities) {
				rightleg.rotateAngleX = legsAngleMoving;
				leftleg.rotateAngleX = legsAngleMoving;
			}

			rightleg.rotateAngleZ = MathHelper.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * -0.5F;
			leftleg.rotateAngleZ = MathHelper.cos(ageInTicks * swingSpeed2) * angleRange2 * -0.5F;
		}
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

	private void animationThrow() {
		float armsAngleThrow = -degToRad(60);
		float legsAngleThrow = degToRad(20);

		rightarm.rotateAngleX = armsAngleThrow;
		leftarm.rotateAngleX = armsAngleThrow;
		rightleg.rotateAngleX = legsAngleThrow;
		leftleg.rotateAngleX = legsAngleThrow;
	}

	public RendererModel getAnchor() {
		return anchor;
	}
}
