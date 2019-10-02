package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaMermaid<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel head;
	private RendererModel headeyes;
	private RendererModel headaccessory;
	private RendererModel neck;
	private RendererModel bodytop;
	private RendererModel bodymiddle;
	private RendererModel bodymiddlebutton;
	private RendererModel bodybottom;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel hair1;
	private RendererModel hair2;
	private RendererModel waist;
	private RendererModel fin1;
	private RendererModel fin2;
	private RendererModel fin2right;
	private RendererModel fin2left;
	private RendererModel fin3;
	private RendererModel fin4;
	private RendererModel fin5;
	private RendererModel fin6;
	private RendererModel fintail;

	private static final double CYCLES_PER_BLOCK = 0.75D;
	private float[][] undulationCycle = new float[][]
			{
					{-2.5F, -5F, -10F, -15F, -20F, -25F, -30F},
					{-2.5F, -5F, -7F, -9F, -11F, -13F, -15F},
					{0F, 0F, 0F, 0F, 0F, 0F, 0F},
					{2.5F, 5F, 10F, 15F, 20F, 25F, 30F},
					{2.5F, 5F, 7F, 9F, 11F, 13F, 15F},
					{0F, 0F, 0F, 0F, 0F, 0F, 0F},
			};

	public ModelGaiaMermaid() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 1F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 1F);
		headeyes.setTextureSize(128, 64);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 1F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 1F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 1F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 1F);
		bodymiddle.setTextureSize(128, 64);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 1F);
		bodymiddlebutton.setTextureSize(128, 64);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 1F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -0.5F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.6981317F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -0.5F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.6981317F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 1F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, -0.0872665F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 1F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, -0.0872665F, 0F, -0.1745329F);
		hair1 = new RendererModel(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 1F);
		hair1.setTextureSize(128, 64);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new RendererModel(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 1F);
		hair2.setTextureSize(128, 64);
		setRotation(hair2, 0F, 0F, 0F);
		RendererModel finright = new RendererModel(this, 36, 36);
		finright.addBox(-4F, -6F, -1F, 0, 5, 5);
		finright.setRotationPoint(0F, 1F, 1F);
		finright.setTextureSize(128, 64);
		setRotation(finright, 0F, -0.5235988F, 0F);
		RendererModel finleft = new RendererModel(this, 36, 36);
		finleft.addBox(4F, -6F, -1F, 0, 5, 5);
		finleft.setRotationPoint(0F, 1F, 1F);
		finleft.setTextureSize(128, 64);
		setRotation(finleft, 0F, 0.5235988F, 0F);
		RendererModel hairclip = new RendererModel(this, 36, 37);
		hairclip.addBox(-1.5F, -6F, 3.5F, 3, 3, 1);
		hairclip.setRotationPoint(0F, 1F, 1F);
		hairclip.setTextureSize(128, 64);
		setRotation(hairclip, 0F, 0F, 0F);
		RendererModel rightpauldron = new RendererModel(this, 68, 0);
		rightpauldron.addBox(-3F, -2F, -2F, 4, 3, 4);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 1F);
		rightpauldron.setTextureSize(128, 64);
		setRotation(rightpauldron, -0.0872665F, 0F, -0.3490659F);
		RendererModel headhelmet = new RendererModel(this, 36, 46);
		headhelmet.addBox(-4F, -8.5F, -6.5F, 8, 8, 8);
		headhelmet.setRotationPoint(0F, 1F, 1F);
		headhelmet.setTextureSize(128, 64);
		setRotation(headhelmet, -0.5235988F, 0F, 0F);
		RendererModel leftpauldron = new RendererModel(this, 84, 0);
		leftpauldron.addBox(-1F, -2F, -2F, 4, 3, 4);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 1F);
		leftpauldron.setTextureSize(128, 64);
		setRotation(leftpauldron, -0.0872665F, 0F, 0.3490659F);
		waist = new RendererModel(this, 68, 7);
		waist.addBox(-4F, 8F, -3F, 8, 8, 5);
		waist.setRotationPoint(0F, 1F, 1F);
		waist.setTextureSize(128, 64);
		setRotation(waist, 0F, 0F, 0F);
		fin1 = new RendererModel(this, 100, 0);
		fin1.addBox(-3.5F, -1F, -2F, 7, 4, 4);
		fin1.setRotationPoint(0F, 11F, 0.5F);
		fin1.setTextureSize(128, 64);
		setRotation(fin1, 0F, 0F, 0F);
		fin2 = new RendererModel(this, 100, 8);
		fin2.addBox(-3F, 0F, 0F, 6, 4, 4);
		fin2.setRotationPoint(0F, 14F, -1.5F);
		fin2.setTextureSize(128, 64);
		setRotation(fin2, 0F, 0F, 0F);
		fin2right = new RendererModel(this, 120, 5);
		fin2right.addBox(0F, 0F, -1.5F, 0, 3, 3);
		fin2right.setRotationPoint(-3F, 16F, 0.5F);
		fin2right.setTextureSize(128, 64);
		setRotation(fin2right, 0F, 0F, 0.7853982F);
		fin2left = new RendererModel(this, 120, 5);
		fin2left.addBox(0F, 0F, -1.5F, 0, 3, 3);
		fin2left.setRotationPoint(3F, 16F, 0.5F);
		fin2left.setTextureSize(128, 64);
		setRotation(fin2left, 0F, 0F, -0.7853982F);
		fin3 = new RendererModel(this, 100, 16);
		fin3.addBox(-2.5F, 0F, 0F, 5, 4, 4);
		fin3.setRotationPoint(0F, 18F, -1.5F);
		fin3.setTextureSize(128, 64);
		setRotation(fin3, 0F, 0F, 0F);
		fin4 = new RendererModel(this, 100, 24);
		fin4.addBox(-2F, 0F, 0.5F, 4, 4, 3);
		fin4.setRotationPoint(0F, 22F, -1.5F);
		fin4.setTextureSize(128, 64);
		setRotation(fin4, 0F, 0F, 0F);
		fin5 = new RendererModel(this, 100, 31);
		fin5.addBox(-1.5F, 0F, 0F, 3, 3, 3);
		fin5.setRotationPoint(0F, 26F, -1F);
		fin5.setTextureSize(128, 64);
		setRotation(fin5, 0F, 0F, 0F);
		fin6 = new RendererModel(this, 100, 37);
		fin6.addBox(-1F, 0F, 0.5F, 2, 2, 2);
		fin6.setRotationPoint(0F, 29F, -1F);
		fin6.setTextureSize(128, 64);
		setRotation(fin6, 0F, 0F, 0F);
		fintail = new RendererModel(this, 100, 41);
		fintail.addBox(-3.5F, -1F, 0F, 7, 7, 0);
		fintail.setRotationPoint(0F, 31F, 0.5F);
		fintail.setTextureSize(128, 64);
		setRotation(fintail, 0F, 0F, 0F);

		convertToChild(head, finright);
		convertToChild(head, finleft);
		convertToChild(head, hairclip);
		convertToChild(head, headhelmet);
		convertToChild(rightarm, rightpauldron);
		convertToChild(leftarm, leftpauldron);
		
		convertToChild(fin6, fintail);
		convertToChild(fin5, fin6);
		convertToChild(fin4, fin5);
		convertToChild(fin3, fin4);
		convertToChild(fin2, fin2right);
		convertToChild(fin2, fin2left);
		convertToChild(fin2, fin3);
		convertToChild(fin1, fin2);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
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
		hair1.render(scale);
		hair2.render(scale);
		waist.render(scale);
		fin1.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		hair1.rotateAngleY = head.rotateAngleY;
		hair2.rotateAngleY = head.rotateAngleY;

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

		// legs
		fin1.rotateAngleX = -0.1308997F;
		fin2.rotateAngleX = +0.3926991F;
		fin3.rotateAngleX = +0.3926991F;
		fin4.rotateAngleX = +0.785398F;
		fintail.rotateAngleX = +0.3926991F;
		
		updateDistanceMovedTotal(entityIn);
		int cycleIndex = (int) ((getDistanceMovedTotal() * CYCLES_PER_BLOCK) % undulationCycle.length);

		fin1.rotateAngleZ = degToRad(undulationCycle[cycleIndex][0]);
		fin2.rotateAngleZ = degToRad(undulationCycle[cycleIndex][1]);
		fin3.rotateAngleZ = degToRad(undulationCycle[cycleIndex][2]);
		fin4.rotateAngleZ = degToRad(undulationCycle[cycleIndex][3]);
		fin5.rotateAngleZ = degToRad(undulationCycle[cycleIndex][4]);
		fin6.rotateAngleZ = degToRad(undulationCycle[cycleIndex][5]);
		fintail.rotateAngleZ = degToRad(undulationCycle[cycleIndex][6]);
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

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
