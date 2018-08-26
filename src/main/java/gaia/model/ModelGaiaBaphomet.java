package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBaphomet extends ModelGaia {

	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer mantle;
	private ModelRenderer mantlefront;
	private ModelRenderer cloak1;
	private ModelRenderer cloak2;
	private ModelRenderer cloak3;
	private ModelRenderer waist;

	public ModelGaiaBaphomet() {
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
		bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 2F, 0F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 2F, 0F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
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
		rightleg.addBox(-1.5F, -1F, -1F, 3, 14, 3);
		rightleg.setRotationPoint(-2F, 11F, -0.5F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1F, 3, 14, 3);
		leftleg.setRotationPoint(2F, 11F, -0.5F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, 0F, 0F, 0F);
		ModelRenderer righthairclip = new ModelRenderer(this, 36, 14);
		righthairclip.addBox(-5.5F, -5F, 2.533333F, 3, 5, 3);
		righthairclip.setRotationPoint(0F, 1F, 0F);
		righthairclip.setTextureSize(64, 32);
		setRotation(righthairclip, 0.1745329F, 0F, 0.1745329F);
		ModelRenderer lefthairclip = new ModelRenderer(this, 48, 14);
		lefthairclip.addBox(2.5F, -5F, 2.5F, 3, 5, 3);
		lefthairclip.setRotationPoint(0F, 1F, 0F);
		lefthairclip.setTextureSize(64, 32);
		setRotation(lefthairclip, 0.1745329F, 0F, -0.1745329F);
		ModelRenderer righthair = new ModelRenderer(this, 36, 22);
		righthair.addBox(-5F, -4.5F, 3F, 2, 10, 2);
		righthair.setRotationPoint(0F, 1F, 0F);
		righthair.setTextureSize(64, 32);
		setRotation(righthair, 0.1745329F, 0F, 0.1745329F);
		ModelRenderer lefthair = new ModelRenderer(this, 36, 22);
		lefthair.addBox(3F, -4.5F, 3F, 2, 10, 2);
		lefthair.setRotationPoint(0F, 1F, 0F);
		lefthair.setTextureSize(64, 32);
		setRotation(lefthair, 0.1745329F, 0F, -0.1745329F);
		ModelRenderer righthorn1 = new ModelRenderer(this, 36, 34);
		righthorn1.addBox(-3F, -8F, 0F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, 1F, 0F);
		righthorn1.setTextureSize(64, 32);
		setRotation(righthorn1, 0F, 0F, 0F);
		ModelRenderer righthorn2 = new ModelRenderer(this, 36, 38);
		righthorn2.addBox(-4F, -9F, 1F, 2, 2, 4);
		righthorn2.setRotationPoint(0F, 1F, 0F);
		righthorn2.setTextureSize(64, 32);
		setRotation(righthorn2, 0F, 0F, 0F);
		ModelRenderer righthorn3 = new ModelRenderer(this, 36, 44);
		righthorn3.addBox(-3F, -8F, 4F, 2, 2, 2);
		righthorn3.setRotationPoint(0F, 1F, 0F);
		righthorn3.setTextureSize(64, 32);
		setRotation(righthorn3, 0F, 0F, 0F);
		ModelRenderer righthorn4 = new ModelRenderer(this, 36, 48);
		righthorn4.addBox(-1.5F, -6.5F, 4.5F, 1, 1, 1);
		righthorn4.setRotationPoint(0F, 1F, 0F);
		righthorn4.setTextureSize(64, 32);
		setRotation(righthorn4, 0F, 0F, 0F);
		ModelRenderer lefthorn1 = new ModelRenderer(this, 36, 34);
		lefthorn1.mirror = true;
		lefthorn1.addBox(1F, -8F, 0F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, 1F, 0F);
		lefthorn1.setTextureSize(64, 32);
		setRotation(lefthorn1, 0F, 0F, 0F);
		ModelRenderer lefthorn2 = new ModelRenderer(this, 36, 38);
		lefthorn2.mirror = true;
		lefthorn2.addBox(2F, -9F, 1F, 2, 2, 4);
		lefthorn2.setRotationPoint(0F, 1F, 0F);
		lefthorn2.setTextureSize(64, 32);
		setRotation(lefthorn2, 0F, 0F, 0F);
		ModelRenderer lefthorn3 = new ModelRenderer(this, 36, 44);
		lefthorn3.mirror = true;
		lefthorn3.addBox(1F, -8F, 4F, 2, 2, 2);
		lefthorn3.setRotationPoint(0F, 1F, 0F);
		lefthorn3.setTextureSize(64, 32);
		setRotation(lefthorn3, 0F, 0F, 0F);
		ModelRenderer lefthorn4 = new ModelRenderer(this, 36, 48);
		lefthorn4.mirror = true;
		lefthorn4.addBox(0.5F, -6.5F, 4.5F, 1, 1, 1);
		lefthorn4.setRotationPoint(0F, 1F, 0F);
		lefthorn4.setTextureSize(64, 32);
		setRotation(lefthorn4, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 46);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 46);
		leftear.mirror = true;
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		rightear = new ModelRenderer(this, 36, 42);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		leftear = new ModelRenderer(this, 36, 42);
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		mantle = new ModelRenderer(this, 64, 0);
		mantle.addBox(-5F, 0F, -0.5F, 10, 3, 3);
		mantle.setRotationPoint(0F, 1F, 0F);
		mantle.setTextureSize(64, 32);
		setRotation(mantle, 0F, 0F, 0F);
		mantlefront = new ModelRenderer(this, 64, 6);
		mantlefront.addBox(-4F, 0F, -2F, 8, 3, 3);
		mantlefront.setRotationPoint(0F, 1F, 0F);
		mantlefront.setTextureSize(64, 32);
		setRotation(mantlefront, 0F, 0F, 0F);
		cloak1 = new ModelRenderer(this, 64, 12);
		cloak1.addBox(-4.5F, 1F, -0.5F, 9, 4, 3);
		cloak1.setRotationPoint(0F, 1F, 0F);
		cloak1.setTextureSize(64, 32);
		setRotation(cloak1, 0.2617994F, 0F, 0F);
		cloak2 = new ModelRenderer(this, 64, 19);
		cloak2.addBox(-5F, 4.5F, 0.5F, 10, 6, 3);
		cloak2.setRotationPoint(0F, 1F, 0F);
		cloak2.setTextureSize(64, 32);
		setRotation(cloak2, 0.1745329F, 0F, 0F);
		cloak3 = new ModelRenderer(this, 64, 28);
		cloak3.addBox(-5.5F, 10F, 2F, 11, 8, 3);
		cloak3.setRotationPoint(0F, 1F, 0F);
		cloak3.setTextureSize(64, 32);
		setRotation(cloak3, 0.0872665F, 0F, 0F);
		ModelRenderer righthand = new ModelRenderer(this, 64, 39);
		righthand.addBox(-2.5F, 6F, -1.5F, 3, 5, 3);
		righthand.setRotationPoint(-2.5F, 2.5F, 0F);
		righthand.setTextureSize(64, 32);
		setRotation(righthand, 0F, 0F, 0.1745329F);
		ModelRenderer lefthand = new ModelRenderer(this, 76, 39);
		lefthand.addBox(-0.5F, 6F, -1.5F, 3, 5, 3);
		lefthand.setRotationPoint(2.5F, 2.5F, 0F);
		lefthand.setTextureSize(64, 32);
		setRotation(lefthand, 0F, 0F, -0.1745329F);
		waist = new ModelRenderer(this, 64, 47);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, 0F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.0872665F, 0F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 92, 0);
		rightfoot.addBox(-2F, 5F, -1.5F, 4, 8, 4);
		rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		rightfoot.setTextureSize(64, 32);
		setRotation(rightfoot, 0F, 0F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 108, 0);
		leftfoot.addBox(-2F, 5F, -1.5F, 4, 8, 4);
		leftfoot.setRotationPoint(2F, 11F, -0.5F);
		leftfoot.setTextureSize(64, 32);
		setRotation(leftfoot, 0F, 0F, 0F);

		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, righthorn4);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, lefthorn4);
		convertToChild(head, righthairclip);
		convertToChild(head, righthair);
		convertToChild(head, lefthairclip);
		convertToChild(head, lefthair);
		convertToChild(rightarm, righthand);
		convertToChild(leftarm, lefthand);
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
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		mantle.render(scale);
		mantlefront.render(scale);
		cloak1.render(scale);
		cloak2.render(scale);
		cloak3.render(scale);
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
		cloak1.rotateAngleZ = MathHelper.cos(limbSwing * 0.6162F) * 0.1F * limbSwingAmount;
		cloak2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6262F) * 0.1F * limbSwingAmount;
		cloak3.rotateAngleZ = MathHelper.cos(limbSwing * 0.6362F) * 0.1F * limbSwingAmount;

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

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
