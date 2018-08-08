package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import gaia.items.ItemShard;
import gaia.renderer.particle.ParticleWarning;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaDhampir extends EntityMobHostileBase {

	private int spawn;
	private int spawnLevel3;
	private int spawnLevel3Chance;

	public EntityGaiaDhampir(World worldIn) {
		super(worldIn);

		experienceValue = EntityAttributes.EXPERIENCE_VALUE_2;
		stepHeight = 1.0F;

		spawn = 1;
		spawnLevel3 = 0;
		spawnLevel3Chance = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_2, true));
		tasks.addTask(2, new EntityAIWander(this, 1.0D));
		tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(3, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
		getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
		getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_2);
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
		getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float modifiedDamage = damage;
		if (modifiedDamage > EntityAttributes.BASE_DEFENSE_2) {
			modifiedDamage = EntityAttributes.BASE_DEFENSE_2;

			if (GaiaConfig.GENERAL.spawnLevel3) {
				spawnLevel3Chance += (int) (GaiaConfig.GENERAL.spawnLevel3Chance * 0.05);
			}
		}

		return super.attackEntityFrom(source, modifiedDamage);
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
		if (getHealth() < EntityAttributes.MAX_HEALTH_2 * 0.25F && getHealth() > 0.0F && spawn == 1) {
			if (GaiaConfig.GENERAL.spawnLevel3) {
				if (spawnLevel3Chance > (int) (GaiaConfig.GENERAL.spawnLevel3Chance * 0.5)) {
					spawnLevel3Chance = (int) (GaiaConfig.GENERAL.spawnLevel3Chance * 0.5);
				}

				if ((rand.nextInt(GaiaConfig.GENERAL.spawnLevel3Chance - spawnLevel3Chance) == 0 || rand.nextInt(1) > 0)) {
					spawnLevel3 = 1;
				}
			}

			spawn = 2;
		}

		if (spawnLevel3 == 1) {
			world.setEntityState(this, (byte) 13);

			attackEntityFrom(DamageSource.GENERIC, EntityAttributes.MAX_HEALTH_2 * 0.01F);
		}

		super.onLivingUpdate();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 13) {
			for (int i = 0; i < 1; ++i) {
				ParticleWarning particleCustom = new ParticleWarning(world,
						posX + rand.nextDouble() * width * 2.0D - width,
						posY + 1.0D + rand.nextDouble() * height,
						posZ + rand.nextDouble() * width * 2.0D - width, 0.0D, 0.0D, 0.0D);
				Minecraft.getMinecraft().effectRenderer.addEffect(particleCustom);
			}
		} else {
			super.handleStatusUpdate(id);
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
			int var3 = rand.nextInt(3 + lootingModifier);

			for (int var4 = 0; var4 < var3; ++var4) {
				dropItem(GaiaItems.MiscSoulFire, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.Drop_Nugget(this, 1);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.Drop_Nugget(this, 5);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(3);
				if (i == 0) {
					dropItem(GaiaItems.BoxGold, 1);
				} else if (i == 1) {
					dropItem(GaiaItems.BagBook, 1);
				} else if (i == 2) {
					dropItem(Item.getItemFromBlock(GaiaBlocks.DOLL_MAID), 1);
				}
			}
		}

		// Boss
		if (spawnLevel3 == 1) {
			spawnLevel3();
		}
	}

	private void spawnLevel3() {
		EntityGaiaVampire vampire = new EntityGaiaVampire(world);
		vampire.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
		vampire.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(vampire)), null);
		world.spawnEntity(vampire);
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
		setEnchantmentBasedOnDifficulty(difficulty);

		return ret;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
}
