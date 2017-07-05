package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaAnubis extends ModelGaia {
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
	ModelRenderer crown;
	ModelRenderer rightear;
	ModelRenderer leftear;
	ModelRenderer mantle;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer rightarmhand;
	ModelRenderer leftarmhand;
	ModelRenderer tail;
	ModelRenderer waist;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;
	ModelRenderer rightfoot;
	ModelRenderer leftfoot;

	public ModelGaiaAnubis() {
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
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 9, 7);
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
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.1745329F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.1745329F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 36);
		this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.hair1 = new ModelRenderer(this, 36, 16);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(64, 32);
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 27);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(64, 32);
		this.setRotation(hair2, 0F, 0F, 0F);
		this.crown = new ModelRenderer(this, 36, 39);
		this.crown.addBox(-1F, -8F, -4.6F, 2, 3, 1);
		this.crown.setRotationPoint(0F, 1F, 0F);
		this.crown.setTextureSize(64, 32);
		this.setRotation(crown, 0F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 43);
		this.rightear.addBox(-4.5F, -10F, -1.5F, 3, 4, 3);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(64, 32);
		this.setRotation(rightear, 0F, 0F, 0F);
		this.leftear = new ModelRenderer(this, 48, 43);
		this.leftear.addBox(1.5F, -10F, -1.5F, 3, 4, 3);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(64, 32);
		this.setRotation(leftear, 0F, 0F, 0F);
		this.mantle = new ModelRenderer(this, 36, 50);
		this.mantle.addBox(-4F, 0F, -2F, 8, 2, 4);
		this.mantle.setRotationPoint(0F, 1F, 0F);
		this.mantle.setTextureSize(64, 32);
		this.setRotation(mantle, 0F, 0F, 0F);
		this.rightarmlower = new ModelRenderer(this, 64, 0);
		this.rightarmlower.addBox(-2.5F, 2.5F, -1.5F, 2, 8, 3);
		this.rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		this.leftarmlower = new ModelRenderer(this, 74, 0);
		this.leftarmlower.addBox(0.5F, 2F, -1.5F, 2, 8, 3);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		this.rightarmhand = new ModelRenderer(this, 64, 11);
		this.rightarmhand.addBox(-1.5F, 7.5F, -2F, 2, 4, 4);
		this.rightarmhand.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmhand.setTextureSize(64, 32);
		this.setRotation(rightarmhand, 0F, 0F, 0.1745329F);
		this.leftarmhand = new ModelRenderer(this, 76, 11);
		this.leftarmhand.addBox(-0.5F, 7.5F, -2F, 2, 4, 4);
		this.leftarmhand.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmhand.setTextureSize(64, 32);
		this.setRotation(leftarmhand, 0F, 0F, -0.1745329F);
		this.tail = new ModelRenderer(this, 88, 0);
		this.tail.addBox(-1F, 7.5F, -4F, 2, 10, 2);
		this.tail.setRotationPoint(0F, 1F, 0F);
		this.tail.setTextureSize(64, 32);
		this.setRotation(tail, 0.5235988F, 0F, 0F);
		this.waist = new ModelRenderer(this, 88, 12);
		this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(64, 32);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 88, 20);
		this.rightleglower.addBox(-2F, 5F, -2F, 4, 6, 4);
		this.rightleglower.setRotationPoint(-2F, 11F, 0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, 0F, 0F, 0F);
		this.leftleglower = new ModelRenderer(this, 104, 20);
		this.leftleglower.addBox(-2F, 5F, -2F, 4, 6, 4);
		this.leftleglower.setRotationPoint(2F, 11F, 0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, 0F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 88, 30);
		this.rightfoot.addBox(-2F, 11F, -3.5F, 4, 2, 4);
		this.rightfoot.setRotationPoint(-2F, 11F, 0F);
		this.rightfoot.setTextureSize(64, 32);
		this.setRotation(rightfoot, 0F, 0F, 0F);
		this.leftfoot = new ModelRenderer(this, 88, 30);
		this.leftfoot.addBox(-2F, 11F, -3.5F, 4, 2, 4);
		this.leftfoot.setRotationPoint(2F, 11F, 0F);
		this.leftfoot.setTextureSize(64, 32);
		this.setRotation(leftfoot, 0F, 0F, 0F);
		
		this.convertToChild(head, crown);
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(rightarm, rightarmhand);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(leftarm, leftarmhand);
		this.convertToChild(rightleg, rightleglower);
		this.convertToChild(rightleg, rightfoot);
		this.convertToChild(leftleg, leftleglower);
		this.convertToChild(leftleg, leftfoot);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
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
//		this.crown.render(scale);
//		this.rightear.render(scale);
//		this.leftear.render(scale);
		this.mantle.render(scale);
//		this.rightarmlower.render(scale);
//		this.leftarmlower.render(scale);
//		this.rightarmhand.render(scale);
//		this.leftarmhand.render(scale);
		this.tail.render(scale);
		this.waist.render(scale);
//		this.rightleglower.render(scale);
//		this.leftleglower.render(scale);
//		this.rightfoot.render(scale);
//		this.leftfoot.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.render(scale);
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
        ItemStack itemstack = ((EntityLivingBase)entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST);

        if (itemstack == null || itemstack.getItem() != Items.STICK) {
    		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
    		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
    		
    		this.rightarm.rotateAngleZ = 0.0F;
    		this.leftarm.rotateAngleZ = 0.0F;

            if (this.swingProgress > -9990.0F) {
    			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
            }
            
            this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
            this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
            this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
            this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        } else if (itemstack.getItem() == Items.STICK) {
        	spawnAnimation(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        //body
		this.tail.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(5);
		
		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
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
	
	public void spawnAnimation(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.rightarm.rotateAngleX = -1.047198F;
        this.leftarm.rotateAngleX = -1.047198F;
        
        if ((this.rightarm.rotateAngleX == -1.047198F) && (this.leftarm.rotateAngleX == -1.047198F)) {
        	this.rightarm.rotateAngleY = -0.2617994F;
        	this.leftarm.rotateAngleY = 0.2617994F;
        }
	}
}
