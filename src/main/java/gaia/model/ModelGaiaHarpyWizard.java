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
public class ModelGaiaHarpyWizard extends ModelGaia {

	ModelRenderer head;
	ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodybottom;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer headglasses;
	ModelRenderer headrightear;
	ModelRenderer headleftear;
	ModelRenderer cloak1;
	ModelRenderer cloak2;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer tail;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;

	public ModelGaiaHarpyWizard() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 12F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 12F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 12F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 12F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 12F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 25);
		bodybottom.addBox(-3F, 6F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 12F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightarm = new ModelRenderer(this, 68, 0);
		rightarm.addBox(-1F, 0F, -3F, 1, 4, 6);
		rightarm.setRotationPoint(-2.5F, 12.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 68, 0);
		leftarm.mirror = true;
		leftarm.addBox(0F, 0F, -3F, 1, 4, 6);
		leftarm.setRotationPoint(2.5F, 12.5F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 4, 3);
		rightleg.setRotationPoint(-2F, 20F, 0F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 4, 3);
		leftleg.setRotationPoint(2F, 20F, 0F);
		setRotation(leftleg, 0F, 0F, 0F);
		headglasses = new ModelRenderer(this, 24, 6);
		headglasses.addBox(-3F, -6F, -3.6F, 6, 6, 0);
		headglasses.setRotationPoint(0F, 12F, 0F);
		setRotation(headglasses, 0F, 0F, 0F);
		headrightear = new ModelRenderer(this, 36, 14);
		headrightear.addBox(-3F, 0F, -3F, 3, 3, 3);
		headrightear.setRotationPoint(-3F, 7F, 2F);
		setRotation(headrightear, -0.7853982F, 0F, 0.5235988F);
		headleftear = new ModelRenderer(this, 36, 14);
		headleftear.mirror = true;
		headleftear.addBox(0F, 0F, -3F, 3, 3, 3);
		headleftear.setRotationPoint(3F, 7F, 2F);
		setRotation(headleftear, -0.7853982F, 0F, -0.5235988F);
		cloak1 = new ModelRenderer(this, 36, 20);
		cloak1.addBox(-4F, -0.5F, -4F, 8, 2, 8);
		cloak1.setRotationPoint(0F, 12F, 0F);
		setRotation(cloak1, 0F, 0F, 0F);
		cloak2 = new ModelRenderer(this, 36, 30);
		cloak2.addBox(-3F, 0.5F, -3F, 6, 2, 6);
		cloak2.setRotationPoint(0F, 12F, 0F);
		setRotation(cloak2, 0F, 0F, 0F);
		rightarmlower = new ModelRenderer(this, 68, 10);
		rightarmlower.addBox(-1F, 0F, -2.5F, 1, 4, 5);
		rightarmlower.setRotationPoint(-2.5F, 16.5F, 0F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new ModelRenderer(this, 68, 10);
		leftarmlower.mirror = true;
		leftarmlower.addBox(0F, 0F, -2.5F, 1, 4, 5);
		leftarmlower.setRotationPoint(2.5F, 16.5F, 0F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 68, 19);
		tail.addBox(-1.5F, 0F, -1F, 3, 3, 1);
		tail.setRotationPoint(0F, 18F, 1F);
		setRotation(tail, 0.7853982F, 0F, 0F);
		rightleglower = new ModelRenderer(this, 82, 0);
		rightleglower.addBox(-1F, 2F, -1F, 2, 2, 2);
		rightleglower.setRotationPoint(-2F, 20F, 0F);
		setRotation(rightleglower, 0F, 0F, 0F);
		leftleglower = new ModelRenderer(this, 82, 0);
		leftleglower.mirror = true;
		leftleglower.addBox(-1F, 2F, -1F, 2, 2, 2);
		leftleglower.setRotationPoint(2F, 20F, 0F);
		setRotation(leftleglower, 0F, 0F, 0F);

		convertToChild(head, headglasses);
		convertToChild(head, headrightear);
		convertToChild(head, headleftear);

		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);

		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodybottom.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		cloak1.render(scale);
		cloak2.render(scale);
		tail.render(scale);

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

		// arms
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.523599F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.523599F;

			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		}
		
		if (itemstack.getItem() == Items.FEATHER) {
			rightarm.rotateAngleX = 0.0F;
			leftarm.rotateAngleX = 0.0F;
			
			rightarm.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
			rightarm.rotateAngleZ = rightarm.rotateAngleZ + 0.785398F;
			leftarm.rotateAngleZ = leftarm.rotateAngleZ - 0.785398F;
		}

		if (itemstack.getItem() == Items.STICK) {
			animationCast();
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount;
        rightleg.rotateAngleY = 0.0F;
        leftleg.rotateAngleY = 0.0F;
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

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationCast() {
		rightarm.rotateAngleX = -2.35619F;
		rightarm.rotateAngleZ = -0.261799F;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}