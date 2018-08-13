package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaPropFlowerCyan extends ModelGaia {
	private ModelRenderer headflower1;
	private ModelRenderer headflower2;

	public ModelGaiaPropFlowerCyan() {
		textureWidth = 64;
		textureHeight = 32;

		headflower1 = new ModelRenderer(this, 0, 0);
		headflower1.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		headflower1.setRotationPoint(0.0F, 23.0F, 0.0F);
		headflower1.setTextureSize(64, 32);
		setRotation(headflower1, 0.0F, -0.7853982F, 0.0F);
		headflower2 = new ModelRenderer(this, 0, 0);
		headflower2.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		headflower2.setRotationPoint(0.0F, 23.0F, 0.0F);
		headflower2.setTextureSize(64, 32);
		setRotation(headflower2, 0.0F, 0.7853982F, 0.0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		headflower1.render(scale);
		headflower2.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
		//noop
	}
}
