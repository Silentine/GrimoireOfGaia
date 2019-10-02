package gaia.entity.goals;

import gaia.entity.hostile.GaiaCreepEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class GaiaCreepSwellGoal extends Goal {
    private final GaiaCreepEntity creep;
    private LivingEntity attackTarget;

    public GaiaCreepSwellGoal(GaiaCreepEntity creepIn) {
        this.creep = creepIn;
        this.setMutexFlags(EnumSet.of(Flag.MOVE));
    }

    public boolean shouldExecute() {
        LivingEntity target = this.creep.getAttackTarget();
        return this.creep.getCreeperState() > 0 || target != null && this.creep.getDistanceSq(target) < 9.0D;
    }

    public void startExecuting() {
        this.creep.getNavigator().clearPath();
        this.attackTarget = this.creep.getAttackTarget();
    }

    public void resetTask() {
        this.attackTarget = null;
    }

    public void tick() {
        if (this.attackTarget == null) {
            this.creep.setCreeperState(-1);
        } else if (this.creep.getDistanceSq(this.attackTarget) > 49.0D) {
            this.creep.setCreeperState(-1);
        } else if (!this.creep.getEntitySenses().canSee(this.attackTarget)) {
            this.creep.setCreeperState(-1);
        } else {
            this.creep.setCreeperState(1);
        }
    }
}