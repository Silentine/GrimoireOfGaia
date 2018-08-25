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
public class ModelGaiaSatyress extends ModelGaia {
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
	private ModelRenderer righthair;
	private ModelRenderer lefthair;
	private ModelRenderer waist;
	private ModelRenderer tail;

	public ModelGaiaSatyress() {
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
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.25F, 3F, -1.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.25F, 3F, -1.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.0872665F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.0872665F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1F, 3, 8, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.1745329F, 0F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1F, 3, 8, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.1745329F, 0F, 0.0349066F);
		righthair = new ModelRenderer(this, 36, 14);
		righthair.addBox(-5.5F, -4.5F, 1.5F, 4, 12, 4);
		righthair.setRotationPoint(0F, 1F, 0F);
		righthair.setTextureSize(64, 32);
		setRotation(righthair, 0.0872665F, 0F, 0.0872665F);
		lefthair = new ModelRenderer(this, 36, 14);
		lefthair.addBox(1.5F, -4.5F, 1.5F, 4, 12, 4);
		lefthair.setRotationPoint(0F, 1F, 0F);
		lefthair.setTextureSize(64, 32);
		setRotation(lefthair, 0.0872665F, 0F, -0.0872665F);
		ModelRenderer righthorn1 = new ModelRenderer(this, 36, 30);
		righthorn1.addBox(-5F, -5.5F, -2.5F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, 1F, 0F);
		righthorn1.setTextureSize(64, 32);
		setRotation(righthorn1, 0F, 0F, 0F);
		ModelRenderer righthorn2 = new ModelRenderer(this, 36, 34);
		righthorn2.addBox(-6F, -6.5F, -1.5F, 2, 2, 3);
		righthorn2.setRotationPoint(0F, 1F, 0F);
		righthorn2.setTextureSize(64, 32);
		setRotation(righthorn2, 0F, 0F, 0F);
		ModelRenderer righthorn3 = new ModelRenderer(this, 36, 39);
		righthorn3.addBox(-7F, -5.5F, 0.5F, 2, 3, 2);
		righthorn3.setRotationPoint(0F, 1F, 0F);
		righthorn3.setTextureSize(64, 32);
		setRotation(righthorn3, 0F, 0F, 0F);
		ModelRenderer righthorn4 = new ModelRenderer(this, 36, 44);
		righthorn4.addBox(6.5F, -3F, 0F, 1, 1, 1);
		righthorn4.setRotationPoint(0F, 1F, 0F);
		righthorn4.setTextureSize(64, 32);
		righthorn4.mirror = true;
		setRotation(righthorn4, 0F, 0F, 0F);
		ModelRenderer lefthorn1 = new ModelRenderer(this, 36, 30);
		lefthorn1.mirror = true;
		lefthorn1.addBox(3F, -5.5F, -2.5F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, 1F, 0F);
		lefthorn1.setTextureSize(64, 32);
		setRotation(lefthorn1, 0F, 0F, 0F);
		ModelRenderer lefthorn2 = new ModelRenderer(this, 36, 34);
		lefthorn2.mirror = true;
		lefthorn2.addBox(4F, -6.5F, -1.5F, 2, 2, 3);
		lefthorn2.setRotationPoint(0F, 1F, 0F);
		lefthorn2.setTextureSize(64, 32);
		setRotation(lefthorn2, 0F, 0F, 0F);
		ModelRenderer lefthorn3 = new ModelRenderer(this, 36, 39);
		lefthorn3.mirror = true;
		lefthorn3.addBox(5F, -5.5F, 0.5F, 2, 3, 2);
		lefthorn3.setRotationPoint(0F, 1F, 0F);
		lefthorn3.setTextureSize(64, 32);
		setRotation(lefthorn3, 0F, 0F, 0F);
		ModelRenderer lefthorn4 = new ModelRenderer(this, 36, 44);
		lefthorn4.mirror = true;
		lefthorn4.addBox(-7.5F, -3F, 0F, 1, 1, 1);
		lefthorn4.setRotationPoint(0F, 1F, 0F);
		lefthorn4.setTextureSize(64, 32);
		setRotation(lefthorn4, 0F, 0F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 66, 0);
		rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 6, 3);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0F, 0F, 0.0872665F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 78, 0);
		leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 6, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftpauldron.setTextureSize(64, 32);
		setRotation(leftpauldron, 0F, 0F, -0.0872665F);
		waist = new ModelRenderer(this, 66, 9);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 6, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		tail = new ModelRenderer(this, 66, 19);
		tail.addBox(-1.5F, 9F, -3F, 3, 5, 1);
		tail.setRotationPoint(0F, 1F, 0F);
		tail.setTextureSize(64, 32);
		setRotation(tail, 0.4363323F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 66, 25);
		rightfoot.addBox(-1F, 5F, 1F, 2, 8, 2);
		rightfoot.setRotationPoint(-2F, 11F, 0F);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, -0.1745329F, 0F, -0.0349066F);
		ModelRenderer leftfoot = new ModelRenderer(this, 66, 25);
		leftfoot.addBox(-1F, 5F, 1F, 2, 8, 2);
		leftfoot.setRotationPoint(2F, 11F, 0F);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, -0.1745329F, 0F, 0.0349066F);

		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, righthorn4);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, lefthorn4);
		convertToChild(rightarm, rightpauldron);
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
		righthair.render(scale);
		lefthair.render(scale);
		waist.render(scale);
		tail.render(scale);

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
		righthair.rotateAngleY = head.rotateAngleY;
		lefthair.rotateAngleY = head.rotateAngleY;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		if (itemstack.getItem() == Items.FEATHER) {
			animationPotion();
		}

		// body
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(10);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.8F * limbSwingAmount;
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

	private void animationPotion() {
		if ((rightleg.rotateAngleX != -0.1745329F) || (leftleg.rotateAngleX != -0.1745329F)) {
			rightarm.rotateAngleX += 1.0472F;
			leftarm.rotateAngleX += 1.0472F;
			rightarm.rotateAngleY = -0.523599F;
			leftarm.rotateAngleY = +0.523599F;
		}
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
