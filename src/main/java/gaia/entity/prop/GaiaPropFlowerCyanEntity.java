package gaia.entity.prop;

import com.google.common.collect.Sets;
import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobPropEntity;
import gaia.entity.hostile.GaiaMandragoraEntity;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class GaiaPropFlowerCyanEntity extends AbstractMobPropEntity {

	private int shovelAttack;

	public GaiaPropFlowerCyanEntity(EntityType<? extends GaiaPropFlowerCyanEntity> type, World worldIn) {
		super(type, worldIn);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;

		shovelAttack = 0;
	}

	public GaiaPropFlowerCyanEntity(World worldIn) {
		this(GaiaEntities.CYAN_FLOWER.get(), worldIn);
	}

	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, @Nullable CompoundNBT itemNbt) {
		renderYawOffset = 180.0F;
		prevRenderYawOffset = 180.0F;
		rotationYaw = 180.0F;
		prevRotationYaw = 180.0F;
		rotationYawHead = 180.0F;
		prevRotationYawHead = 180.0F;
		return super.onInitialSpawn(worldIn, difficulty, reason, livingdata, itemNbt);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float input = damage;
		Entity entity = source.getTrueSource();

		if (entity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());

			if (itemstack.getItem() instanceof ShovelItem) {
				input = input * 1.5F;
				shovelAttack += 1;
			}
		}

		return super.attackEntityFrom(source, input);
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
		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.addParticle(ParticleTypes.EXPLOSION, posX + (rand.nextDouble() - 0.5D) * (double) getWidth(), posY + rand.nextDouble() * (double) getHeight(), posZ + (rand.nextDouble() - 0.5D) * (double) getWidth(), 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.livingTick();
		}
	}

	private void setSpawn(byte id) {
		if (id == 0) {
			GaiaMandragoraEntity mandragora = new GaiaMandragoraEntity(world);
			mandragora.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			mandragora.onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(mandragora)), null, null, null);
			mandragora.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.EGG));
			world.addEntity(mandragora);
		}
	}

	protected void playParticleEffect(boolean play) {
		IParticleData data = ParticleTypes.LARGE_SMOKE;

		if (!play) {
			data = ParticleTypes.EXPLOSION;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.addParticle(data, posX + (double) (rand.nextFloat() * getWidth() * 2.0F) - (double) getWidth(), posY + 0.5D + (double) (rand.nextFloat() * getHeight()), posZ + (double) (rand.nextFloat() * getWidth() * 2.0F) - (double) getWidth(), d0, d1, d2);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 7) {
			playParticleEffect(true);
		} else if (id == 6) {
			playParticleEffect(false);
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.BLOCK_GRASS_BREAK;
	}

	@Override
	protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
		if (wasRecentlyHit) {
			if (world.rand.nextInt(4) == 0) {
				world.setEntityState(this, (byte) 7);
				setSpawn((byte) 0);
			} else {
				world.setEntityState(this, (byte) 6);

				switch (rand.nextInt(10)) {
					case 0:
						entityDropItem(new ItemStack(Blocks.DANDELION, 1), 0.0F);
						break;
					case 1:
						entityDropItem(new ItemStack(Blocks.POPPY, 1), 0.0F);
						break;
					case 2:
						entityDropItem(new ItemStack(Blocks.BLUE_ORCHID, 1), 0.0F);
						break;
					case 3:
						entityDropItem(new ItemStack(Blocks.AZURE_BLUET, 1), 0.0F);
						break;
					case 4:
						entityDropItem(new ItemStack(Blocks.ALLIUM, 1), 0.0F);
						break;
					case 5:
						entityDropItem(new ItemStack(Blocks.RED_TULIP, 1), 0.0F);
						break;
					case 6:
						entityDropItem(new ItemStack(Blocks.ORANGE_TULIP, 1), 0.0F);
						break;
					case 7:
						entityDropItem(new ItemStack(Blocks.WHITE_TULIP, 1), 0.0F);
						break;
					case 8:
						entityDropItem(new ItemStack(Blocks.PINK_TULIP, 1), 0.0F);
						break;
					case 9:
					default:
						entityDropItem(new ItemStack(Blocks.OXEYE_DAISY, 1), 0.0F);
						break;
				}
			}
			if (shovelAttack >= 1 && (rand.nextInt(16) == 0)) {
				entityDropItem(GaiaItems.FOOD_MANDRAKE.get(), 1);
			}
		}
	}

	@Override
	protected void onDeathUpdate() {
		remove();
	}

	/* IMMUNITIES */
	@Override
	public boolean isPotionApplicable(EffectInstance potioneffectIn) {
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

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	private static Set<Block> spawnBlocks = Sets.newHashSet(Blocks.GRASS, Blocks.DIRT);

	@Override
	public boolean canSpawn(IWorld worldIn, SpawnReason value) {
		super.canSpawn(worldIn, value);

		if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
			return daysPassed(worldIn.getWorld()) && spawnConditions();
		} else {
			return spawnConditions();
		}
	}

	public boolean spawnConditions() {
		if (world.getWorld().isDaytime()) {
			float f = getBrightness();
			if (f > 0.5F && world.canBlockSeeSky(getPosition())) {
				if (torchCheck(this.world, this.getPosition())) {
					return false;
				} else {
					int i = MathHelper.floor(posX);
					int j = MathHelper.floor(getBoundingBox().minY);
					int k = MathHelper.floor(posZ);
					BlockPos blockpos = new BlockPos(i, j, k);
					Block var1 = world.getBlockState(blockpos.down()).getBlock();

					Set<String> additionalBlocks = new HashSet<String>(GaiaConfig.COMMON.additionalFlowerSpawnBlocks.get());

					boolean defaultFlag = spawnBlocks.contains(var1);
					boolean additionalFlag = !additionalBlocks.isEmpty() && additionalBlocks.contains(var1.getRegistryName().toString());

					return world.getDifficulty() != Difficulty.PEACEFUL && (defaultFlag || additionalFlag) && !world.containsAnyLiquid(getBoundingBox());
				}
			}
		}
		return false;
	}

	private static Set<Block> blackList = Sets.newHashSet(GaiaBlocks.SPAWN_GUARD.get());
	/* SPAWN CONDITIONS */

	@Override
	public void applyEntityCollision(Entity entityIn) {
	}
}
