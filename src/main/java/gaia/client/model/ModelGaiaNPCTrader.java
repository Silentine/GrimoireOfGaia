package gaia.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaNPCTrader<T extends MobEntity> extends ModelGaia<T> {
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
	private ModelRenderer rightarmlower;
	private ModelRenderer leftarmlower;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer rightear;
	private ModelRenderer leftear;
	private ModelRenderer watch;
	private ModelRenderer tail;
	private ModelRenderer skirt;
	private ModelRenderer rightskirt01;
	private ModelRenderer leftskirt01;
	private ModelRenderer rightskirt02;
	private ModelRenderer leftskirt02;

	public ModelGaiaNPCTrader() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, 0F);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, 0F);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, 0F);
		setRotation(bodytop, -0.0872665F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddle, 0F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		setRotation(bodymiddlebutton, 0F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, 0F);
		setRotation(bodybottom, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 6, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftarm, 0F, 0F, 0F);
		rightarmlower = new ModelRenderer(this, 16, 20);
		rightarmlower.addBox(-1F, 0F, -2F, 2, 6, 2);
		rightarmlower.setRotationPoint(-3.5F, 7.5F, 1F);
		setRotation(rightarmlower, 0F, 0F, 0F);
		leftarmlower = new ModelRenderer(this, 16, 20);
		leftarmlower.mirror = true;
		leftarmlower.addBox(-1F, 0F, -2F, 2, 6, 2);
		leftarmlower.setRotationPoint(3.5F, 7.5F, 1F);
		setRotation(leftarmlower, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1.5F, -1F, -1.5F, 3, 8, 3);
		rightleg.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleg, -0.3490659F, -0.0872665F, -0.0349066F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1.5F, -1F, -1.5F, 3, 8, 3);
		leftleg.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleg, -0.3490659F, 0.0872665F, 0.0349066F);
		ModelRenderer righthair = new ModelRenderer(this, 36, 14);
		righthair.addBox(-5F, -5F, 1.5F, 3, 9, 3);
		righthair.setRotationPoint(0F, 1F, 0F);
		setRotation(righthair, 0F, 0.0872665F, 0.1745329F);
		ModelRenderer lefthair = new ModelRenderer(this, 36, 14);
		lefthair.addBox(2F, -5F, 1.5F, 3, 9, 3);
		lefthair.setRotationPoint(0F, 1F, 0F);
		setRotation(lefthair, 0F, -0.0872665F, -0.1745329F);
		ModelRenderer righthairpin = new ModelRenderer(this, 36, 26);
		righthairpin.addBox(-6F, -8F, 1F, 4, 4, 4);
		righthairpin.setRotationPoint(0F, 1F, 0F);
		setRotation(righthairpin, 0F, 0F, 0.1745329F);
		ModelRenderer lefthairpin = new ModelRenderer(this, 52, 26);
		lefthairpin.addBox(2F, -8F, 1F, 4, 4, 4);
		lefthairpin.setRotationPoint(0F, 1F, 0F);
		setRotation(lefthairpin, 0F, 0F, -0.1745329F);
		rightear = new ModelRenderer(this, 36, 34);
		rightear.addBox(-3F, -8.5F, -6F, 2, 8, 6);
		rightear.setRotationPoint(0F, 1F, 0F);
		setRotation(rightear, 0F, 0.2617994F, 0F);
		leftear = new ModelRenderer(this, 36, 34);
		leftear.addBox(1F, -8.5F, -6F, 2, 8, 6);
		leftear.setRotationPoint(0F, 1F, 0F);
		setRotation(leftear, 0F, -0.2617994F, 0F);
		ModelRenderer headnose = new ModelRenderer(this, 36, 48);
		headnose.addBox(-0.5F, -2.5F, -3.1F, 1, 1, 1);
		headnose.setRotationPoint(0F, 1F, 0F);
		setRotation(headnose, 0F, 0F, 0F);
		ModelRenderer headnoseshadow = new ModelRenderer(this, 36, 50);
		headnoseshadow.addBox(-0.5F, -4F, -3.2F, 1, 2, 1);
		headnoseshadow.setRotationPoint(0F, 1F, 0F);
		setRotation(headnoseshadow, 0F, 0F, 0F);
		ModelRenderer rightpauldron = new ModelRenderer(this, 36, 53);
		rightpauldron.addBox(-2.5F, -1.5F, -1.5F, 3, 3, 3);
		rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		setRotation(rightpauldron, 0F, 0F, 0.1745329F);
		ModelRenderer leftpauldron = new ModelRenderer(this, 36, 53);
		leftpauldron.mirror = true;
		leftpauldron.addBox(-0.5F, -1.5F, -1.5F, 3, 3, 3);
		leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		setRotation(leftpauldron, 0F, 0F, -0.1745329F);
		watch = new ModelRenderer(this, 68, 0);
		watch.addBox(-3F, 8F, -2.5F, 1, 5, 5);
		watch.setRotationPoint(0F, 1F, 0F);
		setRotation(watch, 0F, 0F, 0.1745329F);
		tail = new ModelRenderer(this, 68, 10);
		tail.addBox(-1.5F, 6F, -5F, 3, 3, 3);
		tail.setRotationPoint(0F, 1F, 0F);
		setRotation(tail, 0.7853982F, 0F, 0F);
		skirt = new ModelRenderer(this, 68, 16);
		skirt.addBox(-3.5F, 8.5F, -3.5F, 7, 2, 7);
		skirt.setRotationPoint(0F, 1F, 0F);
		setRotation(skirt, 0F, 0F, 0F);
		rightskirt01 = new ModelRenderer(this, 68, 25);
		rightskirt01.addBox(-2F, 0.5F, -4F, 5, 3, 8);
		rightskirt01.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightskirt01, 0F, 0F, 0F);
		leftskirt01 = new ModelRenderer(this, 68, 25);
		leftskirt01.mirror = true;
		leftskirt01.addBox(-3F, 0.5F, -4F, 5, 3, 8);
		leftskirt01.setRotationPoint(2F, 11F, 0F);
		setRotation(leftskirt01, 0F, 0F, 0F);
		rightskirt02 = new ModelRenderer(this, 68, 36);
		rightskirt02.addBox(-2.5F, 3.5F, -4.5F, 6, 5, 9);
		rightskirt02.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightskirt02, 0F, 0F, 0F);
		leftskirt02 = new ModelRenderer(this, 68, 36);
		leftskirt02.mirror = true;
		leftskirt02.addBox(-3.5F, 3.5F, -4.5F, 6, 5, 9);
		leftskirt02.setRotationPoint(2F, 11F, 0F);
		setRotation(leftskirt02, 0F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 68, 50);
		rightleglower.addBox(-1.5F, 4.5F, 1.5F, 3, 8, 2);
		rightleglower.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightleglower, -0.3490659F, -0.0872665F, -0.0349066F);
		ModelRenderer leftleglower = new ModelRenderer(this, 68, 50);
		leftleglower.addBox(-1.5F, 4.5F, 1.5F, 3, 8, 2);
		leftleglower.setRotationPoint(2F, 11F, 0F);
		setRotation(leftleglower, -0.3490659F, 0.0872665F, 0.0349066F);
		ModelRenderer rightfootlower = new ModelRenderer(this, 68, 60);
		rightfootlower.addBox(-1.5F, 11.5F, -5F, 3, 1, 3);
		rightfootlower.setRotationPoint(-2F, 11F, 0F);
		setRotation(rightfootlower, 0.0872665F, -0.0872665F, -0.0349066F);
		ModelRenderer leftfootlower = new ModelRenderer(this, 68, 60);
		leftfootlower.addBox(-1.5F, 11.5F, -5F, 3, 1, 3);
		leftfootlower.setRotationPoint(2F, 11F, 0F);
		setRotation(leftfootlower, 0.0872665F, 0.0872665F, 0.0349066F);

		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(head, righthair);
		convertToChild(head, lefthair);
		convertToChild(head, headnose);
		convertToChild(head, headnoseshadow);
		convertToChild(head, righthairpin);
		convertToChild(head, lefthairpin);
		convertToChild(rightarm, rightarmlower);
		convertToChild(leftarm, leftarmlower);
		convertToChild(rightarm, rightpauldron);
		convertToChild(leftarm, leftpauldron);
		convertToChild(rightskirt01, rightskirt02);
		convertToChild(rightleg, rightskirt01);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfootlower);
		convertToChild(leftskirt01, leftskirt02);
		convertToChild(leftleg, leftskirt01);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfootlower);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		headaccessory.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		neck.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bodytop.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bodymiddle.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bodymiddlebutton.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		bodybottom.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightchest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftchest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightleg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftleg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		watch.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		skirt.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

		if (entityIn.ticksExisted % 60 == 0 && entityIn.limbSwingAmount <= 0.1F) {
			headeyes.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		}
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		float earDefaultAngleZ = 0.2617994F;

		rightear.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(4);
		rightear.rotateAngleY += earDefaultAngleZ;
		leftear.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * -degToRad(4);
		leftear.rotateAngleY += -earDefaultAngleZ;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		float armDefaultAngleY = 0.349066F;
		float armDefaultAngleZ = 0.174533F;

		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		rightarm.rotateAngleY = +armDefaultAngleY;
		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;

		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleY = -armDefaultAngleY;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + armDefaultAngleZ;

		rightarmlower.rotateAngleX = -armDefaultAngleY;
		leftarmlower.rotateAngleX = -armDefaultAngleY;

		// body
		tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount) * 0.5F;
		leftleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount) * 0.5F;
		rightleg.rotateAngleX -= 0.3490659F;
		leftleg.rotateAngleX -= 0.3490659F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
