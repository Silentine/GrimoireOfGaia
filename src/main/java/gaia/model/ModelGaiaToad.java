package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaToad extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
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
	private ModelRenderer necktie;
	private ModelRenderer rightarmlower;
	private ModelRenderer leftarmlower;
	private ModelRenderer tail;
	private ModelRenderer rightleglower;
	private ModelRenderer leftleglower;

	public ModelGaiaToad() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 13F, -8F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 13F, -8F);
		setRotation(headeyes, 0F, 0F, 0F);
		ModelRenderer headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 13F, -8F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 13F, -8F);
		setRotation(neck, 1.134464F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 13F, -8F);
		setRotation(bodytop, 1.134464F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 13F, -8F);
		setRotation(bodymiddle, 1.22173F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 13F, -8F);
		setRotation(bodymiddlebutton, 1.22173F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 13F, -8F);
		setRotation(bodybottom, 1.308997F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 15F, -7F);
		setRotation(rightchest, 1.919862F, -0.0872665F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 15F, -7F);
		setRotation(leftchest, 1.919862F, 0.0872665F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-2.5F, 14F, -7F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, 14F, -7F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 7, 3);
		rightleg.setRotationPoint(-2.5F, 17F, 2F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 7, 3);
		leftleg.setRotationPoint(2.5F, 17F, 2F);
		setRotation(leftleg, 0F, 0F, 0F);
		ModelRenderer headrighteye = new ModelRenderer(this, 36, 14);
		headrighteye.addBox(-4.5F, -7.5F, -4.5F, 3, 3, 3);
		headrighteye.setRotationPoint(0F, 13F, -8F);
		setRotation(headrighteye, 0F, 0F, 0F);
		ModelRenderer headlefteye = new ModelRenderer(this, 36, 14);
		headlefteye.mirror = true;
		headlefteye.addBox(1.5F, -7.5F, -4.5F, 3, 3, 3);
		headlefteye.setRotationPoint(0F, 13F, -8F);
		setRotation(headlefteye, 0F, 0F, 0F);
		necktie = new ModelRenderer(this, 36, 20);
		necktie.addBox(-1F, 0.5F, -1.4F, 2, 2, 0);
		necktie.setRotationPoint(0F, 13F, -8F);
		setRotation(necktie, 0F, 0F, 0F);
		ModelRenderer necktietip = new ModelRenderer(this, 36, 22);
		necktietip.addBox(-1F, 2.5F, -1.9F, 2, 2, 1);
		necktietip.setRotationPoint(0F, 13F, -8F);
		setRotation(necktietip, 0F, 0F, 0F);
		rightarmlower = new ModelRenderer(this, 16, 20);
		rightarmlower.addBox(0F, 0F, -1F, 2, 6, 2);
		rightarmlower.setRotationPoint(-4.5F, 19F, -7F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new ModelRenderer(this, 16, 20);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-2F, 0F, -1F, 2, 6, 2);
		leftarmlower.setRotationPoint(4.5F, 19F, -7F);
		leftarmlower.mirror = true;
		setRotation(leftarmlower, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 36, 25);
		tail.addBox(-3.5F, 9F, -1F, 7, 5, 2);
		tail.setRotationPoint(0F, 13F, -8F);
		setRotation(tail, 1.308997F, 0F, 0F);
		rightleglower = new ModelRenderer(this, 24, 22);
		rightleglower.addBox(-1.45F, 0F, 0F, 3, 7, 3);
		rightleglower.setRotationPoint(-2.5F, 23F, 0.5F);
		setRotation(rightleglower, 0F, 0F, 0F);
		leftleglower = new ModelRenderer(this, 24, 22);
		leftleglower.mirror = true;
		leftleglower.addBox(-1.55F, 0F, 0F, 3, 7, 3);
		leftleglower.setRotationPoint(2.5F, 23F, 0.5F);
		setRotation(leftleglower, 0F, 0F, 0F);

		convertToChild(head, headaccessory);
		convertToChild(head, headrighteye);
		convertToChild(head, headlefteye);
		convertToChild(necktie, necktietip);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
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
		necktie.render(scale);
		tail.render(scale);

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

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = degToRad(15);
		leftarm.rotateAngleZ = -degToRad(15);
		rightarmlower.rotateAngleZ = -degToRad(30);
		leftarmlower.rotateAngleZ = degToRad(30);

		// body
		for (int k = 1; k < 2; ++k) {
			necktie.rotateAngleZ = MathHelper.cos(((float) k * 1.5F + ageInTicks) * 0.1F) / 16;
		}

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.2F * limbSwingAmount;
		rightleg.rotateAngleX -= degToRad(45);
		leftleg.rotateAngleX -= degToRad(45);
		rightleg.rotateAngleY = degToRad(30);
		leftleg.rotateAngleY = -degToRad(30);

		rightleglower.rotateAngleX = degToRad(90);
		leftleglower.rotateAngleX = degToRad(90);
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

		head.rotateAngleX -= (float) ((double) head.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
	}
}
