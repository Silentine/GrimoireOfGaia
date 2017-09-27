package gaia.model;

import gaia.entity.monster.EntityGaiaKobold;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaKobold extends ModelGaia {

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
    ModelRenderer hair;
    ModelRenderer headnose;
    ModelRenderer headnoseshadow;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer rightarmlower;
    ModelRenderer leftarmlower;
    ModelRenderer righthand;
    ModelRenderer lefthand;
    ModelRenderer backpack;
    ModelRenderer waist;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer rightleglower;
    ModelRenderer leftleglower;
    ModelRenderer rightfootlower;
    ModelRenderer leftfootlower;

    public ModelGaiaKobold() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
        this.head.setRotationPoint(0F, 1F, -1F);
        this.head.setTextureSize(64, 32);
        this.setRotation(head, 0F, 0F, 0F);
        this.headeyes = new ModelRenderer(this, 24, 0);
        this.headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
        this.headeyes.setRotationPoint(0F, 1F, -1F);
        this.headeyes.setTextureSize(64, 32);
        this.setRotation(headeyes, 0F, 0F, 0F);
        this.headaccessory = new ModelRenderer(this, 36, 0);
        this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
        this.headaccessory.setRotationPoint(0F, 1F, -1F);
        this.headaccessory.setTextureSize(64, 32);
        this.setRotation(headaccessory, 0F, 0F, 0F);
        this.neck = new ModelRenderer(this, 0, 12);
        this.neck.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.neck.setRotationPoint(0F, 1F, -1F);
        this.neck.setTextureSize(64, 32);
        this.setRotation(neck, 0F, 0F, 0F);
        this.bodytop = new ModelRenderer(this, 0, 16);
        this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
        this.bodytop.setRotationPoint(0F, 1F, -1F);
        this.bodytop.setTextureSize(64, 32);
        this.setRotation(bodytop, 0F, 0F, 0F);
        this.bodymiddle = new ModelRenderer(this, 0, 25);
        this.bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
        this.bodymiddle.setRotationPoint(0F, 1F, -1F);
        this.bodymiddle.setTextureSize(64, 32);
        this.setRotation(bodymiddle, 0.0872665F, 0F, 0F);
        this.bodymiddlebutton = new ModelRenderer(this, 0, 25);
        this.bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
        this.bodymiddlebutton.setRotationPoint(0F, 1F, -1F);
        this.bodymiddlebutton.setTextureSize(64, 32);
        this.setRotation(bodymiddlebutton, 0.0872665F, 0F, 0F);
        this.bodybottom = new ModelRenderer(this, 0, 30);
        this.bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
        this.bodybottom.setRotationPoint(0F, 1F, -1F);
        this.bodybottom.setTextureSize(64, 32);
        this.setRotation(bodybottom, 0.1745329F, 0F, 0F);
        this.rightchest = new ModelRenderer(this, 0, 36);
        this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.rightchest.setRotationPoint(-1.3F, 3F, -2.5F);
        this.rightchest.setTextureSize(64, 32);
        this.setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
        this.leftchest = new ModelRenderer(this, 0, 36);
        this.leftchest.mirror = true;
        this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.leftchest.setRotationPoint(1.3F, 3F, -2.5F);
        this.leftchest.setTextureSize(64, 32);
        this.setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
        this.rightarm = new ModelRenderer(this, 16, 12);
        this.rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
        this.rightarm.setRotationPoint(-2.5F, 2.5F, -1F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0F, 0F, 0.1745329F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.mirror = true;
        this.leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, -1F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0F, 0F, -0.1745329F);
        this.rightleg = new ModelRenderer(this, 98, 0);
        this.rightleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
        this.rightleg.setRotationPoint(-2.5F, 12F, 0F);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(rightleg, -0.3490659F, -0.0872665F, -0.0349066F);
        this.leftleg = new ModelRenderer(this, 98, 0);
        this.leftleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
        this.leftleg.setRotationPoint(2.5F, 12F, 0F);
        this.leftleg.setTextureSize(64, 32);
        this.setRotation(leftleg, -0.3490659F, 0.0872665F, 0.0349066F);
        this.hair = new ModelRenderer(this, 36, 14);
        this.hair.addBox(-4F, -2.5F, 0F, 8, 4, 4);
        this.hair.setRotationPoint(0F, 1F, -1F);
        this.hair.setTextureSize(64, 32);
        this.setRotation(hair, 0F, 0F, 0F);
        this.headnose = new ModelRenderer(this, 36, 22);
        this.headnose.addBox(-0.5F, -2.5F, -3.1F, 1, 1, 1);
        this.headnose.setRotationPoint(0F, 1F, -1F);
        this.headnose.setTextureSize(64, 32);
        this.setRotation(headnose, 0F, 0F, 0F);
        this.headnoseshadow = new ModelRenderer(this, 36, 24);
        this.headnoseshadow.addBox(-0.5F, -4F, -3.2F, 1, 2, 1);
        this.headnoseshadow.setRotationPoint(0F, 1F, -1F);
        this.headnoseshadow.setTextureSize(64, 32);
        this.setRotation(headnoseshadow, 0F, 0F, 0F);
        this.rightear = new ModelRenderer(this, 36, 27);
        this.rightear.addBox(-1.5F, -7F, -5.5F, 3, 6, 3);
        this.rightear.setRotationPoint(0F, 1F, -1F);
        this.rightear.setTextureSize(64, 32);
        this.setRotation(rightear, 0F, 0.7853982F, 0F);
        this.leftear = new ModelRenderer(this, 36, 27);
        this.leftear.mirror = true;
        this.leftear.addBox(-1.5F, -7F, -5.5F, 3, 6, 3);
        this.leftear.setRotationPoint(0F, 1F, -1F);
        this.leftear.setTextureSize(64, 32);
        this.setRotation(leftear, 0F, -0.7853982F, 0F);
        this.rightarmlower = new ModelRenderer(this, 64, 0);
        this.rightarmlower.addBox(-2.5F, 2F, -1.5F, 2, 8, 3);
        this.rightarmlower.setRotationPoint(-2.5F, 2.5F, -1F);
        this.rightarmlower.setTextureSize(64, 32);
        this.setRotation(rightarmlower, 0F, 0F, 0.1745329F);
        this.leftarmlower = new ModelRenderer(this, 64, 0);
        this.leftarmlower.mirror = true;
        this.leftarmlower.addBox(0.5F, 2F, -1.5F, 2, 8, 3);
        this.leftarmlower.setRotationPoint(2.5F, 2.5F, -1F);
        this.leftarmlower.setTextureSize(64, 32);
        this.setRotation(leftarmlower, 0F, 0F, -0.1745329F);
        this.righthand = new ModelRenderer(this, 64, 11);
        this.righthand.addBox(-2.5F, 8F, -2F, 2, 4, 4);
        this.righthand.setRotationPoint(-2.5F, 2.5F, -1F);
        this.righthand.setTextureSize(64, 32);
        this.setRotation(righthand, 0F, 0F, 0.0872665F);
        this.lefthand = new ModelRenderer(this, 64, 11);
        this.lefthand.mirror = true;
        this.lefthand.addBox(0.5F, 8F, -2F, 2, 4, 4);
        this.lefthand.setRotationPoint(2.5F, 2.5F, -1F);
        this.lefthand.setTextureSize(64, 32);
        this.setRotation(lefthand, 0F, 0F, -0.0872665F);
        this.backpack = new ModelRenderer(this, 76, 0);
        this.backpack.addBox(-2.5F, 5F, 0.5F, 5, 4, 3);
        this.backpack.setRotationPoint(0F, 1F, -1F);
        this.backpack.setTextureSize(64, 32);
        this.setRotation(backpack, 0.1745329F, 0F, 0F);
        this.waist = new ModelRenderer(this, 76, 7);
        this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
        this.waist.setRotationPoint(0F, 1F, -1F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.1745329F, 0F, 0F);
        this.tail1 = new ModelRenderer(this, 76, 15);
        this.tail1.addBox(-1F, 7F, -3.5F, 2, 5, 2);
        this.tail1.setRotationPoint(0F, 1F, -1F);
        this.tail1.setTextureSize(64, 32);
        this.setRotation(tail1, 0.5235988F, 0F, 0F);
        this.tail2 = new ModelRenderer(this, 76, 22);
        this.tail2.addBox(-1.5F, 11F, -5F, 3, 8, 3);
        this.tail2.setRotationPoint(0F, 1F, -1F);
        this.tail2.setTextureSize(64, 32);
        this.setRotation(tail2, 0.6108652F, 0F, 0F);
        this.rightleglower = new ModelRenderer(this, 98, 11);
        this.rightleglower.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
        this.rightleglower.setRotationPoint(-2.5F, 12F, 0F);
        this.rightleglower.setTextureSize(64, 32);
        this.setRotation(rightleglower, -0.3490659F, -0.0872665F, -0.0349066F);
        this.leftleglower = new ModelRenderer(this, 98, 11);
        this.leftleglower.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
        this.leftleglower.setRotationPoint(2.5F, 12F, 0F);
        this.leftleglower.setTextureSize(64, 32);
        this.setRotation(leftleglower, -0.3490659F, 0.0872665F, 0.0349066F);
        this.rightfootlower = new ModelRenderer(this, 98, 21);
        this.rightfootlower.addBox(-1.5F, 10.5F, -5F, 3, 1, 3);
        this.rightfootlower.setRotationPoint(-2.5F, 12F, 0F);
        this.rightfootlower.setTextureSize(64, 32);
        this.setRotation(rightfootlower, 0.0872665F, -0.0872665F, -0.0349066F);
        this.leftfootlower = new ModelRenderer(this, 98, 21);
        this.leftfootlower.addBox(-1.5F, 10.5F, -5F, 3, 1, 3);
        this.leftfootlower.setRotationPoint(2.5F, 12F, 0F);
        this.leftfootlower.setTextureSize(64, 32);
        this.setRotation(leftfootlower, 0.0872665F, 0.0872665F, 0.0349066F);

        this.convertToChild(head, hair);
        this.convertToChild(head, headnose);
        this.convertToChild(head, headnoseshadow);
        this.convertToChild(head, rightear);
        this.convertToChild(head, leftear);
        this.convertToChild(rightarm, rightarmlower);
        this.convertToChild(rightarm, righthand);
        this.convertToChild(leftarm, leftarmlower);
        this.convertToChild(leftarm, lefthand);
        this.convertToChild(rightleg, rightleglower);
        this.convertToChild(rightleg, rightfootlower);
        this.convertToChild(leftleg, leftleglower);
        this.convertToChild(leftleg, leftfootlower);
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
        // this.hair.render(scale);
        // this.headnose.render(scale);
        // this.headnoseshadow.render(scale);
        // this.rightear.render(scale);
        // this.leftear.render(scale);
        // this.rightarmlower.render(scale);
        // this.leftarmlower.render(scale);
        // this.righthand.render(scale);
        // this.lefthand.render(scale);
        this.backpack.render(scale);
        this.waist.render(scale);
        this.tail1.render(scale);
        this.tail2.render(scale);
        // this.rightleglower.render(scale);
        // this.leftleglower.render(scale);
        // this.rightfootlower.render(scale);
        // this.leftfootlower.render(scale);

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

        ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
        EntityGaiaKobold entity = (EntityGaiaKobold) entityIn;

        if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
            holdingBow(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        } else if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // body
        this.tail1.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(15);
        this.tail2.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(20);

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
        this.rightleg.rotateAngleX -= 0.3490659F;
        this.leftleg.rotateAngleX -= 0.3490659F;
    }

    public void holdingBow(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
            Entity entityIn) {
        float f = MathHelper.sin(this.swingProgress * (float) Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float) Math.PI);

        this.rightarm.rotateAngleZ = -0.3F;
        this.leftarm.rotateAngleZ = 0.3F;
        this.rightarm.rotateAngleY = -(0.1F - f * 0.6F);
        this.leftarm.rotateAngleY = 0.3F - f * 0.6F;
        this.rightarm.rotateAngleX = -((float) Math.PI / 2F);
        this.leftarm.rotateAngleX = -((float) Math.PI / 2F);
        this.rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
        this.leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
        this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
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
