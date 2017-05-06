package gaia.model;

import gaia.entity.monster.EntityGaiaMinotaurus;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMinotaurus extends ModelGaia {
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
    ModelRenderer headnose;
    ModelRenderer headnosering;
    ModelRenderer righthorn1;
    ModelRenderer righthorn2;
    ModelRenderer righthorn3;
    ModelRenderer lefthorn1;
    ModelRenderer lefthorn2;
    ModelRenderer lefthorn3;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer ring;
    ModelRenderer rightpauldron;
    ModelRenderer leftpauldron;
    ModelRenderer rightarmband;
    ModelRenderer leftarmband;
    ModelRenderer waist;
    ModelRenderer tail;
    ModelRenderer rightleglower;
    ModelRenderer leftleglower;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;

	public ModelGaiaMinotaurus() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(128, 64);
		this.setRotation(head, 0F, 0F, 0F);
		this.headeyes = new ModelRenderer(this, 24, 0);
		this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		this.headeyes.setRotationPoint(0F, 1F, 0F);
		this.headeyes.setTextureSize(128, 64);
		this.setRotation(headeyes, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(128, 64);
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.neck = new ModelRenderer(this, 0, 12);
		this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.neck.setRotationPoint(0F, 1F, 0F);
		this.neck.setTextureSize(128, 64);
		this.setRotation(neck, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 16);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(128, 64);
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 25);
		this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(128, 64);
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
		this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 30);
		this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(128, 64);
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 36);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(128, 64);
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 0, 36);
		this.leftchest.mirror = true;
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(128, 64);
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.setRotation(rightarm, 0F, 0F, 0.0872665F);
		this.leftarm = new ModelRenderer(this, 16, 36);
		this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.setRotation(leftarm, 0F, 0F, -0.0872665F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		this.rightleg.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleg.setTextureSize(128, 64);
		this.setRotation(rightleg, -0.1745329F, 0F, 0F);
		this.leftleg = new ModelRenderer(this, 24, 12);
		this.leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
		this.leftleg.setRotationPoint(2F, 11F, -0.5F);
		this.leftleg.setTextureSize(128, 64);
		this.setRotation(leftleg, -0.1745329F, 0F, 0F);
		this.headnose = new ModelRenderer(this, 36, 14);
		this.headnose.addBox(-1.5F, -6.5F, -5.5F, 3, 2, 2);
		this.headnose.setRotationPoint(0F, 1F, 0F);
		this.headnose.setTextureSize(128, 64);
		this.setRotation(headnose, 0F, 0F, 0F);
		this.headnosering = new ModelRenderer(this, 36, 28);
		this.headnosering.addBox(-1.5F, -5.5F, -6.5F, 3, 3, 1);
		this.headnosering.setRotationPoint(0F, 1F, 0F);
		this.headnosering.setTextureSize(128, 64);
		this.setRotation(headnosering, 0F, 0F, 0F);
		this.righthorn1 = new ModelRenderer(this, 36, 18);
		this.righthorn1.addBox(-5F, -7F, -2F, 2, 2, 2);
		this.righthorn1.setRotationPoint(0F, 1F, 0F);
		this.righthorn1.setTextureSize(128, 64);
		this.setRotation(righthorn1, 0F, 0F, 0F);
		this.righthorn2 = new ModelRenderer(this, 36, 22);
		this.righthorn2.addBox(-4F, -8F, -3F, 2, 2, 2);
		this.righthorn2.setRotationPoint(0F, 1F, 0F);
		this.righthorn2.setTextureSize(128, 64);
		this.setRotation(righthorn2, 0F, 0F, 0F);
		this.righthorn3 = new ModelRenderer(this, 36, 26);
		this.righthorn3.addBox(-2.5F, -8.5F, -2.5F, 1, 1, 1);
		this.righthorn3.setRotationPoint(0F, 1F, 0F);
		this.righthorn3.setTextureSize(128, 64);
		this.setRotation(righthorn3, 0F, 0F, 0F);
		this.lefthorn1 = new ModelRenderer(this, 36, 18);
		this.lefthorn1.mirror = true;
		this.lefthorn1.addBox(3F, -7F, -2F, 2, 2, 2);
		this.lefthorn1.setRotationPoint(0F, 1F, 0F);
		this.lefthorn1.setTextureSize(128, 64);
		this.lefthorn1.mirror = true;
		this.setRotation(lefthorn1, 0F, 0F, 0F);
		this.lefthorn2 = new ModelRenderer(this, 36, 22);
		this.lefthorn2.mirror = true;
		this.lefthorn2.addBox(2F, -8F, -3F, 2, 2, 2);
		this.lefthorn2.setRotationPoint(0F, 1F, 0F);
		this.lefthorn2.setTextureSize(128, 64);
		this.setRotation(lefthorn2, 0F, 0F, 0F);
		this.lefthorn3 = new ModelRenderer(this, 36, 26);
		this.lefthorn3.mirror = true;
		this.lefthorn3.addBox(1.5F, -8.5F, -2.5F, 1, 1, 1);
		this.lefthorn3.setRotationPoint(0F, 1F, 0F);
		this.lefthorn3.setTextureSize(128, 64);
		this.setRotation(lefthorn3, 0F, 0F, 0F);
		this.rightear = new ModelRenderer(this, 36, 28);
		this.rightear.addBox(-3.5F, -5F, 0.5F, 0, 4, 4);
		this.rightear.setRotationPoint(0F, 1F, 0F);
		this.rightear.setTextureSize(128, 64);
		this.setRotation(rightear, 0F, -0.7853982F, 0F);
		this.leftear = new ModelRenderer(this, 36, 28);
		this.leftear.mirror = true;
		this.leftear.addBox(3.5F, -5F, 0.5F, 0, 4, 4);
		this.leftear.setRotationPoint(0F, 1F, 0F);
		this.leftear.setTextureSize(128, 64);
		this.setRotation(leftear, 0F, 0.7853982F, 0F);
		this.ring = new ModelRenderer(this, 36, 36);
		this.ring.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 1);
		this.ring.setRotationPoint(0F, 3F, -1.5F);
		this.ring.setTextureSize(128, 64);
		this.setRotation(ring, -0.6981317F, 0F, 0F);
		this.rightpauldron = new ModelRenderer(this, 36, 40);
		this.rightpauldron.addBox(-3.5F, -1.5F, -2F, 4, 4, 4);
		this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightpauldron.setTextureSize(128, 64);
		this.setRotation(rightpauldron, 0F, 0F, 0.0872665F);
		this.leftpauldron = new ModelRenderer(this, 36, 40);
		this.leftpauldron.mirror = true;
		this.leftpauldron.addBox(-0.5F, -1.5F, -2F, 4, 4, 4);
		this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftpauldron.setTextureSize(128, 64);
		this.setRotation(leftpauldron, 0F, 0F, -0.0872665F);
		this.rightarmband = new ModelRenderer(this, 36, 48);
		this.rightarmband.addBox(-2.5F, 8F, -1.5F, 3, 1, 3);
		this.rightarmband.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarmband.setTextureSize(128, 64);
		this.setRotation(rightarmband, 0F, 0F, 0.0872665F);
		this.leftarmband = new ModelRenderer(this, 48, 48);
		this.leftarmband.addBox(-0.5F, 8F, -1.5F, 3, 1, 3);
		this.leftarmband.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarmband.setTextureSize(128, 64);
		this.setRotation(leftarmband, 0F, 0F, -0.0872665F);
		this.waist = new ModelRenderer(this, 64, 0);
		this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		this.waist.setRotationPoint(0F, 1F, 0F);
		this.waist.setTextureSize(128, 64);
		this.setRotation(waist, 0.0872665F, 0F, 0F);
		this.tail = new ModelRenderer(this, 64, 8);
		this.tail.addBox(-1F, 0F, 0F, 2, 10, 0);
		this.tail.setRotationPoint(0F, 10F, 2F);
		this.tail.setTextureSize(128, 64);
		this.setRotation(tail, 0.4014257F, 0F, 0F);
		this.rightleglower = new ModelRenderer(this, 64, 18);
		this.rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		this.rightleglower.setRotationPoint(-2F, 11F, -0.5F);
		this.rightleglower.setTextureSize(128, 64);
		this.setRotation(rightleglower, -0.1745329F, 0F, 0F);
		this.leftleglower = new ModelRenderer(this, 64, 18);
		this.leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
		this.leftleglower.setRotationPoint(2F, 11F, -0.5F);
		this.leftleglower.setTextureSize(128, 64);
		this.setRotation(leftleglower, -0.1745329F, 0F, 0F);
		this.rightfoot = new ModelRenderer(this, 64, 30);
		this.rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		this.rightfoot.setRotationPoint(-2F, 11F, -0.5F);
		this.rightfoot.setTextureSize(128, 64);
		this.setRotation(rightfoot, 0F, 0F, 0F);
		this.leftfoot = new ModelRenderer(this, 64, 30);
		this.leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
		this.leftfoot.setRotationPoint(2F, 11F, -0.5F);
		this.leftfoot.setTextureSize(128, 64);
		this.setRotation(leftfoot, 0F, 0F, 0F);

		this.convertToChild(head, headnose);
		this.convertToChild(head, headnosering);
		this.convertToChild(head, righthorn1);
		this.convertToChild(head, righthorn2);
		this.convertToChild(head, righthorn3);
		this.convertToChild(head, lefthorn1);
		this.convertToChild(head, lefthorn2);
		this.convertToChild(head, lefthorn3);
		this.convertToChild(head, rightear);
		this.convertToChild(head, leftear);
		this.convertToChild(rightarm, rightpauldron);
		this.convertToChild(rightarm, rightarmband);
		this.convertToChild(leftarm, leftpauldron);
		this.convertToChild(leftarm, leftarmband);
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
		this.bodymiddle.render(scale);
		this.bodymiddlebutton.render(scale);
		this.bodybottom.render(scale);
		this.rightchest.render(scale);
		this.leftchest.render(scale);
		this.rightarm.render(scale);
		this.leftarm.render(scale);
		this.rightleg.render(scale);
		this.leftleg.render(scale);
