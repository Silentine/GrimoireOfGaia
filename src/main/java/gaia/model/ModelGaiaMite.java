package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMite extends ModelGaia {
	
	private ModelRenderer head;
	private ModelRenderer body;
	private ModelRenderer back;
	private ModelRenderer rightantenna;
	private ModelRenderer leftantenna;

	public ModelGaiaMite() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2F, -2F, -2F, 4, 3, 2);
		head.setRotationPoint(0F, 23F, -2F);
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 5);
		body.addBox(-3F, -3F, 0F, 6, 4, 5);
		body.setRotationPoint(0F, 23F, -2F);
		setRotation(body, 0F, 0F, 0F);
		back = new ModelRenderer(this, 22, 4);
		back.addBox(-2F, -2F, 0F, 4, 3, 2);
		back.setRotationPoint(0F, 23F, 3F);
		setRotation(back, 0F, 0F, 0F);
		rightantenna = new ModelRenderer(this, 22, 0);
		rightantenna.addBox(0F, -2F, -2F, 0, 2, 2);
		rightantenna.setRotationPoint(-1F, 22F, -3F);
		setRotation(rightantenna, 0F, 0F, 0F);
		leftantenna = new ModelRenderer(this, 22, 0);
		leftantenna.addBox(0F, -2F, -2F, 0, 2, 2);
		leftantenna.setRotationPoint(1F, 22F, -3F);
		setRotation(leftantenna, 0F, 0F, 0F);

		convertToChild(head, rightantenna);
		convertToChild(head, leftantenna);
		convertToChild(body, back);
		convertToChild(head, body);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
	}
}
