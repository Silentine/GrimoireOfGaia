package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TileModelBustVampire extends ModelBase {

    ModelRenderer head;
    ModelRenderer headaccessory;
    ModelRenderer headflower;
    ModelRenderer headleaves;
    ModelRenderer earright;
    ModelRenderer earleft;
    ModelRenderer body;
    ModelRenderer rightchest;
    ModelRenderer leftchest;
    ModelRenderer chestribbon;
    ModelRenderer rightshoulder;
    ModelRenderer rightarm;
    ModelRenderer leftshoulder;
    ModelRenderer leftarm;
    ModelRenderer stand1;
    ModelRenderer stand2;
    ModelRenderer stand3;

    public TileModelBustVampire() {
        this.textureWidth = 128;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-3F, -9F, -3F, 6, 6, 6);
        this.head.setRotationPoint(0F, 17F, 0F);
        this.head.setTextureSize(64, 32);
        this.setRotation(head, 0F, 0F, 0F);
        this.headaccessory = new ModelRenderer(this, 36, 0);
        this.headaccessory.addBox(-3.5F, -9.5F, -3.5F, 7, 7, 7);
        this.headaccessory.setRotationPoint(0F, 17F, 0F);
        this.headaccessory.setTextureSize(64, 32);
        this.setRotation(headaccessory, 0F, 0F, 0F);
        this.headflower = new ModelRenderer(this, 36, 20);
        this.headflower.addBox(-6F, -10F, -1F, 2, 1, 2);
        this.headflower.setRotationPoint(0F, 18F, 0F);
        this.headflower.setTextureSize(64, 32);
        this.setRotation(headflower, 0F, 0F, 0.7853982F);
        this.headleaves = new ModelRenderer(this, 36, 23);
        this.headleaves.addBox(-7F, -9F, -1.5F, 4, 0, 3);
        this.headleaves.setRotationPoint(0F, 18F, 0F);
        this.headleaves.setTextureSize(64, 32);
        this.setRotation(headleaves, 0F, 0F, 0.7853982F);
        this.earright = new ModelRenderer(this, 36, 14);
        this.earright.addBox(-3.5F, -7F, -1.5F, 0, 2, 4);
        this.earright.setRotationPoint(0F, 17F, 0F);
        this.earright.setTextureSize(64, 32);
        this.setRotation(earright, 0F, -0.2617994F, 0F);
        this.earleft = new ModelRenderer(this, 44, 14);
        this.earleft.addBox(3.5F, -7F, -1.5F, 0, 2, 4);
        this.earleft.setRotationPoint(0F, 17F, 0F);
        this.earleft.setTextureSize(64, 32);
        this.setRotation(earleft, 0F, 0.2617994F, 0F);
        this.body = new ModelRenderer(this, 0, 12);
        this.body.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
        this.body.setRotationPoint(0F, 14F, 0F);
        this.body.setTextureSize(64, 32);
        this.setRotation(body, 0F, 0F, 0F);
        this.rightchest = new ModelRenderer(this, 0, 21);
        this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.rightchest.setRotationPoint(-1.3F, 16F, -1.5F);
        this.rightchest.setTextureSize(64, 32);
        this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
        this.leftchest = new ModelRenderer(this, 8, 21);
        this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
        this.leftchest.setRotationPoint(1.3F, 16F, -1.5F);
        this.leftchest.setTextureSize(64, 32);
        this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
        this.chestribbon = new ModelRenderer(this, 36, 26);
        this.chestribbon.addBox(-1.5F, -1.1F, -2F, 3, 0, 3);
        this.chestribbon.setRotationPoint(0F, 16F, -1.5F);
        this.chestribbon.setTextureSize(64, 32);
        this.setRotation(chestribbon, 0.7853982F, 0F, 0F);
        this.rightshoulder = new ModelRenderer(this, 64, 0);
        this.rightshoulder.addBox(-3F, -1F, -2F, 4, 4, 4);
        this.rightshoulder.setRotationPoint(-2.5F, 15.5F, 0F);
        this.rightshoulder.setTextureSize(64, 32);
        this.setRotation(rightshoulder, 0.0872665F, 0F, 0.0872665F);
        this.rightarm = new ModelRenderer(this, 16, 12);
        this.rightarm.addBox(-2F, -1F, -1F, 2, 4, 2);
        this.rightarm.setRotationPoint(-2.5F, 15.5F, 0F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0.0872665F, 0F, -0.0872665F);
        this.leftshoulder = new ModelRenderer(this, 80, 0);
        this.leftshoulder.addBox(-1F, -1F, -2F, 4, 4, 4);
        this.leftshoulder.setRotationPoint(2.5F, 15.5F, 0F);
        this.leftshoulder.setTextureSize(64, 32);
        this.setRotation(leftshoulder, 0.0872665F, 0F, -0.0872665F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 4, 2);
        this.leftarm.setRotationPoint(2.5F, 15.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0.0872665F, 0F, 0.0872665F);
        this.stand1 = new ModelRenderer(this, 0, 25);
        this.stand1.addBox(-1.5F, 6F, -1.5F, 3, 1, 3);
        this.stand1.setRotationPoint(0F, 14F, 0F);
        this.stand1.setTextureSize(64, 32);
        this.setRotation(stand1, 0F, 0F, 0F);
        this.stand2 = new ModelRenderer(this, 0, 29);
        this.stand2.addBox(-1F, 7F, -1F, 2, 2, 2);
        this.stand2.setRotationPoint(0F, 14F, 0F);
        this.stand2.setTextureSize(64, 32);
        this.setRotation(stand2, 0F, 0F, 0F);
        this.stand3 = new ModelRenderer(this, 0, 33);
        this.stand3.addBox(-2F, 9F, -2F, 4, 1, 4);
        this.stand3.setRotationPoint(0F, 14F, 0F);
        this.stand3.setTextureSize(64, 32);
        this.setRotation(stand3, 0F, 0F, 0F);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.head.render(scale);
        this.headaccessory.render(scale);
        this.headflower.render(scale);
        this.headleaves.render(scale);
        this.earright.render(scale);
        this.earleft.render(scale);
        this.body.render(scale);
        this.rightchest.render(scale);
        this.leftchest.render(scale);
        this.chestribbon.render(scale);
        this.rightshoulder.render(scale);
        this.rightarm.render(scale);
        this.leftshoulder.render(scale);
        this.leftarm.render(scale);
        this.stand1.render(scale);
        this.stand2.render(scale);
        this.stand3.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void renderModel(float scale) {
        this.head.render(scale);
        this.headaccessory.render(scale);
        this.headflower.render(scale);
        this.headleaves.render(scale);
        this.earright.render(scale);
        this.earleft.render(scale);
        this.body.render(scale);
        this.rightchest.render(scale);
        this.leftchest.render(scale);
        this.chestribbon.render(scale);
        this.rightshoulder.render(scale);
        this.rightarm.render(scale);
        this.leftshoulder.render(scale);
        this.leftarm.render(scale);
        this.stand1.render(scale);
        this.stand2.render(scale);
        this.stand3.render(scale);
    }
}
