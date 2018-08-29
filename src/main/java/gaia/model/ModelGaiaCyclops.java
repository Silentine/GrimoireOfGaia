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
public class ModelGaiaCyclops extends ModelGaia {
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
	private ModelRenderer hair;
	private ModelRenderer skirt;

	public ModelGaiaCyclops() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.0349066F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0.0349066F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0.0349066F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0.0349066F, 0F, 0F);
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
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
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
		hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-1.5F, -5F, 2.5F, 3, 12, 3);
		hair.setRotationPoint(0F, 1F, 0F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0.0349066F, 0F, 0F);
		ModelRenderer hairribbon = new ModelRenderer(this, 36, 29);
		hairribbon.addBox(-2.5F, -4F, 2.5F, 5, 3, 7);
		hairribbon.setRotationPoint(0F, 1F, 0F);
		hairribbon.setTextureSize(64, 32);
		setRotation(hairribbon, 0.7853982F, 0F, 0F);
		ModelRenderer righthorn = new ModelRenderer(this, 36, 39);
		righthorn.addBox(-2.5F, -2.5F, -7.5F, 1, 1, 3);
		righthorn.setRotationPoint(0F, 1F, 0F);
		righthorn.setTextureSize(64, 32);
		setRotation(righthorn, -0.7504916F, 0F, 0F);
		ModelRenderer lefthorn = new ModelRenderer(this, 36, 39);
		lefthorn.addBox(1.5F, -2.5F, -7.5F, 1, 1, 3);
		lefthorn.setRotationPoint(0F, 1F, 0F);
		lefthorn.setTextureSize(64, 32);
		setRotation(lefthorn, -0.7504916F, 0F, 0F);
		ModelRenderer rightarmpauldron = new ModelRenderer(this, 36, 43);
		rightarmpauldron.addBox(-3F, -2F, -2F, 3, 5, 4);
		rightarmpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmpauldron.setTextureSize(64, 32);
		setRotation(rightarmpauldron, 0.0872665F, 0F, 0.4363323F);
		ModelRenderer leftarmpauldron = new ModelRenderer(this, 50, 43);
		leftarmpauldron.addBox(0F, -2F, -2F, 3, 5, 4);
		leftarmpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmpauldron.setTextureSize(64, 32);
		setRotation(leftarmpauldron, 0.0872665F, 0F, -0.4363323F);
		ModelRenderer rightarmgauntlet = new ModelRenderer(this, 36, 52);
		rightarmgauntlet.addBox(-2.5F, 5F, -1.5F, 2, 5, 3);
		rightarmgauntlet.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmgauntlet.setTextureSize(64, 32);
		setRotation(rightarmgauntlet, 0.0872665F, 0F, 0.1745329F);
		ModelRenderer leftarmgauntlet = new ModelRenderer(this, 46, 52);
		leftarmgauntlet.addBox(0.5F, 5F, -1.5F, 2, 5, 3);
		leftarmgauntlet.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmgauntlet.setTextureSize(64, 32);
		setRotation(leftarmgauntlet, 0.0872665F, 0F, -0.1745329F);
		skirt = new ModelRenderer(this, 64, 0);
		skirt.addBox(-3.5F, 7.466667F, -3F, 7, 6, 4);
		skirt.setRotationPoint(0F, 1F, 0F);
		skirt.setTextureSize(128, 64);
		setRotation(skirt, 0.0872665F, 0F, 0F);
		ModelRenderer rightlegupper = new ModelRenderer(this, 64, 10);
		rightlegupper.addBox(-2F, -1.533333F, -2F, 4, 7, 4);
		rightlegupper.setRotationPoint(-2F, 11F, 0F);
		rightlegupper.setTextureSize(128, 64);
		setRotation(rightlegupper, 0.0872665F, 0F, 0.1745329F);
		ModelRenderer leftlegupper = new ModelRenderer(this, 64, 10);
		leftlegupper.mirror = true;
		leftlegupper.addBox(-2F, -1.533333F, -2F, 4, 7, 4);
		leftlegupper.setRotationPoint(2F, 11F, 0F);
		leftlegupper.setTextureSize(128, 64);
		setRotation(leftlegupper, 0.0872665F, 0F, -0.1745329F);

		convertToChild(head, hairribbon);
		convertToChild(head, righthorn);
		convertToChild(head, lefthorn);
		convertToChild(rightarm, rightarmpauldron);
		convertToChild(leftarm, leftarmpauldron);
		convertToChild(rightarm, rightarmgauntlet);
		convertToChild(leftarm, leftarmgauntlet);
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
		hair.render(scale);
		skirt.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = (headPitch / 57.295776F) + 0.0349066F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		hair.rotateAngleY = head.rotateAngleY;

		// arms
		if (itemstack.getItem() != Items.STICK) {
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
		}

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

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

		// right arm
		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);

		// left arm
		leftarm.rotateAngleX = (float) ((double) leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		leftarm.rotateAngleY += (bodytop.rotateAngleY * 2.0F);
		leftarm.rotateAngleZ -= (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationBuff() {
		rightarm.rotateAngleX = -0.698132F;
		leftarm.rotateAngleX = -0.698132F;
		rightarm.rotateAngleY = 0.698132F;
		leftarm.rotateAngleY = -0.698132F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
