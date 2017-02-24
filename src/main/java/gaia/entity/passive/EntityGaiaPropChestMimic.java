package gaia.entity.passive;

import gaia.entity.monster.EntityGaiaMimic;
import gaia.init.GaiaItems;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityBodyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import com.google.common.collect.Sets;

/** 
 * @see EntityShulker
 */
public class EntityGaiaPropChestMimic extends EntityAgeable {
	
	private boolean canSpawn;
	private boolean canSpawnDrop;

	private static final Item[] chestDrops = new Item[] { 
		Item.getItemFromBlock(Blocks.TORCH),
		Items.BREAD,
		Items.COAL,
		Items.IRON_INGOT,
		Items.GOLD_INGOT,
		Items.REDSTONE,
		GaiaItems.SpawnTrader,
		GaiaItems.SpawnTame,
		GaiaItems.BagOre,
		GaiaItems.BagRecord
	};

	public EntityGaiaPropChestMimic(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
		this.experienceValue = 0;
		this.prevRenderYawOffset = 180.0F;
		this.renderYawOffset = 180.0F;
		this.canSpawn = false;
		this.canSpawnDrop = false;
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
		}

		return super.onInitialSpawn(difficulty, livingdata);
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
			this.attackEntityFrom(DamageSource.generic, 4.00F);
			this.spawnMob();
			this.canSpawn = false;
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

	 protected SoundEvent getDeathSound() {
		 return SoundEvents.BLOCK_CHEST_OPEN;	
	 }

	 protected void dropFewItems(boolean par1, int par2) {
		 if (this.canSpawnDrop == true) {
			 this.spawnMob();
		 } else if (this.canSpawn == false) {
			 for (int var4 = 0; var4 < 1; ++var4) {
				 Item var6 = chestDrops[this.rand.nextInt(chestDrops.length)];

				 for (int var7 = 0; var7 < 1; ++var7) {
					 this.dropItem(var6, 1);
				 }
			 }
		 }
	 }

	 protected void spawnMob() {
		 EntityGaiaMimic spawnMob;
		 spawnMob = new EntityGaiaMimic(this.worldObj);
		 spawnMob.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
		 spawnMob.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(spawnMob)), (IEntityLivingData)null);
		 this.worldObj.spawnEntityInWorld(spawnMob);
	 }

	 /*TODO Make this entity have a chance to drop dungeon chest loot
    @Nullable
    protected ResourceLocation getLootTable() {
        return (chestDungeon == 1) ? LootTableList.CHESTS_SIMPLE_DUNGEON : null;
    }
	  */

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

	 public int getMaxSpawnedInChunk() {
		 return 1;
	 }

	 public boolean getCanSpawnHere() {
		 return this.posY < 32.0D && this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
	 }

	 public EntityAgeable createChild(EntityAgeable entityageable) {
		 return null;
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

	 class BodyHelper extends EntityBodyHelper {
		 public BodyHelper(EntityLivingBase p_i47062_2_) {
			 super(p_i47062_2_);
		 }

		 /**
		  * Update the Head and Body rendering angles
		  */
		 public void updateRenderAngles() {}
	 }
}
