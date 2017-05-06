package gaia.model;

import gaia.entity.monster.EntityGaiaCobbleGolem;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/** 
 * @see ModelIronGolem
 */
@SideOnly(Side.CLIENT)
public class ModelGaiaCobbleGolem extends ModelGaia {
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarmupper;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmupper;
	ModelRenderer leftarmlower;
	ModelRenderer bodylower;
	ModelRenderer rightlegupper;
	ModelRenderer rightleglower;
	ModelRenderer leftlegupper;
	ModelRenderer leftleglower;
	
    public ModelGaiaCobbleGolem() {
        this(0.0F);
    }

    public ModelGaiaCobbleGolem(float p_i1161_1_) {
        this(p_i1161_1_, -7.0F);
    }

	public ModelGaiaCobbleGolem(float p_i46362_1_, float p_i46362_2_) {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.0F, -2.0F, -1.0F, 6, 4, 4);
		this.head.setRotationPoint(0.0F, 3.0F, -4.0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(this.head, 0.0872665F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 0, 8);
		this.body.addBox(-7.0F, -6.0F, -4.0F, 14, 12, 8);
		this.body.setRotationPoint(0.0F, 4.0F, 2.0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(this.body, 0.2617994F, 0.0F, 0.0F);
		this.rightarmupper = new ModelRenderer(this, 44, 0);
		this.rightarmupper.addBox(-6.0F, -4.0F, -3.0F, 6, 12, 6);
		this.rightarmupper.setRotationPoint(-7.0F, 2.0F, 3.0F);
		this.rightarmupper.setTextureSize(64, 32);
		this.setRotation(this.rightarmupper, 0.0F, 0.0F, 0.0F);
		this.rightarmlower = new ModelRenderer(this, 44, 18);
		this.rightarmlower.addBox(-5.0F, 8.0F, -2.0F, 4, 14, 4);
		this.rightarmlower.setRotationPoint(-7.0F, 2.0F, 3.0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(this.rightarmlower, 0.0F, 0.0F, 0.0F);
		this.leftarmupper = new ModelRenderer(this, 44, 0);
		this.leftarmupper.addBox(0.0F, -4.0F, -3.0F, 6, 12, 6);
		this.leftarmupper.setRotationPoint(7.0F, 2.0F, 3.0F);
		this.leftarmupper.setTextureSize(64, 32);
		this.setRotation(this.leftarmupper, 0.0F, 0.0F, 0.0F);
		this.leftarmlower = new ModelRenderer(this, 44, 18);
		this.leftarmlower.addBox(1.0F, 8.0F, -2.0F, 4, 14, 4);
		this.leftarmlower.setRotationPoint(7.0F, 2.0F, 3.0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(this.leftarmlower, 0.0F, 0.0F, 0.0F);
		this.bodylower = new ModelRenderer(this, 0, 28);
		this.bodylower.addBox(-1.0F, 11.0F, -3.0F, 8, 4, 6);
		this.bodylower.setRotationPoint(-3.0F, -1.0F, 3.0F);
		this.bodylower.setTextureSize(64, 32);
		this.setRotation(this.bodylower, 0.0872665F, 0.0F, 0.0F);
		this.rightlegupper = new ModelRenderer(this, 44, 36);
		this.rightlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		this.rightlegupper.setRotationPoint(-3.0F, 13.0F, 4.0F);
		this.rightlegupper.setTextureSize(64, 32);
		this.setRotation(this.rightlegupper, -0.1745329F, 0.0F, 0.0F);
		this.rightleglower = new ModelRenderer(this, 44, 45);
		this.rightleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		this.rightleglower.setRotationPoint(-3.0F, 13.0F, 4.0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(this.rightleglower, -0.1745329F, 0.0F, 0.0F);
		this.leftlegupper = new ModelRenderer(this, 44, 36);
		this.leftlegupper.addBox(-1.5F, 1.0F, -1.5F, 3, 6, 3);
		this.leftlegupper.setRotationPoint(3.0F, 13.0F, 4.0F);
		this.leftlegupper.setTextureSize(64, 32);
		this.setRotation(this.leftlegupper, -0.1745329F, 0.0F, 0.0F);
		this.leftleglower = new ModelRenderer(this, 44, 45);
		this.leftleglower.addBox(-2.0F, 5.0F, 0.0F, 4, 6, 4);
		this.leftleglower.setRotationPoint(3.0F, 13.0F, 4.0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(this.leftleglower, -0.1745329F, 0.0F, 0.0F);
		
		this.convertToChild(rightarmupper, rightarmlower);
		this.convertToChild(leftarmupper, leftarmlower);
		this.convertToChild(rightlegupper, rightleglower);
		this.convertToChild(leftlegupper, leftleglower);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
		this.body.render(scale);
		this.rightarmupper.render(scale);
		this.leftarmupper.render(scale);
		this.bodylower.render(scale);
		this.rightlegupper.render(scale);
		this.leftlegupper.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		
		//arms
		
		//legs
		this.rightlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightlegupper.rotateAngleX -= 0.1745329F;
		this.leftlegupper.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leftlegupper.rotateAngleX -= 0.1745329F;
	}
	
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime) {
		EntityGaiaCobbleGolem entitygaiacobblegolem = (EntityGaiaCobbleGolem)entitylivingbaseIn;
		int i = entitygaiacobblegolem.getAttackTimer();

		if (i > 0) {
			this.rightarmupper.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - partialTickTime, 10.0F);
			this.leftarmupper.rotateAngleX = -2.0F + 1.5F * this.func_78172_a((float)i - partialTickTime, 10.0F);
		}
	}
	
    private float func_78172_a(float p_78172_1_, float p_78172_2_) {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
