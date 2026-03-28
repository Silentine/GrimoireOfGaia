package gaia.client.state;

import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;

public class MinotaurusRenderState extends ArmedEntityRenderState implements PoweredState {
	public int variant;
	public boolean isRiding;
	public boolean isAggressive;
	public boolean powered;

	@Override
	public boolean isPowered() {
		return powered;
	}
}