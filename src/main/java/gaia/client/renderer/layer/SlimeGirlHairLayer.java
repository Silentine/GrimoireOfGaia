package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SlimeGirlModel;
import gaia.entity.trader.SlimeGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class SlimeGirlHairLayer extends RenderLayer<SlimeGirl, SlimeGirlModel> {
	private static final ResourceLocation HAIR_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/slime_girl/hair_slime_girl.png");

	private final EntityModel<SlimeGirl> model;

	public SlimeGirlHairLayer(RenderLayerParent<SlimeGirl, SlimeGirlModel> layerParent, EntityModelSet modelSet) {
		super(layerParent);
		this.model = new SlimeGirlModel(modelSet.bakeLayer(ClientHandler.SLIME_GIRL));
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, SlimeGirl slimeGirl,
					   float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		Minecraft minecraft = Minecraft.getInstance();
		boolean flag = minecraft.shouldEntityAppearGlowing(slimeGirl) && slimeGirl.isInvisible();
		if (!slimeGirl.isInvisible() || flag) {
			VertexConsumer vertexconsumer;
			if (flag) {
				vertexconsumer = bufferSource.getBuffer(RenderType.outline(this.getTextureLocation(slimeGirl)));
			} else {
				vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(slimeGirl)));
			}

			this.getParentModel().copyPropertiesTo(this.model);
			this.model.prepareMobModel(slimeGirl, limbSwing, limbSwingAmount, partialTicks);
			this.model.setupAnim(slimeGirl, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			this.model.renderToBuffer(poseStack, vertexconsumer, packedLightIn,
					LivingEntityRenderer.getOverlayCoords(slimeGirl, 0F), 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	protected ResourceLocation getTextureLocation(SlimeGirl slimeGirl) {
		return HAIR_LOCATION;
	}
}
