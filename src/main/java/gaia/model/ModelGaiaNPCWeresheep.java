package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNPCWeresheep extends ModelGaia {
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
	private ModelRenderer bell;
	private ModelRenderer waist1;
	private ModelRenderer waist2;
	private ModelRenderer tail;
	private ModelRenderer rightlegbutton;
	private ModelRenderer leftlegbutton;
	private ModelRenderer rightleglower;
	private ModelRenderer leftleglower;

	public ModelGaiaNPCWeresheep() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(128, 64);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(128, 64);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(128, 64);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(128, 64);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(128, 64);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(128, 64);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(128, 64);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(128, 64);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(128, 64);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, 0F, -0.0872665F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, 0F, 0.0872665F, -0.0349066F);
		ModelRenderer hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4F, -6F, 1F, 8, 4, 3);
		hair1.setRotationPoint(0F, 1F, 0F);
		hair1.setTextureSize(128, 64);
		setRotation(hair1, 0F, 0F, 0F);
		ModelRenderer hair2 = new ModelRenderer(this, 36, 21);
		hair2.addBox(-4.5F, -3F, 1.5F, 9, 4, 3);
		hair2.setRotationPoint(0F, 1F, 0F);
		hair2.setTextureSize(128, 64);
		setRotation(hair2, 0F, 0F, 0F);
		ModelRenderer horn1 = new ModelRenderer(this, 36, 28);
		horn1.addBox(-4F, -9F, -5F, 8, 5, 5);
		horn1.setRotationPoint(0F, 1F, 0F);
		horn1.setTextureSize(128, 64);
		setRotation(horn1, 0F, 0F, 0F);
		ModelRenderer horn2 = new ModelRenderer(this, 36, 38);
		horn2.addBox(-5F, -8F, -4F, 10, 3, 3);
		horn2.setRotationPoint(0F, 1F, 0F);
		horn2.setTextureSize(128, 64);
		setRotation(horn2, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 44);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(128, 64);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 44);
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(128, 64);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		bell = new ModelRenderer(this, 36, 44);
		bell.addBox(-1F, 0F, -1.5F, 2, 2, 2);
		bell.setRotationPoint(0F, 3F, -1.5F);
		bell.setTextureSize(128, 64);
		setRotation(bell, -2.356194F, 0F, 0F);
		ModelRenderer rightarmupper = new ModelRenderer(this, 64, 4);
		rightarmupper.addBox(-2.5F, 0.1333333F, -1.5F, 3, 2, 3);
		rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmupper.setTextureSize(128, 64);
		setRotation(rightarmupper, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmupper = new ModelRenderer(this, 64, 4);
		leftarmupper.addBox(-0.5F, 0F, -1.5F, 3, 2, 3);
		leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmupper.setTextureSize(128, 64);
		setRotation(leftarmupper, 0F, 0F, -0.1745329F);
		ModelRenderer rightarmbutton = new ModelRenderer(this, 64, 0);
		rightarmbutton.addBox(-3F, 7.5F, -1F, 2, 2, 2);
		rightarmbutton.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmbutton.setTextureSize(128, 64);
		setRotation(rightarmbutton, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmbutton = new ModelRenderer(this, 64, 0);
		leftarmbutton.addBox(1F, 7.5F, -1F, 2, 2, 2);
		leftarmbutton.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmbutton.setTextureSize(128, 64);
		setRotation(leftarmbutton, 0F, 0F, -0.1745329F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 64, 9);
		rightarmlower.addBox(-2.5F, 5F, -1.5F, 3, 5, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmlower.setTextureSize(128, 64);
		setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 64, 9);
		leftarmlower.addBox(-0.5F, 5F, -1.5F, 3, 5, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmlower.setTextureSize(128, 64);
		setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		waist1 = new ModelRenderer(this, 64, 17);
		waist1.addBox(-3.5F, 7.5F, -3F, 7, 2, 6);
		waist1.setRotationPoint(0F, 1F, 0F);
		waist1.setTextureSize(128, 64);
		setRotation(waist1, 0F, 0F, 0F);
		waist2 = new ModelRenderer(this, 64, 25);
		waist2.addBox(-4F, 9F, -3.5F, 8, 4, 7);
		waist2.setRotationPoint(0F, 1F, 0F);
		waist2.setTextureSize(128, 64);
		setRotation(waist2, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 64, 36);
		tail.addBox(-1.5F, 10.5F, 3.5F, 3, 3, 3);
		tail.setRotationPoint(0F, 1F, 0F);
		tail.setTextureSize(128, 64);
		setRotation(tail, 0F, 0F, 0F);
		rightlegbutton = new ModelRenderer(this, 64, 0);
		rightlegbutton.addBox(-1F, 5.5F, -2.5F, 2, 2, 2);
		rightlegbutton.setRotationPoint(-2F, 11F, 0F);
		rightlegbutton.setTextureSize(128, 64);
		setRotation(rightlegbutton, 0F, -0.0872665F, 0F);
		leftlegbutton = new ModelRenderer(this, 64, 0);
		leftlegbutton.addBox(-1F, 5.5F, -2.5F, 2, 2, 2);
		leftlegbutton.setRotationPoint(2F, 11F, 0F);
		leftlegbutton.setTextureSize(128, 64);
		setRotation(leftlegbutton, 0F, 0.0872665F, 0F);
		rightleglower = new ModelRenderer(this, 94, 0);
		rightleglower.addBox(-2F, 5F, -2F, 4, 7, 4);
		rightleglower.setRotationPoint(-2F, 11F, 0F);
		rightleglower.setTextureSize(128, 64);
		setRotation(rightleglower, 0F, -0.0872665F, 0F);
		leftleglower = new ModelRenderer(this, 94, 0);
		leftleglower.addBox(-2F, 5F, -2F, 4, 7, 4);
		leftleglower.setRotationPoint(2F, 11F, 0F);
		leftleglower.setTextureSize(128, 64);
		setRotation(leftleglower, 0F, 0.0872665F, 0F);

		convertToChild(head, hair1);
		convertToChild(head, hair2);
		convertToChild(head, horn1);
		convertToChild(head, horn2);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightarmupper);
		convertToChild(rightarm, rightarmbutton);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmupper);
		convertToChild(leftarm, leftarmbutton);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightleg, rightlegbutton);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftlegbutton);
		convertToChild(leftleg, leftleglower);
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
		bell.render(scale);
		waist1.render(scale);
		waist2.render(scale);
		tail.render(scale);

		/*
		 * rightlegbutton.render(scale); leftlegbutton.render(scale); rightleglower.render(scale); leftleglower.render(scale);
		 */

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

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail.rotateAngleY = ((MathHelper.cos(limbSwing * 0.6662F) * 0.5F) / 4) * limbSwingAmount;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
