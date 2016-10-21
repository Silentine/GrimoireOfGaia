package gaia.entity.ai;

import gaia.entity.monster.EntityGaiaCreep;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIGaiaCreepSwell extends EntityAIBase {
   EntityGaiaCreep swellingCreep;
   EntityLivingBase CreepAttackTarget;

   public EntityAIGaiaCreepSwell(EntityGaiaCreep par1EntityGaiaCreep) {
      this.swellingCreep = par1EntityGaiaCreep;
      this.setMutexBits(1);
   }

   public boolean shouldExecute() {
      EntityLivingBase entitylivingbase = this.swellingCreep.getAttackTarget();
      return this.swellingCreep.getCreeperState() > 0 || entitylivingbase != null && this.swellingCreep.getDistanceSqToEntity(entitylivingbase) < 9.0D;
   }
   
   

   public void startExecuting() {
      this.swellingCreep.getNavigator().clearPathEntity();
      this.CreepAttackTarget = this.swellingCreep.getAttackTarget();
   }

   public void resetTask() {
      this.CreepAttackTarget = null;
   }

   public void updateTask() {
      if (this.CreepAttackTarget == null) {
         this.swellingCreep.setCreeperState(-1);
      } else if (this.swellingCreep.getDistanceSqToEntity(this.CreepAttackTarget) > 49.0D) {
         this.swellingCreep.setCreeperState(-1);
      } else if (!this.swellingCreep.getEntitySenses().canSee(this.CreepAttackTarget)) {
         this.swellingCreep.setCreeperState(-1);
      } else {
         this.swellingCreep.setCreeperState(1);
      }
   }
}
