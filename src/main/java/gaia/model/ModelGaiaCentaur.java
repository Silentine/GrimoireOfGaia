package gaia.model;

import gaia.entity.monster.EntityGaiaCentaur;
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
public class ModelGaiaCentaur extends ModelGaia {

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
	private ModelRenderer hair1;
	private ModelRenderer hair2;
	private ModelRenderer saddle1;
	private ModelRenderer saddle2;
	private ModelRenderer saddle3;
	private ModelRenderer front;
	private ModelRenderer body1;
	private ModelRenderer body2;
	private ModelRenderer rightsaddlestrap1;
	private ModelRenderer leftsaddlestrap1;
	private ModelRenderer rightlegupper;
	private ModelRenderer leftlegupper;
	private ModelRenderer rightlegback1;
	private ModelRenderer leftlegback1;
	private ModelRenderer tail;

	public ModelGaiaCentaur() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, -6F, -7.5F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, -6F, -7.5F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, -6F, -7.5F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, -6F, -7.5F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -2F, 5, 6, 3);
		bodytop.setRotationPoint(0F, -6F, -7F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -2F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, -6F, -7F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5.5F, -2.1F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, -5.5F, -7F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -3F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, -6F, -7F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, -4F, -9F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, -4F, -9F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, -5F, -7.5F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 36);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, -5F, -7.5F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair1.setRotationPoint(0F, -6F, -7.5F);
		hair1.setTextureSize(64, 32);
		setRotation(hair1, 0F, 0F, 0F);
		hair2 = new ModelRenderer(this, 36, 25);
		hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		hair2.setRotationPoint(0F, -6F, -7.5F);
		hair2.setTextureSize(64, 32);
		setRotation(hair2, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 33);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, -6F, -7.5F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 33);
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, -6F, -7.5F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 36, 41);
		rightpauldron.addBox(-3F, -1.5F, -2F, 4, 3, 4);
		rightpauldron.setRotationPoint(-2.5F, -5F, -7.5F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		ModelRenderer rightarmguard = new ModelRenderer(this, 36, 48);
		rightarmguard.addBox(-2.5F, 5F, -1.5F, 3, 4, 3);
		rightarmguard.setRotationPoint(-2.5F, -5F, -7.5F);
		rightarmguard.setTextureSize(64, 32);
		setRotation(rightarmguard, 0F, 0F, 0.1745329F);
		saddle1 = new ModelRenderer(this, 36, 55);
		saddle1.addBox(-4F, 13.5F, 5F, 8, 1, 8);
		saddle1.setRotationPoint(0F, -10F, -8F);
		saddle1.setTextureSize(64, 32);
		setRotation(saddle1, 0F, 0F, 0F);
		saddle2 = new ModelRenderer(this, 68, 0);
		saddle2.addBox(-1F, 12.5F, 5F, 2, 1, 2);
		saddle2.setRotationPoint(0F, -10F, -8F);
		saddle2.setTextureSize(64, 32);
		setRotation(saddle2, 0F, 0F, 0F);
		saddle3 = new ModelRenderer(this, 76, 0);
		saddle3.addBox(-3F, 12.5F, 11F, 6, 1, 2);
		saddle3.setRotationPoint(0F, -10F, -8F);
		saddle3.setTextureSize(64, 32);
		setRotation(saddle3, 0F, 0F, 0F);
		front = new ModelRenderer(this, 68, 10);
		front.addBox(-3.5F, 7.5F, -2F, 7, 10, 3);
		front.setRotationPoint(0F, -6F, -7F);
		front.setTextureSize(64, 32);
		setRotation(front, -0.0872665F, 0F, 0F);
		body1 = new ModelRenderer(this, 68, 23);
		body1.addBox(-4F, 14F, 0F, 8, 9, 9);
		body1.setRotationPoint(0F, -10F, -8F);
		body1.setTextureSize(64, 32);
		setRotation(body1, -0.0872665F, 0F, 0F);
		body2 = new ModelRenderer(this, 68, 41);
		body2.addBox(-3.5F, 15.5F, 5F, 7, 8, 12);
		body2.setRotationPoint(0F, -10F, -8F);
		body2.setTextureSize(64, 32);
		setRotation(body2, 0.0872665F, 0F, 0F);
		rightsaddlestrap1 = new ModelRenderer(this, 68, 3);
		rightsaddlestrap1.addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1);
		rightsaddlestrap1.setRotationPoint(-4F, 4F, 0F);
		rightsaddlestrap1.setTextureSize(64, 32);
		setRotation(rightsaddlestrap1, 0F, 0F, 0F);
		leftsaddlestrap1 = new ModelRenderer(this, 68, 3);
		leftsaddlestrap1.addBox(-0.5F, -0.5F, -0.5F, 1, 6, 1);
		leftsaddlestrap1.setRotationPoint(4F, 4F, 0F);
		leftsaddlestrap1.setTextureSize(64, 32);
		setRotation(leftsaddlestrap1, 0F, 0F, 0F);
		ModelRenderer rightsaddlestrap2 = new ModelRenderer(this, 72, 3);
		rightsaddlestrap2.addBox(-0.5F, 5.5F, -1F, 1, 2, 2);
		rightsaddlestrap2.setRotationPoint(-4F, 4F, 0F);
		rightsaddlestrap2.setTextureSize(64, 32);
		setRotation(rightsaddlestrap2, 0F, 0F, 0F);
		ModelRenderer leftsaddlestrap2 = new ModelRenderer(this, 72, 3);
		leftsaddlestrap2.addBox(-0.5F, 5.5F, -1F, 1, 2, 2);
		leftsaddlestrap2.setRotationPoint(4F, 4F, 0F);
		leftsaddlestrap2.setTextureSize(64, 32);
		setRotation(leftsaddlestrap2, 0F, 0F, 0F);
		rightlegupper = new ModelRenderer(this, 106, 0);
		rightlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		rightlegupper.setRotationPoint(-4F, 9F, -7F);
		rightlegupper.setTextureSize(64, 32);
		setRotation(rightlegupper, 0F, 0F, -0.0872665F);
		leftlegupper = new ModelRenderer(this, 106, 0);
		leftlegupper.addBox(-1.466667F, -1.5F, -1.5F, 3, 8, 3);
		leftlegupper.setRotationPoint(4F, 9F, -7F);
		leftlegupper.setTextureSize(64, 32);
		setRotation(leftlegupper, 0F, 0F, 0.0872665F);
		ModelRenderer rightlegbracelet = new ModelRenderer(this, 106, 11);
		rightlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		rightlegbracelet.setRotationPoint(-4F, 9F, -7F);
		rightlegbracelet.setTextureSize(64, 32);
		setRotation(rightlegbracelet, 0F, 0F, -0.0872665F);
		ModelRenderer leftlegbracelet = new ModelRenderer(this, 106, 11);
		leftlegbracelet.addBox(-1.5F, 10.5F, -1F, 3, 2, 3);
		leftlegbracelet.setRotationPoint(4F, 9F, -7F);
		leftlegbracelet.setTextureSize(64, 32);
		setRotation(leftlegbracelet, 0F, 0F, 0.0872665F);
		ModelRenderer rightleglower = new ModelRenderer(this, 106, 16);
		rightleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		rightleglower.setRotationPoint(-4F, 9F, -7F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, 0F, 0F, -0.0872665F);
		ModelRenderer leftleglower = new ModelRenderer(this, 106, 16);
		leftleglower.addBox(-1F, 6.5F, -0.5F, 2, 8, 2);
		leftleglower.setRotationPoint(4F, 9F, -7F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, 0F, 0F, 0.0872665F);
		rightlegback1 = new ModelRenderer(this, 106, 26);
		rightlegback1.addBox(-0.5F, -2.5F, -1.5F, 3, 8, 6);
		rightlegback1.setRotationPoint(-4F, 7F, 7F);
		rightlegback1.setTextureSize(64, 32);
		setRotation(rightlegback1, -0.296706F, 0F, -0.0872665F);
		leftlegback1 = new ModelRenderer(this, 106, 26);
		leftlegback1.addBox(-2.5F, -2.5F, -1.5F, 3, 8, 6);
		leftlegback1.setRotationPoint(4F, 7F, 7F);
		leftlegback1.setTextureSize(64, 32);
		setRotation(leftlegback1, -0.296706F, 0F, 0.0872665F);
		ModelRenderer rightlegback2 = new ModelRenderer(this, 106, 40);
		rightlegback2.addBox(-1.5F, 2F, 2.5F, 3, 3, 6);
		rightlegback2.setRotationPoint(-4F, 7F, 7F);
		rightlegback2.setTextureSize(64, 32);
		setRotation(rightlegback2, -1.047198F, 0F, -0.0872665F);
		ModelRenderer leftlegback2 = new ModelRenderer(this, 106, 40);
		leftlegback2.addBox(-1.5F, 2F, 2.5F, 3, 3, 6);
		leftlegback2.setRotationPoint(4F, 7F, 7F);
		leftlegback2.setTextureSize(64, 32);
		setRotation(leftlegback2, -1.047198F, 0F, 0.0872665F);
		ModelRenderer rightlegback3 = new ModelRenderer(this, 106, 49);
		rightlegback3.addBox(-1F, 8F, 1.5F, 2, 8, 2);
		rightlegback3.setRotationPoint(-4F, 7F, 7F);
		rightlegback3.setTextureSize(64, 32);
		setRotation(rightlegback3, -0.122173F, 0F, -0.0872665F);
		ModelRenderer leftlegback3 = new ModelRenderer(this, 106, 49);
		leftlegback3.addBox(-1F, 8F, 1.5F, 2, 8, 2);
		leftlegback3.setRotationPoint(4F, 7F, 7F);
		leftlegback3.setTextureSize(64, 32);
		setRotation(leftlegback3, -0.122173F, 0F, 0.0872665F);
		tail = new ModelRenderer(this, 106, 51);
		tail.addBox(-1F, -1F, -0.5F, 2, 2, 8);
		tail.setRotationPoint(0F, 6F, 10F);
		tail.setTextureSize(64, 32);
		setRotation(tail, -1.047198F, 0F, 0F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightpauldron);
		convertToChild(rightarm, rightarmguard);
		convertToChild(rightlegupper, rightlegbracelet);
		convertToChild(rightlegupper, rightleglower);
		convertToChild(leftlegupper, leftlegbracelet);
		convertToChild(leftlegupper, leftleglower);
		convertToChild(rightsaddlestrap1, rightsaddlestrap2);
		convertToChild(leftsaddlestrap1, leftsaddlestrap2);
		convertToChild(rightlegback1, rightlegback2);
		convertToChild(rightlegback1, rightlegback3);
		convertToChild(leftlegback1, leftlegback2);
		convertToChild(leftlegback1, leftlegback3);
	}

	@Override
	public void render(Entity entity, float limbSwingAmount, float ageInTicks, float par4, float par5, float par6, float par7) {
		super.render(entity, limbSwingAmount, ageInTicks, par4, par5, par6, par7);
		setRotationAngles(limbSwingAmount, ageInTicks, par4, par5, par6, par7, entity);
		head.render(par7);
		headaccessory.render(par7);
		neck.render(par7);
		bodytop.render(par7);
		bodymiddle.render(par7);
		bodymiddlebutton.render(par7);
		bodybottom.render(par7);
		rightchest.render(par7);
		leftchest.render(par7);
		rightarm.render(par7);
		leftarm.render(par7);
		hair1.render(par7);
		hair2.render(par7);
		saddle1.render(par7);
		saddle2.render(par7);
		saddle3.render(par7);
		front.render(par7);
		body1.render(par7);
		body2.render(par7);
		rightsaddlestrap1.render(par7);
		leftsaddlestrap1.render(par7);
		rightlegupper.render(par7);
		leftlegupper.render(par7);
		rightlegback1.render(par7);
		leftlegback1.render(par7);
		tail.render(par7);

		if (entity.ticksExisted % 60 == 0 && ageInTicks <= 0.1F) {
			headeyes.render(par7);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		ItemStack itemstack = ((EntityLivingBase) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack equipstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		EntityGaiaCentaur entity = (EntityGaiaCentaur) entityIn;

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
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		if (entity.isHoldingBow() && (equipstack.getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		if (itemstack.getItem() == Items.FEATHER) {
			animationPotion();
		}

		// body
		rightsaddlestrap1.rotateAngleX = MathHelper.cos(limbSwing * 0.7862F) * 0.4F * limbSwingAmount;
		leftsaddlestrap1.rotateAngleX = MathHelper.cos(limbSwing * 0.7862F) * 0.4F * limbSwingAmount;
		tail.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(10);

		// legs
		rightlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.7862F) * 0.8F * limbSwingAmount;
		leftlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightlegback1.rotateAngleX = MathHelper.cos(limbSwing * 0.7662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		rightlegback1.rotateAngleX -= 0.296706F;
		leftlegback1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftlegback1.rotateAngleX -= 0.296706F;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2.2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2.2F);
		rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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
		if ((rightlegupper.rotateAngleX != 0.0F) || (leftlegupper.rotateAngleX != 0.0F)) {
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
