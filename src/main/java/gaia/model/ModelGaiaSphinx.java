package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSphinx extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer body1;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm3;
	private ModelRenderer leftarm3;
	private ModelRenderer body2;
	private ModelRenderer body3;
	private ModelRenderer tail;
	private ModelRenderer rightbackleg1;
	private ModelRenderer leftbackleg1;
	private ModelRenderer rightwing;
	private ModelRenderer leftwing;

	public ModelGaiaSphinx(float scaleFactor) {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6.5F, -3F, 6, 6, 6, scaleFactor);
		head.setRotationPoint(0F, 8F, -7.5F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6.5F, -3.1F, 6, 6, 0, scaleFactor);
		headeyes.setRotationPoint(0F, 8F, -7.5F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7, scaleFactor);
		headaccessory.setRotationPoint(0F, 8F, -7.5F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2, scaleFactor);
		neck.setRotationPoint(0F, 8F, -7.5F);
		setRotation(neck, 0.5235988F, 0F, 0F);
		body1 = new ModelRenderer(this, 0, 16);
		body1.addBox(-2.5F, 0F, -2F, 5, 6, 3, scaleFactor);
		body1.setRotationPoint(0F, 8F, -7F);
		setRotation(body1, 0.6981317F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 25);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2, scaleFactor);
		rightchest.setRotationPoint(-1.3F, 11F, -7F);
		setRotation(rightchest, 1.48353F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 25);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2, scaleFactor);
		leftchest.setRotationPoint(1.3F, 11F, -7F);
		setRotation(leftchest, 1.48353F, -0.1745329F, -0.0872665F);
		ModelRenderer rightarm1 = new ModelRenderer(this, 18, 12);
		rightarm1.addBox(-2F, 0F, -1.5F, 2, 8, 2, scaleFactor);
		rightarm1.setRotationPoint(-2.5F, 8F, -6F);
		setRotation(rightarm1, 0.1745329F, 0F, -0.0349066F);
		ModelRenderer leftarm1 = new ModelRenderer(this, 18, 12);
		leftarm1.addBox(-0.5F, 0F, -1.5F, 2, 8, 2, scaleFactor);
		leftarm1.setRotationPoint(3F, 8F, -6F);
		setRotation(leftarm1, 0.1745329F, 0F, 0.0349066F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 14);
		rightear.addBox(-4.5F, -10.5F, -1.5F, 3, 4, 3, scaleFactor);
		rightear.setRotationPoint(0F, 8F, -7.5F);
		setRotation(rightear, 0F, 0F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 48, 14);
		leftear.addBox(1.5F, -10.5F, -1.5F, 3, 4, 3, scaleFactor);
		leftear.setRotationPoint(0F, 8F, -7.5F);
		setRotation(leftear, 0F, 0F, 0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 21);
		hair.addBox(-4F, -5.5F, -2F, 8, 6, 6, scaleFactor);
		hair.setRotationPoint(0F, 8F, -7.5F);
		setRotation(hair, 0F, 0F, 0F);
		ModelRenderer crown = new ModelRenderer(this, 36, 33);
		crown.addBox(-1F, -8F, -4.6F, 2, 3, 1, scaleFactor);
		crown.setRotationPoint(0F, 8F, -7.5F);
		setRotation(crown, 0F, 0F, 0F);
		ModelRenderer rightarm2 = new ModelRenderer(this, 18, 22);
		rightarm2.addBox(-2F, 7F, 1F, 2, 7, 3, scaleFactor);
		rightarm2.setRotationPoint(-2.5F, 8F, -6F);
		setRotation(rightarm2, -0.1745329F, 0F, -0.0349066F);
		ModelRenderer leftarm2 = new ModelRenderer(this, 18, 22);
		leftarm2.addBox(-0.5F, 7F, 1F, 2, 7, 3, scaleFactor);
		leftarm2.setRotationPoint(3F, 8F, -6F);
		setRotation(leftarm2, -0.1745329F, 0F, 0.0349066F);
		rightarm3 = new ModelRenderer(this, 18, 32);
		rightarm3.addBox(-2.5F, 11F, -10F, 3, 2, 3, scaleFactor);
		rightarm3.setRotationPoint(-2.5F, 8F, -6F);
		setRotation(rightarm3, 0.5235988F, 0F, -0.0349066F);
		leftarm3 = new ModelRenderer(this, 18, 32);
		leftarm3.addBox(-1F, 11F, -10F, 3, 2, 3, scaleFactor);
		leftarm3.setRotationPoint(3F, 8F, -6F);
		setRotation(leftarm3, 0.5235988F, 0F, 0.0349066F);
		ModelRenderer rightarmbracelet = new ModelRenderer(this, 36, 37);
		rightarmbracelet.addBox(-3F, 11F, 0.5F, 4, 2, 4, scaleFactor);
		rightarmbracelet.setRotationPoint(-2.5F, 8F, -6F);
		setRotation(rightarmbracelet, -0.1745329F, 0F, -0.0349066F);
		ModelRenderer leftarmbracelet = new ModelRenderer(this, 36, 37);
		leftarmbracelet.addBox(-1.5F, 11F, 0.5F, 4, 2, 4, scaleFactor);
		leftarmbracelet.setRotationPoint(3F, 8F, -6F);
		setRotation(leftarmbracelet, -0.1745329F, 0F, 0.0349066F);
		body2 = new ModelRenderer(this, 66, 0);
		body2.addBox(-3.5F, -3F, -7.5F, 7, 7, 8, scaleFactor);
		body2.setRotationPoint(0F, 8F, -1F);
		setRotation(body2, 1.396263F, 0F, 0F);
		body3 = new ModelRenderer(this, 66, 15);
		body3.addBox(-3F, 3F, -8F, 6, 10, 7, scaleFactor);
		body3.setRotationPoint(0F, 8F, -3F);
		setRotation(body3, 1.745329F, 0F, 0F);
		tail = new ModelRenderer(this, 66, 32);
		tail.addBox(-0.5F, 0F, -0.5F, 1, 12, 1, scaleFactor);
		tail.setRotationPoint(0F, 8F, 10F);
		setRotation(tail, 0.6108652F, 0F, 0F);
		rightbackleg1 = new ModelRenderer(this, 96, 0);
		rightbackleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6, scaleFactor);
		rightbackleg1.setRotationPoint(-3F, 8F, 9F);
		setRotation(rightbackleg1, -0.296706F, 0F, 0.0349066F);
		leftbackleg1 = new ModelRenderer(this, 96, 0);
		leftbackleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6, scaleFactor);
		leftbackleg1.setRotationPoint(3F, 8F, 9F);
		setRotation(leftbackleg1, -0.296706F, 0F, -0.0349066F);
		ModelRenderer rightbackleg2 = new ModelRenderer(this, 96, 14);
		rightbackleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6, scaleFactor);
		rightbackleg2.setRotationPoint(-3F, 8F, 9F);
		setRotation(rightbackleg2, -0.8726646F, 0F, 0.0349066F);
		ModelRenderer leftbackleg2 = new ModelRenderer(this, 96, 14);
		leftbackleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6, scaleFactor);
		leftbackleg2.setRotationPoint(3F, 8F, 9F);
		setRotation(leftbackleg2, -0.8726646F, 0F, -0.0349066F);
		ModelRenderer rightbackleg3 = new ModelRenderer(this, 96, 23);
		rightbackleg3.addBox(-1F, 9F, 1F, 2, 6, 3, scaleFactor);
		rightbackleg3.setRotationPoint(-3F, 8F, 9F);
		setRotation(rightbackleg3, -0.2617994F, 0F, 0.0349066F);
		ModelRenderer leftbackleg3 = new ModelRenderer(this, 96, 23);
		leftbackleg3.addBox(-1F, 9F, 1F, 2, 6, 3, scaleFactor);
		leftbackleg3.setRotationPoint(3F, 8F, 9F);
		setRotation(leftbackleg3, -0.2617994F, 0F, -0.0349066F);
		ModelRenderer rightbacklegbracelet = new ModelRenderer(this, 36, 37);
		rightbacklegbracelet.addBox(-2F, 12F, 0.5F, 4, 2, 4, scaleFactor);
		rightbacklegbracelet.setRotationPoint(-3F, 8F, 9F);
		setRotation(rightbacklegbracelet, -0.2617994F, 0F, 0.0349066F);
		ModelRenderer leftbacklegbracelet = new ModelRenderer(this, 36, 37);
		leftbacklegbracelet.addBox(-2F, 12F, 0.5F, 4, 2, 4, scaleFactor);
		leftbacklegbracelet.setRotationPoint(3F, 8F, 9F);
		setRotation(leftbacklegbracelet, -0.2617994F, 0F, -0.0349066F);
		ModelRenderer rightbackleg4 = new ModelRenderer(this, 96, 32);
		rightbackleg4.addBox(-1.5F, 14F, -5F, 3, 2, 3, scaleFactor);
		rightbackleg4.setRotationPoint(-3F, 8F, 9F);
		setRotation(rightbackleg4, 0.0872665F, 0F, 0.0349066F);
		ModelRenderer leftbackleg4 = new ModelRenderer(this, 96, 32);
		leftbackleg4.addBox(-1.5F, 14F, -5F, 3, 2, 3, scaleFactor);
		leftbackleg4.setRotationPoint(3F, 8F, 9F);
		setRotation(leftbackleg4, 0.0872665F, 0F, -0.0349066F);
		rightwing = new ModelRenderer(this, 92, 36);
		rightwing.addBox(0F, -1F, -1F, 0, 16, 12, scaleFactor);
		rightwing.setRotationPoint(-4F, 8F, -4F);
		setRotation(rightwing, 1.22173F, -0.5235988F, 0.2617994F);
		leftwing = new ModelRenderer(this, 104, 36);
		leftwing.addBox(0F, -1F, -1F, 0, 16, 12, scaleFactor);
		leftwing.setRotationPoint(4F, 8F, -4F);
		setRotation(leftwing, 1.22173F, 0.5235988F, -0.2617994F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(head, hair);
		convertToChild(head, crown);
		convertToChild(rightarm3, rightarm1);
		convertToChild(rightarm3, rightarm2);
		convertToChild(rightarm3, rightarmbracelet);
		convertToChild(leftarm3, leftarm1);
		convertToChild(leftarm3, leftarm2);
		convertToChild(leftarm3, leftarmbracelet);
		convertToChild(rightbackleg1, rightbackleg2);
		convertToChild(rightbackleg1, rightbackleg3);
		convertToChild(rightbackleg1, rightbacklegbracelet);
		convertToChild(rightbackleg1, rightbackleg4);
		convertToChild(leftbackleg1, leftbackleg2);
		convertToChild(leftbackleg1, leftbackleg3);
		convertToChild(leftbackleg1, leftbacklegbracelet);
		convertToChild(leftbackleg1, leftbackleg4);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		body1.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm3.render(scale);
		leftarm3.render(scale);
		body2.render(scale);
		body3.render(scale);
		tail.render(scale);
		rightbackleg1.render(scale);
		leftbackleg1.render(scale);
		rightwing.render(scale);
		leftwing.render(scale);

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
		rightarm3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		leftarm3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;

		rightarm3.rotateAngleX += 0.5235988F;
		leftarm3.rotateAngleX += 0.5235988F;

		// body
		rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
		leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
		rightwing.rotateAngleY -= 0.5235988F;
		leftwing.rotateAngleY += 0.5235988F;

		tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightbackleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		leftbackleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		rightbackleg1.rotateAngleX -= 0.296706F;
		leftbackleg1.rotateAngleX -= 0.296706F;
	}
}
