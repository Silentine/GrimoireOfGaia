package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobAssistBase;
import gaia.entity.GaiaLootTableList;
import gaia.entity.ai.EntityAIGaiaValidateTargetPlayer;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.items.ItemShard;
import gaia.items.ItemShieldProp;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

import javax.annotation.Nullable;


public class EntityGaiaMermaid extends EntityMobAssistBase {
	
	private byte inWaterTimer;

	public EntityGaiaMermaid(World worldIn) {
		super(GaiaEntities.MERMAID, worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;
        setPathPriority(PathNodeType.WATER, 8.0F);
        
		inWaterTimer = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true));
		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		targetTasks.addTask(2, new EntityAIGaiaValidateTargetPlayer(this));
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
		getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_2);
		getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
		getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);
		getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.25D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		if (hasShield()) {
			Entity entity = source.getImmediateSource();
			return !(entity instanceof EntityArrow) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		} else {
			return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		}
	}

	private boolean hasShield() {
		ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

		if (itemstack.getItem() == Items.SHIELD || itemstack.getItem() instanceof ItemShieldProp) {
			return true;
		} else {
			return false;
		}
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
					byte0 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 20;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, byte0 * 20, 2));
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
	public void livingTick() {
		if (!world.isRemote) {
			if (isWet()) {
				if (inWaterTimer <= 100) {
					++inWaterTimer;
				} else {
					world.setEntityState(this, (byte) 8);
					heal(EntityAttributes.MAX_HEALTH_2 * 0.10F);
					addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5 * 20, 0));
					inWaterTimer = 0;
				}
			}
		}

		super.livingTick();
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return GaiaSounds.MERMAID_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return GaiaSounds.MERMAID_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return GaiaSounds.MERMAID_DEATH;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return GaiaLootTableList.ENTITIES_GAIA_MERMAID;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int drop = rand.nextInt(3 + lootingModifier);

			for (int i = 0; i < drop; ++i) {
				entityDropItem(GaiaItems.FOOD_COALFISH, 1);
			}

			if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				entityDropItem(Items.PRISMARINE_SHARD, 1);
			}

			// Nuggets/Fragments
			int dropNugget = rand.nextInt(3) + 1;

			for (int i = 0; i < dropNugget; ++i) {
				entityDropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.COMMON.additionalOre.get()) {
				int dropNuggetAlt = rand.nextInt(3) + 1;

				for (int i = 0; i < dropNuggetAlt; ++i) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
				switch (rand.nextInt(2)) {
				case 0:
					entityDropItem(new ItemStack(GaiaItems.BOX_ORE, 1), 0.0F);
				case 1:
					entityDropItem(GaiaItems.BAG_BOOK, 1);
				}
			}

			// Unique Rare
			if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
				entityDropItem(GaiaItems.BOX_OLD, 1);
			}
		}
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, entityLivingData, itemNbt);

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(GaiaItems.WEAPON_PROP_SWORD_GOLD));
		setEnchantmentBasedOnDifficulty(difficulty);

		ItemStack shield = new ItemStack(GaiaItems.SHIELD_PROP_GOLD, 1);
		setItemStackToSlot(EntityEquipmentSlot.OFFHAND, shield);

		ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
		setItemStackToSlot(EntityEquipmentSlot.FEET, bootsSwimming);
		bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 3);
		return ret;
	}

	/* IMMUNITIES */
	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	@Override
	protected int getFireImmuneTicks() {
		return 10;
	}
	/* IMMUNITIES */

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_UNDERGROUND;
	}

	@Override
	public boolean canSpawn(IWorld worldIn, boolean p_205020_2_) {
		Biome biome = worldIn.getBiome(new BlockPos(this.posX, this.posY, this.posZ));
		if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.WATER)) {
			return this.rand.nextInt(40) == 0 && this.isInWater() && super.canSpawn(worldIn, p_205020_2_);
		} else {
			return this.rand.nextInt(15) == 0 && super.canSpawn(worldIn, p_205020_2_);
		}
	}

	public boolean isInWater() {
		return this.getBoundingBox().minY < (double)(this.world.getSeaLevel() - 5);
	}

//	@Override TODO: Ask what this actually does
//	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
//		return posY < 60.0D && super.canSpawn(world, p_205020_2_);
//	}
	/* SPAWN CONDITIONS */
}
