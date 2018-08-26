package gaia.model;

import gaia.entity.monster.EntityGaiaSahuagin;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSahuagin extends ModelGaia {
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
	private ModelRenderer tail1;
	private ModelRenderer tail2;
	private ModelRenderer tail3;
	private ModelRenderer waist;

	public ModelGaiaSahuagin() {
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
		rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.2617994F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.2617994F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 29);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
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
		ModelRenderer rightear = new ModelRenderer(this, 36, 32);
		rightear.addBox(-4F, -6F, -1F, 0, 5, 5);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 32);
		leftear.addBox(4F, -6F, -1F, 0, 5, 5);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		ModelRenderer rightarmlower1 = new ModelRenderer(this, 64, 0);
		rightarmlower1.addBox(-4F, 2.5F, 0F, 2, 6, 0);
		rightarmlower1.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower1.setTextureSize(64, 32);
		setRotation(rightarmlower1, 0F, 0F, 0.2617994F);
		ModelRenderer leftarmlower1 = new ModelRenderer(this, 68, 0);
		leftarmlower1.addBox(2F, 2.5F, 0F, 2, 6, 0);
		leftarmlower1.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower1.setTextureSize(64, 32);
		setRotation(leftarmlower1, 0F, 0F, -0.2617994F);
		ModelRenderer rightarmlower2 = new ModelRenderer(this, 64, 6);
		rightarmlower2.addBox(-2.5F, 4F, -1.5F, 2, 6, 3);
		rightarmlower2.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower2.setTextureSize(64, 32);
		setRotation(rightarmlower2, 0F, 0F, 0.2617994F);
		ModelRenderer leftarmlower2 = new ModelRenderer(this, 74, 6);
		leftarmlower2.addBox(0.5F, 4F, -1.5F, 2, 6, 3);
		leftarmlower2.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower2.setTextureSize(64, 32);
		setRotation(leftarmlower2, 0F, 0F, -0.2617994F);
		ModelRenderer righthand = new ModelRenderer(this, 64, 15);
		righthand.addBox(-2.5F, 8.5F, -2F, 2, 4, 4);
		righthand.setRotationPoint(-2.5F, 2.5F, 0F);
		righthand.setTextureSize(64, 32);
		setRotation(righthand, 0F, 0F, 0.1745329F);
		ModelRenderer lefthand = new ModelRenderer(this, 76, 15);
		lefthand.addBox(0.5F, 8.5F, -2F, 2, 4, 4);
		lefthand.setRotationPoint(2.5F, 2.5F, 0F);
		lefthand.setTextureSize(64, 32);
		setRotation(lefthand, 0F, 0F, -0.1745329F);
		tail1 = new ModelRenderer(this, 64, 31);
		tail1.addBox(-1.5F, -1.5F, 0F, 3, 5, 3);
		tail1.setRotationPoint(0F, 9F, 1F);
		tail1.setTextureSize(64, 32);
		setRotation(tail1, 0.1745329F, 0F, 0F);
		tail2 = new ModelRenderer(this, 64, 39);
		tail2.addBox(-1F, 3.5F, 0.5F, 2, 5, 2);
		tail2.setRotationPoint(0F, 9F, 1F);
		tail2.setTextureSize(64, 32);
		setRotation(tail2, 0.2617994F, 0F, 0F);
		tail3 = new ModelRenderer(this, 64, 46);
		tail3.addBox(-0.5F, 8.5F, 0.5F, 1, 4, 1);
		tail3.setRotationPoint(0F, 9F, 1F);
		tail3.setTextureSize(64, 32);
		setRotation(tail3, 0.3490659F, 0F, 0F);
		waist = new ModelRenderer(this, 64, 23);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		ModelRenderer rightleglower1 = new ModelRenderer(this, 88, 0);
		rightleglower1.addBox(-3.5F, 5F, 0F, 2, 6, 0);
		rightleglower1.setRotationPoint(-2F, 11F, 0F);
		rightleglower1.setTextureSize(64, 32);
		setRotation(rightleglower1, 0F, 0F, 0F);
		ModelRenderer leftleglower1 = new ModelRenderer(this, 92, 0);
		leftleglower1.addBox(1.5F, 5F, 0F, 2, 6, 0);
		leftleglower1.setRotationPoint(2F, 11F, 0F);
		leftleglower1.setTextureSize(64, 32);
		setRotation(leftleglower1, 0F, 0F, 0F);
		ModelRenderer rightleglower2 = new ModelRenderer(this, 88, 6);
		rightleglower2.addBox(-2F, 10F, -2F, 4, 2, 4);
		rightleglower2.setRotationPoint(-2F, 11F, 0F);
		rightleglower2.setTextureSize(64, 32);
		setRotation(rightleglower2, 0F, 0F, 0F);
		ModelRenderer leftleglower2 = new ModelRenderer(this, 88, 6);
		leftleglower2.addBox(-2F, 10F, -2F, 4, 2, 4);
		leftleglower2.setRotationPoint(2F, 11F, 0F);
		leftleglower2.setTextureSize(64, 32);
		setRotation(leftleglower2, 0F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 88, 12);
		rightfoot.addBox(-2F, 12F, -3.5F, 4, 1, 4);
		rightfoot.setRotationPoint(-2F, 11F, 0F);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, 0F, 0F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 88, 12);
		leftfoot.addBox(-2F, 12F, -3.5F, 4, 1, 4);
		leftfoot.setRotationPoint(2F, 11F, 0F);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightarmlower1);
		convertToChild(rightarm, rightarmlower2);
		convertToChild(rightarm, righthand);
		convertToChild(leftarm, leftarmlower1);
		convertToChild(leftarm, leftarmlower2);
		convertToChild(leftarm, lefthand);
		convertToChild(rightleg, rightleglower1);
		convertToChild(rightleg, rightleglower2);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftleglower1);
		convertToChild(leftleg, leftleglower2);
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
		tail1.render(scale);
		tail2.render(scale);
		tail3.render(scale);
		waist.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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

		ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		EntityGaiaSahuagin entity = (EntityGaiaSahuagin) entityIn;

		if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail1.rotateAngleZ = MathHelper.cos(limbSwing * 0.6162F) * 0.1F * limbSwingAmount;
		tail2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6262F) * 0.1F * limbSwingAmount;
		tail3.rotateAngleZ = MathHelper.cos(limbSwing * 0.6362F) * 0.1F * limbSwingAmount;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2F);
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

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
