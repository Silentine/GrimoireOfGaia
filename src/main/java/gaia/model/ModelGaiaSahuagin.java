package gaia.model;

import gaia.entity.monster.EntityGaiaSahuagin;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSahuagin extends ModelGaia {

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
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer rightarmlower1;
    ModelRenderer leftarmlower1;
    ModelRenderer rightarmlower2;
    ModelRenderer leftarmlower2;
    ModelRenderer righthand;
    ModelRenderer lefthand;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer waist;
    ModelRenderer rightleglower1;
    ModelRenderer leftleglower1;
    ModelRenderer rightleglower2;
    ModelRenderer leftleglower2;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;

    public ModelGaiaSahuagin() {
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
        this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
        this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0F, 0F, 0.2617994F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0F, 0F, -0.2617994F);
        this.rightleg = new ModelRenderer(this, 24, 12);
        this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.rightleg.setRotationPoint(-2F, 11F, 0F);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(rightleg, 0F, 0F, 0F);
        this.leftleg = new ModelRenderer(this, 24, 29);
        this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.leftleg.setRotationPoint(2F, 11F, 0F);
        this.leftleg.setTextureSize(64, 32);
        this.setRotation(leftleg, 0F, 0F, 0F);
        this.hair1 = new ModelRenderer(this, 36, 14);
        this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
        this.hair1.setRotationPoint(0F, 1F, 0F);
        this.hair1.setTextureSize(64, 32);
        this.setRotation(hair1, 0F, 0F, 0F);
        this.hair2 = new ModelRenderer(this, 36, 25);
        this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
        this.hair2.setRotationPoint(0F, 1F, 0F);
        this.hair2.setTextureSize(64, 32);
        this.setRotation(hair2, 0F, 0F, 0F);
        this.rightear = new ModelRenderer(this, 36, 32);
        this.rightear.addBox(-4F, -6F, -1F, 0, 5, 5);
        this.rightear.setRotationPoint(0F, 1F, 0F);
        this.rightear.setTextureSize(64, 32);
        this.setRotation(rightear, 0F, -0.5235988F, 0F);
        this.leftear = new ModelRenderer(this, 36, 32);
        this.leftear.addBox(4F, -6F, -1F, 0, 5, 5);
        this.leftear.setRotationPoint(0F, 1F, 0F);
        this.leftear.setTextureSize(64, 32);
        this.setRotation(leftear, 0F, 0.5235988F, 0F);
        this.rightarmlower1 = new ModelRenderer(this, 64, 0);
        this.rightarmlower1.addBox(-4F, 2.5F, 0F, 2, 6, 0);
        this.rightarmlower1.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarmlower1.setTextureSize(64, 32);
        this.setRotation(rightarmlower1, 0F, 0F, 0.2617994F);
        this.leftarmlower1 = new ModelRenderer(this, 68, 0);
        this.leftarmlower1.addBox(2F, 2.5F, 0F, 2, 6, 0);
        this.leftarmlower1.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmlower1.setTextureSize(64, 32);
        this.setRotation(leftarmlower1, 0F, 0F, -0.2617994F);
        this.rightarmlower2 = new ModelRenderer(this, 64, 6);
        this.rightarmlower2.addBox(-2.5F, 4F, -1.5F, 2, 6, 3);
        this.rightarmlower2.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarmlower2.setTextureSize(64, 32);
        this.setRotation(rightarmlower2, 0F, 0F, 0.2617994F);
        this.leftarmlower2 = new ModelRenderer(this, 74, 6);
        this.leftarmlower2.addBox(0.5F, 4F, -1.5F, 2, 6, 3);
        this.leftarmlower2.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmlower2.setTextureSize(64, 32);
        this.setRotation(leftarmlower2, 0F, 0F, -0.2617994F);
        this.righthand = new ModelRenderer(this, 64, 15);
        this.righthand.addBox(-2.5F, 8.5F, -2F, 2, 4, 4);
        this.righthand.setRotationPoint(-2.5F, 2.5F, 0F);
        this.righthand.setTextureSize(64, 32);
        this.setRotation(righthand, 0F, 0F, 0.1745329F);
        this.lefthand = new ModelRenderer(this, 76, 15);
        this.lefthand.addBox(0.5F, 8.5F, -2F, 2, 4, 4);
        this.lefthand.setRotationPoint(2.5F, 2.5F, 0F);
        this.lefthand.setTextureSize(64, 32);
        this.setRotation(lefthand, 0F, 0F, -0.1745329F);
        this.tail1 = new ModelRenderer(this, 64, 31);
        this.tail1.addBox(-1.5F, -1.5F, 0F, 3, 5, 3);
        this.tail1.setRotationPoint(0F, 9F, 1F);
        this.tail1.setTextureSize(64, 32);
        this.setRotation(tail1, 0.1745329F, 0F, 0F);
        this.tail2 = new ModelRenderer(this, 64, 39);
        this.tail2.addBox(-1F, 3.5F, 0.5F, 2, 5, 2);
        this.tail2.setRotationPoint(0F, 9F, 1F);
        this.tail2.setTextureSize(64, 32);
        this.setRotation(tail2, 0.2617994F, 0F, 0F);
        this.tail3 = new ModelRenderer(this, 64, 46);
        this.tail3.addBox(-0.5F, 8.5F, 0.5F, 1, 4, 1);
        this.tail3.setRotationPoint(0F, 9F, 1F);
        this.tail3.setTextureSize(64, 32);
        this.setRotation(tail3, 0.3490659F, 0F, 0F);
        this.waist = new ModelRenderer(this, 64, 23);
        this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
        this.waist.setRotationPoint(0F, 1F, 0F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.0872665F, 0F, 0F);
        this.rightleglower1 = new ModelRenderer(this, 88, 0);
        this.rightleglower1.addBox(-3.5F, 5F, 0F, 2, 6, 0);
        this.rightleglower1.setRotationPoint(-2F, 11F, 0F);
        this.rightleglower1.setTextureSize(64, 32);
        this.setRotation(rightleglower1, 0F, 0F, 0F);
        this.leftleglower1 = new ModelRenderer(this, 92, 0);
        this.leftleglower1.addBox(1.5F, 5F, 0F, 2, 6, 0);
        this.leftleglower1.setRotationPoint(2F, 11F, 0F);
        this.leftleglower1.setTextureSize(64, 32);
        this.setRotation(leftleglower1, 0F, 0F, 0F);
        this.rightleglower2 = new ModelRenderer(this, 88, 6);
        this.rightleglower2.addBox(-2F, 10F, -2F, 4, 2, 4);
        this.rightleglower2.setRotationPoint(-2F, 11F, 0F);
        this.rightleglower2.setTextureSize(64, 32);
        this.setRotation(rightleglower2, 0F, 0F, 0F);
        this.leftleglower2 = new ModelRenderer(this, 88, 6);
        this.leftleglower2.addBox(-2F, 10F, -2F, 4, 2, 4);
        this.leftleglower2.setRotationPoint(2F, 11F, 0F);
        this.leftleglower2.setTextureSize(64, 32);
        this.setRotation(leftleglower2, 0F, 0F, 0F);
        this.rightfoot = new ModelRenderer(this, 88, 12);
        this.rightfoot.addBox(-2F, 12F, -3.5F, 4, 1, 4);
        this.rightfoot.setRotationPoint(-2F, 11F, 0F);
        this.rightfoot.setTextureSize(64, 32);
        this.setRotation(rightfoot, 0F, 0F, 0F);
        this.leftfoot = new ModelRenderer(this, 88, 12);
        this.leftfoot.addBox(-2F, 12F, -3.5F, 4, 1, 4);
        this.leftfoot.setRotationPoint(2F, 11F, 0F);
        this.leftfoot.setTextureSize(64, 32);
        this.setRotation(leftfoot, 0F, 0F, 0F);

        this.convertToChild(head, rightear);
        this.convertToChild(head, leftear);
        this.convertToChild(rightarm, rightarmlower1);
        this.convertToChild(rightarm, rightarmlower2);
        this.convertToChild(rightarm, righthand);
        this.convertToChild(leftarm, leftarmlower1);
        this.convertToChild(leftarm, leftarmlower2);
        this.convertToChild(leftarm, lefthand);
        this.convertToChild(rightleg, rightleglower1);
        this.convertToChild(rightleg, rightleglower2);
        this.convertToChild(rightleg, rightfoot);
        this.convertToChild(leftleg, leftleglower1);
        this.convertToChild(leftleg, leftleglower2);
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
        this.hair1.render(scale);
        this.hair2.render(scale);
        // this.rightear.render(scale);
        // this.leftear.render(scale);
        // this.rightarmlower1.render(scale);
        // this.leftarmlower1.render(scale);
        // this.rightarmlower2.render(scale);
        // this.leftarmlower2.render(scale);
        // this.righthand.render(scale);
        // this.lefthand.render(scale);
        this.tail1.render(scale);
        this.tail2.render(scale);
        this.tail3.render(scale);
        this.waist.render(scale);
        // this.rightleglower1.render(scale);
        // this.leftleglower1.render(scale);
        // this.rightleglower2.render(scale);
        // this.leftleglower2.render(scale);
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
        this.hair1.rotateAngleY = this.head.rotateAngleY;
        this.hair2.rotateAngleY = (this.head.rotateAngleY) * 0.75F;

        // arms
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;

        float f6;
        float f7;
        ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
        EntityGaiaSahuagin entity = (EntityGaiaSahuagin) entityIn;

        if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
            holdingBow(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        } else if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // body
        this.tail1.rotateAngleZ = MathHelper.cos(limbSwing * 0.6162F) * 0.1F * limbSwingAmount;
        this.tail2.rotateAngleZ = MathHelper.cos(limbSwing * 0.6262F) * 0.1F * limbSwingAmount;
        this.tail3.rotateAngleZ = MathHelper.cos(limbSwing * 0.6362F) * 0.1F * limbSwingAmount;

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
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
