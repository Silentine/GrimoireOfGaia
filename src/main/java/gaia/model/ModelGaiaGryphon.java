package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaGryphon extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer neck1;
	private ModelRenderer neck2;
	private ModelRenderer rightwing;
	private ModelRenderer leftwing;
	private ModelRenderer body1;
	private ModelRenderer body2;
	private ModelRenderer frontrightleg1;
	private ModelRenderer frontleftleg1;
	private ModelRenderer backrightleg1;
	private ModelRenderer backleftleg1;
	private ModelRenderer tail1;
	private ModelRenderer tail2;

	public ModelGaiaGryphon() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.5F, -11.5F, -4.5F, 5, 5, 6);
		head.setRotationPoint(0F, 8F, -7F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.1745329F, 0F, 0F);
		ModelRenderer headbrow = new ModelRenderer(this, 0, 11);
		headbrow.addBox(-2.5F, -10.5F, -5.5F, 5, 1, 1);
		headbrow.setRotationPoint(0F, 8F, -7F);
		headbrow.setTextureSize(64, 32);
		setRotation(headbrow, 0.1745329F, 0F, 0F);
		ModelRenderer beak1 = new ModelRenderer(this, 0, 13);
		beak1.addBox(-1.5F, -9.5F, -8.5F, 3, 3, 4);
		beak1.setRotationPoint(0F, 8F, -7F);
		beak1.setTextureSize(64, 32);
		setRotation(beak1, 0.1745329F, 0F, 0F);
		ModelRenderer beak2 = new ModelRenderer(this, 0, 20);
		beak2.addBox(-1F, -9F, -9F, 2, 3, 1);
		beak2.setRotationPoint(0F, 8F, -7F);
		beak2.setTextureSize(64, 32);
		setRotation(beak2, 0.1745329F, 0F, 0F);
		ModelRenderer rightheadear = new ModelRenderer(this, 0, 24);
		rightheadear.addBox(-3F, -12F, -0.5F, 2, 2, 6);
		rightheadear.setRotationPoint(0F, 8F, -7F);
		rightheadear.setTextureSize(64, 32);
		setRotation(rightheadear, 0.1745329F, 0F, 0F);
		ModelRenderer leftheadear = new ModelRenderer(this, 0, 24);
		leftheadear.mirror = true;
		leftheadear.addBox(1F, -12F, -0.5F, 2, 2, 6);
		leftheadear.setRotationPoint(0F, 8F, -7F);
		leftheadear.setTextureSize(64, 32);
		setRotation(leftheadear, 0.1745329F, 0F, 0F);
		neck1 = new ModelRenderer(this, 28, 0);
		neck1.addBox(-3F, -7F, -5.5F, 6, 6, 6);
		neck1.setRotationPoint(0F, 8F, -7F);
		neck1.setTextureSize(128, 64);
		setRotation(neck1, -0.2268928F, 0F, 0F);
		neck2 = new ModelRenderer(this, 28, 12);
		neck2.addBox(-3.5F, -4.5F, -4F, 7, 8, 7);
		neck2.setRotationPoint(0F, 8F, -7F);
		neck2.setTextureSize(128, 64);
		setRotation(neck2, 0.5235988F, 0F, 0F);
		rightwing = new ModelRenderer(this, 108, 38);
		rightwing.addBox(0F, 0F, 0F, 0, 16, 10);
		rightwing.setRotationPoint(-4F, 7F, -6F);
		rightwing.setTextureSize(128, 64);
		setRotation(rightwing, 1.047198F, -0.1745329F, 0.2617994F);
		leftwing = new ModelRenderer(this, 108, 38);
		leftwing.mirror = true;
		leftwing.addBox(0F, 0F, 0F, 0, 16, 10);
		leftwing.setRotationPoint(4F, 7F, -6F);
		leftwing.setTextureSize(128, 64);
		setRotation(leftwing, 1.047198F, 0.1745329F, -0.2617994F);
		body1 = new ModelRenderer(this, 56, 0);
		body1.addBox(-4F, -4F, -8F, 8, 9, 10);
		body1.setRotationPoint(0F, 8F, -3F);
		body1.setTextureSize(128, 64);
		setRotation(body1, 1.22173F, 0F, 0F);
		body2 = new ModelRenderer(this, 56, 19);
		body2.addBox(-3F, 1F, -8F, 6, 12, 8);
		body2.setRotationPoint(0F, 8F, -3F);
		body2.setTextureSize(128, 64);
		setRotation(body2, 1.658063F, 0F, 0F);
		frontrightleg1 = new ModelRenderer(this, 92, 0);
		frontrightleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		frontrightleg1.setRotationPoint(-4F, 9F, -6F);
		frontrightleg1.setTextureSize(128, 64);
		setRotation(frontrightleg1, 0.1745329F, 0F, -0.0349066F);
		ModelRenderer frontrightleg2 = new ModelRenderer(this, 92, 11);
		frontrightleg2.addBox(-1F, 6F, 2F, 2, 8, 3);
		frontrightleg2.setRotationPoint(-4F, 9F, -6F);
		frontrightleg2.setTextureSize(128, 64);
		setRotation(frontrightleg2, -0.1745329F, 0F, -0.0349066F);
		ModelRenderer frontrightclaw = new ModelRenderer(this, 92, 22);
		frontrightclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
		frontrightclaw.setRotationPoint(-4F, 9F, -6F);
		frontrightclaw.setTextureSize(128, 64);
		setRotation(frontrightclaw, 0.0872665F, 0F, -0.0349066F);
		frontleftleg1 = new ModelRenderer(this, 92, 0);
		frontleftleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
		frontleftleg1.setRotationPoint(4F, 9F, -6F);
		frontleftleg1.setTextureSize(128, 64);
		setRotation(frontleftleg1, 0.1745329F, 0F, 0.0349066F);
		ModelRenderer frontleftleg2 = new ModelRenderer(this, 92, 11);
		frontleftleg2.addBox(-1F, 6F, 2F, 2, 8, 3);
		frontleftleg2.setRotationPoint(4F, 9F, -6F);
		frontleftleg2.setTextureSize(128, 64);
		setRotation(frontleftleg2, -0.1745329F, 0F, 0.0349066F);
		ModelRenderer frontleftclaw = new ModelRenderer(this, 92, 22);
		frontleftclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
		frontleftclaw.setRotationPoint(4F, 9F, -6F);
		frontleftclaw.setTextureSize(128, 64);
		setRotation(frontleftclaw, 0.0872665F, 0F, 0.0349066F);
		backrightleg1 = new ModelRenderer(this, 108, 0);
		backrightleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		backrightleg1.setRotationPoint(-3F, 8F, 9F);
		backrightleg1.setTextureSize(128, 64);
		setRotation(backrightleg1, -0.296706F, 0F, -0.0349066F);
		ModelRenderer backrightleg2 = new ModelRenderer(this, 108, 14);
		backrightleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		backrightleg2.setRotationPoint(-3F, 8F, 9F);
		backrightleg2.setTextureSize(128, 64);
		setRotation(backrightleg2, -0.8726646F, 0F, -0.0349066F);
		ModelRenderer backrightleg3 = new ModelRenderer(this, 108, 23);
		backrightleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		backrightleg3.setRotationPoint(-3F, 8F, 9F);
		backrightleg3.setTextureSize(128, 64);
		setRotation(backrightleg3, -0.2617994F, 0F, -0.0349066F);
		ModelRenderer backrightfoot = new ModelRenderer(this, 108, 32);
		backrightfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		backrightfoot.setRotationPoint(-3F, 8F, 9F);
		backrightfoot.setTextureSize(128, 64);
		setRotation(backrightfoot, 0.0872665F, 0F, -0.0349066F);
		backleftleg1 = new ModelRenderer(this, 108, 0);
		backleftleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
		backleftleg1.setRotationPoint(3F, 8F, 9F);
		backleftleg1.setTextureSize(128, 64);
		setRotation(backleftleg1, -0.296706F, 0F, 0.0349066F);
		ModelRenderer backleftleg2 = new ModelRenderer(this, 108, 14);
		backleftleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
		backleftleg2.setRotationPoint(3F, 8F, 9F);
		backleftleg2.setTextureSize(128, 64);
		setRotation(backleftleg2, -0.8726646F, 0F, 0.0349066F);
		ModelRenderer backleftleg3 = new ModelRenderer(this, 108, 23);
		backleftleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
		backleftleg3.setRotationPoint(3F, 8F, 9F);
		backleftleg3.setTextureSize(128, 64);
		setRotation(backleftleg3, -0.2617994F, 0F, 0.0349066F);
		ModelRenderer backleftfoot = new ModelRenderer(this, 108, 32);
		backleftfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
		backleftfoot.setRotationPoint(3F, 8F, 9F);
		backleftfoot.setTextureSize(128, 64);
		setRotation(backleftfoot, 0.0872665F, 0F, 0.0349066F);
		tail1 = new ModelRenderer(this, 56, 39);
		tail1.addBox(-1F, 0F, -1F, 2, 10, 2);
		tail1.setRotationPoint(0F, 8F, 10F);
		tail1.setTextureSize(128, 64);
		setRotation(tail1, 0.6108652F, 0F, 0F);
		tail2 = new ModelRenderer(this, 56, 51);
		tail2.addBox(-1.5F, 8F, -1.5F, 3, 6, 3);
		tail2.setRotationPoint(0F, 8F, 10F);
		tail2.setTextureSize(128, 64);
		setRotation(tail2, 0.6108652F, 0F, 0F);

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
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
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
		tail2.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
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
