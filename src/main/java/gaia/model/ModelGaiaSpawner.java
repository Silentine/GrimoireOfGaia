package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSpawner extends ModelGaia {

	ModelRenderer side1;
	ModelRenderer side2;

	public ModelGaiaSpawner() {
		textureWidth = 64;
		textureHeight = 32;

		side1 = new ModelRenderer(this, 0, 0);
		side1.addBox(-8F, -8F, 0F, 16, 16, 0);
		side1.setRotationPoint(0F, 0F, 0F);
		setRotation(side1, 0F, 0.7853982F, 0F);
		side2 = new ModelRenderer(this, 0, 0);
		side2.addBox(-8F, -8F, 0F, 16, 16, 0);
		side2.setRotationPoint(0F, 0F, 0F);
		setRotation(side2, 0F, -0.7853982F, 0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		side1.render(scale);
		side2.render(scale);
	}
}