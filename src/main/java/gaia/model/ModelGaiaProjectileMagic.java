package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGaiaProjectileMagic extends ModelBase
{
	//fields
	ModelRenderer body1;

	public ModelGaiaProjectileMagic()
	{
		textureWidth = 64;
		textureHeight = 32;

		body1 = new ModelRenderer(this, 0, 0);
		body1.addBox(-2F, -2F, -2F, 4, 4, 4);
		body1.setRotationPoint(0F, 0F, 0F);
		body1.setTextureSize(64, 32);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		this.setRotationAngles(par2, par3, par4, par5, par6, par7, entity);
		body1.render(par7);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        this.body1.rotateAngleY = par4 / (180F / (float)Math.PI);
        this.body1.rotateAngleX = par5 / (180F / (float)Math.PI);
	}
}