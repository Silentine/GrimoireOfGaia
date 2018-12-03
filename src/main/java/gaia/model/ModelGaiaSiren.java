package gaia.model;

import gaia.entity.monster.EntityGaiaSiren;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSiren extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymid;
	private ModelRenderer bodymidbutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer mantle;
	private ModelRenderer rightarmextra;
	private ModelRenderer leftarmextra;
	private ModelRenderer rightarmextralower;
	private ModelRenderer leftarmextralower;
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer tail4;
	private ModelRenderer tail5;
	private ModelRenderer tail6;
	private ModelRenderer tail7;
	private ModelRenderer tail8;

	private static final double CYCLES_PER_BLOCK = 0.75D;
	private float[][] undulationCycle = new float[][] {
		{   5F,   0F,-11.25F,  -45F,-22.5F,    0F, 22.5F,   45F}, 
		{  10F,  10F,     0F,-22.5F,  -45F,-22.5F,    0F, 22.5F}, 
		{   5F,  20F, 11.25F,    0F,-22.5F,  -45F,-22.5F,    0F}, 
		{   0F,  10F , 22.5F, 22.5F,    0F,-22.5F,  -45F,-22.5F}, 
		{  -5F,   0F, 11.25F,   45F, 22.5F,    0F,-22.5F,  -45F}, 
		{ -10F, -10F,     0F, 22.5F,   45F, 22.5F,    0F,-22.5F}, 
		{  -5F, -20F,-11.25F,    0F, 22.5F,   45F, 22.5F,    0F}, 
		{   0F, -10F, -22.5F,-22.5F,    0F, 22.5F,   45F, 22.5F}, 
		};

	public ModelGaiaSiren() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(128, 64);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymid = new ModelRenderer(this, 0, 25);
		bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymid.setRotationPoint(0F, 1F, 0F);
		bodymid.setTextureSize(128, 64);
		setRotation(bodymid, 0F, 0F, 0F);
		bodymidbutton = new ModelRenderer(this, 0, 25);
		bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymidbutton.setRotationPoint(0F, 1F, 0F);
		bodymidbutton.setTextureSize(128, 64);
		setRotation(bodymidbutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0F, 0F, 0.4363323F);
		leftarm = new ModelRenderer(this, 16, 36);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0F, 0F, -0.4363323F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(128, 64);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 25);
		hair2.addBox(-4.5F, 0F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(128, 64);
		setRotation(hair2, 0F, 0F, 0F);
		ModelRenderer finright = new ModelRenderer(this, 36, 32);
		finright.addBox(0F, -3F, 0F, 0, 5, 5);
		finright.setRotationPoint(-3F, -2F, -3F);
		finright.setTextureSize(128, 64);
		setRotation(finright, 0F, -0.5235988F, 0F);
		ModelRenderer finleft = new ModelRenderer(this, 36, 32);
		finleft.addBox(0F, -3F, 0F, 0, 5, 5);
		finleft.setRotationPoint(3F, -2F, -3F);
		finleft.setTextureSize(128, 64);
		setRotation(finleft, 0F, 0.5235988F, 0F);
		mantle = new ModelRenderer(this, 36, 42);
		mantle.addBox(-4.5F, 0F, -2F, 9, 5, 4);
		mantle.setRotationPoint(0F, 1F, 0F);
		mantle.setTextureSize(128, 64);
		setRotation(mantle, -0.0872665F, 0F, 0F);
		rightarmextra = new ModelRenderer(this, 24, 12);
		rightarmextra.addBox(-1F, -1F, -1F, 2, 6, 2);
		rightarmextra.setRotationPoint(-2.5F, 3.5F, 1F);
		rightarmextra.setTextureSize(128, 64);
		setRotation(rightarmextra, 0F, 0F, 0F);
		leftarmextra = new ModelRenderer(this, 24, 36);
		leftarmextra.addBox(-1F, -1F, -1F, 2, 6, 2);
		leftarmextra.setRotationPoint(2.5F, 3.5F, 1F);
		leftarmextra.setTextureSize(128, 64);
		setRotation(leftarmextra, 0F, 0F, 0F);
		rightarmextralower = new ModelRenderer(this, 24, 20);
		rightarmextralower.addBox(-1F, 0F, -2F, 2, 6, 2);
		rightarmextralower.setRotationPoint(-2.5F, 8.5F, 2F);
		rightarmextralower.setTextureSize(128, 64);
		setRotation(rightarmextralower, 0F, 0F, 0F);
		leftarmextralower = new ModelRenderer(this, 24, 44);
		leftarmextralower.addBox(-1F, 0F, -2F, 2, 6, 2);
		leftarmextralower.setRotationPoint(2.5F, 8.5F, 2F);
		leftarmextralower.setTextureSize(128, 64);
		setRotation(leftarmextralower, 0F, 0F, 0F);
		tail1 = new ModelRenderer(this, 64, 0);
		tail1.addBox(-3.5F, -1F, -2.5F, 7, 4, 4);
		tail1.setRotationPoint(0F, 11F, 0F);
		tail1.setTextureSize(128, 64);
		setRotation(tail1, 0F, 0F, 0F);
		tail2 = new ModelRenderer(this, 64, 8);
		tail2.addBox(-3F, 0F, 0F, 6, 4, 4);
		tail2.setRotationPoint(0F, 14F, -2.5F);
		tail2.setTextureSize(128, 64);
		setRotation(tail2, 0F, 0F, 0F);
		tail3 = new ModelRenderer(this, 64, 16);
		tail3.addBox(-2.5F, 0F, 0F, 5, 4, 4);
		tail3.setRotationPoint(0F, 18F, -2.5F);
		tail3.setTextureSize(128, 64);
		setRotation(tail3, 0F, 0F, 0F);
		tail4 = new ModelRenderer(this, 64, 16);
		tail4.addBox(-2.5F, 0F, 0F, 5, 4, 4);
		tail4.setRotationPoint(0F, 22F, -2.5F);
		tail4.setTextureSize(128, 64);
		setRotation(tail4, 0F, 0F, 0F);
		tail5 = new ModelRenderer(this, 64, 24);
		tail5.addBox(-2F, 0F, 0.5F, 4, 4, 3);
		tail5.setRotationPoint(0F, 26F, -2.5F);
		tail5.setTextureSize(128, 64);
		setRotation(tail5, 0F, 0F, 0F);
		tail6 = new ModelRenderer(this, 64, 24);
		tail6.addBox(-2F, 0F, 0F, 4, 4, 3);
		tail6.setRotationPoint(0F, 30F, -2F);
		tail6.setTextureSize(128, 64);
		setRotation(tail6, 0F, 0F, 0F);
		tail7 = new ModelRenderer(this, 64, 31);
		tail7.addBox(-1.5F, 0F, 0.5F, 3, 3, 2);
		tail7.setRotationPoint(0F, 34F, -2F);
		tail7.setTextureSize(128, 64);
		setRotation(tail7, 0F, 0F, 0F);
		tail8 = new ModelRenderer(this, 64, 36);
		tail8.addBox(-1F, 0F, 0F, 2, 2, 2);
		tail8.setRotationPoint(0F, 37F, -1.5F);
		tail8.setTextureSize(128, 64);
		setRotation(tail8, 0F, 0F, 0F);

		convertToChild(head, finright);
		convertToChild(head, finleft);
		convertToChild(rightarmextra, rightarmextralower);
		convertToChild(leftarmextra, leftarmextralower);
		
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
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymid.render(scale);
		bodymidbutton.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		mantle.render(scale);
		rightarmextra.render(scale);
		leftarmextra.render(scale);
		tail1.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && ageInTicks <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
		float armextraDefaultAngleX = 0.261799F;
		
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		EntityGaiaSiren entity = (EntityGaiaSiren) entityIn;

		if (entity.isSwingingArms() && (itemstack.getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		
		rightarmextra.rotateAngleZ = +armextraDefaultAngleX;
		leftarmextra.rotateAngleZ = -armextraDefaultAngleX;
		
		rightarmextra.rotateAngleX = +armextraDefaultAngleX;
		leftarmextra.rotateAngleX = +armextraDefaultAngleX;
		
		rightarmextralower.rotateAngleX = -armextraDefaultAngleX;
		leftarmextralower.rotateAngleX = -armextraDefaultAngleX;

		// legs
		tail1.rotateAngleX = -0.1308997F;
		tail2.rotateAngleX = +0.3926991F;
		tail3.rotateAngleX = +0.3926991F;
		tail4.rotateAngleX = +0.785398F;
		tail8.rotateAngleX = +0.3926991F;
		
		updateDistanceMovedTotal(entityIn);
		int cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % undulationCycle.length);

		tail5.rotateAngleZ = degToRad(undulationCycle[cycleIndex][4]);
		tail6.rotateAngleZ = degToRad(undulationCycle[cycleIndex][5]);
		tail7.rotateAngleZ = degToRad(undulationCycle[cycleIndex][6]);
		tail8.rotateAngleZ = degToRad(undulationCycle[cycleIndex][7]);
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2F);
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

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
