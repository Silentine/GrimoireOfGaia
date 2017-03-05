package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSharko extends ModelBase {
	ModelRenderer head;
	ModelRenderer headsnout;
	ModelRenderer headjaw;
	ModelRenderer finback;
	ModelRenderer bodyback;
	ModelRenderer bodyfront;
	ModelRenderer bodymid;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightpauldron;
	ModelRenderer rightarmfin;
	ModelRenderer rightarmlower;
	ModelRenderer leftpauldron;
	ModelRenderer leftarmfin;
	ModelRenderer leftarmlower;
	ModelRenderer waist;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tailend;
	ModelRenderer rightleg;
	ModelRenderer rightleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftleg;
	ModelRenderer leftleglower;
	ModelRenderer leftfoot;

	public ModelGaiaSharko() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8);
		this.head.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(this.head, 0.1745329F, 0.0F, 0.0F);
		this.headsnout = new ModelRenderer(this, 0, 33);
		this.headsnout.addBox(-3.5F, -7.5F, -5.0F, 7, 4, 6);
		this.headsnout.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.headsnout.setTextureSize(64, 32);
		this.setRotation(this.headsnout, 0.6981317F, 0.0F, 0.0F);
		this.headjaw = new ModelRenderer(this, 0, 43);
		this.headjaw.addBox(-3.0F, -3.0F, -5.0F, 6, 4, 5);
		this.headjaw.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.headjaw.setTextureSize(64, 32);
		this.setRotation(this.headjaw, 0.1745329F, 0.0F, 0.0F);
		this.finback = new ModelRenderer(this, 0, 15);
		this.finback.addBox(-0.5F, -14.0F, -4.0F, 1, 8, 10);
		this.finback.setRotationPoint(0.0F, 4.0F, -4.0F);
		this.finback.setTextureSize(64, 32);
		this.setRotation(this.finback, -0.0872665F, 0.0F, 0.0F);
		this.bodyback = new ModelRenderer(this, 32, 12);
		this.bodyback.addBox(-7.0F, -1.0F, 1.0F, 14, 8, 4);
		this.bodyback.setRotationPoint(0.0F, -1.0F, -3.0F);
		this.bodyback.setTextureSize(64, 32);
		this.setRotation(this.bodyback, 0.3490659F, 0.0F, 0.0F);
		this.bodyfront = new ModelRenderer(this, 32, 0);
		this.bodyfront.addBox(-6.0F, 0.0F, -3.0F, 12, 8, 4);
		this.bodyfront.setRotationPoint(0.0F, -1.0F, -3.0F);
		this.bodyfront.setTextureSize(64, 32);
		this.setRotation(this.bodyfront, 0.3490659F, 0.0F, 0.0F);
		this.bodymid = new ModelRenderer(this, 32, 24);
		this.bodymid.addBox(-2.0F, 5.0F, 0.0F, 8, 5, 6);
		this.bodymid.setRotationPoint(-2.0F, 0.0F, -3.0F);
		this.bodymid.setTextureSize(64, 32);
		this.setRotation(this.bodymid, 0.1745329F, 0.0F, 0.0F);
		this.rightarm = new ModelRenderer(this, 68, 10);
		this.rightarm.addBox(-3F, -2F, -1.5F, 3, 8, 3);
		this.rightarm.setRotationPoint(-7F, 2F, -1F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0.5235988F, -0.2617994F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 68, 10);
		this.leftarm.addBox(0F, -2F, -1.5F, 3, 8, 3);
		this.leftarm.setRotationPoint(7F, 2F, -1F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.5235988F, 0.2617994F, -0.2617994F);
		this.rightpauldron = new ModelRenderer(this, 68, 0);
		this.rightpauldron.addBox(-4F, -5F, -2.5F, 7, 5, 5);
		this.rightpauldron.setRotationPoint(-7F, 2F, -1F);
		this.rightpauldron.setTextureSize(64, 32);
		this.setRotation(rightpauldron, 0.3490659F, 0F, -0.0872665F);
		this.rightarmfin = new ModelRenderer(this, 68, 21);
		this.rightarmfin.addBox(-2F, -1F, 3.5F, 1, 8, 4);
		this.rightarmfin.setRotationPoint(-7F, 2F, -1F);
		this.rightarmfin.setTextureSize(64, 32);
		this.setRotation(rightarmfin, 0F, -0.2617994F, 0.2617994F);
		this.rightarmlower = new ModelRenderer(this, 68, 33);
		this.rightarmlower.addBox(-3.5F, 3F, 1.5F, 4, 10, 4);
		this.rightarmlower.setRotationPoint(-7F, 2F, -1F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, 0F, -0.2617994F, 0.2617994F);
		this.leftpauldron = new ModelRenderer(this, 92, 0);
		this.leftpauldron.addBox(-3F, -5F, -2.5F, 7, 5, 5);
		this.leftpauldron.setRotationPoint(7F, 2F, -1F);
		this.leftpauldron.setTextureSize(64, 32);
		this.setRotation(leftpauldron, 0.3490659F, 0F, 0.0872665F);
		this.leftarmfin = new ModelRenderer(this, 68, 21);
		this.leftarmfin.addBox(1F, -1F, 3.5F, 1, 8, 4);
		this.leftarmfin.setRotationPoint(7F, 2F, -1F);
		this.leftarmfin.setTextureSize(64, 32);
		this.setRotation(leftarmfin, 0F, 0.2617994F, -0.2617994F);
		this.leftarmlower = new ModelRenderer(this, 84, 33);
		this.leftarmlower.addBox(-0.5F, 3F, 1.5F, 4, 10, 4);
		this.leftarmlower.setRotationPoint(7F, 2F, -1F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, 0F, 0.2617994F, -0.2617994F);
		this.waist = new ModelRenderer(this, 32, 35);
		this.waist.addBox(-1F, 10F, 3F, 6, 4, 5);
		this.waist.setRotationPoint(-2F, -1F, -3.5F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0F, 0F, 0F);
		this.tail1 = new ModelRenderer(this, 32, 44);
		this.tail1.addBox(0F, 14F, -3F, 4, 4, 4);
		this.tail1.setRotationPoint(-2F, -1F, -3.5F);
		this.tail1.setTextureSize(64, 32);
		this.setRotation(tail1, 0.5235988F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 48, 44);
		this.tail2.addBox(0.5F, 17.5F, -4F, 3, 3, 3);
		this.tail2.setRotationPoint(-2F, -1F, -3.5F);
		this.tail2.setTextureSize(64, 32);
		this.setRotation(tail2, 0.6108652F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 32, 52);
		this.tail3.addBox(1F, 20F, -5F, 2, 6, 2);
		this.tail3.setRotationPoint(-2F, -1F, -3.5F);
		this.tail3.setTextureSize(64, 32);
		this.setRotation(tail3, 0.6981317F, 0F, 0F);
		this.tailend = new ModelRenderer(this, 40, 52);
		this.tailend.addBox(-3F, 22F, -4.5F, 10, 6, 1);
		this.tailend.setRotationPoint(-2F, -1F, -3.5F);
		this.tailend.setTextureSize(64, 32);
		this.setRotation(tailend, 0.6981317F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 100, 10);
		this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
		this.rightleg.setRotationPoint(-3.0F, 11.0F, 2.0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(this.rightleg, -0.5585054F, 0.0F, 0.0349066F);
		this.rightleglower = new ModelRenderer(this, 100, 21);
		this.rightleglower.addBox(-1.5F, 1.0F, -6.0F, 3, 3, 3);
		this.rightleglower.setRotationPoint(-3.0F, 13.0F, 2.0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(this.rightleglower, 0.3490659F, 0.0F, 0.0349066F);
		this.rightfoot = new ModelRenderer(this, 100, 27);
		this.rightfoot.addBox(-2.0F, 4.0F, -3.0F, 4, 8, 4);
		this.rightfoot.setRotationPoint(-3.0F, 13.0F, 2.0F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(this.rightfoot, -0.1745329F, 0.0F, 0.0349066F);
		this.leftleg = new ModelRenderer(this, 100, 10);
		this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4);
		this.leftleg.setRotationPoint(3.0F, 11.0F, 2.0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(this.leftleg, -0.5759587F, 0.0F, -0.0349066F);
		this.leftleglower = new ModelRenderer(this, 100, 21);
		this.leftleglower.addBox(-1.5F, 1.0F, -6.0F, 3, 3, 3);
		this.leftleglower.setRotationPoint(3.0F, 13.0F, 2.0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(this.leftleglower, 0.3490659F, 0.0F, -0.0349066F);
		this.leftfoot = new ModelRenderer(this, 100, 27);
		this.leftfoot.addBox(-2.0F, 4.0F, -3.0F, 4, 8, 4);
		this.leftfoot.setRotationPoint(3.0F, 13.0F, 2.0F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(this.leftfoot, -0.1745329F, 0.0F, -0.0349066F);
		
		this.convertToChild(head, headsnout);
		this.convertToChild(head, headjaw);
		this.convertToChild(rightarm, rightpauldron);
		this.convertToChild(rightarm, rightarmfin);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftpauldron);
		this.convertToChild(leftarm, leftarmfin);
		this.convertToChild(leftarm, leftarmlower);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
//		this.headsnout.render(par7);
//		this.headjaw.render(par7);
		this.finback.render(par7);
		this.bodyback.render(par7);
		this.bodyfront.render(par7);
		this.bodymid.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
//		this.rightpauldron.render(par7);
//		this.rightarmfin.render(par7);
//		this.rightarmlower.render(par7);
//		this.leftpauldron.render(par7);
//		this.leftarmfin.render(par7);
//		this.leftarmlower.render(par7);
		this.waist.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.tail3.render(par7);
		this.tailend.render(par7);
		this.rightleg.render(par7);
		this.rightleglower.render(par7);
		this.rightfoot.render(par7);
		this.leftleg.render(par7);
		this.leftleglower.render(par7);
		this.leftfoot.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.finback.rotateAngleY = this.head.rotateAngleY;
		
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
            
            this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
            this.rightarm.rotateAngleX += (this.bodyfront.rotateAngleY * 2.0F);
            this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
        this.rightarm.rotateAngleX += (MathHelper.sin(par3 * 0.067F) * 0.05F) + 0.5235988F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) + 0.2617994F;
        this.leftarm.rotateAngleX -= (MathHelper.sin(par3 * 0.067F) * 0.05F) - 0.5235988F;
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightleglower.rotateAngleX = this.rightleg.rotateAngleX + 0.3490659F;
		this.leftleglower.rotateAngleX = this.leftleg.rotateAngleX + 0.3490659F;
		this.rightfoot.rotateAngleX = this.rightleg.rotateAngleX - 0.1745329F;
		this.leftfoot.rotateAngleX = this.leftleg.rotateAngleX - 0.1745329F;
		this.rightleg.rotateAngleX -= 0.5585054F;
		this.leftleg.rotateAngleX -= 0.5585054F;
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
