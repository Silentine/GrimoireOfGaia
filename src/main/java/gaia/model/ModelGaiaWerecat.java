package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaWerecat extends ModelGaia {
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
	private ModelRenderer rightear;
	private ModelRenderer leftear;
	private ModelRenderer leash;
	private ModelRenderer waist;
	private ModelRenderer tail1;
	private ModelRenderer tail2;

	public ModelGaiaWerecat() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, -2.5F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, -2.5F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, -2.5F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, -2.5F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, -3F);
		setRotation(bodytop, 0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, -3F);
		setRotation(bodymiddle, 0.2617994F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5.8F, -2.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, -2F);
		setRotation(bodymiddlebutton, 0.2617994F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, -3F);
		setRotation(bodybottom, 0.3490659F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -4F);
		setRotation(rightchest, 0.9599311F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -4F);
		setRotation(leftchest, 0.9599311F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, -2.5F);
		setRotation(rightarm, -0.1745329F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 36);
		leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, -2.5F);
		setRotation(leftarm, -0.1745329F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 88, 0);
		rightleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
		rightleg.setRotationPoint(-2.5F, 12F, 0F);
		setRotation(rightleg, -0.4363323F, -0.0872665F, -0.0349066F);
		leftleg = new ModelRenderer(this, 88, 0);
		leftleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
		leftleg.setRotationPoint(2.5F, 12F, 0F);
		setRotation(leftleg, -0.4363323F, 0.0872665F, 0.0349066F);
		rightear = new ModelRenderer(this, 36, 28);
		rightear.addBox(0F, 0F, -4F, 3, 3, 4);
		rightear.setRotationPoint(-2F, -5F, 0.5F);
		setRotation(rightear, -0.7853982F, 0.7853982F, 0F);
		leftear = new ModelRenderer(this, 36, 28);
		leftear.mirror = true;
		leftear.addBox(-3F, 0F, -4F, 3, 3, 4);
		leftear.setRotationPoint(2F, -5F, 0.5F);
		setRotation(leftear, -0.7853982F, -0.7853982F, 0F);
		ModelRenderer hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 4, 3);
		hair1.setRotationPoint(0F, 1F, -2.5F);
		setRotation(hair1, 0F, 0F, 0F);
		ModelRenderer hair2 = new ModelRenderer(this, 36, 21);
		hair2.addBox(-4.5F, -3F, 1.5F, 9, 4, 3);
		hair2.setRotationPoint(0F, 1F, -2.5F);
		setRotation(hair2, 0F, 0F, 0F);
		leash = new ModelRenderer(this, 36, 35);
		leash.addBox(-2F, -0.5F, -2F, 4, 1, 4);
		leash.setRotationPoint(0F, 1F, -2.5F);
		setRotation(leash, 0.2617994F, 0F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 64, 0);
		rightarmlower.addBox(-4.5F, 2F, -1.5F, 2, 8, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, -2.5F);
		setRotation(rightarmlower, -0.1745329F, 0F, -0.0872665F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 74, 0);
		leftarmlower.addBox(2.5F, 2F, -1.5F, 2, 8, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, -2.5F);
		setRotation(leftarmlower, -0.1745329F, 0F, 0.0872665F);
		ModelRenderer righthand = new ModelRenderer(this, 64, 11);
		righthand.addBox(-1.5F, 8F, -2F, 2, 4, 4);
		righthand.setRotationPoint(-2.5F, 2.5F, -2.5F);
		setRotation(righthand, -0.1745329F, 0F, 0.1745329F);
		ModelRenderer lefthand = new ModelRenderer(this, 76, 11);
		lefthand.addBox(-0.5F, 8F, -2F, 2, 4, 4);
		lefthand.setRotationPoint(2.5F, 2.5F, -2.5F);
		setRotation(lefthand, -0.1745329F, 0F, -0.1745329F);
		waist = new ModelRenderer(this, 64, 19);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, -3F);
		setRotation(waist, 0.3490659F, 0F, 0F);
		tail1 = new ModelRenderer(this, 64, 27);
		tail1.addBox(-1F, 7F, -3.5F, 2, 5, 2);
		tail1.setRotationPoint(0F, 1F, -2F);
		setRotation(tail1, 0.6108652F, 0F, 0F);
		tail2 = new ModelRenderer(this, 64, 34);
		tail2.addBox(-1.5F, 11F, -5F, 3, 8, 3);
		tail2.setRotationPoint(0F, 1F, -2F);
		setRotation(tail2, 0.6981317F, 0F, 0F);
		ModelRenderer chain = new ModelRenderer(this, 36, 35);
		chain.addBox(-1.5F, 2.5F, -2.5F, 4, 1, 4);
		chain.setRotationPoint(2F, 12F, 0F);
		setRotation(chain, -0.4363323F, 0.0872665F, 0.0349066F);
		ModelRenderer rightfoot = new ModelRenderer(this, 88, 11);
		rightfoot.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
		rightfoot.setRotationPoint(-2.5F, 12F, 0F);
		setRotation(rightfoot, -0.4363323F, -0.0872665F, -0.0349066F);
		ModelRenderer leftfoot = new ModelRenderer(this, 88, 11);
		leftfoot.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
		leftfoot.setRotationPoint(2.5F, 12F, 0F);
		setRotation(leftfoot, -0.4363323F, 0.0872665F, 0.0349066F);
		ModelRenderer rightfootlower = new ModelRenderer(this, 88, 21);
		rightfootlower.addBox(-1.5F, 10F, -7F, 3, 1, 3);
		rightfootlower.setRotationPoint(-2.5F, 12F, 0F);
		setRotation(rightfootlower, 0.1745329F, -0.0872665F, -0.0349066F);
		ModelRenderer leftfootlower = new ModelRenderer(this, 88, 21);
		leftfootlower.addBox(-1.5F, 10F, -7F, 3, 1, 3);
		leftfootlower.setRotationPoint(2.5F, 12F, 0F);
		setRotation(leftfootlower, 0.1745329F, 0.0872665F, 0.0349066F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(head, hair1);
		convertToChild(head, hair2);
		convertToChild(rightarm, rightarmlower);
		convertToChild(rightarm, righthand);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, lefthand);
		convertToChild(rightleg, rightfoot);
		convertToChild(rightleg, rightfootlower);
		convertToChild(leftleg, chain);
		convertToChild(leftleg, leftfoot);
		convertToChild(leftleg, leftfootlower);
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
		rightleg.render(scale);
		leftleg.render(scale);
		leash.render(scale);
		waist.render(scale);
		tail1.render(scale);
		tail2.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		
		float earDefaultAngleX = -0.7853982F;

		rightear.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		rightear.rotateAngleX += earDefaultAngleX;
		leftear.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		leftear.rotateAngleX += earDefaultAngleX;

		// arms
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

		if (itemstack.getItem() == Items.FEATHER) {
			if (entityIn.motionX * entityIn.motionX + entityIn.motionZ * entityIn.motionZ > 2.500000277905201E-7D) {
				animationFlee();
			}
		}

		// body
		tail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(15);
		tail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(20);

		// legs (walk_normal)
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
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

		// right arm
		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX = (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationFlee() {
		rightarm.rotateAngleX += 1.0472F;
		leftarm.rotateAngleX += 1.0472F;
	}
}
