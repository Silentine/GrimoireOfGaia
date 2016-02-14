package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TileModelDollSlimeGirl extends ModelBase {
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer hairpinright;
	ModelRenderer hairpinleft;
	ModelRenderer hairright;
	ModelRenderer hairleft;
	ModelRenderer upperbody;
	ModelRenderer lowerbody;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer waist;
	ModelRenderer rightleg;
	ModelRenderer leftleg;

	public TileModelDollSlimeGirl()
	{
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 15F, 2F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0.0872665F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 15F, 2F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0.0872665F, 0F, 0F);
		this.hairpinright = new ModelRenderer(this, 36, 14);
		this.hairpinright.addBox(-6F, -7F, 2F, 4, 4, 4);
		this.hairpinright.setRotationPoint(0F, 15F, 1F);
		this.hairpinright.setTextureSize(64, 32);
		this.hairpinright.mirror = true;
		this.setRotation(hairpinright, 0.0872665F, -0.1745329F, 0.1745329F);
		this.hairpinleft = new ModelRenderer(this, 52, 14);
		this.hairpinleft.addBox(2F, -7F, 2F, 4, 4, 4);
		this.hairpinleft.setRotationPoint(0F, 15F, 1F);
		this.hairpinleft.setTextureSize(64, 32);
		this.hairpinleft.mirror = true;
		this.setRotation(hairpinleft, 0.0872665F, 0.1745329F, -0.1745329F);
		this.hairright = new ModelRenderer(this, 36, 22);
		this.hairright.addBox(-5.5F, -3F, 2.5F, 3, 7, 3);
		this.hairright.setRotationPoint(0F, 15F, 1F);
		this.hairright.setTextureSize(64, 32);
		this.hairright.mirror = true;
		this.setRotation(hairright, 0.0872665F, -0.1745329F, 0.1745329F);
		this.hairleft = new ModelRenderer(this, 36, 22);
		this.hairleft.addBox(2.5F, -3F, 2.5F, 3, 7, 3);
		this.hairleft.setRotationPoint(0F, 15F, 1F);
		this.hairleft.setTextureSize(64, 32);
		this.hairleft.mirror = true;
		this.setRotation(hairleft, 0.0872665F, 0.1745329F, -0.1745329F);
		this.upperbody = new ModelRenderer(this, 0, 12);
		this.upperbody.addBox(-2.5F, -4F, -1.5F, 5, 4, 3);
		this.upperbody.setRotationPoint(0F, 19F, 2F);
		this.upperbody.setTextureSize(64, 32);
		this.upperbody.mirror = true;
		this.setRotation(upperbody, 0F, 0F, 0F);
		this.lowerbody = new ModelRenderer(this, 0, 19);
		this.lowerbody.addBox(-2.5F, 0F, -1.5F, 5, 4, 3);
		this.lowerbody.setRotationPoint(0F, 19F, 2F);
		this.lowerbody.setTextureSize(64, 32);
		this.lowerbody.mirror = true;
		this.setRotation(lowerbody, -0.1745329F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 26);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 17F, 0.5F);
		this.rightchest.setTextureSize(64, 32);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 8, 26);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 17F, 0.5F);
		this.leftchest.setTextureSize(64, 32);
		this.leftchest.mirror = true;
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 7, 2);
		this.rightarm.setRotationPoint(-2.5F, 16.5F, 2F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 7, 2);
		this.leftarm.setRotationPoint(2.5F, 16.5F, 2F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.waist = new ModelRenderer(this, 36, 32);
		this.waist.addBox(-3F, 4F, -2F, 6, 2, 4);
		this.waist.setRotationPoint(0F, 18F, 2F);
		this.waist.setTextureSize(64, 32);
		this.waist.mirror = true;
		this.setRotation(waist, -0.1745329F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 7, 2);
		this.rightleg.setRotationPoint(-1.5F, 23F, 2F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, -1.570796F, 0.1745329F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 7, 2);
		this.leftleg.setRotationPoint(1.5F, 23F, 2F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, -1.570796F, -0.1745329F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.hairpinright.render(par7);
		this.hairpinleft.render(par7);
		this.hairright.render(par7);
		this.hairleft.render(par7);
		this.upperbody.render(par7);
		this.lowerbody.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.waist.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void renderModel(float par7) {
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.hairpinright.render(par7);
		this.hairpinleft.render(par7);
		this.hairright.render(par7);
		this.hairleft.render(par7);
		this.upperbody.render(par7);
		this.lowerbody.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.waist.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
	}
}
