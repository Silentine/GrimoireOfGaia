package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaGelatinousSlime extends EntityMobHostileBase {

	private boolean animationPlay;
	private int animationTimer;

	public float squishAmount;
	public float squishFactor;
	public float prevSquishFactor;

	public EntityGaiaGelatinousSlime(World worldIn) {
		super(worldIn);

		setSize(1.75F, 1.75F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;
		isImmuneToFire = true;

		setPathPriority(PathNodeType.WATER, -1.0F);

		animationPlay = false;
		animationTimer = 0;

		this.setCanPickUpLoot(true);
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_0, true));
		tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(1, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1 * 0.5);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);

		getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		Entity entity = source.getImmediateSource();

		if (entity instanceof EntityArrow) {
			world.setEntityState(this, (byte) 8);
			heal(EntityAttributes.MAX_HEALTH_2 * 0.10F);
		}

		return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_2));
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_2);
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
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 20, 0));
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

	public void onUpdate() {
		this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
		this.prevSquishFactor = this.squishFactor;
		super.onUpdate();

		if (ticksExisted % 60 == 0) {
			animationPlay = true;
			animationTimer = 0;
		}

		if (animationPlay) {
			this.squishAmount = -0.10F;

			if (animationTimer != 10) {
				animationTimer += 1;
			} else {
				this.squishAmount = 1.0F;
				animationPlay = false;
			}
		}

		this.alterSquishAmount();
	}

	protected void alterSquishAmount() {
		this.squishAmount *= 0.6F;
	}

	@Override
	public void onLivingUpdate() {
		beaconDebuff(4, MobEffects.SLOWNESS, 100, 1);

		if (getHealth() < EntityAttributes.MAX_HEALTH_2) {
			if (hasItem()) {
				setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);

				world.setEntityState(this, (byte) 8);
				heal(EntityAttributes.MAX_HEALTH_2 * 0.20F);
			}
		}

		super.onLivingUpdate();
	}

	private boolean hasItem() {
		if (!this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onDeath(DamageSource cause) {
		if (!this.world.isRemote) {
			spawnLingeringCloud(this, MobEffects.POISON, 10 * 20, 0);
		}
		super.onDeath(cause);
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SLIME_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SLIME_DEATH;
	}

	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_SKELETON;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				dropItem(Items.SLIME_BALL, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				dropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				switch (rand.nextInt(4)) {
				case 0:
					dropItem(GaiaItems.BOX_GOLD, 1);
				case 1:
					dropItem(GaiaItems.BAG_BOOK, 1);
				case 2:
					dropItem(GaiaItems.SPAWN_SLIME_GIRL, 1);
				case 3:
					dropItem(Item.getItemFromBlock(GaiaBlocks.DOLL_SLIME_GIRL), 1);
				}
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		ItemStack offhand = ItemStack.EMPTY;

		switch (rand.nextInt(3)) {
		case 0:
			offhand = new ItemStack(Items.BOW);
			break;
		case 1:
			offhand = new ItemStack(Items.ARROW);
			break;
		case 2:
			offhand = new ItemStack(Items.STONE_SWORD);
			break;
		}

		setItemStackToSlot(EntityEquipmentSlot.OFFHAND, offhand);

		return ret;
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potioneffectIn);
	}
	/* IMMUNITIES */

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_2;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
