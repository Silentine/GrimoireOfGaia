package gaia.model;

import gaia.entity.monster.EntityGaiaSiren;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSiren extends ModelGaia {

    ModelRenderer head;
    ModelRenderer headeyes;
    ModelRenderer headaccessory;
    ModelRenderer neck;
    ModelRenderer bodytop;
    ModelRenderer bodymid;
    ModelRenderer bodymidbutton;
    ModelRenderer bodybottom;
    ModelRenderer rightchest;
    ModelRenderer leftchest;
    public static ModelRenderer rightarm;
    public static ModelRenderer leftarm;
    ModelRenderer hair1;
    ModelRenderer hair2;
    ModelRenderer finright;
    ModelRenderer finleft;
    ModelRenderer mantle;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer tail6;
    ModelRenderer tail7;
    ModelRenderer tail8;

    protected double distanceMovedTotal = 0.0D;
    protected static final double CYCLES_PER_BLOCK = 1.0D;
    protected int cycleIndex = 0;
    protected float[][] undulationCycle = new float[][]
            {
            {  10F, -10F, -10F,   0F,  10F,  10F,   0F, -10F },
            {   5F,  10F, -10F, -10F,   0F,  10F,  10F,   0F },
            {   0F,  25F,   0F, -10F, -10F,   0F,  10F,  10F },
            { -10F,  10F,  10F,   0F, -10F, -10F,   0F,  10F },
            {  -5F, -10F,  10F,  10F,   0F, -10F, -10F,   0F },
            {   0F, -25F,   0F,  10F,  10F,   0F, -10F, -10F },
    };

    public ModelGaiaSiren() {
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
        this.headeyes.setTextureSize(128, 64);
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
        this.bodymid = new ModelRenderer(this, 0, 25);
        this.bodymid.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
        this.bodymid.setRotationPoint(0F, 1F, 0F);
        this.bodymid.setTextureSize(128, 64);
        this.setRotation(bodymid, 0F, 0F, 0F);
        this.bodymidbutton = new ModelRenderer(this, 0, 25);
        this.bodymidbutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
        this.bodymidbutton.setRotationPoint(0F, 1F, 0F);
        this.bodymidbutton.setTextureSize(128, 64);
        this.setRotation(bodymidbutton, 0F, 0F, 0F);
        this.bodybottom = new ModelRenderer(this, 0, 30);
        this.bodybottom.addBox(-3F, 8F, -2F, 6, 3, 3);
        this.bodybottom.setRotationPoint(0F, 1F, 0F);
        this.bodybottom.setTextureSize(128, 64);
        this.setRotation(bodybottom, 0F, 0F, 0F);
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
        this.setRotation(rightarm, 0F, 0F, 0.2617994F);
        this.leftarm = new ModelRenderer(this, 16, 36);
        this.leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
        this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        this.leftarm.setTextureSize(128, 64);
        this.setRotation(leftarm, 0F, 0F, -0.2617994F);
        this.hair1 = new ModelRenderer(this, 36, 14);
        this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
        this.hair1.setRotationPoint(0F, 1F, 0F);
        this.hair1.setTextureSize(128, 64);
        this.setRotation(hair1, 0F, 0F, 0F);
        this.hair2 = new ModelRenderer(this, 36, 25);
        this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
        this.hair2.setRotationPoint(0F, 1F, 0F);
        this.hair2.setTextureSize(128, 64);
        this.setRotation(hair2, 0F, 0F, 0F);
        this.finright = new ModelRenderer(this, 36, 32);
        this.finright.addBox(-4F, -6F, -1F, 0, 5, 5);
        this.finright.setRotationPoint(0F, 1F, 0F);
        this.finright.setTextureSize(128, 64);
        this.setRotation(finright, 0F, -0.5235988F, 0F);
        this.finleft = new ModelRenderer(this, 36, 32);
        this.finleft.addBox(4F, -6F, -1F, 0, 5, 5);
        this.finleft.setRotationPoint(0F, 1F, 0F);
        this.finleft.setTextureSize(128, 64);
        this.setRotation(finleft, 0F, 0.5235988F, 0F);
        this.mantle = new ModelRenderer(this, 36, 42);
        this.mantle.addBox(-4.5F, 0F, -2F, 9, 5, 4);
        this.mantle.setRotationPoint(0F, 1F, 0F);
        this.mantle.setTextureSize(128, 64);
        this.setRotation(mantle, -0.0872665F, 0F, 0F);
        this.tail1 = new ModelRenderer(this, 64, 0);
        this.tail1.addBox(-3.5F, -1F, -2.5F, 7, 4, 4);
        this.tail1.setRotationPoint(0F, 11F, 0F);
        this.tail1.setTextureSize(128, 64);
        this.setRotation(tail1, 0F, undulationCycle[0][0], 0F);
        this.tail2 = new ModelRenderer(this, 64, 8);
        this.tail2.addBox(-3F, 2F, -2.5F, 6, 4, 3);
        this.tail2.setRotationPoint(0F, 11F, 0F);
        this.tail2.setTextureSize(128, 64);
        this.setRotation(tail2, 0.0872665F, undulationCycle[0][1], 0F);
        this.tail3 = new ModelRenderer(this, 64, 15);
        this.tail3.addBox(-2.5F, 5F, -2F, 5, 4, 3);
        this.tail3.setRotationPoint(0F, 11F, 0F);
        this.tail3.setTextureSize(128, 64);
        this.setRotation(tail3, 0.1308997F, undulationCycle[0][2], 0F);
        this.tail4 = new ModelRenderer(this, 64, 22);
        this.tail4.addBox(-2.5F, 7F, -1F, 5, 3, 4);
        this.tail4.setRotationPoint(0F, 11F, 0F);
        this.tail4.setTextureSize(128, 64);
        this.setRotation(tail4, 0.1308997F, undulationCycle[0][3], 0F);
        this.tail5 = new ModelRenderer(this, 64, 29);
        this.tail5.addBox(-2F, 9F, 0F, 4, 3, 5);
        this.tail5.setRotationPoint(0F, 11F, 0F);
        this.tail5.setTextureSize(128, 64);
        this.setRotation(tail5, 0.1308997F, undulationCycle[0][4], 0F);
        this.tail6 = new ModelRenderer(this, 64, 37);
        this.tail6.addBox(-2F, 10F, 3F, 4, 3, 4);
        this.tail6.setRotationPoint(0F, 11F, 0F);
        this.tail6.setTextureSize(128, 64);
        this.setRotation(tail6, 0.1308997F, undulationCycle[0][5], 0F);
        this.tail7 = new ModelRenderer(this, 64, 44);
        this.tail7.addBox(-1.5F, 10.5F, 6.5F, 3, 2, 3);
        this.tail7.setRotationPoint(0F, 11F, 0F);
        this.tail7.setTextureSize(128, 64);
        this.setRotation(tail7, 0.1745329F, undulationCycle[0][6], 0F);
        this.tail8 = new ModelRenderer(this, 64, 49);
        this.tail8.addBox(-1F, 11F, 9F, 2, 1, 2);
        this.tail8.setRotationPoint(0F, 11F, 0F);
        this.tail8.setTextureSize(128, 64);
        this.setRotation(tail8, 0.2181662F, undulationCycle[0][7], 0F);

        this.convertToChild(head, finright);
        this.convertToChild(head, finleft);
        this.convertToChild(tail1, tail2);
        this.convertToChild(tail1, tail3);
        this.convertToChild(tail1, tail4);
        this.convertToChild(tail1, tail5);
        this.convertToChild(tail1, tail6);
        this.convertToChild(tail1, tail7);
        this.convertToChild(tail1, tail8);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.head.render(scale);
        this.headaccessory.render(scale);
        this.neck.render(scale);
        this.bodytop.render(scale);
        this.bodymid.render(scale);
        this.bodymidbutton.render(scale);
        this.bodybottom.render(scale);
        this.rightchest.render(scale);
        this.leftchest.render(scale);
        this.rightarm.render(scale);
        this.leftarm.render(scale);
        this.hair1.render(scale);
        this.hair2.render(scale);
        // this.finright.render(scale);
        // this.finleft.render(scale);
        this.mantle.render(scale);
        this.tail1.render(scale);
        // this.tail2.render(scale);
        // this.tail3.render(scale);
        // this.tail4.render(scale);
        // this.tail5.render(scale);
        // this.tail6.render(scale);
        // this.tail7.render(scale);
        // this.tail8.render(scale);

        if (entityIn.ticksExisted % 60 == 0 && ageInTicks <= 0.1F) {
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

        ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
        EntityGaiaSiren entity = (EntityGaiaSiren) entityIn;

        if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
            HoldingBow(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        } else if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        this.rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        this.leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.2617994F;
        this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // legs
        updateDistanceMovedTotal(entityIn);
        cycleIndex = (int) ((getDistanceMovedTotal(entityIn) * CYCLES_PER_BLOCK) % undulationCycle.length);

        tail1.rotateAngleY = degToRad(undulationCycle[cycleIndex][0]);
        tail2.rotateAngleY = degToRad(undulationCycle[cycleIndex][1]);
        tail3.rotateAngleY = degToRad(undulationCycle[cycleIndex][2]);
        tail4.rotateAngleY = degToRad(undulationCycle[cycleIndex][3]);
        tail5.rotateAngleY = degToRad(undulationCycle[cycleIndex][4]);
        tail6.rotateAngleY = degToRad(undulationCycle[cycleIndex][5]);
        tail7.rotateAngleY = degToRad(undulationCycle[cycleIndex][6]);
        tail8.rotateAngleY = degToRad(undulationCycle[cycleIndex][7]);
    }

    public void HoldingBow(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
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
