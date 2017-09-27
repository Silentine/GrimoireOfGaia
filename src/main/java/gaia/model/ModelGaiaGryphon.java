package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaGryphon extends ModelGaia {

    ModelRenderer head;
    ModelRenderer headbrow;
    ModelRenderer beak1;
    ModelRenderer beak2;
    ModelRenderer rightheadear;
    ModelRenderer leftheadear;
    ModelRenderer neck1;
    ModelRenderer neck2;
    ModelRenderer rightwing;
    ModelRenderer leftwing;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer frontrightleg1;
    ModelRenderer frontrightleg2;
    ModelRenderer frontrightclaw;
    ModelRenderer frontleftleg1;
    ModelRenderer frontleftleg2;
    ModelRenderer frontleftclaw;
    ModelRenderer backrightleg1;
    ModelRenderer backrightleg2;
    ModelRenderer backrightleg3;
    ModelRenderer backrightfoot;
    ModelRenderer backleftleg1;
    ModelRenderer backleftleg2;
    ModelRenderer backleftleg3;
    ModelRenderer backleftfoot;
    ModelRenderer tail1;
    ModelRenderer tail2;

    public ModelGaiaGryphon() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-2.5F, -11.5F, -4.5F, 5, 5, 6);
        this.head.setRotationPoint(0F, 8F, -7F);
        this.head.setTextureSize(64, 32);
        this.setRotation(head, 0.1745329F, 0F, 0F);
        this.headbrow = new ModelRenderer(this, 0, 11);
        this.headbrow.addBox(-2.5F, -10.5F, -5.5F, 5, 1, 1);
        this.headbrow.setRotationPoint(0F, 8F, -7F);
        this.headbrow.setTextureSize(64, 32);
        this.setRotation(headbrow, 0.1745329F, 0F, 0F);
        this.beak1 = new ModelRenderer(this, 0, 13);
        this.beak1.addBox(-1.5F, -9.5F, -8.5F, 3, 3, 4);
        this.beak1.setRotationPoint(0F, 8F, -7F);
        this.beak1.setTextureSize(64, 32);
        this.setRotation(beak1, 0.1745329F, 0F, 0F);
        this.beak2 = new ModelRenderer(this, 0, 20);
        this.beak2.addBox(-1F, -9F, -9F, 2, 3, 1);
        this.beak2.setRotationPoint(0F, 8F, -7F);
        this.beak2.setTextureSize(64, 32);
        this.setRotation(beak2, 0.1745329F, 0F, 0F);
        this.rightheadear = new ModelRenderer(this, 0, 24);
        this.rightheadear.addBox(-3F, -12F, -0.5F, 2, 2, 6);
        this.rightheadear.setRotationPoint(0F, 8F, -7F);
        this.rightheadear.setTextureSize(64, 32);
        this.setRotation(rightheadear, 0.1745329F, 0F, 0F);
        this.leftheadear = new ModelRenderer(this, 0, 24);
        this.leftheadear.mirror = true;
        this.leftheadear.addBox(1F, -12F, -0.5F, 2, 2, 6);
        this.leftheadear.setRotationPoint(0F, 8F, -7F);
        this.leftheadear.setTextureSize(64, 32);
        this.setRotation(leftheadear, 0.1745329F, 0F, 0F);
        this.neck1 = new ModelRenderer(this, 28, 0);
        this.neck1.addBox(-3F, -7F, -5.5F, 6, 6, 6);
        this.neck1.setRotationPoint(0F, 8F, -7F);
        this.neck1.setTextureSize(128, 64);
        this.setRotation(neck1, -0.2268928F, 0F, 0F);
        this.neck2 = new ModelRenderer(this, 28, 12);
        this.neck2.addBox(-3.5F, -4.5F, -4F, 7, 8, 7);
        this.neck2.setRotationPoint(0F, 8F, -7F);
        this.neck2.setTextureSize(128, 64);
        this.setRotation(neck2, 0.5235988F, 0F, 0F);
        this.rightwing = new ModelRenderer(this, 108, 38);
        this.rightwing.addBox(0F, 0F, 0F, 0, 16, 10);
        this.rightwing.setRotationPoint(-4F, 7F, -6F);
        this.rightwing.setTextureSize(128, 64);
        this.setRotation(rightwing, 1.047198F, -0.1745329F, 0.2617994F);
        this.leftwing = new ModelRenderer(this, 108, 38);
        this.leftwing.mirror = true;
        this.leftwing.addBox(0F, 0F, 0F, 0, 16, 10);
        this.leftwing.setRotationPoint(4F, 7F, -6F);
        this.leftwing.setTextureSize(128, 64);
        this.setRotation(leftwing, 1.047198F, 0.1745329F, -0.2617994F);
        this.body1 = new ModelRenderer(this, 56, 0);
        this.body1.addBox(-4F, -4F, -8F, 8, 9, 10);
        this.body1.setRotationPoint(0F, 8F, -3F);
        this.body1.setTextureSize(128, 64);
        this.setRotation(body1, 1.22173F, 0F, 0F);
        this.body2 = new ModelRenderer(this, 56, 19);
        this.body2.addBox(-3F, 1F, -8F, 6, 12, 8);
        this.body2.setRotationPoint(0F, 8F, -3F);
        this.body2.setTextureSize(128, 64);
        this.setRotation(body2, 1.658063F, 0F, 0F);
        this.frontrightleg1 = new ModelRenderer(this, 92, 0);
        this.frontrightleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
        this.frontrightleg1.setRotationPoint(-4F, 9F, -6F);
        this.frontrightleg1.setTextureSize(128, 64);
        this.setRotation(frontrightleg1, 0.1745329F, 0F, -0.0349066F);
        this.frontrightleg2 = new ModelRenderer(this, 92, 11);
        this.frontrightleg2.addBox(-1F, 6F, 2F, 2, 8, 3);
        this.frontrightleg2.setRotationPoint(-4F, 9F, -6F);
        this.frontrightleg2.setTextureSize(128, 64);
        this.setRotation(frontrightleg2, -0.1745329F, 0F, -0.0349066F);
        this.frontrightclaw = new ModelRenderer(this, 92, 22);
        this.frontrightclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
        this.frontrightclaw.setRotationPoint(-4F, 9F, -6F);
        this.frontrightclaw.setTextureSize(128, 64);
        this.setRotation(frontrightclaw, 0.0872665F, 0F, -0.0349066F);
        this.frontleftleg1 = new ModelRenderer(this, 92, 0);
        this.frontleftleg1.addBox(-1.5F, 0F, -1.5F, 3, 8, 3);
        this.frontleftleg1.setRotationPoint(4F, 9F, -6F);
        this.frontleftleg1.setTextureSize(128, 64);
        this.setRotation(frontleftleg1, 0.1745329F, 0F, 0.0349066F);
        this.frontleftleg2 = new ModelRenderer(this, 92, 11);
        this.frontleftleg2.addBox(-1F, 6F, 2F, 2, 8, 3);
        this.frontleftleg2.setRotationPoint(4F, 9F, -6F);
        this.frontleftleg2.setTextureSize(128, 64);
        this.setRotation(frontleftleg2, -0.1745329F, 0F, 0.0349066F);
        this.frontleftclaw = new ModelRenderer(this, 92, 22);
        this.frontleftclaw.addBox(-2F, 14F, -4F, 4, 1, 4);
        this.frontleftclaw.setRotationPoint(4F, 9F, -6F);
        this.frontleftclaw.setTextureSize(128, 64);
        this.setRotation(frontleftclaw, 0.0872665F, 0F, 0.0349066F);
        this.backrightleg1 = new ModelRenderer(this, 108, 0);
        this.backrightleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
        this.backrightleg1.setRotationPoint(-3F, 8F, 9F);
        this.backrightleg1.setTextureSize(128, 64);
        this.setRotation(backrightleg1, -0.296706F, 0F, -0.0349066F);
        this.backrightleg2 = new ModelRenderer(this, 108, 14);
        this.backrightleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
        this.backrightleg2.setRotationPoint(-3F, 8F, 9F);
        this.backrightleg2.setTextureSize(128, 64);
        this.setRotation(backrightleg2, -0.8726646F, 0F, -0.0349066F);
        this.backrightleg3 = new ModelRenderer(this, 108, 23);
        this.backrightleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
        this.backrightleg3.setRotationPoint(-3F, 8F, 9F);
        this.backrightleg3.setTextureSize(128, 64);
        this.setRotation(backrightleg3, -0.2617994F, 0F, -0.0349066F);
        this.backrightfoot = new ModelRenderer(this, 108, 32);
        this.backrightfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
        this.backrightfoot.setRotationPoint(-3F, 8F, 9F);
        this.backrightfoot.setTextureSize(128, 64);
        this.setRotation(backrightfoot, 0.0872665F, 0F, -0.0349066F);
        this.backleftleg1 = new ModelRenderer(this, 108, 0);
        this.backleftleg1.addBox(-1.5F, 0F, -3F, 3, 8, 6);
        this.backleftleg1.setRotationPoint(3F, 8F, 9F);
        this.backleftleg1.setTextureSize(128, 64);
        this.setRotation(backleftleg1, -0.296706F, 0F, 0.0349066F);
        this.backleftleg2 = new ModelRenderer(this, 108, 14);
        this.backleftleg2.addBox(-1F, 5.5F, 2F, 2, 3, 6);
        this.backleftleg2.setRotationPoint(3F, 8F, 9F);
        this.backleftleg2.setTextureSize(128, 64);
        this.setRotation(backleftleg2, -0.8726646F, 0F, 0.0349066F);
        this.backleftleg3 = new ModelRenderer(this, 108, 23);
        this.backleftleg3.addBox(-1F, 9F, 1F, 2, 6, 3);
        this.backleftleg3.setRotationPoint(3F, 8F, 9F);
        this.backleftleg3.setTextureSize(128, 64);
        this.setRotation(backleftleg3, -0.2617994F, 0F, 0.0349066F);
        this.backleftfoot = new ModelRenderer(this, 108, 32);
        this.backleftfoot.addBox(-1.5F, 14F, -5F, 3, 2, 3);
        this.backleftfoot.setRotationPoint(3F, 8F, 9F);
        this.backleftfoot.setTextureSize(128, 64);
        this.setRotation(backleftfoot, 0.0872665F, 0F, 0.0349066F);
        this.tail1 = new ModelRenderer(this, 56, 39);
        this.tail1.addBox(-1F, 0F, -1F, 2, 10, 2);
        this.tail1.setRotationPoint(0F, 8F, 10F);
        this.tail1.setTextureSize(128, 64);
        this.setRotation(tail1, 0.6108652F, 0F, 0F);
        this.tail2 = new ModelRenderer(this, 56, 51);
        this.tail2.addBox(-1.5F, 8F, -1.5F, 3, 6, 3);
        this.tail2.setRotationPoint(0F, 8F, 10F);
        this.tail2.setTextureSize(128, 64);
        this.setRotation(tail2, 0.6108652F, 0F, 0F);

        this.convertToChild(head, headbrow);
        this.convertToChild(head, beak1);
        this.convertToChild(head, beak2);
        this.convertToChild(head, rightheadear);
        this.convertToChild(head, leftheadear);
        this.convertToChild(frontrightleg1, frontrightleg2);
        this.convertToChild(frontrightleg1, frontrightclaw);
        this.convertToChild(frontleftleg1, frontleftleg2);
        this.convertToChild(frontleftleg1, frontleftclaw);

        this.convertToChild(backrightleg1, backrightleg2);
        this.convertToChild(backrightleg1, backrightleg3);
        this.convertToChild(backrightleg1, backrightfoot);
        this.convertToChild(backleftleg1, backleftleg2);
        this.convertToChild(backleftleg1, backleftleg3);
        this.convertToChild(backleftleg1, backleftfoot);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale);
        // this.headbrow.render(scale);
        // this.beak1.render(scale);
        // this.beak2.render(scale);
        // this.rightheadear.render(scale);
        // this.leftheadear.render(scale);
        this.neck1.render(scale);
        this.neck2.render(scale);
        this.rightwing.render(scale);
        this.leftwing.render(scale);
        this.body1.render(scale);
        this.body2.render(scale);
        this.frontrightleg1.render(scale);
        // this.frontrightleg2.render(scale);
        // this.frontrightclaw.render(scale);
        this.frontleftleg1.render(scale);
        // this.frontleftleg2.render(scale);
        // this.frontleftclaw.render(scale);
        this.backrightleg1.render(scale);
        // this.backrightleg2.render(scale);
        // this.backrightleg3.render(scale);
        // this.backrightfoot.render(scale);
        this.backleftleg1.render(scale);
        // this.backleftleg2.render(scale);
        // this.backleftleg3.render(scale);
        // this.backleftfoot.render(scale);
        this.tail1.render(scale);
        this.tail2.render(scale);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
            Entity entityIn) {
        // head
        this.head.rotateAngleY = netHeadYaw / 57.295776F;
        this.neck1.rotateAngleY = this.head.rotateAngleY;
        this.neck2.rotateAngleY = this.head.rotateAngleY;

        if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        // arms
        this.frontrightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
        this.frontleftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
        this.frontrightleg1.rotateAngleX = this.frontrightleg1.rotateAngleX + 0.1745329F;
        this.frontleftleg1.rotateAngleX = this.frontleftleg1.rotateAngleX + 0.1745329F;

        // body
        this.rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
        this.leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.6662F) * 1.0F * limbSwingAmount * 0.5F;
        this.rightwing.rotateAngleY = this.rightwing.rotateAngleY - 0.1745329F;
        this.leftwing.rotateAngleY = this.leftwing.rotateAngleY + 0.1745329F;
        this.tail1.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(5);
        this.tail2.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(7);

        // legs
        this.backrightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
        this.backleftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
        this.backrightleg1.rotateAngleX = this.backrightleg1.rotateAngleX - 0.296706F;
        this.backleftleg1.rotateAngleX = this.backleftleg1.rotateAngleX - 0.296706F;
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

        this.head.rotateAngleX -= (float) ((double) this.head.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
    }
}
