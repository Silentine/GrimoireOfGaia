package gaia.entity.monster;

import java.util.Random;

import javax.annotation.Nullable;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobHostileDay;
import gaia.entity.ai.EntityAIGaiaLeapAtTarget;
import gaia.init.GaiaItems;
import gaia.init.Sounds;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
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
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

/**
 * DEBUG mob
 * 
 * Disable mob in GaiaEntities and ClientProxy.
 */
@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityDebugMob extends EntityMobHostileDay {

	private EntityAIGaiaLeapAtTarget aiGaiaLeapAtTarget = new EntityAIGaiaLeapAtTarget(this, 0.4F);
	private EntityAIAttackMelee aiMeleeAttack = new EntityDebugMob.AILeapAttack(this);

	private static int manual_clock;
	private boolean debugMode;
	private boolean enableAnimation;

	public EntityDebugMob(World worldIn) {
		super(worldIn);
		experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
		stepHeight = 1.0F;
		/* Timers */
		timer = 20;
		manual_clock = 0;
		/* Server data setup */
		sitting = false;

		/* Set to true when in development environment, otherwise, set to false to execute setDead() */
		debugMode = false;
		enableAnimation = false;
	}

	@Override
	protected void initEntityAI() {
		tasks.addTask(0, new EntityAISwimming(this));
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

	/**
	 * Example Implementations
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();
		// 10 ticks = 1 second
		// 1 meter = 1 block
		// Examples of types of timers that can be used

//		if ((manual_clock > 0) && (manual_clock <= 400)) {
//			++manual_clock;
//		} else {
//			if (!worldObj.isRemote) {
//
//			}
//			manual_clock = 1;
//		}
//		if (clock()) {
//			if (!worldObj.isRemote) {
//
//			}
//		}
//		if (ticksExisted % 120 == 0) {
//			if (!worldObj.isRemote) {
//
//			}
//		}

		/** Testing modifying server and client nbt data **/
		if (clock()) {
			if (sitting == true) {
				if (enableAnimation) {
					// Server data
					sitting = false;
					// Client Data
					setSitting(false);

					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
					setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.BOW));
					getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) EntityAttributes.MOVE_SPEED_1 * 0.9);
					tasks.removeTask(aiGaiaLeapAtTarget);
				}
			} else if (sitting == false) {
				if (enableAnimation) {
					// Server data
					sitting = true;
					// Client Data
					setSitting(true);

					setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
					setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.EMPTY);
					getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) EntityAttributes.MOVE_SPEED_1 * 1.5);
					tasks.addTask(0, aiGaiaLeapAtTarget);
				}
			}
		}
		// Example of generating a custom particle
//		if (!world.isRemote && rand.nextInt(200) == 0) {
//			BlockPos pos = getPosition();
//			ParticleExample newEffect = new ParticleExample(world, pos.getX() + 0.5, pos.getY() + 2.2, pos.getZ() + 0.5, 0, 0.001, 0);
//			Minecraft.getMinecraft().effectRenderer.addEffect(newEffect);
//		}
	}

	/**
	 * Example Methods
	 */
	/**
	 * This method gets called first when a mob dies and wants to drop some loot Normally it would check if there is a LootTable bound to the mob, and drop it If not, it would send it to the hardcoded dropFewItems() method Instead of doing one or the other, I've overriden it an told it to do both so it can drop things from a special LootTable and what else would normally drop
	 */
	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		/**
		 * Our method to drop a single random item from a loot table
		 */
		dropRandomLootFromLootTable(LootTableList.CHESTS_END_CITY_TREASURE, wasRecentlyHit, lootingModifier, source);
		/**
		 * We could setup multiples to work in conjunction via randoms and more control statements Or we could just use the control statements to adjust the chance the mob would attempt to drop something from that pool
		 */

//		if (rand.nextInt(4) == 2)
//			drop_A_Random_Loot_From_LootTable(LootTableList.ENTITIES_BLAZE, wasRecentlyHit, lootingModifier, source);
		/**
		 * Our legacy method to handle our other mob drops
		 */
		dropFewItems(wasRecentlyHit, lootingModifier);
	}

	/**
	 * Our Method to drop a random item from an entire Loot Table
	 */
	public void dropRandomLootFromLootTable(ResourceLocation dungeonLoot, boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		long LootTableSeed = 0;
		int maxCount = 0;
		int currentCount = 0;
		Random Randomize = new Random();
		int roll = 0;
		// Things for Looting enchant calculations
		LootTable loottable = world.getLootTableManager().getLootTableFromLocation(dungeonLoot);
		LootContext.Builder lootcontext$builder = (new LootContext.Builder((WorldServer) world)).withLootedEntity(this).withDamageSource(source);
		if (wasRecentlyHit && attackingPlayer != null) {
			lootcontext$builder = lootcontext$builder.withPlayer(attackingPlayer).withLuck(attackingPlayer.getLuck());
		}
		// Here we count the amount of pools are in the Loot Table Array
		for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L ? rand : new Random(LootTableSeed), lootcontext$builder.build())) {
			maxCount++;
		}
		// Our Roll dependent on the amount of pools we counted
		roll = Randomize.nextInt(maxCount);
		for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L ? rand : new Random(LootTableSeed), lootcontext$builder.build())) {
			// Check if our current iteration matches our roll
			if (currentCount == roll) {
				entityDropItem(itemstack, 0.0F);
			}
			currentCount++; // Incrementing the current Iteration
		}
	}

	/**
	 * Our legacy method for dropping items In the newest versions, this is a fallback
	 **/
	@Override
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		System.out.println("I died!");

