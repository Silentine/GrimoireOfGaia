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
public class ModelGaiaNaga extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer body;
	private ModelRenderer body2;
	private ModelRenderer fin1;
	private ModelRenderer fin2;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightarmlower;
	private ModelRenderer leftarmlower;
	private ModelRenderer waist;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer tail4;
	private ModelRenderer tail5;
	private ModelRenderer tail6;
	private ModelRenderer tail7;
	private ModelRenderer tail8;

	private static final double CYCLES_PER_BLOCK = 0.75D;
	private float[][] undulationCycle = new float[][] { { 5F, 0F, -11.25F, -45F, -22.5F, 0F, 22.5F, 45F }, { 10F, 10F, 0F, -22.5F, -45F, -22.5F, 0F, 22.5F }, { 5F, 20F, 11.25F, 0F, -22.5F, -45F, -22.5F, 0F }, { 0F, 10F, 22.5F, 22.5F, 0F, -22.5F, -45F, -22.5F }, { -5F, 0F, 11.25F, 45F, 22.5F, 0F, -22.5F, -45F }, { -10F, -10F, 0F, 22.5F, 45F, 22.5F, 0F, -22.5F }, { -5F, -20F, -11.25F, 0F, 22.5F, 45F, 22.5F, 0F }, { 0F, -10F, -22.5F, -22.5F, 0F, 22.5F, 45F, 22.5F }, };

	public ModelGaiaNaga() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -5F, -3F, 6, 5, 7);
		head.setRotationPoint(0F, -6F, -3F);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer headbrowright = new ModelRenderer(this, 0, 12);
		headbrowright.addBox(-2.5F, -3F, -1F, 2, 2, 3);
		headbrowright.setRotationPoint(0F, -9F, -6F);
		setRotation(headbrowright, 0.3926991F, 0F, 0F);
		ModelRenderer headbrowleft = new ModelRenderer(this, 0, 12);
		headbrowleft.mirror = true;
		headbrowleft.addBox(0.5F, -3F, -1F, 2, 2, 3);
		headbrowleft.setRotationPoint(0F, -9F, -6F);
		setRotation(headbrowleft, 0.3926991F, 0F, 0F);
		ModelRenderer headnose = new ModelRenderer(this, 0, 17);
		headnose.addBox(-2F, -3F, -3F, 4, 3, 5);
		headnose.setRotationPoint(0F, -8F, -6F);
		setRotation(headnose, 0.7853982F, 0F, 0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 25);
		headjaw.addBox(-2.5F, -2F, -6.5F, 5, 3, 6);
		headjaw.setRotationPoint(0F, -6F, -3F);
		setRotation(headjaw, 0F, 0F, 0F);
		ModelRenderer headtendrils = new ModelRenderer(this, 0, 34);
		headtendrils.addBox(-3F, -1F, -7F, 6, 6, 6);
		headtendrils.setRotationPoint(0F, -6F, -3F);
		setRotation(headtendrils, 0F, 0F, 0F);
		ModelRenderer rightfin = new ModelRenderer(this, 19, -5);
		rightfin.addBox(0F, -3F, 0F, 0, 5, 5);
		rightfin.setRotationPoint(-3F, -9F, -5F);
		setRotation(rightfin, 0F, -0.7853982F, 0F);
		ModelRenderer leftfin = new ModelRenderer(this, 19, -5);
		leftfin.mirror = true;
		leftfin.addBox(0F, -3F, 0F, 0, 5, 5);
		leftfin.setRotationPoint(3F, -9F, -5F);
		setRotation(leftfin, 0F, 0.7853982F, 0F);
		body = new ModelRenderer(this, 34, 14);
		body.addBox(-4.5F, -2F, -1.5F, 9, 4, 4);
		body.setRotationPoint(0F, -7F, 0F);
		setRotation(body, 0.2617994F, 0F, 0F);
		body2 = new ModelRenderer(this, 34, 44);
		body2.addBox(-5.5F, 0F, -2.5F, 11, 9, 6);
		body2.setRotationPoint(0F, -7F, 0F);
		setRotation(body2, -0.1745329F, 0F, 0F);
		fin1 = new ModelRenderer(this, 104, 39);
		fin1.addBox(0F, -5F, -2.5F, 0, 13, 12);
		fin1.setRotationPoint(0F, -7F, 0F);
		setRotation(fin1, -0.1745329F, 0F, 0F);
		fin2 = new ModelRenderer(this, 0, 46);
		fin2.addBox(0F, -10F, -3F, 0, 5, 6);
		fin2.setRotationPoint(0F, -6F, -3F);
		setRotation(fin2, 0F, 0F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 34, 0);
		rightpauldron.addBox(-5F, -2.5F, -3F, 7, 7, 7);
		rightpauldron.setRotationPoint(-5.5F, -4F, 0F);
		setRotation(rightpauldron, 0F, 0F, -0.1745329F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 34, 0);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-2F, -2.5F, -3F, 7, 7, 7);
		leftpauldron.setRotationPoint(5.5F, -4F, 0F);
		setRotation(leftpauldron, 0F, 0F, 0.1745329F);
		rightarm = new ModelRenderer(this, 34, 22);
		rightarm.addBox(-3F, -1.5F, -1.5F, 3, 8, 3);
		rightarm.setRotationPoint(-5.5F, -4F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 34, 22);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1.5F, -1.5F, 3, 8, 3);
		leftarm.setRotationPoint(5.5F, -4F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightarmlower = new ModelRenderer(this, 34, 33);
		rightarmlower.addBox(-1.51F, 0F, -3F, 3, 8, 3);
		rightarmlower.setRotationPoint(-7F, 2.5F, 1.5F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new ModelRenderer(this, 34, 33);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-1.49F, 0F, -3F, 3, 8, 3);
		leftarmlower.setRotationPoint(7F, 2.5F, 1.5F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		waist = new ModelRenderer(this, 68, 0);
		waist.addBox(-4.5F, 9F, -2.5F, 9, 5, 5);
		waist.setRotationPoint(0F, -7F, 0F);
		setRotation(waist, -0.1308997F, 0F, 0F);
		tail1 = new ModelRenderer(this, 68, 10);
		tail1.addBox(-4F, 0F, -3F, 8, 8, 6);
		tail1.setRotationPoint(0F, 5F, -0.5F);
		tail1.mirror = true;
		setRotation(tail1, 0F, 0F, 0F);
		tail2 = new ModelRenderer(this, 68, 24);
		tail2.addBox(-3.5F, 0F, 0F, 7, 7, 6);
		tail2.setRotationPoint(0F, 13F, -3.5F);
		setRotation(tail2, 0F, 0F, 0F);
		tail3 = new ModelRenderer(this, 68, 37);
		tail3.addBox(-3F, 0F, 0F, 6, 6, 6);
		tail3.setRotationPoint(0F, 20F, -3.5F);
		setRotation(tail3, 0F, 0F, 0F);
		tail4 = new ModelRenderer(this, 68, 49);
		tail4.addBox(-2.5F, 0F, 0.5F, 5, 5, 5);
		tail4.setRotationPoint(0F, 26F, -3.5F);
		setRotation(tail4, 0F, 0F, 0F);
		tail5 = new ModelRenderer(this, 68, 49);
		tail5.addBox(-2.5F, 0F, 0F, 5, 5, 5);
		tail5.setRotationPoint(0F, 31F, -3F);
		setRotation(tail5, 0F, 0F, 0F);
		tail6 = new ModelRenderer(this, 96, 0);
		tail6.addBox(-2F, 0F, 0.5F, 4, 4, 4);
		tail6.setRotationPoint(0F, 36F, -3F);
		setRotation(tail6, 0F, 0F, 0F);
		tail7 = new ModelRenderer(this, 96, 0);
		tail7.addBox(-2F, 0F, 0F, 4, 4, 4);
		tail7.setRotationPoint(0F, 40F, -2.5F);
		setRotation(tail7, 0F, 0F, 0F);
		tail8 = new ModelRenderer(this, 96, 8);
		tail8.addBox(-1.5F, 0F, 0.5F, 3, 3, 3);
		tail8.setRotationPoint(0F, 44F, -2.5F);
		setRotation(tail8, 0F, 0F, 0F);

		convertToChild(head, headbrowright);
		convertToChild(head, headbrowleft);
		convertToChild(head, headnose);
		convertToChild(head, headjaw);
		convertToChild(head, headtendrils);
		convertToChild(head, rightfin);
		convertToChild(head, leftfin);
		convertToChild(rightarm, rightpauldron);
		convertToChild(leftarm, leftpauldron);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);

		convertToChild(tail7, tail8);
		convertToChild(tail6, tail7);
		convertToChild(tail5, tail6);
		convertToChild(tail4, tail5);
		convertToChild(tail3, tail4);
		convertToChild(tail2, tail3);
		convertToChild(tail1, tail2);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		body.render(scale);
		body2.render(scale);
		fin1.render(scale);
		fin2.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
		tail1.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		float armDefaultAngleX = 0.261799F;

		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

			rightarm.rotateAngleX = +armDefaultAngleX;
			leftarm.rotateAngleX = +armDefaultAngleX;

			rightarmlower.rotateAngleX = -armDefaultAngleX;
			leftarmlower.rotateAngleX = -armDefaultAngleX;
		}

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// body
		fin2.rotateAngleY = head.rotateAngleY;
		fin2.rotateAngleX = head.rotateAngleX;

		// legs
		tail1.rotateAngleX = -0.1308997F;
		tail2.rotateAngleX = 0.3926991F;
		tail3.rotateAngleX = 0.3926991F;
		tail4.rotateAngleX = 0.785398F;
		tail5.rotateAngleX = 0.1309F;
		tail8.rotateAngleX = 0.3926991F;

		updateDistanceMovedTotal(entityIn);
		int cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % undulationCycle.length);

		tail5.rotateAngleZ = degToRad(undulationCycle[cycleIndex][4]);
		tail6.rotateAngleZ = degToRad(undulationCycle[cycleIndex][5]);
		tail7.rotateAngleZ = degToRad(undulationCycle[cycleIndex][6]);
		tail8.rotateAngleZ = degToRad(undulationCycle[cycleIndex][7]);
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

	private void animationBuff() {
		float armDefaultAngleX = 0.785398F;

		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;
		rightarm.rotateAngleZ = +armDefaultAngleX;
		leftarm.rotateAngleZ = -armDefaultAngleX;

		rightarm.rotateAngleX = +armDefaultAngleX;
		leftarm.rotateAngleX = +armDefaultAngleX;
		rightarmlower.rotateAngleX = -armDefaultAngleX;
		leftarmlower.rotateAngleX = -armDefaultAngleX;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
