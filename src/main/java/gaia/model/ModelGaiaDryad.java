package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDryad extends ModelGaia {
	ModelRenderer head;
    ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymid;
	ModelRenderer bodymidbutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	public static ModelRenderer rightarm;
	public static ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer waist1;
	ModelRenderer waist2;
	
    protected float scaleAmountHead = 0.75F;
    protected float scaleAmountBody = 0.5F;
    //Increasing the value moves it closer to the ground
    protected float YOffsetHead = 15.5F;
    protected float YOffsetBody = 23.5F;

	public ModelGaiaDryad() {
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
		this.bodymid = new ModelRenderer(this, 0, 25);
		this.bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymid.setRotationPoint(0F, 1F, 0F);
		this.bodymid.setTextureSize(64, 32);
		this.setRotation(bodymid, 0F, 0F, 0F);
		this.bodymidbutton = new ModelRenderer(this, 0, 25);
		this.bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymidbutton.setRotationPoint(0F, 1F, 0F);
		this.bodymidbutton.setTextureSize(64, 32);
		this.setRotation(bodymidbutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(64, 32);
		this.setRotation(leftchest, 0.7853982F, -0.0872665F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0.0872665F, 0F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0.0872665F, 0F, -0.2617994F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, 0F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0F, 0.0349066F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(64, 32);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 25);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(64, 32);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.waist1 = new ModelRenderer(this, 64, 0);
		this.waist1.addBox(-3.466667F, 7.5F, -3F, 7, 6, 4);
		this.waist1.setRotationPoint(0F, 1F, 0F);
		this.waist1.setTextureSize(64, 32);
		this.setRotation(waist1, 0.0872665F, 0F, 0F);
		this.waist2 = new ModelRenderer(this, 64, 10);
		this.waist2.addBox(-4F, 8.5F, -3.5F, 8, 8, 4);
		this.waist2.setRotationPoint(0F, 1F, 0F);
		this.waist2.setTextureSize(64, 32);
		this.setRotation(waist2, 0.1745329F, 0F, 0F);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        
        ItemStack itemstack = ((EntityLivingBase)entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST);

        if (itemstack == null || itemstack.getItem() != Items.EGG) {
        	this.head.render(scale);
        	this.headaccessory.render(scale);
        	this.neck.render(scale);
        	this.bodytop.render(scale);
        	this.bodymid.render(scale);
        	this.bodymidbutton.render(scale);
        	this.bodybottom.render(scale);
        	this.rightchest.render(scale);
        	this.leftchest.render(scale);
        	this.rightarm.render(scale);
        	this.leftarm.render(scale);
        	this.rightleg.render(scale);
        	this.leftleg.render(scale);
        	this.hair1.render(scale);
        	this.hair2.render(scale);
        	this.waist1.render(scale);
        	this.waist2.render(scale);

        	if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F)
        		this.headeyes.render(scale);

        } else {
        	float f = 2.0F;
        	//================= Scaling =================//
        	GlStateManager.pushMatrix();
        	GlStateManager.scale(scaleAmountHead, scaleAmountHead, scaleAmountHead);
        	GlStateManager.translate(0.0F, this.YOffsetHead * scale, 0.0F);
        	this.head.render(scale);

        	if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
        		this.headeyes.render(scale);
        	}

        	this.headaccessory.render(scale);
        	this.hair1.render(scale);
        	this.hair2.render(scale);
        	GlStateManager.popMatrix();
        	//===========================================//
        	GlStateManager.pushMatrix();
        	GlStateManager.scale(scaleAmountBody, scaleAmountBody, scaleAmountBody);
        	GlStateManager.translate(0.0F, this.YOffsetBody * scale, 0.0F);
        	this.neck.render(scale);
        	this.bodytop.render(scale);
        	this.bodymid.render(scale);
        	this.bodymidbutton.render(scale);
        	this.bodybottom.render(scale);
        	//this.rightchest.render(scale);
        	//this.leftchest.render(scale);
        	this.rightarm.render(scale);
        	this.leftarm.render(scale);
        	this.rightleg.render(scale);
        	this.leftleg.render(scale);
        	this.waist1.render(scale);
        	this.waist2.render(scale);
        	GlStateManager.popMatrix();
        	//===========================================//
        }
    }

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		this.headeyes.rotateAngleY = this.head.rotateAngleY;
		this.headeyes.rotateAngleX = this.head.rotateAngleX;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = (this.head.rotateAngleY) * 0.75F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;
	}
	
	public void holdingMelee(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float f6;
		float f7;
		
		f6 = this.swingProgress;
        f6 = 1.0F - this.swingProgress;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        f7 = MathHelper.sin(f6 * (float)Math.PI);
        float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
        
        this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
        this.rightarm.rotateAngleX += (this.bodytop.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
