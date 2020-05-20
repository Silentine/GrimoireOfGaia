package gaia.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaNPCHolstaurus<T extends MobEntity> extends ModelGaia<T> {
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
	private ModelRenderer waistupper;
	private ModelRenderer tail;

	public ModelGaiaNPCHolstaurus() {
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
		headeyes.setTextureSize(128, 64);
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
		rightchest.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
		rightchest.setRotationPoint(-1.5F, 3.5F, -2F);
		rightchest.setTextureSize(128, 64);
		setRotation(rightchest, 0.7853982F, 0.3490659F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
		leftchest.setRotationPoint(1.5F, 3.5F, -2F);
		leftchest.setTextureSize(128, 64);
		setRotation(leftchest, 0.7853982F, -0.3490659F, -0.0872665F);
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
		rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		rightleg.setRotationPoint(-2F, 11F, -0.5F);
		rightleg.setTextureSize(128, 64);
		setRotation(rightleg, -0.1745329F, -0.1745329F, 0F);
		leftleg = new ModelRenderer(this, 24, 22);
		leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		leftleg.setRotationPoint(2F, 11F, -0.5F);
		leftleg.setTextureSize(128, 64);
		setRotation(leftleg, -0.1745329F, 0.1745329F, 0F);
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
		ModelRenderer righthorn1 = new ModelRenderer(this, 36, 28);
		righthorn1.addBox(-5F, -6F, -1F, 2, 2, 2);
		righthorn1.setRotationPoint(0F, 1F, 0F);
		righthorn1.setTextureSize(128, 64);
		setRotation(righthorn1, 0F, 0F, 0F);
		ModelRenderer righthorn2 = new ModelRenderer(this, 36, 32);
		righthorn2.addBox(-6F, -7F, -2F, 2, 2, 2);
		righthorn2.setRotationPoint(0F, 1F, 0F);
		righthorn2.setTextureSize(128, 64);
		setRotation(righthorn2, 0F, 0F, 0F);
		ModelRenderer righthorn3 = new ModelRenderer(this, 36, 36);
		righthorn3.addBox(-4.5F, -7.5F, -0.5F, 1, 1, 1);
		righthorn3.setRotationPoint(0F, 1F, 0F);
		righthorn3.setTextureSize(128, 64);
		setRotation(righthorn3, 0F, 0F, 0F);
		ModelRenderer lefthorn1 = new ModelRenderer(this, 36, 28);
		lefthorn1.mirror = true;
		lefthorn1.addBox(3F, -6F, -1F, 2, 2, 2);
		lefthorn1.setRotationPoint(0F, 1F, 0F);
		lefthorn1.setTextureSize(128, 64);
		setRotation(lefthorn1, 0F, 0F, 0F);
		ModelRenderer lefthorn2 = new ModelRenderer(this, 36, 32);
		lefthorn2.mirror = true;
		lefthorn2.addBox(4F, -7F, -2F, 2, 2, 2);
		lefthorn2.setRotationPoint(0F, 1F, 0F);
		lefthorn2.setTextureSize(128, 64);
		setRotation(lefthorn2, 0F, 0F, 0F);
		ModelRenderer lefthorn3 = new ModelRenderer(this, 36, 36);
		lefthorn3.mirror = true;
		lefthorn3.addBox(3.5F, -7.5F, -0.5F, 1, 1, 1);
		lefthorn3.setRotationPoint(0F, 1F, 0F);
		lefthorn3.setTextureSize(128, 64);
		setRotation(lefthorn3, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 34);
		rightear.addBox(-4F, -5F, -1F, 0, 4, 4);
		rightear.setRotationPoint(0F, 1F, 0F);
		rightear.setTextureSize(128, 64);
		setRotation(rightear, 0F, -0.5235988F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 34);
		leftear.mirror = true;
		leftear.addBox(4F, -5F, -1F, 0, 4, 4);
		leftear.setRotationPoint(0F, 1F, 0F);
		leftear.setTextureSize(128, 64);
		setRotation(leftear, 0F, 0.5235988F, 0F);
		bell = new ModelRenderer(this, 36, 42);
		bell.addBox(-1F, 0F, -1.5F, 2, 2, 2);
		bell.setRotationPoint(0F, 3F, -1.5F);
		bell.setTextureSize(128, 64);
		setRotation(bell, -2.356194F, 0F, 0F);
		waistupper = new ModelRenderer(this, 36, 46);
		waistupper.addBox(-3F, 0F, -2F, 6, 9, 4);
		waistupper.setRotationPoint(0F, 1F, 0F);
		waistupper.setTextureSize(128, 64);
		setRotation(waistupper, -0.0872665F, 0F, 0F);
		ModelRenderer rightwaist = new ModelRenderer(this, 64, 0);
		rightwaist.addBox(-2F, -1.5F, -2.5F, 4, 3, 5);
		rightwaist.setRotationPoint(-2F, 11F, -0.5F);
		rightwaist.setTextureSize(128, 64);
		setRotation(rightwaist, 0.0872665F, 0F, 0F);
		ModelRenderer leftwaist = new ModelRenderer(this, 82, 0);
		leftwaist.addBox(-2F, -1.5F, -2.5F, 4, 3, 5);
		leftwaist.setRotationPoint(2F, 11F, -0.5F);
		leftwaist.setTextureSize(128, 64);
		setRotation(leftwaist, 0.0872665F, 0F, 0F);
		tail = new ModelRenderer(this, 64, 8);
		tail.addBox(-1F, 0F, 0F, 2, 10, 0);
		tail.setRotationPoint(0F, 10F, 2F);
		tail.setTextureSize(128, 64);
		setRotation(tail, 0.4014257F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 64, 18);
		rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		rightleglower.setTextureSize(128, 64);
		setRotation(rightleglower, -0.1745329F, -0.1745329F, 0F);
		ModelRenderer leftleglower = new ModelRenderer(this, 80, 18);
		leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		leftleglower.setRotationPoint(2F, 11F, -0.5F);
		leftleglower.setTextureSize(128, 64);
		setRotation(leftleglower, -0.1745329F, 0.1745329F, 0F);
		ModelRenderer rightfoot = new ModelRenderer(this, 64, 30);
		rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		rightfoot.setTextureSize(128, 64);
		setRotation(rightfoot, 0F, -0.1745329F, 0F);
		ModelRenderer leftfoot = new ModelRenderer(this, 64, 30);
		leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		leftfoot.setRotationPoint(2F, 11F, -0.5F);
		leftfoot.setTextureSize(128, 64);
		setRotation(leftfoot, 0F, 0.1745329F, 0F);

		convertToChild(head, hair1);
		convertToChild(head, hair2);
		convertToChild(head, righthorn1);
		convertToChild(head, righthorn2);
		convertToChild(head, righthorn3);
		convertToChild(head, lefthorn1);
		convertToChild(head, lefthorn2);
		convertToChild(head, lefthorn3);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightwaist);
		convertToChild(rightleg, rightfoot);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftwaist);
		convertToChild(leftleg, leftfoot);
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
		bell.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		waistupper.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		tail.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);

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
		float chestDefaultRotateAngleX = 0.7853982F;
		
		rightchest.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.2F * limbSwingAmount + chestDefaultRotateAngleX;
		leftchest.rotateAngleX = rightchest.rotateAngleX;
		
		tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.1745329F;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
		leftleg.rotateAngleX -= 0.1745329F;
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
