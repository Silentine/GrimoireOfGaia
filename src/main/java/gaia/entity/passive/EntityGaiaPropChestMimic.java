package gaia.entity.passive;

import java.util.List;

import javax.annotation.Nullable;

import gaia.entity.monster.EntityGaiaMimic;
import gaia.helpers.LootHelper;
import gaia.init.GaiaEntities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Particles;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumLightType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

//TODO Missing model
public class EntityGaiaPropChestMimic extends EntityAgeable {

	private boolean canSpawn;
	private boolean canSpawnDrop;
	private boolean canDrop;

	public EntityGaiaPropChestMimic(World worldIn) {
		super(GaiaEntities.CHEST, worldIn);
		setSize(0.8F, 0.8F);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;
		canSpawn = false;
		canSpawnDrop = false;
		canDrop = false;
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData entityLivingData, NBTTagCompound itemNbt) {
		renderYawOffset = 180.0F;
		prevRenderYawOffset = 180.0F;
		rotationYaw = 180.0F;
		prevRotationYaw = 180.0F;
		rotationYawHead = 180.0F;
		prevRotationYawHead = 180.0F;

		if (world.rand.nextInt(2) == 0) {
			if (world.rand.nextInt(2) == 0) {
				canSpawn = true;
			} else {
				canSpawnDrop = true;
			}
		} else {
			canDrop = true;
		}

		return super.onInitialSpawn(difficulty, entityLivingData, itemNbt);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void livingTick() {
		if (playerDetection() && canSpawn) {
			attackEntityFrom(DamageSource.GENERIC, 2.0F);
			setSpawn((byte) 0);
		}

		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(Particles.EXPLOSION, posX + (rand.nextDouble() - 0.5D) * (double) width, posY + rand.nextDouble() * (double) height, posZ + (rand.nextDouble() - 0.5D) * (double) width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.livingTick();
		}
	}

	private void setSpawn(byte id) {
		EntityGaiaMimic mimic;

		if (id == 0) {
			mimic = new EntityGaiaMimic(world);
			mimic.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			mimic.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mimic)), null, null);
			world.spawnEntity(mimic);

			canSpawn = false;
			canSpawnDrop = false;
		}
	}

	/**
	 * Detects if there are any EntityPlayer nearby
	 */
	private boolean playerDetection() {
		AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(4);
		List<EntityPlayer> list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);

		return !list.isEmpty();
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		attackEntityFrom(DamageSource.GENERIC, 2.0F);

		return super.processInteract(player, hand);
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_CHEST_OPEN;
	}

	@Override
	protected void dropLoot(boolean wasRecentlyHit, int lootingModifier, DamageSource source) {
		if (canSpawnDrop) {
			setSpawn((byte) 0);
		} else if (canDrop) {
			LootHelper.dropRandomLootAtEntityPos(world, attackingPlayer, this, wasRecentlyHit, LootTableList.CHESTS_SIMPLE_DUNGEON, 2);
		}
	}

	@Override
	protected void onDeathUpdate() {
		remove();
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return false;
	}
	/* IMMUNITIES */

	@Override
	protected void collideWithEntity(Entity entityIn) {
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	/**
	 * @see EntityMob
	 */
	private boolean isValidLightLevel() {
		BlockPos blockpos = new BlockPos(this.posX, this.getBoundingBox().minY, this.posZ);
		if (this.world.getLightFor(EnumLightType.SKY, blockpos) > this.rand.nextInt(32)) {
			return false;
		} else {
			int i = this.world.isThundering() ? this.world.getNeighborAwareLightSubtracted(blockpos, 10) : this.world.getLight(blockpos);
			return i <= this.rand.nextInt(8);
		}
	}

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
	
	@Override
	public boolean canSpawn(IWorld p_205020_1_, boolean p_205020_2_) {
		return posY < 32.0D && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.canSpawn(world, p_205020_2_);
	}
	/* SPAWN CONDITIONS */

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox() {
		return isAlive() ? getBoundingBox() : null;
	}

	@Override
	public int getVerticalFaceSpeed() {
		return 180;
	}

	@Override
	public int getHorizontalFaceSpeed() {
		return 180;
	}

	@Override
	public void applyEntityCollision(Entity entityIn) {
	}

	@Override
	public float getCollisionBorderSize() {
		return 0.0F;
	}

	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}
}
