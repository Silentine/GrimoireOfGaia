package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaVampire extends ModelGaia {
	private ModelRenderer anchor;

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
	private ModelRenderer mantle;
	private ModelRenderer cloak1;
	private ModelRenderer cloak2;
	private ModelRenderer cloak3;
	private ModelRenderer cloak4;
	private ModelRenderer rightshoulder;
	private ModelRenderer leftshoulder;
	private ModelRenderer waist;
	private ModelRenderer waist1;
	private ModelRenderer waist2;
	private ModelRenderer waist3;
	private ModelRenderer waist4;

	public ModelGaiaVampire() {
		textureWidth = 128;
		textureHeight = 64;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -12F, 0F);
		setRotation(anchor, 0F, 0F, 0F);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -8F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, -8F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -8F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, -8F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, -8F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, -8F, 0F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, -8F, 0F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, -8F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -6F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -6F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, -6.5F, 0F);
		setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, -6.5F, 0F);
		setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 2F, 0F);
		setRotation(rightleg, 0.0872665F, 0F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 2F, 0F);
		setRotation(leftleg, -0.0872665F, 0F, 0.0349066F);
		mantle = new ModelRenderer(this, 36, 14);
		mantle.addBox(-5F, -6F, -2F, 10, 7, 6);
		mantle.setRotationPoint(0F, -8F, 0F);
		setRotation(mantle, 0F, 0F, 0F);
		cloak1 = new ModelRenderer(this, 36, 27);
		cloak1.addBox(-6.5F, 0F, 0F, 13, 4, 3);
		cloak1.setRotationPoint(0F, -7F, 1F);
		setRotation(cloak1, 0F, 0F, 0F);
		cloak2 = new ModelRenderer(this, 36, 34);
		cloak2.addBox(-7F, 0F, -4F, 14, 5, 4);
		cloak2.setRotationPoint(0F, -3F, 4F);
		setRotation(cloak2, 0F, 0F, 0F);
		cloak3 = new ModelRenderer(this, 36, 43);
		cloak3.addBox(-7.5F, 0F, -5F, 15, 5, 5);
		cloak3.setRotationPoint(0F, 2F, 4F);
		setRotation(cloak3, 0F, 0F, 0F);
		cloak4 = new ModelRenderer(this, 36, 53);
		cloak4.addBox(-8F, 0F, -6F, 16, 6, 6);
		cloak4.setRotationPoint(0F, 7F, 4F);
		setRotation(cloak4, 0F, 0F, 0F);
		rightshoulder = new ModelRenderer(this, 80, 0);
		rightshoulder.addBox(-2.5F, -1F, -1.5F, 3, 4, 3);
		rightshoulder.setRotationPoint(-2.5F, -6.5F, 0F);
		setRotation(rightshoulder, 0.0872665F, 0F, 0.0872665F);
		leftshoulder = new ModelRenderer(this, 80, 0);
		leftshoulder.mirror = true;
		leftshoulder.addBox(-0.5F, -1F, -1.5F, 3, 4, 3);
		leftshoulder.setRotationPoint(2.5F, -6.5F, 0F);
		setRotation(leftshoulder, 0.0872665F, 0F, -0.0872665F);
		waist = new ModelRenderer(this, 80, 7);
		waist.addBox(-3F, 5F, -2.5F, 6, 2, 5);
		waist.setRotationPoint(0F, -8F, 0F);
		setRotation(waist, 0F, 0F, 0F);
		waist1 = new ModelRenderer(this, 80, 14);
		waist1.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist1.setRotationPoint(0F, -8F, 0F);
		setRotation(waist1, 0.0872665F, 0F, 0F);
		waist2 = new ModelRenderer(this, 80, 22);
		waist2.addBox(-3.5F, 0F, -0.5F, 7, 4, 6);
		waist2.setRotationPoint(0F, -1F, -2.5F);
		setRotation(waist2, 0F, 0F, 0F);
		waist3 = new ModelRenderer(this, 80, 32);
		waist3.addBox(-4F, 0F, -0.5666667F, 8, 4, 7);
		waist3.setRotationPoint(0F, 3F, -3F);
		setRotation(waist3, 0F, 0F, 0F);
		waist4 = new ModelRenderer(this, 80, 43);
		waist4.addBox(-4.5F, 0F, -1F, 9, 6, 8);
		waist4.setRotationPoint(0F, 7F, -3.5F);
		setRotation(waist4, 0F, 0F, 0F);

		convertToChild(rightarm, rightshoulder);
		convertToChild(leftarm, leftshoulder);

		convertToChild(cloak3, cloak4);
		convertToChild(cloak2, cloak3);
		convertToChild(cloak1, cloak2);

		convertToChild(waist3, waist4);
		convertToChild(waist2, waist3);

		anchor.addChild(head);
		anchor.addChild(headeyes);
		anchor.addChild(headaccessory);
		anchor.addChild(neck);
		anchor.addChild(bodytop);
		anchor.addChild(bodymiddle);
		anchor.addChild(bodymiddlebutton);
		anchor.addChild(bodybottom);
		anchor.addChild(rightchest);
		anchor.addChild(leftchest);
		anchor.addChild(rightarm);
		anchor.addChild(leftarm);
		anchor.addChild(rightleg);
		anchor.addChild(leftleg);
		anchor.addChild(mantle);
		anchor.addChild(cloak1);
		anchor.addChild(waist);
		anchor.addChild(waist1);
		anchor.addChild(waist2);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((1.5F + ageInTicks) * 0.5F) * 0.5F;

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		headeyes.showModel = entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F;

		// arms
		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;
		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// body
		cloak1.rotateAngleX = degToRad(5);
		cloak2.rotateAngleX = degToRad(5);
		cloak3.rotateAngleX = degToRad(5);
		cloak4.rotateAngleX = degToRad(5);

		cloak1.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(1);
		cloak2.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		cloak3.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(3);
		cloak4.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);

		waist2.rotateAngleX = degToRad(5);
		waist3.rotateAngleX = degToRad(5);
		waist4.rotateAngleX = degToRad(5);

		waist1.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(1);
		waist2.rotateAngleZ = waist1.rotateAngleZ;
		waist3.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		waist4.rotateAngleZ = waist3.rotateAngleZ;
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
}
