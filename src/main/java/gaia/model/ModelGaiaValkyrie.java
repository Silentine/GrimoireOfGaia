package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaValkyrie extends ModelGaia {
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
	private ModelRenderer cape1;
	private ModelRenderer cape2;
	private ModelRenderer cape3;
	private ModelRenderer skirtmantle;
	private ModelRenderer skirt1;
	private ModelRenderer skirt2;
	private ModelRenderer skirt3;
	private ModelRenderer rightwing;
	private ModelRenderer leftwing;

	public ModelGaiaValkyrie() {
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
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
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
		rightarm.setRotationPoint(-2.5F, 3F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 3F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -4F, 2.5F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(64, 32);
		setRotation(hair1, 0.2617994F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 25);
		hair2.addBox(-4.5F, 1F, 3F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(64, 32);
		setRotation(hair2, 0.2617994F, 0F, 0F);
		ModelRenderer rightfeather = new ModelRenderer(this, 36, 37);
		rightfeather.addBox(-4.5F, -7F, 0F, 1, 6, 8);
		rightfeather.setRotationPoint(0F, 1F, 0F);
		rightfeather.setTextureSize(64, 32);
		setRotation(rightfeather, 0.3490659F, -0.2617994F, 0F);
		ModelRenderer leftfeather = new ModelRenderer(this, 36, 37);
		leftfeather.addBox(3.5F, -7F, 0F, 1, 6, 8);
		leftfeather.setRotationPoint(0F, 1F, 0F);
		leftfeather.setTextureSize(64, 32);
		setRotation(leftfeather, 0.3490659F, 0.2617994F, 0F);
		ModelRenderer headhelmet = new ModelRenderer(this, 36, 51);
		headhelmet.addBox(-3F, -7F, -4F, 6, 3, 4);
		headhelmet.setRotationPoint(0F, 1F, 0F);
		headhelmet.setTextureSize(64, 32);
		setRotation(headhelmet, 0F, 0F, 0F);
		cape1 = new ModelRenderer(this, 64, 0);
		cape1.addBox(-3.5F, 0F, 0.5F, 7, 4, 2);
		cape1.setRotationPoint(0F, 1F, 0F);
		cape1.setTextureSize(64, 32);
		setRotation(cape1, 0.1745329F, 0F, 0F);
		cape2 = new ModelRenderer(this, 64, 6);
		cape2.addBox(-4F, 3.5F, 0F, 8, 5, 3);
		cape2.setRotationPoint(0F, 1F, 0F);
		cape2.setTextureSize(64, 32);
		setRotation(cape2, 0.1745329F, 0F, 0F);
		cape3 = new ModelRenderer(this, 64, 14);
		cape3.addBox(-4.5F, 8F, 0.5F, 9, 6, 3);
		cape3.setRotationPoint(0F, 1F, 0F);
		cape3.setTextureSize(64, 32);
		setRotation(cape3, 0.1745329F, 0F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 64, 23);
		rightpauldron.addBox(-4F, -2F, -2F, 4, 3, 4);
		rightpauldron.setRotationPoint(-2.5F, 3F, 0F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0.0872665F, 0F, -0.1745329F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 80, 23);
		leftpauldron.addBox(0F, -2F, -2F, 4, 3, 4);
		leftpauldron.setRotationPoint(2.5F, 3F, 0F);
		leftpauldron.setTextureSize(64, 32);
		setRotation(leftpauldron, 0.0872665F, 0F, 0.1745329F);
		ModelRenderer rightgauntlet = new ModelRenderer(this, 64, 30);
		rightgauntlet.addBox(-2.5F, 3.5F, -1.5F, 2, 6, 3);
		rightgauntlet.setRotationPoint(-2.5F, 3F, 0F);
		rightgauntlet.setTextureSize(64, 32);
		setRotation(rightgauntlet, 0.0872665F, 0F, 0.1745329F);
		skirtmantle = new ModelRenderer(this, 96, 0);
		skirtmantle.addBox(-3.5F, -2.5F, -2F, 7, 4, 4);
		skirtmantle.setRotationPoint(0F, 12F, 0F);
		skirtmantle.setTextureSize(64, 32);
		setRotation(skirtmantle, 0.1745329F, 0F, 0F);
		skirt1 = new ModelRenderer(this, 96, 8);
		skirt1.addBox(-4F, -2F, -1.5F, 8, 4, 4);
		skirt1.setRotationPoint(0F, 12F, 0F);
		skirt1.setTextureSize(64, 32);
		setRotation(skirt1, 0.1832596F, 0F, 0F);
		skirt2 = new ModelRenderer(this, 96, 16);
		skirt2.addBox(-4.5F, 1F, -1F, 9, 5, 4);
		skirt2.setRotationPoint(0F, 12F, 0F);
		skirt2.setTextureSize(64, 32);
		setRotation(skirt2, 0.1745329F, 0F, 0F);
		skirt3 = new ModelRenderer(this, 96, 25);
		skirt3.addBox(-5F, 5F, -0.5F, 10, 5, 4);
		skirt3.setRotationPoint(0F, 12F, 0F);
		skirt3.setTextureSize(64, 32);
		setRotation(skirt3, 0.1745329F, 0F, 0F);
		rightwing = new ModelRenderer(this, 74, 34);
		rightwing.addBox(0F, 0F, 0.5F, 0, 12, 18);
		rightwing.setRotationPoint(-2F, 2F, 1F);
		rightwing.setTextureSize(64, 32);
		setRotation(rightwing, 0.6981317F, -0.5235988F, 0F);
		leftwing = new ModelRenderer(this, 92, 34);
		leftwing.addBox(0F, 0F, 0.5F, 0, 12, 18);
		leftwing.setRotationPoint(2F, 2F, 1F);
		leftwing.setTextureSize(64, 32);
		setRotation(leftwing, 0.6981317F, 0.5235988F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 96, 34);
		rightfoot.addBox(-2F, 5F, -2F, 4, 8, 4);
		rightfoot.setRotationPoint(-2F, 11F, 0F);
		rightfoot.setTextureSize(128, 64);
		setRotation(rightfoot, 0F, 0F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 96, 34);
		leftfoot.addBox(-2F, 5F, -2F, 4, 8, 4);
		leftfoot.setRotationPoint(2F, 11F, 0F);
		leftfoot.setTextureSize(128, 64);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, rightfeather);
		convertToChild(head, leftfeather);
		convertToChild(head, headhelmet);
		convertToChild(rightarm, rightpauldron);
		convertToChild(rightarm, rightgauntlet);
		convertToChild(leftarm, leftpauldron);
		convertToChild(rightleg, rightfoot);
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
		cape1.render(scale);
		cape2.render(scale);
		cape3.render(scale);
		skirtmantle.render(scale);
		skirt1.render(scale);
		skirt2.render(scale);
		skirt3.render(scale);
		rightwing.render(scale);
		leftwing.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

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
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			float armDefaultAngleZ = 0.1745329F;

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// body
		float wingDefaultAngleY = 0.5235988F;

		rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.rotateAngleY -= wingDefaultAngleY;
		leftwing.rotateAngleY += wingDefaultAngleY;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.35F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.35F * limbSwingAmount;
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

	private void animationBuff() {
		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;
		rightarm.rotateAngleZ = +0.785398F;
		leftarm.rotateAngleZ = -0.785398F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
