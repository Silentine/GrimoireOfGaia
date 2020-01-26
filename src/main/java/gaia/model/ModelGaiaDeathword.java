package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDeathword extends ModelGaia {

	ModelRenderer anchor;
	ModelRenderer rightcover;
	ModelRenderer leftcover;
	ModelRenderer rightpage;
	ModelRenderer leftpage;
	ModelRenderer rightmiddlepage;
	ModelRenderer leftmiddlepage;
	ModelRenderer binder;

	public ModelGaiaDeathword() {
		textureWidth = 64;
		textureHeight = 32;

		// Used to adjust height
		float rotationPointZ = 0F;

		anchor = new ModelRenderer(this, 38, 0);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0F, -7F, 0F + rotationPointZ);
		setRotation(anchor, 0F, 0F, 0F);

		rightcover = new ModelRenderer(this, 0, 0);
		rightcover.addBox(-6F, -5F, 0F, 6, 10, 0);
		rightcover.setRotationPoint(-1F, 4F, 0F);
		setRotation(rightcover, 0F, -0.3490659F, 0F);
		leftcover = new ModelRenderer(this, 0, 10);
		leftcover.addBox(0F, -5F, 0F, 6, 10, 0);
		leftcover.setRotationPoint(1F, 4F, 0F);
		setRotation(leftcover, 0F, 0.3490659F, 0F);
		rightpage = new ModelRenderer(this, 12, 0);
		rightpage.addBox(-5F, -4F, 0F, 5, 8, 1);
		rightpage.setRotationPoint(0F, 4F, -1F);
		setRotation(rightpage, 0F, -0.3490659F, 0F);
		leftpage = new ModelRenderer(this, 12, 9);
		leftpage.addBox(0F, -4F, 0F, 5, 8, 1);
		leftpage.setRotationPoint(0F, 4F, -1F);
		setRotation(leftpage, 0F, 0.3490659F, 0F);
		rightmiddlepage = new ModelRenderer(this, 24, 0);
		rightmiddlepage.addBox(-5F, -4F, 0F, 5, 8, 0);
		rightmiddlepage.setRotationPoint(0F, 4F, -1F);
		setRotation(rightmiddlepage, 0F, -0.8726646F, 0F);
		leftmiddlepage = new ModelRenderer(this, 24, 8);
		leftmiddlepage.addBox(-5F, -4F, 0F, 5, 8, 0);
		leftmiddlepage.setRotationPoint(0F, 4F, -1F);
		setRotation(leftmiddlepage, 0F, -2.268928F, 0F);
		binder = new ModelRenderer(this, 34, 0);
		binder.mirror = true;
		binder.addBox(-1F, -5F, 1F, 2, 10, 0);
		binder.setRotationPoint(0F, 4F, -1F);
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
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
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
