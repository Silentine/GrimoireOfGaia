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
public class ModelGaiaSuccubus<T extends MobEntity> extends ModelGaia<T> {
	RendererModel head;
	RendererModel headeyes;
	RendererModel headaccessory;
	RendererModel neck;
	RendererModel bodytop;
	RendererModel bodymiddle;
	RendererModel bodymiddlebutton;
	RendererModel bodybottom;
	RendererModel rightchest;
	RendererModel leftchest;
	RendererModel rightarm;
	RendererModel leftarm;
	RendererModel rightleg;
	RendererModel leftleg;
	RendererModel bodytopMale;
	RendererModel bodymiddleMale;
	RendererModel hair1;
	RendererModel hair2;
	RendererModel tail;
	RendererModel waist;
	RendererModel rightwing;
	RendererModel leftwing;

	public ModelGaiaSuccubus() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(128, 64);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(128, 64);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(128, 64);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 7F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 2F, 0F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		rightleg.setRotationPoint(-2F, 11F, -0.5F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, -0.1745329F, 0F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		leftleg.setRotationPoint(2F, 11F, -0.5F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, -0.1745329F, 0F, 0F);
		bodytopMale = new RendererModel(this, 0, 50);
		bodytopMale.addBox(-3F, 0F, -1.5F, 6, 6, 3);
		bodytopMale.setRotationPoint(0F, 1F, 0F);
		bodytopMale.setTextureSize(128, 64);
		setRotation(bodytopMale, -0.0872665F, 0F, 0F);
		bodymiddleMale = new RendererModel(this, 0, 59);
		bodymiddleMale.addBox(-2.5F, 5.5F, -1.5F, 5, 3, 2);
		bodymiddleMale.setRotationPoint(0F, 1F, 0F);
		bodymiddleMale.setTextureSize(128, 64);
		setRotation(bodymiddleMale, 0F, 0F, 0F);
		hair1 = new RendererModel(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(128, 64);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new RendererModel(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(128, 64);
		setRotation(hair2, 0F, 0F, 0F);
		RendererModel righthorn1 = new RendererModel(this, 36, 37);
		righthorn1.addBox(-4F, -7F, -2F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, 1F, 0F);
		righthorn1.setTextureSize(128, 64);
		setRotation(righthorn1, 0F, 0F, 0F);
		RendererModel righthorn2 = new RendererModel(this, 36, 41);
		righthorn2.addBox(-5F, -6F, -4F, 2, 2, 3);
		righthorn2.setRotationPoint(0F, 1F, 0F);
		righthorn2.setTextureSize(128, 64);
		setRotation(righthorn2, 0F, 0F, 0F);
		RendererModel righthorn3 = new RendererModel(this, 36, 46);
		righthorn3.addBox(-4F, -7F, -5F, 2, 2, 2);
		righthorn3.setRotationPoint(0F, 1F, 0F);
		righthorn3.setTextureSize(128, 64);
		setRotation(righthorn3, 0F, 0F, 0F);
		RendererModel righthorn4 = new RendererModel(this, 36, 50);
		righthorn4.addBox(-2.5F, -7.5F, -4.5F, 1, 1, 1);
		righthorn4.setRotationPoint(0F, 1F, 0F);
		righthorn4.setTextureSize(128, 64);
		setRotation(righthorn4, 0F, 0F, 0F);
		RendererModel lefthorn1 = new RendererModel(this, 36, 37);
		lefthorn1.mirror = true;
		lefthorn1.addBox(2F, -7F, -2F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, 1F, 0F);
		lefthorn1.setTextureSize(128, 64);
		setRotation(lefthorn1, 0F, 0F, 0F);
		RendererModel lefthorn2 = new RendererModel(this, 36, 41);
		lefthorn2.mirror = true;
		lefthorn2.addBox(3F, -6F, -4F, 2, 2, 3);
		lefthorn2.setRotationPoint(0F, 1F, 0F);
		lefthorn2.setTextureSize(128, 64);
		setRotation(lefthorn2, 0F, 0F, 0F);
		RendererModel lefthorn3 = new RendererModel(this, 36, 46);
		lefthorn3.mirror = true;
		lefthorn3.addBox(2F, -7F, -5F, 2, 2, 2);
		lefthorn3.setRotationPoint(0F, 1F, 0F);
		lefthorn3.setTextureSize(128, 64);
		setRotation(lefthorn3, 0F, 0F, 0F);
		RendererModel lefthorn4 = new RendererModel(this, 36, 50);
		lefthorn4.mirror = true;
		lefthorn4.addBox(1.5F, -7.5F, -4.5F, 1, 1, 1);
		lefthorn4.setRotationPoint(0F, 1F, 0F);
		lefthorn4.setTextureSize(128, 64);
		setRotation(lefthorn4, 0F, 0F, 0F);
		RendererModel rightpauldron = new RendererModel(this, 64, 0);
		rightpauldron.addBox(-2.5F, -2F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		rightpauldron.setTextureSize(128, 64);
		setRotation(rightpauldron, 0.0872665F, 0F, 0.1745329F);
		RendererModel leftpauldron = new RendererModel(this, 64, 0);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -2F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftpauldron.setTextureSize(128, 64);
		setRotation(leftpauldron, 0.0872665F, 0F, -0.1745329F);
		RendererModel rightarmlower = new RendererModel(this, 64, 6);
		rightarmlower.addBox(-4F, 5F, -1.5F, 2, 6, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower.setTextureSize(128, 64);
		setRotation(rightarmlower, 0.0872665F, 0F, 0F);
		RendererModel leftarmlower = new RendererModel(this, 64, 6);
		leftarmlower.mirror = true;
		leftarmlower.addBox(2F, 5F, -1.5F, 2, 6, 3);
		leftarmlower.setRotationPoint(3F, 2.5F, 0F);
		leftarmlower.setTextureSize(128, 64);
		setRotation(leftarmlower, 0.0872665F, 0F, 0F);
		tail = new RendererModel(this, 64, 15);
		tail.addBox(-1F, 0F, 0F, 2, 9, 0);
		tail.setRotationPoint(0F, 9F, 1.5F);
		tail.setTextureSize(128, 64);
		setRotation(tail, 0.3490659F, 0F, 0F);
		waist = new RendererModel(this, 64, 24);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(128, 64);
		setRotation(waist, 0.0872665F, 0F, 0F);
		RendererModel rightleglower = new RendererModel(this, 86, 0);
		rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		rightleglower.setTextureSize(128, 64);
		setRotation(rightleglower, -0.1745329F, 0F, 0F);
		RendererModel leftleglower = new RendererModel(this, 86, 0);
		leftleglower.mirror = true;
		leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		leftleglower.setRotationPoint(2F, 11F, -0.5F);
		leftleglower.setTextureSize(128, 64);
		setRotation(leftleglower, -0.1745329F, 0F, 0F);
		leftleglower.mirror = false;
		RendererModel rightfoot = new RendererModel(this, 86, 12);
		rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		rightfoot.setTextureSize(128, 64);
		setRotation(rightfoot, 0F, 0F, 0F);
		RendererModel leftfoot = new RendererModel(this, 86, 12);
		leftfoot.mirror = true;
		leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		leftfoot.setRotationPoint(2F, 11F, -0.5F);
		leftfoot.setTextureSize(128, 64);
		setRotation(leftfoot, 0F, 0F, 0F);
		RendererModel rightfootback = new RendererModel(this, 86, 18);
		rightfootback.addBox(-1F, 11F, 1F, 2, 2, 2);
		rightfootback.setRotationPoint(-2F, 11F, -0.5F);
		rightfootback.setTextureSize(128, 64);
		setRotation(rightfootback, 0F, 0F, 0F);
		RendererModel leftfootback = new RendererModel(this, 86, 18);
		leftfootback.mirror = true;
		leftfootback.addBox(-1F, 11F, 1F, 2, 2, 2);
		leftfootback.setRotationPoint(2F, 11F, -0.5F);
		leftfootback.setTextureSize(128, 64);
		setRotation(leftfootback, 0F, 0F, 0F);
		rightwing = new RendererModel(this, 104, 42);
		rightwing.addBox(0F, -1F, 0F, 0, 14, 8);
		rightwing.setRotationPoint(-1.5F, 2F, 2F);
		rightwing.setTextureSize(128, 64);
		setRotation(rightwing, 0.5235988F, -0.7853982F, 0F);
		leftwing = new RendererModel(this, 112, 42);
		leftwing.addBox(0F, -1F, 0F, 0, 14, 8);
		leftwing.setRotationPoint(1.5F, 2F, 2F);
		leftwing.setTextureSize(128, 64);
		setRotation(leftwing, 0.5235988F, 0.7853982F, 0F);
		RendererModel righthornMale3 = new RendererModel(this, 36, 57);
		righthornMale3.addBox(-5F, -8F, -1F, 2, 2, 2);
		righthornMale3.setRotationPoint(0F, 1F, 0F);
		righthornMale3.setTextureSize(128, 64);
		setRotation(righthornMale3, 0F, 0F, 0F);
		RendererModel lefthornMale3 = new RendererModel(this, 36, 57);
		lefthornMale3.mirror = true;
		lefthornMale3.addBox(3F, -8F, -1F, 2, 2, 2);
		lefthornMale3.setRotationPoint(0F, 1F, 0F);
		lefthornMale3.setTextureSize(128, 64);
		setRotation(lefthornMale3, 0F, 0F, 0F);
		RendererModel righthornMale4 = new RendererModel(this, 36, 62);
		righthornMale4.addBox(-3.5F, -8.5F, -1.5F, 1, 1, 1);
		righthornMale4.setRotationPoint(0F, 1F, 0F);
		righthornMale4.setTextureSize(128, 64);
		setRotation(righthornMale4, 0F, 0F, 0F);
		RendererModel lefthornMale4 = new RendererModel(this, 36, 62);
		lefthornMale4.mirror = true;
		lefthornMale4.addBox(2.5F, -8.5F, -1.5F, 1, 1, 1);
		lefthornMale4.setRotationPoint(0F, 1F, 0F);
		lefthornMale4.setTextureSize(128, 64);
		setRotation(lefthornMale4, 0F, 0F, 0F);

		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, righthorn4);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, lefthorn4);
		convertToChild(rightarm, rightpauldron);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftpauldron);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfoot);
		convertToChild(rightleg, rightfootback);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfoot);
		convertToChild(leftleg, leftfootback);
		convertToChild(head, righthornMale3);
		convertToChild(head, righthornMale4);
		convertToChild(head, lefthornMale3);
		convertToChild(head, lefthornMale4);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddle.render(scale);
		bodymiddlebutton.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		bodytopMale.render(scale);
		bodymiddleMale.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		tail.render(scale);
		waist.render(scale);
		rightwing.render(scale);
		leftwing.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstackChest = ((MobEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.CHEST);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		hair1.rotateAngleY = head.rotateAngleY;
		hair2.rotateAngleY = (head.rotateAngleY) * 0.75F;

		// arms
		if (itemstackChest.getItem() == Items.STICK) {
			rightarm.rotationPointX = -3F;
			leftarm.rotationPointX = 3F;
		}

		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * 1.0F * limbSwingAmount * 0.5F;
		--rightwing.rotateAngleY;
		++leftwing.rotateAngleY;

		float chestDefaultRotateAngleX = 0.7853982F;

		rightchest.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount) + chestDefaultRotateAngleX;
		leftchest.rotateAngleX = rightchest.rotateAngleX;

		tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.1745329F;
		leftleg.rotateAngleX -= 0.1745329F;
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

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
