package gaia.model;

import gaia.entity.monster.EntityGaiaDwarf;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDwarf extends ModelGaia {
    ModelRenderer head;
    ModelRenderer headaccessory;
    ModelRenderer headbeard;
    ModelRenderer neck;
    ModelRenderer body;
    ModelRenderer rightarmpauldron;
    ModelRenderer leftarmpauldron;
	public static ModelRenderer rightarm;
	public static ModelRenderer leftarm;
    ModelRenderer rightarmgauntlet;
    ModelRenderer leftarmgauntlet;
    ModelRenderer rightlegupper;
    ModelRenderer leftlegupper;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightlegboot;
    ModelRenderer leftlegboot;

	public ModelGaiaDwarf() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4F, -8F, -4F, 8, 8, 8);
		this.head.setRotationPoint(0F, 4F, 0F);
		this.head.setTextureSize(64, 32);
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 64, 0);
		this.headaccessory.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9);
		this.headaccessory.setRotationPoint(0F, 4F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.headbeard = new ModelRenderer(this, 64, 18);
		this.headbeard.addBox(-4.5F, -2F, -4.5F, 9, 9, 9);
		this.headbeard.setRotationPoint(0F, 4F, 0F);
		this.headbeard.setTextureSize(64, 32);
		this.setRotation(headbeard, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 64, 36);
		this.neck.addBox(-2F, -4F, -2F, 4, 4, 4);
		this.neck.setRotationPoint(0F, 4F, 0F);
		this.neck.setTextureSize(64, 32);
		this.setRotation(neck, 0F, 0F, 0F);
		this.body = new ModelRenderer(this, 0, 16);
		this.body.addBox(-4F, -2F, -2F, 8, 10, 4);
		this.body.setRotationPoint(0F, 6F, 0F);
		this.body.setTextureSize(64, 32);
		this.setRotation(body, 0F, 0F, 0F);
		this.rightarmpauldron = new ModelRenderer(this, 100, 0);
		this.rightarmpauldron.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
		this.rightarmpauldron.setRotationPoint(-5F, 6F, 0F);
		this.rightarmpauldron.setTextureSize(64, 32);
		this.setRotation(rightarmpauldron, 0F, 0F, 0F);
		this.leftarmpauldron = new ModelRenderer(this, 100, 0);
		this.leftarmpauldron.mirror = true;
		this.leftarmpauldron.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
		this.leftarmpauldron.setRotationPoint(5F, 6F, 0F);
		this.leftarmpauldron.setTextureSize(64, 32);
		this.setRotation(leftarmpauldron, 0F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 24, 16);
		this.rightarm.addBox(-3F, -2F, -2F, 4, 10, 4);
		this.rightarm.setRotationPoint(-5F, 6F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0F);
		this.leftarm = new ModelRenderer(this, 24, 16);
		this.leftarm.mirror = true;
		this.leftarm.addBox(-1F, -2F, -2F, 4, 10, 4);
		this.leftarm.setRotationPoint(5F, 6F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, 0F);
		this.rightarmgauntlet = new ModelRenderer(this, 100, 10);
		this.rightarmgauntlet.addBox(-3.5F, 3.5F, -2.5F, 5, 5, 5);
		this.rightarmgauntlet.setRotationPoint(-5F, 6F, 0F);
		this.rightarmgauntlet.setTextureSize(64, 32);
		this.setRotation(rightarmgauntlet, 0F, 0F, 0F);
		this.leftarmgauntlet = new ModelRenderer(this, 100, 10);
		this.leftarmgauntlet.mirror = true;
		this.leftarmgauntlet.addBox(-1.5F, 3.5F, -2.5F, 5, 5, 5);
		this.leftarmgauntlet.setRotationPoint(5F, 6F, 0F);
		this.leftarmgauntlet.setTextureSize(64, 32);
		this.setRotation(leftarmgauntlet, 0F, 0F, 0F);
		this.rightlegupper = new ModelRenderer(this, 100, 20);
		this.rightlegupper.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
		this.rightlegupper.setRotationPoint(-2F, 14F, 0F);
		this.rightlegupper.setTextureSize(64, 32);
		this.setRotation(rightlegupper, 0F, 0F, 0F);
		this.leftlegupper = new ModelRenderer(this, 100, 20);
		this.leftlegupper.mirror = true;
		this.leftlegupper.addBox(-2.5F, 0F, -2.5F, 5, 5, 5);
		this.leftlegupper.setRotationPoint(2F, 14F, 0F);
		this.leftlegupper.setTextureSize(64, 32);
		this.setRotation(leftlegupper, 0F, 0F, 0F);
		this.rightleg = new ModelRenderer(this, 40, 16);
		this.rightleg.addBox(-2F, 0F, -2F, 4, 10, 4);
		this.rightleg.setRotationPoint(-2F, 14F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, 0F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 40, 16);
		this.leftleg.mirror = true;
		this.leftleg.addBox(-2F, 0F, -2F, 4, 10, 4);
		this.leftleg.setRotationPoint(2F, 14F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, 0F, 0F, 0F);
		this.rightlegboot = new ModelRenderer(this, 100, 30);
		this.rightlegboot.addBox(-2.5F, 5F, -2.5F, 5, 5, 5);
		this.rightlegboot.setRotationPoint(-2F, 14F, 0F);
		this.rightlegboot.setTextureSize(64, 32);
		this.setRotation(rightlegboot, 0F, 0F, 0F);
		this.leftlegboot = new ModelRenderer(this, 100, 30);
		this.leftlegboot.mirror = true;
		this.leftlegboot.addBox(-2.5F, 5F, -2.5F, 5, 5, 5);
		this.leftlegboot.setRotationPoint(2F, 14F, 0F);
		this.leftlegboot.setTextureSize(64, 32);
		this.setRotation(leftlegboot, 0F, 0F, 0F);

		this.convertToChild(head, headaccessory);
		this.convertToChild(head, headbeard);
		this.convertToChild(rightarm, rightarmpauldron);
		this.convertToChild(leftarm, leftarmpauldron);
		this.convertToChild(rightarm, rightarmgauntlet);
		this.convertToChild(leftarm, leftarmgauntlet);
		this.convertToChild(rightleg, rightlegupper);
		this.convertToChild(leftleg, leftlegupper);
		this.convertToChild(rightleg, rightlegboot);
		this.convertToChild(leftleg, leftlegboot);
	}

	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
