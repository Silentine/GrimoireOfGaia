package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMandragora extends ModelBase {
	ModelRenderer head;
    ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer headflower1;
	ModelRenderer headflower2;
	ModelRenderer headhairright;
	ModelRenderer headhairleft;
	ModelRenderer waist;
	ModelRenderer headleaf1;
	ModelRenderer headleaf2;
	ModelRenderer headleaf3;
	ModelRenderer headleaf4;
	ModelRenderer headleafs1;
	ModelRenderer headleafs2;
	ModelRenderer headleafs3;
	ModelRenderer headleafs4;

	public ModelGaiaMandragora() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(64, 32);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(64, 32);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(64, 32);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0.0349066F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.0349066F, 0F, -0.0872665F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0.0349066F, 0F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0.0349066F, 0F, 0.0349066F);
		this.headflower1 = new ModelRenderer(this, 36, 28);
		this.headflower1.addBox(-3F, -12.5F, 0F, 6, 6, 0);
		this.headflower1.setRotationPoint(0F, 1F, 0F);
		this.headflower1.setTextureSize(64, 32);
		this.setRotation(headflower1, 0F, -0.7853982F, 0F);
		this.headflower2 = new ModelRenderer(this, 36, 28);
		this.headflower2.addBox(-3F, -12.5F, 0F, 6, 6, 0);
		this.headflower2.setRotationPoint(0F, 1F, 0F);
		this.headflower2.setTextureSize(64, 32);
		this.setRotation(headflower2, 0F, 0.7853982F, 0F);
		this.headhairright = new ModelRenderer(this, 36, 34);
		this.headhairright.addBox(-4.5F, -2F, 0.5F, 4, 14, 4);
		this.headhairright.setRotationPoint(0F, 1F, 0F);
		this.headhairright.setTextureSize(64, 32);
		this.setRotation(headhairright, 0.0436332F, 0F, 0.0436332F);
		this.headhairleft = new ModelRenderer(this, 36, 34);
		this.headhairleft.addBox(0.5F, -2F, 0.5F, 4, 14, 4);
		this.headhairleft.setRotationPoint(0F, 1F, 0F);
		this.headhairleft.setTextureSize(64, 32);
		this.setRotation(headhairleft, 0.0436332F, 0F, -0.0436332F);
		this.waist = new ModelRenderer(this, 36, 52);
		this.waist.addBox(-3.5F, 8.5F, -3F, 7, 5, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.headleaf1 = new ModelRenderer(this, 36, 14);
		this.headleaf1.addBox(-3F, -10F, -6F, 6, 8, 0);
		this.headleaf1.setRotationPoint(0F, 1F, 0F);
		this.headleaf1.setTextureSize(64, 32);
		this.setRotation(headleaf1, -1.308997F, -0.7853982F, 0F);
		this.headleaf2 = new ModelRenderer(this, 36, 14);
		this.headleaf2.addBox(-3F, -10F, -6F, 6, 8, 0);
		this.headleaf2.setRotationPoint(0F, 1F, 0F);
		this.headleaf2.setTextureSize(64, 32);
		this.setRotation(headleaf2, -1.308997F, 0.7853982F, 0F);
		this.headleaf3 = new ModelRenderer(this, 36, 14);
		this.headleaf3.addBox(-3F, -10F, -6F, 6, 8, 0);
		this.headleaf3.setRotationPoint(0F, 1F, 0F);
		this.headleaf3.setTextureSize(64, 32);
		this.setRotation(headleaf3, -1.308997F, 2.356194F, 0F);
		this.headleaf4 = new ModelRenderer(this, 36, 14);
		this.headleaf4.addBox(-3F, -10F, -6F, 6, 8, 0);
		this.headleaf4.setRotationPoint(0F, 1F, 0F);
		this.headleaf4.setTextureSize(64, 32);
		this.setRotation(headleaf4, -1.308997F, -2.356194F, 0F);
		this.headleafs1 = new ModelRenderer(this, 36, 22);
		this.headleafs1.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		this.headleafs1.setRotationPoint(0F, 1F, 0F);
		this.headleafs1.setTextureSize(64, 32);
		this.setRotation(headleafs1, -1.047198F, 0F, 0F);
		this.headleafs2 = new ModelRenderer(this, 36, 22);
		this.headleafs2.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		this.headleafs2.setRotationPoint(0F, 1F, 0F);
		this.headleafs2.setTextureSize(64, 32);
		this.setRotation(headleafs2, -1.047198F, 1.570796F, 0F);
		this.headleafs3 = new ModelRenderer(this, 36, 22);
		this.headleafs3.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		this.headleafs3.setRotationPoint(0F, 1F, 0F);
		this.headleafs3.setTextureSize(64, 32);
		this.setRotation(headleafs3, -1.047198F, 3.141593F, 0F);
		this.headleafs4 = new ModelRenderer(this, 36, 22);
		this.headleafs4.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
		this.headleafs4.setRotationPoint(0F, 1F, 0F);
		this.headleafs4.setTextureSize(64, 32);
		this.setRotation(headleafs4, -1.047198F, -1.570796F, 0F);
		
		this.convertToChild(head, headflower1);
		this.convertToChild(head, headflower2);
		this.convertToChild(head, headleaf1);
		this.convertToChild(head, headleaf2);
		this.convertToChild(head, headleaf3);
		this.convertToChild(head, headleaf4);
		this.convertToChild(head, headleafs1);
		this.convertToChild(head, headleafs2);
		this.convertToChild(head, headleafs3);
		this.convertToChild(head, headleafs4);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.neck.render(par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodymiddlebutton.render(par7);
		this.bodybottom.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
//		this.headflower1.render(par7);
//		this.headflower2.render(par7);
		this.headhairright.render(par7);
		this.headhairleft.render(par7);
		this.waist.render(par7);
//		this.headleaf1.render(par7);
//		this.headleaf2.render(par7);
//		this.headleaf3.render(par7);
//		this.headleaf4.render(par7);
//		this.headleafs1.render(par7);
//		this.headleafs2.render(par7);
//		this.headleafs3.render(par7);
//		this.headleafs4.render(par7);

		if (entity.ticksExisted % 60 == 0 && par3 <= 0.1F) {
			this.headeyes.render(par7);
		} 
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.headhairright.rotateAngleY = this.head.rotateAngleY;
		this.headhairleft.rotateAngleY = this.head.rotateAngleY;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
        
		float f6;
        float f7;

        if (this.swingProgress > -9990.0F) {
            f6 = this.swingProgress;
            f6 = 1.0F - this.swingProgress;
            f6 *= f6;
            f6 *= f6;
            f6 = 1.0F - f6;
            f7 = MathHelper.sin(f6 * (float)Math.PI);
            float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8)) + 0.0872665F;
            this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.025F;
        
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.rightleg.rotateAngleX += 0.0349066F;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.leftleg.rotateAngleX += 0.0349066F;
	}
	
	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		parParent.addChild(parChild);
	}
}
