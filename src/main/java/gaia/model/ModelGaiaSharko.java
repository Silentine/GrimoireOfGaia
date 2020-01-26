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
public class ModelGaiaSharko extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer finback;
	private ModelRenderer bodyback;
	private ModelRenderer bodyfront;
	private ModelRenderer bodymid;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer waist;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer tailend;
	private ModelRenderer rightleg;
	private ModelRenderer rightleglower;
	private ModelRenderer rightfoot;
	private ModelRenderer leftleg;
	private ModelRenderer leftleglower;
	private ModelRenderer leftfoot;

	public ModelGaiaSharko() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8);
		head.setRotationPoint(0.0F, 4.0F, -4.0F);
		setRotation(head, 0.1745329F, 0.0F, 0.0F);
		ModelRenderer headsnout = new ModelRenderer(this, 0, 33);
		headsnout.addBox(-3.5F, -7.5F, -5.0F, 7, 4, 6);
		headsnout.setRotationPoint(0.0F, 4.0F, -4.0F);
		setRotation(headsnout, 0.6981317F, 0.0F, 0.0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 43);
		headjaw.addBox(-3.0F, -3.0F, -5.0F, 6, 4, 5);
		headjaw.setRotationPoint(0.0F, 4.0F, -4.0F);
		setRotation(headjaw, 0.1745329F, 0.0F, 0.0F);
		finback = new ModelRenderer(this, 0, 15);
		finback.addBox(0.0F, -14.0F, -4.0F, 0, 8, 10);
		finback.setRotationPoint(0.0F, 4.0F, -4.0F);
		setRotation(finback, -0.0872665F, 0.0F, 0.0F);
		bodyback = new ModelRenderer(this, 32, 12);
		bodyback.addBox(-7.0F, -1.0F, 1.0F, 14, 8, 4);
		bodyback.setRotationPoint(0.0F, -1.0F, -3.0F);
		setRotation(bodyback, 0.3490659F, 0.0F, 0.0F);
		bodyfront = new ModelRenderer(this, 32, 0);
		bodyfront.addBox(-6.0F, 0.0F, -3.0F, 12, 8, 4);
		bodyfront.setRotationPoint(0.0F, -1.0F, -3.0F);
		setRotation(bodyfront, 0.3490659F, 0.0F, 0.0F);
		bodymid = new ModelRenderer(this, 32, 24);
		bodymid.addBox(-2.0F, 5.0F, 0.0F, 8, 5, 6);
		bodymid.setRotationPoint(-2.0F, 0.0F, -3.0F);
		setRotation(bodymid, 0.1745329F, 0.0F, 0.0F);
		rightarm = new ModelRenderer(this, 68, 10);
		rightarm.addBox(-3F, -2F, -1.5F, 3, 8, 3);
		rightarm.setRotationPoint(-7F, 2F, -1F);
		setRotation(rightarm, 0.5235988F, -0.2617994F, 0.2617994F);
		leftarm = new ModelRenderer(this, 68, 10);
		leftarm.addBox(0F, -2F, -1.5F, 3, 8, 3);
		leftarm.setRotationPoint(7F, 2F, -1F);
		setRotation(leftarm, 0.5235988F, 0.2617994F, -0.2617994F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 68, 0);
		rightpauldron.addBox(-4F, -5F, -2.5F, 7, 5, 5);
		rightpauldron.setRotationPoint(-7F, 2F, -1F);
		setRotation(rightpauldron, 0.3490659F, 0F, -0.0872665F);
		ModelRenderer rightarmfin = new ModelRenderer(this, 68, 21);
		rightarmfin.addBox(-2F, -1F, 3.5F, 1, 8, 4);
		rightarmfin.setRotationPoint(-7F, 2F, -1F);
		setRotation(rightarmfin, 0F, -0.2617994F, 0.2617994F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 68, 33);
		rightarmlower.addBox(-3.5F, 3F, 1.5F, 4, 10, 4);
		rightarmlower.setRotationPoint(-7F, 2F, -1F);
		setRotation(rightarmlower, 0F, -0.2617994F, 0.2617994F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 92, 0);
		leftpauldron.addBox(-3F, -5F, -2.5F, 7, 5, 5);
		leftpauldron.setRotationPoint(7F, 2F, -1F);
		setRotation(leftpauldron, 0.3490659F, 0F, 0.0872665F);
		ModelRenderer leftarmfin = new ModelRenderer(this, 68, 21);
		leftarmfin.addBox(1F, -1F, 3.5F, 1, 8, 4);
		leftarmfin.setRotationPoint(7F, 2F, -1F);
		setRotation(leftarmfin, 0F, 0.2617994F, -0.2617994F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 84, 33);
		leftarmlower.addBox(-0.5F, 3F, 1.5F, 4, 10, 4);
		leftarmlower.setRotationPoint(7F, 2F, -1F);
		setRotation(leftarmlower, 0F, 0.2617994F, -0.2617994F);
		waist = new ModelRenderer(this, 32, 35);
		waist.addBox(-1F, 10F, 3F, 6, 4, 5);
		waist.setRotationPoint(-2F, -1F, -3.5F);
		setRotation(waist, 0F, 0F, 0F);
		tail1 = new ModelRenderer(this, 32, 44);
		tail1.addBox(0F, 14F, -3F, 4, 4, 4);
		tail1.setRotationPoint(-2F, -1F, -3.5F);
		setRotation(tail1, 0.5235988F, 0F, 0F);
		tail2 = new ModelRenderer(this, 48, 44);
		tail2.addBox(0.5F, 17.5F, -4F, 3, 3, 3);
		tail2.setRotationPoint(-2F, -1F, -3.5F);
		setRotation(tail2, 0.6108652F, 0F, 0F);
		tail3 = new ModelRenderer(this, 32, 52);
		tail3.addBox(1F, 20F, -5F, 2, 6, 2);
		tail3.setRotationPoint(-2F, -1F, -3.5F);
		setRotation(tail3, 0.6981317F, 0F, 0F);
		tailend = new ModelRenderer(this, 40, 52);
		tailend.addBox(-3F, 22F, -4.5F, 10, 6, 1);
		tailend.setRotationPoint(-2F, -1F, -3.5F);
		setRotation(tailend, 0.6981317F, 0F, 0F);
		rightleg = new ModelRenderer(this, 100, 10);
		rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
		rightleg.setRotationPoint(-3.0F, 11.0F, 2.0F);
		setRotation(rightleg, -0.5585054F, 0.0F, 0.0349066F);
		rightleglower = new ModelRenderer(this, 100, 21);
		rightleglower.addBox(-1.5F, 1.0F, -6.0F, 3, 3, 3);
		rightleglower.setRotationPoint(-3.0F, 13.0F, 2.0F);
		setRotation(rightleglower, 0.3490659F, 0.0F, 0.0349066F);
		rightfoot = new ModelRenderer(this, 100, 27);
		rightfoot.addBox(-2.0F, 4.0F, -3.0F, 4, 8, 4);
		rightfoot.setRotationPoint(-3.0F, 13.0F, 2.0F);
		setRotation(rightfoot, -0.1745329F, 0.0F, 0.0349066F);
		leftleg = new ModelRenderer(this, 100, 10);
		leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
		leftleg.setRotationPoint(3.0F, 11.0F, 2.0F);
		setRotation(leftleg, -0.5759587F, 0.0F, -0.0349066F);
		leftleglower = new ModelRenderer(this, 100, 21);
		leftleglower.addBox(-1.5F, 1.0F, -6.0F, 3, 3, 3);
		leftleglower.setRotationPoint(3.0F, 13.0F, 2.0F);
		setRotation(leftleglower, 0.3490659F, 0.0F, -0.0349066F);
		leftfoot = new ModelRenderer(this, 100, 27);
		leftfoot.addBox(-2.0F, 4.0F, -3.0F, 4, 8, 4);
		leftfoot.setRotationPoint(3.0F, 13.0F, 2.0F);
		setRotation(leftfoot, -0.1745329F, 0.0F, -0.0349066F);

		convertToChild(head, headsnout);
		convertToChild(head, headjaw);
		convertToChild(rightarm, rightpauldron);
		convertToChild(rightarm, rightarmfin);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftpauldron);
		convertToChild(leftarm, leftarmfin);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfoot);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		finback.render(scale);
		bodyback.render(scale);
		bodyfront.render(scale);
		bodymid.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
		tail1.render(scale);
		tail2.render(scale);
		tail3.render(scale);
		tailend.render(scale);
		rightleg.render(scale);
		rightleglower.render(scale);
		rightfoot.render(scale);
		leftleg.render(scale);
		leftleglower.render(scale);
		leftfoot.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		finback.rotateAngleY = head.rotateAngleY;

		// arms
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
			rightarm.rotateAngleX += (MathHelper.sin(ageInTicks * 0.067F) * 0.05F) + 0.5235988F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
			leftarm.rotateAngleX -= (MathHelper.sin(ageInTicks * 0.067F) * 0.05F) - 0.5235988F;
		}

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// body
		tail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		tail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		tail3.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(6);
		tailend.rotateAngleY = tail3.rotateAngleY;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.5585054F;
		leftleg.rotateAngleX -= 0.5585054F;
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
		rightarm.rotateAngleY += (bodyfront.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX = (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodyfront.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationBuff() {
		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;
		rightarm.rotateAngleZ = +0.785398F;
		leftarm.rotateAngleZ = -0.785398F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
