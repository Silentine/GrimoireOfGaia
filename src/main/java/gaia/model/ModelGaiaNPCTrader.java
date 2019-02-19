package gaia.model;

import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaNPCTrader extends ModelGaia {
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
	private ModelRenderer watch;
	private ModelRenderer tail;
	private ModelRenderer waist1;
	private ModelRenderer waist2;
	private ModelRenderer waist3;

	public ModelGaiaNPCTrader() {
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
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 8, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.3490659F, -0.0872665F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 8, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.3490659F, 0.0872665F, 0.0349066F);
		ModelRenderer righthair = new ModelRenderer(this, 36, 14);
		righthair.addBox(-5F, -5F, 1.5F, 3, 9, 3);
		righthair.setRotationPoint(0F, 1F, 0F);
		righthair.setTextureSize(64, 32);
		setRotation(righthair, 0F, 0.0872665F, 0.1745329F);
		ModelRenderer lefthair = new ModelRenderer(this, 36, 14);
		lefthair.addBox(2F, -5F, 1.5F, 3, 9, 3);
		lefthair.setRotationPoint(0F, 1F, 0F);
		lefthair.setTextureSize(64, 32);
		setRotation(lefthair, 0F, -0.0872665F, -0.1745329F);
		ModelRenderer righthairpin = new ModelRenderer(this, 36, 26);
		righthairpin.addBox(-6F, -8F, 1F, 4, 4, 4);
		righthairpin.setRotationPoint(0F, 1F, 0F);
		righthairpin.setTextureSize(64, 32);
		setRotation(righthairpin, 0F, 0F, 0.1745329F);
		ModelRenderer lefthairpin = new ModelRenderer(this, 52, 26);
		lefthairpin.addBox(2F, -8F, 1F, 4, 4, 4);
		lefthairpin.setRotationPoint(0F, 1F, 0F);
		lefthairpin.setTextureSize(64, 32);
		setRotation(lefthairpin, 0F, 0F, -0.1745329F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 34);
		rightear.addBox(-3F, -8.5F, -6F, 2, 8, 6);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, 0.2617994F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 34);
		leftear.addBox(1F, -8.5F, -6F, 2, 8, 6);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, -0.2617994F, 0F);
		ModelRenderer headnose = new ModelRenderer(this, 36, 48);
		headnose.addBox(-0.5F, -2.5F, -3.1F, 1, 1, 1);
		headnose.setRotationPoint(0F, 1F, 0F);
		headnose.setTextureSize(64, 32);
		setRotation(headnose, 0F, 0F, 0F);
		ModelRenderer headnoseshadow = new ModelRenderer(this, 36, 50);
		headnoseshadow.addBox(-0.5F, -4F, -3.2F, 1, 2, 1);
		headnoseshadow.setRotationPoint(0F, 1F, 0F);
		headnoseshadow.setTextureSize(64, 32);
		setRotation(headnoseshadow, 0F, 0F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 36, 53);
		rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		rightpauldron.setTextureSize(64, 32);
		setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 36, 53);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		leftpauldron.setTextureSize(64, 32);
		setRotation(leftpauldron, 0F, 0F, -0.1745329F);
		watch = new ModelRenderer(this, 68, 0);
		watch.addBox(-3F, 8F, -2.5F, 1, 5, 5);
		watch.setRotationPoint(0F, 1F, 0F);
		watch.setTextureSize(64, 32);
		setRotation(watch, 0F, 0F, 0.1745329F);
		tail = new ModelRenderer(this, 68, 10);
		tail.addBox(-1.5F, 6F, -5F, 3, 3, 3);
		tail.setRotationPoint(0F, 1F, 0F);
		tail.setTextureSize(64, 32);
		setRotation(tail, 0.7853982F, 0F, 0F);
		waist1 = new ModelRenderer(this, 68, 16);
		waist1.addBox(-3.5F, 8.5F, -3.5F, 7, 2, 7);
		waist1.setRotationPoint(0F, 1F, 0F);
		waist1.setTextureSize(64, 32);
		setRotation(waist1, 0F, 0F, 0F);
		waist2 = new ModelRenderer(this, 68, 25);
		waist2.addBox(-4F, 10.5F, -4F, 8, 3, 8);
		waist2.setRotationPoint(0F, 1F, 0F);
		waist2.setTextureSize(64, 32);
		setRotation(waist2, 0F, 0F, 0F);
		waist3 = new ModelRenderer(this, 68, 36);
		waist3.addBox(-4.5F, 13.5F, -4.5F, 9, 5, 9);
		waist3.setRotationPoint(0F, 1F, 0F);
		waist3.setTextureSize(64, 32);
		setRotation(waist3, 0F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 68, 50);
		rightleglower.addBox(-1.5F, 4.5F, 1.5F, 3, 8, 2);
		rightleglower.setRotationPoint(-2F, 11F, 0F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, -0.3490659F, -0.0872665F, -0.0349066F);
		ModelRenderer leftleglower = new ModelRenderer(this, 68, 50);
		leftleglower.addBox(-1.5F, 4.5F, 1.5F, 3, 8, 2);
		leftleglower.setRotationPoint(2F, 11F, 0F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, -0.3490659F, 0.0872665F, 0.0349066F);
		ModelRenderer rightfootlower = new ModelRenderer(this, 68, 60);
		rightfootlower.addBox(-1.5F, 11.5F, -5F, 3, 1, 3);
		rightfootlower.setRotationPoint(-2F, 11F, 0F);
		rightfootlower.setTextureSize(64, 32);
		setRotation(rightfootlower, 0.0872665F, -0.0872665F, -0.0349066F);
		ModelRenderer leftfootlower = new ModelRenderer(this, 68, 60);
		leftfootlower.addBox(-1.5F, 11.5F, -5F, 3, 1, 3);
		leftfootlower.setRotationPoint(2F, 11F, 0F);
		leftfootlower.setTextureSize(64, 32);
		setRotation(leftfootlower, 0.0872665F, 0.0872665F, 0.0349066F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(head, righthair);
		convertToChild(head, lefthair);
		convertToChild(head, headnose);
		convertToChild(head, headnoseshadow);
		convertToChild(head, righthairpin);
		convertToChild(head, lefthairpin);
		convertToChild(rightarm, rightpauldron);
		convertToChild(leftarm, leftpauldron);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfootlower);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfootlower);
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
		watch.render(scale);
		tail.render(scale);
		waist1.render(scale);
		waist2.render(scale);
		waist3.render(scale);

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
		tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 0.5F;
		rightleg.rotateAngleX -= 0.3490659F;
		leftleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount) * 0.5F;
		leftleg.rotateAngleX -= 0.3490659F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
