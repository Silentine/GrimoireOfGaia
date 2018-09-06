package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDryad extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymid;
	private ModelRenderer bodymidbutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer waist1;
	private ModelRenderer waist2;

	private static final float SCALE_AMOUNT_HEAD = 0.75F;
	private static final float SCALE_AMOUNT_BODY = 0.5F;
	// Increasing the value moves it closer to the ground
	private static final float Y_OFFSET_BODY = 23.5F;
	private static final float Y_OFFSET_HEAD = 15.5F;

	public ModelGaiaDryad() {
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
		bodymid = new ModelRenderer(this, 0, 25);
		bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymid.setRotationPoint(0F, 1F, 0F);
		bodymid.setTextureSize(64, 32);
		setRotation(bodymid, 0F, 0F, 0F);
		bodymidbutton = new ModelRenderer(this, 0, 25);
		bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymidbutton.setRotationPoint(0F, 1F, 0F);
		bodymidbutton.setTextureSize(64, 32);
		setRotation(bodymidbutton, 0F, 0F, 0F);
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
		setRotation(leftchest, 0.7853982F, -0.0872665F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0872665F, 0F, 0.2617994F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.0872665F, 0F, -0.2617994F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0.0349066F);
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
		ModelRenderer rightear = new ModelRenderer(this, 36, 33);
		rightear.addBox(-4F, -4F, -1F, 0, 2, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(128, 64);
		rightear.mirror = true;
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 33);
		leftear.mirror = true;
		leftear.addBox(4F, -4F, -1F, 0, 2, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(128, 64);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		waist1 = new ModelRenderer(this, 64, 0);
		waist1.addBox(-3.466667F, 7.5F, -3F, 7, 6, 4);
		waist1.setRotationPoint(0F, 1F, 0F);
		waist1.setTextureSize(64, 32);
		setRotation(waist1, 0.0872665F, 0F, 0F);
		waist2 = new ModelRenderer(this, 64, 10);
		waist2.addBox(-4F, 8.5F, -3.5F, 8, 8, 4);
		waist2.setRotationPoint(0F, 1F, 0F);
		waist2.setTextureSize(64, 32);
		setRotation(waist2, 0.1745329F, 0F, 0F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST);

		if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
			head.render(scale);
			headaccessory.render(scale);
			neck.render(scale);
			bodytop.render(scale);
			bodymid.render(scale);
			bodymidbutton.render(scale);
			bodybottom.render(scale);
			rightchest.render(scale);
			leftchest.render(scale);
			rightarm.render(scale);
			leftarm.render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			hair1.render(scale);
			hair2.render(scale);
			waist1.render(scale);
			waist2.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}

		} else {
			/* SCALING */
			GlStateManager.pushMatrix();
			GlStateManager.scale(SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD, SCALE_AMOUNT_HEAD);
			GlStateManager.translate(0.0F, Y_OFFSET_HEAD * scale, 0.0F);
			head.render(scale);

			if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
				headeyes.render(scale);
			}

			headaccessory.render(scale);
			hair1.render(scale);
//			hair2.render(scale);
			GlStateManager.popMatrix();
			/* SCALING */
			GlStateManager.pushMatrix();
			GlStateManager.scale(SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY, SCALE_AMOUNT_BODY);
			GlStateManager.translate(0.0F, Y_OFFSET_BODY * scale, 0.0F);
			neck.render(scale);
			bodytop.render(scale);
			bodymid.render(scale);
			bodymidbutton.render(scale);
			bodybottom.render(scale);
			rightarm.render(scale);
			leftarm.render(scale);
			rightleg.render(scale);
			leftleg.render(scale);
			waist1.render(scale);
			waist2.render(scale);
			GlStateManager.popMatrix();
			/* SCALING */
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
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		if (itemstack.getItem() == Items.FEATHER) {
			animationFlee();
		}

		if (itemstack.getItem() == Items.EGG) {
			animationReset();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

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

	private void animationFlee() {
		if ((rightleg.rotateAngleX >= degToRad(5)) || (rightleg.rotateAngleX <= degToRad(-5))) {
			rightarm.rotateAngleX += 1.0472F;
			leftarm.rotateAngleX += 1.0472F;
			rightarm.rotateAngleY = -0.523599F;
			leftarm.rotateAngleY = 0.523599F;
		} else {
			rightarm.rotateAngleY = 0.0F;
			leftarm.rotateAngleY = 0.0F;
		}
	}

	private void animationReset() {
		rightarm.rotateAngleY = 0.0F;
		leftarm.rotateAngleY = 0.0F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
