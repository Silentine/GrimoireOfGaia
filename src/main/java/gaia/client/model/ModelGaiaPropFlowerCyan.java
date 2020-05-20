package gaia.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import gaia.entity.AbstractMobPropEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaPropFlowerCyan<T extends AbstractMobPropEntity> extends ModelGaia<T> {
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
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		headflower1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		headflower2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
