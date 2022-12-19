package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.GelatinousSlimeModel;
import gaia.entity.GelatinousSlime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;

public class GelatinousSlimeLayer extends RenderLayer<GelatinousSlime, GelatinousSlimeModel> {
	private static final ResourceLocation SLIME_LAYER_LOCATION = new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/gelatinous_slime/layer_gelatinous_slime.png");

	private final EntityModel<GelatinousSlime> model;

	public GelatinousSlimeLayer(RenderLayerParent<GelatinousSlime, GelatinousSlimeModel> layerParent, EntityModelSet modelSet) {
		super(layerParent);
		this.model = new SlimeModel<>(modelSet.bakeLayer(ClientHandler.GELATINOUS_SLIME));
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, GelatinousSlime gelatinousSlime,
					   float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		Minecraft minecraft = Minecraft.getInstance();
		boolean flag = minecraft.shouldEntityAppearGlowing(gelatinousSlime) && gelatinousSlime.isInvisible();
		if (!gelatinousSlime.isInvisible() || flag) {
			VertexConsumer vertexconsumer;
			if (flag) {
				vertexconsumer = bufferSource.getBuffer(RenderType.outline(this.getTextureLocation(gelatinousSlime)));
			} else {
				vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(gelatinousSlime)));
			}

			this.getParentModel().copyPropertiesTo(this.model);
			this.model.prepareMobModel(gelatinousSlime, limbSwing, limbSwingAmount, partialTicks);
			this.model.setupAnim(gelatinousSlime, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			this.model.renderToBuffer(poseStack, vertexconsumer, packedLightIn,
					LivingEntityRenderer.getOverlayCoords(gelatinousSlime, 0F), 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Override
	protected ResourceLocation getTextureLocation(GelatinousSlime gelatinousSlime) {
		return SLIME_LAYER_LOCATION;
	}
}
