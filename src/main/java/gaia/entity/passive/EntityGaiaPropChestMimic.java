package gaia.entity.passive;

import java.util.List;

import javax.annotation.Nullable;

import gaia.entity.monster.EntityGaiaMimic;
import gaia.helpers.LootHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

//TODO Missing model
@SuppressWarnings({ "squid:MaximumInheritanceDepth", "squid:S2160" })
public class EntityGaiaPropChestMimic extends EntityAgeable {

	private boolean canSpawn;
	private boolean canSpawnDrop;
	private boolean canDrop;

	public EntityGaiaPropChestMimic(World worldIn) {
		super(worldIn);
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
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
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

		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0F);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
	}

	@Override
	public boolean isAIDisabled() {
		return false;
	}

	@Override
	public void onLivingUpdate() {
		if (playerDetection() && canSpawn) {
			attackEntityFrom(DamageSource.GENERIC, 2.0F);
			SetSpawn((byte) 0);
		}

		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, posX + (rand.nextDouble() - 0.5D) * (double) width, posY + rand.nextDouble() * (double) height, posZ + (rand.nextDouble() - 0.5D) * (double) width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.onLivingUpdate();
		}
	}

	private void SetSpawn(byte id) {
		EntityGaiaMimic mimic;

		if (id == 0) {
			mimic = new EntityGaiaMimic(world);
			mimic.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			mimic.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mimic)), null);
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
			SetSpawn((byte) 0);
		} else if (canDrop) {
			LootHelper.dropRandomLootAtEntityPos(world, attackingPlayer, this, wasRecentlyHit, LootTableList.CHESTS_SIMPLE_DUNGEON, 2);
		}
	}

	@Override
	protected void onDeathUpdate() {
		setDead();
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
		BlockPos blockpos = new BlockPos(posX, getEntityBoundingBox().minY, posZ);

		if (world.getLightFor(EnumSkyBlock.SKY, blockpos) > rand.nextInt(32)) {
			return false;
		} else {
			int i = world.getLightFromNeighbors(blockpos);

			if (world.isThundering()) {
				int j = world.getSkylightSubtracted();
				world.setSkylightSubtracted(10);
				i = world.getLightFromNeighbors(blockpos);
				world.setSkylightSubtracted(j);
			}

			return i <= rand.nextInt(8);
		}
	}

	/* SPAWN CONDITIONS */
	@Override
	public boolean getCanSpawnHere() {
		return posY < 32.0D && world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.getCanSpawnHere();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
	/* SPAWN CONDITIONS */

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox() {
		return isEntityAlive() ? getEntityBoundingBox() : null;
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
