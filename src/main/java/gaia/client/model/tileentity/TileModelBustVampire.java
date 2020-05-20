package gaia.client.model.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TileModelBustVampire extends Model implements IModelBust {
	private ModelRenderer head;
	private ModelRenderer headaccessory;
	private ModelRenderer headflower;
	private ModelRenderer headleaves;
	private ModelRenderer earright;
	private ModelRenderer earleft;
	private ModelRenderer body;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer chestribbon;
	private ModelRenderer rightshoulder;
	private ModelRenderer rightarm;
	private ModelRenderer leftshoulder;
	private ModelRenderer leftarm;
	private ModelRenderer stand1;
	private ModelRenderer stand2;
	private ModelRenderer stand3;

	public TileModelBustVampire() {
		super(RenderType::getEntityCutoutNoCull);
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -9F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 17F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -9.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 17F, 0F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		headflower = new ModelRenderer(this, 36, 20);
		headflower.addBox(-6F, -10F, -1F, 2, 1, 2);
		headflower.setRotationPoint(0F, 18F, 0F);
		headflower.setTextureSize(64, 32);
		setRotation(headflower, 0F, 0F, 0.7853982F);
		headleaves = new ModelRenderer(this, 36, 23);
		headleaves.addBox(-7F, -9F, -1.5F, 4, 0, 3);
		headleaves.setRotationPoint(0F, 18F, 0F);
		headleaves.setTextureSize(64, 32);
		setRotation(headleaves, 0F, 0F, 0.7853982F);
		earright = new ModelRenderer(this, 36, 14);
		earright.addBox(-3.5F, -7F, -1.5F, 0, 2, 4);
		earright.setRotationPoint(0F, 17F, 0F);
		earright.setTextureSize(64, 32);
		setRotation(earright, 0F, -0.2617994F, 0F);
		earleft = new ModelRenderer(this, 44, 14);
		earleft.addBox(3.5F, -7F, -1.5F, 0, 2, 4);
		earleft.setRotationPoint(0F, 17F, 0F);
		earleft.setTextureSize(64, 32);
		setRotation(earleft, 0F, 0.2617994F, 0F);
		body = new ModelRenderer(this, 0, 12);
		body.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		body.setRotationPoint(0F, 14F, 0F);
		body.setTextureSize(64, 32);
		setRotation(body, 0F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 21);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 16F, -1.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 8, 21);
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 16F, -1.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		chestribbon = new ModelRenderer(this, 36, 26);
		chestribbon.addBox(-1.5F, -1.1F, -2F, 3, 0, 3);
		chestribbon.setRotationPoint(0F, 16F, -1.5F);
		chestribbon.setTextureSize(64, 32);
		setRotation(chestribbon, 0.7853982F, 0F, 0F);
		rightshoulder = new ModelRenderer(this, 64, 0);
		rightshoulder.addBox(-3F, -1F, -2F, 4, 4, 4);
		rightshoulder.setRotationPoint(-2.5F, 15.5F, 0F);
		rightshoulder.setTextureSize(64, 32);
		setRotation(rightshoulder, 0.0872665F, 0F, 0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 4, 2);
		rightarm.setRotationPoint(-2.5F, 15.5F, 0F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0.0872665F, 0F, -0.0872665F);
		leftshoulder = new ModelRenderer(this, 80, 0);
		leftshoulder.addBox(-1F, -1F, -2F, 4, 4, 4);
		leftshoulder.setRotationPoint(2.5F, 15.5F, 0F);
		leftshoulder.setTextureSize(64, 32);
		setRotation(leftshoulder, 0.0872665F, 0F, -0.0872665F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.addBox(0F, -1F, -1F, 2, 4, 2);
		leftarm.setRotationPoint(2.5F, 15.5F, 0F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0.0872665F, 0F, 0.0872665F);
		stand1 = new ModelRenderer(this, 0, 25);
		stand1.addBox(-1.5F, 6F, -1.5F, 3, 1, 3);
		stand1.setRotationPoint(0F, 14F, 0F);
		stand1.setTextureSize(64, 32);
		setRotation(stand1, 0F, 0F, 0F);
		stand2 = new ModelRenderer(this, 0, 29);
		stand2.addBox(-1F, 7F, -1F, 2, 2, 2);
		stand2.setRotationPoint(0F, 14F, 0F);
		stand2.setTextureSize(64, 32);
		setRotation(stand2, 0F, 0F, 0F);
		stand3 = new ModelRenderer(this, 0, 33);
		stand3.addBox(-2F, 9F, -2F, 4, 1, 4);
		stand3.setRotationPoint(0F, 14F, 0F);
		stand3.setTextureSize(64, 32);
		setRotation(stand3, 0F, 0F, 0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		headaccessory.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		headflower.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		headleaves.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		earright.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		earleft.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightchest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftchest.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		chestribbon.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightshoulder.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftshoulder.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftarm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		stand1.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		stand2.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		stand3.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
