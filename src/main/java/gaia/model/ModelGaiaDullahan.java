package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDullahan extends ModelGaia {

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
    ModelRenderer rightshoulder;
    ModelRenderer leftshoulder;
    ModelRenderer leftarmlower;
    ModelRenderer rightgauntlet;
    ModelRenderer leftgauntlet;
    ModelRenderer waist1;
    ModelRenderer waist2;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;

    public ModelGaiaDullahan() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3F, -3F, -3F, 6, 6, 6);
        this.head.setRotationPoint(4F, 3F, -6F);
        this.head.setTextureSize(64, 32);
        this.setRotation(head, 0F, 0F, 0F);
        this.headeyes = new ModelRenderer(this, 24, 0);
        this.headeyes.addBox(-3F, -3F, -3.1F, 6, 6, 0);
        this.headeyes.setRotationPoint(4F, 3F, -6F);
        this.headeyes.setTextureSize(64, 32);
        this.setRotation(headeyes, 0F, 0F, 0F);
        this.headaccessory = new ModelRenderer(this, 36, 0);
        this.headaccessory.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7);
        this.headaccessory.setRotationPoint(4F, 3F, -6F);
        this.headaccessory.setTextureSize(64, 32);
        this.setRotation(headaccessory, 0F, 0F, 0F);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.neck.setRotationPoint(0F, 1F, 0F);
        this.neck.setTextureSize(64, 32);
        this.setRotation(neck, -0.0872665F, 0F, 0F);
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
        this.rightchest.setRotationPoint(-1.25F, 3F, -1.5F);
        this.rightchest.setTextureSize(64, 32);
        this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0F);
        this.leftchest = new ModelRenderer(this, 0, 36);
        this.leftchest.mirror = true;
        this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
        this.leftchest.setTextureSize(64, 32);
        this.setRotation(leftchest, 0.7853982F, -0.1745329F, 0F);
        this.rightarm = new ModelRenderer(this, 16, 12);
        this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
        this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0F, 0F, 0.1745329F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 6, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0F, 0F, -0.1745329F);
        this.rightleg = new ModelRenderer(this, 24, 12);
        this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.rightleg.setRotationPoint(-2F, 11F, 0F);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(rightleg, 0F, 0F, 0F);
        this.leftleg = new ModelRenderer(this, 24, 12);
        this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.leftleg.setRotationPoint(2F, 11F, 0F);
        this.leftleg.setTextureSize(64, 32);
        this.setRotation(leftleg, 0F, 0F, 0F);
        this.rightshoulder = new ModelRenderer(this, 36, 14);
        this.rightshoulder.addBox(-3.5F, -3F, -2F, 4, 5, 4);
        this.rightshoulder.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightshoulder.setTextureSize(64, 32);
        this.setRotation(rightshoulder, 0F, 0F, -0.1745329F);
        this.leftshoulder = new ModelRenderer(this, 52, 14);
        this.leftshoulder.addBox(-0.5F, -3F, -2F, 4, 5, 4);
        this.leftshoulder.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftshoulder.setTextureSize(64, 32);
        this.setRotation(leftshoulder, 0F, 0F, 0.1745329F);
        this.leftarmlower = new ModelRenderer(this, 16, 20);
        this.leftarmlower.addBox(0F, 0F, 4F, 2, 6, 2);
        this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmlower.setTextureSize(64, 32);
        this.setRotation(leftarmlower, -1.570796F, 0F, -0.1745329F);
        this.rightgauntlet = new ModelRenderer(this, 36, 23);
        this.rightgauntlet.addBox(-2.5F, 5.5F, -1.5F, 2, 6, 3);
        this.rightgauntlet.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightgauntlet.setTextureSize(64, 32);
        this.setRotation(rightgauntlet, 0F, 0F, 0.1745329F);
        this.leftgauntlet = new ModelRenderer(this, 46, 23);
        this.leftgauntlet.addBox(-0.5F, 0.5F, 4.5F, 3, 6, 2);
        this.leftgauntlet.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftgauntlet.setTextureSize(64, 32);
        this.setRotation(leftgauntlet, -1.570796F, 0F, -0.1745329F);
        this.waist1 = new ModelRenderer(this, 68, 0);
        this.waist1.addBox(-3.5F, 7.5F, -3F, 7, 6, 4);
        this.waist1.setRotationPoint(0F, 1F, 0F);
        this.waist1.setTextureSize(64, 32);
        this.setRotation(waist1, 0.0872665F, 0F, 0F);
        this.waist2 = new ModelRenderer(this, 68, 10);
        this.waist2.addBox(-4F, 8.5F, -3.5F, 8, 8, 4);
        this.waist2.setRotationPoint(0F, 1F, 0F);
        this.waist2.setTextureSize(64, 32);
        this.setRotation(waist2, 0.1745329F, 0F, 0F);
        this.rightfoot = new ModelRenderer(this, 68, 22);
        this.rightfoot.addBox(-2.5F, 5F, -2F, 4, 8, 4);
        this.rightfoot.setRotationPoint(-1.5F, 11F, 0F);
        this.rightfoot.setTextureSize(64, 32);
        this.setRotation(rightfoot, 0F, 0F, 0F);
        this.leftfoot = new ModelRenderer(this, 68, 22);
        this.leftfoot.addBox(-1.5F, 5F, -2F, 4, 8, 4);
        this.leftfoot.setRotationPoint(1.5F, 11F, 0F);
        this.leftfoot.setTextureSize(64, 32);
        this.setRotation(leftfoot, 0F, 0F, 0F);

        this.convertToChild(rightarm, rightshoulder);
        this.convertToChild(rightarm, rightgauntlet);
        this.convertToChild(leftarm, leftshoulder);
        this.convertToChild(leftarm, leftarmlower);
        this.convertToChild(leftarm, leftgauntlet);
        this.convertToChild(rightleg, rightfoot);
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
        // this.rightshoulder.render(scale);
        // this.leftshoulder.render(scale);
        // this.leftarmlower.render(scale);
        // this.rightgauntlet.render(scale);
        // this.leftgauntlet.render(scale);
        this.waist1.render(scale);
        this.waist2.render(scale);
        // this.rightfoot.render(scale);
        // this.leftfoot.render(scale);

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
        this.leftarm.rotateAngleX = 0.0F;

        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;

        if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
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
