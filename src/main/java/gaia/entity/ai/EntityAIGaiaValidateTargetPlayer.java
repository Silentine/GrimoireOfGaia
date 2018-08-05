package gaia.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIGaiaValidateTargetPlayer extends EntityAINearestAttackableTarget<EntityPlayer> {
	public EntityAIGaiaValidateTargetPlayer(EntityCreature creature) {
		super(creature, EntityPlayer.class, true);
	}

	@Override
	public boolean shouldExecute() {
		return taskOwner.getAttackTarget() instanceof EntityPlayer && super.shouldExecute();
	}
}
