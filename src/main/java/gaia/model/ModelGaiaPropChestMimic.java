package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaPropChestMimic extends ModelGaia {
	private ModelRenderer body;
	private ModelRenderer lock;

	public ModelGaiaPropChestMimic() {
		textureWidth = 64;
		textureHeight = 32;

		body = new ModelRenderer(this, 0, 0);
		body.addBox(-8F, -8F, -8F, 14, 14, 14);
		body.setRotationPoint(1F, 18F, 1F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		lock = new ModelRenderer(this, 0, 0);
		lock.addBox(-2F, -5F, -9F, 2, 4, 1);
		lock.setRotationPoint(1F, 18F, 1F);
		lock.setTextureSize(64, 32);
		lock.mirror = true;
		setRotation(lock, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		body.render(scale);
		lock.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
	}
}