//		this.righthorn1.render(scale);
//		this.righthorn2.render(scale);
//		this.righthorn3.render(scale);
//		this.lefthorn1.render(scale);
//		this.lefthorn2.render(scale);
//		this.lefthorn3.render(scale);
//		this.rightear.render(scale);
//		this.leftear.render(scale);
		this.ring.render(scale);
//		this.rightpauldron.render(scale);
//		this.leftpauldron.render(scale);
//		this.rightarmband.render(scale);
//		this.leftarmband.render(scale);
		this.waist.render(scale);
		this.tail.render(scale);
//		this.rightleglower.render(scale);
//		this.leftleglower.render(scale);
//		this.rightfoot.render(scale);
//		this.leftfoot.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			this.headeyes.render(scale);
		}
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn){
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
		
		ItemStack itemstack = ((EntityLivingBase)entityIn).getHeldItemMainhand();
		EntityGaiaMinotaurus entity = (EntityGaiaMinotaurus)entityIn;

		if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
			holdingBow(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
		} else if (this.swingProgress > -9990.0F) {
			holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch,scaleFactor, entityIn);
        }
		
		this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.0872665F;
		this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		//body
		this.tail.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted*7)) * degToRad(15);

		//legs
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
		this.rightleg.rotateAngleX -= 0.1745329F;
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount;
		this.leftleg.rotateAngleX -= 0.1745329F;
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
        this.rightarm.rotateAngleX += (this.bodytop.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F);
	}
}
