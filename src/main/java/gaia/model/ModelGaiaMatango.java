package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMatango extends ModelGaia {

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
    ModelRenderer hair1;
    ModelRenderer hair2;
    ModelRenderer headmushroom1;
    ModelRenderer headmushroom2;
    ModelRenderer rightarmupper;
    ModelRenderer leftarmupper;
    ModelRenderer mushroom1;
    ModelRenderer mushroom2;
    ModelRenderer waist1;
    ModelRenderer waist2;

    public ModelGaiaMatango() {
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
        this.headeyes.setTextureSize(64, 32);
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
        this.setRotation(rightarm, 0F, 0F, 0.1745329F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(128, 64);
        this.setRotation(leftarm, 0F, 0F, -0.1745329F);
        this.rightleg = new ModelRenderer(this, 24, 12);
        this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.rightleg.setRotationPoint(-2F, 11F, 0F);
        this.rightleg.setTextureSize(128, 64);
        this.setRotation(rightleg, 0F, 0F, -0.0349066F);
        this.leftleg = new ModelRenderer(this, 24, 12);
        this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.leftleg.setRotationPoint(2F, 11F, 0F);
        this.leftleg.setTextureSize(128, 64);
        this.setRotation(leftleg, 0F, 0F, 0.0349066F);
        this.hair1 = new ModelRenderer(this, 36, 14);
        this.hair1.addBox(-4F, -5.5F, -1F, 8, 5, 5);
        this.hair1.setRotationPoint(0F, 1F, 0F);
        this.hair1.setTextureSize(128, 64);
        this.setRotation(hair1, 0F, 0F, 0F);
        this.hair2 = new ModelRenderer(this, 36, 24);
        this.hair2.addBox(-4.5F, -4.5F, -0.5F, 9, 5, 5);
        this.hair2.setRotationPoint(0F, 1F, 0F);
        this.hair2.setTextureSize(128, 64);
        this.setRotation(hair2, 0F, 0F, 0F);
        this.headmushroom1 = new ModelRenderer(this, 36, 34);
        this.headmushroom1.addBox(-0.5F, -8.5F, -0.5F, 3, 3, 3);
        this.headmushroom1.setRotationPoint(0F, 1F, 0F);
        this.headmushroom1.setTextureSize(128, 64);
        this.setRotation(headmushroom1, 0F, 0F, 0F);
        this.headmushroom2 = new ModelRenderer(this, 36, 40);
        this.headmushroom2.addBox(-2.5F, -7.5F, -2.5F, 2, 2, 2);
        this.headmushroom2.setRotationPoint(0F, 1F, 0F);
        this.headmushroom2.setTextureSize(128, 64);
        this.setRotation(headmushroom2, 0F, 0F, 0F);
        this.rightarmupper = new ModelRenderer(this, 64, 0);
        this.rightarmupper.addBox(-2.5F, -1F, -1.5F, 3, 2, 3);
        this.rightarmupper.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarmupper.setTextureSize(128, 64);
        this.setRotation(rightarmupper, 0F, 0F, 0.1745329F);
        this.leftarmupper = new ModelRenderer(this, 64, 0);
        this.leftarmupper.addBox(-0.5F, -1F, -1.5F, 3, 2, 3);
        this.leftarmupper.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmupper.setTextureSize(128, 64);
        this.setRotation(leftarmupper, 0F, 0F, -0.1745329F);
        this.mushroom1 = new ModelRenderer(this, 36, 34);
        this.mushroom1.addBox(-3F, 6.5F, -1.5F, 3, 3, 3);
        this.mushroom1.setRotationPoint(0F, 1F, 0F);
        this.mushroom1.setTextureSize(128, 64);
        this.setRotation(mushroom1, 0.0872665F, 0F, 0F);
        this.mushroom2 = new ModelRenderer(this, 36, 40);
        this.mushroom2.addBox(1F, 6.5F, -3.5F, 2, 2, 2);
        this.mushroom2.setRotationPoint(0F, 1F, 0F);
        this.mushroom2.setTextureSize(128, 64);
        this.setRotation(mushroom2, 0.0872665F, 0F, 0F);
        this.waist1 = new ModelRenderer(this, 64, 5);
        this.waist1.addBox(-3.5F, 7.5F, -4F, 7, 2, 6);
        this.waist1.setRotationPoint(0F, 1F, 0F);
        this.waist1.setTextureSize(128, 64);
        this.setRotation(waist1, 0.0872665F, 0F, 0F);
        this.waist2 = new ModelRenderer(this, 64, 13);
        this.waist2.addBox(-4F, 9F, -4.5F, 8, 4, 7);
        this.waist2.setRotationPoint(0F, 1F, 0F);
        this.waist2.setTextureSize(128, 64);
        this.setRotation(waist2, 0.0872665F, 0F, 0F);

        this.convertToChild(head, hair1);
        this.convertToChild(head, hair2);
        this.convertToChild(head, headmushroom1);
        this.convertToChild(head, headmushroom2);
        this.convertToChild(rightarm, rightarmupper);
        this.convertToChild(leftarm, leftarmupper);
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
        // this.hair1.render(scale);
        // this.hair2.render(scale);
        // this.headmushroom1.render(scale);
        // this.headmushroom2.render(scale);
        // this.rightarmupper.render(scale);
        // this.leftarmupper.render(scale);
        this.mushroom1.render(scale);
        this.mushroom2.render(scale);
        this.waist1.render(scale);
        this.waist2.render(scale);

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

        float f6;
        float f7;

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // body
        this.waist1.rotateAngleY = ((MathHelper.cos(limbSwing * 0.6662F) * 0.5F) / 2) * limbSwingAmount;
        this.waist2.rotateAngleY = this.waist1.rotateAngleY;

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
    }
}
