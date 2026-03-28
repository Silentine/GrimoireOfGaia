package gaia.client.state;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class BehenderRenderState extends LivingEntityRenderState implements PoweredState {
	public int variant;
	public boolean powered;

	@Override
	public boolean isPowered() {
		return powered;
	}
}
