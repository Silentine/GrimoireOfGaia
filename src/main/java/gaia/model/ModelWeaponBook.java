package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWeaponBook extends ModelBase {
	ModelRenderer rightcover;
	ModelRenderer leftcover;
	ModelRenderer spine;
	ModelRenderer rightpage;
	ModelRenderer leftpage;
	ModelRenderer middlepage;
	
	ModelRenderer rightcoveropposite;
	ModelRenderer leftcoveropposite;

	public ModelWeaponBook() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		float x = 0.0F;
		float y = 0.0F;
		float z = 16.0F;

		this.rightcover = new ModelRenderer(this, 12, 0);
		this.rightcover.addBox(-6F, -5F, 0F, 6, 10, 0);
		this.rightcover.setRotationPoint(-1F, 0F, 0F);
		this.rightcover.setTextureSize(64, 32);
		this.setRotation(rightcover, 0F, 1.396263F, 0F);
		this.leftcover = new ModelRenderer(this, 0, 0);
		this.leftcover.addBox(-6F, -5F, 0F, 6, 10, 0);
		this.leftcover.setRotationPoint(1F, 0F, 0F);
		this.leftcover.setTextureSize(64, 32);
		this.setRotation(leftcover, 0F, 1.745329F, 0F);
		this.spine = new ModelRenderer(this, 0, 10);
		this.spine.addBox(0F, -5F, -1F, 0, 10, 2);
		this.spine.setRotationPoint(0F, 0F, 0F);
		this.spine.setTextureSize(64, 32);
		this.setRotation(spine, 0F, -1.570796F, 0F);
		this.rightpage = new ModelRenderer(this, 12, 22);
		this.rightpage.addBox(0.2F, -4F, 0F, 5, 8, 1);
		this.rightpage.setRotationPoint(0F, 0F, 0F);
		this.rightpage.setTextureSize(64, 32);
		this.setRotation(rightpage, 0F, -1.658063F, 0F);
		this.leftpage = new ModelRenderer(this, 0, 22);
		this.leftpage.addBox(0.2F, -4F, -1F, 5, 8, 1);
		this.leftpage.setRotationPoint(0F, 0F, 0F);
		this.leftpage.setTextureSize(64, 32);
		this.setRotation(leftpage, 0F, -1.48353F, 0F);
		this.middlepage = new ModelRenderer(this, 24, 0);
		this.middlepage.addBox(0.2F, -4F, 0F, 5, 8, 0);
		this.middlepage.setRotationPoint(0F, 0F, 0F);
		this.middlepage.setTextureSize(64, 32);
		this.setRotation(middlepage, 0F, -1.570796F, 0F);
		
		this.rightcoveropposite = new ModelRenderer(this, 12, 0);
		this.rightcoveropposite.addBox(-6F, -5F, 0F, 6, 10, 0);
		this.rightcoveropposite.setRotationPoint(-1F, 0F, 0F);
		this.rightcoveropposite.setTextureSize(64, 32);
		this.setRotation(rightcoveropposite, 0F, 1.396263F, 0F);
		this.leftcoveropposite = new ModelRenderer(this, 0, 0);
		this.leftcoveropposite.addBox(-6F, -5F, 0F, 6, 10, 0);
		this.leftcoveropposite.setRotationPoint(1F, 0F, 0F);
		this.leftcoveropposite.setTextureSize(64, 32);
		this.setRotation(leftcoveropposite, 0F, 1.745329F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, boolean isFirstPerson) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.rightcover.render(f5);
		this.leftcover.render(f5);
		this.spine.render(f5);
		this.rightpage.render(f5);
		this.leftpage.render(f5);
		this.middlepage.render(f5);

		if(isFirstPerson) {
			this.rightcover.render(f5);
			this.leftcover.render(f5);
		} else {
			this.rightcoveropposite.render(f5);
			this.leftcoveropposite.render(f5);
		}
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}


	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
	}
}