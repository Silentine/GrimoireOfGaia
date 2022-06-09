package gaia.entity.goal;

import gaia.entity.Creep;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class CreepSwellGoal extends Goal {
	private final Creep creep;
	@Nullable
	private LivingEntity target;

	public CreepSwellGoal(Creep creep) {
		this.creep = creep;
		this.setFlags(EnumSet.of(Goal.Flag.MOVE));
	}

	public boolean canUse() {
		LivingEntity livingentity = this.creep.getTarget();
		return this.creep.getSwellDir() > 0 || livingentity != null && this.creep.distanceToSqr(livingentity) < 9.0D;
	}

	public void start() {
		this.creep.getNavigation().stop();
		this.target = this.creep.getTarget();
	}

	public void stop() {
		this.target = null;
	}

	public boolean requiresUpdateEveryTick() {
		return true;
	}

	public void tick() {
		if (this.target == null) {
			this.creep.setSwellDir(-1);
		} else if (this.creep.distanceToSqr(this.target) > 49.0D) {
			this.creep.setSwellDir(-1);
		} else if (!this.creep.getSensing().hasLineOfSight(this.target)) {
			this.creep.setSwellDir(-1);
		} else {
			this.creep.setSwellDir(1);
		}
	}
}