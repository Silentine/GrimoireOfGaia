package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSuccubus extends ModelGaia {

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
    ModelRenderer righthorn1;
    ModelRenderer righthorn2;
    ModelRenderer righthorn3;
    ModelRenderer righthorn4;
    ModelRenderer lefthorn1;
    ModelRenderer lefthorn2;
    ModelRenderer lefthorn3;
    ModelRenderer lefthorn4;
    ModelRenderer rightpauldron;
    ModelRenderer leftpauldron;
    ModelRenderer rightarmlower;
    ModelRenderer leftarmlower;
    ModelRenderer tail;
    ModelRenderer waist;
    ModelRenderer rightleglower;
    ModelRenderer leftleglower;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;
    ModelRenderer rightwing;
    ModelRenderer leftwing;

    public ModelGaiaSuccubus() {
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
        this.bodybottom.addBox(-3F, 7F, -2.5F, 6, 3, 3);
        this.bodybottom.setRotationPoint(0F, 2F, 0F);
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
        this.setRotation(rightarm, 0.0872665F, 0F, 0.1745329F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0.0872665F, 0F, -0.1745329F);
        this.rightleg = new ModelRenderer(this, 24, 12);
        this.rightleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
        this.rightleg.setRotationPoint(-2F, 11F, -0.5F);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(rightleg, -0.1745329F, 0F, 0F);
        this.leftleg = new ModelRenderer(this, 24, 12);
        this.leftleg.addBox(-1.5F, -1F, -1F, 3, 7, 3);
        this.leftleg.setRotationPoint(2F, 11F, -0.5F);
        this.leftleg.setTextureSize(64, 32);
        this.setRotation(leftleg, -0.1745329F, 0F, 0F);
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
        this.righthorn1 = new ModelRenderer(this, 36, 37);
        this.righthorn1.addBox(-4F, -7F, -2F, 2, 2, 2);
        this.righthorn1.setRotationPoint(0F, 1F, 0F);
        this.righthorn1.setTextureSize(64, 32);
        this.setRotation(righthorn1, 0F, 0F, 0F);
        this.righthorn2 = new ModelRenderer(this, 36, 41);
        this.righthorn2.addBox(-5F, -6F, -4F, 2, 2, 3);
        this.righthorn2.setRotationPoint(0F, 1F, 0F);
        this.righthorn2.setTextureSize(64, 32);
        this.setRotation(righthorn2, 0F, 0F, 0F);
        this.righthorn3 = new ModelRenderer(this, 36, 46);
        this.righthorn3.addBox(-4F, -7F, -5F, 2, 2, 2);
        this.righthorn3.setRotationPoint(0F, 1F, 0F);
        this.righthorn3.setTextureSize(64, 32);
        this.setRotation(righthorn3, 0F, 0F, 0F);
        this.righthorn4 = new ModelRenderer(this, 36, 50);
        this.righthorn4.addBox(-2.5F, -7.5F, -4.5F, 1, 1, 1);
        this.righthorn4.setRotationPoint(0F, 1F, 0F);
        this.righthorn4.setTextureSize(64, 32);
        this.setRotation(righthorn4, 0F, 0F, 0F);
        this.lefthorn1 = new ModelRenderer(this, 36, 37);
        this.lefthorn1.mirror = true;
        this.lefthorn1.addBox(2F, -7F, -2F, 2, 2, 2);
        this.lefthorn1.setRotationPoint(0F, 1F, 0F);
        this.lefthorn1.setTextureSize(64, 32);
        this.setRotation(lefthorn1, 0F, 0F, 0F);
        this.lefthorn2 = new ModelRenderer(this, 36, 41);
        this.lefthorn2.mirror = true;
        this.lefthorn2.addBox(3F, -6F, -4F, 2, 2, 3);
        this.lefthorn2.setRotationPoint(0F, 1F, 0F);
        this.lefthorn2.setTextureSize(64, 32);
        this.setRotation(lefthorn2, 0F, 0F, 0F);
        this.lefthorn3 = new ModelRenderer(this, 36, 46);
        this.lefthorn3.mirror = true;
        this.lefthorn3.addBox(2F, -7F, -5F, 2, 2, 2);
        this.lefthorn3.setRotationPoint(0F, 1F, 0F);
        this.lefthorn3.setTextureSize(64, 32);
        this.setRotation(lefthorn3, 0F, 0F, 0F);
        this.lefthorn4 = new ModelRenderer(this, 36, 50);
        this.lefthorn4.mirror = true;
        this.lefthorn4.addBox(1.5F, -7.5F, -4.5F, 1, 1, 1);
        this.lefthorn4.setRotationPoint(0F, 1F, 0F);
        this.lefthorn4.setTextureSize(64, 32);
        this.setRotation(lefthorn4, 0F, 0F, 0F);
        this.rightpauldron = new ModelRenderer(this, 64, 0);
        this.rightpauldron.addBox(-2.5F, -2F, -1.5F, 3, 3, 3);
        this.rightpauldron.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightpauldron.setTextureSize(64, 32);
        this.setRotation(rightpauldron, 0.0872665F, 0F, 0.1745329F);
        this.leftpauldron = new ModelRenderer(this, 76, 0);
        this.leftpauldron.addBox(-0.5F, -2F, -1.5F, 3, 3, 3);
        this.leftpauldron.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftpauldron.setTextureSize(64, 32);
        this.setRotation(leftpauldron, 0.0872665F, 0F, -0.1745329F);
        this.rightarmlower = new ModelRenderer(this, 64, 6);
        this.rightarmlower.addBox(-4F, 5F, -1.5F, 2, 6, 3);
        this.rightarmlower.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarmlower.setTextureSize(64, 32);
        this.setRotation(rightarmlower, 0.0872665F, 0F, 0F);
        this.leftarmlower = new ModelRenderer(this, 74, 6);
        this.leftarmlower.addBox(2F, 5F, -1.5F, 2, 6, 3);
        this.leftarmlower.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmlower.setTextureSize(64, 32);
        this.setRotation(leftarmlower, 0.0872665F, 0F, 0F);
        this.tail = new ModelRenderer(this, 64, 15);
        this.tail.addBox(-1F, 0F, 0F, 2, 9, 0);
        this.tail.setRotationPoint(0F, 9F, 1.5F);
        this.tail.setTextureSize(64, 32);
        this.setRotation(tail, 0.3490659F, 0F, 0F);
        this.waist = new ModelRenderer(this, 64, 24);
        this.waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
        this.waist.setRotationPoint(0F, 1F, 0F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.0872665F, 0F, 0F);
        this.rightleglower = new ModelRenderer(this, 88, 0);
        this.rightleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
        this.rightleglower.setRotationPoint(-2F, 11F, -0.5F);
        this.rightleglower.setTextureSize(64, 32);
        this.setRotation(rightleglower, -0.1745329F, 0F, 0F);
        this.leftleglower = new ModelRenderer(this, 88, 0);
        this.leftleglower.addBox(-2F, 4F, 0F, 4, 8, 4);
        this.leftleglower.setRotationPoint(2F, 11F, -0.5F);
        this.leftleglower.setTextureSize(64, 32);
        this.setRotation(leftleglower, -0.1745329F, 0F, 0F);
        this.rightfoot = new ModelRenderer(this, 88, 12);
        this.rightfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
        this.rightfoot.setRotationPoint(-2F, 11F, -0.5F);
        this.rightfoot.setTextureSize(64, 32);
        this.setRotation(rightfoot, 0F, 0F, 0F);
        this.leftfoot = new ModelRenderer(this, 88, 12);
        this.leftfoot.addBox(-2F, 11F, -3F, 4, 2, 4);
        this.leftfoot.setRotationPoint(2F, 11F, -0.5F);
        this.leftfoot.setTextureSize(64, 32);
        this.setRotation(leftfoot, 0F, 0F, 0F);
        this.rightwing = new ModelRenderer(this, 104, 42);
        this.rightwing.addBox(0F, -1F, 0F, 0, 14, 8);
        this.rightwing.setRotationPoint(-1.5F, 2F, 2F);
        this.rightwing.setTextureSize(64, 32);
        this.setRotation(rightwing, 0.5235988F, -0.7853982F, 0F);
        this.leftwing = new ModelRenderer(this, 112, 42);
        this.leftwing.addBox(0F, -1F, 0F, 0, 14, 8);
        this.leftwing.setRotationPoint(1.5F, 2F, 2F);
        this.leftwing.setTextureSize(64, 32);
        this.setRotation(leftwing, 0.5235988F, 0.7853982F, 0F);

        this.convertToChild(head, righthorn1);
        this.convertToChild(head, righthorn2);
        this.convertToChild(head, righthorn3);
        this.convertToChild(head, righthorn4);
        this.convertToChild(head, lefthorn1);
        this.convertToChild(head, lefthorn2);
        this.convertToChild(head, lefthorn3);
        this.convertToChild(head, lefthorn4);
        this.convertToChild(rightarm, rightpauldron);
        this.convertToChild(rightarm, rightarmlower);
        this.convertToChild(leftarm, leftpauldron);
        this.convertToChild(leftarm, leftarmlower);
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
        this.hair1.render(scale);
        this.hair2.render(scale);
        // this.rightpauldron.render(scale);
        // this.leftpauldron.render(scale);
        // this.rightarmlower.render(scale);
        // this.leftarmlower.render(scale);
        this.tail.render(scale);
        this.waist.render(scale);
        // this.rightleglower.render(scale);
        // this.leftleglower.render(scale);
        // this.rightfoot.render(scale);
        // this.leftfoot.render(scale);
        this.rightwing.render(scale);
        this.leftwing.render(scale);

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

        if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // body
        this.rightwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F + (float) Math.PI) * 1.0F * limbSwingAmount * 0.5F;
        this.leftwing.rotateAngleY = MathHelper.cos(ageInTicks * 0.3F) * 1.0F * limbSwingAmount * 0.5F;
        --this.rightwing.rotateAngleY;
        ++this.leftwing.rotateAngleY;
        this.tail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;

        this.rightchest.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount) + 0.7853982F;
        this.leftchest.rotateAngleX = this.rightchest.rotateAngleX;

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount;
        this.rightleg.rotateAngleX -= 0.1745329F;
        this.leftleg.rotateAngleX -= 0.1745329F;
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
