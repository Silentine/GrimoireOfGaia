package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaBee extends ModelGaia {

	private ModelRenderer anchor;
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer bodytop;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer rightwing2;
	private ModelRenderer leftwing2;
	private ModelRenderer thorax1;

	public ModelGaiaBee() {
		textureWidth = 128;
		textureHeight = 64;

		// Used to adjust height
		float rotationPointZ = 0F;

		anchor = new ModelRenderer(this, 38, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -7F, 0F + rotationPointZ);
		anchor.setTextureSize(128, 64);
		setRotation(anchor, 0F, 0F, 0F);

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3.5F, -6.5F, -3.25F, 7, 7, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		headeyes.setTextureSize(128, 64);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		ModelRenderer neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, 0.5235988F, 0F, 0F);
		ModelRenderer bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5F, -2.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0.7853982F, 0F, 0F);
		ModelRenderer bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 5.5F, -2.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0.7853982F, 0F, 0F);
		ModelRenderer bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 6.5F, -5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 1.047198F, 0F, 0F);
		ModelRenderer rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3.5F, -0.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 1.308997F, 0.1745329F, 0.0872665F);
		ModelRenderer leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3.5F, -0.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 1.308997F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 1F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 1F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 6, 3);
		rightleg.setRotationPoint(-2F, 9F, 5F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.2617994F, 0.1745329F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 6, 3);
		leftleg.setRotationPoint(2F, 9F, 5F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.2617994F, -0.1745329F, 0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-4F, -6F, 1F, 8, 8, 3);
		hair.setRotationPoint(0F, 1F, 0F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0F, 0F, 0F);
		ModelRenderer rightantenna = new ModelRenderer(this, 36, 25);
		rightantenna.addBox(-2F, -8F, -5F, 1, 4, 4);
		rightantenna.setRotationPoint(0F, 1F, 0F);
		rightantenna.setTextureSize(64, 32);
		setRotation(rightantenna, 0F, 0.1745329F, 0F);
		ModelRenderer leftantenna = new ModelRenderer(this, 36, 25);
		leftantenna.addBox(1F, -8F, -5F, 1, 4, 4);
		leftantenna.setRotationPoint(0F, 1F, 0F);
		leftantenna.setTextureSize(64, 32);
		setRotation(leftantenna, 0F, -0.1745329F, 0F);
		ModelRenderer collar = new ModelRenderer(this, 36, 33);
		collar.addBox(-3.5F, 0F, -1.5F, 7, 3, 3);
		collar.setRotationPoint(0F, 1F, 0F);
		collar.setTextureSize(64, 32);
		setRotation(collar, 0.5235988F, 0F, 0F);
		ModelRenderer rightwing1 = new ModelRenderer(this, 64, -10);
		rightwing1.addBox(0F, -3F, 0F, 0, 6, 10);
		rightwing1.setRotationPoint(-1.5F, 2F, 2F);
		rightwing1.setTextureSize(64, 32);
		setRotation(rightwing1, 0.5235988F, -0.7853982F, 0F);
		rightwing2 = new ModelRenderer(this, 64, -10);
		rightwing2.addBox(0.5F, -3F, 0F, 0, 6, 10);
		rightwing2.setRotationPoint(-1.5F, 2F, 2F);
		rightwing2.setTextureSize(64, 32);
		setRotation(rightwing2, 0F, -0.7853982F, 0F);
		ModelRenderer leftwing1 = new ModelRenderer(this, 74, -10);
		leftwing1.mirror = true;
		leftwing1.addBox(0F, -3F, 0F, 0, 6, 10);
		leftwing1.setRotationPoint(1.5F, 2F, 2F);
		leftwing1.setTextureSize(64, 32);
		setRotation(leftwing1, 0.5235988F, 0.7853982F, 0F);
		leftwing2 = new ModelRenderer(this, 74, -10);
		leftwing2.mirror = true;
		leftwing2.addBox(-0.5F, -3F, 0F, 0, 6, 10);
		leftwing2.setRotationPoint(1.5F, 2F, 2F);
		leftwing2.setTextureSize(64, 32);
		setRotation(leftwing2, 0F, 0.7853982F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 36, 39);
		rightarmlower.addBox(-2.5F, 8F, -1.5F, 3, 2, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, 1F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0F, 0F, 0F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 36, 39);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-0.5F, 8F, -1.5F, 3, 2, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, 1F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0F, 0F, 0F);
		thorax1 = new ModelRenderer(this, 64, 6);
		thorax1.addBox(-1.5F, 4.5F, -6F, 3, 3, 3);
		thorax1.setRotationPoint(0F, 1F, 0F);
		thorax1.setTextureSize(64, 32);
		setRotation(thorax1, 1.570796F, 0F, 0F);
		ModelRenderer thorax2 = new ModelRenderer(this, 64, 12);
		thorax2.addBox(-2.5F, 7.5F, -7F, 5, 5, 5);
		thorax2.setRotationPoint(0F, 1F, 0F);
		thorax2.setTextureSize(64, 32);
		setRotation(thorax2, 1.570796F, 0F, 0F);
		ModelRenderer thorax3 = new ModelRenderer(this, 64, 22);
		thorax3.addBox(-1.5F, 10.5F, -8F, 3, 3, 3);
		thorax3.setRotationPoint(0F, 1F, 0F);
		thorax3.setTextureSize(64, 32);
		setRotation(thorax3, 1.570796F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 24, 21);
		rightleglower.addBox(-1.5F, -0.5F, -6F, 3, 6, 3);
		rightleglower.setRotationPoint(-2F, 9F, 5F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, 1.308997F, 0.1745329F, 0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 24, 21);
		leftleglower.mirror = true;
		leftleglower.addBox(-1.5F, -0.5F, -6F, 3, 6, 3);
		leftleglower.setRotationPoint(2F, 9F, 5F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, 1.308997F, -0.1745329F, 0F);
		ModelRenderer rightlegfoot = new ModelRenderer(this, 94, 0);
		rightlegfoot.addBox(-2F, 5.5F, -6.5F, 4, 1, 4);
		rightlegfoot.setRotationPoint(-2F, 9F, 5F);
		rightlegfoot.setTextureSize(128, 64);
		setRotation(rightlegfoot, 1.308997F, 0.1745329F, 0F);
		ModelRenderer leftlegfoot = new ModelRenderer(this, 94, 0);
		leftlegfoot.mirror = true;
		leftlegfoot.addBox(-2F, 5.5F, -6.5F, 4, 1, 4);
		leftlegfoot.setRotationPoint(2F, 9F, 5F);
		leftlegfoot.setTextureSize(128, 64);
		setRotation(leftlegfoot, 1.308997F, -0.1745329F, 0F);

		anchor.addChild(head);
		anchor.addChild(headeyes);
		anchor.addChild(headaccessory);
		anchor.addChild(neck);
		anchor.addChild(bodytop);
		anchor.addChild(bodymiddle);
		anchor.addChild(bodymiddlebutton);
		anchor.addChild(bodybottom);
		anchor.addChild(rightchest);
		anchor.addChild(leftchest);
		anchor.addChild(rightarm);
		anchor.addChild(leftarm);
		anchor.addChild(rightleg);
		anchor.addChild(leftleg);

		convertToChild(head, hair);
		convertToChild(head, rightantenna);
		convertToChild(head, leftantenna);
		anchor.addChild(collar);
		anchor.addChild(rightwing2);
		convertToChild(rightwing2, rightwing1);
		anchor.addChild(leftwing2);
		convertToChild(leftwing2, leftwing1);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		anchor.addChild(thorax1);
		convertToChild(thorax1, thorax2);
		convertToChild(thorax1, thorax3);
		convertToChild(rightleg, rightleglower);
		convertToChild(leftleg, leftleglower);
		convertToChild(rightleg, rightlegfoot);
		convertToChild(leftleg, leftlegfoot);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float floatSpeed = 0.2F;
		float floatRange = 2.0F;

		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;

		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

//		headeyes.showModel = entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F;

		// arms
		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;
		rightarm.rotateAngleX = 0.0F;
		leftarm.rotateAngleX = 0.0F;

		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		// body
		float swingSpeed = 0.2F;
		float angleRange = 1.0F;
		float wingDefaultAngleY = 0.7853982F;

		rightwing2.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		rightwing2.rotateAngleY -= wingDefaultAngleY;
		leftwing2.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		leftwing2.rotateAngleY += wingDefaultAngleY;

		float thoraxDefaultAngleX = 1.570796F;

		thorax1.rotateAngleX = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(2);
		thorax1.rotateAngleX += thoraxDefaultAngleX;

		// legs
		float swingSpeed2 = 0.2F;
		float angleRange2 = 0.1F;

		rightleg.rotateAngleZ = MathHelper.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * -0.5F;
		leftleg.rotateAngleZ = MathHelper.cos(ageInTicks * swingSpeed2) * angleRange2 * -0.5F;
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

	public ModelRenderer getAnchor() {
		return anchor;
	}
}
