package gaia.client.model.tileentity;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileModelDoll extends Model implements IModelBust {
	private RendererModel head;
	private RendererModel headaccessory;
	private RendererModel hair;
	private RendererModel upperbody;
	private RendererModel lowerbody;
	private RendererModel rightchest;
	private RendererModel leftchest;
	private RendererModel rightarm;
	private RendererModel leftarm;
	private RendererModel waist;
	private RendererModel rightleg;
	private RendererModel leftleg;

	public TileModelDoll() {
		textureWidth = 64;
		textureHeight = 32;

		head = new RendererModel(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 15F, 2F);
		head.setTextureSize(64, 32);
		setRotation(head, 0.0872665F, 0F, 0F);
		headaccessory = new RendererModel(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 15F, 2F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0.0872665F, 0F, 0F);
		hair = new RendererModel(this, 36, 14);
		hair.addBox(-3.5F, -4F, 0.5F, 7, 9, 3);
		hair.setRotationPoint(0F, 15F, 2F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0.0872665F, 0F, 0F);
		upperbody = new RendererModel(this, 0, 12);
		upperbody.addBox(-2.5F, -4F, -1.5F, 5, 4, 3);
		upperbody.setRotationPoint(0F, 19F, 2F);
		upperbody.setTextureSize(64, 32);
		setRotation(upperbody, 0F, 0F, 0F);
		lowerbody = new RendererModel(this, 0, 19);
		lowerbody.addBox(-2.5F, 0F, -1.5F, 5, 4, 3);
		lowerbody.setRotationPoint(0F, 19F, 2F);
		lowerbody.setTextureSize(64, 32);
		setRotation(lowerbody, -0.1745329F, 0F, 0F);
		rightchest = new RendererModel(this, 0, 26);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 17F, 0.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new RendererModel(this, 8, 26);
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 17F, 0.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		rightarm = new RendererModel(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 7, 2);
		rightarm.setRotationPoint(-2.5F, 16.5F, 2F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new RendererModel(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 7, 2);
		leftarm.setRotationPoint(2.5F, 16.5F, 2F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		waist = new RendererModel(this, 36, 26);
		waist.addBox(-3F, 4F, -2F, 6, 2, 4);
		waist.setRotationPoint(0F, 18F, 2F);
		waist.setTextureSize(64, 32);
		setRotation(waist, -0.1745329F, 0F, 0F);
		rightleg = new RendererModel(this, 24, 12);
		rightleg.addBox(-1F, 0F, -1F, 2, 7, 2);
		rightleg.setRotationPoint(-1.5F, 23F, 2F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -1.570796F, 0.1745329F, 0F);
		leftleg = new RendererModel(this, 24, 12);
		leftleg.addBox(-1F, 0F, -1F, 2, 7, 2);
		leftleg.setRotationPoint(1.5F, 23F, 2F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -1.570796F, -0.1745329F, 0F);
	}

	private void setRotation(RendererModel model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void renderModel(float scale) {
		head.render(scale);
		headaccessory.render(scale);
		hair.render(scale);
		upperbody.render(scale);
		lowerbody.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		waist.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
	}
}
