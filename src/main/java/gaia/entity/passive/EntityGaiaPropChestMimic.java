package gaia.entity.passive;

import gaia.entity.monster.EntityGaiaMimic;

import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

import com.google.common.collect.Sets;

/** 
 * @see EntityShulker
 */
public class EntityGaiaPropChestMimic extends EntityAgeable {

	private boolean canSpawn;
	private boolean canSpawnDrop;
	private boolean canDrop;

	public EntityGaiaPropChestMimic(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
		this.experienceValue = 0;
		this.prevRenderYawOffset = 180.0F;
		this.renderYawOffset = 180.0F;
		this.canSpawn = false;
		this.canSpawnDrop = false;
		this.canDrop = false;
	}

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		this.renderYawOffset = 180.0F;
		this.prevRenderYawOffset = 180.0F;
		this.rotationYaw = 180.0F;
		this.prevRotationYaw = 180.0F;
		this.rotationYawHead = 180.0F;
		this.prevRotationYawHead = 180.0F;

		if (this.worldObj.rand.nextInt(2) == 0) {
			if (this.worldObj.rand.nextInt(2) == 0) {
				this.canSpawn = true;
			} else {
				this.canSpawnDrop = true;
			}
		} else {
			this.canDrop = true;
		}

		return super.onInitialSpawn(difficulty, livingdata);
	}
	
    protected boolean canTriggerWalking() {
        return false;
    }

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
	}

	public void knockBack(Entity entityIn, float strenght, double xRatio, double zRatio) {}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if (playerDetection(4) && this.canSpawn == true) {
			this.attackEntityFrom(DamageSource.generic, 2.0F);
			this.spawnMob();
		}

		if (this.getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.onLivingUpdate();
		}
	}

	/** 
	 * Detects if there are any EntityPlayer nearby
	 */
	public boolean playerDetection(int range) {	
		double d0 = (double)(range);          

		int k = (int) this.posX;
		int l = (int) this.posY;
		int i1 = (int) this.posZ;
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).expandXyz(d0);
		List<EntityPlayer> list = this.worldObj.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		if (!list.isEmpty()) return true;            

		return false;
	}
	
	public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {
		this.attackEntityFrom(DamageSource.generic, 2.0F);
		return super.processInteract(player, hand, stack);
	}


	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_CHEST_OPEN;	
	}

	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		//this.dropRandomLootFromLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, wasRecentlyHit, lootingModifier, source);
		if (this.canSpawnDrop) {
			this.spawnMob();
		} else if (this.canDrop) {
			for (int var = 0; var < 2; ++var) {
				this.dropRandomLootFromLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, wasRecentlyHit, lootingModifier, source);
			}
		}

		//this.dropFewItems(wasRecentlyHit, lootingModifier);
	}

	/**
	 * @see EntityLiving
	 */
	public void dropRandomLootFromLootTable(ResourceLocation dungeonLoot, boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		long LootTableSeed = 0;
		int maxCount = 0;
		int currentCount = 0;
		Random Randomize = new Random();
		int roll = 0;

		LootTable loottable = this.worldObj.getLootTableManager().getLootTableFromLocation(dungeonLoot);
		LootContext.Builder lootcontext$builder = (new LootContext.Builder((WorldServer)this.worldObj)).withLootedEntity(this).withDamageSource(source);

		if (wasRecentlyHit && this.attackingPlayer != null) {
			lootcontext$builder = lootcontext$builder.withPlayer(this.attackingPlayer).withLuck(this.attackingPlayer.getLuck());
		}

		for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L ? this.rand : new Random(LootTableSeed), lootcontext$builder.build())) {
			maxCount++;
		}

		roll = Randomize.nextInt(maxCount);        

		for (ItemStack itemstack : loottable.generateLootForPools(LootTableSeed == 0L ? this.rand : new Random(LootTableSeed), lootcontext$builder.build())) {
			if (currentCount == roll)this.entityDropItem(itemstack, 0.0F);
			currentCount++;      
		}
	}

	/* Legacy code
	 protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		 if (this.canSpawnDrop) {
			 this.spawnMob();
		 } else if (wasRecentlyHit && this.canSpawn == false) {
			 for (int var4 = 0; var4 < 1; ++var4) {
				 Item var6 = chestDrops[this.rand.nextInt(chestDrops.length)];

				 for (int var7 = 0; var7 < 1; ++var7) {
					 this.dropItem(var6, 1);
				 }
			 }
		 }
	 }
	 */

	/* LootTable
	 @Nullable
	 protected ResourceLocation getLootTable() {
		 return GaiaLootTableList.EMPTY;
	 }
	 */

	protected void spawnMob() {
		EntityGaiaMimic spawnMob;
		spawnMob = new EntityGaiaMimic(this.worldObj);
		spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
		this.worldObj.spawnEntityInWorld(spawnMob);
		this.canSpawn = false;
		this.canSpawnDrop = false;
	}

	protected void onDeathUpdate() {
		this.setDead();
	}

	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return false;
	}

	protected void collideWithEntity(Entity entityIn) {}

	public boolean canBeCollidedWith() {
		return true;
	}

	public boolean canBePushed() {
		return true;
	}

	public boolean allowLeashing() {
		return false;
	}

	//================= Spawn Conditions =================//
	static Set<Block> spawnBlocks = Sets.newHashSet(new Block[] {
			Blocks.STONE,
			Blocks.DIRT
	});

	/** 
	 * @see EntityMob
	 */
	protected boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

		if (this.worldObj.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32)) {
			return false;
		} else {
			int i = this.worldObj.getLightFromNeighbors(blockpos);

			if (this.worldObj.isThundering()) {
				int j = this.worldObj.getSkylightSubtracted();
				this.worldObj.setSkylightSubtracted(10);
				i = this.worldObj.getLightFromNeighbors(blockpos);
				this.worldObj.setSkylightSubtracted(j);
			}

			return i <= this.rand.nextInt(8);
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY < 32.0D && this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
	}
	//==================================//
	
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox() {
		return this.isEntityAlive() ? this.getEntityBoundingBox() : null;
	}

	public int getVerticalFaceSpeed() {
		return 180;
	}

	public int getHorizontalFaceSpeed() {
		return 180;
	}

	public void applyEntityCollision(Entity entityIn) {}

	public float getCollisionBorderSize() {
		return 0.0F;
	}
	
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
