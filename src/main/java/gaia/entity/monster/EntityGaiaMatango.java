package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaMatango extends EntityMobHostileDay {

	private static final Item[] matangoDrops = new Item[] { Item.getItemFromBlock(Blocks.RED_MUSHROOM), Item.getItemFromBlock(Blocks.BROWN_MUSHROOM) };

	private int spawnTime;

	public EntityGaiaMatango(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;

		spawnTime = 0;
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

			if (itemstack.getItem() instanceof ItemAxe) {
				input = input * 1.5F;
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
		if (super.attackEntityAsMob(entityIn)) {
			if (entityIn instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (world.getDifficulty() == EnumDifficulty.NORMAL) {
					byte0 = 5;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 10;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.POISON, byte0 * 60, 3));
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

		if (isInWater()) {
			addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 10 * 20, 0));
		}

		if (isWet()) {
			addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 10 * 20, 0));
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

		if (getHealth() < EntityAttributes.MAX_HEALTH_1 * 0.90F && getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.10F) {
			if ((spawnTime > 0) && (spawnTime <= 140)) {
				++spawnTime;
			} else {
				world.setEntityState(this, (byte) 9);

				if (!world.isRemote) {
					SetSpawn((byte) 0);
				}

				world.setEntityState(this, (byte) 8);

				heal(EntityAttributes.MAX_HEALTH_1 * 0.20F);

				spawnTime = 1;
			}
		}

		if (isBurning()) {
			addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 0));
			addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 100, 0));
		}

		super.onLivingUpdate();
	}

	private void SetSpawn(byte id) {
		EntityGaiaSummonSporeling sporeling;

		if (id == 0) {
			sporeling = new EntityGaiaSummonSporeling(world);
			sporeling.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			sporeling.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(sporeling)), null);
			world.spawnEntity(sporeling);
		}
	}

	private void beaconMonster() {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1).grow(2);
			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (mob instanceof EntityGaiaSummonSporeling) {
					mob.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 1, true, true));
				}
			}
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.AGGRESSIVE_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.AGGRESSIVE_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.AGGRESSIVE_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			for (int var4 = 0; var4 < 1; ++var4) {
				Item var6 = matangoDrops[rand.nextInt(matangoDrops.length)];

				for (int var7 = 0; var7 < 1; ++var7) {
					dropItem(var6, 1);
				}
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

	@Override
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		ItemStack weaponCustom = new ItemStack(GaiaItems.WEAPON_PROP_ENCHANTED, 1);
		weaponCustom.addEnchantment(Enchantments.KNOCKBACK, 1);
		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, weaponCustom);

		return ret;
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() != MobEffects.POISON && super.isPotionApplicable(potioneffectIn);
	}
	/* IMMUNITIES */

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
