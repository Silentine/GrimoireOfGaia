package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaSummonWoodenGolem extends EntityMobHostileBase {

	@SuppressWarnings("WeakerAccess") // used in reflection
	public EntityGaiaSummonWoodenGolem(World worldIn) {
		super(worldIn);

		setSize(0.50F, 0.75F);
		experienceValue = 0;
		stepHeight = 1.0F;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		tasks.addTask(2, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((EntityAttributes.MAX_HEALTH_1) * 0.50);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue((EntityAttributes.ATTACK_DAMAGE_1) * 0.50);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public boolean canAttackClass(Class<? extends EntityLivingBase> cls) {
		return super.canAttackClass(cls) && cls != EntityGaiaDryad.class || cls != EntityGaiaSpriggan.class || cls != EntityGaiaWitch.class;
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON || potioneffectIn.getPotion() == MobEffects.INSTANT_DAMAGE ? false : super.isPotionApplicable(potioneffectIn);
	}

	/**
	 * @see EntityWitch
	 */
	protected float applyPotionDamageCalculations(DamageSource source, float damage) {
		damage = super.applyPotionDamageCalculations(source, damage);

		if (source.getTrueSource() == this) {
			damage = 0.0F;
		}

		if (source.isMagicDamage()) {
			damage = (float) ((double) damage * 0.15D);
		}

		return damage;
	}
	/* IMMUNITIES */

	@Override
	public boolean getCanSpawnHere() {
		return posY < 0.0D && super.getCanSpawnHere();
	}
}
