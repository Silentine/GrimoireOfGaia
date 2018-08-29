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
	private ModelRenderer pauldron;
	private ModelRenderer body;
	private ModelRenderer body2;
	private ModelRenderer fin1;
	private ModelRenderer fin2;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer waist;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer tail4;
	private ModelRenderer tail5;
	private ModelRenderer tail6;
	private ModelRenderer tail7;

	private static final double CYCLES_PER_BLOCK = 1.0D;
	private float[][] undulationCycle = new float[][] 
			{ 
					{ 10F	, -10F	, -10F	, 0F	, 10F	, 10F	, 0F	, -10F	 }, 
					{ 5F	, 10F	, -10F	, -10F	, 0F	, 10F	, 10F	, 0F	 }, 
					{ 0F	, 25F	, 0F	, -10F	, -10F	, 0F	, 10F	, 10F	 }, 
					{ -10F	, 10F	, 10F	, 0F	, -10F	, -10F	, 0F	, 10F	 },
					{ -5F	, -10F	, 10F	, 10F	, 0F	, -10F	, -10F	, 0F	 }, 
					{ 0F	, -25F	, 0F	, 10F	, 10F	, 0F	, -10F	, -10F	 }, 
			};

	public ModelGaiaNaga() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -5F, -3F, 6, 5, 7);
		head.setRotationPoint(0F, -6F, -3F);
		head.setTextureSize(textureWidth, textureHeight);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer headnose1 = new ModelRenderer(this, 0, 12);
		headnose1.addBox(-1F, -4F, -5F, 2, 1, 2);
		headnose1.setRotationPoint(0F, -6F, -3F);
		headnose1.setTextureSize(textureWidth, textureHeight);
		setRotation(headnose1, 0F, 0F, 0F);
		ModelRenderer headnose2 = new ModelRenderer(this, 0, 15);
		headnose2.addBox(-2F, -3F, -6F, 4, 2, 3);
		headnose2.setRotationPoint(0F, -6F, -3F);
		headnose2.setTextureSize(textureWidth, textureHeight);
		setRotation(headnose2, 0F, 0F, 0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 20);
		headjaw.addBox(-2.5F, -2F, -6.5F, 5, 3, 6);
		headjaw.setRotationPoint(0F, -6F, -3F);
		headjaw.setTextureSize(textureWidth, textureHeight);
		setRotation(headjaw, 0F, 0F, 0F);
		ModelRenderer headtendrils = new ModelRenderer(this, 0, 29);
		headtendrils.addBox(-3F, -1F, -6.5F, 6, 6, 6);
		headtendrils.setRotationPoint(0F, -6F, -3F);
		headtendrils.setTextureSize(textureWidth, textureHeight);
		setRotation(headtendrils, 0F, 0F, 0F);
		ModelRenderer rightfin = new ModelRenderer(this, 19, -5);
		rightfin.addBox(-3F, -5F, 0F, 0, 5, 5);
		rightfin.setRotationPoint(0F, -6F, -3F);
		rightfin.setTextureSize(textureWidth, textureHeight);
		setRotation(rightfin, 0F, -0.5235988F, 0F);
		ModelRenderer leftfin = new ModelRenderer(this, 19, -5);
		leftfin.addBox(3F, -5F, 0F, 0, 5, 5);
		leftfin.setRotationPoint(0F, -6F, -3F);
		leftfin.setTextureSize(textureWidth, textureHeight);
		setRotation(leftfin, 0F, 0.5235988F, 0F);
		pauldron = new ModelRenderer(this, 34, 0);
		pauldron.addBox(-9F, -0.5F, -3F, 18, 7, 7);
		pauldron.setRotationPoint(0F, -7F, 0F);
		pauldron.setTextureSize(textureWidth, textureHeight);
		setRotation(pauldron, -0.1745329F, 0F, 0F);
		body = new ModelRenderer(this, 34, 14);
		body.addBox(-4.5F, -2F, -1.5F, 9, 4, 4);
		body.setRotationPoint(0F, -7F, 0F);
		body.setTextureSize(textureWidth, textureHeight);
		setRotation(body, 0.2617994F, 0F, 0F);
		body2 = new ModelRenderer(this, 34, 44);
		body2.addBox(-5.5F, 0F, -2.5F, 11, 9, 6);
		body2.setRotationPoint(0F, -7F, 0F);
		body2.setTextureSize(textureWidth, textureHeight);
		setRotation(body2, -0.1745329F, 0F, 0F);
		fin1 = new ModelRenderer(this, 0, 34);
		fin1.addBox(0F, -5F, -2.5F, 0, 13, 12);
		fin1.setRotationPoint(0F, -7F, 0F);
		fin1.setTextureSize(textureWidth, textureHeight);
		setRotation(fin1, -0.1745329F, 0F, 0F);
		fin2 = new ModelRenderer(this, 0, 35);
		fin2.addBox(0F, -9F, -3F, 0, 5, 6);
		fin2.setRotationPoint(0F, -6F, -3F);
		fin2.setTextureSize(textureWidth, textureHeight);
		setRotation(fin2, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 34, 22);
		rightarm.addBox(-3F, -1.5F, -1.5F, 3, 8, 3);
		rightarm.setRotationPoint(-5.5F, -4F, 0F);
		rightarm.setTextureSize(textureWidth, textureHeight);
		setRotation(rightarm, 0F, 0F, 0.0872665F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 34, 33);
		rightarmlower.addBox(-3F, 6.5F, -0.5F, 3, 8, 3);
		rightarmlower.setRotationPoint(-5.5F, -4F, 0F);
		rightarmlower.setTextureSize(textureWidth, textureHeight);
		setRotation(rightarmlower, -0.1745329F, 0F, 0.0872665F);
		leftarm = new ModelRenderer(this, 46, 22);
		leftarm.addBox(0F, -1.5F, -1.5F, 3, 8, 3);
		leftarm.setRotationPoint(5.5F, -4F, 0F);
		leftarm.setTextureSize(textureWidth, textureHeight);
		setRotation(leftarm, 0F, 0F, -0.0872665F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 46, 33);
		leftarmlower.addBox(0F, 6.5F, -0.5F, 3, 8, 3);
		leftarmlower.setRotationPoint(5.5F, -4F, 0F);
		leftarmlower.setTextureSize(textureWidth, textureHeight);
		setRotation(leftarmlower, -0.1745329F, 0F, -0.0872665F);
		waist = new ModelRenderer(this, 84, 0);
		waist.addBox(-4.5F, 9F, -2.5F, 9, 5, 5);
		waist.setRotationPoint(0F, -7F, 0F);
		waist.setTextureSize(textureWidth, textureHeight);
		setRotation(waist, -0.1308997F, undulationCycle[0][0], 0F);
		tail1 = new ModelRenderer(this, 84, 10);
		tail1.addBox(-4F, 14F, -2.5F, 8, 3, 4);
		tail1.setRotationPoint(0F, -7F, 0F);
		tail1.setTextureSize(textureWidth, textureHeight);
		setRotation(tail1, -0.0436332F, undulationCycle[0][1], 0F);
		tail2 = new ModelRenderer(this, 84, 17);
		tail2.addBox(-3.5F, 17F, -2.5F, 7, 3, 4);
		tail2.setRotationPoint(0F, -7F, 0F);
		tail2.setTextureSize(textureWidth, textureHeight);
		setRotation(tail2, 0F, undulationCycle[0][2], 0F);
		tail3 = new ModelRenderer(this, 108, 10);
		tail3.addBox(-3F, 20F, -2.5F, 6, 3, 4);
		tail3.setRotationPoint(0F, -7F, 0F);
		tail3.setTextureSize(textureWidth, textureHeight);
		setRotation(tail3, 0.0436332F, undulationCycle[0][3], 0F);
		tail4 = new ModelRenderer(this, 108, 10);
		tail4.addBox(-3F, 23F, -3.5F, 6, 3, 4);
		tail4.setRotationPoint(0F, -7F, 0F);
		tail4.setTextureSize(textureWidth, textureHeight);
		setRotation(tail4, 0.1308997F, undulationCycle[0][4], 0F);
		tail5 = new ModelRenderer(this, 108, 10);
		tail5.addBox(-3F, 26F, -3.5F, 6, 3, 4);
		tail5.setRotationPoint(0F, -7F, 0F);
		tail5.setTextureSize(textureWidth, textureHeight);
		setRotation(tail5, 0.1745329F, undulationCycle[0][5], 0F);
		tail6 = new ModelRenderer(this, 108, 17);
		tail6.addBox(-2.5F, 28F, -1.5F, 5, 3, 4);
		tail6.setRotationPoint(0F, -7F, 0F);
		tail6.setTextureSize(textureWidth, textureHeight);
		setRotation(tail6, 0.1745329F, undulationCycle[0][6], 0F);
		tail7 = new ModelRenderer(this, 108, 17);
		tail7.addBox(-2.5F, 29F, 1.5F, 5, 3, 4);
		tail7.setRotationPoint(0F, -7F, 0F);
		tail7.setTextureSize(textureWidth, textureHeight);
		setRotation(tail7, 0.1745329F, undulationCycle[0][7], 0F);

		convertToChild(head, headnose1);
		convertToChild(head, headnose2);
		convertToChild(head, headjaw);
		convertToChild(head, headtendrils);
		convertToChild(head, rightfin);
		convertToChild(head, leftfin);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(waist, tail1);
		convertToChild(waist, tail2);
		convertToChild(waist, tail3);
		convertToChild(waist, tail4);
		convertToChild(waist, tail5);
		convertToChild(waist, tail6);
		convertToChild(waist, tail7);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		pauldron.render(scale);
		body.render(scale);
		body2.render(scale);
		fin1.render(scale);
		fin2.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		if (itemstack.getItem() != Items.STICK) {
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
		}
		
		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// body
		fin2.rotateAngleY = head.rotateAngleY;
		fin2.rotateAngleX = head.rotateAngleX;

		// legs
		updateDistanceMovedTotal(entityIn);
		int cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % undulationCycle.length);

		waist.rotateAngleY = degToRad(undulationCycle[cycleIndex][0]);
		tail1.rotateAngleY = degToRad(undulationCycle[cycleIndex][1]);
		tail2.rotateAngleY = degToRad(undulationCycle[cycleIndex][2]);
		tail3.rotateAngleY = degToRad(undulationCycle[cycleIndex][3]);
		tail4.rotateAngleY = degToRad(undulationCycle[cycleIndex][4]);
		tail5.rotateAngleY = degToRad(undulationCycle[cycleIndex][5]);
		tail6.rotateAngleY = degToRad(undulationCycle[cycleIndex][6]);
		tail7.rotateAngleY = degToRad(undulationCycle[cycleIndex][7]);
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
		rightarm.rotateAngleX = -0.698132F;
		leftarm.rotateAngleX = -0.698132F;
		rightarm.rotateAngleY = 0.698132F;
		leftarm.rotateAngleY = -0.698132F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
