package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSpriggan extends ModelGaia {
	ModelRenderer head;
    ModelRenderer headeyes;
	ModelRenderer headaccessory;
	ModelRenderer neck;
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodymiddlebutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	public static ModelRenderer rightarm;
	public static ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer headhorns;
	ModelRenderer headhornslong1;
	ModelRenderer headhornslong2;
	ModelRenderer mantle;
	ModelRenderer rightarmlower;
	ModelRenderer leftarmlower;
	ModelRenderer spine;
	ModelRenderer rightleglower;
	ModelRenderer leftleglower;

	public ModelGaiaSpriggan() {
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
		this.rightarm.addBox(-2F, -1F, -1F, 2, 7, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.setRotation(rightarm, 0F, 0F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.mirror = true;
		this.leftarm.addBox(0F, -1F, -1F, 2, 7, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.setRotation(leftarm, 0F, 0F, -0.2617994F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1.5F, -1.5F, 3, 8, 3);
		this.rightleg.setRotationPoint(-2F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.setRotation(rightleg, -0.2617994F, 0F, -0.0872665F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1.5F, -1.5F, 3, 8, 3);
		this.leftleg.setRotationPoint(2F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.setRotation(leftleg, -0.2617994F, 0F, 0.0872665F);
		this.headhorns = new ModelRenderer(this, 36, 14);
		this.headhorns.addBox(-4F, -7F, -4F, 8, 8, 8);
		this.headhorns.setRotationPoint(0F, 1F, 0F);
		this.headhorns.setTextureSize(64, 32);
		this.setRotation(headhorns, 0F, 0F, 0F);
		this.headhornslong1 = new ModelRenderer(this, 36, 30);
		this.headhornslong1.addBox(-6F, -10F, -3F, 12, 5, 5);
		this.headhornslong1.setRotationPoint(0F, 1F, 0F);
		this.headhornslong1.setTextureSize(64, 32);
		this.setRotation(headhornslong1, 0F, 0F, 0F);
		this.headhornslong2 = new ModelRenderer(this, 36, 40);
		this.headhornslong2.addBox(-9F, -7F, -1F, 18, 5, 5);
		this.headhornslong2.setRotationPoint(0F, 1F, 0F);
		this.headhornslong2.setTextureSize(64, 32);
		this.setRotation(headhornslong2, 0F, 0F, 0F);
		this.mantle = new ModelRenderer(this, 82, 0);
		this.mantle.addBox(-5F, -1.5F, -2F, 10, 4, 4);
		this.mantle.setRotationPoint(0F, 1F, 0F);
		this.mantle.setTextureSize(64, 32);
		this.setRotation(mantle, 0F, 0F, 0F);
		this.rightarmlower = new ModelRenderer(this, 82, 8);
		this.rightarmlower.addBox(-5F, 3F, -1.5F, 2, 7, 3);
		this.rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmlower.setTextureSize(64, 32);
		this.setRotation(rightarmlower, 0F, 0F, -0.2617994F);
		convertToChild(rightarm, rightarmlower);
		this.leftarmlower = new ModelRenderer(this, 82, 8);
		this.leftarmlower.mirror = true;
		this.leftarmlower.addBox(3F, 3F, -1.5F, 2, 7, 3);
		this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmlower.setTextureSize(64, 32);
		this.setRotation(leftarmlower, 0F, 0F, 0.2617994F);
		convertToChild(leftarm, leftarmlower);
		this.spine = new ModelRenderer(this, 82, 18);
		this.spine.addBox(-0.5F, 0F, 1.5F, 1, 10, 4);
		this.spine.setRotationPoint(0F, 1F, 0F);
		this.spine.setTextureSize(64, 32);
		this.setRotation(spine, -0.0872665F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 110, 0);
		this.rightleglower.addBox(-0.5F, 4.5F, 2F, 3, 8, 2);
		this.rightleglower.setRotationPoint(-2F, 11F, 0F);
		this.rightleglower.setTextureSize(64, 32);
		this.setRotation(rightleglower, -0.3490659F, 0F, 0.0872665F);
		this.leftleglower = new ModelRenderer(this, 110, 0);
		this.leftleglower.mirror = true;
		this.leftleglower.addBox(-2.5F, 4.5F, 2F, 3, 8, 2);
		this.leftleglower.setRotationPoint(2F, 11F, 0F);
		this.leftleglower.setTextureSize(64, 32);
		this.setRotation(leftleglower, -0.3490659F, 0F, -0.0872665F);
		
		this.convertToChild(head, headhorns);
		this.convertToChild(head, headhornslong1);
		this.convertToChild(head, headhornslong2);
		this.convertToChild(rightleg, rightleglower);
		this.convertToChild(leftleg, leftleglower);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		this.head.render(scale);
		this.headaccessory.render(scale);
		this.neck.render(scale);
		this.bodytop.render(scale);
		this.bodymiddle.render(scale);
		this.bodymiddlebutton.render(scale);
		this.bodybottom.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
		this.rightleg.render(scale);
		this.leftleg.render(scale);
//		this.headhorns.render(scale);
//		this.headhornslong1.render(scale);
//		this.headhornslong2.render(scale);
		this.mantle.render(scale);
//		this.rightarmlower.render(scale);
//		this.leftarmlower.render(scale);
		this.spine.render(scale);
//		this.rightleglower.render(scale);
//		this.leftleglower.render(scale);

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
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
		this.rightleg.rotateAngleX = this.rightleg.rotateAngleX - 0.2617994F;
		this.leftleg.rotateAngleX = this.leftleg.rotateAngleX - 0.2617994F;
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