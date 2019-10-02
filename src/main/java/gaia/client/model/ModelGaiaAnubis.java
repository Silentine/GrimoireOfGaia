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
public class ModelGaiaAnubis<T extends MobEntity> extends ModelGaia<T> {

	RendererModel head;
	RendererModel headeyes;
	RendererModel headaccessory;
	RendererModel neck;
	RendererModel bodytop;
	RendererModel bodymid;
	RendererModel bodymidbutton;
	RendererModel bodybottom;
	RendererModel rightchest;
	RendererModel leftchest;
	RendererModel rightarm;
	RendererModel leftarm;
	RendererModel rightleg;
	RendererModel leftleg;
	RendererModel bodytopmale;
	RendererModel bodymidmale;
	RendererModel hair1;
	RendererModel hair2;
	RendererModel mantle;
	RendererModel tail;
	RendererModel waist;

	public ModelGaiaAnubis() {
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
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 9, 7);
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
		bodymid = new RendererModel(this, 0, 25);
		bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymid.setRotationPoint(0F, 1F, 0F);
		bodymid.setTextureSize(128, 64);
		setRotation(bodymid, 0F, 0F, 0F);
		bodymidbutton = new RendererModel(this, 0, 25);
		bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymidbutton.setRotationPoint(0F, 1F, 0F);
		bodymidbutton.setTextureSize(128, 64);
		setRotation(bodymidbutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, 0F, 0F, 0F);
		bodytopmale = new RendererModel(this, 0, 50);
		bodytopmale.addBox(-3F, 0F, -1.5F, 6, 6, 3);
		bodytopmale.setRotationPoint(0F, 1F, 0F);
		bodytopmale.setTextureSize(128, 64);
		setRotation(bodytopmale, -0.0872665F, 0F, 0F);
		bodymidmale = new RendererModel(this, 0, 59);
		bodymidmale.addBox(-2.5F, 5.5F, -1.5F, 5, 3, 2);
		bodymidmale.setRotationPoint(0F, 1F, 0F);
		bodymidmale.setTextureSize(128, 64);
		setRotation(bodymidmale, 0F, 0F, 0F);
		hair1 = new RendererModel(this, 36, 16);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(128, 64);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new RendererModel(this, 36, 27);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(128, 64);
		setRotation(hair2, 0F, 0F, 0F);
		RendererModel crown = new RendererModel(this, 36, 39);
		crown.addBox(-1F, -8F, -4.6F, 2, 3, 1);
		crown.setRotationPoint(0F, 1F, 0F);
		crown.setTextureSize(128, 64);
		setRotation(crown, 0F, 0F, 0F);
		RendererModel rightear = new RendererModel(this, 36, 43);
		rightear.addBox(-4.5F, -10F, -1.5F, 3, 4, 3);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(128, 64);
		setRotation(rightear, 0F, 0F, 0F);
		RendererModel leftear = new RendererModel(this, 36, 43);
		leftear.mirror = true;
		leftear.addBox(1.5F, -10F, -1.5F, 3, 4, 3);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(128, 64);
		setRotation(leftear, 0F, 0F, 0F);
		mantle = new RendererModel(this, 36, 50);
		mantle.addBox(-5F, 0F, -2F, 10, 2, 4);
		mantle.setRotationPoint(0F, 1F, 0F);
		mantle.setTextureSize(128, 64);
		mantle.mirror = true;
		setRotation(mantle, 0F, 0F, 0F);
		RendererModel rightarmlower = new RendererModel(this, 64, 0);
		rightarmlower.addBox(-2.5F, 2F, -1.5F, 2, 8, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower.setTextureSize(128, 64);
		rightarmlower.mirror = true;
		setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		RendererModel leftarmlower = new RendererModel(this, 64, 0);
		leftarmlower.mirror = true;
		leftarmlower.addBox(0.5F, 2F, -1.5F, 2, 8, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower.setTextureSize(128, 64);
		setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		RendererModel rightarmhand = new RendererModel(this, 64, 11);
		rightarmhand.addBox(-1.5F, 7.5F, -2F, 2, 4, 4);
		rightarmhand.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmhand.setTextureSize(128, 64);
		setRotation(rightarmhand, 0F, 0F, 0.1745329F);
		RendererModel leftarmhand = new RendererModel(this, 64, 11);
		leftarmhand.mirror = true;
		leftarmhand.addBox(-0.5F, 7.5F, -2F, 2, 4, 4);
		leftarmhand.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmhand.setTextureSize(128, 64);
		setRotation(leftarmhand, 0F, 0F, -0.1745329F);
		tail = new RendererModel(this, 76, 0);
		tail.addBox(-1F, 7.5F, -4F, 2, 10, 2);
		tail.setRotationPoint(0F, 1F, 0F);
		tail.setTextureSize(128, 64);
		tail.mirror = true;
		setRotation(tail, 0.5235988F, 0F, 0F);
		waist = new RendererModel(this, 76, 12);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(128, 64);
		setRotation(waist, 0.0872665F, 0F, 0F);
		RendererModel rightleglower = new RendererModel(this, 76, 20);
		rightleglower.addBox(-2F, 5F, -2F, 4, 6, 4);
		rightleglower.setRotationPoint(-2F, 11F, 0F);
		rightleglower.setTextureSize(128, 64);
		setRotation(rightleglower, 0F, 0F, 0F);
		RendererModel leftleglower = new RendererModel(this, 76, 20);
		leftleglower.mirror = true;
		leftleglower.addBox(-2F, 5F, -2F, 4, 6, 4);
		leftleglower.setRotationPoint(2F, 11F, 0F);
		leftleglower.setTextureSize(128, 64);
		leftleglower.mirror = true;
		setRotation(leftleglower, 0F, 0F, 0F);
		leftleglower.mirror = false;
		RendererModel rightfoot = new RendererModel(this, 76, 30);
		rightfoot.addBox(-2F, 11F, -3.5F, 4, 2, 4);
		rightfoot.setRotationPoint(-2F, 11F, 0F);
		rightfoot.setTextureSize(128, 64);
		rightfoot.mirror = true;
		setRotation(rightfoot, 0F, 0F, 0F);
		RendererModel leftfoot = new RendererModel(this, 76, 30);
		leftfoot.mirror = true;
		leftfoot.addBox(-2F, 11F, -3.5F, 4, 2, 4);
		leftfoot.setRotationPoint(2F, 11F, 0F);
		leftfoot.setTextureSize(128, 64);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, crown);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(getRightArm(), rightarmlower);
		convertToChild(getLeftArm(), leftarmlower);
		convertToChild(getRightArm(), rightarmhand);
		convertToChild(getLeftArm(), leftarmhand);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftfoot);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymid.render(scale);
		bodymidbutton.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		bodytopmale.render(scale);
		bodymidmale.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		mantle.render(scale);
		tail.render(scale);
		waist.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstack = ((MobEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.HEAD);
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
		
		if (itemstack.isEmpty()) {
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
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		if (itemstack.getItem() == Items.STICK) {
			animationCast();
		}

		// body
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(5);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
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
		rightarm.rotateAngleX = -1.0472F;
	}

	private void animationCast() {
		rightarm.rotateAngleX = -1.0472F;
		leftarm.rotateAngleX = -1.0472F;
		rightarm.rotateAngleZ = -0.261799F;
		leftarm.rotateAngleZ = +0.261799F;
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
