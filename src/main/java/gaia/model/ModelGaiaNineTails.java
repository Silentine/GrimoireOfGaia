package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNineTails extends ModelGaia {
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
	private ModelRenderer tie;
	private ModelRenderer tail1;
	private ModelRenderer tail2;

	public ModelGaiaNineTails() {
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
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, -0.0872665F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0.0872665F, 0.0349066F);
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
		ModelRenderer rightear = new ModelRenderer(this, 36, 37);
		rightear.addBox(-4.5F, -10F, -1.5F, 3, 4, 3);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		rightear.mirror = true;
		setRotation(rightear, 0F, 0F, 0.0872665F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 37);
		leftear.mirror = true;
		leftear.addBox(1.5F, -10F, -1.5F, 3, 4, 3);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0F, -0.0872665F);
		tie = new ModelRenderer(this, 64, 0);
		tie.addBox(-1.5F, 3F, -2.5F, 3, 2, 1);
		tie.setRotationPoint(0F, 1F, 0F);
		tie.setTextureSize(64, 32);
		setRotation(tie, 0F, 0F, 0F);
		ModelRenderer rightarmupper = new ModelRenderer(this, 64, 3);
		rightarmupper.addBox(-2.5F, 0.5F, -1.5F, 3, 10, 3);
		rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
		rightarmupper.setTextureSize(64, 32);
		setRotation(rightarmupper, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmupper = new ModelRenderer(this, 76, 3);
		leftarmupper.addBox(-0.5F, 0.5F, -1.5F, 3, 10, 3);
		leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
		leftarmupper.setTextureSize(64, 32);
		setRotation(leftarmupper, 0F, 0F, -0.1745329F);
		tail1 = new ModelRenderer(this, 64, 16);
		tail1.addBox(-3.5F, 6.5F, 2.5F, 7, 7, 4);
		tail1.setRotationPoint(0F, 1F, 0F);
		tail1.setTextureSize(64, 32);
		setRotation(tail1, -0.0872665F, 0F, 0F);
		tail2 = new ModelRenderer(this, 64, 27);
		tail2.addBox(-2.5F, 7F, 7F, 5, 5, 4);
		tail2.setRotationPoint(0F, 1F, 0F);
		tail2.setTextureSize(64, 32);
		setRotation(tail2, -0.1745329F, 0F, 0F);
		ModelRenderer rightlegcloth = new ModelRenderer(this, 88, 0);
		rightlegcloth.addBox(-2F, -1F, -2F, 4, 4, 4);
		rightlegcloth.setRotationPoint(-2F, 11F, 0F);
		rightlegcloth.setTextureSize(64, 32);
		setRotation(rightlegcloth, 0F, 0F, 0F);
		ModelRenderer leftlegcloth = new ModelRenderer(this, 104, 0);
		leftlegcloth.addBox(-2F, -1F, -2F, 4, 4, 4);
		leftlegcloth.setRotationPoint(2F, 11F, 0F);
		leftlegcloth.setTextureSize(64, 32);
		setRotation(leftlegcloth, 0F, 0F, 0F);
		ModelRenderer rightsandal = new ModelRenderer(this, 88, 8);
		rightsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		rightsandal.setRotationPoint(-2F, 11F, 0F);
		rightsandal.setTextureSize(64, 32);
		setRotation(rightsandal, 0F, -0.0872665F, -0.0349066F);
		ModelRenderer leftsandal = new ModelRenderer(this, 88, 8);
		leftsandal.addBox(-1.5F, 11F, -2F, 3, 1, 4);
		leftsandal.setRotationPoint(2F, 11F, 0F);
		leftsandal.setTextureSize(64, 32);
		setRotation(leftsandal, 0F, 0.0872665F, 0.0349066F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightarmupper);
		convertToChild(leftarm, leftarmupper);
		convertToChild(rightleg, rightlegcloth);
		convertToChild(rightleg, rightsandal);
		convertToChild(leftleg, leftlegcloth);
		convertToChild(leftleg, leftsandal);
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
		tie.render(scale);
		tail1.render(scale);
		tail2.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;
		hair1.rotateAngleY = head.rotateAngleY;
		hair2.rotateAngleY = head.rotateAngleY;

		// arms
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

		// body
		tail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		tail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);

		rightchest.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount) + 0.7853982F;
		leftchest.rotateAngleX = rightchest.rotateAngleX;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.1F * limbSwingAmount;
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
