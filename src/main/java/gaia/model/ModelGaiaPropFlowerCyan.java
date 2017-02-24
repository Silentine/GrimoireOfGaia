package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaPropFlowerCyan extends ModelGaia {
	ModelRenderer headflower1;
	ModelRenderer headflower2;

	public ModelGaiaPropFlowerCyan() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.headflower1 = new ModelRenderer(this, 0, 0);
		this.headflower1.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		this.headflower1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.headflower1.setTextureSize(64, 32);
		this.setRotation(this.headflower1, 0.0F, -0.7853982F, 0.0F);
		this.headflower2 = new ModelRenderer(this, 0, 0);
		this.headflower2.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		this.headflower2.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.headflower2.setTextureSize(64, 32);
		this.setRotation(this.headflower2, 0.0F, 0.7853982F, 0.0F);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.headflower1.render(scale);
		this.headflower2.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {}
}
