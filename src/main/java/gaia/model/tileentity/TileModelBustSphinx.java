package gaia.model.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileModelBustSphinx extends ModelBase implements IModelBust {
	private ModelRenderer head;
	private ModelRenderer headaccessory;
	private ModelRenderer rightear;
	private ModelRenderer lefttear;
	private ModelRenderer hair01;
	private ModelRenderer hair02;
	private ModelRenderer crown;
	private ModelRenderer body;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer stand1;
	private ModelRenderer stand2;
	private ModelRenderer stand3;

	public TileModelBustSphinx() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -9F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 17F, 0F);
		setRotation(head, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -9.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 17F, 0F);
		setRotation(headaccessory, 0F, 0F, 0F);
		rightear = new ModelRenderer(this, 36, 14);
		rightear.addBox(-4.5F, -13F, -1.5F, 3, 4, 3);
		rightear.setRotationPoint(0F, 17F, 0F);
		setRotation(rightear, 0F, 0F, 0F);
		lefttear = new ModelRenderer(this, 48, 14);
		lefttear.addBox(1.5F, -13F, -1.5F, 3, 4, 3);
		lefttear.setRotationPoint(0F, 17F, 0F);
		setRotation(lefttear, 0F, 0F, 0F);
		hair01 = new ModelRenderer(this, 36, 21);
		hair01.addBox(-4F, -6.5F, -2F, 8, 3, 6);
		hair01.setRotationPoint(0F, 17F, 0F);
		setRotation(hair01, 0F, 0F, 0F);
		hair02 = new ModelRenderer(this, 36, 30);
		hair02.addBox(-4.5F, -3.5F, -1.5F, 9, 6, 6);
		hair02.setRotationPoint(0F, 17F, 0F);
		setRotation(hair02, 0F, 0F, 0F);
		crown = new ModelRenderer(this, 36, 42);
		crown.addBox(-1F, -11F, -4.6F, 2, 3, 1);
		crown.setRotationPoint(0F, 17F, 0F);
		setRotation(crown, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 12);
		body.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		body.setRotationPoint(0F, 14F, 0F);
		setRotation(body, 0.0872665F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 21);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 16F, -1.5F);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 8, 21);
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 16F, -1.5F);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 4, 2);
		rightarm.setRotationPoint(-2.5F, 15.5F, 0F);
		setRotation(rightarm, 0.0872665F, 0F, 0.0872665F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 4, 2);
		leftarm.setRotationPoint(2.5F, 15.5F, 0F);
		setRotation(leftarm, 0.0872665F, 0F, -0.0872665F);
		stand1 = new ModelRenderer(this, 0, 25);
		stand1.addBox(-1.5F, 6F, -1.5F, 3, 1, 3);
		stand1.setRotationPoint(0F, 14F, 0F);
		setRotation(stand1, 0F, 0F, 0F);
		stand2 = new ModelRenderer(this, 0, 29);
		stand2.addBox(-1F, 7F, -1F, 2, 2, 2);
		stand2.setRotationPoint(0F, 14F, 0F);
		setRotation(stand2, 0F, 0F, 0F);
		stand3 = new ModelRenderer(this, 0, 33);
		stand3.addBox(-2F, 9F, -2F, 4, 1, 4);
		stand3.setRotationPoint(0F, 14F, 0F);
		setRotation(stand3, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		head.render(scale);
		headaccessory.render(scale);
		rightear.render(scale);
		lefttear.render(scale);
		hair01.render(scale);
		hair02.render(scale);
		crown.render(scale);
		body.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		stand1.render(scale);
		stand2.render(scale);
		stand3.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void renderModel(float scale) {
		head.render(scale);
		headaccessory.render(scale);
		rightear.render(scale);
		lefttear.render(scale);
		hair01.render(scale);
		hair02.render(scale);
		crown.render(scale);
		body.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		stand1.render(scale);
		stand2.render(scale);
		stand3.render(scale);
	}
}
