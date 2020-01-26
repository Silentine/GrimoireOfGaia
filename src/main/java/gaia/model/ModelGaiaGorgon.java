package gaia.model;

import gaia.entity.monster.EntityGaiaGorgon;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaGorgon extends ModelGaia {

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
	private ModelRenderer hair;
	private ModelRenderer rightear;
	private ModelRenderer leftear;
	private ModelRenderer snake1;
	private ModelRenderer snake2;
	private ModelRenderer snake3;
	private ModelRenderer rightsnake1;
	private ModelRenderer rightsnake2;
	private ModelRenderer leftsnake1;
	private ModelRenderer leftsnake2;
	private ModelRenderer snake1tongue;
	private ModelRenderer snake2tongue;
	private ModelRenderer snake3tongue;
	private ModelRenderer rightsnaketongue;
	private ModelRenderer leftsnaketongue;
	private ModelRenderer rightbang;
	private ModelRenderer leftbang;
	private ModelRenderer waist1;
	private ModelRenderer waist2;
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


	public ModelGaiaGorgon(float scaleFactor) {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6, scaleFactor);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0, scaleFactor);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7, scaleFactor);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2, scaleFactor);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3, scaleFactor);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymid = new ModelRenderer(this, 0, 25);
		bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2, scaleFactor);
		bodymid.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymid, 0F, 0F, 0F);
		bodymidbutton = new ModelRenderer(this, 0, 25);
		bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0, scaleFactor);
		bodymidbutton.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymidbutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2F, 6, 3, 3, scaleFactor);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		setRotation(bodybottom, 0F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2, scaleFactor);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2, scaleFactor);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2, scaleFactor);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0.2617994F);
		leftarm = new ModelRenderer(this, 24, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2, scaleFactor);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, -0.2617994F);
		hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-4F, -7F, -4F, 8, 8, 8, scaleFactor);
		hair.setRotationPoint(0F, 1F, 0F);
		setRotation(hair, 0F, 0F, 0F);
		rightear = new ModelRenderer(this, 36, 32);
		rightear.addBox(0F, -1F, 0F, 0, 3, 4, scaleFactor);
		rightear.setRotationPoint(-3F, -2F, -3F);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		leftear = new ModelRenderer(this, 36, 32);
		leftear.addBox(0F, -1F, 0F, 0, 3, 4, scaleFactor);
		leftear.setRotationPoint(3F, -2F, -3F);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		snake1 = new ModelRenderer(this, 36, 30);
		snake1.addBox(-1F, -4F, -1F, 2, 4, 2);
		snake1.setRotationPoint(0F, -5F, -1.5F);
		setRotation(snake1, 0F, 0F, 0F);
		snake2 = new ModelRenderer(this, 36, 30);
		snake2.addBox(-1F, -3.5F, -1F, 2, 4, 2);
		snake2.setRotationPoint(-3F, -5F, 0F);
		setRotation(snake2, 0F, 0F, 0F);
		snake3 = new ModelRenderer(this, 36, 30);
		snake3.addBox(-1F, -3.5F, -1F, 2, 4, 2);
		snake3.setRotationPoint(3F, -5F, 0F);
		setRotation(snake3, 0F, 0F, 0F);
		rightsnake1 = new ModelRenderer(this, 52, 30);
		rightsnake1.addBox(-6F, -5.5F, -1.5F, 2, 2, 2);
		rightsnake1.setRotationPoint(0F, 1F, 0F);
		setRotation(rightsnake1, 0F, 0F, 0F);
		rightsnake2 = new ModelRenderer(this, 44, 30);
		rightsnake2.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightsnake2.setRotationPoint(-6F, -4.5F, -1.5F);
		setRotation(rightsnake2, 0F, 0F, 0F);
		leftsnake1 = new ModelRenderer(this, 52, 30);
		leftsnake1.addBox(4F, -5.5F, -1.5F, 2, 2, 2);
		leftsnake1.setRotationPoint(0F, 1F, 0F);
		setRotation(leftsnake1, 0F, 0F, 0F);
		leftsnake2 = new ModelRenderer(this, 44, 30);
		leftsnake2.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftsnake2.setRotationPoint(6F, -4.5F, -1.5F);
		setRotation(leftsnake2, 0F, 0F, 0F);
		leftsnake1 = new ModelRenderer(this, 52, 30);
		leftsnake1.addBox(4F, -5.5F, -1.5F, 2, 2, 2, scaleFactor);
		leftsnake1.setRotationPoint(0F, 1F, 0F);
		setRotation(leftsnake1, 0F, 0F, 0F);
		leftsnake2 = new ModelRenderer(this, 44, 30);
		leftsnake2.addBox(5F, -6.5F, -2.5F, 2, 2, 2, scaleFactor);
		leftsnake2.setRotationPoint(0F, 1F, 0F);
		setRotation(leftsnake2, 0F, 0F, 0F);
		snake1tongue = new ModelRenderer(this, 59, 30);
		snake1tongue.addBox(-0.5F, 0F, -1F, 1, 0, 1, scaleFactor);
		snake1tongue.setRotationPoint(0F, -7F, -2.5F);
		snake1tongue.mirror = true;
		setRotation(snake1tongue, 0.7853982F, 0F, 0F);
		snake2tongue = new ModelRenderer(this, 59, 30);
		snake2tongue.addBox(-0.5F, 0F, -1F, 1, 0, 1, scaleFactor);
		snake2tongue.setRotationPoint(-3F, -6.5F, -1F);
		setRotation(snake2tongue, 0.7853982F, 0F, 0F);
		snake3tongue = new ModelRenderer(this, 59, 30);
		snake3tongue.addBox(-0.5F, 0F, -1F, 1, 0, 1, scaleFactor);
		snake3tongue.setRotationPoint(3F, -6.5F, -1F);
		setRotation(snake3tongue, 0.7853982F, 0F, 0F);
		rightsnaketongue = new ModelRenderer(this, 59, 30);
		rightsnaketongue.addBox(-0.5F, 0F, -1F, 1, 0, 1, scaleFactor);
		rightsnaketongue.setRotationPoint(-6F, -3.5F, -2.5F);
		setRotation(rightsnaketongue, 0.7853982F, 0F, 0F);
		leftsnaketongue = new ModelRenderer(this, 59, 30);
		leftsnaketongue.addBox(-0.5F, 0F, -1F, 1, 0, 1, scaleFactor);
		leftsnaketongue.setRotationPoint(6F, -3.5F, -2.5F);
		setRotation(leftsnaketongue, 0.7853982F, 0F, 0F);
		rightbang = new ModelRenderer(this, 36, 39);
		rightbang.addBox(-0.5F, 0F, -0.5F, 1, 6, 1, scaleFactor);
		rightbang.setRotationPoint(-3F, -3F, -3F);
		setRotation(rightbang, 0F, 0F, 0F);
		leftbang = new ModelRenderer(this, 36, 39);
		leftbang.addBox(-0.5F, 0F, -0.5F, 1, 6, 1, scaleFactor);
		leftbang.setRotationPoint(3F, -3F, -3F);
		setRotation(leftbang, 0F, 0F, 0F);
		waist1 = new ModelRenderer(this, 68, 0);
		waist1.addBox(-4F, -1.5F, -3.5F, 5, 7, 6, scaleFactor);
		waist1.setRotationPoint(0F, 11F, 0F);
		setRotation(waist1, 0F, 0F, 0F);
		waist2 = new ModelRenderer(this, 68, 13);
		waist2.addBox(-1F, -1.5F, -3F, 5, 2, 5, scaleFactor);
		waist2.setRotationPoint(0F, 11F, 0F);
		setRotation(waist2, 0F, 0F, 0.3490659F);
		tail1 = new ModelRenderer(this, 90, 0);
		tail1.addBox(-3.5F, -1F, -2.5F, 7, 4, 4, scaleFactor);
		tail1.setRotationPoint(0F, 11F, 0F);
		setRotation(tail1, 0F, 0F, 0F);
		tail2 = new ModelRenderer(this, 90, 8);
		tail2.addBox(-3F, 0F, 0F, 6, 4, 4, scaleFactor);
		tail2.setRotationPoint(0F, 14F, -2.5F);
		setRotation(tail2, 0F, 0F, 0F);
		tail3 = new ModelRenderer(this, 90, 16);
		tail3.addBox(-2.5F, 0F, 0F, 5, 4, 4, scaleFactor);
		tail3.setRotationPoint(0F, 18F, -2.5F);
		setRotation(tail3, 0F, 0F, 0F);
		tail4 = new ModelRenderer(this, 90, 16);
		tail4.addBox(-2.5F, 0F, 0F, 5, 4, 4, scaleFactor);
		tail4.setRotationPoint(0F, 22F, -2.5F);
		setRotation(tail4, 0F, 0F, 0F);
		tail5 = new ModelRenderer(this, 90, 24);
		tail5.addBox(-2F, 0F, 0.5F, 4, 4, 3, scaleFactor);
		tail5.setRotationPoint(0F, 26F, -2.5F);
		setRotation(tail5, 0F, 0F, 0F);
		tail6 = new ModelRenderer(this, 90, 24);
		tail6.addBox(-2F, 0F, 0F, 4, 4, 3, scaleFactor);
		tail6.setRotationPoint(0F, 30F, -2F);
		setRotation(tail6, 0F, 0F, 0F);
		tail7 = new ModelRenderer(this, 90, 31);
		tail7.addBox(-1.5F, 0F, 0.5F, 3, 3, 2, scaleFactor);
		tail7.setRotationPoint(0F, 34F, -2F);
		setRotation(tail7, 0F, 0F, 0F);
		tail8 = new ModelRenderer(this, 90, 36);
		tail8.addBox(-1F, 0F, 0F, 2, 2, 2, scaleFactor);
		tail8.setRotationPoint(0F, 37F, -1.5F);
		setRotation(tail8, 0F, 0F, 0F);
		
		convertToChild(head, hair);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(snake1, snake1tongue);
		convertToChild(snake2, snake2tongue);
		convertToChild(snake3, snake3tongue);
		convertToChild(rightsnake2, rightsnaketongue);
		convertToChild(leftsnake2, leftsnaketongue);
		convertToChild(head, snake1);
		convertToChild(head, snake2);
		convertToChild(head, snake3);
		convertToChild(rightsnake1, rightsnake2);
		convertToChild(leftsnake1, leftsnake2);
		convertToChild(head, rightsnake1);
		convertToChild(head, leftsnake1);
		convertToChild(head, rightbang);
		convertToChild(head, leftbang);
		
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
		waist1.render(scale);
		waist2.render(scale);
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
		
		snake1tongue.showModel = entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F;
		snake2tongue.showModel = entityIn.ticksExisted % 120 == 0 && limbSwingAmount <= 0.1F;
		snake3tongue.showModel = entityIn.ticksExisted % 180 == 0 && limbSwingAmount <= 0.1F;
		rightsnaketongue.showModel = entityIn.ticksExisted % 180 == 0 && limbSwingAmount <= 0.1F;
		leftsnaketongue.showModel = entityIn.ticksExisted % 120 == 0 && limbSwingAmount <= 0.1F;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		EntityGaiaGorgon entity = (EntityGaiaGorgon) entityIn;

		if (entity.isSwingingArms() && (itemstack.getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.4363323F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

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
