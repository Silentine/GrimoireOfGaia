package gaia.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import akka.dispatch.CachingConfig.PathEntry;

//Not sure if this will be used anymore. It has been phased out at this point.
/**
 * @see EntityAIAttackMelee
 */
public class EntityAIGaiaAttackMelee extends EntityAIBase {

	World worldObj;
	EntityCreature attacker;
	int attackTick;
	double speedTowardsTarget;
	boolean longMemory;
	PathEntry entityPathEntity;
	Class classTarget;
	private int field_75445_i;
	private int failedPathFindingPenalty;

	public EntityAIGaiaAttackMelee(EntityCreature par1EntityCreature, Class par2Class, double par3, boolean par5) {
		this(par1EntityCreature, par3, par5);
		this.classTarget = par2Class;
	}

	public EntityAIGaiaAttackMelee(EntityCreature creature, double speedIn, boolean useLongMemory) {
		this.attacker = creature;
		this.worldObj = creature.worldObj;
		this.speedTowardsTarget = speedIn;
		this.longMemory = useLongMemory;
		this.setMutexBits(3);
	}

	public boolean shouldExecute() {
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();

		if (entitylivingbase == null) {
			return false;
		} 
		else if (!entitylivingbase.isEntityAlive()) 
		{
			return false;
		} 
		else if (this.classTarget != null && !this.classTarget.isAssignableFrom(entitylivingbase.getClass())) 
		{
			return false;
		} 
		else if (--this.field_75445_i <= 0) 
		{
			//TODO* Temp this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(entitylivingbase);
			this.field_75445_i = 4 + this.attacker.getRNG().nextInt(7);
			return this.entityPathEntity != null;
		} else {
			return true;
		}
	}

	public boolean continueExecuting() {
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
		//isWithinHomeDistance(MathHelper.floor_double(entitylivingbase.posX), MathHelper.floor_double(entitylivingbase.posY), MathHelper.floor_double(entitylivingbase.posZ))));
		return entitylivingbase == null?false:(!entitylivingbase.isEntityAlive()?false:(!this.longMemory?!this.attacker.getNavigator().noPath():this.attacker.isWithinHomeDistanceCurrentPosition()));
	}

	public void startExecuting() {
		//TODO* Temp this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
		this.field_75445_i = 0;
	}

	public void resetTask() {
		this.attacker.getNavigator().clearPathEntity();
	}

	public void updateTask() {
		EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
		this.attacker.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
		if ((this.longMemory || this.attacker.getEntitySenses().canSee(entitylivingbase)) && --this.field_75445_i <= 0) {
			this.field_75445_i = this.failedPathFindingPenalty + 4 + this.attacker.getRNG().nextInt(7);
			this.attacker.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget);
			if (this.attacker.getNavigator().getPath() != null) {
				PathPoint d0 = this.attacker.getNavigator().getPath().getFinalPathPoint();
				float minDistance = this.attacker.width + entitylivingbase.width;
				minDistance *= minDistance;
				if (d0 != null && entitylivingbase.getDistanceSq((double)d0.xCoord, (double)d0.yCoord, (double)d0.zCoord) < (double)minDistance) {
					this.failedPathFindingPenalty = 0;
				} else {
					this.failedPathFindingPenalty += 10;
				}
			} else {
				this.failedPathFindingPenalty += 10;
			}
		}

		this.attackTick = Math.max(this.attackTick - 1, 0);

		double var4 = (double)(this.attacker.width * 2.0F * this.attacker.width * 2.0F + entitylivingbase.width);
		//normally entitylivingbase.boundingBox.minY
		if (this.attacker.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ) <= var4 && this.attackTick <= 0) {
			this.attackTick = 20;
			/** TODO TEMP*
			if (this.attacker.getHeldItem() != null) {
				this.attacker.swingItem();
			}
			 */

			if (this.attackTick <= 0)
			{
				this.attackTick = 20;
				this.attacker.swingArm(EnumHand.MAIN_HAND);
			}
			this.attacker.attackEntityAsMob(entitylivingbase);
		}
	}

	protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_)
	{
		double d0 = this.getAttackReachSqr(p_190102_1_);

		if (p_190102_2_ <= d0 && this.attackTick <= 0)
		{
			this.attackTick = 20;
			this.attacker.swingArm(EnumHand.MAIN_HAND);
			this.attacker.attackEntityAsMob(p_190102_1_);
		}
	}

	protected double getAttackReachSqr(EntityLivingBase attackTarget)
	{
		return (double)(this.attacker.width * 2.0F * this.attacker.width * 2.0F + attackTarget.width);
	}
}
