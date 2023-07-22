package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.MermaidModel;
import gaia.entity.Mermaid;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class MermaidRenderer extends MobRenderer<Mermaid, MermaidModel> {
	public static final ResourceLocation[] MERMAID_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mermaid/mermaid01.png"),
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/mermaid/mermaid02.png")};

	public MermaidRenderer(Context context) {
		super(context, new MermaidModel(context.bakeLayer(ClientHandler.MERMAID)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Mermaid mermaid) {
		return MERMAID_LOCATIONS[mermaid.getVariant()];
	}
}
