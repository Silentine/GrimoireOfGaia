package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SphinxModel;
import gaia.client.renderer.layer.AuraLayer;
import gaia.entity.Sphinx;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;

public class SphinxRenderer extends MobRenderer<Sphinx, SphinxModel> {
	public static final ResourceLocation[] SPHINX_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/sphinx/sphinx.png")
	};

	public SphinxRenderer(Context context) {
		super(context, new SphinxModel(context.bakeLayer(ClientHandler.SPHINX)), ClientHandler.largeShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet()));
		this.addLayer(new AuraLayer<>(this, () -> new SphinxModel(context.bakeLayer(ClientHandler.SPHINX))));
	}

	@Override
	protected void scale(Sphinx sphinx, PoseStack poseStack, float partialTicks) {
		poseStack.scale(1.25F, 1.25F, 1.25F);
	}

	@Override
	public ResourceLocation getTextureLocation(Sphinx centaur) {
		return SPHINX_LOCATIONS[centaur.getVariant()];
	}
}
