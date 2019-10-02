package gaia.client.model;

import gaia.entity.AbstractMobPropEntity;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGaiaPropFlowerCyan<T extends AbstractMobPropEntity> extends ModelGaia<T> {
	private RendererModel headflower1;
	private RendererModel headflower2;

	public ModelGaiaPropFlowerCyan() {
		textureWidth = 64;
		textureHeight = 32;

		headflower1 = new RendererModel(this, 0, 0);
		headflower1.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		headflower1.setRotationPoint(0.0F, 23.0F, 0.0F);
		headflower1.setTextureSize(64, 32);
		setRotation(headflower1, 0.0F, -0.7853982F, 0.0F);
		headflower2 = new RendererModel(this, 0, 0);
		headflower2.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		headflower2.setRotationPoint(0.0F, 23.0F, 0.0F);
		headflower2.setTextureSize(64, 32);
		setRotation(headflower2, 0.0F, 0.7853982F, 0.0F);
	}

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		headflower1.render(scale);
		headflower2.render(scale);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
	}
}
