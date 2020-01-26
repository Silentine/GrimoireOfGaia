package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMimic extends ModelGaia {
	private ModelRenderer anchor;
	private ModelRenderer lid1;
	private ModelRenderer lid2;
	private ModelRenderer lock;
	private ModelRenderer teeth1;
	private ModelRenderer teeth2;

//	private Random rnd = new Random();

	public ModelGaiaMimic() {
		textureWidth = 128;
		textureHeight = 64;

		// Used to adjust height
		float rotationPointZ = -4F;

		anchor = new ModelRenderer(this, 0, 19);
		anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		anchor.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(anchor, 0F, 0F, 0F);
		
		lid1 = new ModelRenderer(this, 0, 0);
		lid1.addBox(-7.0F, -5.0F, -14.0F, 14, 5, 14);
		lid1.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(lid1, -0.69813174F, 0.0F, 0.0F);
		lid2 = new ModelRenderer(this, 0, 19);
		lid2.addBox(-7.0F, 0.0F, -14.0F, 14, 10, 14);
		lid2.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(lid2, 0.3490659F, 0.0F, 0.0F);
		lock = new ModelRenderer(this, 0, 0);
		lock.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1);
		lock.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(lock, -0.69813174F, 0.0F, 0.0F);
		teeth1 = new ModelRenderer(this, 56, 20);
		teeth1.addBox(-6.0F, -4.0F, -13.0F, 12, 8, 12);
		teeth1.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(teeth1, 0.3490659F, 0.0F, 0.0F);
		teeth2 = new ModelRenderer(this, 56, 0);
		teeth2.addBox(-6.0F, -3.0F, -13.0F, 12, 8, 12);
		teeth2.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(teeth2, -0.69813174F, 0.0F, 0.0F);
		ModelRenderer rot = new ModelRenderer(this, 56, 40);
		rot.addBox(-5.0F, -7.0F, -11.0F, 10, 14, 10);
		rot.setRotationPoint(0.0F, 5.0F, 7.0F + rotationPointZ);
		setRotation(rot, -0.1745329F, 0.0F, 0.0F);

		anchor.addChild(lid1);
		anchor.addChild(lid2);
		anchor.addChild(lock);
		anchor.addChild(teeth1);
		anchor.addChild(teeth2);
		anchor.addChild(rot);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		anchor.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		// anchor
//		anchor.rotationPointX = (float) (this.rnd.nextGaussian());
//		anchor.rotationPointZ = (float) (this.rnd.nextGaussian());

		anchor.rotationPointY = -2.0F + MathHelper.cos((ageInTicks + 1.5F) * 0.5F) * 0.5F;

		// body
		lid1.rotateAngleX = MathHelper.cos(ageInTicks * 1.8F + (float) Math.PI) * 0.8F * 0.5F;
		lid2.rotateAngleX = MathHelper.cos(ageInTicks * 1.8F) * 0.8F * 0.5F;
		lock.rotateAngleX = lid1.rotateAngleX - 0.69813174F;
		lid1.rotateAngleX -= 0.69813174F;
		lid2.rotateAngleX += 0.3490659F;
		teeth1.rotateAngleX = MathHelper.cos(ageInTicks * 1.8F) * 0.4F * 0.5F;
		teeth2.rotateAngleX = MathHelper.cos(ageInTicks * 1.8F + (float) Math.PI) * 0.4F * 0.5F;
		teeth1.rotateAngleX += 0.3490659F;
		teeth2.rotateAngleX -= 0.69813174F;
	}
}
