package gaia.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaMandragora extends ModelGaia {

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
    ModelRenderer headleaf1;
    ModelRenderer headleaf2;
    ModelRenderer headleaf3;
    ModelRenderer headleaf4;
    ModelRenderer headleafs1;
    ModelRenderer headleafs2;
    ModelRenderer headleafs3;
    ModelRenderer headleafs4;
    ModelRenderer headflower1;
    ModelRenderer headflower2;
    ModelRenderer headhairright;
    ModelRenderer headhairleft;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer waist;

    protected float scaleAmountHead = 0.75F;
    protected float scaleAmountBody = 0.5F;
    //Increasing the value moves it closer to the ground
    protected float YOffsetHead = 15.5F;
    protected float YOffsetBody = 23.5F;

    public ModelGaiaMandragora() {
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
        rightarm = new ModelRenderer(this, 16, 12);
        rightarm.addBox(-2F, -1F, -1F, 2, 12, 2);
        rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
        rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0.0349066F, 0F, 0.0872665F);
        leftarm = new ModelRenderer(this, 16, 12);
        leftarm.addBox(0F, -1F, -1F, 2, 12, 2);
        leftarm.setRotationPoint(2.5F, 2.5F, 0F);
        leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0.0349066F, 0F, -0.0872665F);
        this.rightleg = new ModelRenderer(this, 24, 12);
        this.rightleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.rightleg.setRotationPoint(-2F, 11F, 0F);
        this.rightleg.setTextureSize(64, 32);
        this.setRotation(rightleg, 0.0349066F, 0F, -0.0349066F);
        this.leftleg = new ModelRenderer(this, 24, 12);
        this.leftleg.addBox(-1.5F, -1F, -1.5F, 3, 14, 3);
        this.leftleg.setRotationPoint(2F, 11F, 0F);
        this.leftleg.setTextureSize(64, 32);
        this.setRotation(leftleg, 0.0349066F, 0F, 0.0349066F);
        this.headflower1 = new ModelRenderer(this, 36, 28);
        this.headflower1.addBox(-3F, -12.5F, 0F, 6, 6, 0);
        this.headflower1.setRotationPoint(0F, 1F, 0F);
        this.headflower1.setTextureSize(64, 32);
        this.setRotation(headflower1, 0F, -0.7853982F, 0F);
        this.headflower2 = new ModelRenderer(this, 36, 28);
        this.headflower2.addBox(-3F, -12.5F, 0F, 6, 6, 0);
        this.headflower2.setRotationPoint(0F, 1F, 0F);
        this.headflower2.setTextureSize(64, 32);
        this.setRotation(headflower2, 0F, 0.7853982F, 0F);
        this.headhairright = new ModelRenderer(this, 36, 34);
        this.headhairright.addBox(-4.5F, -2F, 0.5F, 4, 14, 4);
        this.headhairright.setRotationPoint(0F, 1F, 0F);
        this.headhairright.setTextureSize(64, 32);
        this.setRotation(headhairright, 0.0436332F, 0F, 0.0436332F);
        this.headhairleft = new ModelRenderer(this, 36, 34);
        this.headhairleft.addBox(0.5F, -2F, 0.5F, 4, 14, 4);
        this.headhairleft.setRotationPoint(0F, 1F, 0F);
        this.headhairleft.setTextureSize(64, 32);
        this.setRotation(headhairleft, 0.0436332F, 0F, -0.0436332F);
        this.waist = new ModelRenderer(this, 36, 52);
        this.waist.addBox(-3.5F, 8.5F, -3F, 7, 5, 4);
        this.waist.setRotationPoint(0F, 1F, 0F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.0872665F, 0F, 0F);
        this.headleaf1 = new ModelRenderer(this, 36, 14);
        this.headleaf1.addBox(-3F, -10F, -6F, 6, 8, 0);
        this.headleaf1.setRotationPoint(0F, 1F, 0F);
        this.headleaf1.setTextureSize(64, 32);
        this.setRotation(headleaf1, -1.308997F, -0.7853982F, 0F);
        this.headleaf2 = new ModelRenderer(this, 36, 14);
        this.headleaf2.addBox(-3F, -10F, -6F, 6, 8, 0);
        this.headleaf2.setRotationPoint(0F, 1F, 0F);
        this.headleaf2.setTextureSize(64, 32);
        this.setRotation(headleaf2, -1.308997F, 0.7853982F, 0F);
        this.headleaf3 = new ModelRenderer(this, 36, 14);
        this.headleaf3.addBox(-3F, -10F, -6F, 6, 8, 0);
        this.headleaf3.setRotationPoint(0F, 1F, 0F);
        this.headleaf3.setTextureSize(64, 32);
        this.setRotation(headleaf3, -1.308997F, 2.356194F, 0F);
        this.headleaf4 = new ModelRenderer(this, 36, 14);
        this.headleaf4.addBox(-3F, -10F, -6F, 6, 8, 0);
        this.headleaf4.setRotationPoint(0F, 1F, 0F);
        this.headleaf4.setTextureSize(64, 32);
        this.setRotation(headleaf4, -1.308997F, -2.356194F, 0F);
        this.headleafs1 = new ModelRenderer(this, 36, 22);
        this.headleafs1.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
        this.headleafs1.setRotationPoint(0F, 1F, 0F);
        this.headleafs1.setTextureSize(64, 32);
        this.setRotation(headleafs1, -1.047198F, 0F, 0F);
        this.headleafs2 = new ModelRenderer(this, 36, 22);
        this.headleafs2.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
        this.headleafs2.setRotationPoint(0F, 1F, 0F);
        this.headleafs2.setTextureSize(64, 32);
        this.setRotation(headleafs2, -1.047198F, 1.570796F, 0F);
        this.headleafs3 = new ModelRenderer(this, 36, 22);
        this.headleafs3.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
        this.headleafs3.setRotationPoint(0F, 1F, 0F);
        this.headleafs3.setTextureSize(64, 32);
        this.setRotation(headleafs3, -1.047198F, 3.141593F, 0F);
        this.headleafs4 = new ModelRenderer(this, 36, 22);
        this.headleafs4.addBox(-2F, -9.5F, -5.5F, 4, 6, 0);
        this.headleafs4.setRotationPoint(0F, 1F, 0F);
        this.headleafs4.setTextureSize(64, 32);
        this.setRotation(headleafs4, -1.047198F, -1.570796F, 0F);
        this.headflower1 = new ModelRenderer(this, 36, 28);
        this.headflower1.addBox(-3F, -12.5F, 0F, 6, 6, 0);
        this.headflower1.setRotationPoint(0F, 1F, 0F);
        this.headflower1.setTextureSize(64, 32);
        this.setRotation(headflower1, 0F, -0.7853982F, 0F);
        this.headflower2 = new ModelRenderer(this, 36, 28);
        this.headflower2.addBox(-3F, -12.5F, 0F, 6, 6, 0);
        this.headflower2.setRotationPoint(0F, 1F, 0F);
        this.headflower2.setTextureSize(64, 32);
        this.setRotation(headflower2, 0F, 0.7853982F, 0F);
        this.headhairright = new ModelRenderer(this, 36, 34);
        this.headhairright.addBox(-4.5F, -2F, 0.5F, 4, 14, 4);
        this.headhairright.setRotationPoint(0F, 1F, 0F);
        this.headhairright.setTextureSize(64, 32);
        this.setRotation(headhairright, 0.0436332F, 0F, 0.0436332F);
        this.headhairleft = new ModelRenderer(this, 36, 34);
        this.headhairleft.addBox(0.5F, -2F, 0.5F, 4, 14, 4);
        this.headhairleft.setRotationPoint(0F, 1F, 0F);
        this.headhairleft.setTextureSize(64, 32);
        this.setRotation(headhairleft, 0.0436332F, 0F, -0.0436332F);
        this.rightear = new ModelRenderer(this, 36, 48);
        this.rightear.addBox(-4F, -4F, -1F, 0, 2, 4);
        this.rightear.setRotationPoint(0F, 1F, 0F);
        this.rightear.setTextureSize(64, 32);
        this.setRotation(rightear, 0F, -0.5235988F, 0F);
        this.leftear = new ModelRenderer(this, 36, 48);
        this.leftear.mirror = true;
        this.leftear.addBox(4F, -4F, -1F, 0, 2, 4);
        this.leftear.setRotationPoint(0F, 1F, 0F);
        this.leftear.setTextureSize(64, 32);
        this.setRotation(leftear, 0F, 0.5235988F, 0F);
        this.waist = new ModelRenderer(this, 64, 0);
        this.waist.addBox(-3.5F, 8.5F, -3F, 7, 5, 4);
        this.waist.setRotationPoint(0F, 1F, 0F);
        this.waist.setTextureSize(64, 32);
        this.setRotation(waist, 0.0872665F, 0F, 0F);

        this.convertToChild(head, headflower1);
        this.convertToChild(head, headflower2);
        this.convertToChild(head, headhairright);
        this.convertToChild(head, headhairleft);
        this.convertToChild(head, rightear);
        this.convertToChild(head, leftear);
        this.convertToChild(head, headleaf1);
        this.convertToChild(head, headleaf2);
        this.convertToChild(head, headleaf3);
        this.convertToChild(head, headleaf4);
        this.convertToChild(head, headleafs1);
        this.convertToChild(head, headleafs2);
        this.convertToChild(head, headleafs3);
        this.convertToChild(head, headleafs4);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        ItemStack itemstack = ((EntityLivingBase)entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST);

        if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
            this.head.render(scale);
            this.headaccessory.render(scale);
            this.neck.render(scale);
            this.bodytop.render(scale);
            this.bodymiddle.render(scale);
            this.bodymiddlebutton.render(scale);
            this.bodybottom.render(scale);
            rightarm.render(scale);
            leftarm.render(scale);
            this.rightleg.render(scale);
            this.leftleg.render(scale);
            this.waist.render(scale);

            if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
                this.headeyes.render(scale);
            }
        } else {
            float f = 2.0F;
            // ================= Scaling =================//
            GlStateManager.pushMatrix();
            GlStateManager.scale(scaleAmountHead, scaleAmountHead, scaleAmountHead);
            GlStateManager.translate(0.0F, this.YOffsetHead * scale, 0.0F);
            this.head.render(scale);

            if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
                this.headeyes.render(scale);
            }

            this.headaccessory.render(scale);
            GlStateManager.popMatrix();
            // ===========================================//
            GlStateManager.pushMatrix();
            GlStateManager.scale(scaleAmountBody, scaleAmountBody, scaleAmountBody);
            GlStateManager.translate(0.0F, this.YOffsetBody * scale, 0.0F);
            this.neck.render(scale);
            this.bodytop.render(scale);
            this.bodymiddle.render(scale);
            this.bodymiddlebutton.render(scale);
            this.bodybottom.render(scale);
            rightarm.render(scale);
            leftarm.render(scale);
            this.rightleg.render(scale);
            this.leftleg.render(scale);
            this.waist.render(scale);
            GlStateManager.popMatrix();
            // ===========================================//
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
        rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
        leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

        rightarm.rotateAngleZ = 0.0F;
        leftarm.rotateAngleZ = 0.0F;

        if (this.swingProgress > -9990.0F) {
            holdingMelee(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        }

        rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
        leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
        leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

        // legs
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
        this.rightleg.rotateAngleX += 0.0349066F;
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
        this.leftleg.rotateAngleX += 0.0349066F;
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

        rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
        rightarm.rotateAngleX += (this.bodytop.rotateAngleY * 2.0F);
        rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F);
    }
}
