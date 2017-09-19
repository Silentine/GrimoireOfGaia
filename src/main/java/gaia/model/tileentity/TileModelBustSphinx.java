package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TileModelBustSphinx extends ModelBase {

    ModelRenderer head;
    ModelRenderer headaccessory;
    ModelRenderer rightear;
    ModelRenderer lefttear;
    ModelRenderer hair01;
    ModelRenderer hair02;
    ModelRenderer crown;
    ModelRenderer body;
    ModelRenderer rightchest;
    ModelRenderer leftchest;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer stand1;
    ModelRenderer stand2;
    ModelRenderer stand3;

    public TileModelBustSphinx() {
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
        this.rightear = new ModelRenderer(this, 36, 14);
        this.rightear.addBox(-4.5F, -13F, -1.5F, 3, 4, 3);
        this.rightear.setRotationPoint(0F, 17F, 0F);
        this.rightear.setTextureSize(64, 32);
        this.setRotation(rightear, 0F, 0F, 0F);
        this.lefttear = new ModelRenderer(this, 48, 14);
        this.lefttear.addBox(1.5F, -13F, -1.5F, 3, 4, 3);
        this.lefttear.setRotationPoint(0F, 17F, 0F);
        this.lefttear.setTextureSize(64, 32);
        this.setRotation(lefttear, 0F, 0F, 0F);
        this.hair01 = new ModelRenderer(this, 36, 21);
        this.hair01.addBox(-4F, -6.5F, -2F, 8, 3, 6);
        this.hair01.setRotationPoint(0F, 17F, 0F);
        this.hair01.setTextureSize(64, 32);
        this.setRotation(hair01, 0F, 0F, 0F);
        this.hair02 = new ModelRenderer(this, 36, 30);
        this.hair02.addBox(-4.5F, -3.5F, -1.5F, 9, 6, 6);
        this.hair02.setRotationPoint(0F, 17F, 0F);
        this.hair02.setTextureSize(64, 32);
        this.setRotation(hair02, 0F, 0F, 0F);
        this.crown = new ModelRenderer(this, 36, 42);
        this.crown.addBox(-1F, -11F, -4.6F, 2, 3, 1);
        this.crown.setRotationPoint(0F, 17F, 0F);
        this.crown.setTextureSize(64, 32);
        this.setRotation(crown, 0F, 0F, 0F);
        this.body = new ModelRenderer(this, 0, 12);
        this.body.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
        this.body.setRotationPoint(0F, 14F, 0F);
        this.body.setTextureSize(64, 32);
        this.setRotation(body, 0.0872665F, 0F, 0F);
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
        this.rightarm = new ModelRenderer(this, 16, 12);
        this.rightarm.addBox(-2F, -1F, -1F, 2, 4, 2);
        this.rightarm.setRotationPoint(-2.5F, 15.5F, 0F);
        this.rightarm.setTextureSize(64, 32);
        this.setRotation(rightarm, 0.0872665F, 0F, 0.0872665F);
        this.leftarm = new ModelRenderer(this, 16, 12);
        this.leftarm.addBox(0F, -1F, -1F, 2, 4, 2);
        this.leftarm.setRotationPoint(2.5F, 15.5F, 0F);
        this.leftarm.setTextureSize(64, 32);
        this.setRotation(leftarm, 0.0872665F, 0F, -0.0872665F);
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

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.head.render(scale);
        this.headaccessory.render(scale);
        this.rightear.render(scale);
        this.lefttear.render(scale);
        this.hair01.render(scale);
        this.hair02.render(scale);
        this.crown.render(scale);
        this.body.render(scale);
        this.rightchest.render(scale);
        this.leftchest.render(scale);
        this.rightarm.render(scale);
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
        this.rightear.render(scale);
        this.lefttear.render(scale);
        this.hair01.render(scale);
        this.hair02.render(scale);
        this.crown.render(scale);
        this.body.render(scale);
        this.rightchest.render(scale);
        this.leftchest.render(scale);
        this.rightarm.render(scale);
        this.leftarm.render(scale);
        this.stand1.render(scale);
        this.stand2.render(scale);
        this.stand3.render(scale);
    }
}
