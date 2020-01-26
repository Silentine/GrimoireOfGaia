package gaia.model;

import gaia.entity.prop.EntityGaiaPropAntHill;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaPropAntHill extends ModelGaia {
	private ModelRenderer body01;
	private ModelRenderer body02;
	private ModelRenderer body03;

	public ModelGaiaPropAntHill() {
		textureWidth = 128;
		textureHeight = 64;

		body01 = new ModelRenderer(this, 0, 0);
		body01.addBox(-3F, -4F, -3F, 6, 1, 6);
		body01.setRotationPoint(0F, 24F, 0F);
		setRotation(body01, 0F, 0F, 0F);
		body02 = new ModelRenderer(this, 0, 7);
		body02.addBox(-5F, -3F, -5F, 10, 1, 10);
		body02.setRotationPoint(0F, 24F, 0F);
		setRotation(body02, 0F, 0F, 0F);
		body03 = new ModelRenderer(this, 0, 18);
		body03.addBox(-6F, -2F, -6F, 12, 2, 12);
		body03.setRotationPoint(0F, 24F, 0F);
		setRotation(body03, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		EntityGaiaPropAntHill entityGaiaPropAntHill = (EntityGaiaPropAntHill) entityIn;
		
		if (entityGaiaPropAntHill.getSpawnAmount() <= 2) {
		body01.render(scale);
		}
		body02.render(scale);
		body03.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
	}
}
