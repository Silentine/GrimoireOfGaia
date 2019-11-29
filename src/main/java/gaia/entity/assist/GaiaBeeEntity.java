package gaia.entity.assist;

import gaia.config.GaiaConfig;
import gaia.entity.AbstractMobAssistEntity;
import gaia.entity.EntityAttributes;
import gaia.entity.types.IDayMob;
import gaia.init.GaiaEntities;
import gaia.init.GaiaItems;
import gaia.init.GaiaLootTables;
import gaia.init.GaiaSounds;
import gaia.item.ItemShard;
import gaia.util.RangedHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;

public class GaiaBeeEntity extends AbstractMobAssistEntity implements IDayMob, IRangedAttackMob {
    private static final int DETECTION_RANGE = 3;

    private static final DataParameter<Boolean> IS_MOVING = EntityDataManager.<Boolean>createKey(GaiaBeeEntity.class, DataSerializers.BOOLEAN);

    private RangedAttackGoal aiArrowAttack = new RangedAttackGoal(this, EntityAttributes.ATTACK_SPEED_1, 20, 60, 15.0F);
    private LeapAtTargetGoal aiAttackLeapAtTarget = new LeapAtTargetGoal(this, 0.2F);
    private LeapAtTarget aiAttackLeapAtTargetAI = new GaiaBeeEntity.LeapAtTarget(this);

    private int timer;
    private int switchDetect;
    private int switchEquip;

    private boolean animationPlay;
    private int animationTimer;

    public GaiaBeeEntity(EntityType<? extends GaiaBeeEntity> entityType, World world) {
        super(entityType, world);

        experienceValue = EntityAttributes.EXPERIENCE_VALUE_1;
        stepHeight = 1.0F;

        timer = 0;
        switchDetect = 0;
        switchEquip = 0;

        animationPlay = false;
        animationTimer = 0;
    }

    public GaiaBeeEntity(World world) {
        this(GaiaEntities.BEE, world);
    }

    private void setCombatTask() {
        setCombatTask(0);
    }

    private void setCombatTask(int id) {
        switch(id) {
            default:
                if (!isNeutral()) {
                    goalSelector.removeGoal(aiAttackLeapAtTarget);
                    goalSelector.removeGoal(aiAttackLeapAtTargetAI);
                    goalSelector.addGoal(1, aiArrowAttack);

                    setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                    animationPlay = false;
                    animationTimer = 0;
                }
            case 1:
                goalSelector.removeGoal(aiArrowAttack);
                goalSelector.addGoal(1, aiAttackLeapAtTarget);
                goalSelector.addGoal(2, aiAttackLeapAtTargetAI);
        }
    }

    @Override
    protected void registerData() {
        super.registerData();
        getDataManager().register(IS_MOVING, false);
    }

    public boolean isMoving() {
        return (getDataManager().get(IS_MOVING));
    }

    public void setMoving(boolean isMoving) {
        getDataManager().set(IS_MOVING, isMoving);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        setCombatTask();
    }

    @Override
    public int getGaiaTier() {
        return 1;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage) {
        float attackDamage = source == source.OUT_OF_WORLD ? damage : Math.min(damage, EntityAttributes.BASE_DEFENSE_1);
        return super.attackEntityFrom(source, attackDamage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            HashMap<Effect, Integer> effects = new HashMap<>();
            effects.put(Effects.POISON, 0);

            ApplyDebuff(world, entityIn, effects);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        RangedHelper.poison(target, this, distanceFactor);

        setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.ARROW));
        animationPlay = true;
        animationTimer = 0;
    }

    @Override
    public boolean isTameable() {
        return true;
    }

    @Override
    public void livingTick() {
        if (!onGround && getMotion().getY() < 0.0D) {
            Vec3d motion = getMotion();
            double motionY = motion.getY();
            motionY *= 0.8D;
            setMotion(motion.x, motionY, motion.z);
        }

        if (isNeutral()) {
            setCombatTask(1);
            timer = 0;
            switchEquip = 1;
        }

        if (!world.isRemote && (getHealth() >= EntityAttributes.MAX_HEALTH_1)) {
            if (detectMovement() && !isMoving()) {
                setMoving(true);
            }

            if (!detectMovement() && isMoving()) {
                setMoving(false);
            }
        }

        if (playerDetection(this, DETECTION_RANGE)) {
            if (switchDetect == 0) {
                switchDetect = 1;
            }
        } else {
            if (switchDetect == 1) {
                switchDetect = 0;
            }
        }

        if (switchDetect == 1 && switchEquip == 0) {
            if (timer <= 20) {
                ++timer;
            } else {
                setCombatTask(1);
                timer = 0;
                switchEquip = 1;
            }
        }

        if (switchDetect == 0 && switchEquip == 1) {
            if (timer <= 20) {
                ++timer;
            } else {
                setCombatTask((byte) 0);
                timer = 0;
                switchEquip = 0;
            }
        }

        if (animationPlay) {
            if (animationTimer != 20) {
                animationTimer += 1;
            } else {
                setItemStackToSlot(EquipmentSlotType.HEAD, ItemStack.EMPTY);
                animationPlay = false;
            }
        }

        super.livingTick();
    }

    private boolean detectMovement() {
        Vec3d motion = this.getMotion();
        if (motion.getX() * motion.getX() + motion.getZ() * motion.getZ() > 2.500000277905201E-7D) {
            int i = MathHelper.floor(posX);
            int j = MathHelper.floor(posY - 0.20000000298023224D);
            int k = MathHelper.floor(posZ);
            BlockState iblockstate = world.getBlockState(new BlockPos(i, j, k));

            if (iblockstate.getMaterial() != Material.AIR) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
        super.knockBack(xRatio, zRatio, EntityAttributes.KNOCKBACK_1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GaiaSounds.BEE_SAY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return GaiaSounds.BEE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return GaiaSounds.BEE_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        playSound(GaiaSounds.NONE, 1.0F, 1.0F);
    }

    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        if (wasRecentlyHit) {
            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(new ItemStack(Items.BONE_MEAL), 1);
            }

            if ((rand.nextInt(2) == 0 || rand.nextInt(1 + lootingModifier) > 0)) {
                entityDropItem(GaiaItems.FOOD_HONEY, 1);
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
                entityDropItem(GaiaItems.BOX_IRON, 1);
            }
        }
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        setCombatTask();

        return super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);
    }

    @Override
    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        return potioneffectIn.getPotion() == Effects.POISON ? false : super.isPotionApplicable(potioneffectIn);
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return EntityAttributes.CHUNK_LIMIT_1;
    }

    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason reason) {
        return canEntitySeeSky(worldIn, this) && super.canSpawn(worldIn, reason);
    }

    static class LeapAtTarget extends MeleeAttackGoal {
        LeapAtTarget(GaiaBeeEntity entity) {
            super(entity, EntityAttributes.ATTACK_SPEED_1, true);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return 4.0D + attackTarget.getWidth();
        }
    }
}
