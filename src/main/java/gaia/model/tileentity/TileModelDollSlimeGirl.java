package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileModelDollSlimeGirl extends ModelBase implements IModelBust {
	private ModelRenderer head;
	private ModelRenderer headaccessory;
	private ModelRenderer hairpinright;
	private ModelRenderer hairpinleft;
	private ModelRenderer hairright;
	private ModelRenderer hairleft;
	private ModelRenderer upperbody;
	private ModelRenderer lowerbody;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer waist;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;

	public TileModelDollSlimeGirl() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 15F, 2F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.0872665F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 15F, 2F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0.0872665F, 0F, 0F);
		hairpinright = new ModelRenderer(this, 36, 14);
		hairpinright.addBox(-6F, -7F, 2F, 4, 4, 4);
		hairpinright.setRotationPoint(0F, 15F, 1F);
		hairpinright.setTextureSize(64, 32);
		setRotation(hairpinright, 0.0872665F, -0.1745329F, 0.1745329F);
		hairpinleft = new ModelRenderer(this, 52, 14);
		hairpinleft.addBox(2F, -7F, 2F, 4, 4, 4);
		hairpinleft.setRotationPoint(0F, 15F, 1F);
		hairpinleft.setTextureSize(64, 32);
		setRotation(hairpinleft, 0.0872665F, 0.1745329F, -0.1745329F);
		hairright = new ModelRenderer(this, 36, 22);
		hairright.addBox(-5.5F, -3F, 2.5F, 3, 7, 3);
		hairright.setRotationPoint(0F, 15F, 1F);
		hairright.setTextureSize(64, 32);
		setRotation(hairright, 0.0872665F, -0.1745329F, 0.1745329F);
		hairleft = new ModelRenderer(this, 36, 22);
		hairleft.addBox(2.5F, -3F, 2.5F, 3, 7, 3);
		hairleft.setRotationPoint(0F, 15F, 1F);
		hairleft.setTextureSize(64, 32);
		setRotation(hairleft, 0.0872665F, 0.1745329F, -0.1745329F);
		upperbody = new ModelRenderer(this, 0, 12);
		upperbody.addBox(-2.5F, -4F, -1.5F, 5, 4, 3);
		upperbody.setRotationPoint(0F, 19F, 2F);
		upperbody.setTextureSize(64, 32);
		setRotation(upperbody, 0F, 0F, 0F);
		lowerbody = new ModelRenderer(this, 0, 19);
		lowerbody.addBox(-2.5F, 0F, -1.5F, 5, 4, 3);
		lowerbody.setRotationPoint(0F, 19F, 2F);
		lowerbody.setTextureSize(64, 32);
		setRotation(lowerbody, -0.1745329F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 26);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 17F, 0.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 8, 26);
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 17F, 0.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 7, 2);
		rightarm.setRotationPoint(-2.5F, 16.5F, 2F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 7, 2);
		leftarm.setRotationPoint(2.5F, 16.5F, 2F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		waist = new ModelRenderer(this, 36, 32);
		waist.addBox(-3F, 4F, -2F, 6, 2, 4);
		waist.setRotationPoint(0F, 18F, 2F);
		waist.setTextureSize(64, 32);
		setRotation(waist, -0.1745329F, 0F, 0F);
		rightleg = new ModelRenderer(this, 24, 12);
		rightleg.addBox(-1F, 0F, -1F, 2, 7, 2);
		rightleg.setRotationPoint(-1.5F, 23F, 2F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -1.570796F, 0.1745329F, 0F);
		leftleg = new ModelRenderer(this, 24, 12);
		leftleg.addBox(-1F, 0F, -1F, 2, 7, 2);
		leftleg.setRotationPoint(1.5F, 23F, 2F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -1.570796F, -0.1745329F, 0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		headaccessory.render(scale);
		hairpinright.render(scale);
		hairpinleft.render(scale);
		hairright.render(scale);
		hairleft.render(scale);
		upperbody.render(scale);
		lowerbody.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void renderModel(float scale) {
		head.render(scale);
		headaccessory.render(scale);
		hairpinright.render(scale);
		hairpinleft.render(scale);
		hairright.render(scale);
		hairleft.render(scale);
		upperbody.render(scale);
		lowerbody.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}
}
