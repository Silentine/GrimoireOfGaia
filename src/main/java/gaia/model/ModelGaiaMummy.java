package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMummy extends ModelGaia {

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
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer headbandage;
    ModelRenderer rightarmbandage;
    ModelRenderer leftarmbandage;
    ModelRenderer waist;

    public ModelGaiaMummy() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
        this.head.setRotationPoint(0F, 1F, 0F);
        this.head.setTextureSize(64, 32);
        this.setRotation(head, 0F, 0F, 0F);
        this.headeyes = new ModelRenderer(this, 24, 0);
        this.headeyes.addBox(-3F, -6F, -3F, 6, 6, 0);
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
        this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
        this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, -1.570796F, 0F, 0F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.mirror = true;
        this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, -1.570796F, 0F, 0F);
        this.rightleg = new ModelRenderer(this, 24, 12);
        this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.rightleg.setRotationPoint(-2F, 11F, 0F);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(rightleg, 0F, 0F, -0.0349066F);
        this.leftleg = new ModelRenderer(this, 24, 12);
        this.leftleg.mirror = true;
        this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.leftleg.setRotationPoint(2F, 11F, 0F);
        this.leftleg.setTextureSize(64, 32);
        this.setRotation(leftleg, 0F, 0F, 0.0349066F);
        this.headbandage = new ModelRenderer(this, 36, 14);
        this.headbandage.addBox(-4F, -7F, -4F, 8, 8, 8);
        this.headbandage.setRotationPoint(0F, 1F, 0F);
        this.headbandage.setTextureSize(64, 32);
        this.setRotation(headbandage, 0F, 0F, 0F);
        this.rightarmbandage = new ModelRenderer(this, 36, 30);
        this.rightarmbandage.addBox(-2F, -1F, 1F, 2, 12, 4);
        this.rightarmbandage.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarmbandage.setTextureSize(64, 32);
        this.setRotation(rightarmbandage, -1.570796F, 0F, 0F);
        this.leftarmbandage = new ModelRenderer(this, 36, 30);
        this.leftarmbandage.mirror = true;
        this.leftarmbandage.addBox(0F, -1F, 1F, 2, 12, 4);
        this.leftarmbandage.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmbandage.setTextureSize(64, 32);
        this.setRotation(leftarmbandage, -1.570796F, 0F, 0F);
        this.waist = new ModelRenderer(this, 68, 0);
        this.waist.addBox(-4F, 8.5F, -3F, 8, 8, 4);
        this.waist.setRotationPoint(0F, 1F, 0F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.0872665F, 0F, 0F);

        this.convertToChild(head, headbandage);
        this.convertToChild(rightarm, rightarmbandage);
        this.convertToChild(leftarm, leftarmbandage);
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
        // this.headbandage.render(scale);
        // this.rightarmbandage.render(scale);
        // this.leftarmbandage.render(scale);
        this.waist.render(scale);

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
//        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.5F;
//        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;

        if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.rightarm.rotateAngleX += (MathHelper.sin(ageInTicks * 0.067F) * 0.025F) - 1.570796F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.leftarm.rotateAngleX -= (MathHelper.sin(ageInTicks * 0.067F) * 0.025F) + 1.570796F;

        // legs
        this.rightleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount) * 0.5F;
        this.leftleg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount) * 0.5F;
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

        // right arm
        this.rightarm.rotateAngleX -= (float) ((double) this.rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
        this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
        this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F);

        // left arm
        this.leftarm.rotateAngleX -= (float) ((double) this.leftarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
        this.leftarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
        this.leftarm.rotateAngleZ -= (MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F);
    }
}
