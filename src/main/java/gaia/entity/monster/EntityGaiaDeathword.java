package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaStrafe;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaDeathword extends EntityMobHostileBase {

	private static final int DETECTION_RANGE = 6;

	private EntityAIAttackMelee aiMeleeAttack = new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true);
	private EntityAIGaiaStrafe aiStrafe = new EntityAIGaiaStrafe(this, EntityAttributes.ATTACK_SPEED_1, 20, 15.0F);

	private boolean canSpawn;
	private int spawnTimer;
	private int spawnLimit;

	public EntityGaiaDeathword(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		canSpawn = true;
		spawnTimer = 0;
		spawnLimit = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));

		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 5;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 10;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, byte0 * 20, 0));
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
		beaconMonster();

		if (playerDetection(DETECTION_RANGE)) {
			if (spawnLimit <= 3 && canSpawn) {
				if (spawnTimer != 60) {
					spawnTimer += 1;
				}

				if (spawnTimer == 60) {
					world.setEntityState(this, (byte) 9);

					if (!world.isRemote) {
						switch (rand.nextInt(4)) {
						case 0:
							boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this);
							if (!flag) {
								setSpawn((byte) 0);
							} else {
								setSpawn((byte) 1);
							}

							break;
						case 1:
							setSpawn((byte) 1);
							break;
						case 2:
							setSpawn((byte) 2);
							break;
						case 3:
							setSpawn((byte) 3);
							break;
						default:
						}
					}

					spawnTimer = 0;
					spawnLimit += 1;
				}
			}

			if (spawnLimit >= 4 && canSpawn) {
				setAI((byte) 1);

				canSpawn = false;
			}
		}

		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		if (motionX > 0 || motionY > 0 || motionZ > 0) {
			for (int var5 = 0; var5 < 2; ++var5) {
				world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}
		}

		if (isBurning()) {
			addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		super.onLivingUpdate();
	}

	private void setAI(byte id) {
		if (id == 0) {
			tasks.removeTask(aiMeleeAttack);
			tasks.addTask(1, aiStrafe);
		}

		if (id == 1) {
			tasks.removeTask(aiStrafe);
			tasks.addTask(1, aiMeleeAttack);
		}
	}

	private void setSpawn(byte id) {
		EntityCreeper creeper;
		EntitySkeleton skeleton;
		EntitySpider spider;
		EntityZombie zombie;

		if (id == 0) {
			creeper = new EntityCreeper(world);
			creeper.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			creeper.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(creeper)), null);
			world.spawnEntity(creeper);
		}

		if (id == 1) {
			skeleton = new EntitySkeleton(world);
			skeleton.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			skeleton.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(skeleton)), null);
			skeleton.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR, 1, 0));
			skeleton.setDropChance(EntityEquipmentSlot.MAINHAND, 0);
			skeleton.setDropChance(EntityEquipmentSlot.OFFHAND, 0);
			skeleton.setDropChance(EntityEquipmentSlot.FEET, 0);
			skeleton.setDropChance(EntityEquipmentSlot.LEGS, 0);
			skeleton.setDropChance(EntityEquipmentSlot.CHEST, 0);
			skeleton.setDropChance(EntityEquipmentSlot.HEAD, 0);
			world.spawnEntity(skeleton);
		}

		if (id == 2) {
			spider = new EntitySpider(world);
			spider.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			spider.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(spider)), null);
			world.spawnEntity(spider);
		}

		if (id == 3) {
			zombie = new EntityZombie(world);
			zombie.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			zombie.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(zombie)), null);
			zombie.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(GaiaItems.ACCESSORY_HEADGEAR, 1, 0));
			zombie.setDropChance(EntityEquipmentSlot.MAINHAND, 0);
			zombie.setDropChance(EntityEquipmentSlot.OFFHAND, 0);
			zombie.setDropChance(EntityEquipmentSlot.FEET, 0);
			zombie.setDropChance(EntityEquipmentSlot.LEGS, 0);
			zombie.setDropChance(EntityEquipmentSlot.CHEST, 0);
			zombie.setDropChance(EntityEquipmentSlot.HEAD, 0);
			world.spawnEntity(zombie);
		}
	}

	private void setCombatTask() {
		tasks.removeTask(aiMeleeAttack);
		tasks.removeTask(aiStrafe);

		setAI((byte) 1);
	}

	private void beaconMonster() {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(6);
			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (!(mob instanceof EntityPlayer)) {
					mob.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 60 * 20, 1, true, true));
				}
			}
		}
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection(int range) {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.BOOK_HIT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.BOOK_HIT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.BOOK_HIT;
	}
	
	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTables.ENTITIES_GAIA_DEATHWORD;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3) + 1;

			for (int i = 0; i < drop; ++i) {
				dropItem(Items.PAPER, 1);
			}

			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(Items.BOOK, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.IRON_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				entityDropItem(new ItemStack(GaiaItems.BOX, 1, 0), 0.0F);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.BAG_BOOK, 1);
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				dropItem(GaiaItems.WEAPON_BOOK, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		ItemStack weaponCustom = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED, 1);
		weaponCustom.addEnchantment(Enchantments.KNOCKBACK, 1);
		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weaponCustom);

		setCombatTask();

		return ret;
	}

	/* IMMUNITIES */
	@Override
	public void fall(float distance, float damageMultiplier) {
	}
	/* IMMUNITIES */

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);

		setCombatTask();
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY < 16.0D && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
