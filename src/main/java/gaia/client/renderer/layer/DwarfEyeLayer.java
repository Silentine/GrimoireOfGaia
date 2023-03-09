package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import gaia.GrimoireOfGaia;
import gaia.client.model.DwarfModel;
import gaia.entity.Dwarf;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class DwarfEyeLayer extends EyesLayer<Dwarf, DwarfModel> {
	private static final RenderType DWARF_EYE_EYES = RenderType.eyes(new ResourceLocation(GrimoireOfGaia.MOD_ID, "textures/entity/dwarf/eyes_dwarf03.png"));

	public DwarfEyeLayer(RenderLayerParent<Dwarf, DwarfModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn, Dwarf dwarf,
					   float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		super.render(poseStack, bufferSource, packedLightIn, dwarf, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);

	}

	public RenderType renderType() {
		return DWARF_EYE_EYES;
	}
}