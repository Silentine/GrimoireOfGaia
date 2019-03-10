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
public class ModelGaiaOrc extends ModelGaia {
	ModelRenderer head;
	ModelRenderer neck;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public ModelGaiaOrc() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, -2F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		ModelRenderer headaccessory = new ModelRenderer(this, 64, 0);
		headaccessory.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9);
		headaccessory.setRotationPoint(0F, -2F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		ModelRenderer headjaw = new ModelRenderer(this, 64, 18);
		headjaw.addBox(-4.5F, -0.5F, -4.5F, 9, 3, 4);
		headjaw.setRotationPoint(0F, -2F, 0F);
		headjaw.setTextureSize(64, 32);
		setRotation(headjaw, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 64, 39);
		neck.addBox(-2F, -4F, -2F, 4, 4, 4);
		neck.setRotationPoint(0F, -2F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 16);
		body.addBox(-5F, 0F, -2F, 10, 14, 4);
		body.setRotationPoint(0F, -2F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0F, 0F, 0F);
		ModelRenderer rightarmpauldron = new ModelRenderer(this, 100, 0);
		rightarmpauldron.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
		rightarmpauldron.setRotationPoint(-6F, 0F, 0F);
		rightarmpauldron.setTextureSize(64, 32);
		setRotation(rightarmpauldron, 0F, 0F, 0F);
		ModelRenderer leftarmpauldron = new ModelRenderer(this, 100, 10);
		leftarmpauldron.mirror = true;
		leftarmpauldron.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
		leftarmpauldron.setRotationPoint(6F, 0F, 0F);
		leftarmpauldron.setTextureSize(64, 32);
		setRotation(leftarmpauldron, 0F, 0F, 0F);
		ModelRenderer rightarmhorn = new ModelRenderer(this, 100, 20);
		rightarmhorn.addBox(-4.5F, -3.5F, -1.5F, 3, 3, 3);
		rightarmhorn.setRotationPoint(-6F, 0F, 0F);
		rightarmhorn.setTextureSize(64, 32);
		setRotation(rightarmhorn, 0F, 0F, 0F);
		ModelRenderer leftarmhorn = new ModelRenderer(this, 100, 26);
		leftarmhorn.mirror = true;
		leftarmhorn.addBox(1.5F, -3.5F, -1.5F, 3, 3, 3);
		leftarmhorn.setRotationPoint(6F, 0F, 0F);
		leftarmhorn.setTextureSize(64, 32);
		setRotation(leftarmhorn, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 28, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 14, 4);
		rightarm.setRotationPoint(-6F, 0F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 28, 16);
		leftarm.mirror = true;
		leftarm.addBox(-1F, -2F, -2F, 4, 14, 4);
		leftarm.setRotationPoint(6F, 0F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, 0F);
		ModelRenderer rightarmgauntlet = new ModelRenderer(this, 100, 32);
		rightarmgauntlet.addBox(-3.5F, 7.5F, -2.5F, 5, 5, 5);
		rightarmgauntlet.setRotationPoint(-6F, 0F, 0F);
		rightarmgauntlet.setTextureSize(64, 32);
		setRotation(rightarmgauntlet, 0F, 0F, 0F);
		ModelRenderer leftarmgauntlet = new ModelRenderer(this, 100, 32);
		leftarmgauntlet.mirror = true;
		leftarmgauntlet.addBox(-1.5F, 7.5F, -2.5F, 5, 5, 5);
		leftarmgauntlet.setRotationPoint(6F, 0F, 0F);
		leftarmgauntlet.setTextureSize(64, 32);
		setRotation(leftarmgauntlet, 0F, 0F, 0F);
		ModelRenderer rightlegupper = new ModelRenderer(this, 100, 42);
		rightlegupper.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
		rightlegupper.setRotationPoint(-2F, 12F, 0F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, 0F, 0F, 0F);
		ModelRenderer leftlegupper = new ModelRenderer(this, 100, 42);
		leftlegupper.mirror = true;
		leftlegupper.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
		leftlegupper.setRotationPoint(2F, 12F, 0F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 44, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 44, 16);
		leftleg.mirror = true;
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		ModelRenderer rightlegboot = new ModelRenderer(this, 100, 52);
		rightlegboot.addBox(-2.5F, 7F, -2.5F, 5, 5, 5);
		rightlegboot.setRotationPoint(-2F, 12F, 0F);
		rightlegboot.setTextureSize(64, 32);
		setRotation(rightlegboot, 0F, 0F, 0F);
		ModelRenderer leftlegboot = new ModelRenderer(this, 100, 52);
		leftlegboot.addBox(-2.5F, 7F, -2.5F, 5, 5, 5);
		leftlegboot.setRotationPoint(2F, 12F, 0F);
		leftlegboot.setTextureSize(64, 32);
		setRotation(leftlegboot, 0F, 0F, 0F);
		ModelRenderer righthorn1 = new ModelRenderer(this, 64, 25);
		righthorn1.addBox(-5.5F, -8.5F, -2.5F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, -2F, 0F);
		righthorn1.setTextureSize(64, 32);
		setRotation(righthorn1, 0F, 0F, 0F);
		ModelRenderer righthorn2 = new ModelRenderer(this, 64, 29);
		righthorn2.addBox(-6.5F, -10.5F, -1.5F, 3, 3, 3);
		righthorn2.setRotationPoint(0F, -2F, 0F);
		righthorn2.setTextureSize(64, 32);
		setRotation(righthorn2, 0F, 0F, 0F);
		ModelRenderer righthorn3 = new ModelRenderer(this, 64, 35);
		righthorn3.addBox(-4.5F, -11.5F, -2.5F, 2, 2, 2);
		righthorn3.setRotationPoint(0F, -2F, 0F);
		righthorn3.setTextureSize(64, 32);
		setRotation(righthorn3, 0F, 0F, 0F);
		ModelRenderer lefthorn1 = new ModelRenderer(this, 64, 25);
		lefthorn1.mirror = true;
		lefthorn1.addBox(4.5F, -8.5F, -2.5F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, -2F, 0F);
		lefthorn1.setTextureSize(64, 32);
		setRotation(lefthorn1, 0F, 0F, 0F);
		ModelRenderer lefthorn2 = new ModelRenderer(this, 64, 29);
		lefthorn2.mirror = true;
		lefthorn2.addBox(4.5F, -10.5F, -1.5F, 3, 3, 3);
		lefthorn2.setRotationPoint(0F, -2F, 0F);
		lefthorn2.setTextureSize(64, 32);
		setRotation(lefthorn2, 0F, 0F, 0F);
		ModelRenderer lefthorn3 = new ModelRenderer(this, 64, 35);
		lefthorn3.mirror = true;
		lefthorn3.addBox(3.5F, -11.5F, -2.5F, 2, 2, 2);
		lefthorn3.setRotationPoint(0F, -2F, 0F);
		lefthorn3.setTextureSize(64, 32);
		setRotation(lefthorn3, 0F, 0F, 0F);

		convertToChild(head, headaccessory);
		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, headjaw);
		convertToChild(rightarm, rightarmpauldron);
		convertToChild(leftarm, leftarmpauldron);
		convertToChild(rightarm, rightarmhorn);
		convertToChild(leftarm, leftarmhorn);
		convertToChild(rightarm, rightarmgauntlet);
		convertToChild(leftarm, leftarmgauntlet);
		convertToChild(rightleg, rightlegupper);
		convertToChild(leftleg, leftlegupper);
		convertToChild(rightleg, rightlegboot);
		convertToChild(leftleg, leftlegboot);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		body.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;

		// arms
		if (itemstack.isEmpty()) {
			rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
			leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

			rightarm.rotateAngleZ = 0.0F;
			leftarm.rotateAngleZ = 0.0F;

			if (swingProgress > -9990.0F) {
				holdingMelee();
			}

			rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
			leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}

		if (itemstack.getItem() == Items.ARROW) {
			animationThrow();
		}

		if (itemstack.getItem() == Items.STICK) {
			animationBuff();
		}

		// legs (walk_normal)
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
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
		rightarm.rotateAngleX += (body.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	private void animationThrow() {
		rightarm.rotateAngleX = -1.0472F;
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
