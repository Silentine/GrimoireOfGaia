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
public class ModelGaiaAnubis extends ModelGaia {
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
	private ModelRenderer mantle;
	private ModelRenderer tail;
	private ModelRenderer waist;

	public ModelGaiaAnubis() {
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
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 9, 7);
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
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(getRightArm(), 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(getLeftArm(), 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 36);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		hair1 = new ModelRenderer(this, 36, 16);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(64, 32);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 27);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(64, 32);
		setRotation(hair2, 0F, 0F, 0F);
		ModelRenderer crown = new ModelRenderer(this, 36, 39);
		crown.addBox(-1F, -8F, -4.6F, 2, 3, 1);
		crown.setRotationPoint(0F, 1F, 0F);
		crown.setTextureSize(64, 32);
		setRotation(crown, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 43);
		rightear.addBox(-4.5F, -10F, -1.5F, 3, 4, 3);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, 0F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 48, 43);
		leftear.addBox(1.5F, -10F, -1.5F, 3, 4, 3);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0F, 0F);
		mantle = new ModelRenderer(this, 36, 50);
		mantle.addBox(-4F, 0F, -2F, 8, 2, 4);
		mantle.setRotationPoint(0F, 1F, 0F);
		mantle.setTextureSize(64, 32);
		setRotation(mantle, 0F, 0F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 64, 0);
		rightarmlower.addBox(-2.5F, 2.5F, -1.5F, 2, 8, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 74, 0);
		leftarmlower.addBox(0.5F, 2F, -1.5F, 2, 8, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		ModelRenderer rightarmhand = new ModelRenderer(this, 64, 11);
		rightarmhand.addBox(-1.5F, 7.5F, -2F, 2, 4, 4);
		rightarmhand.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmhand.setTextureSize(64, 32);
		setRotation(rightarmhand, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmhand = new ModelRenderer(this, 76, 11);
		leftarmhand.addBox(-0.5F, 7.5F, -2F, 2, 4, 4);
		leftarmhand.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmhand.setTextureSize(64, 32);
		setRotation(leftarmhand, 0F, 0F, -0.1745329F);
		tail = new ModelRenderer(this, 88, 0);
		tail.addBox(-1F, 7.5F, -4F, 2, 10, 2);
		tail.setRotationPoint(0F, 1F, 0F);
		tail.setTextureSize(64, 32);
		setRotation(tail, 0.5235988F, 0F, 0F);
		waist = new ModelRenderer(this, 88, 12);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 88, 20);
		rightleglower.addBox(-2F, 5F, -2F, 4, 6, 4);
		rightleglower.setRotationPoint(-2F, 11F, 0F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, 0F, 0F, 0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 104, 20);
		leftleglower.addBox(-2F, 5F, -2F, 4, 6, 4);
		leftleglower.setRotationPoint(2F, 11F, 0F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, 0F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 88, 30);
		rightfoot.addBox(-2F, 11F, -3.5F, 4, 2, 4);
		rightfoot.setRotationPoint(-2F, 11F, 0F);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, 0F, 0F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 88, 30);
		leftfoot.addBox(-2F, 11F, -3.5F, 4, 2, 4);
		leftfoot.setRotationPoint(2F, 11F, 0F);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, crown);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(getRightArm(), rightarmlower);
		convertToChild(getRightArm(), rightarmhand);
		convertToChild(getLeftArm(), leftarmlower);
		convertToChild(getLeftArm(), leftarmhand);
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
		mantle.render(scale);
		tail.render(scale);
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
		hair1.rotateAngleY = head.rotateAngleY;
		hair2.rotateAngleY = (head.rotateAngleY) * 0.75F;

		// arms
		if (itemstack.isEmpty() || itemstack.getItem() != Items.STICK) {
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
		} else if (itemstack.getItem() == Items.STICK) {
			animationSpawn();
		}

		// body
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(5);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
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

	private void animationSpawn() {
		rightarm.rotateAngleX = -1.047198F;
		leftarm.rotateAngleX = -1.047198F;

		rightarm.rotateAngleY = -0.2617994F;
		leftarm.rotateAngleY = 0.2617994F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
