package gaia.entity.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class MobAttackGoal extends MeleeAttackGoal {
	private int raiseArmTicks;

	public MobAttackGoal(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
		super(mob, speedModifier, followingTargetEvenIfNotSeen);
	}

	public void start() {
		super.start();
		this.raiseArmTicks = 0;
	}

	public void stop() {
		super.stop();
		this.mob.setAggressive(false);
	}

	public void tick() {
		super.tick();
		++this.raiseArmTicks;
		if (this.raiseArmTicks >= 5 && this.getTicksUntilNextAttack() < this.getAttackInterval() / 2) {
			this.mob.setAggressive(true);
		} else {
			this.mob.setAggressive(false);
		}
	}
}
