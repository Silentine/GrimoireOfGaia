package gaia.entity.hostile;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobHostileEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaBlocks;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class GaiaMandragoraEntity extends AbstractMobHostileEntity implements IDayMob {
    private static final String IS_CHILD_TAG = "IsBaby";
    private static final String IS_SCREAMING_TAG = "IsScreaming";

    private static final DataParameter<Boolean> IS_CHILD = EntityDataManager.<Boolean>createKey(GaiaMandragoraEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> IS_SCREAMING = EntityDataManager.<Boolean>createKey(GaiaMandragoraEntity.class, DataSerializers.BOOLEAN);

    private int shovelAttack;
    private int inWaterTimer;

    public GaiaMandragoraEntity(EntityType<? extends GaiaMandragoraEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        shovelAttack = 0;
        inWaterTimer = 0;
    }

    public GaiaMandragoraEntity(World world) {
        this(GaiaEntities.MANDRAGORA.get(), world);
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public void setAttackTask() {
        goalSelector.addGoal(1, new MeleeAttackGoal(this, EntityAttributes.ATTACK_SPEED_0, true));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_0);
        getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.00D);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float input = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
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
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entityIn;
                int difficultyModifier = 0;
                int difficultyModifier2 = 0;

                if (world.getDifficulty() == Difficulty.NORMAL) {
                    difficultyModifier = 20;
                    difficultyModifier2 = 10;
                } else if (world.getDifficulty() == Difficulty.HARD) {
                    difficultyModifier = 30;
                    difficultyModifier2 = 20;
                }

                if (difficultyModifier > 0) {
                    livingEntity.addPotionEffect(new EffectInstance(Effects.SLOWNESS, difficultyModifier * 20, 3));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, difficultyModifier * 20, 0));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.NAUSEA, difficultyModifier2 * 20, 0));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void livingTick() {
        if (isScreaming()) {
            rangeDebuff(2, Effects.NAUSEA, 100, 0);
        }

        if (!world.isRemote) {
            if (isWet()) {
                if (inWaterTimer <= 100) {
                    ++inWaterTimer;
                } else {
                    world.setEntityState(this, (byte) 8);
                    heal(EntityAttributes.MAX_HEALTH_1 * 0.10F);
                    addPotionEffect(new EffectInstance(Effects.RESISTANCE, 5 * 20, 0));
                    inWaterTimer = 0;
                }
            }
        }

        Vec3d motion = getMotion();
        if (motion.x * motion.x + motion.z * motion.z > 2.500000277905201E-7D && rand.nextInt(5) == 0) {
            int i = MathHelper.floor(posX);
            int j = MathHelper.floor(posY - 0.20000000298023224D);
            int k = MathHelper.floor(posZ);
            BlockState BlockState = world.getBlockState(new BlockPos(i, j, k));

            if (BlockState.getMaterial() != Material.AIR) {
                world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, BlockState), posX + (rand.nextDouble() - 0.5D) * getWidth(), getBoundingBox().minY + 0.1D, posZ + (rand.nextDouble() - 0.5D) * getWidth(), 4.0D * (rand.nextDouble() - 0.5D), 0.5D, (rand.nextDouble() - 0.5D) * 4.0D);
            }
        }

        if (isBurning()) {
            addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 0));
            addPotionEffect(new EffectInstance(Effects.WEAKNESS, 100, 0));
        }

        super.livingTick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.MANDRAGORA_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.MANDRAGORA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.MANDRAGORA_DEATH;
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_ROOT.get(), 1);
            }

            if (shovelAttack >= 4) {
                if ((rand.nextInt(8) == 0)) {
                    entityDropItem(GaiaItems.FOOD_MANDRAKE.get(), 1);
                }
            } else {
                if ((rand.nextInt(16) == 0)) {
                    entityDropItem(GaiaItems.FOOD_MANDRAKE.get(), 1);
                }
            }

            // Nuggets/Fragments
            int dropNugget = rand.nextInt(3) + 1;

            for (int i = 0; i < dropNugget; ++i) {
                entityDropItem(Items.IRON_NUGGET, 1);
            }

            if (GaiaConfig.COMMON.additionalOre.get()) {
                int dropNuggetAlt = rand.nextInt(3) + 1;

                for (int i = 0; i < dropNuggetAlt; ++i) {
                    ItemShard.dropNugget(this, 4);
                }
            }

            // Rare
            if ((rand.nextInt(EntityAttributes.RATE_RARE_DROP) == 0)) {
                entityDropItem(GaiaItems.BOX_IRON.get(), 1);
            }

            // Unique Rare
            if ((rand.nextInt(EntityAttributes.RATE_UNIQUE_RARE_DROP) == 0)) {
                entityDropItem(GaiaBlocks.DECO_GARDEN_GNOME.get(), 1);
            }
        }
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        ILivingEntityData entityData = super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);

        setChild(true);
        setScreaming(true);

        return entityData;
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(IS_CHILD, true);
        this.getDataManager().register(IS_SCREAMING, true);
    }

    public boolean isChild() {
        return (getDataManager().get(IS_CHILD));
    }

    public void setChild(boolean isChild) {
        getDataManager().set(IS_CHILD, isChild);
    }

    public boolean isScreaming() {
        return (getDataManager().get(IS_SCREAMING));
    }

    public void setScreaming(boolean isScreaming) {
        getDataManager().set(IS_SCREAMING, isScreaming);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean(IS_CHILD_TAG, isChild());
        compound.putBoolean(IS_SCREAMING_TAG, isScreaming());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains(IS_CHILD_TAG)) {
            boolean isChild = compound.getBoolean(IS_CHILD_TAG);
            setChild(isChild);
        }

        if (compound.contains(IS_SCREAMING_TAG)) {
            boolean isScreaming = compound.getBoolean(IS_SCREAMING_TAG);
            setScreaming(isScreaming);
        }
    }

    @Override
    public float getEyeHeight(Pose pose) {
        float f;

        ItemStack itemstack = getItemStackFromSlot(EquipmentSlotType.CHEST);

        if (itemstack.isEmpty() || itemstack.getItem() != Items.EGG) {
            f = 1.74F;
        } else {
            f = 1.74F - 0.81F;
        }

        return f;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance instance) {
        return instance.getPotion() == Effects.POISON ? false : super.isPotionApplicable(instance);
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return reason != SpawnReason.NATURAL && super.canSpawn(worldIn, reason);
    }

}
