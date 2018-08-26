package gaia.model;

import gaia.entity.monster.EntityGaiaCobbleGolem;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @see ModelIronGolem
 */
@SideOnly(Side.CLIENT)
public class ModelGaiaCobbleGolem extends ModelGaia {

	private ModelRenderer head;
	private ModelRenderer body;
	private ModelRenderer rightarmupper;
	private ModelRenderer leftarmupper;
	private ModelRenderer bodylower;
	private ModelRenderer rightlegupper;
	private ModelRenderer leftlegupper;

	public ModelGaiaCobbleGolem() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -2.0F, -1.0F, 6, 4, 4);
		head.setRotationPoint(0.0F, 3.0F, -4.0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.0872665F, 0.0F, 0.0F);
		body = new ModelRenderer(this, 0, 8);
		body.addBox(-7.0F, -6.0F, -4.0F, 14, 12, 8);
		body.setRotationPoint(0.0F, 4.0F, 2.0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0.2617994F, 0.0F, 0.0F);
		rightarmupper = new ModelRenderer(this, 44, 0);
		rightarmupper.addBox(-6.0F, -4.0F, -3.0F, 6, 12, 6);
		rightarmupper.setRotationPoint(-7.0F, 2.0F, 3.0F);
		rightarmupper.setTextureSize(64, 32);
		setRotation(rightarmupper, 0.0F, 0.0F, 0.0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 44, 18);
		rightarmlower.addBox(-5.0F, 8.0F, -2.0F, 4, 14, 4);
		rightarmlower.setRotationPoint(-7.0F, 2.0F, 3.0F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0.0F, 0.0F, 0.0F);
		leftarmupper = new ModelRenderer(this, 44, 0);
		leftarmupper.addBox(0.0F, -4.0F, -3.0F, 6, 12, 6);
		leftarmupper.setRotationPoint(7.0F, 2.0F, 3.0F);
		leftarmupper.setTextureSize(64, 32);
		setRotation(leftarmupper, 0.0F, 0.0F, 0.0F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 44, 18);
		leftarmlower.addBox(1.0F, 8.0F, -2.0F, 4, 14, 4);
		leftarmlower.setRotationPoint(7.0F, 2.0F, 3.0F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0.0F, 0.0F, 0.0F);
		bodylower = new ModelRenderer(this, 0, 28);
		bodylower.addBox(-1.0F, 11.0F, -3.0F, 8, 4, 6);
		bodylower.setRotationPoint(-3.0F, -1.0F, 3.0F);
		bodylower.setTextureSize(64, 32);
		setRotation(bodylower, 0.0872665F, 0.0F, 0.0F);
		rightlegupper = new ModelRenderer(this, 44, 36);
		rightlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		rightlegupper.setRotationPoint(-3.0F, 13.0F, 4.0F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, -0.1745329F, 0.0F, 0.0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 44, 45);
		rightleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		rightleglower.setRotationPoint(-3.0F, 13.0F, 4.0F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, -0.1745329F, 0.0F, 0.0F);
		leftlegupper = new ModelRenderer(this, 44, 36);
		leftlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		leftlegupper.setRotationPoint(3.0F, 13.0F, 4.0F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, -0.1745329F, 0.0F, 0.0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 44, 45);
		leftleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		leftleglower.setRotationPoint(3.0F, 13.0F, 4.0F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, -0.1745329F, 0.0F, 0.0F);

		convertToChild(rightarmupper, rightarmlower);
		convertToChild(leftarmupper, leftarmlower);
		convertToChild(rightlegupper, rightleglower);
		convertToChild(leftlegupper, leftleglower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		body.render(scale);
		rightarmupper.render(scale);
		leftarmupper.render(scale);
		bodylower.render(scale);
		rightlegupper.render(scale);
		leftlegupper.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms

		// legs
		rightlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		rightlegupper.rotateAngleX -= 0.1745329F;
		leftlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		leftlegupper.rotateAngleX -= 0.1745329F;
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
		EntityGaiaCobbleGolem entitygaiacobblegolem = (EntityGaiaCobbleGolem) entitylivingbaseIn;
		int i = entitygaiacobblegolem.getAttackTimer();

		if (i > 0) {
			rightarmupper.rotateAngleX = -2.0F + 1.5F * getArmRotation((float) i - partialTickTime);
			leftarmupper.rotateAngleX = -2.0F + 1.5F * getArmRotation((float) i - partialTickTime);
		}
	}

	private float getArmRotation(float tickTime) {
		return (Math.abs(tickTime % 10.0F - 10.0F * 0.5F) - 10.0F * 0.25F) / (10.0F * 0.25F);
	}
}
