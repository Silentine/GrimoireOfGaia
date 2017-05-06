package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaPropChestMimic extends ModelGaia {
	ModelRenderer body;
	ModelRenderer lock;

	public ModelGaiaPropChestMimic() {
		this.textureWidth = 64;
		this.textureHeight = 32;

        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-8F, -8F, -8F, 14, 14, 14);
        this.body.setRotationPoint(1F, 18F, 1F);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(body, 0F, 0F, 0F);
        this.lock = new ModelRenderer(this, 0, 0);
        this.lock.addBox(-2F, -5F, -9F, 2, 4, 1);
        this.lock.setRotationPoint(1F, 18F, 1F);
        this.lock.setTextureSize(64, 32);
        this.lock.mirror = true;
        this.setRotation(lock, 0F, 0F, 0F);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.body.render(scale);
		this.lock.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {}
}