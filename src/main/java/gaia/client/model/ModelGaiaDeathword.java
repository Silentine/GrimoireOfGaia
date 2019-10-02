package gaia.client.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaDeathword<T extends MobEntity> extends ModelGaia<T> {

	RendererModel anchor;
	RendererModel rightcover;
	RendererModel leftcover;
	RendererModel rightpage;
	RendererModel leftpage;
	RendererModel rightmiddlepage;
	RendererModel leftmiddlepage;
	RendererModel binder;

	public ModelGaiaDeathword() {
		textureWidth = 64;
		textureHeight = 32;

		// Used to adjust height
		float rotationPointZ = 0F;

		anchor = new RendererModel(this, 38, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -7F, 0F + rotationPointZ);
		anchor.setTextureSize(128, 64);
		setRotation(anchor, 0F, 0F, 0F);

		rightcover = new RendererModel(this, 0, 0);
		rightcover.addBox(-6F, -5F, 0F, 6, 10, 0);
		rightcover.setRotationPoint(-1F, 4F, 0F);
		rightcover.setTextureSize(64, 32);
		setRotation(rightcover, 0F, -0.3490659F, 0F);
		leftcover = new RendererModel(this, 0, 10);
		leftcover.addBox(0F, -5F, 0F, 6, 10, 0);
		leftcover.setRotationPoint(1F, 4F, 0F);
		leftcover.setTextureSize(64, 32);
		setRotation(leftcover, 0F, 0.3490659F, 0F);
		rightpage = new RendererModel(this, 12, 0);
		rightpage.addBox(-5F, -4F, 0F, 5, 8, 1);
		rightpage.setRotationPoint(0F, 4F, -1F);
		rightpage.setTextureSize(64, 32);
		setRotation(rightpage, 0F, -0.3490659F, 0F);
		leftpage = new RendererModel(this, 12, 9);
		leftpage.addBox(0F, -4F, 0F, 5, 8, 1);
		leftpage.setRotationPoint(0F, 4F, -1F);
		leftpage.setTextureSize(64, 32);
		setRotation(leftpage, 0F, 0.3490659F, 0F);
		rightmiddlepage = new RendererModel(this, 24, 0);
		rightmiddlepage.addBox(-5F, -4F, 0F, 5, 8, 0);
		rightmiddlepage.setRotationPoint(0F, 4F, -1F);
		rightmiddlepage.setTextureSize(64, 32);
		setRotation(rightmiddlepage, 0F, -0.8726646F, 0F);
		leftmiddlepage = new RendererModel(this, 24, 8);
		leftmiddlepage.addBox(-5F, -4F, 0F, 5, 8, 0);
		leftmiddlepage.setRotationPoint(0F, 4F, -1F);
		leftmiddlepage.setTextureSize(64, 32);
		setRotation(leftmiddlepage, 0F, -2.268928F, 0F);
		binder = new RendererModel(this, 34, 0);
		binder.addBox(-1F, -5F, 1F, 2, 10, 0);
		binder.setRotationPoint(0F, 4F, -1F);
		binder.setTextureSize(64, 32);
		binder.mirror = true;
		setRotation(binder, 0F, 0F, 0F);

		anchor.addChild(rightcover);
		anchor.addChild(leftcover);
		anchor.addChild(rightpage);
		anchor.addChild(leftpage);
		anchor.addChild(rightmiddlepage);
		anchor.addChild(leftmiddlepage);
		anchor.addChild(binder);

//		convertToChild(rightpage, rightpage);
//		convertToChild(leftpage, leftpage);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		float floatSpeed = 0.4F;
		float floatRange = 3.0F;

		// anchor
		anchor.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * floatSpeed) * floatRange;
		anchor.rotateAngleX = (degToRad(45));

		float swingSpeed = 0.4F;
		float angleRange = 0.8F;

		// body
		rightcover.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed + (float) Math.PI) * angleRange * 0.5F;
		rightcover.rotateAngleY -= degToRad(30);
		leftcover.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed) * angleRange * 0.5F;
		leftcover.rotateAngleY += degToRad(30);

		rightpage.rotateAngleY = rightcover.rotateAngleY;
		leftpage.rotateAngleY = leftcover.rotateAngleY;

		float swingSpeed2 = 0.4F;
		float angleRange2 = 0.4F;

		rightmiddlepage.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed2 + (float) Math.PI) * angleRange2 * 0.5F;
		rightmiddlepage.rotateAngleY -= degToRad(50);
		leftmiddlepage.rotateAngleY = MathHelper.cos(ageInTicks * swingSpeed2) * angleRange2 * 0.5F;
		leftmiddlepage.rotateAngleY -= degToRad(130);
	}
}
