package gaia.entity.prop;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import gaia.GaiaConfig;
import gaia.entity.EntityMobProp;
import gaia.entity.monster.EntityGaiaMandragora;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaPropFlowerCyan extends EntityMobProp {

	private int shovelAttack;

	public EntityGaiaPropFlowerCyan(World worldIn) {
		super(worldIn);
		setSize(0.8F, 0.8F);
		experienceValue = 0;
		prevRenderYawOffset = 180.0F;
		renderYawOffset = 180.0F;

		shovelAttack = 0;
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
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float damage) {
		float input = damage;
		Entity entity = source.getTrueSource();

		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getHeldItem(getActiveHand());

			if (itemstack.getItem() instanceof ItemSpade) {
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
	public void onLivingUpdate() {
		if (getHealth() <= 0.0F) {
			for (int i = 0; i < 2; ++i) {
				world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, posX + (rand.nextDouble() - 0.5D) * (double) width, posY + rand.nextDouble() * (double) height, posZ + (rand.nextDouble() - 0.5D) * (double) width, 0.0D, 0.0D, 0.0D);
			}
		} else {
			super.onLivingUpdate();
		}
	}

	private void setSpawn(byte id) {
		EntityGaiaMandragora mandragora;

		if (id == 0) {
			mandragora = new EntityGaiaMandragora(world);
			mandragora.setLocationAndAngles(posX, posY, posZ, rotationYaw, 0.0F);
			mandragora.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(mandragora)), null);
			mandragora.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.EGG));
			world.spawnEntity(mandragora);
		}
	}

	protected void playParticleEffect(boolean play) {
		EnumParticleTypes enumparticletypes = EnumParticleTypes.SMOKE_LARGE;

		if (!play) {
			enumparticletypes = EnumParticleTypes.EXPLOSION_NORMAL;
		}

		for (int i = 0; i < 7; ++i) {
			double d0 = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(enumparticletypes, posX + (double) (rand.nextFloat() * width * 2.0F) - (double) width, posY + 0.5D + (double) (rand.nextFloat() * height), posZ + (double) (rand.nextFloat() * width * 2.0F) - (double) width, d0, d1, d2);
		}
	}

	@SideOnly(Side.CLIENT)
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
	protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if (wasRecentlyHit) {
			if (world.rand.nextInt(4) == 0) {
				world.setEntityState(this, (byte) 7);
				setSpawn((byte) 0);
			} else {
				world.setEntityState(this, (byte) 6);

				switch (rand.nextInt(10)) {
				case 0:
					dropItem(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), 1);
					break;
				case 1:
					dropItem(Item.getItemFromBlock(Blocks.RED_FLOWER), 1);
					break;
				case 2:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 1), 0.0F);
					break;
				case 3:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 2), 0.0F);
					break;
				case 4:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 3), 0.0F);
					break;
				case 5:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 4), 0.0F);
					break;
				case 6:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 5), 0.0F);
					break;
				case 7:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 6), 0.0F);
					break;
				case 8:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 7), 0.0F);
					break;
				case 9:
				default:
					entityDropItem(new ItemStack(Blocks.RED_FLOWER, 1, 8), 0.0F);
					break;
				}
			}

			if (shovelAttack >= 1 && (rand.nextInt(16) == 0)) {
				dropItem(GaiaItems.FOOD_MANDRAKE, 1);
			}
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

	/* SPAWN CONDITIONS */
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	private static Set<Block> spawnBlocks = Sets.newHashSet(Blocks.GRASS, Blocks.DIRT);

	@Override
	public boolean getCanSpawnHere() {
		super.getCanSpawnHere();

		if (GaiaConfig.SPAWN.spawnDaysPassed) {
			return daysPassed() && spawnConditions();
		} else {
			return spawnConditions();
		}
	}

	public boolean spawnConditions() {
		if (world.isDaytime()) {
			float f = getBrightness();
			if (f > 0.5F && world.canSeeSky(getPosition())) {
				if (torchCheck(this.world, this.getPosition())) {
					return false;
				} else {
					int i = MathHelper.floor(posX);
					int j = MathHelper.floor(getEntityBoundingBox().minY);
					int k = MathHelper.floor(posZ);
					BlockPos blockpos = new BlockPos(i, j, k);
					Block var1 = world.getBlockState(blockpos.down()).getBlock();

					Set<String> additionalBlocks = new HashSet<String>(Arrays.asList(GaiaConfig.SPAWN.additionalFlowerSpawnBlocks));

					boolean defaultFlag = spawnBlocks.contains(var1);
					boolean additionalFlag = !additionalBlocks.isEmpty() && additionalBlocks.contains(var1.getRegistryName().toString());

					return world.getDifficulty() != EnumDifficulty.PEACEFUL && (defaultFlag || additionalFlag) && !world.containsAnyLiquid(getEntityBoundingBox());
				}
			}
		}
		return false;
	}

	private static Set<Block> blackList = Sets.newHashSet(GaiaBlocks.SPAWN_GUARD);

	/**
	 * The actual check. It inputs the radius and feeds it to the sphere shape method. After it gets the block position map it scans every block in that map. Then returns depending if the match triggers.
	 */
	private static boolean torchCheck(World world, BlockPos pos) {
		for (BlockPos location : BlockPos.getAllInBox(pos.add(-8, -8, -8), pos.add(8, 8, 8))) {
			if (blackList.contains(world.getBlockState(location).getBlock())) {
				return true;
			}
		}

		return false;
	}
	/* SPAWN CONDITIONS */

	@Override
	public void applyEntityCollision(Entity entityIn) {
	}
}
