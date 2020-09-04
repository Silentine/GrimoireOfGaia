package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.ISwimmingMob;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaSphinxEntity extends AbstractMobHostileEntity implements ISwimmingMob {

    private int spawnTime;

    public GaiaSphinxEntity(EntityType<? extends GaiaSphinxEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_3;
        stepHeight = 6.0F;

        spawnTime = 0;
    }

    @Override
    public int getGaiaTier() {
        return 3;
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_3, true));
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_3);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == DamageSource.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_3);
        return !(source instanceof IndirectEntityDamageSource) && super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.SLOWNESS, 0);
            effects.put(Effects.MINING_FATIGUE, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        if (!onGround && getMotion().getY() < 0.0D) {
            Vec3d motion = getMotion();
            double motionY = motion.getY();
            motionY *= 0.8D;
            setMotion(motion.x, motionY, motion.z);
        }

        if (getHealth() < EntityAttributes.MAX_HEALTH_3 * 0.75F && getHealth() > EntityAttributes.MAX_HEALTH_3 * 0.25F) {
            if ((spawnTime > 0) && (spawnTime <= 200)) {
                ++spawnTime;
            } else {
                world.setEntityState(this, (byte) 9);

                heal(EntityAttributes.MAX_HEALTH_3 * 0.10F);
                spawnTime = 1;
            }
        }

        if (getHealth() <= 0.0F) {
            for (int i = 0; i < 2; ++i) {
                world.addParticle(ParticleTypes.EXPLOSION, getPosX() + (rand.nextDouble() - 0.5D) * getWidth(), getPosY() + rand.nextDouble() * getHeight(), getPosZ() + (rand.nextDouble() - 0.5D) * getWidth(), 0.0D, 0.0D, 0.0D);
            }
        } else {
            super.livingTick();
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.SPHINX_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.SPHINX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.SPHINX_DEATH;
    }


    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(4) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_SMALL_APPLE_GOLD.get(), 1);
            }

            // Nuggets/Shards
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                ItemShard.dropNugget(this, 2);
            }

            int dropNuggetAlt = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNuggetAlt; ++i) {
                ItemShard.dropNugget(this, 3);
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BOX_DIAMOND.get(), 1);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaBlocks.BUST_SPHINX.get(), 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(GaiaItems.MISC_RING_JUMP.get()), 1);
            }

            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(new ItemStack(GaiaItems.CHEST_TEMPLE.get()), 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        ItemStack bootsSwimming = new ItemStack(Items.LEATHER_BOOTS);
        setItemStackToSlot(EquipmentSlotType.FEET, bootsSwimming);
        bootsSwimming.addEnchantment(Enchantments.DEPTH_STRIDER, 2);

        return entityData;
    }

    @Override
    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
    }

    @Override
    public void setMotionMultiplier(BlockState blockState, Vec3d motion) {
        if (blockState.getBlock() != Blocks.COBWEB) {
            super.setMotionMultiplier(blockState, motion);
        }
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_3;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        if (GaiaConfig.COMMON.spawnLevel3Rain.get()) {
            return canEntitySeeSky(worldIn, this) && world.getWorld().isRaining() && super.canSpawn(worldIn, reason);
        } else {
            return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
        }
    }
}
