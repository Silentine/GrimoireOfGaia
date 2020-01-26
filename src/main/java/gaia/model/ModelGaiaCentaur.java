package gaia.model;

import gaia.entity.monster.EntityGaiaCentaur;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaCentaur extends ModelGaia {

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
	private ModelRenderer bodytopmale;
	private ModelRenderer bodymidmale;
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer rightear;
	private ModelRenderer leftear;
	private ModelRenderer rightpauldron;
	private ModelRenderer leftpauldron;
	private ModelRenderer front;
	private ModelRenderer body1;
	private ModelRenderer body2;
	private ModelRenderer rightlegupper;
	private ModelRenderer leftlegupper;
	private ModelRenderer rightlegbracelet;
	private ModelRenderer leftlegbracelet;
	private ModelRenderer rightleglower;
	private ModelRenderer leftleglower;
	private ModelRenderer rightlegback1;
	private ModelRenderer leftlegback1;
	private ModelRenderer rightlegback2;
	private ModelRenderer leftlegback2;
	private ModelRenderer rightlegback3;
	private ModelRenderer leftlegback3;
	private ModelRenderer tail;

	public ModelGaiaCentaur() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -6F, -7.5F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, -6F, -7.5F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -6F, -7.5F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, -6F, -7.5F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -2F, 5, 6, 3);
		bodytop.setRotationPoint(0F, -6F, -7F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -2F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, -6F, -7F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5.5F, -2.1F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, -5.5F, -7F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -3F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, -6F, -7F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -4F, -9F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -4F, -9F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, -5F, -7.5F);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 24, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, -5F, -7.5F);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		bodytopmale = new ModelRenderer(this, 0, 50);
		bodytopmale.addBox(-3F, 0F, -2F, 6, 6, 3);
		bodytopmale.setRotationPoint(0F, -6F, -7F);
		setRotation(bodytopmale, -0.0872665F, 0F, 0F);
		bodymidmale = new ModelRenderer(this, 0, 59);
		bodymidmale.addBox(-2.5F, 5.5F, -2F, 5, 3, 2);
		bodymidmale.setRotationPoint(0F, -6F, -7F);
		setRotation(bodymidmale, 0F, 0F, 0F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, -6F, -7.5F);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, -6F, -7.5F);
		setRotation(hair2, 0F, 0F, 0F);
		rightear = new ModelRenderer(this, 36, 33);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, -6F, -7.5F);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		leftear = new ModelRenderer(this, 36, 33);
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, -6F, -7.5F);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		rightpauldron = new ModelRenderer(this, 36, 41);
		rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, -5F, -7.5F);
		setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		leftpauldron = new ModelRenderer(this, 36, 41);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, -5F, -7.5F);
		setRotation(leftpauldron, 0F, 0F, -0.1745329F);
		front = new ModelRenderer(this, 64, 0);
		front.addBox(-3.5F, 7.5F, -2F, 7, 8, 3);
		front.setRotationPoint(0F, -6F, -7F);
		setRotation(front, -0.0872665F, 0F, 0F);
		body1 = new ModelRenderer(this, 64, 11);
		body1.addBox(-4F, -1F, -2F, 8, 9, 9);
		body1.setRotationPoint(0F, 5F, -7.5F);
		setRotation(body1, 0F, 0F, 0F);
		body2 = new ModelRenderer(this, 64, 29);
		body2.addBox(-3.5F, -0.5F, -2F, 7, 8, 12);
		body2.setRotationPoint(0F, 4.5F, -0.5F);
		setRotation(body2, 0F, 0F, 0F);
		rightlegupper = new ModelRenderer(this, 106, 0);
		rightlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		rightlegupper.setRotationPoint(-4F, 9F, -7F);
		setRotation(rightlegupper, 0F, 0F, 0F);
		leftlegupper = new ModelRenderer(this, 106, 0);
		leftlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		leftlegupper.setRotationPoint(4F, 9F, -7F);
		setRotation(leftlegupper, 0F, 0F, 0F);
		rightlegbracelet = new ModelRenderer(this, 106, 11);
		rightlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		rightlegbracelet.setRotationPoint(-4F, 9F, -7F);
		setRotation(rightlegbracelet, 0F, 0F, 0F);
		leftlegbracelet = new ModelRenderer(this, 106, 11);
		leftlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		leftlegbracelet.setRotationPoint(4F, 9F, -7F);
		setRotation(leftlegbracelet, 0F, 0F, 0F);
		rightleglower = new ModelRenderer(this, 106, 16);
		rightleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		rightleglower.setRotationPoint(-4F, 9F, -7F);
		setRotation(rightleglower, 0F, 0F, 0F);
		leftleglower = new ModelRenderer(this, 106, 16);
		leftleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		leftleglower.setRotationPoint(4F, 9F, -7F);
		setRotation(leftleglower, 0F, 0F, 0F);
		rightlegback1 = new ModelRenderer(this, 106, 26);
		rightlegback1.addBox(-0.5F, -2.5F, -1.5F, 3, 8, 6);
		rightlegback1.setRotationPoint(-4F, 7F, 6F);
		setRotation(rightlegback1, 0F, 0F, 0F);
		leftlegback1 = new ModelRenderer(this, 106, 26);
		leftlegback1.addBox(-2.5F, -2.5F, -1.5F, 3, 8, 6);
		leftlegback1.setRotationPoint(4F, 7F, 6F);
		setRotation(leftlegback1, 0F, 0F, 0F);
		rightlegback2 = new ModelRenderer(this, 106, 40);
		rightlegback2.addBox(-1.5F, 0F, 0F, 3, 6, 3);
		rightlegback2.setRotationPoint(-3.5F, 12.5F, 4.5F);
		setRotation(rightlegback2, 0F, 0F, 0F);
		leftlegback2 = new ModelRenderer(this, 106, 40);
		leftlegback2.addBox(-1.5F, 0F, 0F, 3, 6, 3);
		leftlegback2.setRotationPoint(3.5F, 12.5F, 4.5F);
		setRotation(leftlegback2, 0F, 0F, 0F);
		rightlegback3 = new ModelRenderer(this, 106, 49);
		rightlegback3.addBox(-1F, 0F, -2F, 2, 7, 2);
		rightlegback3.setRotationPoint(-3.5F, 18.5F, 7.5F);
		setRotation(rightlegback3, 0F, 0F, 0F);
		leftlegback3 = new ModelRenderer(this, 106, 49);
		leftlegback3.addBox(-1F, 0F, -2F, 2, 7, 2);
		leftlegback3.setRotationPoint(3.5F, 18.5F, 7.5F);
		setRotation(leftlegback3, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 106, 51);
		tail.addBox(-1F, -1F, -0.5F, 2, 2, 8);
		tail.setRotationPoint(0F, 6F, 10F);
		setRotation(tail, 0F, 0F, 0F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(getRightArm(), rightpauldron);
		convertToChild(getLeftArm(), leftpauldron);
		convertToChild(rightlegupper, rightlegbracelet);
		convertToChild(rightlegupper, rightleglower);
		convertToChild(leftlegupper, leftlegbracelet);
		convertToChild(leftlegupper, leftleglower);
		convertToChild(rightlegback2, rightlegback3);
		convertToChild(rightlegback1, rightlegback2);
		convertToChild(leftlegback2, leftlegback3);
		convertToChild(leftlegback1, leftlegback2);
		convertToChild(body2, tail);
		convertToChild(body2, rightlegback1);
		convertToChild(body2, leftlegback1);
		convertToChild(body1, body2);
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
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		bodytopmale.render(scale);
		bodymidmale.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		front.render(scale);
		body1.render(scale);
		rightlegupper.render(scale);
		leftlegupper.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && ageInTicks <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack itemstackChest = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack equipstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		EntityGaiaCentaur entity = (EntityGaiaCentaur) entityIn;

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

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (entity.isSwingingArms() && (equipstack.getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		if (itemstack.getItem() == Items.FEATHER) {
			if (entityIn.motionX * entityIn.motionX + entityIn.motionZ * entityIn.motionZ > 2.500000277905201E-7D) {
				animationFlee();
			}
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		body1.rotateAngleX = -degToRad(5);
		body2.rotateAngleX = degToRad(10);
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(10);
		tail.rotateAngleX = -degToRad(45);

		// legs
		rightlegupper.rotateAngleZ = -degToRad(5);
		rightlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.7862F) * 0.8F * limbSwingAmount;
		leftlegupper.rotateAngleZ = degToRad(5);
		leftlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		rightlegback1.rotateAngleZ = -degToRad(5);
		rightlegback1.rotateAngleX = MathHelper.cos(limbSwing * 0.7662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightlegback1.rotateAngleX -= 0.296706F;
		leftlegback1.rotateAngleZ = degToRad(5);
		leftlegback1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftlegback1.rotateAngleX -= 0.296706F;
		rightlegback2.rotateAngleX = degToRad(30);
		leftlegback2.rotateAngleX = rightlegback2.rotateAngleX;
		rightlegback3.rotateAngleX = -degToRad(18);
		leftlegback3.rotateAngleX = rightlegback3.rotateAngleX;
		
		if (isRiding) {
			body1.rotateAngleX = -degToRad(20);
			body2.rotateAngleX = -degToRad(45);
			tail.rotateAngleX = degToRad(65);
			rightlegback1.rotateAngleZ = degToRad(25);
			leftlegback1.rotateAngleZ = -rightlegback1.rotateAngleZ;
			rightlegupper.rotateAngleX = -degToRad(25);
			leftlegupper.rotateAngleX = rightlegupper.rotateAngleX;
			rightlegback1.rotateAngleX = -degToRad(20);
			leftlegback1.rotateAngleX = rightlegback1.rotateAngleX;
		}
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2.2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2.2F);
		rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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

	private void animationFlee() {
		leftarm.rotateAngleX += 1.0472F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
