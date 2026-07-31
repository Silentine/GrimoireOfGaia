package gaia.client.renderer.layer;

import gaia.GrimoireOfGaia;
import gaia.client.model.DwarfModel;
import gaia.client.state.DwarfRenderState;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;

public class DwarfEyeLayer extends EyesLayer<DwarfRenderState, DwarfModel> {
	private static final RenderType DWARF_EYE_EYES = RenderTypes.eyes(GrimoireOfGaia.modLoc("textures/entity/dwarf/eyes_dwarf03.png"));

	public DwarfEyeLayer(RenderLayerParent<DwarfRenderState, DwarfModel> renderLayerParent) {
		super(renderLayerParent);
	}

	public RenderType renderType() {
		return DWARF_EYE_EYES;
	}
}