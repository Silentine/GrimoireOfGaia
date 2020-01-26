package gaia.model;

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
public class ModelGaiaIllagerFire extends ModelGaia {
	// fields
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer headlayer;
	ModelRenderer headnose;
	ModelRenderer headcigar;
	ModelRenderer bodylayer;
	ModelRenderer bodygauge;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer flamethrower1;
	ModelRenderer flamethrower2;
	ModelRenderer flamethrower3;
	ModelRenderer flamethrower4;
	ModelRenderer tank1;
	ModelRenderer tank2;
	ModelRenderer tank3;
	ModelRenderer tank4;
	ModelRenderer tankrope1;
	ModelRenderer tankrope2;
	ModelRenderer blazeHead;
	private final ModelRenderer[] blazeSticks = new ModelRenderer[12];

	public ModelGaiaIllagerFire() {
		textureWidth = 256;
		textureHeight = 128;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -10F, -4F, 8, 10, 8);
		head.setRotationPoint(0F, -3F, 0F);
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 28, 18);
		body.addBox(-7F, 0F, -3.5F, 14, 17, 7);
		body.setRotationPoint(0F, -3F, 0F);
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 70, 27);
		rightarm.addBox(-5F, -2F, -3.5F, 5, 8, 7);
		rightarm.setRotationPoint(-7F, -1F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 70, 27);
		leftarm.mirror = true;
		leftarm.addBox(0F, -2F, -3.5F, 5, 8, 7);
		leftarm.setRotationPoint(7F, -1F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 25);
		rightleg.addBox(-3.5F, 0F, -3.5F, 7, 10, 7);
		rightleg.setRotationPoint(-3.5F, 14F, 0F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 25);
		leftleg.mirror = true;
		leftleg.addBox(-3.5F, 0F, -3.5F, 7, 10, 7);
		leftleg.setRotationPoint(3.5F, 14F, 0F);
		setRotation(leftleg, 0F, 0F, 0F);
		headlayer = new ModelRenderer(this, 32, 0);
		headlayer.addBox(-4F, -10F, -4F, 8, 10, 8, 0.5F);
		headlayer.setRotationPoint(0F, -3F, 0F);
		setRotation(headlayer, 0F, 0F, 0F);
		headnose = new ModelRenderer(this, 24, 0);
		headnose.addBox(-1F, -1F, -2F, 2, 4, 2);
		headnose.setRotationPoint(0F, -5F, -4F);
		setRotation(headnose, 0F, 0F, 0F);
		headcigar = new ModelRenderer(this, 56, 0);
		headcigar.addBox(-0.5F, -0.5F, -4F, 1, 1, 4);
		headcigar.setRotationPoint(1F, -4F, -4F);
		setRotation(headcigar, 0F, -0.7853982F, 0F);
		bodylayer = new ModelRenderer(this, 0, 42);
		bodylayer.addBox(-7.5F, -0.5F, -4F, 15, 20, 8);
		bodylayer.setRotationPoint(0F, -3F, 0F);
		setRotation(bodylayer, 0F, 0F, 0F);
		bodygauge = new ModelRenderer(this, 46, 42);
		bodygauge.addBox(-2.5F, -2.5F, -1F, 5, 5, 1);
		bodygauge.setRotationPoint(-4.5F, 2.5F, -3.5F);
		setRotation(bodygauge, 0F, 0F, 0F);
		rightarmlower = new ModelRenderer(this, 70, 54);
		rightarmlower.addBox(-2.49F, 0F, -7F, 5, 9, 7);
		rightarmlower.setRotationPoint(-9.5F, 5F, 3.5F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new ModelRenderer(this, 70, 54);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-2.51F, 0F, -7F, 5, 9, 7);
		leftarmlower.setRotationPoint(9.5F, 5F, 3.5F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		flamethrower1 = new ModelRenderer(this, 114, 32);
		flamethrower1.addBox(-2.49F, 2F, 0F, 5, 10, 5);
		flamethrower1.setRotationPoint(-9.5F, 5F, 3.5F);
		setRotation(flamethrower1, 0F, 0F, 0F);
		flamethrower2 = new ModelRenderer(this, 114, 47);
		flamethrower2.addBox(-1.5F, 5F, 1F, 3, 10, 3);
		flamethrower2.setRotationPoint(-9.5F, 5F, 3.5F);
		setRotation(flamethrower2, 0F, 0F, 0F);
		flamethrower3 = new ModelRenderer(this, 114, 60);
		flamethrower3.addBox(-1F, 8F, -4F, 2, 2, 4);
		flamethrower3.setRotationPoint(-9.5F, 5F, 3.5F);
		setRotation(flamethrower3, 0F, 0F, 0F);
		flamethrower4 = new ModelRenderer(this, 114, 66);
		flamethrower4.addBox(-3.49F, 3F, 1F, 1, 3, 3);
		flamethrower4.setRotationPoint(-9.5F, 5F, 3.5F);
		setRotation(flamethrower4, 0F, 0F, 0F);
		tankrope1 = new ModelRenderer(this, 114, 72);
		tankrope1.addBox(-8F, -1F, -1F, 8, 2, 2);
		tankrope1.setRotationPoint(-11F, 8F, 12.5F);
		setRotation(tankrope1, 0F, 0F, 0F);
		tankrope2 = new ModelRenderer(this, 114, 72);
		tankrope2.addBox(-8F, -1F, -2F, 8, 2, 2);
		tankrope2.setRotationPoint(-19F, 8F, 13.5F);
		setRotation(tankrope2, 0F, 0F, 0F);
		tank1 = new ModelRenderer(this, 94, 0);
		tank1.addBox(-8F, -8F, 0F, 16, 16, 16);
		tank1.setRotationPoint(0F, 8F, 4.5F);
		setRotation(tank1, 0F, 0F, 0F);
		tank2 = new ModelRenderer(this, 94, 32);
		tank2.addBox(-2F, -4F, -4F, 2, 8, 8);
		tank2.setRotationPoint(-8F, 8F, 12.5F);
		setRotation(tank2, 0F, 0F, 0F);
		tank3 = new ModelRenderer(this, 94, 48);
		tank3.addBox(0F, -4F, -4F, 2, 8, 8);
		tank3.setRotationPoint(8F, 8F, 12.5F);
		setRotation(tank3, 0F, 0F, 0F);
		tank4 = new ModelRenderer(this, 94, 64);
		tank4.addBox(-1F, -4F, -3F, 2, 4, 6);
		tank4.setRotationPoint(9F, 5F, 12.5F);
		setRotation(tank4, 0F, 0F, 0.7853982F);

		blazeHead = new ModelRenderer(this, 158, 0);
		blazeHead.addBox(-4F, -8F, -4F, 8, 8, 8);
		blazeHead.setRotationPoint(0F, 12F, 12.5F);
		setRotation(blazeHead, 0F, 0F, 0F);
		for (int i = 0; i < this.blazeSticks.length; ++i) {
			this.blazeSticks[i] = new ModelRenderer(this, 158, 16);
			this.blazeSticks[i].addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
		}

		convertToChild(head, headlayer);
		convertToChild(head, headnose);
		convertToChild(head, headcigar);
		convertToChild(body, bodylayer);
		convertToChild(body, bodygauge);
		convertToChild(tank3, tank4);
		convertToChild(tankrope1, tankrope2);
		convertToChild(rightarmlower, flamethrower1);
		convertToChild(rightarmlower, flamethrower2);
		convertToChild(rightarmlower, flamethrower3);
		convertToChild(rightarmlower, flamethrower4);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(body, rightarm);
		convertToChild(body, leftarm);
		convertToChild(body, rightleg);
		convertToChild(body, leftleg);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		body.render(scale);
		tank1.render(scale);
		tank2.render(scale);
		tank3.render(scale);
		tankrope1.render(scale);
		blazeHead.render(scale);

		for (ModelRenderer modelrenderer : this.blazeSticks) {
			modelrenderer.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = 0.0F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F);
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
			rightarm.rotateAngleX = rightarm.rotateAngleX - degToRad(15);
			rightarmlower.rotateAngleX = -degToRad(30);
			rightarm.rotateAngleY = 0.0F;
			
			tankrope1.rotateAngleY = -degToRad(45);
			tankrope1.rotateAngleZ = -degToRad(90);
			tankrope2.rotateAngleY = -degToRad(90);
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleY = 0.0F;
		leftleg.rotateAngleY = 0.0F;
		rightleg.rotateAngleZ = 0.0F;
		leftleg.rotateAngleZ = 0.0F;

		// blaze
		float f = ageInTicks * (float) Math.PI * -0.1F;

		for (int i = 0; i < 4; ++i) {
			blazeSticks[i].rotationPointY = 6.0F + MathHelper.cos(((float) (i * 2) + ageInTicks) * 0.25F);
			blazeSticks[i].rotationPointX = -1.0F + MathHelper.cos(f) * 5.0F;
			blazeSticks[i].rotationPointZ = 11.5F + MathHelper.sin(f) * 5.0F;
			++f;
		}

		blazeHead.rotateAngleY = netHeadYaw * 0.017453292F;
		blazeHead.rotateAngleX = headPitch * 0.017453292F;

		if (isRiding) {
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

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (body.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationThrow() {
		rightarm.rotateAngleY = -degToRad(30);
		rightarmlower.rotateAngleX = -degToRad(60);
		
		tankrope1.rotateAngleY = -degToRad(60);
		tankrope1.rotateAngleZ = -degToRad(90);
		tankrope2.rotateAngleY = -degToRad(60);
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
