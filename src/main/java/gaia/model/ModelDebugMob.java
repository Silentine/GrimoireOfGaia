package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDebugMob extends ModelGaia {

    ModelRenderer head;
    ModelRenderer headeyes;
    ModelRenderer headaccessory;
    ModelRenderer neck;
    ModelRenderer bodytop;
    ModelRenderer bodymiddle;
    ModelRenderer bodymiddlebutton;
    ModelRenderer bodybottom;
    public static ModelRenderer rightarm;
    public static ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer headleaf;
    ModelRenderer hair;
    ModelRenderer ears;
    ModelRenderer backpack;
    ModelRenderer bodycover;
    ModelRenderer rightarmcloth;
    ModelRenderer leftarmcloth;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer rightlegcloth;
    ModelRenderer rightlegclothlower;
    ModelRenderer leftlegcloth;
    ModelRenderer leftlegclothlower;

    public ModelDebugMob() {
        textureWidth = 128;
        textureHeight = 64;

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
        this.headaccessory.addBox(-3.5F, -7F, -3.5F, 7, 7, 7);
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
        this.setRotation(rightleg, 0F, 0F, 0F);
        this.leftleg = new ModelRenderer(this, 24, 12);
        this.leftleg.mirror = true;
        this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.leftleg.setRotationPoint(2F, 11F, 0F);
        this.leftleg.setTextureSize(128, 64);
        this.setRotation(leftleg, 0F, 0F, 0F);
        this.headleaf = new ModelRenderer(this, 36, 30);
        this.headleaf.addBox(-2.5F, -7.5F, -4F, 5, 5, 5);
        this.headleaf.setRotationPoint(0F, 1F, 0F);
        this.headleaf.setTextureSize(128, 64);
        this.setRotation(headleaf, 0F, 0F, 0F);
        this.hair = new ModelRenderer(this, 36, 19);
        this.hair.addBox(-4.5F, -5F, -2.5F, 9, 6, 5);
        this.hair.setRotationPoint(0F, 1F, 0F);
        this.hair.setTextureSize(128, 64);
        this.setRotation(hair, 0F, 0F, 0F);
        this.ears = new ModelRenderer(this, 36, 14);
        this.ears.addBox(-5.5F, -8F, 0.5F, 11, 4, 1);
        this.ears.setRotationPoint(0F, 0F, 0F);
        this.ears.setTextureSize(128, 64);
        this.setRotation(ears, 0F, 0F, 0F);
        this.backpack = new ModelRenderer(this, 64, 10);
        this.backpack.addBox(-3F, 0F, 2F, 6, 6, 6);
        this.backpack.setRotationPoint(0F, 1F, 0F);
        this.backpack.setTextureSize(128, 64);
        this.setRotation(backpack, -0.122173F, 0F, 0F);
        this.bodycover = new ModelRenderer(this, 64, 0);
        this.bodycover.addBox(-2.5F, 3F, -1.6F, 5, 10, 0);
        this.bodycover.setRotationPoint(0F, 1F, 0F);
        this.bodycover.setTextureSize(128, 64);
        this.setRotation(bodycover, -0.0872665F, 0F, 0F);
        this.rightarmcloth = new ModelRenderer(this, 88, 0);
        this.rightarmcloth.addBox(-2.5F, 1F, -1.5F, 3, 8, 3);
        this.rightarmcloth.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarmcloth.setTextureSize(128, 64);
        this.setRotation(rightarmcloth, 0F, 0F, 0.1745329F);
        this.leftarmcloth = new ModelRenderer(this, 88, 0);
        this.leftarmcloth.mirror = true;
        this.leftarmcloth.addBox(-0.5F, 1F, -1.5F, 3, 8, 3);
        this.leftarmcloth.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarmcloth.setTextureSize(128, 64);
        this.setRotation(leftarmcloth, 0F, 0F, -0.1745329F);
        this.tail1 = new ModelRenderer(this, 88, 11);
        this.tail1.addBox(-2F, -2F, 0F, 4, 4, 4);
        this.tail1.setRotationPoint(0F, 11F, 2F);
        this.tail1.setTextureSize(128, 64);
        this.setRotation(tail1, 0F, 0F, 0F);
        this.tail2 = new ModelRenderer(this, 88, 19);
        this.tail2.addBox(-1.5F, -0.5F, 4F, 3, 3, 2);
        this.tail2.setRotationPoint(0F, 11F, 2F);
        this.tail2.setTextureSize(128, 64);
        this.setRotation(tail2, 0F, 0F, 0F);
        this.tail3 = new ModelRenderer(this, 88, 24);
        this.tail3.addBox(-1F, 1F, 6F, 2, 2, 1);
        this.tail3.setRotationPoint(0F, 11F, 2F);
        this.tail3.setTextureSize(128, 64);
        this.setRotation(tail3, 0F, 0F, 0F);
        this.rightlegcloth = new ModelRenderer(this, 104, 0);
        this.rightlegcloth.addBox(-2F, 0F, -2F, 4, 10, 4);
        this.rightlegcloth.setRotationPoint(-2F, 11F, 0F);
        this.rightlegcloth.setTextureSize(128, 64);
        this.setRotation(rightlegcloth, 0F, 0F, 0F);
        this.rightlegclothlower = new ModelRenderer(this, 104, 14);
        this.rightlegclothlower.addBox(-2.5F, 3F, -2.5F, 5, 6, 5);
        this.rightlegclothlower.setRotationPoint(-2F, 11F, 0F);
        this.rightlegclothlower.setTextureSize(128, 64);
        this.setRotation(rightlegclothlower, 0F, 0F, 0F);
        this.leftlegcloth = new ModelRenderer(this, 104, 0);
        this.leftlegcloth.mirror = true;
        this.leftlegcloth.addBox(-2F, 0F, -2F, 4, 10, 4);
        this.leftlegcloth.setRotationPoint(2F, 11F, 0F);
        this.leftlegcloth.setTextureSize(128, 64);
        this.setRotation(leftlegcloth, 0F, 0F, 0F);
        this.leftlegclothlower = new ModelRenderer(this, 104, 14);
        this.leftlegclothlower.mirror = true;
        this.leftlegclothlower.addBox(-2.5F, 3F, -2.5F, 5, 6, 5);
        this.leftlegclothlower.setRotationPoint(2F, 11F, 0F);
        this.leftlegclothlower.setTextureSize(128, 64);
        this.setRotation(leftlegclothlower, 0F, 0F, 0F);

        this.convertToChild(head, hair);
        this.convertToChild(head, ears);
        this.convertToChild(rightarm, rightarmcloth);
        this.convertToChild(leftarm, leftarmcloth);
        this.convertToChild(bodytop, backpack);
        this.convertToChild(bodytop, bodycover);
        this.convertToChild(tail1, tail2);
        this.convertToChild(tail1, tail3);
        this.convertToChild(rightleg, rightlegcloth);
        this.convertToChild(rightleg, rightlegclothlower);
        this.convertToChild(leftleg, leftlegcloth);
        this.convertToChild(leftleg, leftlegclothlower);
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
        this.rightarm.render(scale);
        this.leftarm.render(scale);
        this.rightleg.render(scale);
        this.leftleg.render(scale);
        // this.headleaf.render(scale);
        // this.hair.render(scale);
        // this.ears.render(scale);
        // this.backpack.render(scale);
        // this.bodycover.render(scale);
        // this.rightarmcloth.render(scale);
        // this.leftarmcloth.render(scale);
        this.tail1.render(scale);
        // this.tail2.render(scale);
        // this.tail3.render(scale);
        // this.rightlegcloth.render(scale);
        // this.rightlegclothlower.render(scale);
        // this.leftlegcloth.render(scale);
        // this.leftlegclothlower.render(scale);

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
        this.headeyes.rotateAngleY = this.head.rotateAngleY;
        this.headaccessory.rotateAngleY = this.head.rotateAngleY;
        this.headaccessory.rotateAngleX = this.head.rotateAngleX;

        if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
            headTilt(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

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
        this.tail1.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(2);
        this.tail2.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(4);
        this.tail3.rotateAngleY = MathHelper.cos(degToRad(entityIn.ticksExisted * 7)) * degToRad(6);

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.1F * limbSwingAmount;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.1F * limbSwingAmount;
    }

    /*
     * TODO Create a method to display death animations
     * @see ModelEnderman
     * @see RenderEnderman
     * @see EntityEnderman
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float p_78086_2_, float p_78086_3_, float partialTickTime) {
        super.setLivingAnimations(entitylivingbaseIn, p_78086_2_, p_78086_3_, partialTickTime);
        //boolean onDeath = ((EntityGaiaAnubis)entitylivingbaseIn).onDeath(partialTickTime);

        EntityExampleMob entity = (EntityExampleMob)entitylivingbaseIn;

        if (entity.onDeath = true) {
            this.headeyes.showModel = true;
        } else {
            this.headeyes.showModel = false;
        }

        if (entity.onDeath = true) {
            this.rightarm.rotateAngleX -= 0.7853981F;
            this.leftarm.rotateAngleX -= 0.7853981F;
            this.rightleg.rotateAngleX -= 0.7853981F;
            this.leftarm.rotateAngleX -= 0.7853981F;
        } 
    }
     */

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

    public void headTilt(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
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

        this.head.rotateAngleZ = (float) ((double) this.head.rotateAngleZ - ((double) f7 * 1.2D + (double) f8));
        this.head.rotateAngleZ += (this.bodytop.rotateAngleY * 2.0F);
        this.head.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F);
    }
}
