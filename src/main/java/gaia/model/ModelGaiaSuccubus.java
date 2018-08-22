package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSuccubus extends ModelGaia {
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
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer tail;
	private ModelRenderer waist;
	private ModelRenderer rightwing;
	private ModelRenderer leftwing;

	public ModelGaiaSuccubus() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 7F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 2F, 0F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		rightleg.setRotationPoint(-2F, 11F, -0.5F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.1745329F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		leftleg.setRotationPoint(2F, 11F, -0.5F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.1745329F, 0F, 0F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(64, 32);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(64, 32);
		setRotation(hair2, 0F, 0F, 0F);
		ModelRenderer righthorn1 = new ModelRenderer(this, 36, 37);
		righthorn1.addBox(-4F, -7F, -2F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, 1F, 0F);
		righthorn1.setTextureSize(64, 32);
		setRotation(righthorn1, 0F, 0F, 0F);
		ModelRenderer righthorn2 = new ModelRenderer(this, 36, 41);
		righthorn2.addBox(-5F, -6F, -4F, 2, 2, 3);
		righthorn2.setRotationPoint(0F, 1F, 0F);
		righthorn2.setTextureSize(64, 32);
		setRotation(righthorn2, 0F, 0F, 0F);
		ModelRenderer righthorn3 = new ModelRenderer(this, 36, 46);
		righthorn3.addBox(-4F, -7F, -5F, 2, 2, 2);
		righthorn3.setRotationPoint(0F, 1F, 0F);
		righthorn3.setTextureSize(64, 32);
		setRotation(righthorn3, 0F, 0F, 0F);
		ModelRenderer righthorn4 = new ModelRenderer(this, 36, 50);
		righthorn4.addBox(-2.5F, -7.5F, -4.5F, 1, 1, 1);
		righthorn4.setRotationPoint(0F, 1F, 0F);
		righthorn4.setTextureSize(64, 32);
		setRotation(righthorn4, 0F, 0F, 0F);
		ModelRenderer lefthorn1 = new ModelRenderer(this, 36, 37);
		lefthorn1.mirror = true;
		lefthorn1.addBox(2F, -7F, -2F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, 1F, 0F);
		lefthorn1.setTextureSize(64, 32);
		setRotation(lefthorn1, 0F, 0F, 0F);
		ModelRenderer lefthorn2 = new ModelRenderer(this, 36, 41);
		lefthorn2.mirror = true;
		lefthorn2.addBox(3F, -6F, -4F, 2, 2, 3);
		lefthorn2.setRotationPoint(0F, 1F, 0F);
		lefthorn2.setTextureSize(64, 32);
		setRotation(lefthorn2, 0F, 0F, 0F);
		ModelRenderer lefthorn3 = new ModelRenderer(this, 36, 46);
		lefthorn3.mirror = true;
		lefthorn3.addBox(2F, -7F, -5F, 2, 2, 2);
		lefthorn3.setRotationPoint(0F, 1F, 0F);
		lefthorn3.setTextureSize(64, 32);
		setRotation(lefthorn3, 0F, 0F, 0F);
		ModelRenderer lefthorn4 = new ModelRenderer(this, 36, 50);
		lefthorn4.mirror = true;
		lefthorn4.addBox(1.5F, -7.5F, -4.5F, 1, 1, 1);
		lefthorn4.setRotationPoint(0F, 1F, 0F);
		lefthorn4.setTextureSize(64, 32);
		setRotation(lefthorn4, 0F, 0F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 64, 0);
		rightpauldron.addBox(-2.5F, -2F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0.0872665F, 0F, 0.1745329F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 76, 0);
		leftpauldron.addBox(-0.5F, -2F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftpauldron.setTextureSize(64, 32);
		setRotation(leftpauldron, 0.0872665F, 0F, -0.1745329F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 64, 6);
		rightarmlower.addBox(-4F, 5F, -1.5F, 2, 6, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0.0872665F, 0F, 0F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 74, 6);
		leftarmlower.addBox(2F, 5F, -1.5F, 2, 6, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0.0872665F, 0F, 0F);
		tail = new ModelRenderer(this, 64, 15);
		tail.addBox(-1F, 0F, 0F, 2, 9, 0);
		tail.setRotationPoint(0F, 9F, 1.5F);
		tail.setTextureSize(64, 32);
		setRotation(tail, 0.3490659F, 0F, 0F);
		waist = new ModelRenderer(this, 64, 24);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 88, 0);
		rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, -0.1745329F, 0F, 0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 88, 0);
		leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		leftleglower.setRotationPoint(2F, 11F, -0.5F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, -0.1745329F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 88, 12);
		rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, 0F, 0F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 88, 12);
		leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		leftfoot.setRotationPoint(2F, 11F, -0.5F);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, 0F, 0F, 0F);
		rightwing = new ModelRenderer(this, 104, 42);
		rightwing.addBox(0F, -1F, 0F, 0, 14, 8);
		rightwing.setRotationPoint(-1.5F, 2F, 2F);
		rightwing.setTextureSize(64, 32);
		setRotation(rightwing, 0.5235988F, -0.7853982F, 0F);
		leftwing = new ModelRenderer(this, 112, 42);
		leftwing.addBox(0F, -1F, 0F, 0, 14, 8);
		leftwing.setRotationPoint(1.5F, 2F, 2F);
		leftwing.setTextureSize(64, 32);
		setRotation(leftwing, 0.5235988F, 0.7853982F, 0F);

		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, righthorn4);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, lefthorn4);
		convertToChild(rightarm, rightpauldron);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftpauldron);
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
		rightleg.render(scale);
		leftleg.render(scale);
		hair1.render(scale);
		hair2.render(scale);
		tail.render(scale);
		waist.render(scale);
		rightwing.render(scale);
		leftwing.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
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

		// body
		rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * 1.0F * limbSwingAmount * 0.5F;
		--rightwing.rotateAngleY;
		++leftwing.rotateAngleY;
		tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		rightchest.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount) + 0.7853982F;
		leftchest.rotateAngleX = rightchest.rotateAngleX;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.1745329F;
		leftleg.rotateAngleX -= 0.1745329F;
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
