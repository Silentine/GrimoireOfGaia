package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaGelatinousSlime extends ModelGaia {

	private ModelRenderer anchor;

	ModelRenderer head;
	ModelRenderer bodyupper;
	ModelRenderer bodylower;
	ModelRenderer invisiblearm;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightarmlower;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer leftleglower;
	ModelRenderer mainbody1;
	ModelRenderer mainbody2;
	ModelRenderer mainbody2particles;
	ModelRenderer slime1;
	ModelRenderer slime2;
	ModelRenderer slime3;
	ModelRenderer slimesoutheast;
	ModelRenderer slimenortheast;
	ModelRenderer slimenorthwest;
	ModelRenderer slimesouthwest;

	public ModelGaiaGelatinousSlime() {
		textureWidth = 256;
		textureHeight = 128;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint( 0F, 8F, 0F);
		setRotation(anchor, 0F, 0F, 0F);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -7F, -4F, 8, 8, 8);
		head.setRotationPoint(4F, 2F, -4F);
		setRotation(head, 0.0872665F, -0.4363323F, 0F);
		bodyupper = new ModelRenderer(this, 0, 16);
		bodyupper.addBox(-4F, 0F, -2F, 8, 8, 4);
		bodyupper.setRotationPoint(4F, 3F, -4F);
		setRotation(bodyupper, 0.6108652F, 0.3490659F, 0F);
		bodylower = new ModelRenderer(this, 0, 28);
		bodylower.addBox(-4F, 9F, -5.5F, 8, 4, 4);
		bodylower.setRotationPoint(4F, 3F, -4F);
		setRotation(bodylower, 1.047198F, 0.3490659F, 0F);
		invisiblearm = new ModelRenderer(this, 32, 16);
		invisiblearm.addBox(-1F, 0F, -1F, 2, 12, 2);
		invisiblearm.setRotationPoint(-2F, 4F, 8F);
		setRotation(invisiblearm, 0F, 0F, 0.7853982F);
		rightarm = new ModelRenderer(this, 24, 16);
		rightarm.addBox(-1F, 0F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		setRotation(rightarm, 0.4363323F, 0F, 1.047198F);
		leftarm = new ModelRenderer(this, 24, 16);
		leftarm.mirror = true;
		leftarm.addBox(-1F, 0F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(9F, 5F, -3F);
		setRotation(leftarm, 0F, 0F, -0.7853982F);
		rightarmlower = new ModelRenderer(this, 24, 16);
		rightarmlower.addBox(-1F, 0F, 5F, 2, 6, 2);
		rightarmlower.setRotationPoint(-5F, 2F, 0F);
		setRotation(rightarmlower, -1.134464F, 0F, 1.047198F);
		rightleg = new ModelRenderer(this, 24, 16);
		rightleg.addBox(-1F, 0F, -1F, 2, 6, 2);
		rightleg.setRotationPoint(9F, 13F, 4F);
		setRotation(rightleg, 0.7853982F, -0.1745329F, 0F);
		leftleg = new ModelRenderer(this, 24, 16);
		leftleg.mirror = true;
		leftleg.addBox(-1F, 0F, -1F, 2, 6, 2);
		leftleg.setRotationPoint(-4F, 12F, 0F);
		setRotation(leftleg, -0.7853982F, 0.4363323F, 0F);
		leftleglower = new ModelRenderer(this, 24, 16);
		leftleglower.mirror = true;
		leftleglower.addBox(-1F, 4F, -5F, 2, 6, 2);
		leftleglower.setRotationPoint(-4F, 12F, 0F);
		setRotation(leftleglower, 0F, 0.4363323F, 0F);
		mainbody1 = new ModelRenderer(this, 64, 0);
		mainbody1.addBox(-16F, -16F, -16F, 32, 32, 32);
		mainbody1.setRotationPoint(0F, 8F, 0F);
		setRotation(mainbody1, 0F, 0F, 0F);
		mainbody2 = new ModelRenderer(this, 64, 64);
		mainbody2.addBox(-12F, -12F, -12F, 24, 24, 24);
		mainbody2.setRotationPoint(0F, 8F, 0F);
		setRotation(mainbody2, 0F, 0F, 0F);
		mainbody2particles = new ModelRenderer(this, 160, 64);
		mainbody2particles.addBox(-12F, -12F, -12F, 24, 24, 24);
		mainbody2particles.setRotationPoint(0F, 8F, 0F);
		setRotation(mainbody2particles, 0F, 0F, 0F);
		slime1 = new ModelRenderer(this, 64, 0);
		slime1.addBox(-18F, -11F, 4F, 2, 2, 2);
		slime1.setRotationPoint(0F, 8F, 0F);
		setRotation(slime1, 0F, 0F, 0F);
		slime2 = new ModelRenderer(this, 64, 4);
		slime2.addBox(-19F, -8F, -2F, 3, 3, 3);
		slime2.setRotationPoint(0F, 8F, 0F);
		setRotation(slime2, 0F, 0F, 0F);
		slime3 = new ModelRenderer(this, 64, 4);
		slime3.addBox(16F, -3F, -6F, 3, 3, 3);
		slime3.setRotationPoint(0F, 8F, 0F);
		setRotation(slime3, 0F, 0F, 0F);
		slimesoutheast = new ModelRenderer(this, 76, 0);
		slimesoutheast.addBox(-18F, 12F, -18F, 4, 4, 4);
		slimesoutheast.setRotationPoint(0F, 8F, 0F);
		setRotation(slimesoutheast, 0F, 0F, 0F);
		slimenortheast = new ModelRenderer(this, 76, 0);
		slimenortheast.addBox(-18F, 12F, 14F, 4, 4, 4);
		slimenortheast.setRotationPoint(0F, 8F, 0F);
		setRotation(slimenortheast, 0F, 0F, 0F);
		slimenorthwest = new ModelRenderer(this, 76, 0);
		slimenorthwest.addBox(14F, 12F, 14F, 4, 4, 4);
		slimenorthwest.setRotationPoint(0F, 8F, 0F);
		setRotation(slimenorthwest, 0F, 0F, 0F);
		slimesouthwest = new ModelRenderer(this, 76, 0);
		slimesouthwest.addBox(14F, 12F, -18F, 4, 4, 4);
		slimesouthwest.setRotationPoint(0F, 8F, 0F);
		setRotation(slimesouthwest, 0F, 0F, 0F);

		anchor.addChild(bodyupper);
		anchor.addChild(head);
		anchor.addChild(bodylower);
		anchor.addChild(leftarm);
		anchor.addChild(rightleg);
		anchor.addChild(mainbody2particles);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftleg, leftleglower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);

//	    head.render(scale);
//	    bodyupper.render(scale);
//	    bodylower.render(scale);
		invisiblearm.render(scale);
		rightarm.render(scale);
//	    leftarm.render(scale);
//	    rightarmlower.render(scale);
//	    rightleg.render(scale);
		leftleg.render(scale);
//	    leftleglower.render(scale);
		mainbody1.render(scale);
		mainbody2.render(scale);
//	    mainbody2particles.render(scale);
		slime1.render(scale);
		slime2.render(scale);
		slime3.render(scale);
	    slimesoutheast.render(scale);
	    slimenortheast.render(scale);
	    slimenorthwest.render(scale);
	    slimesouthwest.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float floatSpeed = 0.2F;
		float floatRange = 0.2F;
		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		float rightarmDefaultAngleZ = 1.047198F;

		rightarm.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		rightarm.rotateAngleZ += rightarmDefaultAngleZ;

		// body
		float bodyupperDefaultAngleX = 0.6108652F;

		bodyupper.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		bodyupper.rotateAngleX += bodyupperDefaultAngleX;

		float bodylowerDefaultAngleX = 1.047198F;

		bodylower.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		bodylower.rotateAngleX += bodylowerDefaultAngleX;

		// legs
		float leftlegDefaultAngleX = 0.7853982F;

		leftleg.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		leftleg.rotateAngleX -= leftlegDefaultAngleX;
	}

	public ModelRenderer getRightArm() {
		return leftarm;
	}

	public ModelRenderer getLeftArm() {
		return invisiblearm;
	}
}
