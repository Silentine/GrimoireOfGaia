package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBanshee extends ModelGaia {

	private ModelRenderer anchor;
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer bodytop;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer waist1;
	private ModelRenderer waist2;
	private ModelRenderer waist3;
	private ModelRenderer waist4;

	public ModelGaiaBanshee() {
		textureWidth = 128;
		textureHeight = 64;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -6F, -1F);
		anchor.setTextureSize(64, 32);
		setRotation(anchor, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -6F, -1F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, -6F, -1F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -6F, -1F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		ModelRenderer neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, -6F, -1F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, -6F, -1F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, 0F, 0F, 0F);
		ModelRenderer bodymid = new ModelRenderer(this, 0, 25);
		bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymid.setRotationPoint(0F, -6F, -1F);
		bodymid.setTextureSize(64, 32);
		setRotation(bodymid, 0.0872665F, 0F, 0F);
		ModelRenderer bodymidbutton = new ModelRenderer(this, 0, 25);
		bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymidbutton.setRotationPoint(0F, -6F, -1F);
		bodymidbutton.setTextureSize(64, 32);
		setRotation(bodymidbutton, 0.0872665F, 0F, 0F);
		ModelRenderer bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -3F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, -6F, -1F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.2617994F, 0F, 0F);
		ModelRenderer rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -4F, -2.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		ModelRenderer leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -4F, -2.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, -4.5F, -1F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.3490659F, 0F, 0.2617994F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, -4.5F, -1F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.3490659F, 0F, -0.2617994F);
		ModelRenderer rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 4F, 0.5F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0.2617994F, 0F, -0.0349066F);
		ModelRenderer leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 4F, 0.5F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0.1745329F, 0F, 0.0349066F);
		ModelRenderer hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -7.5F, -0.5F, 8, 7, 2);
		hair1.setRotationPoint(0F, -6F, -1F);
		hair1.setTextureSize(64, 32);
		setRotation(hair1, 0.0872665F, 0F, 0F);
		ModelRenderer hair2 = new ModelRenderer(this, 36, 23);
		hair2.addBox(-5F, -8.5F, 1.5F, 10, 10, 4);
		hair2.setRotationPoint(0F, -6F, -1F);
		hair2.setTextureSize(64, 32);
		setRotation(hair2, 0.1745329F, 0F, 0F);
		ModelRenderer hair3 = new ModelRenderer(this, 36, 37);
		hair3.addBox(-6F, -9.5F, 5.5F, 12, 12, 6);
		hair3.setRotationPoint(0F, -6F, -1F);
		hair3.setTextureSize(64, 32);
		setRotation(hair3, 0.1745329F, 0F, 0F);
		ModelRenderer hair4 = new ModelRenderer(this, 6, 41);
		hair4.addBox(-4F, -7.5F, 5.5F, 8, 8, 14);
		hair4.setRotationPoint(0F, -6F, -1F);
		hair4.setTextureSize(64, 32);
		setRotation(hair4, 0.1745329F, 0F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 72, 0);
		rightarmlower.addBox(-2.5F, 1F, -1.5F, 3, 10, 3);
		rightarmlower.setRotationPoint(-2.5F, -4.5F, -1F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0.3490659F, 0F, 0.2617994F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 72, 0);
		leftarmlower.addBox(-0.5F, 1F, -1.5F, 3, 10, 3);
		leftarmlower.setRotationPoint(2.5F, -4.5F, -1F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0.3490659F, 0F, -0.2617994F);
		waist1 = new ModelRenderer(this, 72, 13);
		waist1.addBox(-3.5F, 7.5F, -4F, 7, 2, 6);
		waist1.setRotationPoint(0F, -6F, -1F);
		waist1.setTextureSize(64, 32);
		setRotation(waist1, 0.2617994F, 0F, 0F);
		waist2 = new ModelRenderer(this, 72, 21);
		waist2.addBox(-4F, 9F, -4.5F, 8, 4, 7);
		waist2.setRotationPoint(0F, -6F, -1F);
		waist2.setTextureSize(64, 32);
		setRotation(waist2, 0.2792527F, 0F, 0F);
		waist3 = new ModelRenderer(this, 72, 32);
		waist3.addBox(-4.5F, 12F, -5F, 9, 5, 8);
		waist3.setRotationPoint(0F, -6F, -1F);
		waist3.setTextureSize(64, 32);
		setRotation(waist3, 0.296706F, 0F, 0F);
		waist4 = new ModelRenderer(this, 72, 45);
		waist4.addBox(-5F, 16F, -6F, 10, 6, 9);
		waist4.setRotationPoint(0F, -6F, -1F);
		waist4.setTextureSize(64, 32);
		setRotation(waist4, 0.3403392F, 0F, 0F);

		anchor.addChild(head);
		anchor.addChild(headeyes);
		anchor.addChild(headaccessory);
		anchor.addChild(neck);
		anchor.addChild(bodytop);
		anchor.addChild(bodymid);
		anchor.addChild(bodymidbutton);
		anchor.addChild(bodybottom);
		anchor.addChild(rightchest);
		anchor.addChild(leftchest);
		anchor.addChild(rightarm);
		anchor.addChild(leftarm);
		anchor.addChild(rightleg);
		anchor.addChild(leftleg);
		convertToChild(head, hair1);
		convertToChild(head, hair2);
		convertToChild(head, hair3);
		convertToChild(head, hair4);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		anchor.addChild(waist1);
		anchor.addChild(waist2);
		anchor.addChild(waist3);
		anchor.addChild(waist4);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
		// anchor
		anchor.rotationPointY = (MathHelper.cos((1.5F + ageInTicks) * 0.5F)) * 0.5F;

		anchor.showModel = !(entityIn.ticksExisted % 45 == 0 && limbSwingAmount <= 0.1F);

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
		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleX = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(10);
		leftarm.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(-10);
		rightarm.rotateAngleZ += 0.2617994F;
		leftarm.rotateAngleZ -= 0.2617994F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// body
		waist1.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(1);
		waist2.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		waist3.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(3);
		waist4.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
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
		rightarm.rotateAngleX -= (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX -= (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}
}
