package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaEnderEye extends ModelGaia {

    ModelRenderer anchor;
    ModelRenderer body;
    ModelRenderer eyelid1;
    ModelRenderer eyelid2;
    ModelRenderer rightwing;
    ModelRenderer leftwing;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;

    public ModelGaiaEnderEye() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.anchor = new ModelRenderer(this, 0, 0);
        this.anchor.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
        this.anchor.setRotationPoint(0F, -7F, 0F);
        this.anchor.setTextureSize(128, 64);
        this.setRotation(anchor, 0F, 0F, 0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(-4F, -5F, -2F, 8, 8, 6);
        this.body.setRotationPoint(0F, -7F, 0F);
        this.body.setTextureSize(128, 64);
        this.setRotation(body, 0.1745329F, 0F, 0F);
        this.eyelid1 = new ModelRenderer(this, 0, 14);
        this.eyelid1.addBox(-5F, -5F, -9F, 10, 5, 10);
        this.eyelid1.setRotationPoint(0F, -9F, 4.5F);
        this.eyelid1.setTextureSize(128, 64);
        this.setRotation(eyelid1, 0.0349066F, 0F, 0F);
        this.eyelid2 = new ModelRenderer(this, 0, 29);
        this.eyelid2.addBox(-5F, 0F, -9F, 10, 5, 10);
        this.eyelid2.setRotationPoint(0F, -9F, 4.5F);
        this.eyelid2.setTextureSize(128, 64);
        this.setRotation(eyelid2, 0.3490659F, 0F, 0F);
        this.rightwing = new ModelRenderer(this, 98, 38);
        this.rightwing.addBox(0F, 0F, -5F, 0, 16, 10);
        this.rightwing.setRotationPoint(-4F, -9F, 5F);
        this.rightwing.setTextureSize(128, 64);
        this.setRotation(rightwing, 0F, 0F, 1.570796F);
        this.leftwing = new ModelRenderer(this, 108, 38);
        this.leftwing.addBox(0F, 0F, -6F, 0, 16, 10);
        this.leftwing.setRotationPoint(4F, -9F, 5F);
        this.leftwing.setTextureSize(128, 64);
        this.setRotation(leftwing, 0F, 0F, -1.570796F);
        this.tail1 = new ModelRenderer(this, 0, 44);
        this.tail1.addBox(-1.5F, 0F, -1.5F, 3, 3, 3);
        this.tail1.setRotationPoint(0F, -6F, 4F);
        this.tail1.setTextureSize(128, 64);
        this.setRotation(tail1, 0.7853982F, 0F, 0F);
        this.tail2 = new ModelRenderer(this, 0, 50);
        this.tail2.addBox(-1F, 3F, -0.5F, 2, 4, 2);
        this.tail2.setRotationPoint(0F, -6F, 4F);
        this.tail2.setTextureSize(128, 64);
        this.setRotation(tail2, 0.6108652F, 0F, 0F);
        this.tail3 = new ModelRenderer(this, 0, 56);
        this.tail3.addBox(-0.5F, 6F, 1F, 1, 4, 1);
        this.tail3.setRotationPoint(0F, -6F, 4F);
        this.tail3.setTextureSize(128, 64);
        this.setRotation(tail3, 0.4363323F, 0F, 0F);

        this.anchor.addChild(body);
        this.anchor.addChild(eyelid1);
        this.anchor.addChild(eyelid2);
        this.anchor.addChild(rightwing);
        this.anchor.addChild(leftwing);
        this.anchor.addChild(tail1);
        this.anchor.addChild(tail2);
        this.anchor.addChild(tail3);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.anchor.render(scale);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
            Entity entityIn) {
        // anchor
        this.anchor.rotationPointY = MathHelper.cos(((float) 1.5F + ageInTicks) * 0.5F);

        // body
        this.body.rotateAngleY = netHeadYaw / 57.295776F;
        this.eyelid1.rotateAngleX = MathHelper.cos(ageInTicks * 0.4F + (float) Math.PI) * 0.2F * 0.5F;
        this.eyelid1.rotateAngleX += 0.0349066F;
        this.eyelid2.rotateAngleX = MathHelper.cos(ageInTicks * 0.4F) * 0.08F * 0.5F;
        this.eyelid2.rotateAngleX += 0.3490659F;
        this.rightwing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F + (float) Math.PI) * 1.6F * 0.5F;
        this.rightwing.rotateAngleZ = this.rightwing.rotateAngleZ + 1.570796F;
        this.leftwing.rotateAngleZ = MathHelper.cos(ageInTicks * 0.6F) * 1.6F * 0.5F;
        this.leftwing.rotateAngleZ = this.leftwing.rotateAngleZ - 1.570796F;
        this.tail1.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.2F * 0.5F;
        this.tail1.rotateAngleX += 0.7853982F;
        this.tail2.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.2F * 0.5F;
        this.tail2.rotateAngleX += 0.6108652F;
        this.tail3.rotateAngleX = MathHelper.cos(ageInTicks * 1.2F + (float) Math.PI) * 0.2F * 0.5F;
        this.tail3.rotateAngleX += 0.4363323F;
    }
}
