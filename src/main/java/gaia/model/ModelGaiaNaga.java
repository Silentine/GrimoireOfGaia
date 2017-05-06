package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaNaga extends ModelGaia {
	ModelRenderer head;
	ModelRenderer headnose1;
	ModelRenderer headnose2;
	ModelRenderer headjaw;
	ModelRenderer headtendrils;
	ModelRenderer rightfin;
	ModelRenderer leftfin;
	ModelRenderer pauldron;
	ModelRenderer body;
	ModelRenderer body2;
	ModelRenderer fin1;
	ModelRenderer fin2;
	public static ModelRenderer rightarm;
	ModelRenderer rightarmlower;
	public static ModelRenderer leftarm;
	ModelRenderer leftarmlower;
	ModelRenderer waist;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tail4;
	ModelRenderer tail5;
	ModelRenderer tail6;
	ModelRenderer tail7;
	
    protected double distanceMovedTotal = 0.0D;
    protected static final double CYCLES_PER_BLOCK = 1.0D; 
    protected int cycleIndex = 0;
    protected float[][] undulationCycle = new float[][]
    {
    	    {  10F, -10F, -10F,   0F,  10F,  10F,   0F, -10F },
    	    {   5F,  10F, -10F, -10F,   0F,  10F,  10F,   0F },
    	    {   0F,  25F,   0F, -10F, -10F,   0F,  10F,  10F },
    	    { -10F,  10F,  10F,   0F, -10F, -10F,   0F,  10F },
    	    {  -5F, -10F,  10F,  10F,   0F, -10F, -10F,   0F },
    	    {   0F, -25F,   0F,  10F,  10F,   0F, -10F, -10F },
    };

	public ModelGaiaNaga() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -5F, -3F, 6, 5, 7);
		this.head.setRotationPoint(0F, -6F, -3F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headnose1 = new ModelRenderer(this, 0, 12);
		this.headnose1.addBox(-1F, -4F, -5F, 2, 1, 2);
		this.headnose1.setRotationPoint(0F, -6F, -3F);
		this.headnose1.setTextureSize(128, 64);
		this.setRotation(headnose1, 0F, 0F, 0F);
		this.headnose2 = new ModelRenderer(this, 0, 15);
		this.headnose2.addBox(-2F, -3F, -6F, 4, 2, 3);
		this.headnose2.setRotationPoint(0F, -6F, -3F);
		this.headnose2.setTextureSize(128, 64);
		this.setRotation(headnose2, 0F, 0F, 0F);
		this.headjaw = new ModelRenderer(this, 0, 20);
		this.headjaw.addBox(-2.5F, -2F, -6.5F, 5, 3, 6);
		this.headjaw.setRotationPoint(0F, -6F, -3F);
		this.headjaw.setTextureSize(128, 64);
		this.setRotation(headjaw, 0F, 0F, 0F);
		this.headtendrils = new ModelRenderer(this, 0, 29);
		this.headtendrils.addBox(-3F, -1F, -6.5F, 6, 6, 6);
		this.headtendrils.setRotationPoint(0F, -6F, -3F);
		this.headtendrils.setTextureSize(128, 64);
		this.setRotation(headtendrils, 0F, 0F, 0F);
		this.rightfin = new ModelRenderer(this, 19, -5);
		this.rightfin.addBox(-3F, -5F, 0F, 0, 5, 5);
		this.rightfin.setRotationPoint(0F, -6F, -3F);
		this.rightfin.setTextureSize(128, 64);
		this.setRotation(rightfin, 0F, -0.5235988F, 0F);
		this.leftfin = new ModelRenderer(this, 19, -5);
		this.leftfin.addBox(3F, -5F, 0F, 0, 5, 5);
		this.leftfin.setRotationPoint(0F, -6F, -3F);
		this.leftfin.setTextureSize(128, 64);
		setRotation(leftfin, 0F, 0.5235988F, 0F);
		this.pauldron = new ModelRenderer(this, 34, 0);
		this.pauldron.addBox(-9F, -0.5F, -3F, 18, 7, 7);
		this.pauldron.setRotationPoint(0F, -7F, 0F);
		this.pauldron.setTextureSize(128, 64);
		this.setRotation(pauldron, -0.1745329F, 0F, 0F);
		this.body = new ModelRenderer(this, 34, 14);
		this.body.addBox(-4.5F, -2F, -1.5F, 9, 4, 4);
		this.body.setRotationPoint(0F, -7F, 0F);
		this.body.setTextureSize(128, 64);
		this.setRotation(body, 0.2617994F, 0F, 0F);
		this.body2 = new ModelRenderer(this, 34, 44);
		this.body2.addBox(-5.5F, 0F, -2.5F, 11, 9, 6);
		this.body2.setRotationPoint(0F, -7F, 0F);
		this.body2.setTextureSize(128, 64);
		this.setRotation(body2, -0.1745329F, 0F, 0F);
		this.fin1 = new ModelRenderer(this, 0, 34);
		this.fin1.addBox(0F, -5F, -2.5F, 0, 13, 12);
		this.fin1.setRotationPoint(0F, -7F, 0F);
		this.fin1.setTextureSize(128, 64);
		this.setRotation(fin1, -0.1745329F, 0F, 0F);
		this.fin2 = new ModelRenderer(this, 0, 35);
		this.fin2.addBox(0F, -9F, -3F, 0, 5, 6);
		this.fin2.setRotationPoint(0F, -6F, -3F);
		this.fin2.setTextureSize(128, 64);
		this.setRotation(fin2, 0F, 0F, 0F);
		this.rightarm = new ModelRenderer(this, 34, 22);
		this.rightarm.addBox(-3F, -1.5F, -1.5F, 3, 8, 3);
		this.rightarm.setRotationPoint(-5.5F, -4F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.rightarmlower = new ModelRenderer(this, 34, 33);
		this.rightarmlower.addBox(-3F, 6.5F, -0.5F, 3, 8, 3);
		this.rightarmlower.setRotationPoint(-5.5F, -4F, 0F);
		this.rightarmlower.setTextureSize(128, 64);
		this.setRotation(rightarmlower, -0.1745329F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 46, 22);
		this.leftarm.addBox(0F, -1.5F, -1.5F, 3, 8, 3);
		this.leftarm.setRotationPoint(5.5F, -4F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.leftarmlower = new ModelRenderer(this, 46, 33);
		this.leftarmlower.addBox(0F, 6.5F, -0.5F, 3, 8, 3);
		this.leftarmlower.setRotationPoint(5.5F, -4F, 0F);
		this.leftarmlower.setTextureSize(128, 64);
		this.setRotation(leftarmlower, -0.1745329F, 0F, -0.0872665F);
		this.waist = new ModelRenderer(this, 84, 0);
		this.waist.addBox(-4.5F, 9F, -2.5F, 9, 5, 5);
		this.waist.setRotationPoint(0F, -7F, 0F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, -0.1308997F, undulationCycle[0][0], 0F);
		this.tail1 = new ModelRenderer(this, 84, 10);
		this.tail1.addBox(-4F, 14F, -2.5F, 8, 3, 4);
		this.tail1.setRotationPoint(0F, -7F, 0F);
		this.tail1.setTextureSize(128, 64);
		this.setRotation(tail1, -0.0436332F, undulationCycle[0][1], 0F);
		this.tail2 = new ModelRenderer(this, 84, 17);
		this.tail2.addBox(-3.5F, 17F, -2.5F, 7, 3, 4);
		this.tail2.setRotationPoint(0F, -7F, 0F);
		this.tail2.setTextureSize(128, 64);
		this.setRotation(tail2, 0F, undulationCycle[0][2], 0F);
		this.tail3 = new ModelRenderer(this, 108, 10);
		this.tail3.addBox(-3F, 20F, -2.5F, 6, 3, 4);
		this.tail3.setRotationPoint(0F, -7F, 0F);
		this.tail3.setTextureSize(128, 64);
		this.setRotation(tail3, 0.0436332F, undulationCycle[0][3], 0F);
		this.tail4 = new ModelRenderer(this, 108, 10);
		this.tail4.addBox(-3F, 23F, -3.5F, 6, 3, 4);
		this.tail4.setRotationPoint(0F, -7F, 0F);
		this.tail4.setTextureSize(128, 64);
		this.setRotation(tail4, 0.1308997F, undulationCycle[0][4], 0F);
		this.tail5 = new ModelRenderer(this, 108, 10);
		this.tail5.addBox(-3F, 26F, -3.5F, 6, 3, 4);
		this.tail5.setRotationPoint(0F, -7F, 0F);
		this.tail5.setTextureSize(128, 64);
		this.setRotation(tail5, 0.1745329F, undulationCycle[0][5], 0F);
		this.tail6 = new ModelRenderer(this, 108, 17);
		this.tail6.addBox(-2.5F, 28F, -1.5F, 5, 3, 4);
		this.tail6.setRotationPoint(0F, -7F, 0F);
		this.tail6.setTextureSize(128, 64);
		this.setRotation(tail6, 0.1745329F, undulationCycle[0][6], 0F);
		this.tail7 = new ModelRenderer(this, 108, 17);
		this.tail7.addBox(-2.5F, 29F, 1.5F, 5, 3, 4);
		this.tail7.setRotationPoint(0F, -7F, 0F);
		this.tail7.setTextureSize(128, 64);
		this.setRotation(tail7, 0.1745329F, undulationCycle[0][7], 0F);
		
		this.convertToChild(head, headnose1);
		this.convertToChild(head, headnose2);
		this.convertToChild(head, headjaw);
		this.convertToChild(head, headtendrils);
		this.convertToChild(head, rightfin);
		this.convertToChild(head, leftfin);
		this.convertToChild(rightarm, rightarmlower);
		this.convertToChild(leftarm, leftarmlower);
		this.convertToChild(waist, tail1);
		this.convertToChild(waist, tail2);
		this.convertToChild(waist, tail3);
		this.convertToChild(waist, tail4);
		this.convertToChild(waist, tail5);
		this.convertToChild(waist, tail6);
		this.convertToChild(waist, tail7);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
//		this.headnose1.render(scale);
//		this.headnose2.render(scale);
//		this.headjaw.render(scale);
//		this.headtendrils.render(scale);
//		this.rightfin.render(scale);
//		this.leftfin.render(scale);
		this.pauldron.render(scale);
		this.body.render(scale);
		this.body2.render(scale);
		this.fin1.render(scale);
		this.fin2.render(scale);
		this.rightarm.render(scale);
//		this.rightarmlower.render(scale);
		this.leftarm.render(scale);
//		this.leftarmlower.render(scale);
		this.waist.render(scale);
//		this.tail1.render(scale);
//		this.tail2.render(scale);
//		this.tail3.render(scale);
//		this.tail4.render(scale);
//		this.tail5.render(scale);
//		this.tail6.render(scale);
//		this.tail7.render(scale);
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		//head
		this.head.rotateAngleY = netHeadYaw / 57.295776F;
		this.head.rotateAngleX = headPitch / 57.295776F;
		
		//arms
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
		
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		
        if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
        
        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F) + 0.0872665F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		
		//body
		this.fin2.rotateAngleY = this.head.rotateAngleY;
		this.fin2.rotateAngleX = this.head.rotateAngleX;
		
        //legs      
		updateDistanceMovedTotal(entityIn);
		cycleIndex = (int) ((getDistanceMovedTotal(entityIn)*CYCLES_PER_BLOCK)%undulationCycle.length);
		
		waist.rotateAngleY = degToRad(undulationCycle[cycleIndex][0]) ;
		tail1.rotateAngleY = degToRad(undulationCycle[cycleIndex][1]) ;
		tail2.rotateAngleY = degToRad(undulationCycle[cycleIndex][2]) ;
		tail3.rotateAngleY = degToRad(undulationCycle[cycleIndex][3]) ;
		tail4.rotateAngleY = degToRad(undulationCycle[cycleIndex][4]) ;
		tail5.rotateAngleY = degToRad(undulationCycle[cycleIndex][5]) ;
		tail6.rotateAngleY = degToRad(undulationCycle[cycleIndex][6]) ;
		tail7.rotateAngleY = degToRad(undulationCycle[cycleIndex][7]) ;
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
