package gaia.entity.goals;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.player.PlayerEntity;

public class GaiaValidateTargetPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
    public GaiaValidateTargetPlayerGoal(CreatureEntity creature) {
        super(creature, PlayerEntity.class, true);
    }

    @Override
    public boolean shouldExecute() {
        return goalOwner.getAttackTarget() instanceof PlayerEntity && super.shouldExecute();
    }
}
