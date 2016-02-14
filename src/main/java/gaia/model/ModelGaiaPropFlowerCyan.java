package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaPropFlowerCyan extends ModelBase {
	ModelRenderer headflower1;
	ModelRenderer headflower2;

	public ModelGaiaPropFlowerCyan() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		
		this.headflower1 = new ModelRenderer(this, 0, 0);
		this.headflower1.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		this.headflower1.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.headflower1.setTextureSize(64, 32);
		this.headflower1.mirror = true;
		this.setRotation(this.headflower1, 0.0F, -0.7853982F, 0.0F);
		this.headflower2 = new ModelRenderer(this, 0, 0);
		this.headflower2.addBox(-3.0F, -10.0F, 0.0F, 6, 11, 0);
		this.headflower2.setRotationPoint(0.0F, 23.0F, 0.0F);
		this.headflower2.setTextureSize(64, 32);
		this.headflower2.mirror = true;
		this.setRotation(this.headflower2, 0.0F, 0.7853982F, 0.0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.headflower1.render(par7);
		this.headflower2.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {}
}