//		BlockPos pos3 = getPosition();
//		ParticleExample newEffect3 = new ParticleExample(world, pos3.getX() + 0.5, pos3.getY() + 2.2, pos3.getZ() + 0.5, 0, 0.0025, 0);
//		Minecraft.getMinecraft().effectRenderer.addEffect(newEffect3);

		/**
		 * IDs found @Enchantment.registerEnchantments();
		 */
		ItemStack enchantmentBook = new ItemStack(Items.ENCHANTED_BOOK);
		/**
		 * Special method that gives books a unique NBT they need. Note; avoid using IDs
		 */
		ItemEnchantedBook.addEnchantment(enchantmentBook, new EnchantmentData(Enchantments.KNOCKBACK, 1));
		ItemEnchantedBook.addEnchantment(enchantmentBook, new EnchantmentData(Enchantment.getEnchantmentByID(70), 1));
		enchantmentBook.setStackDisplayName("Mysterious Tome");
		this.entityDropItem(enchantmentBook, 1);

		ItemStack shirt = new ItemStack(Items.LEATHER_CHESTPLATE);
		// Add enchantment
		shirt.addEnchantment(Enchantments.PROTECTION, 1);
		// Add color
		ItemArmor itemArmor = (ItemArmor) shirt.getItem();
		itemArmor.setColor(shirt, 5681460);
		// Add name
		shirt.setStackDisplayName("Dusty Shirt");
		this.entityDropItem(shirt, 1);

		ItemStack rod = new ItemStack(Items.FISHING_ROD);
		rod.addEnchantment(Enchantments.LURE, 1);
		rod.setStackDisplayName("Arctic Fishing Rod");
		this.entityDropItem(rod, 1);

		if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0 || rand.nextInt(1 + lootingModifier) > 0) && rand.nextInt(1) == 0) {
			dropItem(GaiaItems.BOX_IRON, 1);
		}
	}

	/**
	 * Clock to prevent effect being spammed
	 */
	public boolean clock() {
		timer++;
		if (timer > 100) {
			timer = 0;
			return true;
		}
		return false;
	};

	/* SITTING ANIMATION */
	/**
	 * Server Side NBT Data
	 */
	short timer;
	boolean sitting;

	public void readEntityFromNBT(NBTTagCompound tag) {
		super.readEntityFromNBT(tag);
		if (tag.hasKey("Timer")) {
			timer = tag.getShort("Timer");
		}
		if (tag.hasKey("Sitting")) {
			sitting = tag.getBoolean("Sitting");
		}
	}

	public void writeEntityToNBT(NBTTagCompound tag) {
		super.writeEntityToNBT(tag);
		tag.setShort("Timer", timer);
		tag.setBoolean("Sitting", sitting);
	}

	/**
	 * NBT Data that the client can access
	 */
	// Create the client key
	private static final DataParameter<Boolean> SITTING = EntityDataManager.<Boolean>createKey(EntityDebugMob.class, DataSerializers.BOOLEAN);

	// Initialize the client key
	protected void entityInit() {
		super.entityInit();
		dataManager.register(SITTING, Boolean.valueOf(false));
	}

	// Retreive the client data
	public boolean getSitting() {
		return ((Boolean) dataManager.get(SITTING)).booleanValue();
	}

	// Set the client data
	public void setSitting(boolean flag) {
		dataManager.set(SITTING, flag);
	}
	/* SITTING ANIMATION */

	@Override
	protected SoundEvent getAmbientSound() {
		return Sounds.DEBUG_SAY;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return Sounds.DEBUG_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return Sounds.DEBUG_DEATH;
	}

	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ret = super.onInitialSpawn(difficulty, livingdata);

		tasks.addTask(1, aiGaiaLeapAtTarget);
		tasks.addTask(2, aiMeleeAttack);
//		setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SHOVEL));
//		setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.BOW));

		setCustomNameTag("Debug Mob");
		setAlwaysRenderNameTag(true);

		if (!debugMode) {
			System.out.println("Disabled.");
			setDead();
		}

		return ret;
	}

	static class AILeapAttack extends EntityAIAttackMelee {
		AILeapAttack(EntityDebugMob entity) {
			super(entity, EntityAttributes.ATTACK_SPEED_1, true);
		}

		@Override
		protected double getAttackReachSqr(EntityLivingBase attackTarget) {
			return 4.0D + attackTarget.width;
		}
	}

	public boolean getCanSpawnHere() {
		return posY < 0.0D && super.getCanSpawnHere();
	}
}
