package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaBanshee extends ModelGaia {
	private ModelRenderer anchor;
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymid;
	private ModelRenderer bodymidbutton;
	private ModelRenderer bodybottom;
	private ModelRenderer leftchest;
	private ModelRenderer rightchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightarmlower;
	private ModelRenderer leftarmlower;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer hair3;
	private ModelRenderer hair4;
	private ModelRenderer rightarmsleeve;
	private ModelRenderer leftarmsleeve;
	private ModelRenderer rightarmsleevelower;
	private ModelRenderer leftarmsleevelower;
	private ModelRenderer skirt1;
	private ModelRenderer skirt2;
	private ModelRenderer skirt3;
	private ModelRenderer skirt4;

	public ModelGaiaBanshee() {
		textureWidth = 128;
		textureHeight = 64;

		anchor = new ModelRenderer(this, 0, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -6F, -1F);
		setRotation(anchor, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3.1F, -6F, -3F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, -6F, -2.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 7F, 1F);
		setRotation(bodytop, 0F, 0F, 0F);
		bodymid = new ModelRenderer(this, 0, 25);
		bodymid.addBox(-2F, -2.5F, -2F, 4, 3, 2);
		bodymid.setRotationPoint(0F, 9F, 1F);
		setRotation(bodymid, 0F, 0F, 0F);
		bodymidbutton = new ModelRenderer(this, 0, 25);
		bodymidbutton.addBox(-0.5F, -2F, -2.1F, 1, 2, 0);
		bodymidbutton.setRotationPoint(0F, 9F, 1F);
		setRotation(bodymidbutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, -3F, -1.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 12F, 0F);
		setRotation(bodybottom, 0F, 0F, 0F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightarmlower = new ModelRenderer(this, 16, 20);
		rightarmlower.addBox(-1F, 0F, -2F, 2, 6, 2);
		rightarmlower.setRotationPoint(-3.5F, 7.5F, 1F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new ModelRenderer(this, 16, 20);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-1F, 0F, -2F, 2, 6, 2);
		leftarmlower.setRotationPoint(3.5F, 7.5F, 1F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0.5F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0.5F);
		setRotation(leftleg, 0F, 0F, 0F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -3.5F, 0F, 8, 7, 2);
		hair1.setRotationPoint(0F, -2F, 2F);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 23);
		hair2.addBox(-5F, -5F, 0F, 10, 10, 4);
		hair2.setRotationPoint(0F, -2F, 4F);
		setRotation(hair2, 0F, 0F, 0F);
		hair3 = new ModelRenderer(this, 36, 37);
		hair3.addBox(-6F, -6F, 0F, 12, 12, 6);
		hair3.setRotationPoint(0F, -2F, 8F);
		setRotation(hair3, 0F, 0F, 0F);
		hair4 = new ModelRenderer(this, 6, 41);
		hair4.addBox(-4F, -4F, 0F, 8, 8, 14);
		hair4.setRotationPoint(0F, -2F, 8F);
		setRotation(hair4, 0F, 0F, 0F);
		rightarmsleeve = new ModelRenderer(this, 72, 0);
		rightarmsleeve.addBox(-2.5F, 1F, -1.5F, 3, 4, 3);
		rightarmsleeve.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarmsleeve, 0F, 0F, 0F);
		leftarmsleeve = new ModelRenderer(this, 72, 0);
		leftarmsleeve.mirror = true;
		leftarmsleeve.addBox(-0.5F, 1F, -1.5F, 3, 4, 3);
		leftarmsleeve.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarmsleeve, 0F, 0F, 0F);
		rightarmsleevelower = new ModelRenderer(this, 72, 7);
		rightarmsleevelower.addBox(-1.49F, 0F, -3F, 3, 6, 3);
		rightarmsleevelower.setRotationPoint(-3.5F, 7.5F, 1.5F);
		setRotation(rightarmsleevelower, 0F, 0F, 0F);
		leftarmsleevelower = new ModelRenderer(this, 72, 7);
		leftarmsleevelower.mirror = true;
		leftarmsleevelower.addBox(-1.51F, 0F, -3F, 3, 6, 3);
		leftarmsleevelower.setRotationPoint(3.5F, 7.5F, 1.5F);
		setRotation(leftarmsleevelower, 0F, 0F, 0F);
		skirt1 = new ModelRenderer(this, 84, 0);
		skirt1.addBox(-3.5F, 0F, -3F, 7, 2, 6);
		skirt1.setRotationPoint(0F, 10F, 0F);
		setRotation(skirt1, 0F, 0F, 0F);
		skirt2 = new ModelRenderer(this, 84, 8);
		skirt2.addBox(-4F, 0F, -0.5F, 8, 4, 7);
		skirt2.setRotationPoint(0F, 12F, -3F);
		setRotation(skirt2, 0F, 0F, 0F);
		skirt3 = new ModelRenderer(this, 84, 19);
		skirt3.addBox(-4.5F, 0F, -0.5F, 9, 5, 8);
		skirt3.setRotationPoint(0F, 16F, -3.5F);
		setRotation(skirt3, 0F, 0F, 0F);
		skirt4 = new ModelRenderer(this, 84, 32);
		skirt4.addBox(-5F, 0F, -0.5F, 10, 6, 9);
		skirt4.setRotationPoint(0F, 21F, -4F);
		setRotation(skirt4, 0F, 0F, 0F);

		convertToChild(hair3, hair4);
		convertToChild(hair2, hair3);
		convertToChild(hair1, hair2);
		convertToChild(head, hair1);
		convertToChild(rightarmlower, rightarmsleevelower);
		convertToChild(leftarmlower, leftarmsleevelower);
		convertToChild(rightarm, rightarmsleeve);
		convertToChild(leftarm, leftarmsleeve);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(skirt3, skirt4);
		convertToChild(skirt2, skirt3);
		convertToChild(skirt1, skirt2);

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
		anchor.addChild(skirt1);
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
//		anchor.showModel = !(entityIn.ticksExisted % 45 == 0 && limbSwingAmount <= 0.1F);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		headeyes.showModel = entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F;

		hair1.rotateAngleZ = -degToRad(15);
		hair2.rotateAngleZ = -degToRad(15);
		hair3.rotateAngleZ = -degToRad(15);
		hair4.rotateAngleZ += degToRad(2);

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

		rightarmlower.rotateAngleX = -degToRad(15);
		leftarmlower.rotateAngleX = -degToRad(15);

		// body
		skirt1.rotateAngleX = degToRad(5);
		skirt2.rotateAngleX = degToRad(10);
		skirt3.rotateAngleX = degToRad(15);
		skirt4.rotateAngleX = degToRad(20);
		
		skirt1.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(1);
		skirt2.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		skirt3.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(3);
		skirt4.rotateAngleZ = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
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
