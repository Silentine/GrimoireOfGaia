
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
public class ModelGaiaOni extends ModelGaia {
	ModelRenderer head;
	ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer sake01;
	ModelRenderer sake02;
	ModelRenderer sake03;
	ModelRenderer sakerope;
	ModelRenderer waist;

	public ModelGaiaOni() {
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
		rightarm.addBox(-3F, -1F, -1.5F, 3, 12, 3);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 36);
		leftarm.addBox(0F, -1F, -1.5F, 3, 12, 3);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		leftarm.mirror = true;
		rightleg = new ModelRenderer(this, 88, 17);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 88, 17);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		ModelRenderer righthorn = new ModelRenderer(this, 36, 14);
		righthorn.addBox(-2.5F, -9.5F, -1.5F, 1, 4, 1);
		righthorn.setRotationPoint(0F, 1F, 0F);
		righthorn.setTextureSize(64, 32);
		setRotation(righthorn, 0.2617994F, 0F, 0F);
		ModelRenderer lefthorn = new ModelRenderer(this, 36, 14);
		lefthorn.mirror = true;
		lefthorn.addBox(1.5F, -9.5F, -1.5F, 1, 4, 1);
		lefthorn.setRotationPoint(0F, 1F, 0F);
		lefthorn.setTextureSize(64, 32);
		setRotation(lefthorn, 0.2617994F, 0F, 0F);
		ModelRenderer rightarmupper = new ModelRenderer(this, 64, 0);
		rightarmupper.addBox(-4F, 0F, -2F, 4, 4, 4);
		rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmupper.setTextureSize(64, 32);
		setRotation(rightarmupper, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmupper = new ModelRenderer(this, 64, 0);
		leftarmupper.mirror = true;
		leftarmupper.addBox(0F, 0F, -2F, 4, 4, 4);
		leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmupper.setTextureSize(64, 32);
		setRotation(leftarmupper, 0F, 0F, -0.1745329F);
		sake01 = new ModelRenderer(this, 64, 8);
		sake01.addBox(-2.5F, 3F, 2.5F, 6, 6, 6);
		sake01.setRotationPoint(0F, 1F, 0F);
		sake01.setTextureSize(64, 32);
		setRotation(sake01, -0.0872665F, 0F, 0F);
		sake02 = new ModelRenderer(this, 64, 20);
		sake02.addBox(-1.5F, -1F, 3.5F, 4, 4, 4);
		sake02.setRotationPoint(0F, 1F, 0F);
		sake02.setTextureSize(64, 32);
		setRotation(sake02, -0.0872665F, 0F, 0F);
		sake03 = new ModelRenderer(this, 64, 28);
		sake03.addBox(-0.5F, -2F, 4.5F, 2, 2, 2);
		sake03.setRotationPoint(0F, 1F, 0F);
		sake03.setTextureSize(64, 32);
		setRotation(sake03, -0.0872665F, 0F, 0F);
		sakerope = new ModelRenderer(this, 64, 32);
		sakerope.addBox(-3F, 6F, 7F, 2, 6, 2);
		sakerope.setRotationPoint(0F, 1F, 0F);
		sakerope.setTextureSize(64, 32);
		setRotation(sakerope, -0.0872665F, 0F, 0F);
		waist = new ModelRenderer(this, 88, 0);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		ModelRenderer rightlegupper = new ModelRenderer(this, 88, 8);
		rightlegupper.addBox(-2F, -1F, -2F, 4, 5, 4);
		rightlegupper.setRotationPoint(-2F, 11F, 0F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, 0F, 0F, 0.0872665F);
		ModelRenderer leftlegupper = new ModelRenderer(this, 88, 8);
		leftlegupper.mirror = true;
		leftlegupper.addBox(-2F, -1F, -2F, 4, 5, 4);
		leftlegupper.setRotationPoint(2F, 11F, 0F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, 0F, 0F, -0.0872665F);

		convertToChild(head, righthorn);
		convertToChild(head, lefthorn);
		convertToChild(rightarm, rightarmupper);
		convertToChild(leftarm, leftarmupper);
		convertToChild(rightleg, rightlegupper);
		convertToChild(leftleg, leftlegupper);
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
		sake01.render(scale);
		sake02.render(scale);
		sake03.render(scale);
		sakerope.render(scale);
		waist.render(scale);

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

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
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