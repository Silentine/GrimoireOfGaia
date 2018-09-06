package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.entity.EntityAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaSummonSpider extends EntitySpider {

	@SuppressWarnings("WeakerAccess") // used in reflection
	public EntityGaiaSummonSpider(World worldIn) {
		super(worldIn);

		this.setSize(0.5F, 0.25F);
		experienceValue = 0;
		stepHeight = 1.0F;
	}

	@Override
	protected void initEntityAI() {
		super.initEntityAI();
		this.targetTasks.addTask(2, new EntityGaiaSummonSpider.AISpiderTarget(this, EntityPlayer.class));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				int i = 0;

				if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
					i = 7;
				} else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
					i = 15;
				}

				if (i > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, i * 20, 0));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, i * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	static class AISpiderTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T> {
		public AISpiderTarget(EntityGaiaSummonSpider spider, Class<T> classTarget) {
			super(spider, classTarget, true);
		}

		public boolean shouldExecute() {
			return super.shouldExecute();
		}
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

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		return livingdata;
	}

	public float getEyeHeight() {
		return 0.45F;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY < 0.0D && super.getCanSpawnHere();
	}
}
