package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSporeling extends ModelGaia {
	// fields
	ModelRenderer head;
	ModelRenderer headalt;
	ModelRenderer body;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public ModelGaiaSporeling() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -5F, -4F, 8, 6, 8);
		head.setRotationPoint(0F, 19F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headalt = new ModelRenderer(this, 0, 14);
		headalt.addBox(-4F, -5F, -4F, 8, 3, 8);
		headalt.setRotationPoint(0F, 19F, 0F);
		setRotation(headalt, 0F, 0F, 0F);
		body = new ModelRenderer(this, 32, 0);
		body.addBox(-2F, -5F, -2F, 4, 7, 4);
		body.setRotationPoint(0F, 21F, 0F);
		setRotation(body, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 32, 11);
		rightleg.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
		rightleg.setRotationPoint(-1.5F, 21F, 0F);
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 32, 11);
		leftleg.mirror = true;
		leftleg.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
		leftleg.setRotationPoint(1.5F, 21F, 0F);
		setRotation(leftleg, 0F, 0F, 0F);

		convertToChild(head, headalt);
		convertToChild(body, head);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		body.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;

		// body
		if (swingProgress > -9990.0F) {
			holdingMelee();
		}

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
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(body.rotateAngleX - 0.7F) * 0.75F;

		body.rotateAngleX -= (float) ((double) body.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
	}
}
