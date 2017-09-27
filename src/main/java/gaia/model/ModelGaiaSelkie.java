package gaia.model;

import gaia.entity.monster.EntityGaiaSelkie;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSelkie extends ModelGaia {

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
    ModelRenderer hair1;
    ModelRenderer hair2;
    ModelRenderer hat1;
    ModelRenderer hat2;
    ModelRenderer righthatear;
    ModelRenderer lefthatear;
    ModelRenderer chestpiece;
    ModelRenderer waist;
    ModelRenderer zip;
    ModelRenderer fin1;
    ModelRenderer fin2;
    ModelRenderer fin3;
    ModelRenderer fin4;
    ModelRenderer fintail;

    protected double distanceMovedTotal = 0.0D;
    protected static final double CYCLES_PER_BLOCK = 1.0D;
    protected int cycleIndex = 0;
    protected float[][] undulationCycle = new float[][]
            {
            {  -5F, -10F, -15F, -20F, -25F, -30F },
            {  -5F,  -7F,  -9F, -11F, -13F, -15F },
            {   0F,   0F,   0F,   0F,   0F,   0F },
            {   5F,  10F,  15F,  20F,  25F,  30F },
            {   5F,   7F,   9F,  11F,  13F,  15F },
            {   0F,   0F,   0F,   0F,   0F,   0F },
    };

    public ModelGaiaSelkie() {
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
        this.rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
        this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0F, 0F, 0.1745329F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0F, 0F, -0.1745329F);
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
        this.hat1 = new ModelRenderer(this, 64, 0);
        this.hat1.addBox(-4F, -7.5F, -5F, 8, 3, 8);
        this.hat1.setRotationPoint(0F, 1F, 0F);
        this.hat1.setTextureSize(64, 32);
        this.setRotation(hat1, -0.1745329F, 0F, 0F);
        this.hat2 = new ModelRenderer(this, 64, 11);
        this.hat2.addBox(-3F, -8.5F, -4F, 6, 1, 6);
        this.hat2.setRotationPoint(0F, 1F, 0F);
        this.hat2.setTextureSize(64, 32);
        this.setRotation(hat2, -0.1745329F, 0F, 0F);
        this.righthatear = new ModelRenderer(this, 64, 10);
        this.righthatear.addBox(-5F, -6F, -4F, 0, 18, 8);
        this.righthatear.setRotationPoint(0F, 1F, 0F);
        this.righthatear.setTextureSize(64, 32);
        this.setRotation(righthatear, 0F, 0F, 0.1745329F);
        this.lefthatear = new ModelRenderer(this, 64, 10);
        this.lefthatear.addBox(5F, -6F, -4F, 0, 18, 8);
        this.lefthatear.setRotationPoint(0F, 1F, 0F);
        this.lefthatear.setTextureSize(64, 32);
        this.setRotation(lefthatear, 0F, 0F, -0.1745329F);
        this.chestpiece = new ModelRenderer(this, 64, 36);
        this.chestpiece.addBox(-4F, -2F, -1F, 8, 6, 2);
        this.chestpiece.setRotationPoint(0F, 1F, 0F);
        this.chestpiece.setTextureSize(64, 32);
        this.setRotation(chestpiece, -0.7853982F, 0F, 0F);
        this.waist = new ModelRenderer(this, 96, 0);
        this.waist.addBox(-4F, 7.5F, -3F, 8, 3, 4);
        this.waist.setRotationPoint(0F, 1F, 0F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.0872665F, undulationCycle[0][0], 0F);
        this.zip = new ModelRenderer(this, 96, 7);
        this.zip.addBox(-1F, 0F, -3.5F, 2, 3, 1);
        this.zip.setRotationPoint(0F, 11F, 0F);
        this.zip.setTextureSize(64, 32);
        this.setRotation(zip, -0.6108652F, 0, 0F);
        this.fin1 = new ModelRenderer(this, 96, 11);
        this.fin1.addBox(-3.5F, -1F, -3F, 7, 6, 6);
        this.fin1.setRotationPoint(0F, 11F, 0F);
        this.fin1.setTextureSize(64, 32);
        this.setRotation(fin1, -0.2617994F, undulationCycle[0][1], 0F);
        this.fin2 = new ModelRenderer(this, 96, 23);
        this.fin2.addBox(-3F, 4F, -3.5F, 6, 5, 5);
        this.fin2.setRotationPoint(0F, 11F, 0F);
        this.fin2.setTextureSize(64, 32);
        this.setRotation(fin2, -0.0872665F, undulationCycle[0][2], 0F);
        this.fin3 = new ModelRenderer(this, 96, 33);
        this.fin3.addBox(-2.5F, 7F, -6F, 5, 4, 4);
        this.fin3.setRotationPoint(0F, 11F, 0F);
        this.fin3.setTextureSize(64, 32);
        this.setRotation(fin3, 0.2617994F, undulationCycle[0][3], 0F);
        this.fin4 = new ModelRenderer(this, 96, 41);
        this.fin4.addBox(-2F, 8F, -9F, 4, 3, 3);
        this.fin4.setRotationPoint(0F, 11F, 0F);
        this.fin4.setTextureSize(64, 32);
        this.setRotation(fin4, 0.6108652F, undulationCycle[0][4], 0F);
        this.fintail = new ModelRenderer(this, 96, 47);
        this.fintail.addBox(-4F, 12F, 1F, 8, 1, 4);
        this.fintail.setRotationPoint(0F, 11F, 0F);
        this.fintail.setTextureSize(64, 32);
        this.setRotation(fintail, -0.0872665F, undulationCycle[0][5], 0F);

        this.convertToChild(head, hat1);
        this.convertToChild(head, hat2);
        this.convertToChild(waist, zip);
        this.convertToChild(waist, fin1);
        this.convertToChild(waist, fin2);
        this.convertToChild(waist, fin3);
        this.convertToChild(waist, fin4);
        this.convertToChild(waist, fintail);
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
        this.hair1.render(scale);
        this.hair2.render(scale);
        // this.hat1.render(scale);
        // this.hat2.render(scale);
        this.righthatear.render(scale);
        this.lefthatear.render(scale);
        this.chestpiece.render(scale);
        this.waist.render(scale);
        // this.zip.render(scale);
        // this.fin1.render(scale);
        // this.fin2.render(scale);
        // this.fin3.render(scale);
        // this.fin4.render(scale);
        // this.fintail.render(scale);

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
        this.righthatear.rotateAngleY = this.head.rotateAngleY;
        this.lefthatear.rotateAngleY = this.head.rotateAngleY;
        this.hair1.rotateAngleY = this.head.rotateAngleY;
        this.hair2.rotateAngleY = (this.head.rotateAngleY) * 0.75F;

        // arms
        this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;

        ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
        EntityGaiaSelkie entity = (EntityGaiaSelkie) entityIn;

        if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
            holdingBow(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        } else if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // legs
        updateDistanceMovedTotal(entityIn);
        cycleIndex = (int) ((getDistanceMovedTotal(entityIn) * CYCLES_PER_BLOCK) % undulationCycle.length);

        waist.rotateAngleY = degToRad(undulationCycle[cycleIndex][0]);
        fin1.rotateAngleY = degToRad(undulationCycle[cycleIndex][1]);
        fin2.rotateAngleY = degToRad(undulationCycle[cycleIndex][2]);
        fin3.rotateAngleY = degToRad(undulationCycle[cycleIndex][3]);
        fin4.rotateAngleY = degToRad(undulationCycle[cycleIndex][4]);
        fintail.rotateAngleY = degToRad(undulationCycle[cycleIndex][5]);
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
