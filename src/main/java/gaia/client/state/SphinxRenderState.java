package gaia.client.state;

import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;

public class SphinxRenderState extends ArmedEntityRenderState implements PoweredState {
	public int variant;
	public boolean powered;

	@Override
	public boolean isPowered() {
		return powered;
	}
}