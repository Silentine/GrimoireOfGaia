package gaia.model;

import gaia.entity.monster.EntityGaiaCobblestoneGolem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaCobblestoneGolem extends ModelBase {
	ModelRenderer crown;
	ModelRenderer head;
	ModelRenderer nose;
	ModelRenderer mouth;
	ModelRenderer back;
	ModelRenderer rightshoulder;
	ModelRenderer rightarmupper;
	ModelRenderer rightarmlower;
	ModelRenderer righthand;
	ModelRenderer leftshoulder;
	ModelRenderer leftarmupper;
	ModelRenderer leftarmlower;
	ModelRenderer lefthand;
	ModelRenderer body;
	ModelRenderer bodymid;
	ModelRenderer bodylower;
	ModelRenderer rightlegupper;
	ModelRenderer rightleglower;
	ModelRenderer leftlegupper;
	ModelRenderer leftleglower;
	
    public ModelGaiaCobblestoneGolem() {
        this(0.0F);
    }

    public ModelGaiaCobblestoneGolem(float p_i1161_1_) {
        this(p_i1161_1_, -7.0F);
    }

	public ModelGaiaCobblestoneGolem(float p_i46362_1_, float p_i46362_2_) {
		this.textureWidth = 256;
		this.textureHeight = 128;

		this.crown = new ModelRenderer(this, 32, 0);
		this.crown.addBox(-2.0F, -10.0F, -5.0F, 4, 4, 1);
		this.crown.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.crown.setTextureSize(64, 32);
		this.setRotation(this.crown, 0.2617994F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		this.head.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(this.head, 0.2617994F, 0.0F, 0.0F);
		this.nose = new ModelRenderer(this, 32, 5);
		this.nose.addBox(-1.0F, -5.0F, -5.0F, 2, 3, 1);
		this.nose.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.nose.setTextureSize(64, 32);
		this.setRotation(this.nose, 0.2617994F, 0.0F, 0.0F);
		this.mouth = new ModelRenderer(this, 32, 9);
		this.mouth.addBox(-2.0F, -1.0F, -5.0F, 4, 2, 2);
		this.mouth.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.mouth.setTextureSize(64, 32);
		this.setRotation(this.mouth, 0.2617994F, 0.0F, 0.0F);
		this.back = new ModelRenderer(this, 0, 16);
		this.back.addBox(-6.0F, -3.0F, -0.5F, 12, 5, 5);
		this.back.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.back.setTextureSize(64, 32);
		this.setRotation(this.back, 0.9599311F, 0.0F, 0.0F);
		this.rightshoulder = new ModelRenderer(this, 45, 0);
		this.rightshoulder.addBox(-7.0F, -3.5F, -3.5F, 9, 8, 9);
		this.rightshoulder.setRotationPoint(-7.0F, -5.0F, 0.0F);
		this.rightshoulder.setTextureSize(64, 32);
		this.setRotation(this.rightshoulder, 0.1745329F, 0.0F, -0.2617994F);
		this.rightarmupper = new ModelRenderer(this, 45, 17);
		this.rightarmupper.addBox(-4.0F, -1.0F, -2.0F, 5, 11, 5);
		this.rightarmupper.setRotationPoint(-7.0F, -5.0F, 0.0F);
		this.rightarmupper.setTextureSize(64, 32);
		this.setRotation(this.rightarmupper, -0.0872665F, 0.0F, 0.1745329F);
		this.rightarmlower = new ModelRenderer(this, 45, 33);
		this.rightarmlower.addBox(-4.0F, 9.0F, 2.0F, 5, 11, 5);
		this.rightarmlower.setRotationPoint(-7.0F, -5.0F, 0.0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(this.rightarmlower, -0.5235988F, 0.0F, 0.1745329F);
		this.righthand = new ModelRenderer(this, 45, 49);
		this.righthand.addBox(-5.0F, 12.0F, 1.0F, 7, 9, 7);
		this.righthand.setRotationPoint(-7.0F, -5.0F, 0.0F);
		this.righthand.setTextureSize(64, 32);
		this.setRotation(this.righthand, -0.5235988F, 0.0F, 0.1745329F);
		this.leftshoulder = new ModelRenderer(this, 81, 0);
		this.leftshoulder.addBox(-2.0F, -3.5F, -3.5F, 9, 8, 9);
		this.leftshoulder.setRotationPoint(7.0F, -5.0F, 0.0F);
		this.leftshoulder.setTextureSize(64, 32);
		this.setRotation(this.leftshoulder, 0.1745329F, 0.0F, 0.2617994F);
		this.leftarmupper = new ModelRenderer(this, 45, 17);
		this.leftarmupper.addBox(-1.0F, -1.0F, -2.0F, 5, 11, 5);
		this.leftarmupper.setRotationPoint(7.0F, -5.0F, 0.0F);
		this.leftarmupper.setTextureSize(64, 32);
		this.setRotation(this.leftarmupper, -0.0872665F, 0.0F, -0.1745329F);
		this.leftarmlower = new ModelRenderer(this, 45, 33);
		this.leftarmlower.addBox(-1.0F, 9.0F, 2.0F, 5, 11, 5);
		this.leftarmlower.setRotationPoint(7.0F, -5.0F, 0.0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(this.leftarmlower, -0.5235988F, 0.0F, -0.1745329F);
		this.lefthand = new ModelRenderer(this, 73, 49);
		this.lefthand.addBox(-2.0F, 12.0F, 1.0F, 7, 9, 7);
		this.lefthand.setRotationPoint(7.0F, -5.0F, 0.0F);
		this.lefthand.setTextureSize(64, 32);
		this.setRotation(this.lefthand, -0.5235988F, 0.0F, -0.1745329F);
		this.body = new ModelRenderer(this, 0, 26);
		this.body.addBox(-7.0F, -2.0F, -3.0F, 14, 11, 8);
		this.body.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(this.body, 0.2617994F, 0.0F, 0.0F);
		this.bodymid = new ModelRenderer(this, 0, 61);
		this.bodymid.addBox(-6.5F, 14.0F, 1.0F, 13, 7, 7);
		this.bodymid.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.bodymid.setTextureSize(64, 32);
		this.setRotation(this.bodymid, 0.0F, 0.0F, 0.0F);
		this.bodylower = new ModelRenderer(this, 0, 45);
		this.bodylower.addBox(-6.0F, 7.0F, -1.0F, 12, 10, 6);
		this.bodylower.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.bodylower.setTextureSize(64, 32);
		this.setRotation(this.bodylower, 0.1745329F, 0.0F, 0.0F);
		this.rightlegupper = new ModelRenderer(this, 45, 65);
		this.rightlegupper.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4);
		this.rightlegupper.setRotationPoint(-3.0F, 9.0F, 4.0F);
		this.rightlegupper.setTextureSize(64, 32);
		this.setRotation(this.rightlegupper, -0.2617994F, 0.0F, 0.0F);
		this.rightleglower = new ModelRenderer(this, 45, 79);
		this.rightleglower.addBox(-2.5F, 5.0F, 0.0F, 5, 10, 5);
		this.rightleglower.setRotationPoint(-3.0F, 9.0F, 4.0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(this.rightleglower, -0.2617994F, 0.0F, 0.0F);
		this.leftlegupper = new ModelRenderer(this, 45, 65);
		this.leftlegupper.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4);
		this.leftlegupper.setRotationPoint(3.0F, 9.0F, 4.0F);
		this.leftlegupper.setTextureSize(64, 32);
		this.setRotation(this.leftlegupper, -0.2617994F, 0.0F, 0.0F);
		this.leftleglower = new ModelRenderer(this, 45, 79);
		this.leftleglower.addBox(-2.5F, 5.0F, 0.0F, 5, 10, 5);
		this.leftleglower.setRotationPoint(3.0F, 9.0F, 4.0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(this.leftleglower, -0.2617994F, 0.0F, 0.0F);
		
		this.convertToChild(head, crown);
		this.convertToChild(head, nose);
		this.convertToChild(head, mouth);
		this.convertToChild(rightshoulder, rightarmupper);
		this.convertToChild(rightshoulder, rightarmlower);
		this.convertToChild(rightshoulder, righthand);
		this.convertToChild(leftshoulder, leftarmupper);
		this.convertToChild(leftshoulder, leftarmlower);
		this.convertToChild(leftshoulder, lefthand);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
//		this.crown.render(par7);
//		this.nose.render(par7);
//		this.mouth.render(par7);
		this.back.render(par7);
		this.rightshoulder.render(par7);
//		this.rightarmupper.render(par7);
//		this.rightarmlower.render(par7);
//		this.righthand.render(par7);
		this.leftshoulder.render(par7);
//		this.leftarmupper.render(par7);
//		this.leftarmlower.render(par7);
//		this.lefthand.render(par7);
		this.body.render(par7);
		this.bodymid.render(par7);
		this.bodylower.render(par7);
		this.rightlegupper.render(par7);
		this.rightleglower.render(par7);
		this.leftlegupper.render(par7);
		this.leftleglower.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		//head
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = (par5 / 57.295776F) + 0.2617994F;
		
		//arms
		this.rightshoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.leftshoulder.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		
		this.rightshoulder.rotateAngleZ = 0.0F;
		this.leftshoulder.rotateAngleZ = 0.0F;
        
        this.rightshoulder.rotateAngleZ += (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) - 0.2617994F;
        this.rightshoulder.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
        this.leftshoulder.rotateAngleZ -= (MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F) - 0.2617994F;
        this.leftshoulder.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;
		
		//legs
		this.rightlegupper.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.5F * par2;
		this.leftlegupper.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.5F * par2;
		this.rightleglower.rotateAngleX = this.rightlegupper.rotateAngleX - 0.2617994F;
		this.leftleglower.rotateAngleX = this.leftlegupper.rotateAngleX - 0.2617994F;
		this.rightlegupper.rotateAngleX -= 0.2617994F;
		this.leftlegupper.rotateAngleX -= 0.2617994F;
	}
	
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime) {
		EntityGaiaCobblestoneGolem entitygaiacobblestonegolem = (EntityGaiaCobblestoneGolem)entitylivingbaseIn;
		int i = entitygaiacobblestonegolem.getAttackTimer();

		if (i > 0) {
			this.rightshoulder.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - partialTickTime, 10.0F);
			this.leftshoulder.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - partialTickTime, 10.0F);
		} else {
			int j = entitygaiacobblestonegolem.getHoldRoseTick();

			if (j > 0) {
				this.rightshoulder.rotateAngleX = -0.8F + 0.025F * this.func_78172_a((float)j, 70.0F);
				this.leftshoulder.rotateAngleX = 0.0F;
			} else {
				this.rightshoulder.rotateAngleX = (-0.2F + 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
				this.leftshoulder.rotateAngleX = (-0.2F - 1.5F * this.func_78172_a(p_78086_2_, 13.0F)) * p_78086_3_;
			}
		}
	}
	
    private float func_78172_a(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
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
