package gaia.entity.monster;

import javax.annotation.Nullable;

import gaia.GaiaConfig;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileBase;
import gaia.entity.ai.EntityAIGaiaBreakDoor;
import gaia.init.GaiaItems;
import gaia.items.ItemShard;
import net.minecraft.entity.Entity;
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
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * UNDER CONSTRUCTION
 * 
 * Disable mob in GaiaEntities and ClientProxy before release.
 */
@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaOrc extends EntityMobHostileBase {

	private static final String MOB_TYPE_TAG = "MobType";

	private final EntityAIGaiaBreakDoor breakDoor = new EntityAIGaiaBreakDoor(this);

	private int buffEffect;
	private boolean animationPlay;
	private int animationTimer;

	public EntityGaiaOrc(World worldIn) {
		super(worldIn);

		setSize(0.8F, 2.2F);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
		setCanPickUpLoot(true);

		buffEffect = 0;
		animationPlay = false;
		animationTimer = 0;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(2, new EntityAIAttackMelee(this, EntityAttributes.ATTACK_SPEED_1, true));
		tasks.addTask(3, new EntityAIWander(this, 1.0D));
		tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	/**
	 * Sets or removes EntityAIBreakDoor task
	 */
	public void setBreakDoorsAItask(boolean enabled) {
		((PathNavigateGround) this.getNavigator()).setBreakDoors(enabled);

		if (enabled) {
			this.tasks.addTask(1, this.breakDoor);
		} else {
			this.tasks.removeTask(this.breakDoor);
		}
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
		if (hasShield()) {
			return !(source instanceof EntityDamageSourceIndirect) && super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		} else {
			return super.attackEntityFrom(source, Math.min(damage, EntityAttributes.BASE_DEFENSE_1));
		}
	}

	private boolean hasShield() {
		ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

		if (itemstack.getItem() == Items.SHIELD || itemstack.getItem() == GaiaItems.SHIELD_PROP) {
			return true;
		} else {
			return false;
		}
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
	public void onLivingUpdate() {
		/* BUFF */
		if (getHealth() <= EntityAttributes.MAX_HEALTH_1 * 0.25F && getHealth() > 0.0F && buffEffect == 0) {
			SetEquipment((byte) 2);
			animationPlay = true;

			addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 20 * 60, 0));

			buffEffect = 1;
		}

		if (getHealth() > EntityAttributes.MAX_HEALTH_1 * 0.25F && buffEffect == 1) {
			buffEffect = 0;
			animationPlay = false;
			animationTimer = 0;
		}

		if (animationPlay) {
			if (animationTimer != 30) {
				animationTimer += 1;
			} else {
				SetEquipment((byte) 1);
				animationPlay = false;
			}
		}
		/* BUFF */

		super.onLivingUpdate();
	}

	private void SetEquipment(byte id) {
		if (id == 0) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.EMPTY);
		}

		if (id == 1) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.EGG));
		}

		if (id == 2) {
			setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.STICK));
		}
	}

	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
				dropItem(GaiaItems.FOOD_MEAT, 1);
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

		if (world.rand.nextInt(2) == 0) {
			setTextureType(1);
		}

		switch (rand.nextInt(3)) {
		case 0:
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_AXE));
			setEnchantmentBasedOnDifficulty(difficulty);
			break;
		case 1:
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_AXE));
			setEnchantmentBasedOnDifficulty(difficulty);
			break;
		case 2:
			setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_AXE));
			setEnchantmentBasedOnDifficulty(difficulty);
			break;
		default:
		}

		ItemStack itemstack = getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);

		ItemStack shield = ItemStack.EMPTY;
		ItemStack armor_leggings = ItemStack.EMPTY;
		ItemStack armor_chestplate = ItemStack.EMPTY;

		if (itemstack.getItem() == Items.WOODEN_AXE) {
			armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
		} else if (itemstack.getItem() == Items.STONE_AXE) {
			shield = new ItemStack(GaiaItems.SHIELD_PROP, 1, 0);
			armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
			armor_chestplate = new ItemStack(Items.LEATHER_CHESTPLATE);
		} else if (itemstack.getItem() == Items.IRON_AXE) {
			shield = new ItemStack(GaiaItems.SHIELD_PROP, 1, 1);
			armor_leggings = new ItemStack(Items.LEATHER_LEGGINGS);
			armor_chestplate = new ItemStack(Items.IRON_CHESTPLATE);
		}

		setItemStackToSlot(EntityEquipmentSlot.OFFHAND, shield);
		setItemStackToSlot(EntityEquipmentSlot.LEGS, armor_leggings);
		setItemStackToSlot(EntityEquipmentSlot.CHEST, armor_chestplate);

		setBreakDoorsAItask(true);

		/* WIP */
		setCustomNameTag("WIP");
		setAlwaysRenderNameTag(true);
		/* WIP */
		return ret;
	}

	/* ALTERNATE SKIN */
	private static final DataParameter<Integer> SKIN = EntityDataManager.createKey(EntityGaiaOrc.class, DataSerializers.VARINT);

	@Override
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SKIN, 0);
	}

	public int getTextureType() {
		return dataManager.get(SKIN);
	}

	private void setTextureType(int par1) {
		dataManager.set(SKIN, par1);
	}
	/* ALTERNATE SKIN */

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return EntityAttributes.CHUNK_LIMIT_1;
	}

	@Override
	public boolean getCanSpawnHere() {
		return posY > 60.0D && super.getCanSpawnHere();
	}
	/* SPAWN CONDITIONS */
}
