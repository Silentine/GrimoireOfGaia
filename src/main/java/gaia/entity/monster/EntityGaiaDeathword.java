package gaia.entity.monster;

import java.util.List;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.block.material.Material;
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
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

/**
 * UNDER CONSTRUCTION
 * 
 * Disable mob in GaiaEntities and ClientProxy before release.
 */
@SuppressWarnings("squid:MaximumInheritanceDepth")
public class EntityGaiaDeathword extends EntityMobHostileBase {

	public EntityGaiaDeathword(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true));
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
					byte0 = 10;
				} else if (world.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 20;
				}

				if (byte0 > 0) {
					((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, byte0 * 20, 0));
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

		if (!onGround && motionY < 0.0D) {
			motionY *= 0.8D;
		}

		if (motionX > 0 || motionY > 0 || motionZ > 0) {
			for (int var5 = 0; var5 < 2; ++var5) {
				world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, posX + (rand.nextDouble() - 0.5D) * width, posY + rand.nextDouble() * height, posZ + (rand.nextDouble() - 0.5D) * width, 0.0D, 0.0D, 0.0D);
			}
		}
		super.onLivingUpdate();
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			int var3 = rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				dropItem(GaiaItems.MISC_FUR, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				dropItem(Items.GOLD_NUGGET, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.dropNugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					dropItem(GaiaItems.BOX_GOLD, 1);
				} else if (i == 1) {
					dropItem(GaiaItems.BAG_BOOK, 1);
				} else if (i == 2) {
					dropItem(GaiaItems.WEAPON_BOOK_FREEZING, 1);
				}
			}
		}
	}

	private void beaconMonster() {
		if (!world.isRemote) {
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(6);
			List<EntityLivingBase> moblist = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase mob : moblist) {
				if (!(mob instanceof EntityPlayer)) {
					mob.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 300, 1, true, true));
				}
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

		setCustomNameTag("WIP");
		setAlwaysRenderNameTag(true);

		return ret;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
