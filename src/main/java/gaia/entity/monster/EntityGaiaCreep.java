package gaia.entity.monster;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaCreepSwell;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings({"squid:MaximumInheritanceDepth", "squid:S2160"})
public class EntityGaiaCreep extends EntityMobHostileBase {

	private static final String EXPLOSION_RADIUS_TAG = "ExplosionRadius";
	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 30;
	private int explosionRadius = 3;

	private static final DataParameter<Integer> STATE = EntityDataManager.createKey(EntityGaiaCreep.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> POWERED = EntityDataManager.createKey(EntityGaiaCreep.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> IGNITED = EntityDataManager.createKey(EntityGaiaCreep.class, DataSerializers.BOOLEAN);

	public EntityGaiaCreep(World worldIn) {
		super(worldIn);

		setSize(0.75F, 0.75F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIGaiaCreepSwell(this));
		tasks.addTask(2, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true));
		tasks.addTask(3, new EntityAIWander(this, 1.0D));
		tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
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
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
		super.fall(distance, damageMultiplier);
		timeSinceIgnited = (int) (timeSinceIgnited + distance * 1.5F);
		if (timeSinceIgnited > fuseTime - 5) {
			timeSinceIgnited = fuseTime - 5;
		}
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(STATE, -1);
		dataManager.register(POWERED, Boolean.FALSE);
		dataManager.register(IGNITED, Boolean.FALSE);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);

		if (dataManager.get(POWERED)) {
			compound.setBoolean("powered", true);
		}

		compound.setShort("Fuse", (short) fuseTime);
		compound.setByte(EXPLOSION_RADIUS_TAG, (byte) explosionRadius);
		compound.setBoolean("ignited", hasIgnited());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		dataManager.set(POWERED, compound.getBoolean("powered"));

		if (compound.hasKey("Fuse", 99)) {
			fuseTime = compound.getShort("Fuse");
		}

		if (compound.hasKey(EXPLOSION_RADIUS_TAG, 99)) {
			explosionRadius = compound.getByte(EXPLOSION_RADIUS_TAG);
		}

		if (compound.getBoolean("ignited")) {
			ignite();
		}
	}

	@Override
	public void onUpdate() {
		if (isEntityAlive()) {
			lastActiveTime = timeSinceIgnited;

			if (hasIgnited()) {
				setCreeperState(1);
			}

			int i = getCreeperState();

			if (i > 0 && timeSinceIgnited == 0) {
				playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 0.5F);
			}

			timeSinceIgnited += i;

			if (timeSinceIgnited < 0) {
				timeSinceIgnited = 0;
			}

			if (timeSinceIgnited >= fuseTime) {
				timeSinceIgnited = fuseTime;
				explode();
			}
		}

		super.onUpdate();
	}

	private boolean hasIgnited() {
		return dataManager.get(IGNITED);
	}

	private void ignite() {
		dataManager.set(IGNITED, true);
	}

	private void explode() {
		if (!world.isRemote) {
			boolean flag = world.getGameRules().getBoolean("mobGriefing");
			float f = getPowered() ? 2.0F : 1.0F;
			dead = true;
			world.createExplosion(this, posX, posY, posZ, explosionRadius * f, flag);
			setDead();
		}
	}

	public int getCreeperState() {
		return dataManager.get(STATE);
	}

	public void setCreeperState(int state) {
		dataManager.set(STATE, state);
	}

	@Override
	public void onLivingUpdate() {
		if (getHealth() <= EntityAttributes.MAX_HEALTH_1 * 0.10F) {
			addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 100, 0));
		}
		super.onLivingUpdate();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_CREEPER_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_CREEPER_DEATH;
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(Items.GUNPOWDER, 1);
			}

			// Nuggets/Fragments
			int var11 = rand.nextInt(3) + 1;

			for (int var12 = 0; var12 < var11; ++var12) {
				ItemShard.dropNugget(this, 0);
			}

			if (GaiaConfig.OPTIONS.additionalOre) {
				int var13 = rand.nextInt(3) + 1;

				for (int var14 = 0; var14 < var13; ++var14) {
					ItemShard.dropNugget(this, 4);
				}
			}

			// Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				int i = rand.nextInt(2);
				if (i == 0) {
					entityDropItem(new ItemStack(GaiaItems.BOX, 1, 0), 0.0F);
				} else if (i == 1) {
					dropItem(Item.getItemFromBlock(GaiaBlocks.DOLL_CREEPER_GIRL), 1);
				}
			}

			// Very Rare
			if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1) > 0)) {
				dropItem(GaiaItems.SPAWN_CREEPER_GIRL, 1);
			}
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		return true;
	}

	public boolean getPowered() {
		return dataManager.get(POWERED);
	}

	@SideOnly(Side.CLIENT)
	public float getCreeperFlashIntensity(float par1) {
		return (lastActiveTime + (timeSinceIgnited - lastActiveTime) * par1) / (fuseTime - 2);
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt lightningBolt) {
		super.onStruckByLightning(lightningBolt);
		dataManager.set(POWERED, true);
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY < 60.0D && posY > 32.0D && super.getCanSpawnHere();
	}
}
