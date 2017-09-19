package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaArachne extends ModelGaia {

    ModelRenderer head;
    ModelRenderer headeyes;
    ModelRenderer headaccessory;
    ModelRenderer neck;
    ModelRenderer bodytop;
    ModelRenderer bodymiddlebutton;
    ModelRenderer bodymiddle;
    ModelRenderer bodybottom;
    ModelRenderer rightchest;
    ModelRenderer leftchest;
    public static ModelRenderer rightarm;
    public static ModelRenderer leftarm;
    ModelRenderer righteye;
    ModelRenderer lefteye;
    ModelRenderer hair;
    ModelRenderer rightarmlower;
    ModelRenderer leftarmlower;
    ModelRenderer waist;
    ModelRenderer skull1;
    ModelRenderer skull2;
    ModelRenderer skull3;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer leg7;
    ModelRenderer leg5;
    ModelRenderer leg3;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg4;
    ModelRenderer leg6;
    ModelRenderer leg8;

    public ModelGaiaArachne() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
        this.head.setRotationPoint(0F, 5F, -10F);
        this.head.setTextureSize(64, 32);
        this.setRotation(head, 0F, 0F, 0F);
        this.headeyes = new ModelRenderer(this, 24, 0);
        this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
        this.headeyes.setRotationPoint(0F, 5F, -10F);
        this.headeyes.setTextureSize(64, 32);
        this.setRotation(headeyes, 0F, 0F, 0F);
        this.headaccessory = new ModelRenderer(this, 36, 0);
        this.headaccessory.addBox(-3.5F, -5.5F, -3.5F, 7, 9, 7);
        this.headaccessory.setRotationPoint(0F, 4F, -10F);
        this.headaccessory.setTextureSize(64, 32);
        this.setRotation(headaccessory, 0F, 0F, 0F);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.neck.setRotationPoint(0F, 4F, -10F);
        this.neck.setTextureSize(64, 32);
        this.setRotation(neck, 0F, 0F, 0F);
        this.bodytop = new ModelRenderer(this, 0, 16);
        this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
        this.bodytop.setRotationPoint(0F, 5F, -10F);
        this.bodytop.setTextureSize(64, 32);
        this.setRotation(bodytop, 0.0872665F, 0F, 0F);
        this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
        this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
        this.bodymiddlebutton.setRotationPoint(0F, 5F, -10F);
        this.bodymiddlebutton.setTextureSize(64, 32);
        this.setRotation(bodymiddlebutton, 0.1745329F, 0F, 0F);
        this.bodymiddle = new ModelRenderer(this, 0, 25);
        this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
        this.bodymiddle.setRotationPoint(0F, 5F, -10F);
        this.bodymiddle.setTextureSize(64, 32);
        this.setRotation(bodymiddle, 0.1745329F, 0F, 0F);
        this.bodybottom = new ModelRenderer(this, 0, 30);
        this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
        this.bodybottom.setRotationPoint(0F, 5F, -10F);
        this.bodybottom.setTextureSize(64, 32);
        this.setRotation(bodybottom, 0.2617994F, 0F, 0F);
        this.rightchest = new ModelRenderer(this, 0, 36);
        this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.rightchest.setRotationPoint(-1.3F, 7F, -11.2F);
        this.rightchest.setTextureSize(64, 32);
        this.setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
        this.leftchest = new ModelRenderer(this, 0, 36);
        this.leftchest.mirror = true;
        this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.leftchest.setRotationPoint(1.3F, 7F, -11.2F);
        this.leftchest.setTextureSize(64, 32);
        this.setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
        this.rightarm = new ModelRenderer(this, 16, 12);
        this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
        this.rightarm.setRotationPoint(-2.5F, 6.5F, -9.5F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0F, 0F, 0.2617994F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
        this.leftarm.setRotationPoint(2.5F, 6.5F, -9.5F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0F, 0F, -0.2617994F);
        this.righteye = new ModelRenderer(this, 36, 16);
        this.righteye.addBox(-4F, -6F, -2.5F, 2, 2, 2);
        this.righteye.setRotationPoint(0F, 4F, -10F);
        this.righteye.setTextureSize(64, 32);
        this.setRotation(righteye, 0F, 0F, 0F);
        this.lefteye = new ModelRenderer(this, 36, 16);
        this.lefteye.mirror = true;
        this.lefteye.addBox(2F, -8F, -2.5F, 2, 2, 2);
        this.lefteye.setRotationPoint(0F, 6F, -10F);
        this.lefteye.setTextureSize(64, 32);
        this.setRotation(lefteye, 0F, 0F, 0F);
        this.hair = new ModelRenderer(this, 36, 20);
        this.hair.addBox(-2F, -7F, 1F, 4, 4, 4);
        this.hair.setRotationPoint(0F, 4F, -10F);
        this.hair.setTextureSize(64, 32);
        this.setRotation(hair, 0F, 0F, 0F);
        this.rightarmlower = new ModelRenderer(this, 36, 28);
        this.rightarmlower.addBox(-2.5F, 3.5F, -1.5F, 2, 6, 3);
        this.rightarmlower.setRotationPoint(-2.5F, 6.5F, -9.5F);
        this.rightarmlower.setTextureSize(64, 32);
        this.setRotation(rightarmlower, 0F, 0F, 0.2617994F);
        this.leftarmlower = new ModelRenderer(this, 36, 28);
        this.leftarmlower.mirror = true;
        this.leftarmlower.addBox(0.5F, 3.5F, -1.5F, 2, 6, 3);
        this.leftarmlower.setRotationPoint(2.5F, 6.5F, -9.5F);
        this.leftarmlower.setTextureSize(64, 32);
        this.setRotation(leftarmlower, 0F, 0F, -0.2617994F);
        this.waist = new ModelRenderer(this, 36, 37);
        this.waist.addBox(-3.5F, 9F, -3F, 7, 5, 4);
        this.waist.setRotationPoint(0F, 5F, -10F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.2617994F, 0F, 0F);
        this.skull1 = new ModelRenderer(this, 36, 56);
        this.skull1.addBox(-0.8F, -1.5F, -9.5F, 4, 4, 4);
        this.skull1.setRotationPoint(0F, 16F, -5F);
        this.skull1.setTextureSize(64, 32);
        this.setRotation(skull1, 0.1745329F, 0.7853982F, 0.1745329F);
        this.skull2 = new ModelRenderer(this, 36, 46);
        this.skull2.addBox(-2.5F, -1.8F, -13F, 5, 5, 5);
        this.skull2.setRotationPoint(0F, 16F, -1F);
        this.skull2.setTextureSize(64, 32);
        this.setRotation(skull2, 0.2443461F, 0F, 0F);
        this.skull3 = new ModelRenderer(this, 36, 56);
        this.skull3.addBox(-3.2F, -1.5F, -9.5F, 4, 4, 4);
        this.skull3.setRotationPoint(0F, 16F, -5F);
        this.skull3.setTextureSize(64, 32);
        this.setRotation(skull3, 0.1745329F, -0.7853982F, -0.1745329F);
        this.body1 = new ModelRenderer(this, 64, 0);
        this.body1.addBox(-3F, -4F, -8F, 6, 8, 8);
        this.body1.setRotationPoint(0F, 16F, -1F);
        this.body1.setTextureSize(64, 32);
        this.setRotation(body1, -0.4363323F, 0F, 0F);
        this.body2 = new ModelRenderer(this, 64, 16);
        this.body2.addBox(-3.5F, -3.5F, -6F, 7, 6, 8);
        this.body2.setRotationPoint(0F, 16F, 2F);
        this.body2.setTextureSize(64, 32);
        this.setRotation(body2, 0.2617994F, 0F, 0F);
        this.body3 = new ModelRenderer(this, 64, 30);
        this.body3.addBox(-2.5F, -6F, -2F, 5, 8, 8);
        this.body3.setRotationPoint(0F, 16F, -1F);
        this.body3.setTextureSize(64, 32);
        this.setRotation(body3, 0.2617994F, 0F, 0F);
        this.body4 = new ModelRenderer(this, 78, 34);
        this.body4.addBox(-5F, -4F, -6F, 10, 10, 12);
        this.body4.setRotationPoint(0F, 13F, 7F);
        this.body4.setTextureSize(64, 32);
        this.setRotation(body4, -0.4363323F, 0F, 0F);
        this.body5 = new ModelRenderer(this, 64, 56);
        this.body5.addBox(-2F, 5F, 5F, 4, 3, 3);
        this.body5.setRotationPoint(0F, 13F, 7F);
        this.body5.setTextureSize(64, 32);
        this.setRotation(body5, -0.4363323F, 0F, 0F);
        this.leg1 = new ModelRenderer(this, 92, 0);
        this.leg1.addBox(-15F, -1F, -1F, 16, 2, 2);
        this.leg1.setRotationPoint(-4F, 15F, 2F);
        this.leg1.setTextureSize(64, 32);
        this.setRotation(leg1, 0F, 0.5759587F, -0.4886922F);
        this.leg2 = new ModelRenderer(this, 92, 0);
        this.leg2.addBox(-1F, -1F, -1F, 16, 2, 2);
        this.leg2.setRotationPoint(4F, 15F, 2F);
        this.leg2.setTextureSize(64, 32);
        this.setRotation(leg2, 0F, -0.5759587F, 0.4886922F);
        this.leg3 = new ModelRenderer(this, 92, 0);
        this.leg3.addBox(-15F, -1F, -1F, 16, 2, 2);
        this.leg3.setRotationPoint(-4F, 15F, 1F);
        this.leg3.setTextureSize(64, 32);
        this.setRotation(leg3, 0F, 0.2792527F, -0.5585054F);
        this.leg4 = new ModelRenderer(this, 92, 0);
        this.leg4.addBox(-1F, -1F, -1F, 16, 2, 2);
        this.leg4.setRotationPoint(4F, 15F, 1F);
        this.leg4.setTextureSize(64, 32);
        this.setRotation(leg4, 0F, -0.2792527F, 0.5585054F);
        this.leg5 = new ModelRenderer(this, 92, 0);
        this.leg5.addBox(-15F, -1F, -1F, 16, 2, 2);
        this.leg5.setRotationPoint(-4F, 15F, 0F);
        this.leg5.setTextureSize(64, 32);
        this.leg5.mirror = true;
        this.setRotation(leg5, 0F, -0.2792527F, -0.5585054F);
        this.leg6 = new ModelRenderer(this, 92, 0);
        this.leg6.addBox(-1F, -1F, -1F, 16, 2, 2);
        this.leg6.setRotationPoint(4F, 15F, 0F);
        this.leg6.setTextureSize(64, 32);
        this.setRotation(leg6, 0F, 0.2792527F, 0.5585054F);
        this.leg7 = new ModelRenderer(this, 92, 0);
        this.leg7.addBox(-15F, -1F, -1F, 16, 2, 2);
        this.leg7.setRotationPoint(-4F, 15F, -1F);
        this.leg7.setTextureSize(64, 32);
        this.leg7.mirror = true;
        this.setRotation(leg7, 0F, -0.5759587F, -0.5585054F);
        this.leg8 = new ModelRenderer(this, 92, 0);
        this.leg8.addBox(-1F, -1F, -1F, 16, 2, 2);
        this.leg8.setRotationPoint(4F, 15F, -1F);
        this.leg8.setTextureSize(64, 32);
        this.setRotation(leg8, 0F, 0.5759587F, 0.5585054F);

        this.convertToChild(head, righteye);
        this.convertToChild(head, lefteye);
        this.convertToChild(head, hair);
        this.convertToChild(rightarm, rightarmlower);
        this.convertToChild(leftarm, leftarmlower);
        this.convertToChild(body4, body5);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale);
        this.headaccessory.render(scale);
        this.neck.render(scale);
        this.bodytop.render(scale);
        this.bodymiddlebutton.render(scale);
        this.bodymiddle.render(scale);
        this.bodybottom.render(scale);
        this.rightchest.render(scale);
        this.leftchest.render(scale);
        this.rightarm.render(scale);
        this.leftarm.render(scale);
        // this.righteye.render(scale);
        // this.lefteye.render(scale);
        // this.hair.render(scale);
        // this.rightarmlower.render(scale);
        // this.leftarmlower.render(scale);
        this.waist.render(scale);
        this.skull1.render(scale);
        this.skull2.render(scale);
        this.skull3.render(scale);
        this.body1.render(scale);
        this.body2.render(scale);
        this.body3.render(scale);
        this.body4.render(scale);
        // this.body5.render(scale);
        this.leg1.render(scale);
        this.leg2.render(scale);
        this.leg3.render(scale);
        this.leg4.render(scale);
        this.leg5.render(scale);
        this.leg6.render(scale);
        this.leg7.render(scale);
        this.leg8.render(scale);

        if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
            this.headeyes.render(scale);
        }
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
            Entity entityIn) {
        // head
        this.head.rotateAngleY = netHeadYaw / 57.295776F;
        this.head.rotateAngleX = headPitch / 57.295776F;
        this.headeyes.rotateAngleY = this.head.rotateAngleY;
        this.headeyes.rotateAngleX = this.head.rotateAngleX;
        this.headaccessory.rotateAngleY = this.head.rotateAngleY;
        this.headaccessory.rotateAngleX = this.head.rotateAngleX;

        // arms
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;

        if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        this.rightarm.rotateAngleZ += 0.3490659F;
        this.leftarm.rotateAngleZ -= 0.3490659F;

        // body
        this.rightchest.rotateAngleX = ((MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount)) + 0.8726646F;
        this.leftchest.rotateAngleX = this.rightchest.rotateAngleX;

        this.skull1.rotateAngleX = ((MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount)) + 0.1745329F;
        this.skull2.rotateAngleX = ((MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount)) + 0.2443461F;
        this.skull3.rotateAngleX = ((MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount)) + 0.1745329F;

        this.body4.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount);
        this.body5.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.05F * limbSwingAmount);

        this.body4.rotateAngleX -= 0.4363323F;

        // legs
        float f6 = 0.7853982F;
        this.leg1.rotateAngleZ = -f6;
        this.leg2.rotateAngleZ = f6;
        this.leg3.rotateAngleZ = -f6 * 0.74F;
        this.leg4.rotateAngleZ = f6 * 0.74F;
        this.leg5.rotateAngleZ = -f6 * 0.74F;
        this.leg6.rotateAngleZ = f6 * 0.74F;
        this.leg7.rotateAngleZ = -f6;
        this.leg8.rotateAngleZ = f6;
        float f7 = -0.0F;
        float f8 = 0.3926991F;
        this.leg1.rotateAngleY = f8 * 2.0F + f7;
        this.leg2.rotateAngleY = -f8 * 2.0F - f7;
        this.leg3.rotateAngleY = f8 * 1.0F + f7;
        this.leg4.rotateAngleY = -f8 * 1.0F - f7;
        this.leg5.rotateAngleY = -f8 * 1.0F + f7;
        this.leg6.rotateAngleY = f8 * 1.0F - f7;
        this.leg7.rotateAngleY = -f8 * 2.0F + f7;
        this.leg8.rotateAngleY = f8 * 2.0F - f7;
        float f9 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f10 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f11 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * limbSwingAmount;
        float f12 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 4.712389F) * 0.4F) * limbSwingAmount;
        float f13 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f14 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f15 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 1.5707964F) * 0.4F) * limbSwingAmount;
        float f16 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 4.712389F) * 0.4F) * limbSwingAmount;
        this.leg1.rotateAngleY += f9;
        this.leg2.rotateAngleY += -f9;
        this.leg3.rotateAngleY += f10;
        this.leg4.rotateAngleY += -f10;
        this.leg5.rotateAngleY += f11;
        this.leg6.rotateAngleY += -f11;
        this.leg7.rotateAngleY += f12;
        this.leg8.rotateAngleY += -f12;
        this.leg1.rotateAngleZ += f13;
        this.leg2.rotateAngleZ += -f13;
        this.leg3.rotateAngleZ += f14;
        this.leg4.rotateAngleZ += -f14;
        this.leg5.rotateAngleZ += f15;
        this.leg6.rotateAngleZ += -f15;
        this.leg7.rotateAngleZ += f16;
        this.leg8.rotateAngleZ += -f16;
    }

    public void holdingMelee(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
            Entity entityIn) {
        float f6;
        float f7;

        f6 = this.swingProgress;
        f6 = 1.0F - this.swingProgress;
        f6 *= f6;
        f6 *= f6;
        f6 = 1.0F - f6;
        f7 = MathHelper.sin(f6 * (float) Math.PI);
        float f8 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;

        this.rightarm.rotateAngleX = (float) ((double) this.rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
        this.rightarm.rotateAngleX += (this.bodytop.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F);
    }
}
