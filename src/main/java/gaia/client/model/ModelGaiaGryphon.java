package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaGryphon<T extends MobEntity> extends ModelGaia<T> {
	private RendererModel head;
	private RendererModel neck1;
	private RendererModel neck2;
	private RendererModel rightwing;
	private RendererModel leftwing;
	private RendererModel body1;
	private RendererModel body2;
	private RendererModel frontrightleg1;
	private RendererModel frontleftleg1;
	private RendererModel backrightleg1;
	private RendererModel backleftleg1;
	private RendererModel tail1;
	private RendererModel tail2;
	private RendererModel tail3;

	public ModelGaiaGryphon() {
		textureWidth = 128;
		textureHeight = 64;

		head = new RendererModel(this, 0, 0);
		head.addBox(-2.5F, -11.5F, -4.5F, 5, 5, 6);
		head.setRotationPoint(0F, 8F, -7F);
		setRotation(head, 0.1745329F, 0F, 0F);
		RendererModel headbrow = new RendererModel(this, 0, 11);
		headbrow.addBox(-2.5F, -10.5F, -5.5F, 5, 1, 1);
		headbrow.setRotationPoint(0F, 8F, -7F);
		setRotation(headbrow, 0.1745329F, 0F, 0F);
		RendererModel beak1 = new RendererModel(this, 0, 13);
		beak1.addBox(-1.5F, -9.5F, -8.5F, 3, 3, 4);
		beak1.setRotationPoint(0F, 8F, -7F);
		setRotation(beak1, 0.1745329F, 0F, 0F);
		RendererModel beak2 = new RendererModel(this, 0, 20);
		beak2.addBox(-1F, -9F, -9F, 2, 3, 1);
		beak2.setRotationPoint(0F, 8F, -7F);
		setRotation(beak2, 0.1745329F, 0F, 0F);
		RendererModel rightheadear = new RendererModel(this, 0, 24);
		rightheadear.addBox(-3F, -12F, -0.5F, 2, 2, 6);
		rightheadear.setRotationPoint(0F, 8F, -7F);
		setRotation(rightheadear, 0.1745329F, 0F, 0F);
		RendererModel leftheadear = new RendererModel(this, 0, 24);
		leftheadear.mirror = true;
		leftheadear.addBox(1F, -12F, -0.5F, 2, 2, 6);
		leftheadear.setRotationPoint(0F, 8F, -7F);
		setRotation(leftheadear, 0.1745329F, 0F, 0F);
		neck1 = new RendererModel(this, 28, 0);
		neck1.addBox(-3F, -7F, -5.5F, 6, 6, 6);
		neck1.setRotationPoint(0F, 8F, -7F);
		setRotation(neck1, -0.2268928F, 0F, 0F);
		neck2 = new RendererModel(this, 28, 12);
		neck2.addBox(-3.5F, -4.5F, -4F, 7, 8, 7);
		neck2.setRotationPoint(0F, 8F, -7F);
		setRotation(neck2, 0.5235988F, 0F, 0F);
		rightwing = new RendererModel(this, 108, 38);
		rightwing.addBox(0F, 0F, 0F, 0, 16, 10);
		rightwing.setRotationPoint(-4F, 7F, -6F);
		setRotation(rightwing, 1.047198F, -0.1745329F, 0.2617994F);
		leftwing = new RendererModel(this, 108, 38);
		leftwing.mirror = true;
		leftwing.addBox(0F, 0F, 0F, 0, 16, 10);
		leftwing.setRotationPoint(4F, 7F, -6F);
		setRotation(leftwing, 1.047198F, 0.1745329F, -0.2617994F);
		body1 = new RendererModel(this, 56, 0);
		body1.addBox(-4F, -4F, -8F, 8, 9, 10);
		body1.setRotationPoint(0F, 8F, -3F);
		setRotation(body1, 1.22173F, 0F, 0F);
		body2 = new RendererModel(this, 56, 19);
		body2.addBox(-3F, 1F, -8F, 6, 12, 8);
		body2.setRotationPoint(0F, 8F, -3F);
		setRotation(body2, 1.658063F, 0F, 0F);
		frontrightleg1 = new RendererModel(this, 92, 0);
		frontrightleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		frontrightleg1.setRotationPoint(-4F, 9F, -6F);
		setRotation(frontrightleg1, 0.1745329F, 0F, -0.0349066F);
		RendererModel frontrightleg2 = new RendererModel(this, 92, 11);
		frontrightleg2.addBox(-1F, 6F, 2F, 2, 8, 3);
		frontrightleg2.setRotationPoint(-4F, 9F, -6F);
		setRotation(frontrightleg2, -0.1745329F, 0F, -0.0349066F);
		RendererModel frontrightclaw = new RendererModel(this, 92, 22);
		frontrightclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
		frontrightclaw.setRotationPoint(-4F, 9F, -6F);
		setRotation(frontrightclaw, 0.0872665F, 0F, -0.0349066F);
		frontleftleg1 = new RendererModel(this, 92, 0);
		frontleftleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		frontleftleg1.setRotationPoint(4F, 9F, -6F);
		setRotation(frontleftleg1, 0.1745329F, 0F, 0.0349066F);
		RendererModel frontleftleg2 = new RendererModel(this, 92, 11);
		frontleftleg2.addBox(-1F, 6F, 2F, 2, 8, 3);
		frontleftleg2.setRotationPoint(4F, 9F, -6F);
		setRotation(frontleftleg2, -0.1745329F, 0F, 0.0349066F);
		RendererModel frontleftclaw = new RendererModel(this, 92, 22);
		frontleftclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
		frontleftclaw.setRotationPoint(4F, 9F, -6F);
		setRotation(frontleftclaw, 0.0872665F, 0F, 0.0349066F);
		backrightleg1 = new RendererModel(this, 108, 0);
		backrightleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		backrightleg1.setRotationPoint(-3F, 8F, 9F);
		setRotation(backrightleg1, -0.296706F, 0F, -0.0349066F);
		RendererModel backrightleg2 = new RendererModel(this, 108, 14);
		backrightleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		backrightleg2.setRotationPoint(-3F, 8F, 9F);
		setRotation(backrightleg2, -0.8726646F, 0F, -0.0349066F);
		RendererModel backrightleg3 = new RendererModel(this, 108, 23);
		backrightleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		backrightleg3.setRotationPoint(-3F, 8F, 9F);
		setRotation(backrightleg3, -0.2617994F, 0F, -0.0349066F);
		RendererModel backrightfoot = new RendererModel(this, 108, 32);
		backrightfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		backrightfoot.setRotationPoint(-3F, 8F, 9F);
		setRotation(backrightfoot, 0.0872665F, 0F, -0.0349066F);
		backleftleg1 = new RendererModel(this, 108, 0);
		backleftleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		backleftleg1.setRotationPoint(3F, 8F, 9F);
		setRotation(backleftleg1, -0.296706F, 0F, 0.0349066F);
		RendererModel backleftleg2 = new RendererModel(this, 108, 14);
		backleftleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		backleftleg2.setRotationPoint(3F, 8F, 9F);
		setRotation(backleftleg2, -0.8726646F, 0F, 0.0349066F);
		RendererModel backleftleg3 = new RendererModel(this, 108, 23);
		backleftleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		backleftleg3.setRotationPoint(3F, 8F, 9F);
		setRotation(backleftleg3, -0.2617994F, 0F, 0.0349066F);
		RendererModel backleftfoot = new RendererModel(this, 108, 32);
		backleftfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		backleftfoot.setRotationPoint(3F, 8F, 9F);
		setRotation(backleftfoot, 0.0872665F, 0F, 0.0349066F);
		tail1 = new RendererModel(this, 56, 39);
		tail1.addBox(-1F, -1F, 0F, 2, 2, 6);
		tail1.setRotationPoint(0F, 8F, 10F);
		setRotation(tail1, 0F, 0F, 0F);
		tail2 = new RendererModel(this, 56, 47);
		tail2.addBox(-0.5F, -0.5F, 0F, 1, 1, 6);
		tail2.setRotationPoint(0F, 8F, 16F);
		setRotation(tail2, 0F, 0F, 0F);
		tail3 = new RendererModel(this, 56, 54);
		tail3.addBox(-1F, -1F, 0F, 2, 2, 3);
		tail3.setRotationPoint(0F, 8F, 22F);
		setRotation(tail3, 0F, 0F, 0F);

		convertToChild(head, headbrow);
		convertToChild(head, beak1);
		convertToChild(head, beak2);
		convertToChild(head, rightheadear);
		convertToChild(head, leftheadear);
		convertToChild(frontrightleg1, frontrightleg2);
		convertToChild(frontrightleg1, frontrightclaw);
		convertToChild(frontleftleg1, frontleftleg2);
		convertToChild(frontleftleg1, frontleftclaw);

		convertToChild(backrightleg1, backrightleg2);
		convertToChild(backrightleg1, backrightleg3);
		convertToChild(backrightleg1, backrightfoot);
		convertToChild(backleftleg1, backleftleg2);
		convertToChild(backleftleg1, backleftleg3);
		convertToChild(backleftleg1, backleftfoot);
		
		convertToChild(tail2, tail3);
		convertToChild(tail1, tail2);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		neck1.render(scale);
		neck2.render(scale);
		rightwing.render(scale);
		leftwing.render(scale);
		body1.render(scale);
		body2.render(scale);
		frontrightleg1.render(scale);
		frontleftleg1.render(scale);
		backrightleg1.render(scale);
		backleftleg1.render(scale);
		tail1.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		neck1.rotateAngleY = head.rotateAngleY;
		neck2.rotateAngleY = head.rotateAngleY;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		// arms
		frontrightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		frontleftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		frontrightleg1.rotateAngleX = frontrightleg1.rotateAngleX + 0.1745329F;
		frontleftleg1.rotateAngleX = frontleftleg1.rotateAngleX + 0.1745329F;

		// body
		rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.rotateAngleY = rightwing.rotateAngleY - 0.1745329F;
		leftwing.rotateAngleY = leftwing.rotateAngleY + 0.1745329F;
		
		tail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(5);
		tail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(7);
		
		tail1.rotateAngleX = -degToRad(60);
		tail2.rotateAngleX = +degToRad(30);
		tail3.rotateAngleX = +degToRad(30);

		// legs
		backrightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		backleftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		backrightleg1.rotateAngleX = backrightleg1.rotateAngleX - 0.296706F;
		backleftleg1.rotateAngleX = backleftleg1.rotateAngleX - 0.296706F;
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

		head.rotateAngleX -= (float) ((double) head.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
	}
}
