package gaia.client.state;

import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;

public class GelatinousSlimeRenderState extends ArmedEntityRenderState {
	public int variant;
	public float squish;
	public int size = 1;

	public ItemStackRenderState mainItemRenderState;
}