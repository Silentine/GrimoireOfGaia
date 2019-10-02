package gaia.client.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaAnt<T extends MobEntity> extends ModelGaia<T> {
	// fields
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
	private RendererModel rightleg;
	private RendererModel leftleg;
	private RendererModel rightarm2;
	private RendererModel leftarm2;
	private RendererModel thorax1;

	private static final float SCALE_AMOUNT_HEAD = 0.75F;
	private static final float SCALE_AMOUNT_BODY = 0.5F;
	private static final float Y_OFFSET_HEAD = 15.5F;
	private static final float Y_OFFSET_BODY = 23.5F;

	public ModelGaiaAnt() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, -2.5F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new RendererModel(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, -2.5F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, -2.466667F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new RendererModel(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, -2.5F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new RendererModel(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, -2.5F);
		setRotation(bodytop, 0.1745329F, 0F, 0F);
		bodymiddle = new RendererModel(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -2.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, -4F);
		setRotation(bodymiddle, 0.6108652F, 0F, 0F);
		bodymiddlebutton = new RendererModel(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -2.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, -4F);
		setRotation(bodymiddlebutton, 0.6108652F, 0F, 0F);
		bodybottom = new RendererModel(this, 0, 30);
		bodybottom.addBox(-3F, 6.5F, -6F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, -4F);
		setRotation(bodybottom, 1.047198F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -3.6F);
		setRotation(rightchest, 0.9599311F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -3.6F);
		setRotation(leftchest, 0.9599311F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		getRightArm().addBox(-2F, -1F, -1F, 2, 10, 2);
		getRightArm().setRotationPoint(-2.5F, 2.5F, -2.5F);
		setRotation(getRightArm(), 0F, 0F, 0.2617994F);
		leftarm = new RendererModel(this, 16, 12);
		getLeftArm().mirror = true;
		getLeftArm().addBox(0F, -1F, -1F, 2, 10, 2);
		getLeftArm().setRotationPoint(2.5F, 2.5F, -2.5F);
		setRotation(getLeftArm(), 0F, 0F, -0.2617994F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1F, -1F, -1F, 2, 7, 2);
		rightleg.setRotationPoint(-3F, 10F, 0F);
		setRotation(rightleg, -0.2617994F, 0F, -0.1745329F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1F, -1F, -1F, 2, 7, 2);
		leftleg.setRotationPoint(3F, 10F, 0F);
		setRotation(leftleg, -0.2617994F, 0F, 0.1745329F);
		RendererModel hairahoge = new RendererModel(this, 36, 14);
		hairahoge.addBox(0.7F, -10F, -4.7F, 4, 4, 4);
		hairahoge.setRotationPoint(0F, 1F, -2.5F);
		setRotation(hairahoge, 0F, 0.7853982F, 0F);
		RendererModel headrighthair1 = new RendererModel(this, 36, 22);
		headrighthair1.addBox(-4F, -7F, 2F, 2, 2, 2);
		headrighthair1.setRotationPoint(0F, 1F, -2.5F);
		setRotation(headrighthair1, 0F, 0F, 0F);
		RendererModel headlefthair1 = new RendererModel(this, 36, 22);
		headlefthair1.mirror = true;
		headlefthair1.addBox(2F, -7F, 2F, 2, 2, 2);
		headlefthair1.setRotationPoint(0F, 1F, -2.466667F);
		setRotation(headlefthair1, 0F, 0F, 0F);
		RendererModel headrighthair2 = new RendererModel(this, 36, 26);
		headrighthair2.addBox(-5F, -6F, 3F, 2, 4, 2);
		headrighthair2.setRotationPoint(0F, 1F, -2.5F);
		setRotation(headrighthair2, 0F, 0F, 0F);
		RendererModel headlefthair2 = new RendererModel(this, 36, 26);
		headlefthair2.mirror = true;
		headlefthair2.addBox(3F, -6F, 3F, 2, 4, 2);
		headlefthair2.setRotationPoint(0F, 1F, -2.466667F);
		setRotation(headlefthair2, 0F, 0F, 0F);
		RendererModel headrighthair3 = new RendererModel(this, 36, 32);
		headrighthair3.addBox(-4F, -3F, 2F, 2, 2, 2);
		headrighthair3.setRotationPoint(0F, 1F, -2.5F);
		setRotation(headrighthair3, 0F, 0F, 0F);
		RendererModel headlefthair3 = new RendererModel(this, 36, 32);
		headlefthair3.mirror = true;
		headlefthair3.addBox(2F, -3F, 2F, 2, 2, 2);
		headlefthair3.setRotationPoint(0F, 1F, -2.466667F);
		setRotation(headlefthair3, 0F, 0F, 0F);
		RendererModel rightarmlower = new RendererModel(this, 64, 0);
		rightarmlower.addBox(-5F, 3F, -1.5F, 2, 6, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, -2.5F);
		setRotation(rightarmlower, 0F, 0F, -0.0872665F);
		RendererModel leftarmlower = new RendererModel(this, 64, 0);
		leftarmlower.addBox(3F, 3F, -1.5F, 2, 6, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, -2.5F);
		setRotation(leftarmlower, 0F, 0F, 0.0872665F);
		RendererModel rightarmhand = new RendererModel(this, 64, 9);
		rightarmhand.addBox(-1F, 8F, -2F, 2, 2, 2);
		rightarmhand.setRotationPoint(-2.5F, 2.5F, -2.5F);
		setRotation(rightarmhand, 0F, 0F, 0.2617994F);
		RendererModel leftarmhand = new RendererModel(this, 64, 9);
		leftarmhand.mirror = true;
		leftarmhand.addBox(-1F, 8F, -2F, 2, 2, 2);
		leftarmhand.setRotationPoint(2.5F, 2.5F, -2.5F);
		setRotation(leftarmhand, 0F, 0F, -0.2617994F);
		rightarm2 = new RendererModel(this, 64, 13);
		rightarm2.addBox(-0.5F, -1F, -0.5F, 1, 3, 1);
		rightarm2.setRotationPoint(-2.5F, 6F, -2F);
		setRotation(rightarm2, 0.1745329F, -0.2617994F, 0.2617994F);
		leftarm2 = new RendererModel(this, 64, 13);
		leftarm2.mirror = true;
		leftarm2.addBox(-0.5F, -1F, -0.5F, 1, 3, 1);
		leftarm2.setRotationPoint(2.5F, 6F, -2F);
		setRotation(leftarm2, 0.1745329F, 0.2617994F, -0.2617994F);
		RendererModel rightarm2lower = new RendererModel(this, 64, 17);
		rightarm2lower.addBox(-0.5F, 0F, 1.5F, 1, 3, 1);
		rightarm2lower.setRotationPoint(-2.5F, 6F, -2F);
		setRotation(rightarm2lower, -1.396263F, -0.2617994F, 0.2617994F);
		RendererModel leftarm2lower = new RendererModel(this, 64, 17);
		leftarm2lower.mirror = true;
		leftarm2lower.addBox(-0.5F, 0F, 1.5F, 1, 3, 1);
		leftarm2lower.setRotationPoint(2.5F, 6F, -2F);
		setRotation(leftarm2lower, -1.396263F, 0.2617994F, -0.2617994F);
		thorax1 = new RendererModel(this, 64, 21);
		thorax1.addBox(-1.5F, 8.5F, -5F, 3, 1, 3);
		thorax1.setRotationPoint(0F, 1F, -4F);
		setRotation(thorax1, 1.047198F, 0F, 0F);
		RendererModel thorax2 = new RendererModel(this, 64, 25);
		thorax2.addBox(-2F, 9.5F, -5.5F, 4, 5, 4);
		thorax2.setRotationPoint(0F, 1F, -4F);
		setRotation(thorax2, 1.047198F, 0F, 0F);
		RendererModel thorax3 = new RendererModel(this, 64, 34);
		thorax3.addBox(-1F, 13.5F, -6.5F, 2, 2, 2);
		thorax3.setRotationPoint(0F, 1F, -4F);
		setRotation(thorax3, 1.047198F, 0F, 0F);
		RendererModel rightlegknee = new RendererModel(this, 80, 0);
		rightlegknee.addBox(-0.5F, 0F, -7F, 2, 3, 2);
		rightlegknee.setRotationPoint(-3F, 10F, 0F);
		setRotation(rightlegknee, 1.308997F, 0F, -0.0872665F);
		RendererModel leftlegknee = new RendererModel(this, 80, 0);
		leftlegknee.mirror = true;
		leftlegknee.addBox(-1.5F, 0F, -7F, 2, 3, 2);
		leftlegknee.setRotationPoint(3F, 10F, 0F);
		setRotation(leftlegknee, 1.308997F, 0F, 0.0872665F);
		RendererModel rightleglower = new RendererModel(this, 80, 5);
		rightleglower.addBox(1F, 5.5F, 2F, 2, 7, 2);
		rightleglower.setRotationPoint(-3F, 10F, 0F);
		setRotation(rightleglower, -0.2617994F, 0F, 0.1745329F);
		RendererModel leftleglower = new RendererModel(this, 80, 5);
		leftleglower.mirror = true;
		leftleglower.addBox(-3F, 5.5F, 2F, 2, 7, 2);
		leftleglower.setRotationPoint(3F, 10F, 0F);
		setRotation(leftleglower, -0.2617994F, 0F, -0.1745329F);
		RendererModel rightlegfoot = new RendererModel(this, 80, 14);
		rightlegfoot.addBox(-0.5F, 12F, -2F, 2, 2, 2);
		rightlegfoot.setRotationPoint(-3F, 10F, 0F);
		setRotation(rightlegfoot, 0F, 0F, 0F);
		RendererModel leftlegfoot = new RendererModel(this, 80, 14);
		leftlegfoot.mirror = true;
		leftlegfoot.addBox(-1.5F, 12F, -2F, 2, 2, 2);
		leftlegfoot.setRotationPoint(3F, 10F, 0F);
		setRotation(leftlegfoot, 0F, 0F, 0F);

		convertToChild(head, hairahoge);
		convertToChild(head, headrighthair1);
		convertToChild(head, headlefthair1);
		convertToChild(head, headrighthair2);
		convertToChild(head, headlefthair2);
		convertToChild(head, headrighthair3);
		convertToChild(head, headlefthair3);
		convertToChild(getRightArm(), rightarmlower);
		convertToChild(getLeftArm(), leftarmlower);
		convertToChild(getRightArm(), rightarmhand);
		convertToChild(getLeftArm(), leftarmhand);
		convertToChild(rightarm2, rightarm2lower);
		convertToChild(leftarm2, leftarm2lower);
		convertToChild(thorax1, thorax2);
		convertToChild(thorax1, thorax3);
		convertToChild(rightleg, rightlegknee);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightlegfoot);
		convertToChild(leftleg, leftlegknee);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftlegfoot);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		if (!entityIn.isChild()) {
			head.render(scale);
			headeyes.render(scale);
			headaccessory.render(scale);
			neck.render(scale);
			bodytop.render(scale);
			bodymiddle.render(scale);
			bodymiddlebutton.render(scale);
			bodybottom.render(scale);
			rightchest.render(scale);
			leftchest.render(scale);
			getRightArm().render(scale);
			getLeftArm().render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			rightarm2.render(scale);
			leftarm2.render(scale);
			thorax1.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}
		} else {
			/** SCALING **/
			GlStateManager.pushMatrix();
			GlStateManager.scalef(SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD);
			GlStateManager.translatef(0.0F, Y_OFFSET_HEAD * scale, 0.0F);
			head.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}

			headaccessory.render(scale);
			GlStateManager.popMatrix();
			/** SCALING **/
			GlStateManager.pushMatrix();
			GlStateManager.scalef(SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY);
			GlStateManager.translatef(0.0F, Y_OFFSET_BODY * scale, 0.0F);
			neck.render(scale);
			bodytop.render(scale);
			bodymiddle.render(scale);
			bodymiddlebutton.render(scale);
			bodybottom.render(scale);
			getRightArm().render(scale);
			getLeftArm().render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			rightarm2.render(scale);
			leftarm2.render(scale);
			thorax1.render(scale);
			GlStateManager.popMatrix();
			/** SCALING **/
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

		// arms
		getRightArm().rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		getLeftArm().rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		getRightArm().rotateAngleZ = 0.0F;
		getLeftArm().rotateAngleZ = 0.0F;

		ItemStack itemstack = ((MobEntity) entityIn).getHeldItemMainhand();

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		getRightArm().rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		getRightArm().rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		getLeftArm().rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		getLeftArm().rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		float thoraxDefaultAngleX = 1.047198F;

		thorax1.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		thorax1.rotateAngleX += thoraxDefaultAngleX;

		// legs (walk_normal)
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
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

		getRightArm().rotateAngleX = (float) ((double) getRightArm().rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		getRightArm().rotateAngleX += (bodytop.rotateAngleY * 2.0F);
		getRightArm().rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public RendererModel getRightArm() {
		return rightarm;
	}

	public RendererModel getLeftArm() {
		return leftarm;
	}
}
