package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaVampire extends EntityMobHostileBase {

	private int spawnTime;
	private int spawnTime2;

	@SuppressWarnings("WeakerAccess") //used in reflection
	public EntityGaiaVampire(World worldIn) {
		super(worldIn);

		setSize(1.0F, 2.2F);
		experienceValue = EntityAttributes.experienceValue3;
		stepHeight = 1.0F;
		isImmuneToFire = true;

		spawnTime = 0;
		spawnTime2 = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIRestrictSun(this));
		tasks.addTask(2, new EntityAIFleeSun(this, EntityAttributes.attackSpeed3));
		tasks.addTask(3, new EntityAIAttackMelee(this, EntityAttributes.attackSpeed3, true));
		tasks.addTask(4, new EntityAIWander(this, 1.0D));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
		tasks.addTask(5, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.maxHealth3);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.followrange);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.moveSpeed3);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.attackDamage3);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.rateArmor3);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		return !(source instanceof EntityDamageSourceIndirect) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.baseDefense3));
	}

	@Override
	public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {
		super.knockBack(entityIn, strenght, xRatio, zRatio, EntityAttributes.knockback3);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 20;
				}

				if (byte0 > 0 && getHealth() < EntityAttributes.maxHealth3 * 0.75F) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NAUSEA, byte0 * 20, 0));

					world.setEntityState(this, (byte) 9);

					heal(EntityAttributes.maxHealth3 * 0.10F);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		if (world.isDaytime() && !world.isRemote) {
			float f = getBrightness();

			if (f > 0.5F && rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && world.canSeeSky(getPosition())) {
				world.setEntityState(this, (byte) 13);
				attackEntityFrom(DamageSource.GENERIC, EntityAttributes.maxHealth3 * 0.25F);
			}
		}

		if (getHealth() < EntityAttributes.maxHealth3 * 0.75F && getHealth() > EntityAttributes.maxHealth3 * 0.25F) {
			if ((spawnTime > 0) && (spawnTime <= 200)) {
				++spawnTime;
			} else {
				world.setEntityState(this, (byte) 12);

				if (!world.isRemote) {
					EntityGaiaSummonButler spawnMob = new EntityGaiaSummonButler(world);
					spawnMob.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
					spawnMob.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(spawnMob)), null);
					world.spawnEntity(spawnMob);
				}

				world.setEntityState(this, (byte) 9);

				heal(EntityAttributes.maxHealth3 * 0.10F);

				spawnTime = 1;
			}
		}

		if (!world.isRemote) {
			setBesideClimbableBlock(collidedHorizontally);
		}

		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE,
						posX + (rand.nextDouble() - 0.5D) * width,
						posY + rand.nextDouble() * height,
						posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}

			EntityBat spawnMob2 = new EntityBat(world);
			if (spawnTime2 == 0 && !world.isRemote) {
				spawnTime2 = 1;
			} else if (spawnTime2 == 1 && !world.isRemote) {
				spawnMob2.setLocationAndAngles(posX, posY + 1.0D, posZ, rotationYaw, 0.0F);
				spawnMob2.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(spawnMob2)), null);
				world.spawnEntity(spawnMob2);
				spawnTime2 = 2;
			}
		} else {
			super.onLivingUpdate();
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 12) {
			spawnParticles(EnumParticleTypes.EXPLOSION_NORMAL);
		} else if (id == 13) {
			spawnParticles(EnumParticleTypes.SMOKE_LARGE);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@SideOnly(Side.CLIENT)
	private void spawnParticles(EnumParticleTypes particleType) {
		for (int i = 0; i < 5; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(particleType,
					posX + (rand.nextDouble() * width * 2.0D) - width,
					posY + 1.0D + (rand.nextDouble() * height),
					posZ + (rand.nextDouble() * width * 2.0D) - width, d0, d1, d2);
		}
	}

	// ================= Climber data =================//
	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(CLIMBING, (byte) 0);
	}

	protected PathNavigate getNewNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	@Override
	public boolean isOnLadder() {
		return isBesideClimbableBlock();
	}

	private boolean isBesideClimbableBlock() {
		return (dataManager.get(CLIMBING) & 1) != 0;
	}

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntityGaiaValkyrie.class, DataSerializers.BYTE);

	private void setBesideClimbableBlock(boolean climbing) {
		byte b0 = dataManager.get(CLIMBING);

		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		dataManager.set(CLIMBING, b0);
	}
	// ================================================//

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.aggressive_say;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.aggressive_hurt;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.aggressive_death;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		playSound(Sounds.none, 1.0F, 1.0F);
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FoodSmallAppleGold, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 2);
			}

			int var13 = rand.nextInt(3) + 1;

			for (int var14 = 0; var14 < var13; ++var14) {
				ItemShard.Drop_Nugget(this, 3);
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.rateraredrop) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					dropItem(GaiaItems.BoxDiamond, 1);
				} else if (i == 1) {
					dropItem(Item.getItemFromBlock(GaiaBlocks.BUST_VAMPIRE), 1);

				} else if (i == 2) {
					entityDropItem(new ItemStack(GaiaItems.MiscRing, 1, 3), 0.0F);
				}
			}
		}
	}

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
		//noop
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);

		return ret;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	// ================= Tier Immunities =================//
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		//noop
	}

	@Override
	public void setInWeb() {
		//noop
	}
	// ===================================================//

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