//		this.headaccessory.render(scale);
//		this.headbeard.render(scale);
		this.neck.render(scale);
		this.body.render(scale);
//		this.rightarmpauldron.render(scale);
//		this.leftarmpauldron.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
//		this.rightarmgauntlet.render(scale);
//		this.leftarmgauntlet.render(scale);
//		this.rightlegupper.render(scale);
//		this.leftlegupper.render(scale);
		this.rightleg.render(scale);
		this.leftleg.render(scale);
//		this.rightlegboot.render(scale);
//		this.leftlegboot.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = 0.0F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
		ItemStack itemstack = ((EntityLivingBase)entityIn).getHeldItemMainhand();
		EntityGaiaDwarf entity = (EntityGaiaDwarf)entityIn;
		
		if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
			holdingBow(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
		} else if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
		
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
	}
	
	public void holdingBow(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
		
		this.rightarm.rotateAngleZ = -0.3F;
		this.leftarm.rotateAngleZ = 0.3F;
		this.rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		this.leftarm.rotateAngleY = 0.3F - f * 0.6F;
		this.rightarm.rotateAngleX = -((float)Math.PI / 2F);
		this.leftarm.rotateAngleX = -((float)Math.PI / 2F);
		this.rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		this.leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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
        this.rightarm.rotateAngleX += (this.body.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
