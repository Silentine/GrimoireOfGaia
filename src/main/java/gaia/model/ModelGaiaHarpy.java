package gaia.model;

import gaia.entity.monster.EntityGaiaHarpy;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaHarpy extends ModelGaia {
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
	private ModelRenderer tail;

	private static final float SCALE_AMOUNT_HEAD = 0.75F;
	private static final float SCALE_AMOUNT_BODY = 0.5F;
	private static final float Y_OFFSET_HEAD = 15.0F;
	private static final float Y_OFFSET_BODY = 23.5F;

	// x and y coordinates of hairahoge must be manually adjusted by a 0.5 difference
	public ModelGaiaHarpy() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 2F, -4F);
		setRotation(head, 0.0872665F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, -2F);
		setRotation(headeyes, 0.0872665F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 2F, -4F);
		setRotation(headaccessory, 0.0872665F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 2F, -4F);
		setRotation(neck, 0.0872665F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 2F, -4F);
		setRotation(bodytop, 0.1745329F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5F, -3.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 2F, -4F);
		setRotation(bodymiddle, 0.6108652F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5.5F, -3.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 2F, -4F);
		setRotation(bodymiddlebutton, 0.6108652F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 6F, -7F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 2F, -4F);
		setRotation(bodybottom, 1.047198F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 4F, -5F);
		setRotation(rightchest, 0.9599311F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 4F, -5F);
		setRotation(leftchest, 0.9599311F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-2.5F, 3.5F, -3.5F);
		setRotation(rightarm, 0.6108652F, -0.1745329F, 0.3490659F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, 3.5F, -3.5F);
		setRotation(leftarm, 0.6108652F, 0.1745329F, -0.3490659F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-2F, -1F, -1.5F, 3, 6, 3);
		rightleg.setRotationPoint(-2F, 10.5F, 0.8F);
		setRotation(rightleg, -0.5235988F, -0.0872665F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1F, -1F, -1.5F, 3, 6, 3);
		leftleg.setRotationPoint(2F, 10.5F, 0.8F);
		setRotation(leftleg, -0.5235988F, 0.0872665F, 0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-2.5F, -8F, 2F, 5, 5, 5);
		hair.setRotationPoint(0F, 2F, -4F);
		setRotation(hair, 0.0872665F, 0F, 0F);
		ModelRenderer hairahoge = new ModelRenderer(this, 36, 24);
		hairahoge.addBox(-1.3F, -9F, -1.8F, 4, 4, 4);
		hairahoge.setRotationPoint(0F, 1F, -4F);
		setRotation(hairahoge, 0F, -0.7853982F, 0F);
		ModelRenderer rightfeather = new ModelRenderer(this, 36, 32);
		rightfeather.addBox(-4.5F, -5F, 0F, 1, 6, 8);
		rightfeather.setRotationPoint(0F, 2F, -4F);
		setRotation(rightfeather, 0.3490659F, -0.2617994F, 0F);
		ModelRenderer leftfeather = new ModelRenderer(this, 36, 32);
		leftfeather.mirror = true;
		leftfeather.addBox(3.5F, -5F, 0F, 1, 6, 8);
		leftfeather.setRotationPoint(0F, 2F, -4F);
		setRotation(leftfeather, 0.3490659F, 0.2617994F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 16, 20);
		rightarmlower.addBox(-2F, 0F, 4F, 2, 6, 2);
		rightarmlower.setRotationPoint(-2.5F, 3.5F, -3.5F);
		setRotation(rightarmlower, -0.9599311F, -0.1745329F, 0.3490659F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 16, 20);
		leftarmlower.addBox(0F, 0F, 4F, 2, 6, 2);
		leftarmlower.setRotationPoint(2.5F, 3.5F, -3.5F);
		setRotation(leftarmlower, -0.9599311F, 0.1745329F, -0.3490659F);
		ModelRenderer rightwing = new ModelRenderer(this, 64, 16);
		rightwing.addBox(-1.5F, 4.5F, -5F, 1, 8, 12);
		rightwing.setRotationPoint(-2.5F, 3.5F, -3.5F);
		setRotation(rightwing, 0.6108652F, -0.1745329F, 0.3490659F);
		ModelRenderer leftwing = new ModelRenderer(this, 64, 16);
		leftwing.mirror = true;
		leftwing.addBox(0.5F, 5F, -5F, 1, 8, 12);
		leftwing.setRotationPoint(2.5F, 3.5F, -3.5F);
		setRotation(leftwing, 0.6108652F, 0.1745329F, -0.3490659F);
		ModelRenderer rightwinglower = new ModelRenderer(this, 64, 0);
		rightwinglower.addBox(-1F, 7F, -2F, 1, 6, 10);
		rightwinglower.setRotationPoint(-2.5F, 3.5F, -3.5F);
		setRotation(rightwinglower, -0.0872665F, -0.1745329F, 0.3490659F);
		ModelRenderer leftwinglower = new ModelRenderer(this, 64, 0);
		leftwinglower.mirror = true;
		leftwinglower.addBox(0F, 7F, -2F, 1, 6, 10);
		leftwinglower.setRotationPoint(2.5F, 3.5F, -3.5F);
		setRotation(leftwinglower, -0.0872665F, 0.1745329F, -0.3490659F);
		tail = new ModelRenderer(this, 90, 0);
		tail.addBox(-1.5F, 7F, -4F, 3, 10, 1);
		tail.setRotationPoint(0F, 2F, -4F);
		setRotation(tail, 1.047198F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 90, 11);
		rightleglower.addBox(-1.5F, 4F, 2F, 2, 2, 4);
		rightleglower.setRotationPoint(-2F, 10.5F, 0.8F);
		setRotation(rightleglower, -1.047198F, -0.0872665F, 0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 90, 11);
		leftleglower.addBox(-0.5F, 4F, 2F, 2, 2, 4);
		leftleglower.setRotationPoint(2F, 10.5F, 0.8F);
		setRotation(leftleglower, -1.047198F, 0.0872665F, 0F);
		ModelRenderer righttalonupper = new ModelRenderer(this, 90, 17);
		righttalonupper.addBox(-1F, 3F, -5.5F, 1, 6, 1);
		righttalonupper.setRotationPoint(-2F, 10.5F, 0.8F);
		setRotation(righttalonupper, 0.5235988F, -0.0872665F, 0F);
		ModelRenderer lefttalonupper = new ModelRenderer(this, 90, 17);
		lefttalonupper.addBox(0F, 3F, -5.5F, 1, 6, 1);
		lefttalonupper.setRotationPoint(2F, 10.5F, 0.8F);
		setRotation(lefttalonupper, 0.5235988F, 0.0872665F, 0F);
		ModelRenderer righttalon = new ModelRenderer(this, 90, 24);
		righttalon.addBox(-1.5F, 5F, -12F, 2, 1, 4);
		righttalon.setRotationPoint(-2F, 10.5F, 0.8F);
		setRotation(righttalon, 1.047198F, -0.0872665F, 0F);
		ModelRenderer lefttalon = new ModelRenderer(this, 90, 24);
		lefttalon.addBox(-0.5F, 5F, -12F, 2, 1, 4);
		lefttalon.setRotationPoint(2F, 10.5F, 0.8F);
		setRotation(lefttalon, 1.047198F, 0.0872665F, 0F);
		ModelRenderer righttalonlower = new ModelRenderer(this, 90, 29);
		righttalonlower.addBox(-2F, 13F, -4F, 3, 1, 5);
		righttalonlower.setRotationPoint(-2F, 10.5F, 0.8F);
		setRotation(righttalonlower, 0F, -0.0872665F, 0F);
		ModelRenderer lefttalonlower = new ModelRenderer(this, 90, 29);
		lefttalonlower.addBox(-1F, 13F, -4F, 3, 1, 5);
		lefttalonlower.setRotationPoint(2F, 10.5F, 0.8F);
		setRotation(lefttalonlower, 0F, 0.0872665F, 0F);

		convertToChild(head, hair);
		convertToChild(head, hairahoge);
		convertToChild(head, rightfeather);
		convertToChild(head, leftfeather);
		convertToChild(rightarm, rightarmlower);
		convertToChild(rightarm, rightwing);
		convertToChild(rightarm, rightwinglower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, leftwing);
		convertToChild(leftarm, leftwinglower);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, righttalonupper);
		convertToChild(rightleg, righttalon);
		convertToChild(rightleg, righttalonlower);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, lefttalonupper);
		convertToChild(leftleg, lefttalon);
		convertToChild(leftleg, lefttalonlower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		EntityGaiaHarpy entityGaiaHarpy = (EntityGaiaHarpy) entityIn;

		if (!entityGaiaHarpy.isChild()) {
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
			tail.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}
		} else {
			/** SCALING **/
			GlStateManager.pushMatrix();
			GlStateManager.scale(SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD);
			GlStateManager.translate(0.0F, Y_OFFSET_HEAD * scale, 0.0F);
			head.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}

			headaccessory.render(scale);
			GlStateManager.popMatrix();
			/** SCALING **/
			GlStateManager.pushMatrix();
			GlStateManager.scale(SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY);
			GlStateManager.translate(0.0F, Y_OFFSET_BODY * scale, 0.0F);
			neck.render(scale);
			bodytop.render(scale);
			bodymiddle.render(scale);
			bodymiddlebutton.render(scale);
			bodybottom.render(scale);
			rightarm.render(scale);
			leftarm.render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			tail.render(scale);
			GlStateManager.popMatrix();
			/** SCALING **/
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = (headPitch / 57.295776F) + 0.0872665F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		// arms
		rightarm.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F - 0.1745329F;
		leftarm.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F + 0.1745329F;

		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F + 0.6108652F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F + 0.6108652F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.3490659F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.3490659F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		if (itemstack.getItem() == Items.FEATHER) {
			if (entityIn.motionX * entityIn.motionX + entityIn.motionZ * entityIn.motionZ > 2.500000277905201E-7D) {
				animationFlee();
			}
		}

		// body
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(5);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.5235988F;
		leftleg.rotateAngleX -= 0.5235988F;
        rightleg.rotateAngleY = -0.0872665F;
        leftleg.rotateAngleY = 0.0872665F;
        rightleg.rotateAngleZ = 0.0F;
        leftleg.rotateAngleZ = 0.0F;
		
		if (isRiding) {
			rightarm.rotateAngleX += -((float) Math.PI / 5F);
			leftarm.rotateAngleX += -((float) Math.PI / 5F);
			rightleg.rotateAngleX = -1.4137167F;
			rightleg.rotateAngleY = ((float) Math.PI / 10F);
			rightleg.rotateAngleZ = 0.07853982F;
			leftleg.rotateAngleX = -1.4137167F;
			leftleg.rotateAngleY = -((float) Math.PI / 10F);
			leftleg.rotateAngleZ = -0.07853982F;
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

		// right arm
		rightarm.rotateAngleX -= (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX -= (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationFlee() {
		rightarm.rotateAngleX += 1.0472F;
		leftarm.rotateAngleX += 1.0472F;
	}
}
