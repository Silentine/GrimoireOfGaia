package gaia.model;

import gaia.entity.monster.EntityGaiaWitch;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaWitch extends ModelGaia {

	private ModelRenderer anchor;
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer hat1;
	private ModelRenderer hat2;
	private ModelRenderer hat3;
	private ModelRenderer hat4;
	private ModelRenderer hat5;
	private ModelRenderer hat6;
	private ModelRenderer amulet;
	private ModelRenderer rightmantle;
	private ModelRenderer leftmantle;
	private ModelRenderer mantle;
	private ModelRenderer rightleglower;
	private ModelRenderer leftleglower;
	private ModelRenderer skirt1;
	private ModelRenderer skirt2;
	private ModelRenderer rightfoot;
	private ModelRenderer leftfoot;
	private ModelRenderer broombody;
	private ModelRenderer broombrush;

	public ModelGaiaWitch() {
		textureWidth = 128;
		textureHeight = 64;

		float rotationPointZ = -2F;
		float heldItemOffset = -0.5F;

		anchor = new ModelRenderer(this, 0, 40);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(heldItemOffset, -2F, 4F);
		setRotation(anchor, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 0F, -0.5F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, 0F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, -0.5F, -2.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 7F, 1.5F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 0F, -2.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 7F, 1.5F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 0F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 9F, 1F);
		setRotation(bodybottom, 0F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3.5F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3.5F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, -0.5F);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, -0.5F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 7, 3);
		rightleg.setRotationPoint(-2F, 11F, 0.5F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 22);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 7, 3);
		leftleg.setRotationPoint(2F, 11F, 0.5F);
		setRotation(leftleg, 0F, 0F, 0F);
		hat1 = new ModelRenderer(this, 36, 14);
		hat1.addBox(-7F, -1F, -7F, 14, 2, 14);
		hat1.setRotationPoint(0F, -3F, 0F);
		setRotation(hat1, 0F, 0F, 0F);
		hat2 = new ModelRenderer(this, 36, 30);
		hat2.addBox(-4F, -5F, 0F, 8, 5, 8);
		hat2.setRotationPoint(0F, -4F, -4F);
		setRotation(hat2, 0F, 0F, 0F);
		hat3 = new ModelRenderer(this, 68, 30);
		hat3.addBox(0F, -6F, 0F, 6, 6, 6);
		hat3.setRotationPoint(-3F, -9F, -3F);
		setRotation(hat3, 0F, 0F, 0F);
		hat4 = new ModelRenderer(this, 36, 43);
		hat4.addBox(0F, -4F, 0F, 4, 4, 4);
		hat4.setRotationPoint(-2F, -15F, -2F);
		setRotation(hat4, 0F, 0F, 0F);
		hat5 = new ModelRenderer(this, 52, 43);
		hat5.addBox(0F, -3F, 0F, 3, 3, 3);
		hat5.setRotationPoint(-1.5F, -19F, -1.5F);
		setRotation(hat5, 0F, 0F, 0F);
		hat6 = new ModelRenderer(this, 36, 51);
		hat6.addBox(0F, -2F, 0F, 2, 2, 2);
		hat6.setRotationPoint(-1F, -22F, -1F);
		setRotation(hat6, 0F, 0F, 0F);
		amulet = new ModelRenderer(this, 36, 55);
		amulet.addBox(-1F, -1F, -3.5F, 2, 2, 2);
		amulet.setRotationPoint(0F, 1F, 0F);
		setRotation(amulet, 0.4363323F, 0F, 0F);
		rightmantle = new ModelRenderer(this, 92, 0);
		rightmantle.addBox(-3F, -2F, -2F, 4, 4, 4);
		rightmantle.setRotationPoint(-2.5F, 2.5F, -0.5F);
		setRotation(rightmantle, 0F, 0F, 0F);
		leftmantle = new ModelRenderer(this, 92, 0);
		leftmantle.mirror = true;
		leftmantle.addBox(-1F, -2F, -2F, 4, 4, 4);
		leftmantle.setRotationPoint(2.5F, 2.5F, -0.5F);
		setRotation(leftmantle, 0F, 0F, 0F);
		mantle = new ModelRenderer(this, 92, 8);
		mantle.addBox(-4.5F, 0.5F, 0F, 9, 10, 3);
		mantle.setRotationPoint(0F, 1F, 0F);
		setRotation(mantle, 0.1745329F, 0F, 0F);
		rightleglower = new ModelRenderer(this, 24, 32);
		rightleglower.addBox(-1.49F, 0F, 0F, 3, 7, 3);
		rightleglower.setRotationPoint(-2F, 17F, -1F);
		setRotation(rightleglower, 0F, 0F, 0F);
		leftleglower = new ModelRenderer(this, 24, 32);
		leftleglower.addBox(-1.51F, 0F, 0F, 3, 7, 3);
		leftleglower.setRotationPoint(2F, 17F, -1F);
		setRotation(leftleglower, 0F, 0F, 0F);
		skirt1 = new ModelRenderer(this, 92, 21);
		skirt1.addBox(-3.5F, 0.5F, -3F, 7, 2, 6);
		skirt1.setRotationPoint(0F, 9F, 0.5F);
		setRotation(skirt1, 0F, 0F, 0F);
		skirt2 = new ModelRenderer(this, 92, 29);
		skirt2.addBox(-4F, -1F, -3.5F, 8, 4, 7);
		skirt2.setRotationPoint(0F, 12F, 0.5F);
		setRotation(skirt2, 0F, 0F, 0F);
		rightfoot = new ModelRenderer(this, 92, 40);
		rightfoot.addBox(-2F, 3F, -0.5F, 4, 4, 4);
		rightfoot.setRotationPoint(-2F, 17F, -1F);
		setRotation(rightfoot, 0F, 0F, 0F);
		leftfoot = new ModelRenderer(this, 92, 40);
		leftfoot.addBox(-2F, 3F, -0.5F, 4, 4, 4);
		leftfoot.setRotationPoint(2F, 17F, -1F);
		setRotation(leftfoot, 0F, 0F, 0F);
		broombody = new ModelRenderer(this, 112, 43);
		broombody.addBox(-0.5F, -11F, -0.5F, 1, 20, 1);
		broombody.setRotationPoint(0F, 14F, 0F);
		setRotation(broombody, 1.570796F, 0F, 0F);
		broombrush = new ModelRenderer(this, 116, 43);
		broombrush.addBox(-1.5F, 8F, -1.5F, 3, 10, 3);
		broombrush.setRotationPoint(0F, 14F, 0F);
		setRotation(broombrush, 1.570796F, 0F, 0F);

		// joints
		// head
		convertToChild(head, headeyes);
		convertToChild(head, headaccessory);
		convertToChild(hat5, hat6);
		convertToChild(hat4, hat5);
		convertToChild(hat3, hat4);
		convertToChild(hat2, hat3);
		convertToChild(hat1, hat2);
		convertToChild(head, hat1);
		// upperBody
		convertToChild(bodytop, rightchest);
		convertToChild(bodytop, leftchest);
		convertToChild(bodytop, rightarm);
		convertToChild(bodytop, leftarm);
		convertToChild(rightarm, rightmantle);
		convertToChild(leftarm, leftmantle);
		convertToChild(bodytop, amulet);
		convertToChild(bodytop, mantle);
		// lowerBody
		convertToChild(bodymiddle, bodymiddlebutton);
		convertToChild(rightleglower, rightfoot);
		convertToChild(leftleglower, leftfoot);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
		convertToChild(skirt1, skirt2);
		convertToChild(bodybottom, skirt1);
		convertToChild(bodybottom, rightleg);
		convertToChild(bodybottom, leftleg);
		// broom
		convertToChild(broombody, broombrush);
		// finalConnection
		convertToChild(bodymiddle, bodybottom);
		convertToChild(bodytop, bodymiddle);
		convertToChild(neck, bodytop);
		convertToChild(neck, head);
		// anchor
		convertToChild(anchor, neck);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
		broombody.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		EntityGaiaWitch entityGaiaWitch = (EntityGaiaWitch) entityIn;
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

		boolean moveExtremities;
		float rightArmAngleMoving;
		float leftArmAngleMoving;
		float defaultAngle = 0;

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.showModel = entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F;

		hat1.rotateAngleZ = -degToRad(30);
		hat3.rotateAngleX = -degToRad(20);
		hat3.rotateAngleZ = degToRad(20);
		hat4.rotateAngleX = -degToRad(20);
		hat4.rotateAngleZ = degToRad(20);
		hat5.rotateAngleX = -degToRad(20);
		hat5.rotateAngleZ = degToRad(20);
		hat6.rotateAngleX = degToRad(10);
		hat6.rotateAngleZ = -degToRad(10);

		if (entityGaiaWitch.isRidingBroom()) {
			moveExtremities = false;
			rightArmAngleMoving = degToRad(30);
			leftArmAngleMoving = degToRad(45);

			// arms
			rightarm.rotateAngleX = -rightArmAngleMoving;
			rightarm.rotateAngleY = -rightArmAngleMoving;
			rightarm.rotateAngleZ = 0;
			leftarm.rotateAngleX = -leftArmAngleMoving;
			leftarm.rotateAngleY = leftArmAngleMoving;
			leftarm.rotateAngleZ = 0;
			rightmantle.rotateAngleZ = rightArmAngleMoving;
			leftmantle.rotateAngleZ = -rightArmAngleMoving;
			// body
			bodytop.rotateAngleX = degToRad(25);
			bodymiddle.rotateAngleX = degToRad(10);
			bodybottom.rotateAngleX = degToRad(15);
			// legs
			rightleg.rotateAngleX = -degToRad(80);
			rightleg.rotateAngleY = -degToRad(5);
			leftleg.rotateAngleX = -degToRad(60);
			leftleg.rotateAngleY = degToRad(5);
			rightleglower.rotateAngleX = degToRad(45);
			leftleglower.rotateAngleX = degToRad(75);
			// broom
			broombody.showModel = true;
		} else {
			moveExtremities = true;
			rightArmAngleMoving = defaultAngle;
			leftArmAngleMoving = defaultAngle;

			// arms
			rightarm.rotateAngleX = defaultAngle;
			rightarm.rotateAngleY = defaultAngle;
			leftarm.rotateAngleX = defaultAngle;
			leftarm.rotateAngleY = defaultAngle;
			rightmantle.rotateAngleZ = degToRad(10);
			leftmantle.rotateAngleZ = -degToRad(10);
			// body
			bodytop.rotateAngleX = defaultAngle;
			bodymiddle.rotateAngleX = defaultAngle;
			bodybottom.rotateAngleX = defaultAngle;
			// legs
			rightleg.rotateAngleX = defaultAngle;
			rightleg.rotateAngleY = defaultAngle;
			leftleg.rotateAngleX = defaultAngle;
			leftleg.rotateAngleY = defaultAngle;
			rightleglower.rotateAngleX = defaultAngle;
			leftleglower.rotateAngleX = defaultAngle;
			// broom
			broombody.showModel = false;
		}

		// arms
		if (moveExtremities) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		}

		if (!moveExtremities) {
			rightarm.rotateAngleX = -rightArmAngleMoving;
			leftarm.rotateAngleX = -leftArmAngleMoving;
		}

		// legs
		if (moveExtremities) {
			rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
			leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
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

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
