package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.BoneKnightModel;
import gaia.entity.BoneKnight;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class BoneKnightRenderer extends MobRenderer<BoneKnight, BoneKnightModel> {
	public static final ResourceLocation[] BONE_KNIGHT_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/bone_knight/bone_knight.png")};

	public BoneKnightRenderer(Context context) {
		super(context, new BoneKnightModel(context.bakeLayer(ClientHandler.BONE_KNIGHT)), ClientHandler.smallShadow);
		this.addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public ResourceLocation getTextureLocation(BoneKnight bone_knight) {
		return BONE_KNIGHT_LOCATIONS[bone_knight.getVariant()];
	}
}
