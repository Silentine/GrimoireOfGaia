package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobPassiveDay;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaCobbleGolem extends EntityMobPassiveDay {

	private int attackTimer;

	public EntityGaiaCobbleGolem(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
		isImmuneToFire = true;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_0, true));
		tasks.addTask(1, new EntityAIWander(this, 0.5D));
		tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(2, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAIGaiaValidateTargetPlayer(this));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_0);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float input = Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
		Entity entity = source.getTrueSource();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());
			if (itemstack.getItem() instanceof ItemPickaxe) {
				input = input + 5;
			}
		}

		return super.attackEntityFrom(source, input);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		attackTimer = 10;
		world.setEntityState(this, (byte) 4);
		boolean var2 = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) 7 + rand.nextInt(15));
		if (var2) {
			entityIn.motionY += 0.2D;
		}

		playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		return var2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 4) {
			attackTimer = 10;
			playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0F, 1.0F);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return attackTimer;
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (attackTimer > 0) {
			--attackTimer;
		}

		if (motionX * motionX + motionZ * motionZ > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
			int i = MathHelper.floor(posX);
			int j = MathHelper.floor(posY - 0.20000000298023224D);
			int k = MathHelper.floor(posZ);
			IBlockState iblockstate = world.getBlockState(new BlockPos(i, j, k));

			if (iblockstate.getMaterial() != Material.AIR) {
				world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, posX + (rand.nextDouble() - 0.5D) * width, getEntityBoundingBox().minY + 0.1D, posZ + (rand.nextDouble() - 0.5D) * width, 4.0D * (rand.nextDouble() - 0.5D), 0.5D, (rand.nextDouble() - 0.5D) * 4.0D, Block.getStateId(iblockstate));
			}
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.NONE;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.BLOCK_STONE_BREAK;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_IRONGOLEM_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(Items.IRON_NUGGET, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				dropItem(Items.IRON_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0) && rand.nextInt(1) == 0) {
				dropItem(GaiaItems.BOX_IRON, 1);
			}
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

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
