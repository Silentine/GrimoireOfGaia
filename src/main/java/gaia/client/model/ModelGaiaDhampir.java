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
public class ModelGaiaDhampir<T extends MobEntity> extends ModelGaia<T> {
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
	private RendererModel mantle;
	private RendererModel cape1;
	private RendererModel cape2;
	private RendererModel waist;

	public ModelGaiaDhampir() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(64, 32);
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
		setRotation(leftchest, 0.7853982F, -0.1570796F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		hair = new RendererModel(this, 36, 14);
		hair.addBox(-1F, -2.5F, 2.5F, 2, 12, 2);
		hair.setRotationPoint(0F, 1F, 0F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0.3490659F, 0F, 0F);
		RendererModel righthair = new RendererModel(this, 36, 24);
		righthair.addBox(-4F, -6F, -1F, 0, 4, 4);
		righthair.setRotationPoint(0F, 1F, 0F);
		righthair.setTextureSize(64, 32);
		setRotation(righthair, 0F, -0.5235988F, 0F);
		RendererModel lefthair = new RendererModel(this, 36, 24);
		lefthair.addBox(4F, -6F, -1F, 0, 4, 4);
		lefthair.setRotationPoint(0F, 1F, 0F);
		lefthair.setTextureSize(64, 32);
		setRotation(lefthair, 0F, 0.5235988F, 0F);
		RendererModel hat1 = new RendererModel(this, 36, 20);
		hat1.addBox(-6F, -7F, -6F, 12, 2, 12);
		hat1.setRotationPoint(0F, 1F, 0F);
		hat1.setTextureSize(64, 32);
		setRotation(hat1, 0.0349066F, 0.9599311F, 0.0349066F);
		RendererModel hat2 = new RendererModel(this, 36, 34);
		hat2.addBox(-3F, -10F, -3F, 6, 3, 6);
		hat2.setRotationPoint(0F, 1F, 0F);
		hat2.setTextureSize(64, 32);
		setRotation(hat2, 0.0349066F, 0.7853982F, 0.0349066F);
		RendererModel hat3 = new RendererModel(this, 36, 43);
		hat3.addBox(-4F, -11F, 0F, 4, 3, 4);
		hat3.setRotationPoint(0F, 1F, 0F);
		hat3.setTextureSize(64, 32);
		setRotation(hat3, 0.0349066F, 0.9599311F, 0.0349066F);
		RendererModel hatflower = new RendererModel(this, 36, 50);
		hatflower.addBox(-3.5F, -11F, -3.5F, 7, 4, 7);
		hatflower.setRotationPoint(0F, 1F, 0F);
		hatflower.setTextureSize(64, 32);
		setRotation(hatflower, 0.0349066F, 0.7853982F, 0.0349066F);
		mantle = new RendererModel(this, 84, 0);
		mantle.addBox(-4F, -3F, -2F, 8, 4, 4);
		mantle.setRotationPoint(0F, 1F, 0F);
		mantle.setTextureSize(64, 32);
		setRotation(mantle, 0F, 0F, 0F);
		RendererModel rightpauldron = new RendererModel(this, 84, 8);
		rightpauldron.addBox(-2.5F, -1F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, 2F, 0F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0F, 0F, 0F);
		RendererModel leftpauldron = new RendererModel(this, 96, 8);
		leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftpauldron.setTextureSize(64, 32);
		setRotation(leftpauldron, 0F, 0F, 0F);
		cape1 = new RendererModel(this, 84, 14);
		cape1.addBox(-5F, 1F, -1F, 10, 6, 3);
		cape1.setRotationPoint(0F, 1F, 0F);
		cape1.setTextureSize(64, 32);
		setRotation(cape1, 0.3490659F, 0F, 0F);
		cape2 = new RendererModel(this, 84, 23);
		cape2.addBox(-5.5F, 6F, 0.5F, 11, 6, 3);
		cape2.setRotationPoint(0F, 1F, 0F);
		cape2.setTextureSize(64, 32);
		setRotation(cape2, 0.1745329F, 0F, 0F);
		waist = new RendererModel(this, 84, 32);
		waist.addBox(-4F, 7.5F, -3F, 8, 6, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		RendererModel rightboot = new RendererModel(this, 84, 42);
		rightboot.addBox(-2F, 4F, -2F, 4, 7, 4);
		rightboot.setRotationPoint(-2F, 11F, 0F);
		rightboot.setTextureSize(64, 32);
		setRotation(rightboot, 0F, 0F, 0F);
		RendererModel leftboot = new RendererModel(this, 84, 42);
		leftboot.addBox(-2F, 4F, -2F, 4, 7, 4);
		leftboot.setRotationPoint(2F, 11F, 0F);
		leftboot.setTextureSize(64, 32);
		setRotation(leftboot, 0F, 0F, 0F);

		convertToChild(head, righthair);
		convertToChild(head, lefthair);
		convertToChild(head, hat1);
		convertToChild(head, hat2);
		convertToChild(head, hat3);
		convertToChild(head, hatflower);
		convertToChild(rightarm, rightpauldron);
		convertToChild(leftarm, leftpauldron);
		convertToChild(rightleg, rightboot);
		convertToChild(leftleg, leftboot);
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
		hair.render(scale);
		mantle.render(scale);
		cape1.render(scale);
		cape2.render(scale);
		waist.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		ItemStack itemstack = ((MobEntity) entityIn).getItemStackFromSlot(EquipmentSlotType.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		hair.rotateAngleY = head.rotateAngleY;

		// arms
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

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// body
		mantle.rotateAngleY = head.rotateAngleY;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
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

	private void animationBuff() {
		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;
		rightarm.rotateAngleZ = +0.785398F;
		leftarm.rotateAngleZ = -0.785398F;
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
