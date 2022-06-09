package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SludgeGirlModel;
import gaia.entity.SludgeGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class SludgeHairLayer extends RenderLayer<SludgeGirl, SludgeGirlModel> {
	public static final ResourceLocation[] SLUDGE_GIRL_HAIR_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/hair_sludge_girl01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/hair_sludge_girl02.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/hair_sludge_girl03.png")};

	private final SludgeGirlModel model;

	public SludgeHairLayer(RenderLayerParent<SludgeGirl, SludgeGirlModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new SludgeGirlModel(modelSet.bakeLayer(ClientHandler.SLUDGE_GIRL));
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, SludgeGirl sludeGirl, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		Minecraft minecraft = Minecraft.getInstance();
		boolean flag = minecraft.shouldEntityAppearGlowing(sludeGirl) && sludeGirl.isInvisible();
		if (!sludeGirl.isInvisible() || flag) {
			VertexConsumer vertexconsumer;
			if (flag) {
				vertexconsumer = bufferSource.getBuffer(RenderType.outline(this.getTextureLocation(sludeGirl)));
			} else {
				vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(sludeGirl)));
			}

			this.getParentModel().copyPropertiesTo(this.model);
			this.model.prepareMobModel(sludeGirl, limbSwing, limbSwingAmount, partialTicks);
			this.model.setupAnim(sludeGirl, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, LivingEntityRenderer.getOverlayCoords(sludeGirl, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	protected ResourceLocation getTextureLocation(SludgeGirl sludgeGirl) {
		return SLUDGE_GIRL_HAIR_LOCATIONS[sludgeGirl.getVariant()];
	}
}