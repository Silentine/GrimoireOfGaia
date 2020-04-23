package gaia.entity;

import gaia.GaiaReference;
import gaia.config.GaiaConfig;
import gaia.entity.types.IDayMob;
import gaia.entity.types.IEnderMob;
import gaia.entity.types.IFlyingMob;
import gaia.entity.types.ISwimmingMob;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractMobHostileEntity extends MonsterEntity implements ISharedMethods {

    private static final DataParameter<Boolean> NEUTRAL = EntityDataManager.<Boolean>createKey(AbstractMobHostileEntity.class, DataSerializers.BOOLEAN);
    private final NearestAttackableTargetGoal<PlayerEntity> attackNearestPlayerGoal = new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true);

    protected AbstractMobHostileEntity(EntityType<? extends MonsterEntity> entityType, World world) {
        super(entityType, world);
        setTargetPlayerTask();
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.giveSpecificTasks();
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    public void setTargetPlayerTask() {
        if (this.world != null && !this.world.isRemote) {
            if((this instanceof IDayMob && GaiaConfig.COMMON.passiveHostileMobs.get())|| isNeutral()) {
                this.targetSelector.removeGoal(this.attackNearestPlayerGoal);
            } else {
                this.targetSelector.addGoal(2, attackNearestPlayerGoal);
            }
        }
    }

    public void setAttackTask() {
        // Here to be overridden
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.getDataManager().register(NEUTRAL, false);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("neutral", isNeutral());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.dataManager.set(NEUTRAL, compound.getBoolean("neutral"));

        if (compound.getBoolean("neutral")) {
            this.setNeutral();
        }

        setTargetPlayerTask();
    }

    public boolean isNeutral() {
        return this.dataManager.get(NEUTRAL);
    }

    public void setNeutral() {
        this.dataManager.set(NEUTRAL, Boolean.valueOf(true));
        this.setTargetPlayerTask();
    }

    public double wanderSpeed() {
        return 1.0D;
    }

    public void giveSpecificTasks() {
        if(this instanceof IEnderMob) {
            if(this instanceof IFlyingMob) {
                this.goalSelector.addGoal(2, new WaterAvoidingRandomFlyingGoal( this, wanderSpeed()));
            } else {
                if(this instanceof ISwimmingMob) {
                    this.goalSelector.addGoal(2, new RandomWalkingGoal(this, wanderSpeed()));
                    this.goalSelector.addGoal(2, new SwimGoal(this));
                } else {
                    this.goalSelector.addGoal(0, new SwimGoal(this));
                    this.goalSelector.addGoal(2, new WaterAvoidingRandomWalkingGoal(this, wanderSpeed()));
                }
            }
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return this instanceof ISwimmingMob;
    }

    @Override
    public boolean canSwim() {
        return super.canSwim() && this instanceof ISwimmingMob;
    }

    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        boolean isInTag = ItemTags.getCollection().getOrCreate(GaiaReference.PREMIUM_MONSTER_FEED_TAG).contains(stack.getItem());
        if (isInTag && !isNeutral()) {
            world.setEntityState(this, (byte) 8);

            if (!player.abilities.isCreativeMode) {
                stack.shrink(1);
            }

            this.setNeutral();
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        setGaiaAttributes();
    }

    public void setGaiaAttributes() {
        int gaiaTier = getGaiaTier();
        switch (gaiaTier) {
            default:
                getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_1);
                getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
                getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_1);
                getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_1);
                getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_1);
            case 2:
                getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_2);
                getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
                getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_2);
                getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_2);
                getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_2);
            case 3:
                getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityAttributes.MAX_HEALTH_3);
                getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityAttributes.FOLLOW_RANGE);
                getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityAttributes.MOVE_SPEED_3);
                getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(EntityAttributes.ATTACK_DAMAGE_3);
                getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(EntityAttributes.RATE_ARMOR_3);
        }
    }

    abstract public int getGaiaTier();

    /*
     * Shared Code
     */
    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (GaiaConfig.COMMON.baseDamage.get()) {
                if (entity instanceof PlayerEntity && GaiaConfig.COMMON.shieldsBlockPiercing.get()) {
                    PlayerEntity player = (PlayerEntity) entity;
                    ItemStack itemstack = player.getActiveItemStack();

                    if (itemstack.getItem() == Items.SHIELD) {
                        return true;
                    }
                }

                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 2, 0));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 7) {
            spawnParticles(ParticleTypes.HAPPY_VILLAGER);
        } else if (id == 8) {
            for (int i = 0; i < 8; ++i) {
                world.addParticle(ParticleTypes.HEART, posX + (double) (rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), posY + 0.5D + (double) (rand.nextFloat() * this.getHeight()), posZ + (double) (rand.nextFloat() * this.getWidth() * 2.0F) - (double) this.getWidth(), 0.0D, 0.0D, 0.0D);
            }
        } else if (id == 9) {
            spawnParticles(ParticleTypes.FLAME);
        } else if (id == 10) {
            spawnParticles(ParticleTypes.WITCH);
        } else if (id == 11) {
            spawnParticles(ParticleTypes.SMOKE);
        } else if (id == 12) {
            spawnParticles(ParticleTypes.EXPLOSION);
        } else {
            super.handleStatusUpdate(id);
        }
    }

    /**
     * Adapted from @VillagerEntity
     */
    @OnlyIn(Dist.CLIENT)
    protected void spawnParticles(IParticleData particleData) {
        for(int i = 0; i < 5; ++i) {
            double lvt_3_1_ = this.rand.nextGaussian() * 0.02D;
            double lvt_5_1_ = this.rand.nextGaussian() * 0.02D;
            double lvt_7_1_ = this.rand.nextGaussian() * 0.02D;
            this.world.addParticle(particleData, this.posX + (double)(this.rand.nextFloat() * this.getWidth() * 2.0F) - (double)this.getWidth(), this.posY + 1.0D + (double)(this.rand.nextFloat() * this.getHeight()), this.posZ + (double)(this.rand.nextFloat() * this.getWidth() * 2.0F) - (double)this.getWidth(), lvt_3_1_, lvt_5_1_, lvt_7_1_);
        }
    }

    /**
     * Adapted from @BeaconTileEntity 's addEffectsToPlayers method
     */
    protected void rangeDebuff(double range, Effect effect, int duration, int amplifier) {
        if (!world.isRemote) {
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB(posX, posY, posZ, posX + 1, posY + 1, posZ + 1)).grow(range);
            List<LivingEntity> moblist = world.getEntitiesWithinAABB(LivingEntity.class, axisalignedbb);

            for (LivingEntity mob : moblist) {
                if (!(mob instanceof MobEntity) && (mob instanceof IMob || mob instanceof PlayerEntity)) {
                    mob.addPotionEffect(new EffectInstance(effect, duration, amplifier, true, true));
                }
            }
        }
    }

    /**
     * Adapted from @EntityCreeper 's spawnLingeringCloud method
     */
    protected void spawnLingeringCloud(LivingEntity sourceMob, Effect potionIn, int durationIn, int amplifierIn) {
        AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(sourceMob.world, posX, posY, posZ);
        areaeffectcloudentity.setOwner(sourceMob);
        areaeffectcloudentity.setRadius(2.5F);
        areaeffectcloudentity.setRadiusOnUse(-0.5F);
        areaeffectcloudentity.setWaitTime(10);
        areaeffectcloudentity.setDuration(areaeffectcloudentity.getDuration() / 2);
        areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float)areaeffectcloudentity.getDuration());

        areaeffectcloudentity.addEffect(new EffectInstance(potionIn, durationIn, amplifierIn));

        world.addEntity(areaeffectcloudentity);
    }

    /**
     * Used to adjust the motionY when a mob is hit.
     */
    public void knockBack(double xRatio, double zRatio, double power) {
        if (rand.nextDouble() >= getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getValue()) {
            isAirBorne = true;
            float f1 = MathHelper.sqrt(xRatio * xRatio + zRatio * zRatio);
            float f2 = 0.4F;
            Vec3d motion = this.getMotion();
            double motionX = motion.getX();
            double motionY = motion.getY();
            double motionZ = motion.getZ();
            motionX /= 2.0D;
            motionY /= 2.0D;
            motionZ /= 2.0D;
            motionX -= xRatio / (double) f1 * (double) f2;
            motionY += (double) f2;
            motionZ -= zRatio / (double) f1 * (double) f2;

            if (motionY > power) {
                motionY = power;
            }

            this.setMotion(motionX, motionY, motionZ);
        }
    }

    /* SPAWN CONDITIONS */
    @Override
    public boolean canSpawn(IWorld worldIn, SpawnReason value) {
        boolean blacklisted = this.isDimensionBlacklisted(world);
        boolean flag = true;

        if(this instanceof IDayMob)
            flag = this.spawnConditions(this);

        if (GaiaConfig.COMMON.spawnDaysPassed.get()) {
            return blacklisted && flag && this.daysPassed(world) && super.canSpawn(world, value);
        } else {
            return blacklisted && flag && super.canSpawn(worldIn, value);
        }
    }

    //Overriding these just to have the proper variable names
    @Override
    protected void dropSpecialItems(DamageSource source, int lootingModifier, boolean wasRecentlyHit) {
        super.dropSpecialItems(source, lootingModifier, wasRecentlyHit);
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData entityLivingData, @Nullable CompoundNBT itemNbt) {
        if (this instanceof IDayMob) {
            if(GaiaConfig.COMMON.passiveHostileMobs.get()) {
                targetSelector.removeGoal(attackNearestPlayerGoal);
            }
        }
        this.setAttackTask();
        return super.onInitialSpawn(worldIn, difficulty, reason, entityLivingData, itemNbt);
    }
}
